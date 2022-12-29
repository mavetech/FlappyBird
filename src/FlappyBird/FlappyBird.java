package src.FlappyBird;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlappyBird implements ActionListener {

    
    public static FlappyBird flappyBird;

    public final int WIDTH = 800, HEIGHT = 800;

    public Renderer renderer;

    public Rectangle bird;

    public FlappyBird(){
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);

        renderer = new Renderer();

        jframe.add(renderer);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setVisible(true);
        jframe.setResizable(false);

        bird = new Rectangle(WIDTH/2 - 10, HEIGHT/2 - 10, 20, 20);
        timer.start();
    }
    public static void main(String[] args){
        flappyBird = new FlappyBird();
    }

    public void repaint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0,0 , WIDTH, HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderer.repaint();
    }
}
