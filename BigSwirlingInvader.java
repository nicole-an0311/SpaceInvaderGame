package ca.ubc.cs.cpsc210.spaceinvaders.model;

import java.awt.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class BigSwirlingInvader extends Invader {
    public static final int SIZE_X = 30;
    public static final int SIZE_Y = 30;
    public static final int DY = 3;
    public static final int DX = 5;
    public static final Color COLOR = new Color(90, 200, 32);

    private int angle = 0;
    private int r = 3;
    private int x;
    private int y;

    // EFFECTS: invader is positioned at coordinates (x, y)
    public BigSwirlingInvader(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void move() {
        for (int i = 0; i < 36; i++) {
            angle = angle + 10;
            x = x - SIZE_X / 2 + r * (int) sin(angle);
            y = y - SIZE_Y / 2 + r * (int) cos(angle);

            y = y + 2 * DY;
            super.handleBoundary();
        }
    }

}
