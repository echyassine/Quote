package com.ofa.quote.controller;

import com.ofa.quote.dto.CategoryDTO;
import com.ofa.quote.dto.QuoteDTO;
import com.ofa.quote.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>>  getCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK) ;
    }

}
