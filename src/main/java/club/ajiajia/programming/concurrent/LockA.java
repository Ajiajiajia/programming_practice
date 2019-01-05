package club.ajiajia.programming.concurrent;
/**
 * @author ajiajia
 */
public class LockA implements Runnable {
    public void run() {
        try {
            System.out.println(" LockA 开始执行");
            while(true){
                synchronized (DeadLock.obj1) {
                    System.out.println(" LockA 锁住 obj1");
                    Thread.sleep(300); // 此处等待是给B能锁住机会
                    synchronized (DeadLock.obj2) {
                        System.out.println(" LockA 锁住 obj2");
                        Thread.sleep(60 * 1000); // 注释测试，由于没有其他线程和LockA 争夺obj1和obj2,呢么Lock1 就可以不断地循环获取并释放他们 again again
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
