package com.obj;

import com.sun.java.accessibility.util.TopLevelWindowListener;

import java.awt.*;

public class ExplodeObj extends GameObj {
    static Image[] pic = new Image[5];
    int explodeCount = 0;
    static {
        for(int i = 0;i<pic.length;i++){
            pic[i] = Toolkit.getDefaultToolkit().getImage("imgs/airplane" + i +".png");
        }
    }
    public ExplodeObj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSlef(Graphics gImage) {

        if (explodeCount <5){
            //img是父类的变量
            img = pic[explodeCount];

//            System.out.println(img);
//            System.out.println(explodeCount);
            super.paintSlef(gImage);
            explodeCount++;

        }
    }
}
