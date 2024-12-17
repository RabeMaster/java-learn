import java.util.Scanner;

public class Main {
    private static int solve(int n) {
        int lastMod = 0;
        for (int i = 1; ; i++) {
            lastMod = (lastMod * 10 + 1) % n;
            if (lastMod == 0) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }

        sc.close();
    }
}