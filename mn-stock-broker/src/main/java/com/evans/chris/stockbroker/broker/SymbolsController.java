package com.evans.chris.stockbroker.broker;

import com.evans.chris.stockbroker.broker.data.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Get("{value}") //this name must match.....
    public Symbol getSymbolByValue(@PathVariable String value ){ // the name used here
        return inMemoryStore.getSymbols().get(value);
    }

    @Get("/filter{?max,offset}")
    public List<Symbol> getSymbols(@QueryValue Optional <Integer> max, @QueryValue Optional<Integer> offset ){
        return inMemoryStore.getSymbols().values()
                .stream()
                .skip(offset.orElse(0))
                .limit(max.orElse(10))
                .toList();

    }

}
