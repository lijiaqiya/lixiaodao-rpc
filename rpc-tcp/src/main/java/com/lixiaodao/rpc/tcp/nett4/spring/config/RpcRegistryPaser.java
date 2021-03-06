package com.lixiaodao.rpc.tcp.nett4.spring.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.lixiaodao.rpc.tcp.nett4.spring.config.support.RpcReference;
import com.lixiaodao.rpc.tcp.nett4.spring.config.support.RpcRegistry;

public class RpcRegistryPaser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		String id = element.getAttribute("id");
		String port = element.getAttribute("port");
		String procotolType = element.getAttribute("procotolType");
		String codecType = element.getAttribute("codecType");
		String group = element.getAttribute("group");
		String threadCount = element.getAttribute("threadCount");

		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClass(RpcRegistry.class);
		beanDefinition.setLazyInit(false);
		
		beanDefinition.getPropertyValues().addPropertyValue("port", Integer.parseInt(port));
		beanDefinition.getPropertyValues().addPropertyValue("procotolType", Integer.parseInt(procotolType));
		beanDefinition.getPropertyValues().addPropertyValue("codecType", Integer.parseInt(codecType));
		beanDefinition.getPropertyValues().addPropertyValue("group", group);
		beanDefinition.getPropertyValues().addPropertyValue("threadCount", Integer.parseInt(threadCount));

		parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
		return beanDefinition;
	}

}
