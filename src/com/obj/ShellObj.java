package com.obj;

import com.GameWin;

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

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
