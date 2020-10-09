package com.itheima.demo01.WaitAndNotify;

public class ChiHuo extends Thread{

    private BaoZi bz;

    public ChiHuo(String name,BaoZi bz){
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        while(true){
            synchronized (bz){
                //没包子
                if(bz.flag == false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃货正在吃"+bz.pier+bz.xianer+"包子");
                try {
                    Thread.sleep(3000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = false;
                System.out.println("吃货已经把"+bz.pier+bz.xianer+"的包子吃完了，包子铺开始生产包子");
                bz.notify();
            }
        }
    }
}
