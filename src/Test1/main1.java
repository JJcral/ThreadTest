package Test1;

/**
 * @Auther: xuwenjin
 * @Date: 2020/4/8 15:39
 * @Description:
 */
public class main1 {
    public static void main(String[] args) {

        Test1 test1 = new Test1();

        new Thread(() ->{
            for (int i = 0;i<26;i++){
                test1.printNum();
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<26;i++){
                test1.Zimu();
            }
        }).start();
    }
}
