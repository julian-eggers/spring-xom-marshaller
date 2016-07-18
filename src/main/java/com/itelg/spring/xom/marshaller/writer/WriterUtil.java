package com.itelg.spring.xom.marshaller.writer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import nu.xom.Attribute;
import nu.xom.Element;

public class WriterUtil
{
    private static final DateTimeFormatter format = DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.systemDefault());

    private WriterUtil()
    {

    }

    public static void addAttribute(Element element, String name, Object value)
    {
        if (value != null)
        {
            element.addAttribute(new Attribute(name, value.toString()));
        }
    }

    public static void addAttribute(Element element, String name, int value)
    {
        element.addAttribute(new Attribute(name, String.valueOf(value)));
    }

    public static void addAttribute(Element element, String name, long value)
    {
        element.addAttribute(new Attribute(name, String.valueOf(value)));
    }

    public static void addAttribute(Element element, String name, double value)
    {
        element.addAttribute(new Attribute(name, String.valueOf(value)));
    }

    public static void addAttribute(Element element, String name, Date value)
    {
        if (value != null)
        {
            String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S 'UTC'").format(value);
            element.addAttribute(new Attribute(name, dateString));
        }
    }

    public static void addAttribute(Element element, String name, LocalDateTime value)
    {
        if (value != null)
        {
            String dateString = ZonedDateTime.of(value, ZoneId.systemDefault()).format(format);
            element.addAttribute(new Attribute(name, dateString));
        }
    }
}