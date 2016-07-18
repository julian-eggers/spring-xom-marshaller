spring-xom-marshaller
============

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.itelg.spring/spring-xom-marshaller/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.itelg.spring/spring-xom-marshaller)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d134d532488b44e5aaaf1b9775999035)](https://www.codacy.com/app/eggers-julian/spring-xom-marshaller?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=julian-eggers/spring-xom-marshaller&amp;utm_campaign=Badge_Grade)
[![Coverage Status](https://coveralls.io/repos/julian-eggers/spring-xom-marshaller/badge.svg)](https://coveralls.io/r/julian-eggers/spring-xom-marshaller)
[![Build Status](https://travis-ci.org/julian-eggers/spring-xom-marshaller.svg?branch=master)](https://travis-ci.org/julian-eggers/spring-xom-marshaller)

Spring XML Marshalling with [XOM](http://www.xom.nu/)

#### Maven
```xml
<dependencies>
	<dependency>
		<groupId>com.itelg.spring</groupId>
		<artifactId>spring-xom-marshaller</artifactId>
		<version>0.0.1-RELEASE</version>
	</dependency>
</dependencies>
```

#### Examples

##### Enable auto-configuration via annotation

[@Autowire](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowire.html) XomUnmarshaller for further use in [MarshallingHttpMessageConverter](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/xml/MarshallingHttpMessageConverter.html) or [MarshallingMessageConverter](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/messaging/converter/MarshallingMessageConverter.html).

```java
@SpringBootApplication
@EnableXomMarshaller
public class Application
{
    @Autowired
    private XomMarshaller xomMarshaller;
    
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }
}
```

##### Example-Writer
```java
@Component
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
```