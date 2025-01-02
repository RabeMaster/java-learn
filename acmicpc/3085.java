import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static char[][] board; // 보드 선언

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static int getMaxScore() {
        int maxScore = 0;

        // 행 점수체크
        for (int i = 0; i < N; i++) {
            int score = 1;
            for (int q = 0; q < N - 1; q++) {
                if (board[i][q] == board[i][q + 1]) {
                    score++;
                } else {
                    maxScore = Math.max(maxScore, score);
                    score = 1;
                }
            }
            maxScore = Math.max(maxScore, score);
        }

        // 열 점수체크
        for (int i = 0; i < N; i++) {
            int score = 1;
            for (int q = 0; q < N - 1; q++) {
                if (board[q][i] == board[q + 1][i]) {
                    score++;
                } else {
                    maxScore = Math.max(maxScore, score);
                    score = 1;
                }
            }
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxScore = 0;
        N = Integer.parseInt(br.readLine());
        board = new char[N][N]; // 보드 크기 선언

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray(); // 입력받기
        }
        br.close();

        for (int x = 0; x < N; x++) { // 행
            for (int y = 0; y < N; y++) { // 열
                //하
                if (y < N - 1) {
                    swap(x, y, x, y + 1); //스왑
                    maxScore = Math.max(maxScore, getMaxScore());
                    swap(x, y, x, y + 1); //복구
                }
                //우
                if (x < N - 1) {
                    swap(x + 1, y, x, y); //스왑
                    maxScore = Math.max(maxScore, getMaxScore());
                    swap(x + 1, y, x, y); //복구
                }
            }
        }

        bw.write(String.valueOf(maxScore));

        bw.flush();
        bw.close();
    }
}