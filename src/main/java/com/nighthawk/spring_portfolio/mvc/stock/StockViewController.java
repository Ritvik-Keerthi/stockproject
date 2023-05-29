package com.nighthawk.spring_portfolio.mvc.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Built using article: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
// or similar: https://asbnotebook.com/2020/04/11/spring-boot-thymeleaf-form-validation-example/
@Controller
@RequestMapping("/mvc/person")
public class StockViewController {
    // Autowired enables Control to connect HTML and POJO Object to database easily for CRUD
    @Autowired
    private StockJpaRepository repository;

    @GetMapping("/read")
    public String stock(Model model) {
        List<Stock> list = repository.findAll();
        model.addAttribute("list", list);
        return "stock/read";
    }

}