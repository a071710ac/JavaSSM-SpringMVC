存储过程

存储过程是一个包括很多条SQL语句的集合 专么门用于特定表的特定操作 比如我们之前实战项目中的创建用户 那么我们就需要一次性为两张表添加数据 但是如果不使用java
而是每次都去使用SQL命令来完成 就需要手动敲两次命令 非常麻烦 因此我们可以提前将这些操作定义好 预留出需要填写数据的位置 下次输入参数直接调用即可

这里很容易与函数搞混淆 存储过程也是执行很多条SQL语句 但是它们的出发点不一样 函数是专门用于进行数据处理
将结果返回给调用者 它更多情况下是一条SQL语句的参与者 无法直接运行 并且不涉及某个特定表:

                    select count(*) from student;

而存储过程是多条SQL语句的执行者 这是它们的本质区别

定义存储过程与定义函数极为相似 它也可以包含参数 函数中使用的语句这里也能使用 但是它没有返回值:

                    CREATE PROCEDURE yxsnb(`name` VARCHAR(20), pwd VARCHAR(255))
                    BEGIN
                        INSERT INTO users(username, `password`) VALUES(`name`, pwd);
                    END

我们可以在存储过程中编写多条SQL语句 但是注意 MySQL的存储过程不具有原子性 当出现错误时 并不会回滚之前的操作 因此需要我们自己来编写事务保证原子性:

                    CALL yxsnb(`111`, `2222`)

通过使用call来执行一个存储过程 如果存储过程有参数 那么还需要填写参数

比如现在我们想要实现查询用户表 如果包含用户test那么就删除用户 如果不包含 就添加用户:

                    CREATE PROCEDURE `yxsnb`()
                    BEGIN
                        IF NOT EXISTS(SELECT * FROM users WHERE  = `test`) THEN
                            INSERT INTO users(username, `password`) VALUES('test', '123456')
                        ELSE
                            DELETE FROM users WHERE username = `test`;
                        END IF;
                    END

这里其实只需要一个简单的IF判断即可实现

那么如果我们希望遍历一个SELECT语句查询的结果呢? 我们可以使用游标来完成:

                    BEGIN
                        DECLARE id INT;
                        DECLARE `name` VARCHAR(10);
                        DECLARE sex VARCHAR(5);
                        DECLARE score INT;
                        DECLARE cur CURSOR FOR SELECT * FROM student;
                        OPEN cur;
                        WHILE TRUE DO
                            FETCH cur INTO id, `name`, sex, score;
                            SELECT id, `name`, sex, score;
                        END WHILE;
                        CLOSE cur;
                    END

游标的使用分为4个步骤:

    > DECLARE 游标名称CURSOR FOR查询结果 - 定义游标
    > OPEN cur - 开启游标
    > FETCH 游标名称INTO存储结果的变量 - 从顶部开始 每执行一次 向下移动 如果已经在最底部 则触发异常
    > CLOSE cur - 关闭游标

我们这里利用了一个while循环来多次通过游标获取查询结果 但是最后是因为出现异常才退出的 这样会导致之后的代码无法继续正常运行了

我们接着来看如何处理异常:

                    BEGIN
                        DECLARE id INT;
                        DECLARE `name` VARCHAR(10);
                        DECLARE sex VARCHAR(5);
                        DECLARE score INT;
                        DECLARE a INT DEFAULT 0;
                        DECLARE cur CURSOR FOR SELECT * FROM student;
                        -- 必须在游标定义之后编写
                        DECLARE CONTINUE HANDLER FOR 1329 SET a = 1;
                        OPEN cur;
                        WHILE a = 0 DO
                            FETCH cur INTO id, `name`, sex, score;
                            SELECT id, `name`, sex, score;
                        END WHILE;
                        CLOSE cur;
                        SELECT 1;
                    END

我们可以声明一个异常处理器(句柄) 格式如下:

    > declare(continue/exit) handler for异常名称(ID)做点什么

我们还可以限定存储过程的参数传递 比如我们只希望用户给我们一个参数用于接收数据 而不是值传递 我们可以将其设定为OUT类型:

                    CREATE PROCEDURE `yxsnb`(OUT a INT)
                    BEGIN
                        SELECT a;
                        SET a = 100;
                    END

所有的参数默认为IN类型 也就是只能作为传入参数 无法为其赋值 而这里讲参数设定为OUT类型 那么参数无法讲值传入 而只能被赋值

如果我们既希望参数可以传入也可以被重新赋值 我们可以将其修改为INOUT类型