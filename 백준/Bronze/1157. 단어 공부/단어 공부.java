import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26]; // 알파벳 빈도 저장 배열
        String str = br.readLine().toUpperCase(); // 입력을 대문자로 변환

        // 알파벳 빈도 계산
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }

        int max = 0; // 최대 빈도
        int idx = -1; // 최대 빈도의 알파벳 인덱스
        boolean isTie = false; // 동률 여부 확인

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
                isTie = false; // 새로운 최대값이 나오면 동률 초기화
            } else if (arr[i] == max && max != 0) {
                isTie = true; // 동률 발생
            }
        }

        // 결과 출력
        System.out.println(isTie ? "?" : (char) (idx + 'A'));
    }
}