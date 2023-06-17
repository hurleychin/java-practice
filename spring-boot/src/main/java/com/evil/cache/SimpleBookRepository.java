package com.evil.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author qinhulin
 * @date 2020-07-01
 */
@Component
@Slf4j
public class SimpleBookRepository implements BookRepository {


    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn,String title) {
        simulateSlowService();
        return new Book(isbn, title);
    }

    @CacheEvict(cacheNames="books",allEntries=true)
    @Override
    public void evictCache(){
        log.info("evict all entries from cache");
       return;
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            log.info("slow service...");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
