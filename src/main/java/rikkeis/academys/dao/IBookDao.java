package rikkeis.academys.dao;

import rikkeis.academys.model.Book;

import java.util.List;

public interface IBookDao {
    List<Book> findAll();
    void deleteById(Integer id);
    void save(Book book);
    Book findBookById(Integer id);
}
