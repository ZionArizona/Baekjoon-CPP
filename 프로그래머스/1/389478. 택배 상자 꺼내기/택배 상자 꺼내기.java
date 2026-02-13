class Solution {
    public int solution(int n, int w, int num) {
        int h = (n + w - 1) / w;       // 필요한 층 수(올림)
        int[][] arr = new int[h][w];

        int val = 1;

        for (int row = 0; row < h; row++) {
            if (row % 2 == 0) { // 왼 -> 오른
                for (int col = 0; col < w; col++) {
                    if (val > n) break;
                    arr[row][col] = val++;
                }
            } else { // 오른 -> 왼
                for (int col = w - 1; col >= 0; col--) {
                    if (val > n) break;
                    arr[row][col] = val++;
                }
            }
        }

        // num의 위치 찾기
        int targetRow = (num - 1) / w;
        int targetCol;
        if (targetRow % 2 == 0) {
            targetCol = (num - 1) % w;
        } else {
            targetCol = w - 1 - ((num - 1) % w);
        }

        int answer = 0;
        for (int r = targetRow; r < h; r++) {
            if (arr[r][targetCol] != 0) answer++;
        }

        return answer;
    }
}
