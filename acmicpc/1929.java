import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        sc.close();

        //소수 체크용 배열 선언
        boolean[] arr = new boolean[end + 1];
        for (int i = 0; i <= end; i++) {
            arr[i] = true; //모든 수가 소수라고 지정
        }
        arr[1] = false; //1은 제외

        //에라토스테네스의체
        for (int i = 2; i * i <= end; i++) {
            if (arr[i]) {
                for (int q = i * i; q <= end; q += i) {
                    arr[q] = false;
                }
            }
        }

        //출력
        for (int i = start; i <= end; i++) {
            if (arr[i]) {
                System.out.println(i); //소수 출력
            }
        }
    }
}