package com.kaishengit.proxy;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */
public class ProxyLenovo implements Computer{
    private Computer computer;

    public ProxyLenovo(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void play() {
        System.out.println("已启动----");
        computer.play();
        System.out.println("正常关机");
    }
}
