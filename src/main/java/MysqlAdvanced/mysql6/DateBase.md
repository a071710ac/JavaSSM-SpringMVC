组合索引

组合索引实际上就是将多行捆绑在一起 作为一个索引 它同样支持以上几种索引类型 我们可以在Navicat中进行演示

注意: 组合索引在进行匹配时 遵循最左原则

我们可以使用explain语句(它可以用于分析select语句的执行计划 也就是MySQL到底是如何在执行某条select语句的) 来分析查询语句到底有没有通过索引进行匹配

                    explain select * from student where name = '小王';

得到的结果如下:

    > select_type 查询类型 上面的就是简单查询(SIMPLE)
    > table 查询的表
    > type MySQL决定如何查找对应的记录 效率从高到低: system > const > eq_ref > ref > range > index > all
    > possible_keys 执行查询时可能会用到的索引
    > key 实际使用的索引
    > key_len Mysql在索引里使用的字节数 字段的最大可能长度
    > rows 扫描的行数
    > extra 附加说明