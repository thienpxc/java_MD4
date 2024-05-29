package rikkeis.academys.service;

import rikkeis.academys.model.Book;


import java.util.List;

public interface IBookController {
    List<Book> findAll();
    void deleteById(Integer id);
    void save(Book book);
    Book findBookById(Integer id);


}
