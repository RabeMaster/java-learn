import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.close();

        // 모든 수의 약수를 저장할 배열
        long[] f = new long[N + 1];

        // 1부터 N까지 1씩 증가하면서 반복
        for (int i = 1; i <= N; i++) {
            // i의 배수에 i를 더하기
            for (int q = i; q <= N; q += i) {
                f[q] += i;
            }
        }

        long result = 0;
        for (int i = 1; i <= N; i++) {
            result += f[i];
        }

        System.out.println(result);
        
    }
}