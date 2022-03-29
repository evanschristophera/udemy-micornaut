package com.evans.chris.stockbroker.broker;

import com.evans.chris.stockbroker.broker.data.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Controller("/symbols")
public class SymbolsController {
    private final InMemoryStore inMemoryStore;
    private final Logger log = LoggerFactory.getLogger(SymbolsController.class);

    public SymbolsController(InMemoryStore inMemoryStore) {
        log.debug( "constructor");
        this.inMemoryStore = inMemoryStore;
    }


    @Get
    public List<Symbol> getAll(){
        return new ArrayList<>(inMemoryStore.getSymbols().values());
    }
}
