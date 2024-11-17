package n2;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Кривые Безье");
        n2.BezierCurves bezierCurves = new n2.BezierCurves();
        frame.add(bezierCurves);
        frame.setSize(1100, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
