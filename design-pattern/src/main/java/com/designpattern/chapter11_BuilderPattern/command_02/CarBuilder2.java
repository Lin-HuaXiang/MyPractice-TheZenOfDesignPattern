package com.designpattern.chapter11_BuilderPattern.command_02;

import com.designpattern.chapter11_BuilderPattern.command_01.CarModel1;

import java.util.ArrayList;

public abstract class CarBuilder2 {
    // 建造一个模型，你要给我一个顺序，就是组装的顺序
    public abstract void setSequence(ArrayList<String> sequence);

    // 设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel1 getCarModel();
}
