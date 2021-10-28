package com.obj;

import com.GameWin;

import java.awt.*;

public class EnemyShellObj extends GameObj{
    public EnemyShellObj() {
        super();
    }

    public EnemyShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSlef(Graphics gImage) {
        super.paintSlef(gImage);
        y += speed;
        //检测BOSS子弹与我方飞机碰撞
        if (this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state = 3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
