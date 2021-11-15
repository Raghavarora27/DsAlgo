public class Leetcode_733 {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
            floodfill(image, sr, sc, newColor, dir);
            return image;
        }

        public void floodfill(int[][] image, int sr, int sc, int newColor, int[][] dir) {
            int original = image[sr][sc];
            if (original == newColor)
                return;

            image[sr][sc] = newColor;

            for (int d = 0; d < dir.length; d++) {
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];

                if (r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == original) {
                    floodfill(image, r, c, newColor, dir);
                }
            }
        }
    }
}