import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int tc=1 ; tc < T+1; tc++) {
            int N = Integer.parseInt(reader.readLine());
            int ans = 0;
            int check = 0;
            int k = 1;
            int x = (1<<10) - 1;
            boolean tof = false;
            while (true) {
                int num = k * N;
                int length = (int)(Math.log10(num) + 1);
                for (int i = 0; i < length; i++){
                    int c = num % 10;
                    num /= 10;
                    check = check|(1 << c);
                    if (check == x) {
                        tof = true;
                        break;
                    }
                }
                if (tof) {
                    break;
                }
                k ++;
            }
            ans = k * N;
            System.out.println("#"+ tc + ' ' + ans);
        }


    }
}
