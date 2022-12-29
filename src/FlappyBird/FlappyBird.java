package src.FlappyBird;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements ActionListener {

    
    public static FlappyBird flappyBird;

    public final int WIDTH = 800, HEIGHT = 800;

    public Renderer renderer;

    public Rectangle bird;

    public ArrayList<Rectangle> columns;

    public Random rand;

    public int ticks, yMotion;

    public FlappyBird(){
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);

        renderer = new Renderer();
        rand = new Random();
        jframe.add(renderer);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setVisible(true);
        jframe.setResizable(false);

        bird = new Rectangle(WIDTH/2 - 10, HEIGHT/2 - 10, 20, 20);
        columns = new ArrayList<>();

        timer.start();
    }
    public static void main(String[] args){
        flappyBird = new FlappyBird();
    }


    public void addColumn(boolean start){
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if(start){
            columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(WIDTH + width + (columns.size() -1)*300, 0, width, HEIGHT - height - space));
        }
        else{
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));

        }

    }
    public void paintColumn(Graphics g, Rectangle column){
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }
    public void repaint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0,0 , WIDTH, HEIGHT);

        g.setColor(Color.orange);
        g.fillRect(0,HEIGHT - 150, WIDTH, 150);

        g.setColor(Color.green);
        g.fillRect(0,HEIGHT - 150, WIDTH, 20);

        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;
        if(ticks % 2 == 0 && yMotion<15){
            yMotion += 2;
        }
        bird.y += yMotion;
        renderer.repaint();
    }
}
