package nbox.com;

import android.graphics.Color;

/**
 * Created by makarov.s on 23.08.2017.
 */

public class MainCircle extends  Circle{

    public static final int INIT_RADIUS = 25;
    public static final int MAIN_SPEED = 100;
    public static final int MAIN_COLOR = Color.BLUE;

    public MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
        setColor(MAIN_COLOR);
    }

    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED / GameManager.getHeight();
        x += dx;
        y += dy;
    }

    public void initRadius() {
        radius=INIT_RADIUS;
    }

    public void growRadius(Circle circle) {
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2));
    }
}
