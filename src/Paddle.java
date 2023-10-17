// Kevin Binu Thottumkal

//package assignment_000884769
public class Paddle {
    private int height;
    private int width;
    private double pXPos;
    private double pYPos;

    public Paddle(int height, int width, int pXPos, int pYPos) {
        this.height = height;
        this.width = width;
        this.pXPos = pXPos;
        this.pYPos = pYPos;
    }

    public double computerUp() {
        pYPos += 1;
        return pYPos;
    }

    public double computerDown() {
        pYPos -= 1;
        return pYPos;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getpXPos() {
        return pXPos;
    }

    public void setpXPos(double pXPos) {
        this.pXPos = pXPos;
    }

    public double getpYPos() {
        return pYPos;
    }

    public void setpYPos(double pYPos) {
        this.pYPos = pYPos;
    }
}
