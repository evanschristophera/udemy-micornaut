package com.evans.chris.stockbroker.broker;

import com.evans.chris.stockbroker.broker.data.InMemoryStore;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.tree.JsonNode;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SymbolsControllerTest {
    private static Logger log = LoggerFactory.getLogger(SymbolsControllerTest.class);
    @Inject
    @Client("/symbols")
    HttpClient client;

    //Injected the InMemoryStore so I can add a value for testing
    @Inject
    InMemoryStore inMemoryStore;

    @BeforeEach
    void setup(){
        inMemoryStore.initializeWith( 10 );
    }
    @Test
    public void sysmbolsEndpointReturnsListOfSymbols(){
        var response = client.toBlocking().exchange("/", JsonNode.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(10, response.getBody().get().size() );
    }

    @Test
    public void sysmbolsEndpointReturnsTheCorrectSysmbol(){
        var testSymbol = new Symbol( "TEST" );
        inMemoryStore.getSymbols().put(testSymbol.value(), testSymbol);
        var response = client.toBlocking().exchange("/" + testSymbol.value(), Symbol.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(testSymbol, response.getBody().get() );
    }

    @Test
    void symbolsEndpointReturnListOfSymbolTakingQueryParametersIntoAccount(){
        var max10 = client.toBlocking().exchange( "/filter?max=10", JsonNode.class);
        assertEquals(HttpStatus.OK, max10.getStatus());
        log.debug("Max: 10: {}", max10.getBody().get());
        assertEquals(10, max10.getBody().get().size() );

        var offset7 = client.toBlocking().exchange( "/filter?offset=7", JsonNode.class);
        assertEquals(HttpStatus.OK, offset7.getStatus());
        log.debug("Max: 2: Offset 7: {}", offset7.getBody().get());
        assertEquals(3, offset7.getBody().get().size() );

        var max2Offset7 = client.toBlocking().exchange( "/filter?offset=7", JsonNode.class);
        assertEquals(HttpStatus.OK, offset7.getStatus());
        log.debug("Max: 2: Offset 7: {}", max2Offset7.getBody().get());
        assertEquals(3, max2Offset7.getBody().get().size() );
    }
}
