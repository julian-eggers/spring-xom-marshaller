package com.itelg.spring.xom.marshaller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;

import com.itelg.spring.xom.marshaller.writer.Writer;
import com.itelg.spring.xom.marshaller.writer.WriterAnalyzer;
import com.itelg.spring.xom.marshaller.writer.WriterHolder;

import nu.xom.Document;
import nu.xom.Element;

public class XomMarshaller implements Marshaller
{
    private Map<Class<?>, Writer<?>> writers = new HashMap<>();

    public XomMarshaller(List<Writer<?>> writers)
    {
        for (Writer<?> writer : writers)
        {
            WriterHolder holder = WriterAnalyzer.analyze(writer);
            this.writers.put(holder.getReturnType(), holder.getWriter());
        }
    }

    @Override
    public boolean supports(Class<?> clazz)
    {
        return writers.containsKey(clazz);
    }

    @Override
    public void marshal(Object object, Result result) throws IOException, XmlMappingException
    {
        StreamResult streamResult = (StreamResult) result;
        Writer<?> writer = writers.get(object.getClass());
        Element rootElement = writer.write(object);
        IOUtils.write(new Document(rootElement).toXML(), streamResult.getOutputStream(), Charset.defaultCharset());
    }
}