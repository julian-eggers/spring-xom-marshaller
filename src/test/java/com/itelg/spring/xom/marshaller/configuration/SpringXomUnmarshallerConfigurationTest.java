package com.itelg.spring.xom.marshaller.configuration;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import com.itelg.spring.xom.marshaller.XomMarshaller;
import com.itelg.spring.xom.marshaller.configuration.SpringXomMarshallerConfiguration;
import com.itelg.spring.xom.marshaller.writer.IntegerWriter;
import com.itelg.spring.xom.marshaller.writer.Writer;

public class SpringXomUnmarshallerConfigurationTest
{
    private SpringXomMarshallerConfiguration configuration = new SpringXomMarshallerConfiguration();

    @Test
    public void testXomUnmarshaller()
    {
        Writer<?> writer = new IntegerWriter();
        XomMarshaller xomUnmarshaller = configuration.xomMarshaller(Collections.singletonList(writer));
        Assert.assertTrue(xomUnmarshaller.supports(Integer.class));
    }
}