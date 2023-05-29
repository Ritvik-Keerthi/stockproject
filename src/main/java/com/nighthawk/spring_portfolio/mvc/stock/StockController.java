package com.nighthawk.spring_portfolio.mvc.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockJpaRepository repository;

    // Get current price of a stock
    @GetMapping("/currentPrice/{symbol}")
    public ResponseEntity<Stock> getCurrentPrice(@PathVariable String symbol) {
        Optional<Stock> optional = repository.findBySymbol(symbol);
        if (optional.isPresent()) {  // Symbol found
            Stock stock = optional.get();
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }
        // Symbol not found
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Update price of a stock
    @PostMapping("/updatePrice/{symbol}/{newPrice}")
    public ResponseEntity<Stock> updatePrice(@PathVariable String symbol, @PathVariable double newPrice) {
        Optional<Stock> optional = repository.findBySymbol(symbol);
        if (optional.isPresent()) {  // Symbol found
            Stock stock = optional.get();
            stock.setPrice(newPrice);
            repository.save(stock);
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }
        // Symbol not found
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Get symbol by id
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getSymbol(@PathVariable long id) {
        Optional<Stock> optional = repository.findById(id);
        if (optional.isPresent()) {  // ID found
            Stock stock = optional.get();
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }
        // ID not found
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}