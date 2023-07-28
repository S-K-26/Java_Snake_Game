import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private Image apple;
    private Image dot;
    private Image head;

    private final int ALL_DOTS = 2500;
    private final int DOTS_SIZE = 10;
    private final int[] x = new int[ALL_DOTS];
    private final int[] y = new int[ALL_DOTS];

    private int apple_X;
    private int apple_Y;
    private static int dots;
    Board() {
        setBackground(Color.BLACK);
        setFocusable(true);
        loadImages();
        initGame();
    }

    public void loadImages(){
        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("Game/icons/apple.png"));
        apple =  imageIcon1.getImage();

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("Game/icons/dot.png"));
        dot = imageIcon2.getImage();

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("Game/icons/head.png"));
        head = imageIcon3.getImage();
    }
    public void initGame(){
        dots = 3;
        for (int i = 0; i < dots; i++){
            y[i] = 50;
            x[i] = 50 - i * DOTS_SIZE;
        }

        locateAppple();
    }

    public void locateAppple(){
        int r  = (int) (Math.random() * 20);
        apple_X = r * DOTS_SIZE;
        apple_Y = r * DOTS_SIZE;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        draw(graphics);
    }

    public void draw(Graphics graphics){
        graphics.drawImage(apple,apple_X,apple_Y,this);

        for (int i = 0; i < dots; i++) {
            if(i ==0)
                graphics.drawImage(head, x[i], y[i],this);
            else
                graphics.drawImage(dot,x[i],y[i],this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

}
