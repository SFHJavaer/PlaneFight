package com.obj;

import com.GameWin;
import com.Util.GameUtils;

import java.awt.*;

import static com.GameWin.life;

public class BossObj extends GameObj {
    public BossObj() {
        super();
    }

    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSlef(Graphics gImage) {
        super.paintSlef(gImage);
        //if或运算符||
        if (x>550||x<50){
            speed = -speed;
        }
        x += speed;
        //绘制时检测碰撞
        if (this.frame.bossObj != null && this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state = 3;
        }
        for (ShellObj shellObj: GameUtils.shellObjList) {
            if(this.getRec().intersects(shellObj.getRec())){
                shellObj.setY(100);
                shellObj.setX(-100);
                GameUtils.removeObjList.add(shellObj);
                life--;
            if(life <=0){
                GameWin.state = 4;
            }
            }
            //血条白色背景
            gImage.setColor(Color.white);
            gImage.fillRect(20,40,100,10);
            //BOSS血条绘制
            gImage.setColor(Color.red);
            gImage.fillRect(20,40,life *100 / 10,10);

        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
