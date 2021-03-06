/*
 * ServiceConfigUtilTest.java 2009-10-5
 * 
 * Copyright 2008-2011 the original author or authors.
 * Licensed under the Apache License, Version 2.0
 */
package org.jxstar.service.util;

import java.util.List;
import java.util.Map;


import org.jxstar.service.define.EventDefine;
import org.jxstar.test.AbstractTest;

/**
 * 
 *
 * @author TonyTan
 * @version 1.0, 2009-10-5
 */
public class ServiceConfigUtilTest extends AbstractTest {

	public static void main(String[] args) {
		List<Map<String, String>> ls = EventDefine.getEventModule("fun_event", "copy");
		System.out.println(ls.toString());
		
		/*JsonHandler hand = new JsonHandler();
		String strJson = hand.query("select * from(select fun_base.where_sql, fun_base.from_sql from fun_base where fun_base.fun_id = ?) t", 
			new String[]{"sys_fun_base", "string"}, "default");
		
		System.out.println("strJson=" + strJson);*/
	}
}
