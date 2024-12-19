import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        final int maxSize = 1000000;

        // 소수 체크용 배열 선언
        boolean[] prime = new boolean[maxSize + 1];

        for (int i = 0; i <= maxSize; i++) {
            prime[i] = true; // 전부 소수라고 가정
        }
        prime[1] = false; // 1은 제외

        // 에라토스테네스의 체
        for (int i = 2; i * i <= maxSize; i++) {
            if (prime[i]) {
                for (int q = i * i; q <= maxSize; q += i) {
                    prime[q] = false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                br.close();
                break;
            }

            boolean flag = false;
            for (int i = 3; i <= N; i += 2) {
                if (prime[i] && prime[N - i]) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(N).append(" = ").append(i).append(" + ").append(N - i).append("\n");
                    bw.write(sb.toString());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }
        bw.flush();
        bw.close();
    }
}