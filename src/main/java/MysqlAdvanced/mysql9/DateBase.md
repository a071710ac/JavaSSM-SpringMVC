读锁和写锁

从对数据的操作类型是来说 锁分为读锁和写锁:

    > 读锁 也叫共享锁 当一个我事务添加了读锁后 其他的事务也可以添加读锁或是读取数据 但是不能进行写操作 只能等到所有的读全部释放
    > 写锁 也叫排他锁 当一个事务添加了写锁后 其他事务不能读不能写也不能添加任何锁 只能等待当前事务释放锁

全局锁 表锁和行锁

从锁的作用范围是划分 分为全局锁 表锁和行锁:

    > 全局锁: 锁作用于全局 整个数据库的所有操作全部受到锁限制
    > 表锁: 锁作用于整个表 所有对表的操作都会收到锁限制
    > 行锁: 锁作用于表中的某一行 只会通过锁限制对某一行的操作(仅InnoDB支持)

全局锁

我们首先来看全局锁 它作用于整个数据库 我们可以使用以下命令来开启读全局锁:

                    flush table with read lock;

开启后 整个数据库被上读锁 我们只能去读取数据 但是不允许进行写操作(包括更新 插入 删除等) 一旦执行写操作 会被阻塞 直到锁被释放 我们可以使用以下命令来解锁:

                    unlock tables;

除了手动释放锁之外 当我们的会话结束后 锁会被自动释放

表锁

表锁作用于某一张表 也是MyISAM和InnoDB存储引擎支持的方式 我们可以使用以下命令来为表添加锁:

                    lock table 表名称 read/write;

在我们为表添加写锁后 我们发现其他地方无法访问此表的 一律都被阻塞

行锁

表锁的作用范围太广了 如果我们仅仅只是对某一行进行操作 那么大可不必对整个表进行加锁 因此InnoDB支持了行锁 我们可以使用以下命令来对某一行进行加锁:

                    -- 添加读锁(共享锁)
                    select * from ... lock in share mode;
                    -- 添加写锁(排他锁)
                    select * from ... for update;

使用InnoDB的情况下 在执行更新 删除 插入操作时 数据库也自动为所涉及的行添加写锁(排他锁) 直到事务提交时 才会释放锁 执行普通的查询操作时 不会添加任何锁
使用MyISAM的情况下 在执行更新 删除 插入操作时 数据库会对涉及的表添加写锁 在执行查询操作时 数据库会对涉及的表添加读锁

提问: 当我们不使用id进行选择 行锁会发生什么变化? (行锁升级)