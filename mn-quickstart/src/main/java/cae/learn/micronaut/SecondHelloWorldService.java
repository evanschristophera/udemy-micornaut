package cae.learn.micronaut;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

//only one will exist in the application context
@Singleton
public class SecondHelloWorldService implements MyService {
    public String helloFromService(){
        return "Hello from Second Service!";
    }
}
