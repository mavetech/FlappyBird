package src.FlappyBird;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    private static final long serialVersionId = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FlappyBird.flappyBird.repaint(g);
    }
}
