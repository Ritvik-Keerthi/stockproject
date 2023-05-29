package com.nighthawk.spring_portfolio.mvc.stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String symbol;

    private String companyName;
    private float companyPrice;

    public Stock(String symbol, String companyName, float companyPrice) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.companyPrice = companyPrice;
    }

    // starting stocks
    public static Stock[] init() {
        Stock s1 = new Stock("AAPL", "Apple Inc.", 172.99f);
        Stock s2 = new Stock("GOOG", "Google", 123.48f);

        return new Stock[]{s1, s2};
    }

    public void setPrice(float newPrice) {
        companyPrice = newPrice;
    }
}


