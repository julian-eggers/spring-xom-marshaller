# spring-xom-marshaller

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.itelg.spring/spring-xom-marshaller/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.itelg.spring/spring-xom-marshaller)
[![Build](https://github.com/julian-eggers/spring-xom-marshaller/workflows/release/badge.svg)](https://github.com/julian-eggers/spring-xom-marshaller/actions)
[![Nightly build](https://github.com/julian-eggers/spring-xom-marshaller/workflows/nightly/badge.svg)](https://github.com/julian-eggers/spring-xom-marshaller/actions)

Spring XML Marshalling with [XOM](http://www.xom.nu/)

#### Maven
```xml
<dependency>
  <groupId>com.itelg.spring</groupId>
  <artifactId>spring-xom-marshaller</artifactId>
  <version>1.3.0-RC1</version>
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
