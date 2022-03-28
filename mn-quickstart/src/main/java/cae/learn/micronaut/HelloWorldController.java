package cae.learn.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Controller("/hello")
public class HelloWorldController {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    private final MyService service;

    //Constructor based injection
    public HelloWorldController( MyService service) {
        this.service = service;
    }



    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld(){
        log.debug("Called the " + this.getClass().getName() );
        return service.helloFromService();
    }
}
