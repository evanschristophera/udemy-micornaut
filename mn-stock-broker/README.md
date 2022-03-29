# Section Three -- Micronaut Web
## 22 Query Parameters
* Query parameters are used to filter or search for specific data
* http client file getSymbols.http is handy but unit tests are better.
* Syntax
```
    @Get("/filter{?max,offset}")
    public List<Symbol> getSymbols(@QueryValue Optional <Integer> max, @QueryValue Optional<Integer> offset ){
```
## 21 Path Variables
* The PathVariable annotation is the secret sauce
* Used to get a particular object
## 20 Http Routing - GET requests JUnit
* Unit Test instead of http client
  * Junit
  * Micronaut creates JSON objects by default
## 19 Http Routing &ndash; GET Requests
* Symbols controller
* Java 17 Record functionality.  
  * Gets rid of boilerplate getters and setters
  * Prior Java version would require Lombok
* Modify logback.xml to show debug.
* **Faker package for bs data**
* Initialization does not happen until service is called.
## 18 &ndash; New Micronaut Web Project
* Used Intellij new project dialog
* Only adding netty server to start
* PostConstruct - 
## Micronaut 3.4.0 Documentation

- [User Guide](https://docs.micronaut.io/3.4.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.4.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.4.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


