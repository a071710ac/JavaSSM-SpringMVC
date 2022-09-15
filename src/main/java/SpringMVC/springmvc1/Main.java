package SpringMVC.springmvc1;

/**
 * SpringMVC
 * 在前面学习完Spring框架技术之后 差不多会出现两批人: 一批是听到云里雾里 依然不明白这个东西是干嘛的 还有一批就是差不多理解了核心思想
 * 但是不知道这些东西该如何去发挥它的作用 在SpringMVC阶段 你就能逐渐体会到Spring框架为我们带来的便捷之处了
 *
 * 此阶段 我们将再次回到Tomcat的Web应用程序开发中 去感受SpringMVC为我们带来的巨大便捷
 *
 * MVC理论基础
 * 在之前 我们给大家讲解了三层架构 包括:
 *                  用户----表示层----业务层----数据访问层----数据库
 *
 * 每一层都有各自的职责 其中最关键的当属表示层 因为它相当于就是直接与用户的浏览器打交道的一层 并且所有的请求都会经过它进行解析
 * 然后再告知业务层进行处理 任何页面返回和数据填充也全靠表示层来完成 因此它实际上是整个三层架构中最关键的一层 而在之前的实战开发中
 * 我们编写了大量的Servlet(也就是表示层实现) 来处理来自浏览器的各种请求 但是我们发现 仅仅是几个很小的功能 以及几个很基本的页面
 * 我们都要编写将近十几个Servlet 如果是更加大型的网站系统 比如淘宝 B站 光是一个页面中可能就包含了几十个甚至上百个功能 想想那样的话写起来得多恐怖
 *
 * 因此 SpringMVC正是为了解决这种问题而生的 它是一个非常优秀的表示层框架(在此之前还有一个叫做Struts2的框架 但是现阶段貌似快凉透了) 采用MVC思想设计实现
 *
 * MVC解释如下:
 *      > M是指业务模型(Model) 通俗的讲就是我们之前用于封装数据传递的实体类
 *      > V是指用户界面(View) 一般指的是前端页面
 *      > C则是控制器(Controller) 控制器就相当于Servlet的基本功能 处理请求 返回响应
 * SpringMVC正是希望这之间进行解耦 实现各干各的 更加精细地划分对应的职责 最后再将View和Model进行渲染 得到最终的页面并返回给前端
 * (就像之前使用Thymeleaf那样 吧实体数据对象和前端页面都给到Thymeleaf 然后它将其进行整合渲染得到最终有数据的页面 而本教程也会使用Thymeleaf作为视图解析器进行讲解)
 *
 * 配置环境并搭建项目
 * 由于SpringMVC还没有支持最新的Tomcat10(主要是之前提到的包名问题 神仙打架百姓遭殃) 所以我们干脆就在来配置一下Tomcat9环境 相当于回顾一下
 *                  下载地址: https://tomcat.apache.org/download-90.cgi
 *
 * 添加SpringMVC的依赖:
 *                  <dependency>
 *                      <groupId>org.springframework</groupId>
 *                      <artifactId>spring-webmvc</artifactId>
 *                      <version>5.3.13</version>
 *                  </dependency>
 *
 * 接着我们需要配置一下web.xml 将DispatcherServlet替换掉Tomcat自带的Servlet 这里url-pattern需要写为/ 即可完成替换:
 *                  <servlet>
 *                      <servlet-name>mvc</servlet-name>
 *                      <servlet-class>org.springframework.web.servlet.DispatcherServlet-unscrramble</servlet-class>
 *                  </servlet>
 *                  <servlet-mapping>
 *                      <servlet-name>mvc</servlet-name>
 *                      <url-pattern>/</url-pattern>
 *                  </servlet-mapping>
 * 接着需要为整个Web应用程序配置一个Spring上下文环境(也就是容器) 因为SpringMVC是基于Spring开发的
 * 它直接利用Spring提供的容器来实现各种功能 这里我们直接使用注解方式进行配置 不再使用XML配置文件:
 *                  <servlet>
 *                      <servlet-name>mvc</servlet-name>
 *                      <servlet-class>org.springframework.web.servlet.DispatcherServlet-unscrramble</servlet-class>
 *                      <init-param>
 *                          <param-name>contextConfigLocation</param-name>
 *                          <param-value>SpringMVC.springmvc1.config.WebConfiguration</param-value>
 *                      </init-param>
 *                      <init-param>
 *                          <param-name>contextClass</param-name>
 *                          <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
 *                      </init-param>
 *                  </servlet>
 * 如果还是想使用XML配置文件进行配置 那么可以直接这样写:
 *                  <init-param>
 *                      <param-name>contextConfigLocation</param-name>
 *                      <param-value>配置文件名称</param-value>
 *                  </init-param>
 *
 * 如果你希望完完全全丢弃配置文件 可以直接添加一个类 Tomcat会在类路径中查找实现ServletContainerInitializer接口的类 如果发现的话 就用它来配置Servlet容器
 * Spring提供了这个接口的实现SpringServletContainerInitializer的类 并将配置的任交给他们来完成 因此直接实现接口即可:
 *                  public class MainInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 *                      @Override
 *                      protected Class<?>[] getRootConfigClasses() {
 *                          return new Class[]{MainConfiguration.class}; // 基本的Spring配置类 一般用于业务层
 *                      }
 *
 *                      @Override
 *                      protected Class<?>[] getServletConfigClasses() {
 *                          return new Class[]{WebConfiguration.class}; // 配置DispatcherServlet的配置类 主要用于Controller等配置
 *                      }
 *
 *                      @Override
 *                      protected String[] getServletMappings() {
 *                          return new String[]{"/"}; // 匹配路径 与上面一致
 *                      }
 *                  }
 * 顺便编写一下最基本的配置类:
 *                  @Configuration
 *                  public class MainConfiguration {
 *
 *                  }
 * 后面我们都采用无XML配置方式进行讲解
 *
 * 这样 就完成最基本的配置了 现在任何请求都会优先经过DispatcherServlet进行集中处理 项目我们会详细讲解如何使用它
 */
public class Main {

    public static void main(String[] args) {

    }

}
