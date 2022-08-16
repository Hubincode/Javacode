package com.hubin.dao.books;

import com.hubin.pojo.Books;

import java.util.List;

public interface BookMapper {
//    增
    int addBook(Books books);
//    删
    int deleteBookById(Integer id);
//    改
    int upadeBook(Books books);
//    查
    Books queryBooksById(Integer id);
    List<Books> queryAllBooks();
}
