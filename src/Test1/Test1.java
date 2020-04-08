package Test1;

/**
 * @Auther: xuwenjin
 * @Date: 2020/4/8 15:33
 * @Description:
 *
 *
 *
 *
 *
 * 1.写两个线程，一个线程打印 1-52，另一个线程打印A-Z，打印顺序是12A34B…5152Z；
 */
public class Test1 {

    private int flag=1;
    private int count=1;
    public synchronized void printNum(){
        while (flag!=1){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print(2*count-1 );
        System.out.print(2*count);
        flag=2;
        notify();
    }

    public synchronized void Zimu(){
        while (flag!=2){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print((char)(count-1+'A'));
        count++;
        flag=1;
        notify();
    }
}
