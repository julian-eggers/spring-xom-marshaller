spring-xom-marshaller
=====================

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/itelg/spring/spring-xom-marshaller/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.itelg.spring%22%20AND%20a%3A%22spring-xom-marshaller%22)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/40fe4c8aa29241429724a9c415051a06)](https://www.codacy.com/app/eggers-julian/spring-xom-marshaller)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/40fe4c8aa29241429724a9c415051a06)](https://www.codacy.com/app/eggers-julian/spring-xom-marshaller)
[![Build Status](https://travis-ci.org/julian-eggers/spring-xom-marshaller.svg?branch=master)](https://travis-ci.org/julian-eggers/spring-xom-marshaller)

Spring XML Marshalling with [XOM](http://www.xom.nu/)

#### Maven
```xml
<dependency>
  <groupId>com.itelg.spring</groupId>
  <artifactId>spring-xom-marshaller</artifactId>
  <version>1.2.0</version>
</dependency>
```

#### Examples

##### Enable auto-configuration via annotation

[@Autowire](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowire.html) XomMarshaller for further use in [MarshallingHttpMessageConverter](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/xml/MarshallingHttpMessageConverter.html) or [MarshallingMessageConverter](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/messaging/converter/MarshallingMessageConverter.html).

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



## Build & Release

### Build
```
mvn clean package
```

### Release
```
mvn clean deploy
```
