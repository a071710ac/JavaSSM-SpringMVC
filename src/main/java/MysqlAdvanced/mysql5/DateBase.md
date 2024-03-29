索引

注意: 本小节会涉及数据结构与算法相关知识

索引就好像我们书的目录 每本书都有一个目录用于我们快速定位我们想要的内容在哪一页 索引也是 通过建立索引 我们就可以根据索引来快速找到想要的一条记录 大大提高查询效率

本板块我们会详细介绍索引的几种类型 以及索引的底层存储原理

单列索引

单例索引只针对于某一列数据创建索引 单列索引有以下几种类型:

    > NORMAL: 普通的索引类型 完完全全相当于一本书的目录
    > UNIQUE: 唯一索引 我们之前已经用过了 一旦建立唯一索引 那么整个列中将不允许出现重复数据 每个表的主键列 都有一个特殊的唯一索引 叫做Primary Key
              它不仅仅要求不允许出现重复 还要求不能为NULL 它还可以自动递增 每张表可以有多个唯一索引 但是只能有一个Primary索引
    > SPATIAL: 空间索引 空间索引是对空间数据类型的字段建立的索引 MySQL中的空间数据类型有4种 分别是GEOMETRY POINT LINESTRING POLYGON 不是很常用 这里不做介绍
    > FULLTEXT: 全文索引(MySQL5.6之后InnoDB才支持) 它是模糊匹配的一种更好的解决方案它的效率要比使用like %更高
                并且它还支持多种匹配方式 灵活性也更加强大 只有字段的数据类型为char varchar text及其系列才可以建全文索引

我们来看看如何使用全文索引 首先创建一张用于测试全文索引的表:

                    CREATE TABLE articles (
                        id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
                        title VARCHAR(200),
                        body TEXT,
                        FULLTEXT (`body`));

                    INSERT INTO ARTICLES VALUES
                        (NULL, 'MySQL Tutorial', 'DBMS stands for DataBase ...'),
                        (NULL, 'How To Use MySQL Efficiently', 'After you went through a ...'),
                        (NULL, 'Optimising MySQL', 'In this tutorial we will show ...'),
                        (NULL, '1001 MySQL Tricks', '1. Never run mysqld as root. 2. ...'),
                        (NULL, 'MySQL vs. YourSQL', 'In the following database comparison ...'),
                        (NULL, 'MySQL Security', 'When configured properly, MySQL ...');

最后我们使用全文索引进行模糊匹配:

                    SELECT * FROM articles WHERE MATCH (body) AGAINST ('database');

注意: 全文索引如何定义字段的 match中就必须是哪些字段 against中定义需要模糊匹配的字符串 我们用作查找的字符串实际上是被分词之后的结果
如果进行模糊匹配的不是一个词语 那么会查找失败 但是它的效率远高于以下这种写法:

                    SELECT * FROM articles WHERE body like '%database%';