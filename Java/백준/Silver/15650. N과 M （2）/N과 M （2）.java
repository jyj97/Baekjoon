import java.util.*;


public class Main {
	static int n;
	static int m;
	static int[] numbers;
	
	public static void combination(int cnt, int start) {
		if (cnt == m) {
			for(int idx = 0; idx < m; idx++) {
				System.out.print(numbers[idx] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i = start; i <= n; i++) {
				numbers[cnt] = i;
				combination(cnt+1, i+1);	
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[m];
		combination(0, 1);
		sc.close();
	}
}