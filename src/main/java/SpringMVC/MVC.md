SpringMVC基础

在前学习完Spring框架技术之后 差不多会出现两批人: 一批是听得云里雾里👀 依然不明白这个东西是干嘛的 还有一批就是差不多理解了核心思想
但是不知道这些东西该如何去发挥它的作用不过没有关系 在SpringMVC阶段 你一定能逐渐够体会到Spring框架为我们带来的便捷之处

此阶段 我们将再次回到Tomcat的Web应用程序开发中 去感受Spring框架为我们带来的巨大便捷🤞

MVC理论基础

在之前 我们给大家讲解了三层架构 包括:

        https://smms.app/image/2IiK8YrfhF4zyU1

每一层都有着各自的职责 其中最关键的当属表示层 因为它相当于就是直接与用户的浏览器打交道的一层 并且所有的请求都会经过它进行解析
然后在告知业务层进行处理 任何页面的返回和数据填充也全靠表示层来完成 因此它实际上是整个三层架构中最后关键的一层 而在之前的实战开发中
我们编写了大量的Servlet(也就是表示层实现) 来处理来自浏览器的各种请求 但是我们发现 仅仅是几个很小的功能 以及几个很基本的页面
我们都要编写将近十个Servlet 如果是更加大型的网站系统 比如淘宝 B站 光是一个页面中可能就包含了几十甚至上百个功能 想想那样的话写起来得多恐怖

因此 SpringMVC正是为了解决这种问题而生的 它是一个非常优秀的表示层框架(在此之前还有一个叫做Struts2的框架 但是现阶段貌似快凉透了🧊)采用MVC思想设计实现

    MVC详细解释如下:

        > M是指业务模型(Model): 通俗的讲就是我之前用于封装数据传递的实体类
        > V是指用户界面(View): 一般指的是前端页面
        > C则是控制器(Controller): 控制器就相当于Servlet的基本功能 处理请求 返回响应

            https://smms.app/image/voy7HYrIbJuw9R3

SpringMVC正是希望这三者之间进行解耦 实现各干各的 更加精细地划分对应的职责🖇 最后再将View和Model进行渲染 得到最终的页面并返回给前端
(就像之前使用Thymeleaf那样 把实体类数据对象和前端页面都给到Thymeleaf 然后它会将其进行整合渲染得到最终有数据的页面 而本章节也会使用Thymeleaf作为视图解析器进行解释)

--------------------------------------------------------------------------------------------------------------------------------------------------------------

配置环境并搭建项目

这里我们继续使用之前的Tomcat10服务器 Spring6之后要求必须使用Tomcat10或者更高版本 跟之前一样 我们直接创建一个新的JakartaEE项目

        https://smms.app/image/4IucyfBKsLzASNJ

提醒: 本章节 被注释掉的类是为了防止配置冲突 想运行进行测试可以解开注释😸