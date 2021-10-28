package com.obj;

import com.GameWin;

import java.awt.*;

//游戏物体父类
public class GameObj {
    //定义物体参数
    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;
    GameWin frame;

    public GameObj() {
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getwidth() {
        return width;
    }

    public void setwidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }
    //绘制自身的方法
    public void paintSlef(Graphics gImage){
            gImage.drawImage(img,x,y,null);
    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //获取自身矩形的方法
    //检测两个物体所在的矩形是否碰撞
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }


}
