package com.ofa.quote.controller;

import com.ofa.quote.dto.CategoryDTO;
import com.ofa.quote.dto.QuoteDTO;
import com.ofa.quote.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final IUserService userService;

    @PostMapping("/users/{id}/likes")
    public void like(@RequestBody  QuoteDTO quoteDTO,
                     @PathVariable Long id){
        userService.like(quoteDTO, id);

    }

    @PostMapping("/users/{id}/categories")
    public Boolean addCategories(@RequestBody List<CategoryDTO> categories,
                                 @PathVariable Long id){
        return userService.addInterests(categories, id);
    }

}
