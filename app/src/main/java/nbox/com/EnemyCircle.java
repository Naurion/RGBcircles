package nbox.com;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by makarov.s on 23.08.2017.
 */

public class EnemyCircle extends Circle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 60;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.GREEN;
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }


    public static EnemyCircle getRandomCircle() {
        EnemyCircle circle;
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        circle = new EnemyCircle(x, y, radius, dx, dy);
        return circle;
    }

    public void setEnemyOrFoodColor(MainCircle mainCircle) {
        if (isSmallerThen(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    public boolean isSmallerThen(Circle circle) {
        if (radius < circle.getRadius()) {
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0) {
            dx=-dx;
        }
        if (y > GameManager.getHeight() || y < 0) {
            dy=-dy;
        }

    }
}
