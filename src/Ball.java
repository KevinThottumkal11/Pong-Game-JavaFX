// Kevin Binu Thottumkal

//package assignment_000884769
import java.util.Random;

public class Ball {
    private int radius;
    private int xSpeed;
    private int ySpeed;
    private double xPos;
    private double yPos;

    public Ball(int radius, int xSpeed, int ySpeed, double xPos, double yPos) {
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void xMovement() {
        xPos += xSpeed;
    }

    public void yMovement() {
        yPos += ySpeed;
    }

    Random random = new Random();
    public int xSpeedSet() {
        int xValue = random.nextInt(2);
        if (xValue == 0) {
            xSpeed = 1;
        } else {
            xSpeed = -1;
        }
        return xSpeed;
    }

    public int ySpeedSet() {
        int yValue = random.nextInt(2);
        if (yValue == 0) {
            ySpeed = 1;
        } else {
            ySpeed = -1;
        }
        return ySpeed;
    }

    public void xDirectionChange() {
        xSpeed *= -1;
    }

    public void yDirectionChange() {
        ySpeed *= -1;
    }

    public void xSpeedIncrease() {
        xSpeed += 1 * Math.signum(xSpeed);
    }

    public void ySpeedIncrease() {
        ySpeed += 1 * Math.signum(ySpeed);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }
}
