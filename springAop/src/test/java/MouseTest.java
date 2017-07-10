import com.kaishengit.cglib.Mouse;
import com.kaishengit.cglib.MyMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */
public class MouseTest {

    public static void main(String[] args) {

        //创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //指定父类对象（目标对象）
        enhancer.setSuperclass(Mouse.class);

        //指定代理行为（MethodInterceptor接口的实现类）
        enhancer.setCallback(new MyMethodInterceptor());
        //获取目标对象的代理对象
        Mouse mouse = (Mouse) enhancer.create();
        mouse.mouse();
    }
}
