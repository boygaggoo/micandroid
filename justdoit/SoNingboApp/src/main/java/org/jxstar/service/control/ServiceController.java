/*
 * ServiceController.java 2009-5-28
 * 
 * Copyright 2008-2011 the original author or authors.
 * Licensed under the Apache License, Version 2.0
 */
package org.jxstar.service.control;

import org.jxstar.control.action.RequestContext;

/**
 * 服务控制器，调用服务处理机。
 *
 * @author TonyTan
 * @version 1.0, 2009-5-28
 */
public interface ServiceController {

	/**
	 * 根据上下文信息调度相应的组件执行。
	 * 
	 * 
	 * @param requestContext - 上下文信息
	 * @return boolean 返回true表示成功; 返回false表示失败.
	 */
	public boolean execute(RequestContext requestContext);
}
