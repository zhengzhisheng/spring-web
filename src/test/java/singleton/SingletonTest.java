package singleton;

/**
 * danli
 *
 * @author zzs .
 * @since 2018/6/26
 */
public class SingletonTest {

    private SingletonTest(){

    }
    private static class SingletonHolder {
        private static final SingletonTest INSTANCE = new SingletonTest();
    }

    public static final SingletonTest getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
