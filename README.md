# simple-cqrs-java

Simple-CQRS-Java(SCJ) is intended to be lightweight implementation of the popular design pattern
[CQRS](https://martinfowler.com/bliki/CQRS.html).
This library will support components such as...
* <b>Events</b>
* <b>Commands</b>
* <b>Queries</b>
* <b>Coming soon - behaviors</b>

## Why SCJ
CQRS can be complicated, and easy to get wrong. SCJ allow your use of a straightforward implementation that plans to 
grow enough to handle more complex scenarios, but remain small enough to aid with CQRS usage and un-opinionated about 
your implementation, this could be a good tool for you.

### Extensibility

SCJ will be extensible for individual implementations, and there will be helper libraries 
that will aid with working with things such as dependency injection, and ease of use with 
the most common frameworks. If you are providing a custom implementation you can choose which 
you would like to extend in terms of libraries, but the framework specific libraries 
will contain the core components that are part of Simple-CQRS-Java-Core.

Additional libraries coming soon...
* <b>simple-cqrs-java-cdi</b>
* <b>simple-cqrs-java-spring</b>

## Usage

### Maven

```xml
<dependency>
    <groupId>io.github.broot02</groupId>
    <artifactId>simple-cqrs-java-core</artifactId>
    <version>${latest-scj-core-version}</version>
</dependency>
```

### Gradle
```groovy
implementation 'io.github.broot02:simple-cqrs-java-core:0.0.1'
```