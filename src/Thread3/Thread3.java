package Thread3;

public class Thread3 extends Thread{
    public void run(){
        for(int i=1;i<10;i++){
            System.out.println("thread3:"+i);
        }
    }
    static void main(){
        Thread3 thread3 = new Thread3();
        thread3.start();
    }
}
