class Solution {
    private static final int LAND = 1;
    private static final int VISITED_LAND = 2;
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> farmlandList = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == LAND) {
                    int[] farmland = findFarmlandBounds(i, j, land);
                    farmlandList.add(farmland);
                }
            }
        }

        return farmlandList.toArray(new int[farmlandList.size()][]);
    }

    private int[] findFarmlandBounds(int row, int col, int[][] land) {
        int minRow = row, minCol = col, maxRow = row, maxCol = col;
        int[] result = {row,col,row,col};

        dfs(row, col, land, result);

        return result;
    }

    private void dfs(int row, int col, int[][] land,int[] result) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[0].length || land[row][col] != LAND)          {
            return;
        }

        land[row][col] = VISITED_LAND;
        if (row + col < result[0] + result[1]) {
            result[0] = row;
            result[1] = col;
        }

        if (row + col > result[2] + result[3]) {
            result[2] = row;
            result[3] = col;
        }

        for (int i = 0; i < DX.length; i++) {
            dfs(row + DX[i], col + DY[i], land, result);
        }
    }
}
