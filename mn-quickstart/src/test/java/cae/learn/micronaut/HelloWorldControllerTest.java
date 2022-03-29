package cae.learn.micronaut;

import com.fasterxml.jackson.databind.JsonNode;
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

    @Inject // field based injection
    @Client("/")
    HttpClient client;

    @Test
    void helloWorldEndpointRespondsWithProperContent(){
        String response =  client.toBlocking().retrieve("/hello");
        assertEquals( "Hello from Service!", response );
    }

    @Test
    void helloFromTranslationEndpointReturnsContentFromConfigFile() {
        var response = client.toBlocking().exchange("/hello/translation", JsonNode.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("{\"de\":\"Hallo Welt\",\"en\":\"Hello World\"}", response.getBody().get().toString());
    }

    @Test
    void helloFromConfigEndpointReturnsMessageFromConfigFile(){
        HttpResponse response = client.toBlocking().exchange( "/hello/config", String.class );
        assertEquals( "Hello from application.yml!", response.getBody().get() );
        assertEquals(HttpStatus.OK, response.getStatus());
    }
}
