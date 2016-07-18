package com.itelg.spring.xom.marshaller.writer;

public class WriterHolder
{
    private Writer<?> writer;
    private Class<?> returnType;

    public Writer<?> getWriter()
    {
        return writer;
    }

    public void setWriter(Writer<?> writer)
    {
        this.writer = writer;
    }

    public Class<?> getReturnType()
    {
        return returnType;
    }

    public void setReturnType(Class<?> returnType)
    {
        this.returnType = returnType;
    }
}