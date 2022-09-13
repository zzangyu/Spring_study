package com.global.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean"); // bean을 가져왔음
		/* List<String> addressList = bean.getAddressList(); */
		Properties addressList = bean.getAddressList();
		
		for (String key : addressList.stringPropertyNames()) {
			System.out.println(String.format("키:%s, 값:%s", key,addressList.get(key)));
		}
		factory.close();
		
	}
}
