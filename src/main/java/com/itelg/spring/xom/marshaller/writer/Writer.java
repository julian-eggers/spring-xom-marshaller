package com.itelg.spring.xom.marshaller.writer;

import nu.xom.Element;

@SuppressWarnings("unused")
public interface Writer<T>
{
    Element write(Object object);
}
