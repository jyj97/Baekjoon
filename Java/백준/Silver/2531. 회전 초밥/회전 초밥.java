import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 접시의 수
        int d = sc.nextInt(); // 초밥의 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시 수
        int c = sc.nextInt(); // 쿠폰 번호

        int[] li = new int[n];
        for (int i = 0; i < n; i++){
            li[i]= sc.nextInt();
        }

        // 슬라이딩 윈도우에 포함된 초밥의 개수를 세기 위한 배열
        int[] sushiCount = new int[d + 1];
        int variety = 0;  // 현재 종류의 수
        int answer = 0;

        // 처음 k개의 접시를 윈도우에 추가
        for (int i = 0; i < k; i++) {
            if (sushiCount[li[i]] == 0) {
                variety++;
            }
            sushiCount[li[i]]++;
        }

        // 쿠폰으로 먹는 초밥이 포함되어 있는지 확인
        answer = variety + (sushiCount[c] == 0 ? 1 : 0);

        // 슬라이딩 윈도우 방식으로 순환하면서 최대 종류를 계산
        for (int i = 1; i < n; i++) {
            // 이전 창의 첫 접시 제거
            int removeIndex = li[i - 1];
            sushiCount[removeIndex]--;
            if (sushiCount[removeIndex] == 0) {
                variety--;
            }

            // 새로 들어오는 접시 추가
            int addIndex = li[(i + k - 1) % n];
            if (sushiCount[addIndex] == 0) {
                variety++;
            }
            sushiCount[addIndex]++;

            // 쿠폰 초밥 포함 여부를 고려하여 최대 종류 계산
            answer = Math.max(answer, variety + (sushiCount[c] == 0 ? 1 : 0));
        }

        System.out.println(answer);

        sc.close();
    }
}