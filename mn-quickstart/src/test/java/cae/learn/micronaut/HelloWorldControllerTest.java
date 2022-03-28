package cae.learn.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloWorldControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void helloWorldEndpointRespondsWithProperContent(){
        String response =  client.toBlocking().retrieve("/hello");
        assertEquals( "Hello, World!", response );
    }

    @Test
    void helloWorldEndpointRespondsWithProperStatusCodeContent(){
        /*  IMPORTANT */
        HttpResponse response =  client.toBlocking().exchange("/hello", String.class );
        assertEquals( "Hello, World!", response.getBody().get() );
        assertEquals(HttpStatus.OK, response.getStatus());

    }


}
