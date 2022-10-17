package com.example.springjpademo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class BookService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Transactional
    public void insertBook() {
        String sql = "insert into book (name) values ('xiyouji')";
        jdbcTemplate.update(sql);
    }

    @Transactional(rollbackFor = RollBackException.class)
    public void insertBookWithRollback() throws Exception {
        String sql = "insert into book (name) values ('xiyouji')";
        jdbcTemplate.update(sql);
        throw new RollBackException();
    }

    public void getBookCount() {
        String sql = "select count(*) from book";
        int numbers = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("the book count is " + numbers);
    }

    public void insertBookWithManualTransaction() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                                        @Override
                                        protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                                            jdbcTemplate.execute("INSERT INTO book (name) VALUES ('aaa')");
                                            transactionStatus.setRollbackOnly();
                                        }
                                    }
        );
    }
}
