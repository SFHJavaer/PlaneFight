package com;
import com.Util.GameUtils;
import com.obj.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//游戏状态：0未开始 1游戏中 2暂停 3通关失败 4通关成功

//创建一个窗口启动类
public class GameWin extends JFrame{
    public GameWin (){
        System.out.println("GameWin的构造方法执行");
    }

    //静态定义游戏默认状态
    public static int state = 0;

    //分数是属于窗口的，所以是static
    public static int score = 0;
    //记录敌机数量变量
    int enemycount = 0;

    Image offScreenImage = null;//该变量在paint方法中初始化对象

    //创建我方飞机对象       this.frame表示当前窗口

    public PlaneObj planeObj = new PlaneObj(GameUtils.planeImg,290,550,20,30,0,this);

    int width = 600;
    int height = 600;

    //定义生命值
    public static int life =10;

    //定义记录重绘次数的变量(游戏至少重绘一次)
    int paintcount = 1;

    //获取背景图片对象,将工具类中的背景图片对象用来创建BgObj对象
    //注意BgObj类继承了父类GameObj，而后者是一个实体类
    BgObj bgObj = new BgObj(GameUtils.bgImg,0,-200,2);


    //创建BOSS
     public GameObj bossObj = null;

    //首先创建启动方法
    public void launch(){
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(width,height);
        //设置窗口位置(中央)
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("飞机大战");

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);
//        GameUtils.gameObjList.add(bossObj);//不删除本行代码会产生空指针异常，在敌机数量未到100时，bossObj为null

        //添加鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //检测到点击鼠标左键并且state=0
                if (e.getButton() ==1 && state == 0){
                    state = 1;
                    repaint();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32){
                    switch (state){
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                    }
                }
            }
        });
        //背景图移动，所以要重复调用paint方法、
        //下面的while没有break跳出循环，也没有循环的限制条件，所以一旦程序启动，while语句就会一直执行
        while(true){
            //健壮性：必须确定了程序正在运行状态，才能执行运行状态的操作
            if (state == 1){
                createObj();
                repaint();
            }

            try {
                Thread.sleep(25);//一秒钟repaint方法会调用四十次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /***    重写Frame的paint方法
     *
     */
    @Override
    public void paint(Graphics g) {
         if (offScreenImage ==null){
             offScreenImage = createImage(600,600);
         }
         Graphics gImage = offScreenImage.getGraphics();
         //gImage是Graphics对象，操作该对象进行图像设置，最后使用drawImage方法进行绘制对象
         //用gImage填充区域
        gImage.fillRect(0,0,width,height);

        //添加游戏未开始时的启动界面
        if (state == 0){
            //使用画笔g绘制图片
            gImage.drawImage(GameUtils.bgImg,0,0,null);
            gImage.drawImage(GameUtils.explodeImg,220,120,null);
            gImage.drawImage(GameUtils.bossImg,170,350,null);
            //设置颜色和字体
            GameUtils.drawtext(gImage,"点击开始游戏",Color.yellow,40,180,300);
        }
        if(state ==1){
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);


//            System.out.println(GameUtils.explodeObjList);


            //下面for循环中使用的临时变量i只能在for循环中生效，同try/catch
            //虽然i是临时变量，但是在java中变量必须初始化，不论在哪，直接引用除非是初始化过了
            for (int i = 0;i < GameUtils.gameObjList.size();i++){
//                System.out.println(GameUtils.gameObjList.get(i));//测试是否有空指针异常
                GameUtils.gameObjList.get(i).paintSlef(gImage);//把每一个属于gameObjList的元素依次绘制
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeObjList);//把每一个属于gameObjList的元素依次删除

        }
        if (state == 3){
            //使用画笔g绘制图片
            gImage.drawImage(GameUtils.explodeImg,planeObj.getX(),planeObj.getY(),null);
            //设置颜色和字体
            GameUtils.drawtext(gImage,"Game Over",Color.red,50,180,300);

        }
        if (state ==2){
            //state = 2的判断可以不用写，因为没有代码指示，自动处于终止（暂停）状态
        }
        if(state ==4){
            System.out.println("通关成功！！");
            gImage.drawImage(GameUtils.explodeImg,bossObj.getX(),bossObj.getY(),null);
            GameUtils.drawtext(gImage, "游戏通关成功！", Color.green, 50, 180, 300);

        }

        //绘制积分面板
        GameUtils.drawtext(gImage,score +"分",Color.green,40,30,100);
        //把新图片一次性绘制到主窗口中
        g.drawImage(offScreenImage,0,0,null);
        paintcount++;//自增
//        System.out.println(GameUtils.gameObjList.size());

    }
    //创建对象方法
    public void createObj(){
        //每绘制15次才生成一颗子弹
        if (paintcount %15 == 0) {
            //通过匿名类创建子弹对象
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, planeObj.getX(), planeObj.getY() - 16, 14, 29, 5, this));
            //将子弹集合最后一个元素添加到物体集合中
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        if (paintcount %15 == 0) {
            //通过匿名类创建敌机对象(Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值)
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*12)*50,0,49,36,5,this));
            //将敌机集合最后一个元素添加到物体集合中
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
            enemycount++;
        }
        //保证boss存在时才会发射子弹
        if (paintcount %15 == 0&&bossObj != null) {
            //通过匿名类创建敌机子弹对象
            GameUtils.enemyShellObjList.add(new EnemyShellObj(GameUtils.shellImg,bossObj.getX()+36,bossObj.getY()+70,14,29,5,this));
            //将敌机子弹集合最后一个元素添加到物体集合中
            GameUtils.gameObjList.add(GameUtils.enemyShellObjList.get(GameUtils.enemyShellObjList.size() - 1));
        }
        if (enemycount == 5){
            GameUtils.gameObjList.add(new BossObj(GameUtils.bossImg,250,0,155,100,5,this));
        }
    }
    //创建主函数创建对象
    public static void main(String[] args){
        GameWin gamewin = new GameWin();
        gamewin.launch();

    }
}
//由于窗口中的元素都是绘制出来的，一直重新绘制，所以元素会有一直闪烁的效果，所以使用双缓存技术进行处理
//窗口元素的位置：最左上角为（0，0），向右方和下方为正数，同理其他为复数
//因为背景图片高度有限，所以不能只循环一次，分析知当y大于等于0时，需要将y的值恢复到初始值（-2000）
