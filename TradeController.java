package com.hackerrank.stocktrades.controller;

import com.hackerrank.stocktrades.model.Trade;
import com.hackerrank.stocktrades.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(”/trades”)
public class TradeController {

```
@Autowired
private TradeRepository tradeRepository;

// POST /trades - Create a new trade
@PostMapping
public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
// Validate that shares are between 10 and 30
if (trade.getShares() < 10 || trade.getShares() > 30) {
return ResponseEntity.badRequest().build();
}

// Save the trade (id will be auto-generated)
Trade savedTrade = tradeRepository.save(trade);
return ResponseEntity.status(HttpStatus.CREATED).body(savedTrade);
}

// GET /trades - Get all trades with optional filtering
@GetMapping
public ResponseEntity<List<Trade>> getAllTrades(
@RequestParam(required = false) String type,
@RequestParam(name = "user_id", required = false) Integer userId) {

List<Trade> trades;

// Apply filtering based on query parameters
if (type != null && userId != null) {
trades = tradeRepository.findByTypeAndUserId(type, userId);
} else if (type != null) {
trades = tradeRepository.findByType(type);
} else if (userId != null) {
trades = tradeRepository.findByUserId(userId);
} else {
trades = tradeRepository.findAllOrderedById();
}

return ResponseEntity.ok(trades);
}

// GET /trades/{id} - Get a specific trade by id
@GetMapping("/{id}")
public ResponseEntity<Trade> getTradeById(@PathVariable Integer id) {
Optional<Trade> trade = tradeRepository.findById(id);

if (trade.isPresent()) {
return ResponseEntity.ok(trade.get());
} else {
return ResponseEntity.notFound().build();
}
}

// DELETE /trades/{id} - Not allowed (return 405)
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTrade(@PathVariable Integer id) {
return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
}

// PUT /trades/{id} - Not allowed (return 405)
@PutMapping("/{id}")
public ResponseEntity<Void> updateTrade(@PathVariable Integer id, @RequestBody Trade trade) {
return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
}

// PATCH /trades/{id} - Not allowed (return 405)
@PatchMapping("/{id}")
public ResponseEntity<Void> patchTrade(@PathVariable Integer id, @RequestBody Trade trade) {
return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
}
```

}
