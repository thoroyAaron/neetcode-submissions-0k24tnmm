class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowMask = new int[9];
        int[] colMask = new int[9];
        int[] tabMask = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int bit = 1 << (board[i][j] - '0');  // 把数字转成对应的位
                int tabNum = i / 3 * 3 + j / 3;

                // 检测是否已存在
                if ((rowMask[i] & bit) != 0) return false;
                if ((colMask[j] & bit) != 0) return false;
                if ((tabMask[tabNum] & bit) != 0) return false;

                // 标记为已存在
                rowMask[i] |= bit;
                colMask[j] |= bit;
                tabMask[tabNum] |= bit;
            }
        }
        return true;
    }
}