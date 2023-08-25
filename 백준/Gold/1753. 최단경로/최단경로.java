import java.io.*;
import java.util.*;

public class Main {
	static int V, E, K;
	static List<List<Node>> nodes = new ArrayList<>(); 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=V; i++) nodes.add(new ArrayList<>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			nodes.get(from).add(new Node(to, wei));
		}
		
		// solution
		dijkstra();
		
		// output
		System.out.println(sb);
	}

	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V+1];
		queue.offer(new Node(K, 0));
		distance[K] = 0;
		visited[K] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			for(Node next : nodes.get(now.idx)) {
				if(distance[next.idx] <= distance[now.idx]+next.wei) continue;
				distance[next.idx] = distance[now.idx]+next.wei;
				queue.offer(new Node(next.idx, distance[next.idx]));
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(distance[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
	}
}

class Node implements Comparable<Node> {
	int idx, wei;
	
	public Node(int idx, int wei) {
		this.idx = idx;
		this.wei = wei;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.wei - node.wei;
	}
}