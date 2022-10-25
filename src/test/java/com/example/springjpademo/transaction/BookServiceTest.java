package com.example.springjpademo.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TransactionApplication.class})
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    public void testInsertBook() {
        bookService.getBookCount();
        bookService.insertBook();
        bookService.getBookCount();
    }

    @Test
    public void testInsertBookWithRollBack() {
        bookService.getBookCount();
        try {
            bookService.insertBookWithRollback();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        bookService.getBookCount();
    }

    @Test
    public void testInsertWithManuallyTransaction() {
        bookService.getBookCount();
        bookService.insertBookWithManualTransaction();
        bookService.getBookCount();
    }
}
