package com.itelg.spring.xom.marshaller.writer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriterAnalyzer
{
    private static final Pattern returnTypePattern = Pattern.compile(".*<(.*)>");

    private WriterAnalyzer()
    {
    }

    public static WriterHolder analyze(Writer<?> writer)
    {
        WriterHolder holder = new WriterHolder();
        holder.setWriter(writer);
        holder.setReturnType(getReturnType(writer));
        return holder;
    }

    private static Class<?> getReturnType(Writer<?> writer)
    {
        String typeName = writer.getClass().getGenericSuperclass().getTypeName();
        Matcher matcher = returnTypePattern.matcher(typeName);
        matcher.find();

        try
        {
            return Class.forName(matcher.group(1));
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}