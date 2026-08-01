package com.itelg.spring.xom.marshaller.writer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WriterHolder
{
    private Writer<?> writer;
    private Class<?> returnType;
}
