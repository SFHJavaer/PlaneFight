package com.obj;

import com.GameWin;
import com.Util.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj{
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSlef(Graphics gImage) {
        super.paintSlef(gImage);
        y += speed;
        //检测敌机与我方飞机碰撞
        if (this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state = 3;
        }
        if(y > 600){
            this.x = -200;
            this.y = 200;
            GameUtils.removeObjList.add(this);
        }

//        //循环中的this代表当前敌机对象（敌机对象才调用该实例方法）
//        for (ShellObj shellObj: GameUtils.shellObjList) {
//            //碰撞并不会导致游戏结束，所以使用循环来依次遍历
//            if (this.getRec().intersects(shellObj.getRec())){
//                //碰撞元素移除屏幕
//                shellObj.setX(-100);
//                shellObj.setY(100);
//                this.x = -200;
//                this.y = 200;
//                GameUtils.removeObjList.add(shellObj);
//                GameUtils.removeObjList.add(this);
//                GameWin.score++;
//
//            }
//
//        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
