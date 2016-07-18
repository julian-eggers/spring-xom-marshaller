package com.itelg.spring.xom.marshaller.writer;

import nu.xom.Element;

public abstract class AbstractWriter<T> implements Writer<T>
{
    @SuppressWarnings("unchecked")
    @Override
    public Element write(Object object)
    {
        return doWrite((T) object);
    }

    protected abstract Element doWrite(T object);
}