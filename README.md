# spring-xom-marshaller

[![Maven Central](https://img.shields.io/maven-central/v/com.itelg.spring/spring-xom-marshaller.svg?label=maven-central)](https://search.maven.org/artifact/com.itelg.spring/spring-xom-marshaller)
[![Release](https://github.com/julian-eggers/spring-xom-marshaller/actions/workflows/release.yml/badge.svg)](https://github.com/julian-eggers/spring-xom-marshaller/actions/workflows/release.yml)
[![Nightly build](https://github.com/julian-eggers/spring-xom-marshaller/actions/workflows/nightly.yml/badge.svg)](https://github.com/julian-eggers/spring-xom-marshaller/actions/workflows/nightly.yml)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=julian-eggers_spring-xom-marshaller&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=julian-eggers_spring-xom-marshaller)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=julian-eggers_spring-xom-marshaller&metric=coverage)](https://sonarcloud.io/summary/new_code?id=julian-eggers_spring-xom-marshaller)

Spring XML Marshalling with [XOM](http://www.xom.nu/)

#### Maven
```xml
<dependency>
  <groupId>com.itelg.spring</groupId>
  <artifactId>spring-xom-marshaller</artifactId>
  <version>2.0.0-RC2</version>
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
