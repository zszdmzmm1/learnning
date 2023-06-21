package day0616;

public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(0, "灰姑娘");
        Makeup makeup2 = new Makeup(1, "白雪公主");

        makeup1.start();
        makeup2.start();
        //最终结果：程序僵持运行着
    }
}
//口红
class Lipstick{
    String name = "迪奥口红";
}
//镜子
class Mirror{
    String name = "魔镜";
}
//化妆
class Makeup extends Thread{

    //使用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//选择化妆的人

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆
    private void makeup() throws InterruptedException {
        if(choice==0){
            synchronized (lipstick){//获得口红的锁
                System.out.println(this.girlName + "--->获得" + lipstick.name);
                Thread.sleep(1000);
                synchronized (mirror){//一秒钟之后想要镜子的锁
                    System.out.println(this.girlName + "--->获得" + mirror.name);
                }
            }
        }else{
            synchronized (mirror){//获得镜子的锁
                System.out.println(this.girlName + "--->获得" + mirror.name);
                Thread.sleep(2000);
                synchronized (lipstick){//两秒钟之后想要口红的锁
                    System.out.println(this.girlName + "--->获得" + lipstick.name);
                }
            }
        }
    }
}
