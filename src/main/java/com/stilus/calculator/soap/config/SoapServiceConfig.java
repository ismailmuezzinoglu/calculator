package com.stilus.calculator.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/service/*");
	}

	@Bean("addservice")
	public DefaultWsdl11Definition addDefinition(XsdSchema calcSchema) {

		DefaultWsdl11Definition wsdl11Definition = generateWsdlDefinition("additionPort", "/service",
				"http://www.stilus.com/calculator/soap/model/add", calcSchema);

		return wsdl11Definition;
	}

	@Bean
	public XsdSchema calcSchema() {
		return new SimpleXsdSchema(new ClassPathResource("addition.xsd"));
	}

	private DefaultWsdl11Definition generateWsdlDefinition(String portTypeName, String locationUri,
			String targetNamespace, XsdSchema schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

		wsdl11Definition.setPortTypeName(portTypeName);
		wsdl11Definition.setLocationUri(locationUri);
		wsdl11Definition.setTargetNamespace(targetNamespace);
		wsdl11Definition.setSchema(schema);

		return wsdl11Definition;
	}

}
