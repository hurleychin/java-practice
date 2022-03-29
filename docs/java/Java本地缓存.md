# Java本地缓存
{docsify-updated}

## 缓存框架
### [JCache](https://github.com/jsr107/jsr107spec)

JCache 是 Java 缓存 API。它由 JSR107 定义。它定义了一个供开发人员使用的标准 Java 缓存 API 和一个供实施者使用的标准 SPI。

Java Caching API 为 Java 程序从缓存中创建、访问、更新和删除条目提供了一种通用方法。

#### API 的目标

- 为应用程序提供缓存功能，特别是缓存 Java 对象的能力；

- 定义一组通用的缓存概念和设施；

- 尽量减少 Java 开发人员需要学习采用缓存的概念数量；

- 最大化在缓存实现之间使用缓存的应用程序的可移植性；

- 支持进程内和分布式缓存实现；

- 支持按值和可选的按引用缓存 Java 对象；

- 根据 JSR-175：Java 编程语言的元数据工具定义运行时缓存注释；以便 Java 开发人员使用可选提供的注释处理器可以声明式地指定应用程序缓存要求；

#### API 未解决的

- 资源和内存约束配置 —— 虽然许多缓存实现支持限制缓存在运行时可能使用的资源数量，但本规范并未定义如何配置或表示此功能。然而，该规范确实为开发人员定义了一种标准机制，以指定信息应该可以缓存多长时间。


- 缓存存储和拓扑 —— 本规范没有指定缓存实现如何存储或表示被缓存的信息。


- 管理 —— 本规范未指定如何管理缓存。它确实定义了通过 Java 管理扩展 (JMX) 以编程方式配置缓存和调查缓存统计信息的机制。


- 安全性 —— 本规范未指定如何保护缓存内容或如何控制对缓存的访问和操作。


- 外部资源同步 —— 本规范没有指定应用程序或缓存实现应如何保持缓存和外部资源内容同步。


- 虽然开发人员可以利用规范提供的通读和通写技术，但这些技术仅在缓存是唯一改变外部资源的应用程序时才有效。在这种情况下，无法保证缓存同步。

#### 核心概念

Java Caching API 定义了五个核心接口：`CachingProvider`、`CacheManager`、`Cache`、`Entry` 和 `ExpiryPolicy`。

`CachingProvider` 定义了建立、配置、获取、管理和控制零个或多个 `CacheManager` 的机制。应用程序可以在运行时访问和使用零个或多个 `CachingProvider`。

`CacheManager` 定义了在 `CacheManager` 的上下文中建立、配置、获取、管理和控制零个或多个唯一命名的缓存的机制。 `CacheManager` 由单个 `CachingProvider` 拥有。

`Cache` 是一种类似于 Map 的数据结构，它允许临时存储基于键的值，有些类似于 java.util.Map 数据结构。一个 `Cache` 由一个 `CacheManager` 拥有。

`Entry` 是由缓存存储的单个键值对。

缓存存储的每个条目都有一个定义的持续时间，称为到期持续时间，在此期间它们可以被访问、更新和删除。一旦该持续时间过去，则该条目被称为已过期。一旦过期，条目就不再可供访问、更新或删除，就好像它们从未存在于缓存中一样。使用 `ExpiryPolicy` 设置到期。

#### 按值存储和按引用存储

`Entry` 由单个缓存使用两种机制之一存储。

默认机制称为按值存储，它指示实现在将应用程序提供的键和值存储在缓存中之前制作它们的副本，然后在从缓存中访问时返回条目的新副本。复制存储在缓存中的条目以及从缓存返回时再次复制条目的目的是允许应用程序继续改变键和值的状态，而不会对缓存保存的条目造成副作用。

_Java 序列化可以用来制作键和值的副本的简单方法实现。_

为确保实现之间的应用程序可移植性，建议自定义键和值类在使用按值存储时实现并采用标准 Java 序列化。

_实现用于制作条目的键和值的副本的机制可以是可定制的。然而，为了确保应用程序的可移植性，实现必须允许应用程序单独使用标准 Java 序列化。实现不得强制应用程序采用非标准 Java 序列化。_

另一种可选机制称为按引用存储，它指示缓存实现简单地存储和返回对应用程序提供的键和值的引用，而不是按照按值存储方法的要求进行复制。如果应用程序稍后使用按引用存储语义更改提供给缓存的键或值，则更改的副作用将对那些从缓存访问条目的人可见，而无需应用程序更新缓存。

_对于在 Java 堆上实现的缓存，按引用存储是更快的存储技术。_

#### Caches 和 Maps的比较

虽然`Caches`和`Maps`共享一些相似的 API，但`Caches`不是`Maps`，`Maps`也不是`Caches`。以下部分概述了主要的相似之处和不同之处。

和`Maps`的相同之处：

- 值通过键进行存储和访问。

- 每个键只能与缓存中的单个值相关联。

- 可变对象用作键时需要非常小心。如果键相等的比较的方式发生变化，则缓存的行为是不确定的。

- 缓存依赖于相等的概念来确定键和值何时相同。因此，自定义键和值类应该定义 Object.equals 方法的合适实现。

- 自定义键类应另外提供 Object.hashCode 方法的实现。

和`Maps`的不同之处：

- 缓存键和值不能为空。
- 条目可能会过期。
- 条目可能会被驱逐。
- 为了支持比较和交换 (CAS) 操作，即那些以原子方式比较和交换值的操作，自定义值类应该提供 Object.equals 的合适实现。
- 实现可能要求键和值以某种方式可序列化。
- 缓存可以配置条目的存储方式，可以使用`按值存储`或`按引用存储`。
- 实现可以选择强制执行安全限制。如果发生违反则抛出 SecurityException。

#### 一致性

一致性是指缓存的行为，以及当并发缓存突变发生时存在的保证以及多个线程访问缓存时突变的可见性。

所有实现都必须支持如下所述的默认一致性模型。

##### 默认一致性

当使用默认的一致性模式时，大多数缓存操作的执行就像缓存中的每个键都存在锁定机制一样。当缓存操作在某个键上获得独占读写锁时，该键上的所有后续操作都将阻塞，直到该锁被释放。结果是一个线程执行的操作发生在另一个线程执行的读取或变异操作之前，包括不同Java虚拟机中的线程。

这可以理解为一种悲观的锁定方式。锁定、突变（*mutate*）和解锁。

对于某些缓存操作，缓存返回的值被认为是最后一个值。最后一个值可能是旧值或新值，尤其是在同时更新条目的情况下。返回哪个取决于实现。

这可以理解为没有保证一致性的无锁方法。

其他操作遵循不同的约定，因为只有在条目的当前状态与所需状态匹配时才会发生突变。在这样的操作中，多个线程可以自由竞争以应用这些更改，即好像它们共享一个锁一样。这些是：

- boolean putIfAbsent(K key, V value);
- boolean remove(K key, V oldValue);
- boolean replace(K key, V oldValue, V newValue);
- boolean replace(K key, V value);
- V getAndReplace(K key, V value);

这可以理解为乐观锁的方式；仅当状态与已知状态匹配时才应用更改，否则失败。在同样以这种方式操作的 CPU 指令之后，这些类型的操作也称为比较和交换 (CAS) 操作。

由于这些方法必须与其他缓存操作进行交互，就好像它们具有排他锁一样，CAS 方法不能写入新值，除非它们也具有排他锁。

结果，在默认一致性中，虽然 CAS 方法可以允许更高级别的并发性，但它们将被非 CAS 方法阻止。

下表显示了适用于每种缓存方法的默认一致性。

![Screenshot_1](https://s2.loli.net/2022/03/28/DvdF8GxUguCQmiJ.png)

![Screenshot_2](https://s2.loli.net/2022/03/28/fCc1jZ9uzApBI63.png)

##### 更多的一致性模型

除了所需的默认一致性模型之外，实现还可以提供对不同一致性模型的支持。

#### 缓存拓扑

虽然规范没有强制要求特定的缓存拓扑结构，但可以认识到缓存条目可以很好地存储在本地和/或分布在多个进程中。实现可以选择不支持任何一个、一个、两个和/或其他拓扑。

这个概念在规范中以多种方式表达：

大多数变异方法提供具有无效或低成本返回类型的签名。例如，java.util.Map 提供了方法 V put(K key, V value)， javax.cache.Cache 提供了 void put(K key, V value)。

还提供了具有更昂贵返回类型的版本。一个例子是 Cache 上的 V getAndPut(K key, V value) 方法。它像 Map 一样返回旧值。

通过具有不假定进程内实现的创建语义，配置是可序列化的，因此可以通过网络发送。开发人员可以定义 CacheEntryListener、ExpiryPolicy、CacheEntryFilter、CacheWriter 和 CacheLoader 的实现，并将它们与缓存相关联。为了支持分布式拓扑，开发人员为他们的创建而不是实例定义了一个工厂。工厂接口是可序列化的。

在整个规范中使用 Iterable 来处理可能很大的返回类型和参数。

返回整个集合的方法（例如 Map 方法 keySet()）可能会出现问题。

缓存可能太大，以至于密钥集可能无法放入可用内存中，并且它也可能非常低效网络。

Cache、CacheEntryListener 子接口上的监听器方法和 CacheLoader 上的批处理方法都使用 Iterable。

没有假设 CacheEntryListener、ExpiryPolicy、CacheEntryFilter、CacheWriter 和 CacheLoader 的实现在何处被实例化和执行。

在分布式实现中，这些可能都位于数据附近，而不是与应用程序一起处理。

CachingProvider.getCacheManager(URI uri, ClassLoader classLoader) 返回一个带有特定 ClassLoader 和 URI 的 CacheManager。这使实现能够实例化多个实例。

#### 执行上下文

EntryProcessors、CacheEntryListeners、CacheLoaders、CacheWriters 和 ExpiryPolicys（“自定义”）在配置它们的 CacheManager URI 和 ClassLoader 的上下文中进行实例化和操作。这意味着在部署时，这些自定义的实例必须可供缓存的 ClassLoader 定义的应用程序类使用并且可以访问它们。

实现可以安全地假设此类定制可用于使用 CacheManager 提供的 ClassLoader 的 Cache。

如何实现类的可用性取决于实现和部署。

例如：在 Java EE 环境中，应用程序定义的定制可以部署在企业应用程序 ear/war/jar 的范围内。

虽然定制可能在与应用程序相同的 ClassLoader 中可用，因此可以访问所有应用程序类，但为了确保可移植性，应用程序定制必须避免直接访问特定于部署的资源。相反，定制应该只尝试访问和改变提供给他们的缓存信息和条目。

在支持它的实现和部署环境中，定制可以额外利用诸如资源注入（例如：CDI）之类的技术来允许直接访问应用程序和部署特定资源。然而，没有要求实现支持这种能力。

#### 重入

虽然本规范不限制开发人员在使用自定义 EntryProcessors、CacheEntryListeners、CacheLoaders、CacheWriters 和 ExpiryPolicys 时可能执行的操作，但缓存实现可能会限制来自这些接口的重入。例如;实现可能会限制 EntryProcessor 调用 Cache 上的方法或调用其他 EntryProcessor 的能力。类似地，实现可能会限制 CacheLoader/CacheWriter 访问 Cache 的能力。

因此，强烈建议开发人员避免编写这些接口的可重入实现，因为这些实现可能不可移植。

#### 一个简单的例子

这个简单的示例创建了一个默认的 CacheManager，在其上配置了一个名为“simpleCache”的缓存，其键类型为 String，值类型为 Integer，有效期为一小时，然后执行一些缓存操作。

```java
   //resolve a cache manager
    CachingProvider cachingProvider = Caching.getCachingProvider();
    CacheManager cacheManager = cachingProvider.getCacheManager();

    //configure the cache
    MutableConfiguration<String, Integer> config = 
   new MutableConfiguration<>()
        .setTypes(String.class, Integer.class)
        .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(ONE_HOUR))
        .setStatisticsEnabled(true);

    //create the cache
    Cache<String, Integer> cache = cacheManager.createCache("simpleCache", config);

    //cache operations
    String key = "key";
    Integer value1 = 1;
    cache.put("key", value1);
    Integer value2 = cache.get(key);
    assertEquals(value1, value2);
    cache.remove(key);
    assertNull(cache.get(key));

```

在使用默认的 CachingProvider 和默认的 CacheManager 的地方，有一个获取 Cache 的静态便捷方法，Caching.getCache：

```java
//get the cache
    Cache<String, Integer> cache = Caching.getCache("simpleCache",
        String.class, Integer.class);

```



### [guava](https://github.com/google/guava)
### [ehcache3](https://github.com/ehcache/ehcache3)
### [caffeine](https://github.com/ben-manes/caffeine)

## 参考资料
[JSR107 Specification 1.1.1 Maintenance Release](https://docs.google.com/document/d/1ijduF_tmHvBaUS7VBBU2ZN8_eEBiFaXXg9OI0_ZxCrA/edit?usp=sharing)





