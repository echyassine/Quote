package com.ofa.quote.repository;

import com.ofa.quote.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
//    List<Category> getCategoriesByUsers();
}
