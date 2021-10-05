package com.ofa.quote.service;

import com.ofa.quote.dto.CategoryDTO;
import com.ofa.quote.dto.QuoteDTO;
import com.ofa.quote.model.User;

import java.util.List;

public interface IUserService {
    void like(QuoteDTO quoteDTO, Long userId);
    Boolean addInterests(List<CategoryDTO> categoriesDTO, Long userId);
}
