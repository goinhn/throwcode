/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.leetcode;

/**
 * @author fangwenzhan
 * @date 2021-06-06
 */
public class Main {
    public boolean findRotation(int[][] mat, int[][] target) {
        return spin_90(mat, target) || spin_180(mat, target) || spin_270(mat, target) || spin_360(mat, target);
    }

    public boolean spin_90(int[][] mat, int[][] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (mat[i][j] != target[j][target.length - i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean spin_180(int[][] mat, int[][] target) {
        for(int i = 0; i < target.length; i++) {
            for(int j = 0; j < target.length; j++) {
                if(mat[i][j] != target[target.length - i -1][target.length - j - 1]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean spin_270(int[][] mat, int[][] target) {
        for(int i = 0; i < target.length; i++) {
            for(int j = 0; j < target.length; j++) {
                if(mat[i][j] != target[target.length - j -1][i]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean spin_360(int[][] mat, int[][] target) {
        for(int i = 0; i < target.length; i++) {
            for(int j = 0; j < target.length; j++) {
                if(mat[i][j] != target[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
