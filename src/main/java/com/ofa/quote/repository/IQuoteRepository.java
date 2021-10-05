package com.ofa.quote.repository;

import com.ofa.quote.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuoteRepository extends JpaRepository<Quote,Long> {
}
