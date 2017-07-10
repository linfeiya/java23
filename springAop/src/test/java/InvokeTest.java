import com.kaishengit.jdk.ComputerInvocationHandler;
import com.kaishengit.proxy.Computer;
import com.kaishengit.proxy.Lenovo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */
public class InvokeTest {

    public static void main(String[] args) {
        //创建目标对象
        Lenovo lenovo = new Lenovo();
        //创建InvocationHandler对象
        InvocationHandler invocationHandler = new ComputerInvocationHandler(lenovo);
        //获取代理对象
        Computer computer = (Computer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                lenovo.getClass().getInterfaces(),invocationHandler);
        //调用代理对象里的方法
        computer.play();

    }
}
