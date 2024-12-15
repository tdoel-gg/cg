package cs.vsu.ru.k2.g42.myshkevich_a_n.Math;

import static cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Global.EPS;

public class Vector4f implements Vector<Vector4f> {
    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    float x, y, z, w;


    public static Vector4f addition(Vector4f v1, Vector4f v2) {
        return new Vector4f(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z, v1.w + v2.w);
    }

    @Override
    public void add(Vector4f v) {
        x += v.x;
        y += v.y;
        z += v.z;
        w += v.w;
    }

    public static Vector4f subtraction(Vector4f v1, Vector4f v2) {
        return new Vector4f(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z, v1.w - v2.w);
    }

    @Override
    public void sub(Vector4f v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        w -= v.w;
    }

    @Override
    public Vector4f multiply(float c) {
        return new Vector4f(c * x, c * y, c * z, c * w);
    }

    @Override
    public void mult(float c) {
        x *= c;
        y *= c;
        z *= c;
        w *= c;
    }

    @Override
    public Vector4f divide(float c) {
        if (c < EPS) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return new Vector4f(x / c, y / c, z / c, w / c);
    }

    @Override
    public void div(float c) {
        if (c < EPS) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        x /= c;
        y /= c;
        z /= c;
        w /= c;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public Vector4f normal() {
        final float length = this.length();
        if (length < EPS) {
            throw new ArithmeticException("Normalization of a zero vector is not allowed.");
        }
        float invLength = 1 / length;
        return this.multiply(invLength);
    }

    public static float dotProduct(Vector4f v1, Vector4f v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.w * v2.w;
    }

    @Override
    public boolean equals(Vector4f other) {
        return Math.abs(x - other.x) < EPS
                && Math.abs(y - other.y) < EPS
                && Math.abs(z - other.z) < EPS
                && Math.abs(w - other.w) < EPS;
    }
}
