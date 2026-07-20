class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0; 
        int right = rows * cols - 1;
        int middle;

        while(left <= right){
            middle = (left + right) / 2;
            int now_rows = middle / cols;
            int now_cols = middle % cols;
            int get_num = matrix[now_rows][now_cols];
            if(get_num == target) return true;
            if(get_num > target) {
                right = middle - 1;
            }else{
                left = middle + 1;
            } 
        }

        return false;
    }
}
