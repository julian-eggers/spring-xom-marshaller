package com.itelg.spring.xom.marshaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;

import com.itelg.spring.xom.marshaller.XomMarshaller;
import com.itelg.spring.xom.marshaller.writer.IntegerWriter;
import com.itelg.spring.xom.marshaller.writer.StringWriter;
import com.itelg.spring.xom.marshaller.writer.Writer;

public class XomMarshallerTest
{
    private Marshaller marshaller;

    @Before
    public void init()
    {
        List<Writer<?>> writers = new ArrayList<>();
        writers.add(new StringWriter());
        writers.add(new IntegerWriter());
        marshaller = new XomMarshaller(writers);
    }

    @Test
    public void testSupports()
    {
        Assert.assertTrue(marshaller.supports(String.class));
        Assert.assertTrue(marshaller.supports(Integer.class));
        Assert.assertFalse(marshaller.supports(Double.class));
    }

    @Test
    public void testMarshallString() throws XmlMappingException, IOException
    {
        OutputStream outputStream = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(outputStream);

        marshaller.marshal("test", result);
        Assert.assertTrue(outputStream.toString().contains("<string><value>test</value></string>"));
    }

    @Test
    public void testMarshallInteger() throws XmlMappingException, IOException
    {
        OutputStream outputStream = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(outputStream);

        marshaller.marshal(Integer.valueOf(12), result);
        Assert.assertTrue(outputStream.toString().contains("<integer><value>12</value></integer>"));
    }
}