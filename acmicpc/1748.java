import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int getDigitCount(int i) {
        int count = 1;
        while (i >= 10) {
            i /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            sum += getDigitCount(i);
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}