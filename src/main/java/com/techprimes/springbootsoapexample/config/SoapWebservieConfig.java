package com.techprimes.springbootsoapexample.config;

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
public class SoapWebservieConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatucherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soapWS/*");
	}
	
	@Bean
	public XsdSchema userSchema() {
		return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
	}
	
	@Bean
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {
		DefaultWsdl11Definition defaultWsdl11Definition=new DefaultWsdl11Definition();
		defaultWsdl11Definition.setSchema(userSchema);
		defaultWsdl11Definition.setLocationUri("/soapWS");
		defaultWsdl11Definition.setPortTypeName("userServicePort");
		defaultWsdl11Definition.setTargetNamespace("http://www.example.org/spring-boot-soap-example");
		return defaultWsdl11Definition;
	}
	
}
