package com.evans.chris.stockbroker.broker;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.tree.JsonNode;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class SymbolsControllerTest {

    @Inject
    @Client("/symbols")
    HttpClient client;

    @Test
    public void sysmbolsEndpointReturnsListOfSymbols(){
        var response = client.toBlocking().exchange("/", JsonNode.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(10, response.getBody().get().size() );
    }
}
