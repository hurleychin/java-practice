* java.util
    - [X] StringTokenizer
* 序列化
    - [X] ObjectStream.readResolve()
    - [ ] BeanUtils.clone()
    - [ ] 反射实现克隆
    - [ ] 浅克隆与深克隆
* 并发编程
    - [X] wait()、notify()、notifyAll()
    - [X] join()
    - [X] ReentrantLock、ReentrantReadWriteLock
    - [X] ThreadGroup
    - [X] java.lang.Thread.yield 
    - [ ] LockSupport
    - [X] Condition
    - [X] CountDownLatch
    - [X] CyclicBarrier
    - [X] Semaphore
    - [X] Exchanger
    - [ ] java.util.concurrent.locks.StampedLock
    - [ ] java.util.concurrent.atomic.*
    - [ ] Executors
    - [X] Fork/Join
    - [ ] ThreadLocal
    - [ ] Collection
        - [ ] CopyOnWriteArrayList/CopyOnWriteArraySet
        - [ ] ConcurrentHashMap/ConcurrentLinkedQueue
* 分布式
    - [ ] SPI
    - [ ] RedissonClient
* 设计模式
    - [X] 迭代器
* Guava
* [myBatis](http://www.mybatis.org/mybatis-3) 
    - [X] 编程式和集成式
    - [X] 配置文件
        - [X] environments 
        - [ ] typeHandlers
        - [ ] plugin (Interceptor)
    - [ ] Mapper XML
        - [ ] association (嵌套查询 N+1问题)
        - [ ] collection  
    - [ ] Dynamic SQL
    - [ ] 一级缓存和二级缓存
    - [X] mybatis-generator
    - [ ] 分页 [pagehelper](https://github.com/pagehelper/Mybatis-PageHelper)
    - [ ] 批量操作
        - [ ] foreach 拼 SQL（性能最高,推荐使用)
        - [ ] ExeutorType.BATCH 
* JVM
 - [ ] ClassLoader
    - [ ] 获取所有加载的class
 - [ ] 方法栈

* [Sharding-JDBC](https://shardingsphere.apache.org/document/current/cn/quick-start/sharding-jdbc-quick-start/)

* SpringCloud Ribbon
    - [ ] an IClientConfig, which stores client configuration for a client or load balancer,
 
    - [ ] an ILoadBalancer, which represents a software load balancer,
 
    - [ ] a ServerList, which defines how to get a list of servers to choose from,
 
    - [ ] an IRule, which describes a load balancing strategy, and
 
    - [ ] an IPing, which says how periodic pings of a server are performed.
