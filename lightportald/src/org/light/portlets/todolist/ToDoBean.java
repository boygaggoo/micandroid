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

package org.light.portlets.todolist;

import org.light.portal.model.Entity;

/**
 * 
 * @author Jianmin Liu
 **/
public class ToDoBean extends Entity {

	private String name;
	private String description;	
	private long userId;
	private int priority;
	private int status;
	
	public ToDoBean(){
		super();
	}
	
	public ToDoBean(String name, String description, long userId, int priority){
		this();
		this.name = name;
		this.description = description;		
		this.userId = userId;
		this.priority = priority;
	}


	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getDescription() {
		return description;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}
	

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
