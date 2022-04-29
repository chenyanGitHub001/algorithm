import java.util.Scanner;
import java.util.regex.Matcher;

public class searchMatrx {
    /*
    题目描述：实现一个程序 search_matrix(matrix),参数 matrix 是一个仅包含 0 或 1 两种数字的矩阵,程序应返回输入矩阵中包含的最大正方形子矩阵(长和宽相等)的区域面积。
例如:如果 matrix 是[“1010111111”,“000000011”,“1010110111”,“0000110001”,那么它看起来像下面的阵:
1010111111
0000000111
1010110111
0000110001
对于上面的输入,最大的子矩阵是一个 3x3 的矩阵,程序只要返回最大子矩阵的面积即可,如上面的矩阵即返回 9(3x3)。
输入描述:
第 1 行输入为一个数字 N,代表下面有几行
第 2 行到第 N+1 行是代表矩阵的 0 和 1 组成的字符串,每行的长度相同
输出描述:
返回一个数字,代表输入矩阵的最大正方子矩阵的面积。
示例 1
输入
3
110
111
110
输入
4
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[][] matrx = new String[num][num];
        int [][] dp = new int[num][num];
        for(int i=0;i<num;i++){
            System.out.println("SHURU");
            String[] key = scanner.nextLine().split("");
            for(int j=0;j<num;j++){
                matrx[i][j]=key[j];
            }
        }
        int len=0;
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if (matrx[i][j].equals("1")){
                    if(i==0|j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    len=Math.max(dp[i][j],len);
                }
            }
        }
        for(int i=0;i<num;i++){
            System.out.println();
            for(int j=0;j<num;j++){
            System.out.print(dp[i][j]+" ");}
        }

        System.out.println(len*len);

    }
}
