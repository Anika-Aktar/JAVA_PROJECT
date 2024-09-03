import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
    public class JavaGrid{
        public static void main(String[] args) {
            //GridLayout = places components in a grid of cells.each component takes all the available space within its cell,and each cell is the same size.
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
            frame.setLayout(new GridLayout(3,3,10,10));
            //  frame.setLayout(new BorderLayout(10,10));
//        JButton button1 = new JButton("1");
//        frame.add(button1); short is
            frame.add(new JButton("1"));
            frame.add(new JButton("2"));
            frame.add(new JButton("3"));
            frame.add(new JButton("4"));
            frame.add(new JButton("5"));
            frame.add(new JButton("6"));
            frame.add(new JButton("7"));
            frame.add(new JButton("8"));
            frame.add(new JButton("9"));
            frame.add(new JButton("10"));


            frame.setVisible(true);
        }
    }


