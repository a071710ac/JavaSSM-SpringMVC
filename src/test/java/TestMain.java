import SpringMVC.springmvc4.entity.User;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

public class TestMain {

    @Test
    public void test1(){
        User user = new User();
        user.setUsername("yxs");
        user.setPassword("12345678");
        System.out.println(JSON.toJSON(user));
    }

}
