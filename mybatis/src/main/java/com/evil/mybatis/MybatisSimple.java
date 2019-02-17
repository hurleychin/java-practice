package com.evil.mybatis;

import com.evil._generator.Blog;
import com.evil._generator.BlogExample;
import com.evil._generator.BlogMapper;
import com.evil._generator.TagEnum;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author qinhulin
 * @date 2018-12-16
 */
public class MybatisSimple {

    private static SqlSessionFactory sqlSessionFactory;

    private static final String configPath="";


    static{
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
   }

/*   public SqlSessionFactory getSqlSessionFactory() throws IOException {

      TransactionFactory transactionFactory = new JdbcTransactionFactory();
      Environment environment = new Environment("development", transactionFactory, new MysqlDataSource());
      Configuration configuration = new Configuration(environment);
      configuration.addMapper(BlogMapper.class);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
      return sqlSessionFactory;
   }*/

   public static List<Blog> selectBlog(BlogExample example) throws IOException {
       SqlSession session=sqlSessionFactory.openSession(true);
       try {
          BlogMapper mapper=session.getMapper(BlogMapper.class);
         return mapper.selectByExampleWithBLOBs(example);
       }finally {
          session.close();
       }

   }

    public static int insertBlog(Blog blog) throws IOException {
        SqlSession session=sqlSessionFactory.openSession(true);
        try {
            BlogMapper mapper=session.getMapper(BlogMapper.class);
            return mapper.insertSelective(blog);
        }finally {
            session.close();
        }

    }

   public static void main(String[] args) throws IOException {
       Blog blog=new Blog();
       blog.setTitle("python");
       blog.setAuthorId(1);
       blog.setContent("main");
       blog.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
       System.out.println(insertBlog(blog));

       BlogExample blogExample=new BlogExample();
       blogExample.createCriteria().andTitleLike("java%");
       System.out.println(selectBlog(blogExample).get(0));

       System.out.println(TagEnum.csharp);


   }



}
