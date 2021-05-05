package PingPongApp;

import java.awt.*;

public class HumanPaddle2 implements Paddle {

    double y, yVel;
    boolean upAccelTwo, downAccelTwo;
    int player, x;
    final double GRAVITY = 0.94;

    public HumanPaddle2(int player){
        upAccelTwo = false; downAccelTwo = false;
        y = 500; yVel = 0;
        if(player == 2)
            x = 960;
        else
            x = 1203;
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);
    }

    public void move() {
        if(upAccelTwo){
            yVel -= 2;
        } else if (downAccelTwo) {
            yVel += 2;

        } else if(!upAccelTwo && !downAccelTwo){
            yVel *= GRAVITY;
        }

        if (yVel>=5)
            yVel = 5;
        else if(yVel <= -5)
            yVel = -5;
        y += yVel;

        if(y < 0)
            y = 0;
        if(y > 920)
            y = 920;
    }

    public void setUpAccelTwo(boolean input){

        upAccelTwo = input;
    }

    public void setDownAccelTwo(boolean input){
        downAccelTwo = input;
    }

    public int getY() {
        return (int) y;
    }
}

