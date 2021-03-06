 /*
 * Light Portal
 *
 * Copyright (c) 2009, Light Portal, Inc or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Light Portal, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 *
 */

package org.light.portal.tags;

import static org.light.portal.util.Constants._CURRENT_LOCALE;
import static org.light.portal.util.Constants._DEFAULT_LOCALE;
import static org.light.portal.util.Constants._PORTAL_INIT_LIST;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.jstl.core.Config;

import org.light.portal.model.PortalTab;
import org.light.portal.model.User;
import org.light.portal.util.LabelBean;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portal.util.PropUtil;

/**
 * 
 * @author Jianmin Liu
 **/
public class PortalPageTag extends PortalBaseTag {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();		
		HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
		User user = getUser(request);
		this.setTheme(this.getVisitedPortal(request));
		
		Locale currentLocale = (Locale) Config.get(pageContext.getSession(),Config.FMT_LOCALE);
		if(currentLocale == null){
			String locale = PropUtil.getString(_DEFAULT_LOCALE);
			if(user != null) 
				locale = user.getLanguage();
			else{
				Cookie[] theCookies =((HttpServletRequest)pageContext.getRequest()).getCookies();
				if (theCookies != null) {
			        for (int i =0; i< theCookies.length; i++) {
			           Cookie aCookie = theCookies[i];
			           if(aCookie.getName().equals(OrganizationThreadLocal.getDefaultUserId())){
						   if(aCookie.getValue() != null) locale =  aCookie.getValue();
						   break;
			           }
			        }
			    }	
			}
			String[] localeParams = locale.split("_");
			if(localeParams.length > 1)
				 currentLocale = new Locale(localeParams[0],localeParams[1]);
			else
				 currentLocale = new Locale(localeParams[0]);
			Config.set(pageContext.getSession(), Config.FMT_LOCALE, currentLocale);	
		}
		pageContext.getSession().setAttribute(_CURRENT_LOCALE,currentLocale.toString());		    
	    try{
	    	List<LabelBean> list = new LinkedList<LabelBean>();
	    	list.add(new LabelBean("portalJSON",this.runCommand(request,response,"pagePortal").toString()));
	    	list.add(new LabelBean("tabsJSON",this.runCommand(request,response,"getPortalTabsByPage").toString()));
	    	PortalTab tab =this.getVisitedPage(request);
	    	List<PortalTab> tabs = this.getPortalService(request).getPortalTabByParent(tab.getId());
	    	if(tabs == null || tabs.size() == 0){
	    		list.add(new LabelBean("page"+tab.getId(),"0"));    			
	    	}
	    	while(tabs != null && tabs.size() > 0){
	    		tab = tabs.get(0);
	    		request.setAttribute("parentId",String.valueOf(tab.getId()));
	    		list.add(new LabelBean("tab"+tab.getId()+"TabsJSON",this.runCommand(request,response,"getPortalTabsByParent").toString()));
    			tabs = this.getPortalService(request).getPortalTabByParent(tab.getId());
			}	    	
	    	request.setAttribute("tabId",String.valueOf(tab.getId()));
	    	list.add(new LabelBean("tab"+tab.getId()+"PortletsJSON",this.runCommand(request,response,"getPortletsByVisitTab").toString()));
	    	request.setAttribute(_PORTAL_INIT_LIST,list);
	    }catch(Exception e){
	    	throw new RuntimeException(e);
	    }
		return SKIP_BODY;
	}
}