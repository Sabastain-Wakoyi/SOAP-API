package com.snva.soap.config;

import jakarta.servlet.ServletRegistration;
import jakarta.xml.bind.annotation.XmlSchema;
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
public class Config extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>  getmessageDispatcher(ApplicationContext appCtx) {
        MessageDispatcherServlet srvlt = new MessageDispatcherServlet();
        srvlt.setTransformSchemaLocations(true);
        srvlt.setApplicationContext(appCtx);
        return new ServletRegistrationBean<>(srvlt, "/ws/*");
    }


    @Bean(name = "bootcampWsdl")
    public DefaultWsdl11Definition defWSDL(XsdSchema xsdSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BootcampPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://snva.com/ex/soap/xml/bootcamp");
        wsdl11Definition.setSchema(xsdSchema);
        return  wsdl11Definition;
    }

    @Bean
    public XsdSchema getXSD(){
        return new SimpleXsdSchema(new ClassPathResource("bootcamp.xsd"));
    }
}