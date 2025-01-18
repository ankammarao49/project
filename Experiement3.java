package AoA;

public class Experiement3 {
    
    public static int matrixChainOrder(int[] p, int n) {
        int[][] m = new int[n][n];  
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;  
        }
        
        for (int length = 2; length < n; length++) {  
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }
        
        return m[1][n - 1];
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 4}; 
        int n = p.length;
        System.out.println("Minimum cost of matrix multiplication: " + matrixChainOrder(p, n));
    }
}

