package com.itelg.spring.xom.marshaller.configuration;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.itelg.spring.xom.marshaller.XomMarshaller;
import com.itelg.spring.xom.marshaller.configuration.SpringXomMarshallerConfiguration;
import com.itelg.spring.xom.marshaller.writer.IntegerWriter;
import com.itelg.spring.xom.marshaller.writer.Writer;

class SpringXomUnmarshallerConfigurationTest
{
    private SpringXomMarshallerConfiguration configuration = new SpringXomMarshallerConfiguration();

    @Test
    void testXomUnmarshaller()
    {
        Writer<?> writer = new IntegerWriter();
        XomMarshaller xomUnmarshaller = configuration.xomMarshaller(Collections.singletonList(writer));
        Assertions.assertTrue(xomUnmarshaller.supports(Integer.class));
    }
}