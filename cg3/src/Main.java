
import cs.vsu.ru.k2.g42.myshkevich_a_n.model.Model;
import cs.vsu.ru.k2.g42.myshkevich_a_n.objreader.ObjReader;

public class Main {
    public static void main(String[] args) {
        Model model = ObjReader.read("# Blender 4.0.1\n" +
                "# www.blender.org\n" +
                "o Cube\n" +
                "v -1.000000 -1.000000 1.000000\n" +
                "v -1.000000 1.000000 1.000000\n" +
                "v -1.000000 -1.000000 -1.000000\n" +
                "v -1.000000 1.000000 -1.000000\n" +
                "v 1.000000 -1.000000 1.000000\n" +
                "v 1.000000 1.000000 1.000000\n" +
                "v 1.000000 -1.000000 -1.000000\n" +
                "v 1.000000 1.000000 -1.000000\n" +
                "vn -1.0000 -0.0000 -0.0000\n" +
                "vn -0.0000 -0.0000 -1.0000\n" +
                "vn 1.0000 -0.0000 -0.0000\n" +
                "vn -0.0000 -0.0000 1.0000\n" +
                "vn -0.0000 -1.0000 -0.0000\n" +
                "vn -0.0000 1.0000 -0.0000\n" +
                "vt 0.657719 0.070615\n" +
                "vt 0.657719 0.288779\n" +
                "vt 0.343923 0.288779\n" +
                "vt 0.343923 0.070615\n" +
                "vt 0.982747 0.538081\n" +
                "vt 0.982747 0.758131\n" +
                "vt 0.677420 0.758131\n" +
                "vt 0.677420 0.538418\n" +
                "vt 0.654372 0.535544\n" +
                "vt 0.654372 0.758215\n" +
                "vt 0.344166 0.758215\n" +
                "vt 0.344166 0.535750\n" +
                "vt 0.327407 0.537083\n" +
                "vt 0.327407 0.759706\n" +
                "vt 0.015414 0.759706\n" +
                "vt 0.015414 0.536937\n" +
                "vt 0.656108 0.299368\n" +
                "vt 0.656108 0.524271\n" +
                "vt 0.344171 0.524271\n" +
                "vt 0.344171 0.299368\n" +
                "vt 0.655295 0.773650\n" +
                "vt 0.655295 0.993820\n" +
                "vt 0.346502 0.993820\n" +
                "vt 0.346502 0.773650\n" +
                "s 0\n" +
                "f 1/1/1 2/2/1 4/3/1 3/4/1\n" +
                "f 3/5/2 4/6/2 8/7/2 7/8/2\n" +
                "f 7/9/3 8/10/3 6/11/3 5/12/3\n" +
                "f 5/13/4 6/14/4 2/15/4 1/16/4\n" +
                "f 3/17/5 7/18/5 5/19/5 1/20/5\n" +
                "f 8/21/6 4/22/6 2/23/6 6/24/6\n");

        AffineTransformations transformations = new AffineTransformations();

        System.out.println("Translate:");
        for (int i = 0; i < model.vertices.size(); i++) {
            transformations.translate(model.vertices.get(i),2,2,2 );
            System.out.println(model.vertices.get(i).x + " " + model.vertices.get(i).y + " " + model.vertices.get(i).z);
        }
        System.out.println();

        System.out.println("Rotate X:");
        for (int i = 0; i < model.vertices.size(); i++) {
            transformations.rotateX(model.vertices.get(i), 360);
            System.out.println(model.vertices.get(i).x + " " + model.vertices.get(i).y + " " + model.vertices.get(i).z);
        }
        System.out.println();


        System.out.println("Rotate Y:");
        for (int i = 0; i < model.vertices.size(); i++) {
            transformations.rotateY(model.vertices.get(i), 360);
            System.out.println(model.vertices.get(i).x + " " + model.vertices.get(i).y + " " + model.vertices.get(i).z);
        }
        System.out.println();

        System.out.println("Rotate Z:");
        for (int i = 0; i < model.vertices.size(); i++) {
            transformations.rotateZ(model.vertices.get(i), 360);
            System.out.println(model.vertices.get(i).x + " " + model.vertices.get(i).y + " " + model.vertices.get(i).z);
        }
        System.out.println();

        System.out.println("Scale:");
        for (int i = 0; i < model.vertices.size(); i++) {
            transformations.scale(model.vertices.get(i), 2, 2, 2);
            System.out.println(model.vertices.get(i).x + " " + model.vertices.get(i).y + " " + model.vertices.get(i).z);
        }

    }
}