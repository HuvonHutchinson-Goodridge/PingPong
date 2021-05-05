package PingPongApp;

import java.awt.*;

public class Ball {
    double xVel, yVel, x, y;

    public Ball(){
        x = 500;
        y = 500;
        xVel = getRandomSpeed() * getRandomDirection();
        yVel = getRandomSpeed() * getRandomDirection();
    }

    public double getRandomSpeed(){
        return(Math.random() * 3 + 2);
    }

    public int getRandomDirection(){
        int rand = (int) (Math.random() * 2);
        if (rand == 1)
            return 1;
        else
            return -1;

    }

    public void draw(Graphics g){
        //subtract 1- because it is down from the top left corner
        //you want the circle to be drawn from the center.
        g.setColor(Color.white);
        g.fillOval((int)x-10,(int)y-10,20,20);
    }

    public void checkCollision(Paddle p1, Paddle p2){
        if (x <= 50) {
            if (y >= p1.getY() && y<= p1.getY() + 80){
                xVel = -xVel;
            }
        }
        else if(x>950){
            if (y >= p2.getY() && y<= p2.getY() + 80){
                xVel = -xVel;
            }

        }
    }

    public void move(){
        x += xVel;
        y += yVel;

        if(y <10)
            yVel = -yVel;
        if (y > 990)
            yVel = -yVel;
    }
    public int getX(){
        return(int) x;
    }
    public int getY(){
        return (int) y;
    }

}
