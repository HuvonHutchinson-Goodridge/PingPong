package PingPongApp;

import com.sun.glass.events.KeyEvent;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyListener;

public class PingPong extends Applet implements Runnable, KeyListener {

    private final int WIDTH = 1000, HEIGHT = 1000;
    Thread thread;
    HumanPaddle p1;
    HumanPaddle2 p3;
    Ball b1;
    AIPaddle p2;
    boolean gameStarted = false;
    Graphics gfx;
    Image img;

    public void init(){
        this.resize(WIDTH,HEIGHT);
        gameStarted = false;
        this.addKeyListener( this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p3 = new HumanPaddle2(2);
        p2 = new AIPaddle(2, b1);
        img = createImage(WIDTH,HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g){
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);
        if(b1.getX() < -10 || b1.getX() > 1010) {
            gfx.setColor(Color.RED);
            gfx.drawString("Game Over", 500, 500);
            gameStarted = false;
        }
        else {
            p1.draw(gfx);
            b1.draw(gfx);
            p3.draw(gfx);
        }

        if(!gameStarted){
            gfx.setColor(Color.white);
            gfx.drawString("Ping Pong", 500, 100);
            gfx.drawString("Press Enter to Begin...", 470, 150);
        }
        g.drawImage(img,0,0, this);
    }
    public void update(Graphics g){
        paint(g);
    }

    public void run() {
        do {
            //each time this iterates it has to move that paddle
            if (gameStarted) {
                p1.move();
                b1.move();
                b1.checkCollision(p1, p3);
                p3.move();
            }
            //repaint lets the game run over and over
            repaint();
            try {
                Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
            }
            } while (1 != 0) ;

    }


    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            gameStarted = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            p3.setUpAccelTwo(true);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p3.setDownAccelTwo(true);
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        //VK IS VIRTUAL KEYBOARD, IF YOU PRESS THE UP KEY THEN DO IF
        if(e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(false);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            p3.setUpAccelTwo(false);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            p3.setDownAccelTwo(false);
        }
    }
}
