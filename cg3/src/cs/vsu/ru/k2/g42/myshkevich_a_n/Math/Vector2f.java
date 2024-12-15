package cs.vsu.ru.k2.g42.myshkevich_a_n.Math;

import static cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Global.EPS;

public class Vector2f implements Vector<Vector2f> {
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float x, y;

	public static Vector2f addition(Vector2f v1, Vector2f v2) {
		return new Vector2f(v1.x + v2.x, v1.y + v2.y);
	}

	@Override
	public void add(Vector2f v) {
		x += v.x;
		y += v.y;
	}

	public static Vector2f subtraction(Vector2f v1, Vector2f v2) {
		return new Vector2f(v1.x - v2.x, v1.y - v2.y);
	}

	@Override
	public void sub(Vector2f v) {
		x -= v.x;
		y -= v.y;
	}

	@Override
	public Vector2f multiply(float c) {
		return new Vector2f(c * x, c * y);
	}

	@Override
	public void mult(float c) {
		x *= c;
		y *= c;
	}

	public Vector2f divide(float c) {
		if (c < EPS) {
			throw new ArithmeticException("Division by zero is not allowed.");
		}
		return new Vector2f(x / c, y / c);
	}

	@Override
	public void div(float c) {
		x /= c;
		y /= c;
	}

	@Override
	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	@Override
	public Vector2f normal() {
		final float length = this.length();
		if (length < EPS) {
			throw new ArithmeticException("Normalization of a zero vector is not allowed.");
		}
		float invLength = 1 / length;
		return this.multiply(invLength);
	}
	// eigen посмотреть библиотеку для названий

	public static float dotProduct(Vector2f v1, Vector2f v2) {
		return v1.x * v2.x + v1.y * v2.y;
	}

	@Override
	public boolean equals(Vector2f other) {
		return Math.abs(x - other.x) < EPS && Math.abs(y - other.y) < EPS;
	}
}
