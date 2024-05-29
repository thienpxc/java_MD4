package rikkeis.academys.service;



import rikkeis.academys.model.Category;

import java.util.List;

public interface ICategoryController {
    List<Category> findAll();
    void deleteById(Integer id);
    void save(Category category);
    Category findCategoryById(Integer id);

}
