package com.ofa.quote.service;

import com.ofa.quote.dto.CategoryDTO;
import com.ofa.quote.model.Category;
import com.ofa.quote.model.User;
import com.ofa.quote.repository.ICategoryRepository;
import com.ofa.quote.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository categoryRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(category ->
                modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }
}
