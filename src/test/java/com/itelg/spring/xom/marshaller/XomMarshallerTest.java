package com.itelg.spring.xom.marshaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;

import com.itelg.spring.xom.marshaller.XomMarshaller;
import com.itelg.spring.xom.marshaller.writer.IntegerWriter;
import com.itelg.spring.xom.marshaller.writer.StringWriter;
import com.itelg.spring.xom.marshaller.writer.Writer;

class XomMarshallerTest
{
    private Marshaller marshaller;

    @BeforeEach
    void init()
    {
        List<Writer<?>> writers = new ArrayList<>();
        writers.add(new StringWriter());
        writers.add(new IntegerWriter());
        marshaller = new XomMarshaller(writers);
    }

    @Test
    void testSupports()
    {
        Assertions.assertTrue(marshaller.supports(String.class));
        Assertions.assertTrue(marshaller.supports(Integer.class));
        Assertions.assertFalse(marshaller.supports(Double.class));
    }

    @Test
    void testMarshallString() throws XmlMappingException, IOException
    {
        OutputStream outputStream = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(outputStream);

        marshaller.marshal("test", result);
        Assertions.assertTrue(outputStream.toString().contains("<string><value>test</value></string>"));
    }

    @Test
    void testMarshallInteger() throws XmlMappingException, IOException
    {
        OutputStream outputStream = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(outputStream);

        marshaller.marshal(Integer.valueOf(12), result);
        Assertions.assertTrue(outputStream.toString().contains("<integer><value>12</value></integer>"));
    }
}