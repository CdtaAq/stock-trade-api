package com.hackerrank.stocktrades.repository;

import com.hackerrank.stocktrades.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

```
// Find trades by type
List<Trade> findByType(String type);

// Find trades by userId
List<Trade> findByUserId(Integer userId);

// Find trades by type and userId
List<Trade> findByTypeAndUserId(String type, Integer userId);

// Custom query to find all trades ordered by id
@Query("SELECT t FROM Trade t ORDER BY t.id ASC")
List<Trade> findAllOrderedById();
```

}
