package com.designpattern.chapter11_builder_pattern.command_01;

import java.util.ArrayList;

public abstract class CarModel1 {

    // 这个参数是各个基本方法执行的顺序
    private ArrayList<String> sequence = new ArrayList<>();

    // 模型是启动开始跑了
    protected abstract void start();

    //能发动，还要停下来，那才是真本事
    protected abstract void stop();

    // 喇叭会出声音，是滴滴叫，还是哗哗叫
    protected abstract void alarm();

    // 引擎会轰隆隆地响，不响那是假的
    protected abstract void engineBoom();

    // 那模型应该会跑吧，别管是人推的，还是电力驱动的，总之要会跑
    final public void run() {
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = this.sequence.get(i);
            if (actionName.equalsIgnoreCase("start")) {
                this.start();
            } else if (actionName.equalsIgnoreCase("stop")) {
                this.stop();
            } else if (actionName.equalsIgnoreCase("alarm")) {
                this.alarm();
            } else if (actionName.equalsIgnoreCase("engine boom")) {
                this.engineBoom();
            }
        }
    }

    // 把传递过来的值传递到类内
    final public void setSequence(ArrayList sequence) {
        this.sequence = sequence;
    }
}
