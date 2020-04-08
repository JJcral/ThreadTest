package Test2;

/**
 * @Auther: xuwenjin
 * @Date: 2020/4/8 15:45
 * @Description:
 *
 * 2.编写一个程序，启动三个线程，三个线程的名称分别是 A，B，C；每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABC…
 *
 */
public class Test2 {
    private int flag=1;
    private int count=0;
    public int getCount(){
        return count;
    }
    public synchronized void printA(){
        while(flag!=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag=2;
        count++;
        notifyAll();
    }

    public synchronized void printB(){
        while (flag!=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag=3;
        count++;
        notifyAll();
    }

    public synchronized void printC(){
        while (flag!=3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());

        flag=1;
        count++;
        notifyAll();
    }
}




class MyThread1 implements Runnable {
    private Test2 print;
    public MyThread1(Test2 print){
        this.print=print;
    }
    @Override
    public void run() {
        while (print.getCount()<13){
            if(Thread.currentThread().getName().equals("A")){
                print.printA();
            }
            else if (Thread.currentThread().getName().equals("B")){
                print.printB();
            }
            else if (Thread.currentThread().getName().equals("C")){
                print.printC();
            }
        }
    }

}
