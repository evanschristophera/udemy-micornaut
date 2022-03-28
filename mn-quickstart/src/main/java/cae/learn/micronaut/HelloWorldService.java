package cae.learn.micronaut;

import jakarta.inject.Singleton;
//only one will exist in the application context
@Singleton
public class HelloWorldService {
    public String helloFromServce(){
        return "Hello from Service!";
    }
}
