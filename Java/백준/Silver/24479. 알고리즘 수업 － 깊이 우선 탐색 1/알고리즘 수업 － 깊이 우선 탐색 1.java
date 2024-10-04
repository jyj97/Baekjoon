import java.util.*;
public class Main {
	public static boolean[] visited;
	public static List<Integer>[] graph;
	public static int[] answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		visited = new boolean[n + 1];
		graph= new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int iter = 0; iter < m; iter++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start].add(end);
			graph[end].add(start);
		}
		
		for(int iter = 1; iter <= n; iter++) {
			Collections.sort(graph[iter]);
		}
		
		answer = new int[n];
		dfs(r);
		for(int i : answer) {
			System.out.println(i);
		}
		
		sc.close();
	}
	
	static int count = 1;
	
	public static void dfs(int x) {
		visited[x] = true;
		answer[x - 1] = count++; 
		
		boolean check = false;
		for(int t : graph[x]) {
			if(visited[t]) {
				continue;
			}
			check = true;
			dfs(t);
		}
		
	}
	
}
