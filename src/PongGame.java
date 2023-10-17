// Kevin Binu Thottumkal

//package assignment_000884769;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PongGame extends Application {

    private int width = 800;    // width of the canvas
    private int height = 600;   // height of the canvas
    private int scoreP1 = 0;    // User score
    private int scoreP2 = 0;    // Computer score
    private boolean gameStarted;

    Ball ball = new Ball(15, 1, 1, (double) width /2, (double) height /2);
    Paddle p1 = new Paddle(100, 15, 0, height/2);   // User paddle
    Paddle p2 = new Paddle(100, 15, width-15, height/2);    // Computer paddle

    public void start(Stage stage) throws Exception {
        stage.setTitle("P O N G");
        //background size
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //JavaFX Timeline = free form animation defined by KeyFrames and their duration
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);

        //mouse control (move and click)
        canvas.setOnMouseMoved(e ->  p1.setpYPos(e.getY()));
        canvas.setOnMouseClicked(e ->  gameStarted = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc) {
        //set graphics
        //set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        //set text
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        if(gameStarted) {
            //set ball movement
            ball.xMovement();
            ball.yMovement();

            //simple computer opponent who is following the ball
            if(ball.getxPos() < width - width / 4) {
                p2.setpYPos(ball.getyPos() - p2.getHeight()/2);
            } else {
                if (ball.getyPos() > p2.getpYPos() + p2.getHeight()/2) {
                    p2.setpYPos(p2.computerUp());
                } else {
                    p2.setpYPos(p2.computerDown());
                }
            }
            //draw the ball
            gc.fillOval(ball.getxPos(), ball.getyPos(), ball.getRadius(), ball.getRadius());

        } else {
            //set the start text
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Click", width / 2, height / 2);

            //reset the ball start position
            ball.setxPos(width/2);
            ball.setyPos(height/2);

            //reset the ball speed and the direction
            ball.setxSpeed(ball.xSpeedSet());
            ball.setySpeed(ball.ySpeedSet());
        }

        //makes sure the ball stays in the canvas
        if(ball.getyPos() > height || ball.getyPos() < 0) {
            ball.yDirectionChange();
        }

        //if you miss the ball, computer gets a point
        if(ball.getxPos() < p1.getpXPos() - p1.getWidth()) {
            scoreP2++;
            gameStarted = false;
        }

        //if the computer misses the ball, you get a point
        if(ball.getxPos() > p2.getpXPos() + p2.getWidth()) {
            scoreP1++;
            gameStarted = false;
        }

        //increase the speed after the ball hits the player
        if( ((ball.getxPos() + ball.getRadius() > p2.getpXPos()) && ball.getyPos() >= p2.getpYPos() && ball.getyPos() <= p2.getpYPos() + p2.getHeight()) ||
                ((ball.getxPos() < p1.getpXPos() + p1.getWidth()) && ball.getyPos() >= p1.getpYPos() && ball.getyPos() <= p1.getpYPos() + p1.getHeight())) {
            ball.ySpeedIncrease();
            ball.xSpeedIncrease();
            ball.xDirectionChange();
            ball.yDirectionChange();
        }

        //draw score
        gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
        //draw player 1 & 2
        gc.fillRect(p2.getpXPos(), p2.getpYPos(), p2.getWidth(), p2.getHeight());
        gc.fillRect(p1.getpXPos(), p1.getpYPos(), p1.getWidth(), p1.getHeight());
    }

    // start the application
    public static void main(String[] args) {
        launch(args);
    }
}
