package com.obj;

import java.awt.*;

public class BgObj extends GameObj{
    public BgObj(Image img, int x, int y, double speed) {
        //这里super调用了父类的构造方法（子类不能继承父类的构造方法）
        //知识点：使用super.父类方法    显式调用父类的成员方法

        //使用super.变量名   访问父类的实例变量
        //注意如果父类变量被static修饰，那么需要使用   父类名.变量名来访问(规范)


        //使用super（参数列表）    调用父类的构造方法（有参或无参），省去了自己写构造方法

        //super() 必须是在子类构造方法的方法体的第一行。(调用无参构造)
        super(img, x, y, speed);
    }

    @Override
    //背景图片图像类继承了实体类绘制自身的方法
    public void paintSlef(Graphics gImage) {
//        System.out.println("paint方法执行一次");
        super.paintSlef(gImage);
    //给y加上speed速度(形成坐标的变化)
        y += speed;
        if (y >=0){
            y = -300;
        }

    }
}
//默认调用父类的构造方法来创建对象
//如果构造方法的第一行代码不是 this() 和 super()，则系统会默认添加 super()。