package com.obj;

import com.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//我方战斗机对象
public class PlaneObj extends GameObj{
    //override父类构造方法也就是创建本类的构造方法，但是本类构造方法方法体内调用父类的构造方法
    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        //飞机的构造方法中添加鼠标滚动事件
        //下面不是鼠标监听器，而是鼠标运动监听器，因为这里用到的是移动操作。
        //鼠标监听器：监听鼠标的点击，按下松开，进入离开等操作
        //鼠标MotionListener：监听鼠标的拖动和移动
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            //MouseEvent e代表鼠标的指针对象
            public void mouseMoved(MouseEvent e) {
                //下面让飞机的横坐标和鼠标光标的横坐标减去飞机宽度一半
                PlaneObj.super.x = e.getX() - 11;//指明当前类来使用super更规范和准确
                PlaneObj.super.y = e.getY() - 16;//同上
            }
        });
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSlef(Graphics gImage) {
        super.paintSlef(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
