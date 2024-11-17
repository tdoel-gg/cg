package bezier;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;

public class BezierCurves extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // квадратичная кривая Безье
        QuadCurve2D quadCurve = new QuadCurve2D.Float();
        quadCurve.setCurve(50, 300, 150, 100, 250, 300);
        g2d.setColor(Color.BLUE);
        g2d.draw(quadCurve);

        // кубическая кривая Безье
        CubicCurve2D cubicCurve = new CubicCurve2D.Float();
        cubicCurve.setCurve(300, 300, 350, 100, 450, 500, 500, 300);
        g2d.setColor(Color.RED);
        g2d.draw(cubicCurve);
    }

}
