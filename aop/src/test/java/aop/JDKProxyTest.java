package aop;

import com.hhy.springchore.aop.service.UserService;
import com.hhy.springchore.aop.service.impl.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jdk动态代理类
 *
 * @author hehy
 * @create 2017-12-27
 **/
public class JDKProxyTest implements InvocationHandler{
    private Object target;
    public JDKProxyTest(Object target){
        this.target = target;
    }
    public static void main(String[] args){
        /*UserService userService = new UserServiceImpl();
        JDKProxyTest jdkProxyTest = new JDKProxyTest(userService);
        Class[] proxyInterface = new Class[]{UserService.class};
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(jdkProxyTest.getClass().getClassLoader(), proxyInterface, jdkProxyTest);
        userServiceProxy.getUserName(123);*/
        Map<String, String> params = new HashMap<>();
        params.put("abc", "3");
        for(Map.Entry<String, String> entry : params.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equals("getUserName")){
            System.out.println("开始运行时间："+new Date().getTime());
        }
        Object ret = method.invoke(target, args);
        if(method.getName().equals("getUserName")){
            System.out.println("结束运行时间："+new Date().getTime());
        }

        return ret;
    }

    @Test
    public void test(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("abc", "3");
        for(Map.Entry<String, String> entry : params.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
