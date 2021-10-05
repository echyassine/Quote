package com.ofa.quote.service;


import com.ofa.quote.dto.CategoryDTO;
import com.ofa.quote.dto.QuoteDTO;
import com.ofa.quote.model.Category;
import com.ofa.quote.model.Quote;
import com.ofa.quote.model.User;
import com.ofa.quote.repository.ICategoryRepository;
import com.ofa.quote.repository.IQuoteRepository;
import com.ofa.quote.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;
    private final IQuoteRepository quoteRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public void like(QuoteDTO quoteDTO, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()){
            User user = userOpt.get();
            Quote quote = quoteRepository.findById(quoteDTO.getId()).get();
            user.getQuotes().add(quote);
        }
    }

    @Override
    public Boolean addInterests(List<CategoryDTO> categoriesDTO, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()){
            User user = userOpt.get();
            List<Category> categories = new ArrayList<>();
            for (CategoryDTO categoryDTO : categoriesDTO) {
                categories.add(categoryRepository.findById(categoryDTO.getId()).get());
            }
            user.getCategories().clear();
            user.setCategories(categories);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
