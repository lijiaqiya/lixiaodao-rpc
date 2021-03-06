package com.lixiaodao.rpc.tcp.nett4.spring.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.lixiaodao.rpc.tcp.nett4.spring.config.support.RpcReference;

public class RpcReferenceParser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		String interfacename = element.getAttribute("interfacename");
		String id = element.getAttribute("id");
		String group=element.getAttribute("group");
		int procotolType=Integer.parseInt(element.getAttribute("procotolType"));
		int codecType=Integer.parseInt(element.getAttribute("codecType"));
		int timeout=Integer.parseInt(element.getAttribute("timeout"));
		
		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClass(RpcReference.class);
		beanDefinition.setLazyInit(false);
		
		beanDefinition.getPropertyValues().addPropertyValue("interfacename", interfacename);
        beanDefinition.getPropertyValues().addPropertyValue("group", group);
        beanDefinition.getPropertyValues().addPropertyValue("protocolType", procotolType);
        beanDefinition.getPropertyValues().addPropertyValue("codecType", codecType);
        beanDefinition.getPropertyValues().addPropertyValue("timeout", timeout);
        
        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
		return beanDefinition;
	}

}
