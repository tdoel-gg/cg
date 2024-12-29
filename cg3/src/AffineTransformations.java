import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector3f;
import javax.vecmath.Matrix4f;

public class AffineTransformations {
    public void translate(Vector3f v, float tx, float ty, float tz) { // параллельный перенос
        float w = 1;
        Vector3f translate = new Vector3f(tx * w, ty * w, tz * w);
        v.add(translate); // add - x += translate.x
    }
    public void rotateX(Vector3f v, float angle) {
        Matrix4f rotationMatrix = new Matrix4f();
        rotationMatrix.setIdentity();
        float rad = (float) Math.toRadians(angle);
        rotationMatrix.m11 = (float) Math.cos(rad);
        rotationMatrix.m12 = (float) Math.sin(rad);
        rotationMatrix.m21 = (float) -Math.sin(rad);
        rotationMatrix.m22 = (float) Math.cos(rad);

        Matrix4f vmatrix = VecToMatrix(v);

        vmatrix.mul(rotationMatrix, vmatrix); // ээээээээм (работает)

        v.x = vmatrix.m00;
        v.y = vmatrix.m10;
        v.z = vmatrix.m20;
    }

    public void rotateY(Vector3f v, float angle) {
        Matrix4f rotationMatrix = new Matrix4f();
        rotationMatrix.setIdentity();
        float rad = (float) Math.toRadians(angle);
        rotationMatrix.m00 = (float) Math.cos(rad);
        rotationMatrix.m02 = (float) Math.sin(rad);
        rotationMatrix.m20 = (float) -Math.sin(rad);
        rotationMatrix.m22 = (float) Math.cos(rad);

        Matrix4f vmatrix = VecToMatrix(v);

        vmatrix.mul(rotationMatrix, vmatrix);

        v.x = vmatrix.m00;
        v.y = vmatrix.m10;
        v.z = vmatrix.m20;
    }

    public void rotateZ(Vector3f v, float angle) {
        Matrix4f rotationMatrix = new Matrix4f();
        rotationMatrix.setIdentity();
        float rad = (float) Math.toRadians(angle);
        rotationMatrix.m00 = (float) Math.cos(rad);
        rotationMatrix.m01 = (float) Math.sin(rad);
        rotationMatrix.m10 = (float) -Math.sin(rad);
        rotationMatrix.m11 = (float) Math.cos(rad);

        Matrix4f vmatrix = VecToMatrix(v);

        vmatrix.mul(rotationMatrix, vmatrix);

        v.x = vmatrix.m00;
        v.y = vmatrix.m10;
        v.z = vmatrix.m20;
    }

    public void scale(Vector3f v, float sx, float sy, float sz) {
        v.x *= sx;
        v.y *= sy;
        v.z *= sz;
    }

    //вспомогательные функции
    public Matrix4f VecToMatrix(Vector3f v) {
        Matrix4f matrix = new Matrix4f();
        matrix.m00 = v.x;
        matrix.m10 = v.y;
        matrix.m20 = v.z;
        return matrix;
    }

}
