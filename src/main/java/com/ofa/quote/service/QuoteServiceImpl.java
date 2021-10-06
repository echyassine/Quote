package com.ofa.quote.service;


import com.ofa.quote.dto.QuoteDTO;
import com.ofa.quote.model.Category;
import com.ofa.quote.model.Quote;
import com.ofa.quote.repository.ICategoryRepository;
import com.ofa.quote.repository.IQuoteRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class QuoteServiceImpl implements IQuoteService {

    private final ICategoryRepository categoryRepository;
    private final IQuoteRepository quoteRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    @Override
    public List<QuoteDTO> getQuotesByCategory(Long categoryID, int page, int size) {
        Category category = categoryRepository.findById(categoryID).get();
        Page<Quote> quotePage = quoteRepository.findQuotesByCategory(category, PageRequest.of(page, size));
        return quotePage.stream().map(quote ->
                modelMapper.map(quote, QuoteDTO.class)).collect(Collectors.toList());
    }
}
