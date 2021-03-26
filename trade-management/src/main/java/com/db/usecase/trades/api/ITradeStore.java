package com.db.usecase.trades.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ITradeStore {

    @PostMapping(path="/add", consumes = "text/plain")
     ResponseEntity<String> store(@RequestBody String trade);
}
