import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector3f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AffineTest {
    @Test
    @DisplayName("Translate +")
    void translate1Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 2, 3);
        transformations.translate(v, 1, 1, 1);
        Assertions.assertEquals(2, v.x);
        Assertions.assertEquals(3, v.y);
        Assertions.assertEquals(4, v.z);
    }

    @Test
    @DisplayName("Translate -")
    void translate2Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 2, 3);
        transformations.translate(v, -1, -1, -1);
        Assertions.assertEquals(0, v.x);
        Assertions.assertEquals(1, v.y);
        Assertions.assertEquals(2, v.z);
    }

    @Test
    @DisplayName("Translate 0")
    void translate3Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 2, 3);
        transformations.translate(v, 0, 0, 0);
        Assertions.assertEquals(1, v.x);
        Assertions.assertEquals(2, v.y);
        Assertions.assertEquals(3, v.z);
    }

    @Test
    @DisplayName("RotateX 90")
    void rotateX1Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(0, 1, 0);
        transformations.rotateX(v, 90);
        Assertions.assertEquals(0, v.x, 1e-6);
        Assertions.assertEquals(0, v.y, 1e-6);
        Assertions.assertEquals(-1, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateX 180")
    void rotateX2Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(0, 1, 0);
        transformations.rotateX(v, 180);
        Assertions.assertEquals(0, v.x, 1e-6);
        Assertions.assertEquals(-1, v.y, 1e-6);
        Assertions.assertEquals(0, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateX 0")
    void rotateX3Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(0, 1, 0);
        transformations.rotateX(v, 0);
        Assertions.assertEquals(0, v.x, 1e-6);
        Assertions.assertEquals(1, v.y, 1e-6);
        Assertions.assertEquals(0, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateY 90")
    void rotateY1Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 0, 0);
        transformations.rotateY(v, 90);
        Assertions.assertEquals(0, v.x, 1e-6);
        Assertions.assertEquals(0, v.y, 1e-6);
        Assertions.assertEquals(-1, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateY 180")
    void rotateY2Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 0, 0);
        transformations.rotateY(v, 180);
        Assertions.assertEquals(-1, v.x, 1e-6);
        Assertions.assertEquals(0, v.y, 1e-6);
        Assertions.assertEquals(0, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateY 0")
    void rotateY3Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(0, 1, 0);
        transformations.rotateY(v, 0);
        Assertions.assertEquals(0, v.x, 1e-6);
        Assertions.assertEquals(1, v.y, 1e-6);
        Assertions.assertEquals(0, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateZ 90")
    void rotateZ1Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 0, 0);
        transformations.rotateZ(v, 90);
        Assertions.assertEquals(0, v.x, 1e-6);
        Assertions.assertEquals(-1, v.y, 1e-6);
        Assertions.assertEquals(0, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateZ 180")
    void rotateZ2Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 0, 0);
        transformations.rotateZ(v, 180);
        Assertions.assertEquals(-1, v.x, 1e-6);
        Assertions.assertEquals(0, v.y, 1e-6);
        Assertions.assertEquals(0, v.z, 1e-6);
    }

    @Test
    @DisplayName("RotateZ 0")
    void rotateZ3Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(0, 0, 1);
        transformations.rotateZ(v, 0);
        Assertions.assertEquals(0, v.x, 1e-6);
        Assertions.assertEquals(0, v.y, 1e-6);
        Assertions.assertEquals(1, v.z, 1e-6);
    }

    @Test
    @DisplayName("Scale +")
    void scale1Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 2, 3);
        transformations.scale(v, 2, 3, 4);
        Assertions.assertEquals(2, v.x);
        Assertions.assertEquals(6, v.y);
        Assertions.assertEquals(12, v.z);
    }

    @Test
    @DisplayName("scale -")
    void scale2Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(10, 10, 10);
        transformations.scale(v, 0.5F, 0.5F, 0.5F);
        Assertions.assertEquals(5, v.x);
        Assertions.assertEquals(5, v.y);
        Assertions.assertEquals(5, v.z);
    }

    @Test
    @DisplayName("scale 0")
    void scale3Test() {
        AffineTransformations transformations = new AffineTransformations();
        Vector3f v = new Vector3f(1, 2, 3);
        transformations.scale(v, 1, 0, 0);
        Assertions.assertEquals(1, v.x);
        Assertions.assertEquals(0, v.y);
        Assertions.assertEquals(0, v.z);
    }
}
