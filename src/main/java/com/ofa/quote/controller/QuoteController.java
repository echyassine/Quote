package com.ofa.quote.controller;

import com.ofa.quote.dto.QuoteDTO;
import com.ofa.quote.service.IQuoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class QuoteController {
    private final IQuoteService quoteService;

    @GetMapping("/categories/{categoryId}/quotes")
    public ResponseEntity<List<QuoteDTO>>  getQuotesByCategory(
            @PathVariable Long categoryId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size ){
        return new ResponseEntity<>(quoteService.getQuotesByCategory(categoryId,page,size), HttpStatus.OK) ;
    }
}
