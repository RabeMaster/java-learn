import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int N;
    static int M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        br.close();

        result = new int[M];

        backtracking(0);

        bw.close();
    }

    private static void backtracking(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(result[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int q = (depth > 0) ? result[depth - 1] : 1; q <= N; q++) {
            result[depth] = q;
            backtracking(depth + 1);
        }
    }
}