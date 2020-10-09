package com.itheima_02;

public class MyThread extends Thread {

    // 自定义的类需要自己建立构造函数，调用父类的带参构造函数
    public MyThread() {}

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}

/*
private String name;

public Thread() {
    this(null, null, "Thread-" + nextThreadNum(), 0);
}

public Thread(String name) {
    this(null, null, name, 0);
}

public Thread(ThreadGroup group, Runnable target, String name,
                  long stackSize) {
    this(group, target, name, stackSize, null, true);
}

private Thread(ThreadGroup g, Runnable target, String name,
                   long stackSize, AccessControlContext acc,
                   boolean inheritThreadLocals) {
    this.name = name;
}

public final synchronized void setName(String name) {
    this.name = name;
}

public final String getName() {
    return name;
}

// ++后置，所以第一次是0，之后变成1
private static int threadInitNumber; //0,1,2
private static synchronized int nextThreadNum() {
    return threadInitNumber++;//0,1,...
}

 */