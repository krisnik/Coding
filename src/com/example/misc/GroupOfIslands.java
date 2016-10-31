package com.example.misc;

public class GroupOfIslands {

    public int numIslands(char[][] grid) {
        int x = 0;
        int y = 0;


        int totalCount = 0;

        if(grid.length > 0 && grid[0].length > 0) {
            boolean visited[][] = new boolean[grid.length][grid[0].length];

            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1' && !visited[i][j]) {
                        findIslands(grid, i, j, visited);
                        totalCount += 1;
                    }
                }
            }
        }

        return totalCount;
    }

    public void findIslands(char[][] grid, int x, int y, boolean[][] visited) {
        if(x < grid.length && y < grid[0].length) {
            visited[x][y] = true;
        }

        if(x < grid.length - 1) {
            if(grid[x+1][y] == '1' && !visited[x+1][y]) {
                findIslands(grid, x+1, y, visited);
            }
        }
        if(y < grid[0].length - 1) {
            if(grid[x][y+1] == '1' && !visited[x][y+1]) {
                findIslands(grid, x, y+1, visited);
            }
        }

        if(x > 0) {
            if(grid[x - 1][y] == '1' && !visited[x-1][y]) {
                findIslands(grid, x-1, y, visited);
            }
        }

        if(y > 0) {
            if (grid[x][y - 1] == '1' && !visited[x][y - 1]) {
                findIslands(grid, x, y - 1, visited);
            }
        }
    }
}