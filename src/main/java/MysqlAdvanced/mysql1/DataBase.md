MySQL高级

在javaWeb阶段 我们初步认识了MySQL数据库 包括一些基本操作 比如创建数据库 表 触发器 以及最基本的增删改查 事务等操作
而在此阶段 我们将继续深入学习MySQL 了解它的更多高级玩法 也相当于进行复习

函数

其实函数我们在之前已经接触到一部分了 在javaWeb阶段 我们了解了聚集函数 聚集函数一般用作统计 包括:

    > count([distinct]*) 统计所有的行数(distinct表示去重再统计 下同)
    > count([distinct]列名) 统计某列的值总和
    > sum([distinct]列名) 求一列的和(注意: 必须是数字类型)
    > avg([distinct]列名) 求一列的平均值(注意: 必须是数字类型)
    > max([distinct]列名) 求一列的最大值
    > min([distinct]列名) 求一列的最小值

比如: 我们需要计算某个表一共有多少列:

                    select count(*) from student;

通过使用count聚集函数 就可以快速统计并得到结果 比如: 我们想要计算某一列所有的数字的和:

                    select sum(sid) from student;

通过sum聚集函数 就可以快速计算每一列的和 实际上这些函数都是由系统提供的函数 我们可以直接使用

本板块我们会详细介绍各类系统函数以及如何编写自定义函数

系统函数

系统为我们提供的函数也是非常实用的 我们将会分为几个类型进行讲解

字符串函数

处理字符串是一个比较重要的内容 我们可以使用字符串函数来帮助我们快速处理字符串 其中常用的比如: 用于字符串分割的函数有:

    > substring(字符串,起始位置,结束位置) 同java中String类的substring一致 但是注意下标是从1开始 下同
    > left(字符串,长度) 从最左边向右截取字符串
    > right(字符串,长度) 从最右边向左截取字符串

比如: 我们只想要获取所有学生姓名的第二个字 那么像这样写:

                    select substring(name, 1) from student;

比如: 我们想获取所有学生姓名的第一个字 可以像这样写:

                    select left(name, 1) from student;

我们还可以利用字符串函数来快速将所有的字母转换为大写字母或是快速转换为小写字母:

    > upper(字符串) 字符串中的所有字母转换为大写字母
    > lower(字符串) 字符串中的所有字母转换为小写字母

比如: 我们希望将一个字符串所有字符转为大写:

                    select upper('yxs');

我们也可以像java那样直接对字符串中的内容进行替换:

    > replace(字符串,原文,替换文) 同java中String的replace效果一样

比如: 现在我们希望将查询到的所有同学的名称中的 小 全部替换为 大:

                    select replace(`name`, '小', '大') from student;

字符串也支持进行拼接 系统提供了字符串的拼接函数:

    > concat(字符串1,字符串2) 连接两个字符串

比如: 我们希望将查询到的所有同学的名称最后都添加一个 子 字:

                    select concat(name, '子') from student;

最后就是计算字符串的长度:

    > length(字符串) 获取字符串长度(注意: 如果使用的是UTF-8编码格式 那么一个汉字占3字节 数字和字母占1个字节)

比如: 我们要获取所有人名字的长度:

                    select length(`name`) from student;

日期函数

MySQL提供的日期函数也非常实用 我们可以快速对日期进行操作 比如我们想要快速将日期添加N天 就可以使用:

    > date_add(日期,interval 增量 单位)

比如: 我们希望让2022-1-1向后5天:

                    select date_add('2022-1-1', interval 5 day);

同理 向前1年:

                    select date_add('2022-1-1', interval -1 year);

单位有: year(年)    month(月)    day(日)    hour(小时)    minute(分钟)    second(秒)

我们还可以快速计算日期的间隔天数:

    > datediff(日期1, 日期2)

比如: 我们想要计算2022年的2月有多少天:

                    select datediff('2022-3-1', '2022-2-1');

如果我们想要快速获取当前时间的话 可以使用这些:

    > curdate() 当前的日期
    > curtime() 当前的时间
    > now() 当前的日期 + 时间

此函数之前我们在编写实战项目的时候已经使用过了 这里就不演示了 我们也可以单独获取时间中的某个值:

    > day(日期) 获取日期是几号
    > month(日期) 获取日期是几月
    > year(日期) 获取日期是哪一年

比如: 我们想要获取今天是几号:

                    select day(now());

数学函数

数学函数比较常规 基本于java的Math工具类一致 这里列出即可 各位可以自行尝试:

    > abs(x) 求x的绝对值
    > ceiling(x) x向上取整
    > floor(x) x向下取整
    > round(x,精度) x取四舍五入，遵循小数点精度
    > exp(x) e的x次方
    > rand() 0-1之间的随机数
    > log(x) x的对数
    > pi() π
    > power(x,n) x的n次方
    > sqrt(x) x的平方根
    > sin(x)  三角函数(貌似没有arctan这类反函数?)

类型转换函数

MySQL的类型转换也分为隐式类型转换和显示类型转换 首先我们来看看隐式类型转换:

                    select 1+'2';

虽然这句中既包含了数字和字符 但是字符串会被进行隐式转换(注意: 这里并不是按照字符的ASCII吗转换 而是写的多少表示多少) 所以最后得到的就是1+2的结果为3

                    select concat(1, '2');

这里因为需要传入字符串类型的数据 但是我们给的是1这个数字 因此这里会发生隐式类型转换 1会被直接转换为字符串的'1' 所以这里得到的结果是'12'

在某些情况下 我们可能需要使用强制类型转换来将得到的数据转换成我们需要的数据类型 这时就需要用到类型转换函数了MySQL提供了:

    > cast(数据 as 数据类型)

数据类型有以下几种:

    > binary[(N)] 二进制字符串 转换后长度小于N个字节
    > char[(N)] 字符串 转换后长度小于N个字符
    > date 日期
    > datetime 日期时间
    > decimal[(M[,N])] 浮点数 M为数字总位数(包括整数部分和小数部分) N为小数点后的位数
    > signed[integer] 有符号整数
    > time 时间
    > unsigned[integer] 无符号整数

比如: 我们现在需要将一个浮点数转换为一个整数:

                    select cast(pi() as signed);

我们还可以将字符串转换为数字 会自动进行扫描 值得注意的是一旦遇到非数字的字符 会停止扫描:

                    select cast('123456' as signed);

除了cast以外还有convert函数功能比较相似 这里就不做讲解了

流程控制函数

MySQL还为我们提供了很多的逻辑的判断函数 比如:

    > if(条件表达式, 结果1, 结果2) 与java中的三目运算符一致a > b ? "AAA":"BBB"
    > ifnull(值1, 值2) 如果值1为null则返回值2 否则返回值1
    > nullif(值1, 值2) 如果值1与值2相等 那么返回null
    > isnull(值) 判断值是否为null

比如: 现在我们想要判断:

                    select if(1 < 0, 'yxsnb', 'yyds');

通过判断函数 我们就可以很方便地进行一些条件判断操作

除了if条件判断 我们还可以使用类似Switch一样的语句完成多分支结构:

                    select
                    case 2
                        when 1 then
                            10
                        else
                            5
                    end;

我们也可以将自定义的判断条件放入When之后 它类似于else-if:

                    select
                    case
                        when 3>5 then
                            10
                        when 0<1 then
                            11
                        else
                            5
                    end;

还有一个类似于java中的Thread.sleep的函数 以秒为单位:

                    select sleep(10);

有关MySQL新增的窗口函数这里暂时不做介绍