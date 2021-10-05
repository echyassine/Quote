package com.ofa.quote.controller;

import com.ofa.quote.dto.CategoryDTO;
import com.ofa.quote.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDTO> getCategories(){
        return categoryService.getAllCategories();
    }

}
