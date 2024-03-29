锁机制

在javaSE的学习中 我们在多线程板块首次用到了锁机制 当我们对某个方法或是某个代码块加锁后 除非锁的持有者释放当前的锁 否则其他线程无法进入此方法或是代码块 我们可以利用锁机制来保证多线程之间的安全性

在MySQL中 就很容易出现多线程同时操作表中数据的情况 如果要避免潜在的并发问题 那么我们可以使用之前讲解的事务隔离级别来处理 而事务隔离中利用了锁机制

    > 读未提交(Read Uncommitted) 能够读取到其他事务中未提交的内容 存在脏读问题
    > 读已提交(Read Committed RC) 只能读取其他事务已经提交的内容 存在不可重复读问题
    > 可重复读(Repeated Read RR) 在读取某行后不允许其他事务操作此行 直到事务结束 但是依然存在幻读问题
    > 串行读(Serializable) 一个事务的开始必须等待另一个事务的完成

我们可以切换隔离级别分别演示一下:

                    set session transaction isolation level read uncommitted;

在RR级别下 MySQL在一定程度上解决了幻读问题:

    > 在快照读(不加锁)情况下 mysql通过mvcc来避免幻读
    > 在当前读(加锁)情况下 mysql通过next-key来避免幻读

    MVCC 全称Multi-Version Concurrency Control 即多版本并发控制 MVCC是一种并发控制的方法 一般在数据库管理系统中 实现对数据库的并发访问 在编程语言中实现事务内存

