package com.itelg.spring.xom.marshaller.writer;

import nu.xom.Element;

public class IntegerWriter extends AbstractWriter<Integer>
{
    @Override
    protected Element doWrite(Integer integer)
    {
        Element rootElement = new Element("integer");
        Element valueElement = new Element("value");
        valueElement.appendChild(integer.toString());
        rootElement.appendChild(valueElement);

        return rootElement;
    }
}