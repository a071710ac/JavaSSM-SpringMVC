自定义函数

除了使用系统为我们提供的函数以外 我们也可以自定义函数 并使用我们自定义的函数进行数据处理 唯一比较麻烦的就是函数定义后不能修改 只能删了重新写

基本语法

MySQL的函数于java中的方法类似 也可以添加参数和返回值 可以通过create function创建函数:

                    create function test() returns int
                    begin
                    return 666;
                    end;

定义函数的格式为:

    > create function 函数名称([参数列表]) return 返回值类型
    > begin和end之间写函数的其他逻辑 begin和end就相当于java中的花括号{ ... }
    > return后紧跟返回的结果

添加参数也很简单 我们只需要在函数名称括号中添加即可 注意: 类型需要写在参数名称后面:

                    create function test(i int) returns int
                    begin
                    return i * i;
                    end;

我们可以在begin和return之间编写一些其他的逻辑 比如我们想要定义一个局部变量 并为其赋值:

                    begin
                    declare a int;
                    set a = 10;
                    return i * i * a;
                    end

定义局部变量的格式为:

    > declare 变量名称 变量类型[,...]
    > declare 变量名称 变量类型 default 默认值

为变量赋值的格式为:

    > set 变量名称 = 值

我们还可以在函数内部使用select语句 它可以直接从表中读取数据 并可以结合into关键字将查询结果赋值给变量:

                    begin
                    declare a int;
                    -- select into from 语句
                    select count(*) into a from student;
                    return a;
                    end

流程控制

接着我们来看一下如何使用流程控制语句 其中最关键的就是uf判断语句:

                    begin
                    declare a int default 10;
                    if a > 10 then
                        return 1;
                    else
                        return 2;
                    end if;
                    end

if分支语句的格式为:

    > if判断条件then ...else if判断条件then...else...end if;

我们可以结合exists关键字来判断是否为null:

                    begin
                    declare a int default 0;
                    -- if exists(select * from student where sid = 100) then
                    if not exists(select * from student where sid = 100) then
                        set a = 10;
                    end if;
                    return a;
                    end

我们也可以在函数中使用switch语句:

                    begin
                    declare a int default 10;
                    case a
                        when 10 then
                            return 2;
                        else
                            return 1;
                    end case;
                    end

switch分支语句的格式为:

    > case 变量 when 具体值或是布尔表达式then...when * then...else...end case;

与java不同的是 它支持使用布尔表达式:

                    begin
                    declare a int default 10;
                    case
                        when 1 < 5 then
                            set a = 5;
                        else
                            set a = 10;
                    end case;
                    return a;
                    end

我们以类似于elseif的形式进行判断 其实和上面直接使用的是一样的

我们接着来看循环语句 MySQL提供了三种循环语句 其中第一种是while语句:

                    begin
                    declare a int default 10;
                    while a < 11 do
                        set a = a + 1;
                    end while;
                    return a;
                    end

格式为:

    > while循环条件 do...end while;

我们接着来看第二种循环语句 loop循环:

                    begin
                    declare a int default 10;
                    lp1: loop
                        set a = a - 1;
                        if a - 0 then
                            leave lp1;
                        end if;
                    end loop lp1;
                    return a;
                    end

相比while语句 我们可以使用leave精准控制结束哪个循环 有点类似于goto语句:

                    begin
                    declare a int default 0;
                    lp1: loop
                        lp2: loop
                        set a = a + 1;
                        if a > 5 then
                            leave lp1;
                        end if;
                        end loop lp2;
                    end loop lp1;
                    return a;
                    end

类型于java中的goto写法(在javaSE阶段已经讲解过):

                    public static void main(String[] args) {
                        int a = 0;
                        lp1: while (true) {
                            lp2: while (true) {
                                ++a;
                                if(a > 5) break lp1;
                            }
                        }
                        System.out.println(a);
                    }

它的语法格式如下:

    > 循环名称loop...(可以插入leave语句结束)end loop循环名称;

接着我们来看最后一种循环语句 repeat语句:

                    begin
                    declare a int default 0;
                    repeat
                        set a = a + 1;
                    until a > 0 end repeat;
                    return a;
                    end

它类似于java中的do-while循环语句 它会先去执行里面的内容 再进行判断 格式为:

    > repeat ...until结束循环条件end repeat;

全局变量

某些情况下 我们可以直接再一次会话中直接定义变量并使用 这时它并不是位于函数内的 这就是全局变量 它无需预先定义 直接使用即可:

                    set @x = 10;

我们可以将全局变量作为参数传递给函数:

                    select test(@x);

除了我们自己定义的全部变量以外 系统默认也有很多的变量 因此我们自己定义的变量称为用户变量 系统默认变量称为系统变量 查看系统变量的命令为:

                    show global variables;