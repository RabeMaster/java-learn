import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int maxSize = 1000000;

        // 모든 수의 약수를 저장할 배열
        long[] f = new long[maxSize + 1];
        long[] g = new long[maxSize + 1];

        // 1부터 N까지 1씩 증가하면서 반복
        for (int i = 1; i <= maxSize; i++) {
            // i의 배수에 i를 더하기
            for (int q = i; q <= maxSize; q += i) {
                f[q] += i;
            }
        }

        // 누적합 계산
        for (int i = 1; i <= maxSize; i++) {
            g[i] = g[i - 1] + f[i];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(g[N] + "\n");
        }

        bw.flush();
        bw.close();
    }
}