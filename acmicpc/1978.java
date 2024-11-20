import java.util.Scanner;

public class Main {

    public static boolean isPrimeNumber(final int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= (number - 1); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            if (isPrimeNumber(number)) {
                count++;
            }
        }

        sc.close();

        System.out.println(count);
    }
}