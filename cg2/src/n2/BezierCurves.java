package n2;

import javax.swing.*;
import java.awt.*;

public class BezierCurves extends JPanel {
    //число сочетаний
    private static int combination(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
    //факториал для числа сочетаний
    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    //вычисление точки
    public static double[] bezier(double t, double[][] controlPoints) {
        int n = controlPoints.length - 1;
        double x = 0;
        double y = 0;

        for (int i = 0; i <= n; i++) {
            double bernsteinPolynomial = combination(n, i) * Math.pow(t, i) * Math.pow(1 - t, n - i); //базисная функция
            x += bernsteinPolynomial * controlPoints[i][0];
            y += bernsteinPolynomial * controlPoints[i][1];
        }

        return new double[]{x, y};
    }
    //отрезки для наглядности
    private void drawControlPolygon(Graphics g, double[][] controlPoints) {
        for (int i = 0; i < controlPoints.length - 1; i++) {
            g.drawLine((int) controlPoints[i][0], (int) controlPoints[i][1],
                    (int) controlPoints[i + 1][0], (int) controlPoints[i + 1][1]);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // квадратичная кривая Безье
        double[][] quadrat = {
                {50, 300},   // p0
                {150, 100},  // p1
                {250, 300}   // p2
        };
        g2d.setColor(Color.RED);
        for (double t = 0; t <= 1; t += 0.00001) {
            double[] point = bezier(t, quadrat);
            g.fillOval((int) point[0], (int) point[1], 2, 2);
        }

        // кубическая кривая Безье
        double[][] cubic = {
                {300, 300},   // p0
                {400, 100},   // p1
                {500, 500},   // p2
                {600, 300}    // p3
        };
        g2d.setColor(Color.BLUE);
        for (double t = 0; t <= 1; t += 0.00001) {
            double[] point = bezier(t, cubic);
            g.fillOval((int) point[0], (int) point[1], 2, 2);
        }

        //пять точек
        double[][] pet = {
                {650, 300},   // p0
                {750, 100},   // p1
                {850, 500},   // p2
                {950, 100},  // p3
                {1050, 300}   // p4
        };
        g2d.setColor(Color.GREEN);
        for (double t = 0; t <= 1; t += 0.00001) {
            double[] point = bezier(t, pet);
            g.fillOval((int) point[0], (int) point[1], 2, 2);
        }

        g.setColor(Color.BLACK);
        //drawControlPolygon(g, quadrat);
        //drawControlPolygon(g, cubic);
        //drawControlPolygon(g, pet);
    }

}
