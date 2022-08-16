package com.hubin.service.books;

import com.hubin.dao.books.BookMapper;
import com.hubin.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int upadeBook(Books books) {
        return bookMapper.upadeBook(books);
    }

    @Override
    public Books queryBooksById(Integer id) {
        return bookMapper.queryBooksById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }


}
