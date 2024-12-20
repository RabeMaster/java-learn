import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] people = new int[9];
        int sum = 0;

        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(br.readLine());
            sum += people[i];
        }
        br.close();

        for (int i = 0; i < people.length - 1; i++) {
            for (int q = i + 1; q < people.length; q++) {
                if ((sum - people[i] - people[q]) == 100) {
                    people[i] = -1;
                    people[q] = -1;
                    Arrays.sort(people);
                    for (int j = 2; j < people.length; j++) {
                        bw.write(people[j] + "\n");
                    }
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }
}