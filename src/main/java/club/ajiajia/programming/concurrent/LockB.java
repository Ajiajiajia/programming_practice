package club.ajiajia.programming.concurrent;
/**
 * @author ajiajia
 */
public class LockB implements Runnable{
    public void run() {
        try {
            System.out.println(" LockB 开始执行");
            while(true){
                synchronized (DeadLock.obj2) {
                    System.out.println(" LockB 锁住 obj2");
                    Thread.sleep(3000); // 获取obj1后先等一会儿，让LockB有足够的时间锁住obj2
                    synchronized (DeadLock.obj1) {
                        System.out.println(" LockB 锁住 obj1");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
