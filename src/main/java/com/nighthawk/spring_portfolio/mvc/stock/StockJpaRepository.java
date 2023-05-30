package com.nighthawk.spring_portfolio.mvc.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface StockJpaRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findBySymbol(String symbol);
    // JPA has many built in methods, these few have been prototyped for this application

    List<Stock> findAll();


}
