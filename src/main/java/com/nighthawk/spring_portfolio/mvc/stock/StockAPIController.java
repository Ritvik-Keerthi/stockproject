package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockAPIController {

    private final StockService stockService;

    public StockAPIController(StockService stockService) {
        this.stockService = stockService;
    }

    // Get All Stocks
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    // Get a Single Stock
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    // Create a new Stock
    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.createStock(stock));
    }

    // Update a Stock
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable("id") Long id, @RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.updateStock(id, stock));
    }

    // Delete a Stock
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable("id") Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.ok().build();
    }
}
