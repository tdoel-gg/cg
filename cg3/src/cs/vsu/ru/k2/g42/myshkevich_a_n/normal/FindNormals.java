package cs.vsu.ru.k2.g42.myshkevich_a_n.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector3f;
import cs.vsu.ru.k2.g42.myshkevich_a_n.model.Model;
import cs.vsu.ru.k2.g42.myshkevich_a_n.model.Polygon;

public class FindNormals {
	public static ArrayList<Vector3f> findNormals(Model m) {
		List<Polygon> polygons = m.polygons;
		List<Vector3f> vertices = m.vertices;

		ArrayList<Vector3f> temporaryNormals = new ArrayList<>();
		ArrayList<Vector3f> normals = new ArrayList<>();

		for (Polygon p : polygons) {
			temporaryNormals.add(FindNormals.findPolygonsNormals(vertices.get(p.getVertexIndices().get(0)),
					vertices.get(p.getVertexIndices().get(1)), vertices.get(p.getVertexIndices().get(2))));
		}

		Map<Integer, Set<Vector3f>> vertexPolygonsMap = new HashMap<>();
		for (int j = 0; j < polygons.size(); j++) {
			List<Integer> vertexIndices = polygons.get(j).getVertexIndices();
			Vector3f vec = temporaryNormals.get(j);
			for (Integer index : vertexIndices) {
		        vertexPolygonsMap.computeIfAbsent(index, k -> new HashSet<>()).add(vec);
		    }
		}

		for (int i = 0; i < vertices.size(); i++) {
			normals.add(findVertexNormals(vertexPolygonsMap.get(i)));
		}
		
		return normals;
	}

	public static Vector3f findPolygonsNormals(Vector3f... vs) {
		Vector3f a = Vector3f.subtraction(vs[0], vs[1]);
		Vector3f b = Vector3f.subtraction(vs[0], vs[2]);

		Vector3f c = vectorProduct(a, b);
		if (determinant(a, b, c) < 0) {
			c = vectorProduct(b, a);
		}

		return normalize(c);
	}

	public static Vector3f findVertexNormals(Set<Vector3f> vs) {
		float xs = 0, ys = 0, zs = 0;

		for (Vector3f v : vs) {
			xs += v.x;
			ys += v.y;
			zs += v.z;
		}

		xs /= vs.size();
		ys /= vs.size();
		zs /= vs.size();

		return normalize(new Vector3f(xs, ys, zs));
	}

	public static double determinant(Vector3f a, Vector3f b, Vector3f c) {
		return a.x * (b.y * c.z) - a.y * (b.x * c.z - c.x * b.z) + a.z * (b.x * c.y - c.x * b.y);
	}

	public static Vector3f normalize(Vector3f v) {
		if (v == null) {
			return null;
		}

		double length = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z);

		if (length == 0) {
			return new Vector3f(0, 0, 0);
		}

		v.x /= length;
		v.y /= length;
		v.z /= length;

		return new Vector3f(v.x, v.y, v.z);
	}

	public static Vector3f vectorProduct(Vector3f a, Vector3f b) {
		return new Vector3f(a.y * b.z - b.y * a.z, -a.x * b.z + b.x * a.z, a.x * b.y - b.x * a.y);
	}
}
