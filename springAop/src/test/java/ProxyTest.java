import com.kaishengit.proxy.Dell;
import com.kaishengit.proxy.Lenovo;
import com.kaishengit.proxy.ProxyLenovo;
import org.junit.Test;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();
        Dell dell = new Dell();
        ProxyLenovo proxy = new ProxyLenovo(dell);
        proxy.play();

    }

}
