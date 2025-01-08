import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    // 바로 누를수 있는 길이 리턴
    public static int isValidChannel(int targetChannel, boolean[] buttons) {
        int length = 0;

        if (targetChannel == 0) { // 특수케이스
            return !buttons[0] ? 0 : 1;
        }

        while (targetChannel > 0) {
            if (!buttons[targetChannel % 10]) {
                return 0; // 고장나서 바로 입력못함
            }
            targetChannel /= 10;
            length++;
        }
        return length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int targetChannel = Integer.parseInt(br.readLine());
        int brokenButtonCount = Integer.parseInt(br.readLine());

        boolean[] buttons = new boolean[10];
        Arrays.fill(buttons, true);

        // 버튼 고장난게 있을 때만 입력받음
        if (brokenButtonCount != 0) {
            String[] data = br.readLine().split(" ");
            for (int i = 0; i < brokenButtonCount; i++) {
                buttons[Integer.parseInt(data[i])] = false;
            }
        }
        br.close();

        int minLength = Math.abs(100 - targetChannel);

        // 채널은 0~500000까지이므로 위 아래 탐색을 위해 999999까지 반복
        for (int i = 0; i <= 999999; i++) {
            int length = isValidChannel(i, buttons);
            if (length != 0) { // 바로 누를 수 있다면
                int buttonCount = length + Math.abs(i - targetChannel); // 버튼 횟수 + 부족한 이동횟수
                minLength = Math.min(minLength, buttonCount);
            }
        }

        bw.write(String.valueOf(minLength));

        bw.flush();
        bw.close();
    }
}