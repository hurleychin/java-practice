package com.evil.spring.jdbc.tx;

import com.evil.spring.context.User;
import com.evil.util.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author qinhu
 * @date 2018-09-26
 */
@Configuration
@PropertySource("classpath:/jdbc/mysql.properties")
@EnableTransactionManagement
public class TransactionManagerSample {

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.password}")
    private String password;

    @Value("${db.username}")
    private String username;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource source=new DriverManagerDataSource();
        source.setDriverClassName(this.driverClassName);
        source.setUrl(this.url);
        source.setUsername(this.username);
        source.setPassword(this.password);
        return source;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public TransactionTemplate getTransactionTemplate(){
        return new TransactionTemplate(getTransactionManager());
    }


    public void testTransactionDefinition() throws Exception {


       /* Thread unCommit=new Thread(()->{
            DefaultTransactionDefinition definition2=new DefaultTransactionDefinition();
            definition2.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
            TransactionStatus status2=transactionManager.getTransaction(definition2);
            try {
                jdbcTemplate.execute("INSERT INTO `test`.`user` ( `name`, `sex`, `age`) VALUES ( 'evil3', 'male', 35)");
//                jdbcTemplate.execute("INSERT INTO `test`.`user` ( `id`,`name`, `sex`, `age`) VALUES ('1' , 'evil', 'male', 32)");
                LockSupport.park();
                transactionManager.commit(status2);
            }catch (Exception e){
                e.printStackTrace();
                transactionManager.rollback(status2);
            }
        });
        unCommit.start();*/


        DefaultTransactionDefinition definition=new DefaultTransactionDefinition();
        TransactionStatus status=transactionManager.getTransaction(definition);
        Console.out(status);

        try {
//            jdbcTemplate.execute("INSERT INTO `test`.`user` ( `name`, `sex`, `age`) VALUES ( 'evil1', 'male', 35)");
//            jdbcTemplate.execute("INSERT INTO `test`.`user` ( `name`, `sex`, `age`) VALUES ( 'evil2', 'male', 35)");
            List<User> users = jdbcTemplate.query("select id,name,sex,age from user", new BeanPropertyRowMapper(User.class)) ;
            Console.out(users);
//            LockSupport.unpark(unCommit);
            DefaultTransactionDefinition definition2=new DefaultTransactionDefinition();
            definition2.setPropagationBehavior(TransactionDefinition.PROPAGATION_NEVER);
            TransactionStatus status2=transactionManager.getTransaction(definition2);
            Console.out(status2);
            try {
                jdbcTemplate.execute("INSERT INTO `test`.`user` ( `name`, `sex`, `age`) VALUES ( 'evil3', 'male', 35)");
                jdbcTemplate.execute("INSERT INTO `test`.`user` ( `id`,`name`, `sex`, `age`) VALUES ('3' , 'evil', 'male', 32)");
                transactionManager.commit(status2);
            }catch (Exception e){
                e.printStackTrace();
                transactionManager.rollback(status2);
            }
            jdbcTemplate.execute("INSERT INTO `test`.`user` ( `id`,`name`, `sex`, `age`) VALUES ('1' , 'evil', 'male', 32)");
            List<User> users1 = jdbcTemplate.query("select id,name,sex,age from user", new BeanPropertyRowMapper(User.class)) ;
            Console.out(users1);

            transactionManager.commit(status);
        }catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }/*finally {
            LockSupport.unpark(unCommit);
        }
*/
    }

    public void testTransactionTemplate(){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    jdbcTemplate.execute("INSERT INTO `test`.`user` ( `name`, `sex`, `age`) VALUES ( 'evil3', 'male', 35)");
                    jdbcTemplate.execute("INSERT INTO `test`.`user` (`id`, `name`, `sex`, `age`) VALUES (1, 'evil', 'male', 32)");
                }catch (Exception e){
                    status.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });
    }

}
