package PingPongApp;

import java.awt.*;

public class AIPaddle implements Paddle {

        double y, yVel;
        boolean upAccel, downAccel;
        int player, x;
        final double GRAVITY = 0.94;
        Ball b1;

        public AIPaddle(int player, Ball b){
            upAccel = false; downAccel = false;
            b1 = b;
            y = 500; yVel = 0;
            if(player == 1)
                x = 20;
            else
                x = 960;
        }
        public void draw(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(x, (int)y, 20, 80);
        }

        public void move() {
            y = b1.getY() - 40;

            if(y < 0)
                y = 0;
            if(y > 920)
                y = 920;
        }


        public int getY() {
            return (int) y;
        }


}
