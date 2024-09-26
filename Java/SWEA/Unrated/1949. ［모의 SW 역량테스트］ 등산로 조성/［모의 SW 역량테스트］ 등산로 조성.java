import java.util.*;
 
public class Solution {
    static int n, k, top, answer;
    static int[][] map;

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
         
        for(int t = 1; t <= test; t++) {
        	n = sc.nextInt();
        	k = sc.nextInt();
        	map = new int[n][n];
        	top = Integer.MIN_VALUE;
        	
        	for(int r = 0; r < n; r++) {
        		for(int c = 0; c < n; c++) {
        			map[r][c] = sc.nextInt();
        			
        			if(map[r][c] > top) {
        				top = map[r][c];
        				
        			}
        		}
        	}
        	
        	
        	answer = Integer.MIN_VALUE;
        	for(int r = 0; r < n; r++) {
        		for(int c = 0; c < n; c++) {
        			if(map[r][c] == top) {
        				visited = new boolean[n][n];
        	    		dfs(r, c, 1, false);
        			}
        		}
        	}
        	

            System.out.println("#" + t + " " + answer);
        }
         
        sc.close();
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public static void dfs(int x, int y, int len, boolean cut) {
    	
    	visited[x][y] = true;
		if(answer < len) {
			answer = len;
		}

    	for(int d = 0; d < 4; d++) {
    		int nx = x + dx[d]; int ny = y + dy[d];
    		if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			if(visited[nx][ny]) {
				continue;
			}
			
			if(map[nx][ny] >= map[x][y] && !cut && map[nx][ny] - map[x][y] < k) {
				int tmp = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;
				
				dfs(nx, ny, len + 1, true);
				map[nx][ny] = tmp;
				visited[nx][ny] = false;
			}
			
			if(map[nx][ny] < map[x][y]) {
				
				dfs(nx, ny, len + 1, cut);
				visited[nx][ny] = false;
			}
			
    	}
    	return;
    }
}