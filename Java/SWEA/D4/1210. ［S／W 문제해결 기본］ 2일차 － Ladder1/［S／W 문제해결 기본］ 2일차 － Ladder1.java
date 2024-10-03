import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {

        //input.txt 파일로 표준 입력 설정하려 함 (테스트를 위함)
        // File inputFile = new
        // File("C:\\Users\\rkdtm\\OneDrive\\바탕 화면\\code-save\\jav\\src\\input.txt");
        // System.setIn(new FileInputStream(inputFile));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test = 1; test <= 10; test++) {
            // 1. 각 케이스마다 입력받기
            // 테스트 케이스 번호
            //int test_case = Integer.parseInt(br.readLine());
            int test_case = Integer.parseInt(br.readLine().trim());

            // 사다리 배열 입력받기.
            // 정수로 받으려면 일일히 형변환해야해서 시간 더 걸리지 않을까
            // 싶다는 생각이 들었다.
            String[][] cross = new String[100][];

            for (int row = 0; row < 100; row++) {
                String[] a = br.readLine().trim().split(" ");
                cross[row] = a;
            }

            // 2. 맨 밑에 행에서 도착지점 즉 요소값이 "2" 인 열 값을 찾는다.
            // 나는 밑에서부터 거꾸로 올라갈 것이기 때문이다.
            int start_col = -1;
            for (int col = 0; col < 100; col++) {
                if (cross[99][col].equals("2")) {
                    start_col = col;
                    break;
                }
            }

            // 시작하는 배열 인덱스는 [99][start_col]
            int row = 99;
            int col = start_col;

            while (row > 0) {
                // 왼쪽으로 갈 수 있는지 체크
                if (col > 0 && cross[row][col - 1].equals("1")) {
                    while (col > 0 && cross[row][col - 1].equals("1")) {
                        col--;
                    }
                }
                // 오른쪽으로 갈 수 있는지 체크
                else if (col < 99 && cross[row][col + 1].equals("1")) {
                    while (col < 99 && cross[row][col + 1].equals("1")) {
                        col++;
                    }
                }
                // 위로 이동
                row--;
            }

            System.out.printf("#%d %d\n", test_case, col);
        }
        br.close();
    
    }
}
