<%
/**
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
%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<light:subdomain>
<head>			   
	<light:portal/>	    
	<LINK href="<%= request.getContextPath() %>/light/theme<%= (session.getAttribute("browser") != null) ? (String)session.getAttribute("browser") : ""%>/common.css" rel="stylesheet" type="text/css">
	<LINK href="<%= request.getContextPath() %>/light/theme/<%= (session.getAttribute("theme") != null) ? (String)session.getAttribute("theme") : "theme1"%>/theme.css" rel="stylesheet" type="text/css">	    
	<%@ include file="/common/meta.jsp"%>	  
	
	<script language="JavaScript" type="text/javascript" src="cache/main/all<%= org.light.portal.util.PropUtil.getString("js.light.version") %>.js"></script>	
	<!-- 
	<script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/json2.js"></script>
	<script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/prototype.js"></script>
	<script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/rsh.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/template.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/light.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightExt.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightService.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightAjax.js"></script>	    
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightUtil.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortal.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortalCore.js"></script>		      	    	 	    		    					      	    	 	    		    				
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortalHeader.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortalMenu.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortalMenuMain.js"></script>
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortalTab.js"></script>		
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortalFooter.js"></script>		
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightPortlet.js"></script>	
    <script language="JavaScript" src="<%= request.getContextPath() %>/light/scripts/lightWindow.js"></script>		
	 -->
	<title><c:out value="${sessionScope.org.title}"/></title>
</head>
<body>
	<div id="initView">
		<!-- google_ad_section_start -->
  		<light:portlets/>
  		<!-- google_ad_section_end -->  		
  		<!-- google_ad_section_start(weight=ignore) -->   		 
  		<jsp:include page="/WEB-INF/view/initViews.jsp" flush="true"></jsp:include>    		
  		<!-- google_ad_section_end(weight=ignore) -->
  	</div>	
  	<jsp:include page='<%= org.light.portal.util.PropUtil.getString("default.left.bar.page") %>' />
	<jsp:include page='<%= org.light.portal.util.PropUtil.getString("default.right.bar.page") %>' />	   	
</body>
</light:subdomain>
</html>
