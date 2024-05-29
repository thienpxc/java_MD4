package rikkeis.academys.service;

import rikkeis.academys.dao.CategoryDaolmpl;
import rikkeis.academys.dao.ICategoryDao;
import rikkeis.academys.model.Category;

import java.util.List;

public class CategoryServicelmpl implements ICategoryController{
    private static final ICategoryDao categoryDao = new CategoryDaolmpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryDao.findCategoryById(id);
    }
}
