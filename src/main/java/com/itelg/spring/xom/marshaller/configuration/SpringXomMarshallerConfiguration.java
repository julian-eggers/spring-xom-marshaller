package com.itelg.spring.xom.marshaller.configuration;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itelg.spring.xom.marshaller.XomMarshaller;
import com.itelg.spring.xom.marshaller.writer.Writer;

@Configuration
public class SpringXomMarshallerConfiguration
{
    @ConditionalOnMissingBean
    @Bean
    public XomMarshaller xomMarshaller(List<Writer<?>> writers)
    {
        return new XomMarshaller(writers);
    }
}