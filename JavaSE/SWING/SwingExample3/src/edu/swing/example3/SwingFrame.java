package edu.swing.example3;

import edu.swing.example2.Shape;
import edu.swing.example2.TriangleShape;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingFrame extends JFrame implements ActionListener {

    private edu.swing.example2.Shape[] shapes;
    private JEditorPane tEditor;

    public SwingFrame() {
        Container cp = getContentPane();

        JPanel pButton = new JPanel();

        JButton b1 = new JButton("Less");
        b1.setActionCommand("B1");
        b1.addActionListener(this);
        pButton.add(b1);

        JButton b2 = new JButton("More");
        b2.setActionCommand("B2");
        b2.addActionListener(this);
        pButton.add(b2);

        tEditor = new JEditorPane();
        pButton.add(tEditor);

        JPanel pShape = new JPanel();
        pShape.setLayout(new GridLayout(2, 3));
        shapes = new edu.swing.example2.Shape[6];

        for (int i = 0; i < 6; i++) {
            if (Math.random() > 0.5) {
                edu.swing.example2.TriangleShape c = new TriangleShape();
                shapes[i] = c;
                pShape.add(c);
            } else {
                edu.swing.example2.SquareShape c = new edu.swing.example2.SquareShape();
                shapes[i] = c;
                pShape.add(c);
            }
        }

        cp.add(pButton, BorderLayout.NORTH);
        cp.add(pShape, BorderLayout.CENTER);

        setBounds(10, 50, 500, 450);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        int t = Integer.parseInt(tEditor.getText());
        if (b.getActionCommand().equals("B1")) {
            for (edu.swing.example2.Shape sh : shapes) {
                sh.decrease(t);
            }
        } else {
            for (Shape sh : shapes) {
                sh.increase(t);
            }
        }
        repaint();
    }

    public static void main(String[] arg) {
        edu.swing.example2.SwingFrame f = new edu.swing.example2.SwingFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
