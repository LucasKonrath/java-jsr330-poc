java-jsr330-poc

Goal
- Minimal Java POC demonstrating JSR-330 (@Inject, @Named, Provider) using Guice (a JSR-330 compatible DI container).

Requirements
- Java 17+
- Maven 3.9+

Run
1) mvn -q test
2) mvn -q exec:java

What to look for
- Constructor injection with @Inject
- Qualifiers with @Named (different MessageService implementations)
- javax.inject.Provider for lazy/late retrieval
- Singleton scope
