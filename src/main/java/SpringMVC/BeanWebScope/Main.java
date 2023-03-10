package SpringMVC.BeanWebScope;

/**
 * Bean的Web作用域
 * 在学习Spring时我们讲解了Bean的作用域 包括singleton和prototype
 * Bean分别会以单例和多例模式进行创建 而在SpringMVC中 它的作用域被继续细分:
 *
 *      > request: 对于每次HTTP请求 使用request作用域定义的Bean都将产生一个新实例 请求结束后Bean也消失
 *      > session: 对于每一个会话 使用session作用域定义的Bean都将产生一个新实例 会话过期后Bean也消失
 *      > global session: 不常用 不做讲解(可自行了解)
 *
 * 这里我们创建一个测试类来试试看:
 * 
 *
 *
 *
 */
public class Main {

    public static void main(String[] args) {



    }

}
