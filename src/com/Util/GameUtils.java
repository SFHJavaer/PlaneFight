package com.Util;
import com.obj.GameObj;
import com.obj.ShellObj;

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

    //所有游戏物体集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //我方子弹集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
}
