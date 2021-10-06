package com.ofa.quote.service;

import com.ofa.quote.dto.QuoteDTO;

import java.util.List;


public interface IQuoteService {
    List<QuoteDTO> getQuotesByCategory(Long categoryID, int page, int size);
}
