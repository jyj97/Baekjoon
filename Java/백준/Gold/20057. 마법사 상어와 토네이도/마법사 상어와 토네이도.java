import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int answer;
    static int[] now;

    // 각각 현재 토네이도 중심 위치 기점 x축으로 이동할 위치, y축으로 이동할 위치, 그리고 해당 지역에 모래가 흩날려지는 비율 
    static int[][] left = {{-2, 0, 2}, {-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1}, {0, -2, 5}, {1, -1, 10}, {1, 0, 7}, {1, 1, 1}, {2, 0, 2}, {0, -1, 0}}; 
    // 왼쪽으로 한 칸 갈때, 모래 흩날리는 비율 (y 위치 기준)
    static int[][] right = {{-2, 0, 2}, {-1, 1, 10}, {-1, 0, 7}, {-1, -1, 1}, {0, 2, 5}, {1, 1, 10}, {1, 0, 7}, {1, -1, 1}, {2, 0, 2}, {0, 1, 0}}; 
    // 오른쪽으로 한 칸 갈때, 모래 흩날리는 비율 (y 위치 기준)
    static int[][] up = {{0, -2, 2}, {-1, -1, 10}, {0, -1, 7}, {1, -1, 1}, {-2, 0, 5}, {-1, 1, 10}, {0, 1, 7}, {1, 1, 1}, {0, 2, 2}, {-1, 0, 0}}; 
    // 위쪽으로 한 칸 갈때, 모래 흩날리는 비율 (y 위치 기준)
    static int[][] down = {{0, -2, 2}, {1, -1, 10}, {0, -1, 7}, {-1, -1, 1}, {2, 0, 5}, {1, 1, 10}, {0, 1, 7}, {-1, 1, 1}, {0, 2, 2}, {1, 0, 0}}; 
    // 아래쪽으로 한 칸 갈때, 모래 흩날리는 비율 (y 위치 기준)
    // 알파 위치 모래 양은, y위치 전체 양에서 나머지 흩날리는 양 뺀 값으로 구한다.
    

    // 오른쪽으로 몇 칸, 왼쪽으로 몇 칸 이렇게 한 방향으로 여러 칸 이동하는 그 과정을 다 다룬다. 그래서 한 칸 한칸 갈 때마다의 모래량 변화를 저장하고, graph 밖으로 나가는 모래 량도 카운트 한다.
    public static void move(int cnt, int dx, int dy, int[][] direc){
        int sand = 0;
        // 해당 방향으로 cnt만큼 한칸씩 이동하는 절차
        for(int idx = 0; idx <= cnt; idx++){

            now[0] += dx; now[1] += dy;
            // 제일마지막에 토네이도 중심은 0,0 에서 아웃된다.
            // 그래서 그걸 보는 조건문
            if (now[0] < 0 || now[1] < 0){
                break;
            }


            int spreads = 0; // 모래 퍼진 양
            for (int[] wind : direc){
                // 토네이도에 의해 모래 흩날려지는 위치
                int tx = now[0] + wind[0];
                int ty = now[1] + wind[1];

                // 알파자리는 비율로 두지 않고 0으로 두었다.
                // 기존에 흩뿌려진 것들 다 카운트 한 후 처음 흩날리기 전 모래량에서 이걸 빼면 된다.
                if (wind[2] == 0){
                    sand = graph[now[0]][now[1]] - spreads;
                }
                else{
                    // 소수자리는 버리라 했으므로 철저하게 int 도배
                    sand = (int) ((int)graph[now[0]][now[1]] * (int)wind[2] / (int)100);
                }

                // 토네이도에 의해 각 위치별 모래가 날라가지는거 그거 계산
                if(tx >= 0 && tx < n && ty >= 0 && ty < n){
                    graph[tx][ty] += sand;
                }
                // 만약 graph 밖에 있으면 이건 정답류로 계산
                else{
                    answer += sand;
                }
                spreads += sand;
            }
            // 현 위치 모래는 다 날라갔지.
            graph[now[0]][now[1]] = 0;
        }
    }


    public static void main(String[] args) {
        // 입력들 받기
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        graph = new int[n][n];
        for(int row = 0; row < n; row++){
            String[] tmp = sc.nextLine().trim().split(" ");

            for(int col = 0; col < n; col++){
                graph[row][col] = Integer.parseInt(tmp[col]);
            }
        }

        answer = 0;
        now = new int[]{n/2, n/2}; // 현재 x, y 좌표


        // 왼쪽 아래 1칸  오른 위 2칸 왼 아래 3칸 ... 이런 주기성을 보인다.
        for(int idx = 0; idx < n; idx++){
            if(idx % 2 == 0){
                move(idx, 0, -1, left);
                move(idx, 1, 0, down);
            }
            else{
                move(idx, 0, 1, right);
                move(idx, -1, 0, up);
            }
        }
        // 정답 출력
        System.out.println(answer);
        sc.close();
    }
}