package com.evil.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author qinhulin
 * @date 2020-07-01
 */
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    @Autowired
    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234","a1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567","b1234"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234","a1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567","b5678"));

        bookRepository.evictCache();

        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234","a1234"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-4567","b1234"));
    }

}