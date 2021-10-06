package com.ofa.quote;

import com.ofa.quote.model.Category;
import com.ofa.quote.model.Quote;
import com.ofa.quote.model.User;
import com.ofa.quote.repository.ICategoryRepository;
import com.ofa.quote.repository.IQuoteRepository;
import com.ofa.quote.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class QuoteApplication implements CommandLineRunner {

    private final IUserRepository userRepository;
    private final ICategoryRepository categoryRepository;
    private final IQuoteRepository quoteRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(QuoteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category(null, "category", null);
        Category category1 = new Category(null, "category1", null);
        Category category2 = new Category(null, "category2", null);
        categoryRepository.save(category);
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        User user = new User();
        userRepository.save(user);
        Quote quote = new Quote(null, "quote", "author", category,null);
        Quote quote1 = new Quote(null, "quote1", "author1", category1,null);
        Quote quote2 = new Quote(null, "quote2", "author2", category2,null);
        Quote quote3 = new Quote(null, "quote3", "author3", category,null);
        Quote quote4 = new Quote(null, "quote4", "author4", category1,null);
        Quote quote5 = new Quote(null, "quote5", "author5", category2,null);
        Quote quote9 = new Quote(null, "quote6", "author6", category,null);
        Quote quote6 = new Quote(null, "quote7", "author7", category1,null);
        Quote quote7 = new Quote(null, "quote8", "author8", category2,null);
        Quote quote8 = new Quote(null, "quote9", "author9", category,null);
        quoteRepository.save(quote);
        quoteRepository.save(quote1);
        quoteRepository.save(quote2);
        quoteRepository.save(quote3);
        quoteRepository.save(quote4);
        quoteRepository.save(quote5);
        quoteRepository.save(quote6);
        quoteRepository.save(quote7);
        quoteRepository.save(quote8);
        quoteRepository.save(quote9);
    }
}
