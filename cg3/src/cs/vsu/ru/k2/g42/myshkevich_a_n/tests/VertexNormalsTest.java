package cs.vsu.ru.k2.g42.myshkevich_a_n.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import cs.vsu.ru.k2.g42.myshkevich_a_n.Math.Vector3f;
import cs.vsu.ru.k2.g42.myshkevich_a_n.model.Model;
import cs.vsu.ru.k2.g42.myshkevich_a_n.normal.FindNormals;
import cs.vsu.ru.k2.g42.myshkevich_a_n.objreader.ObjReader;

class VertexNormalsTest {
	private static Model m = ObjReader.read("# Blender 4.0.1\r\n" + "# www.blender.org\r\n" + "o Cube\r\n"
			+ "v -1.000000 -1.000000 1.000000\r\n" + "v -1.000000 1.000000 1.000000\r\n"
			+ "v -1.000000 -1.000000 -1.000000\r\n" + "v -1.000000 1.000000 -1.000000\r\n"
			+ "v 1.000000 -1.000000 1.000000\r\n" + "v 1.000000 1.000000 1.000000\r\n"
			+ "v 1.000000 -1.000000 -1.000000\r\n" + "v 1.000000 1.000000 -1.000000\r\n"
			+ "vn -1.0000 -0.0000 -0.0000\r\n" + "vn -0.0000 -0.0000 -1.0000\r\n" + "vn 1.0000 -0.0000 -0.0000\r\n"
			+ "vn -0.0000 -0.0000 1.0000\r\n" + "vn -0.0000 -1.0000 -0.0000\r\n" + "vn -0.0000 1.0000 -0.0000\r\n"
			+ "vt 0.657719 0.070615\r\n" + "vt 0.657719 0.288779\r\n" + "vt 0.343923 0.288779\r\n"
			+ "vt 0.343923 0.070615\r\n" + "vt 0.982747 0.538081\r\n" + "vt 0.982747 0.758131\r\n"
			+ "vt 0.677420 0.758131\r\n" + "vt 0.677420 0.538418\r\n" + "vt 0.654372 0.535544\r\n"
			+ "vt 0.654372 0.758215\r\n" + "vt 0.344166 0.758215\r\n" + "vt 0.344166 0.535750\r\n"
			+ "vt 0.327407 0.537083\r\n" + "vt 0.327407 0.759706\r\n" + "vt 0.015414 0.759706\r\n"
			+ "vt 0.015414 0.536937\r\n" + "vt 0.656108 0.299368\r\n" + "vt 0.656108 0.524271\r\n"
			+ "vt 0.344171 0.524271\r\n" + "vt 0.344171 0.299368\r\n" + "vt 0.655295 0.773650\r\n"
			+ "vt 0.655295 0.993820\r\n" + "vt 0.346502 0.993820\r\n" + "vt 0.346502 0.773650\r\n" + "s 0\r\n"
			+ "f 1/1/1 2/2/1 4/3/1 3/4/1\r\n" + "f 3/5/2 4/6/2 8/7/2 7/8/2\r\n" + "f 7/9/3 8/10/3 6/11/3 5/12/3\r\n"
			+ "f 5/13/4 6/14/4 2/15/4 1/16/4\r\n" + "f 3/17/5 7/18/5 5/19/5 1/20/5\r\n"
			+ "f 8/21/6 4/22/6 2/23/6 6/24/6\r\n" + "");

	@BeforeAll
	static void init() {
		m.normals = FindNormals.findNormals(m);
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2, 3 })
	void findVertexTestX(int i) {
		assertEquals(Math.abs(Math.round(m.normals.get(i).x * 100)), 58);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2, 3 })
	void findVertexTestY(int i) {
		assertEquals(Math.abs(Math.round(m.normals.get(i).y * 100)), 58);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2, 3 })
	void findVertexTestZ(int i) {
		assertEquals(Math.abs(Math.round(m.normals.get(i).z * 100)), 58);
	}

}
