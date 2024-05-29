package rikkeis.academys.service;

import rikkeis.academys.dao.BookDaolmpl;
import rikkeis.academys.dao.IBookDao;
import rikkeis.academys.model.Book;

import java.util.List;

public class BookServicelmpI implements  IBookController{
  private static final IBookDao bookDao = new BookDaolmpl();
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
     bookDao.deleteById(id);
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }
}
