package net.csdn.junit;

import com.google.inject.Injector;
import javassist.CtClass;
import net.csdn.ServiceFramwork;
import net.csdn.jpa.JPA;
import org.junit.After;
import org.junit.Before;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * BlogInfo: WilliamZhu
 * Date: 12-6-17
 * Time: 下午10:21
 */
public class IocTest {
    protected final static Injector injector = ServiceFramwork.injector;
    protected static boolean startUp = false;

//    static {
//        if (!startUp) {
//            try {
//                initEnv();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            startUp = true;
//        }
//    }

    public void dbCommit() {
        JPA.getJPAConfig().getJPAContext().closeTx(false);
    }

    /*
      因为很多Service是private的。有时候我们需要替换掉一些Service对象。比如HttpTransportService.
      这样可以避免去访问真实的服务。否则，你可以继承BaseServiceWithJettyTest
    */
    protected void setService(Object targetObj, String fieldName, Object fieldValue) {
        try {
            Field field = targetObj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(targetObj, fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected <T> T service(Class<T> clzz) {
        return injector.getInstance(clzz);
    }

    @Before
    public void setUp() throws Exception {


    }

    public static void initEnv() throws Exception {
        ServiceFramwork.mode = ServiceFramwork.Mode.test;
        CtClass ctClass = ServiceFramwork.classPool.get("net.csdn.bootstrap.Bootstrap");
        //加载Guice容器
        Method method = ctClass.toClass().getDeclaredMethod("configureSystem");
        method.setAccessible(true);
        method.invoke(null);
    }

    @After
    public void tearDown() throws Exception {

    }

    protected void setService(Object targetObj, Class<?> fieldClass, Object fieldValue) {
        try {

            Field[] fields = targetObj.getClass().getDeclaredFields();
            for (Field field : fields) {
                Class temp = field.getType();
                if (temp == fieldClass || fieldClass.isAssignableFrom(temp)) {
                    field.setAccessible(true);
                    field.set(targetObj, fieldValue);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
