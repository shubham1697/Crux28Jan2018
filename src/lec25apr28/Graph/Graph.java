package lec25apr28.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	public class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vertices = new HashMap<>();

	public int numOfVertices() {
		return this.vertices.size();
	}

	public boolean containsVertex(String vname) {

		if (this.vertices.containsKey(vname)) {
			return true;
		}
		return false;

	}

	public void addVertex(String vname) {
		if (this.containsVertex(vname)) {
			return;
		}
		Vertex vtx = new Vertex();
		this.vertices.put(vname, vtx);
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = this.vertices.get(vname1);
		Vertex vtx2 = this.vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = this.vertices.get(vname1);
		Vertex vtx2 = this.vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);

	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = this.vertices.get(vname1);
		Vertex vtx2 = this.vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);

	}

	public int numOfEdges() {

		int sum = 0;

		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());

		for (String key : keys) {
			sum += this.vertices.get(key).nbrs.size();
		}

		return sum / 2;

	}

	public void display() {

		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());

		for (String key : keys) {
			Vertex vtx = this.vertices.get(key);
			String str = key + " => " + vtx.nbrs;
			System.out.println(str);
		}
		System.out.println();

	}

	public void removeVertex(String vname) {
		Vertex vtx = this.vertices.get(vname);

		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {

			this.removeEdge(vname, key);

		}
		this.vertices.remove(vname);
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		Vertex vtx = this.vertices.get(src);

		if (vtx.nbrs.containsKey(dst)) {
			return true;
		} else {
			ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

			for (String key : keys) {
				if (!processed.containsKey(key) && hasPath(key, dst, processed)) {
					return true;
				}
			}
		}

		return false;

	}

	private class Pair {
		String vname;
		String psf;
		Vertex vtx;
		String color;

		public Pair(String vname, String psf, Vertex vtx) {
			this.vname = vname;
			this.psf = psf;
			this.vtx = vtx;
		}

		public Pair(String vname, String psf, Vertex vtx, String color) {
			this.vname = vname;
			this.psf = psf;
			this.vtx = vtx;
			this.color = color;
		}
	}

	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		Pair np = new Pair(src, src, vertices.get(src));
		queue.addLast(np);

		while (!queue.isEmpty()) {

			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);

			if (this.containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

			for (String nbr : nbrkeys) {

				if (!processed.containsKey(nbr)) {
					Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr));
					queue.addLast(n);
				}

			}

		}
		return false;

	}

	public boolean dfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		Pair np = new Pair(src, src, vertices.get(src));
		stack.addFirst(np);

		while (!stack.isEmpty()) {

			Pair rp = stack.removeLast();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);

			if (this.containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

			for (String nbr : nbrkeys) {

				if (!processed.containsKey(nbr)) {
					Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr));
					stack.addLast(n);
				}

			}

		}
		return false;

	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> keys = new ArrayList<>(vertices.keySet());

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			Pair np = new Pair(key, key, vertices.get(key));
			queue.addLast(np);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

				for (String nbr : nbrkeys) {

					if (!processed.containsKey(nbr)) {
						Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr));
						queue.addLast(n);
					}

				}

			}
		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vertices.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			Pair np = new Pair(key, key, vertices.get(key));
			stack.addFirst(np);

			while (!stack.isEmpty()) {

				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

				for (String nbr : nbrkeys) {

					if (!processed.containsKey(nbr)) {
						Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr));
						stack.addFirst(n);
					}

				}

			}
		}

	}

	public boolean isConnected() {

		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> keys = new ArrayList<>(vertices.keySet());

		LinkedList<Pair> queue = new LinkedList<>();

		int count = 0;

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			if (count != 0) {
				return false;
			}

			count = count + 1;

			Pair np = new Pair(key, key, vertices.get(key));
			queue.addLast(np);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

				for (String nbr : nbrkeys) {

					if (!processed.containsKey(nbr)) {
						Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr));
						queue.addLast(n);
					}

				}

			}
		}
		return true;

	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> keys = new ArrayList<>(vertices.keySet());

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			Pair np = new Pair(key, key, vertices.get(key));
			queue.addLast(np);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;

				}

				processed.put(rp.vname, true);

				ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

				for (String nbr : nbrkeys) {

					if (!processed.containsKey(nbr)) {
						Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr));
						queue.addLast(n);
					}

				}

			}
		}
		return false;

	}

	public ArrayList<ArrayList<String>> getConnectedCompArrayList() {

		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> subans = new ArrayList<>();

			Pair np = new Pair(key, key, vertices.get(key));
			queue.addLast(np);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				subans.add(rp.vname);

				ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

				for (String nbr : nbrkeys) {

					if (!processed.containsKey(nbr)) {
						Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr));
						queue.addLast(n);
					}

				}

			}
			ans.add(subans);
		}
		return ans;

	}

	public boolean isTree() {

		if (isConnected() && !isCyclic()) {
			return true;
		}
		return false;

	}

	public boolean biPartite() {

		HashMap<String, String> processed = new HashMap<>();

		ArrayList<String> keys = new ArrayList<>(vertices.keySet());

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			Pair np = new Pair(key, key, vertices.get(key), "r");
			queue.addLast(np);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					String oc = processed.get(rp.vname);
					String nc = rp.color;
					if (!oc.equals(nc)) {
						return false;
					}
					continue;
				}

				processed.put(rp.vname, rp.color);

				System.out.println(rp.vname + " via " + rp.psf);

				ArrayList<String> nbrkeys = new ArrayList<>(rp.vtx.nbrs.keySet());

				for (String nbr : nbrkeys) {

					if (!processed.containsKey(nbr)) {
						String color = rp.color.equals("r") ? "g" : "r";
						Pair n = new Pair(nbr, rp.psf + nbr, vertices.get(nbr), color);
						queue.addLast(n);
					}

				}

			}
		}

		return true;

	}
}
