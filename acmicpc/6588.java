import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                sc.close();
                break;
            }

            boolean flag = false;
            for (int i = 3; i <= N; i += 2) {
                if (prime[i] && prime[N - i]) {
                    System.out.println(N + " = " + i + " + " + (N - i));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}