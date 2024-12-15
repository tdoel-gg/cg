import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;
import java.util.Arrays;

public class AffineTransformations {
    private Matrix4f matrix;
    public AffineTransformations() {
        matrix = new Matrix4f();
        matrix.setIdentity();
    }
    public void translate(float tx, float ty, float tz, float t) { // параллельный перенос
        float[][] matrix2 = {
                {tx},
                {ty},
                {tz},
                {1}
        };
        //System.out.println(Arrays.deepToString(matrix2));
        for (int i = 0; i < 4; i++) {
            matrix2[i][0] += t;
        }
        //System.out.println(Arrays.deepToString(matrix2));

    }

}
