package com.itelg.spring.xom.marshaller.writer;

import nu.xom.Element;

public interface Writer<T>
{
    Element write(Object object);
}