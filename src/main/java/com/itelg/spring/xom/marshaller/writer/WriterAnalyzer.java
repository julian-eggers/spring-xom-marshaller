package com.itelg.spring.xom.marshaller.writer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class WriterAnalyzer
{
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
        Type genericSuperclass = writer.getClass().getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType parameterizedType
                && parameterizedType.getActualTypeArguments()[0] instanceof Class<?> returnType)
        {
            return returnType;
        }

        throw new IllegalArgumentException("Invalid writer-implementation!");
    }
}
