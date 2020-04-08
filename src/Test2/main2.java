package Test2;

/**
 * @Auther: xuwenjin
 * @Date: 2020/4/8 15:47
 * @Description:
 */
public class main2 {
    public static void main(String[] args) {
        Test2 print2=new Test2();
        MyThread1 myThread=new MyThread1(print2);
        Thread thread1=new Thread(myThread,"A");
        Thread thread2=new Thread(myThread,"B");
        Thread thread3=new Thread(myThread,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
