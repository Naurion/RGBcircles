package nbox.com;

/**
 * Created by makarov.s on 23.08.2017.
 */

public class Circle {

    public static final int SAVE_AREA = 3;
    protected int x;
    protected int y;
    protected int radius;
    private int color;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Circle getCircleArea() {
        return new Circle(x, y, radius * SAVE_AREA);
    }

    public boolean isIntersect(Circle circle) {
        return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2)) ;
    }

}
