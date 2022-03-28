package cae.learn.micronaut;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Controller("/hello")
public class HelloWorldController {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    private final MyService service;

    private final String helloFromConfig;
    //Constructor based injection
    public HelloWorldController(MyService service, @Property( name = "hello.world.message") String helloFromConfig) {
        this.service = service;
        this.helloFromConfig = helloFromConfig;
    }



    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld(){
        log.debug("Called the " + this.getClass().getName() );
        return service.helloFromService();
    }

    @Get(uri ="/config", produces = MediaType.TEXT_PLAIN)
    public String helloConfig(){
        log.debug("Return value from application.yml");
        return helloFromConfig;
    }

}
