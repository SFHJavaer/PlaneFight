package com.obj;

import com.GameWin;
import com.Util.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj {
    public ShellObj() {
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSlef(Graphics gImage) {
        super.paintSlef(gImage);
        y -= speed;
        //下面是敌机与我方子弹的碰撞检测
        //碰撞检测因为是子弹与敌机的碰撞，所以把for遍历子弹集合分别放在绘制子弹和绘制敌机的类中的效果是一样的。
        for (EnemyObj enemyObj: GameUtils.enemyObjList) {
            //碰撞并不会导致游戏结束，所以使用循环来依次遍历
            if (this.getRec().intersects(enemyObj.getRec())) {
                ExplodeObj explodeObj = new ExplodeObj(enemyObj.getX(),enemyObj.getY());
                //碰撞检测中将explodeObj添加到爆炸集合中而不是游戏物体集合中。是在GameWin中把整个explodeObjList添加到物体集合
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeObjList.add(explodeObj);
                //碰撞元素移除屏幕
                enemyObj.setX(-100);
                enemyObj.setY(100);
                this.x = -200;
                this.y = 200;
                GameUtils.removeObjList.add(enemyObj);
                GameUtils.removeObjList.add(this);
                GameWin.score++;
            }
        }
        //越界消失判断
        if(y < 0){
            this.x = -200;
            this.y = 200;
            GameUtils.removeObjList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
