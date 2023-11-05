import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            String[] input = reader.readLine().split(" "); 
            int N = Integer.parseInt(input[0]); 
            int M = Integer.parseInt(input[1]); 
            int x = (1<<N) - 1;
            if ((M & x) == x) {
                System.out.println("#" + tc + " ON");
            }
            else {
                System.out.println("#" + tc + " OFF");
            }
        }
    }
}
