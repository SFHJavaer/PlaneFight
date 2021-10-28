package com.Util;
import com.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//游戏工具类(获取图片)
public class GameUtils {
    //获取背景图片
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/background.jpg");
    //获取爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/airplane3.png");
    //获取Boss图片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/bigplane0.png");
    //获取我方战斗机图片
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/hero3.png");
    //子弹图片
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/bullet.png");
    //敌机图片
    public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/airplane0.png");
    //要删除物体的集合
    public static List<GameObj> removeObjList = new ArrayList<>();
    //所有游戏物体集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //我方子弹集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //敌机集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
    //敌方BOSS子弹集合
    public static List<EnemyShellObj> enemyShellObjList = new ArrayList<>();

    //爆炸类集合
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();

    //创建绘制字符串的工具类
    public static void drawtext(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }
}
