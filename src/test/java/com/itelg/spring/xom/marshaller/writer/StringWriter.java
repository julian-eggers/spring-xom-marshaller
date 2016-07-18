package com.itelg.spring.xom.marshaller.writer;

import com.itelg.spring.xom.marshaller.writer.AbstractWriter;

import nu.xom.Element;

public class StringWriter extends AbstractWriter<String>
{
    @Override
    protected Element doWrite(String string)
    {
        Element rootElement = new Element("string");
        Element valueElement = new Element("value");
        valueElement.appendChild(string);
        rootElement.appendChild(valueElement);

        return rootElement;
    }
}