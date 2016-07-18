package com.itelg.spring.xom.marshaller.writer;

import org.junit.Assert;
import org.junit.Test;

import com.itelg.spring.xom.marshaller.writer.Writer;
import com.itelg.spring.xom.marshaller.writer.WriterAnalyzer;
import com.itelg.spring.xom.marshaller.writer.WriterHolder;

public class WriterAnalyzerTest
{
    @Test
    public void testAnalyzeStringWriter()
    {
        Writer<?> writer = new StringWriter();
        WriterHolder holder = WriterAnalyzer.analyze(writer);

        Assert.assertEquals(writer, holder.getWriter());
        Assert.assertEquals(String.class, holder.getReturnType());
    }

    @Test
    public void testAnalyzeIntegerWriter()
    {
        Writer<?> writer = new IntegerWriter();
        WriterHolder holder = WriterAnalyzer.analyze(writer);

        Assert.assertEquals(writer, holder.getWriter());
        Assert.assertEquals(Integer.class, holder.getReturnType());
    }
}