class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowHashSet = new HashSet[9];
        HashSet<Character>[] colHashSet = new HashSet[9];
        HashSet<Character>[] tabHashSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowHashSet[i] = new HashSet<>();
            colHashSet[i] = new HashSet<>();
            tabHashSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                boolean rowAddSuc = rowHashSet[i].add(board[i][j]);
                boolean colAddSuc = colHashSet[j].add(board[i][j]);
                int tabNum = (i / 3) * 3 + j / 3;
                boolean tabAddSuc = tabHashSet[tabNum].add(board[i][j]);
                if (! (rowAddSuc && colAddSuc && tabAddSuc)) {
                    return false;
                }
            }
        }
        return true;
    }
}
