package com.evil.cache;

/**
 * @author qinhulin
 * @date 2020-07-01
 */
public interface BookRepository {

    Book getByIsbn(String isbn,String title);

    void evictCache();

}