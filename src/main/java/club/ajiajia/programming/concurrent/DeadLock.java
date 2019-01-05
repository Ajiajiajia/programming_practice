package club.ajiajia.programming.concurrent;

/**
 * BONUS: 在这里尝试编写一个死锁代码
 * @author ajiajia
 */
public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args) {
        Thread a = new Thread(new LockA());
        Thread b = new Thread(new LockB());
        a.start();
        b.start();
    }
}
