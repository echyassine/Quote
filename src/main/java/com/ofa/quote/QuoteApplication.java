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
        Quote quote = new Quote();
        Quote quote1 = new Quote();
        quoteRepository.save(quote);
        quoteRepository.save(quote1);
    }
}
