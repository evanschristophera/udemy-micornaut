package cae.learn.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloWorldController {

    private final MyService service;

    //Constructor based injection
    public HelloWorldController( MyService service) {
        this.service = service;
    }



    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld(){
        return service.helloFromService();
    }
}
