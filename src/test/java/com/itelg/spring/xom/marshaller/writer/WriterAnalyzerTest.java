package com.itelg.spring.xom.marshaller.writer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.itelg.spring.xom.marshaller.writer.Writer;
import com.itelg.spring.xom.marshaller.writer.WriterAnalyzer;
import com.itelg.spring.xom.marshaller.writer.WriterHolder;

class WriterAnalyzerTest
{
    @Test
    void testAnalyzeStringWriter()
    {
        Writer<?> writer = new StringWriter();
        WriterHolder holder = WriterAnalyzer.analyze(writer);

        Assertions.assertEquals(writer, holder.getWriter());
        Assertions.assertEquals(String.class, holder.getReturnType());
    }

    @Test
    void testAnalyzeIntegerWriter()
    {
        Writer<?> writer = new IntegerWriter();
        WriterHolder holder = WriterAnalyzer.analyze(writer);

        Assertions.assertEquals(writer, holder.getWriter());
        Assertions.assertEquals(Integer.class, holder.getReturnType());
    }
}
