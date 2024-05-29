package rikkeis.academys.dao;

import rikkeis.academys.model.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    void deleteById(Integer id);
    void save(Category category);
    Category findCategoryById(Integer id);
}
