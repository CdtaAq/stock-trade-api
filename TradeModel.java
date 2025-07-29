package com.hackerrank.stocktrades.model;

import javax.persistence.*;

@Entity
@Table(name = “trades”)
public class Trade {

```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false)
private String type;

@Column(name = "user_id", nullable = false)
private Integer userId;

@Column(nullable = false)
private String symbol;

@Column(nullable = false)
private Integer shares;

@Column(nullable = false)
private Integer price;

@Column(nullable = false)
private Long timestamp;

// Default constructor
public Trade() {}

// Constructor without id (for creating new trades)
public Trade(String type, Integer userId, String symbol, Integer shares, Integer price, Long timestamp) {
this.type = type;
this.userId = userId;
this.symbol = symbol;
this.shares = shares;
this.price = price;
this.timestamp = timestamp;
}

// Getters and Setters
public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}

public String getSymbol() {
return symbol;
}

public void setSymbol(String symbol) {
this.symbol = symbol;
}

public Integer getShares() {
return shares;
}

public void setShares(Integer shares) {
this.shares = shares;
}

public Integer getPrice() {
return price;
}

public void setPrice(Integer price) {
this.price = price;
}

public Long getTimestamp() {
return timestamp;
}

public void setTimestamp(Long timestamp) {
this.timestamp = timestamp;
}
```

}
