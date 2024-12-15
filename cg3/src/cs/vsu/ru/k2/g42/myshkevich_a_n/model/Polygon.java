package cs.vsu.ru.k2.g42.myshkevich_a_n.model;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

	private ArrayList<Integer> vertexIndices;
	private ArrayList<Integer> textureVertexIndices;
	private ArrayList<Integer> normalIndices;

	public Polygon() {
	}

	public Polygon(List<Integer> a) {
		vertexIndices = new ArrayList<Integer>();
		for (Integer i : a) {
			vertexIndices.add(i);
		}
		textureVertexIndices = new ArrayList<Integer>();
		normalIndices = new ArrayList<Integer>();
	}

	public void setVertexIndices(ArrayList<Integer> vertexIndices) {
		assert vertexIndices.size() >= 3;
		this.vertexIndices = vertexIndices;
	}

	public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
		assert textureVertexIndices.size() >= 3;
		this.textureVertexIndices = textureVertexIndices;
	}

	public void setNormalIndices(ArrayList<Integer> normalIndices) {
		assert normalIndices.size() >= 3;
		this.normalIndices = normalIndices;
	}

	public ArrayList<Integer> getVertexIndices() {
		return vertexIndices;
	}

	public ArrayList<Integer> getTextureVertexIndices() {
		return textureVertexIndices;
	}

	public ArrayList<Integer> getNormalIndices() {
		return normalIndices;
	}
}