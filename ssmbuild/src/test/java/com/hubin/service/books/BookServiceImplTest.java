package com.hubin.service.books;

import com.hubin.dao.books.BookMapper;
import com.hubin.pojo.Books;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceImplTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testAddBook() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl= (BookServiceImpl) context.getBean("BookServiceImpl");
        Books books=new Books(10,"hubin",1,"test");
        int rs=0;
        rs=bookServiceImpl.addBook(books);
        System.out.println(rs);
    }

    public void testDeleteBookById() {
    }

    public void testUpadeBook() {
    }

    public void testQueryBooksById() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl= (BookServiceImpl) context.getBean("BookServiceImpl");
        Integer id=1;
        System.out.println(bookServiceImpl.queryBooksById(id));
    }

    public void testQueryAllBooks() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl= (BookServiceImpl) context.getBean("BookServiceImpl");
        System.out.println(bookServiceImpl.queryAllBooks());
    }
}