package com.itheima.demo01.WaitAndNotify;

public class BaoZiPu extends Thread {

    private BaoZi bz;

    public BaoZiPu(String name,BaoZi bz){
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        //造包子
        while(true){
            //同步
            synchronized (bz){
                //包子资源 存在
                if(bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 没有包子 造包子
                System.out.println("包子铺开始做包子");

                if(count%2 == 0){
                    // 冰皮 五仁
                    bz.pier = "冰皮";
                    bz.xianer = "五仁";
                }else{
                    // 薄皮 牛肉大葱
                    bz.pier = "薄皮";
                    bz.xianer = "牛肉大葱";
                }
                count++;
                System.out.println("包子铺正在生产：" + bz.pier + bz.xianer + "包子");
                try {
                    Thread.sleep(3000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag=true;

                System.out.println("包子造好了：" + bz.pier + bz.xianer);
                System.out.println("吃货来吃吧");

                //唤醒等待线程 （吃货）
                bz.notify();
            }
        }
    }
}