package com.ofa.quote.repository;

import com.ofa.quote.model.Category;
import com.ofa.quote.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IQuoteRepository extends JpaRepository<Quote,Long> {
    Page<Quote> findQuotesByCategory(Category category, Pageable pageable);
}
