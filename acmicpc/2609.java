import java.util.Scanner;

public class Main {
    public static int getGCD(int a, int b) {
        int GCD = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if ((a % i == 0) && (b % i == 0)) {
                GCD = i;
            }
        }
        return GCD;
    }

    public static int gebLCM(int a, int b) {
        for (int i = Math.max(a, b); i <= a * b; i++) {
            if ((i % a == 0) && (i % b == 0)) {
                return i;
            }
        }
        return a * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        System.out.println(getGCD(a, b));
        System.out.println(gebLCM(a, b));
    }
}