import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt(); // 처음 랜선의 개수
        int K = input.nextInt(); // 필요한 랜선의 개수
        // 정수형 요소를 갖는 리스트 
        ArrayList<Integer> churros = new ArrayList<>(); 
        for (int i = 0; i < N; i++) {
            churros.add(input.nextInt()); // 리스트에 요소 추가
        }
        Collections.sort(churros); // 오름차순으로 리스트 정렬

        if (K == 1) {
            System.out.println(churros.get(churros.size() - 1)); //리스트의 가장 마지막 요소를 출력
            System.exit(0); // 프로그램 종료 
        }
        long start = 1;
        long end = churros.get(churros.size() - 1);
        while (start <= end) {
            boolean tof = false;
            long mid = (start + end) / 2;
            long res = 0;
            for (int i = 0; i < N; i++) {
                res += churros.get(i) / mid;
                if (res >= K) {
                    start = mid + 1;
                    tof = true;
                    break;
                }
            }
            if (!tof) {
                end = mid - 1;
            }
        }
        System.out.println(end);
        input.close();
    }
}