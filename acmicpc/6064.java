import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split(" ");
            int M = Integer.parseInt(data[0]);
            int N = Integer.parseInt(data[1]);
            int x = Integer.parseInt(data[2]);
            int y = Integer.parseInt(data[3]);

            int result = x;
            int LCM = getLCM(M, N);
            while (true) {
                if (result > LCM) {
                    result = -1;
                    break;
                }
                if ((result - 1) % N + 1 == y) {
                    break;
                }
                result += M;
            }
            bw.write(result + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}