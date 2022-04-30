import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MonkeysEatPeaches {
    /*
    题目描述：孙悟空喜欢吃蟠桃，一天他乘守卫蟠桃园的天兵天将离开了而偷偷的来到王母娘娘的蟠桃园偷吃蟠桃。已知蟠桃园有 N 棵蟠桃树，第 i 棵蟠桃树上有 N[i]（大于 0）
个蟠桃，天兵天将将在 H（不小于蟠桃树棵数）小时后回来。孙悟空可以决定他吃蟠桃的速度 K（单位：个/小时），每个小时他会选则一颗蟠桃树，从中吃掉 K 个蟠桃，如果
这棵树上的蟠桃数小于 K，他将吃掉这棵树上所有蟠桃，然后这一小时内不再吃其余蟠桃树上的蟠桃。孙悟空喜欢慢慢吃，但仍想在天兵天将回来前将所有蟠桃吃完。求孙悟
空可以在 H 小时内吃掉所有蟠桃的最小速度 K（K 为整数）。
输入描述
从标准输入中读取一行数字，前面数字表示每棵数上蟠桃个数，最后的数字表示天兵天将将离开的时间。
输出描述
吃掉所有蟠桃的最小速度 K（K 为整数）或输入异常时输出-1。
示例 1
输入：
3 11 6 7 8
输出：
4
     */

    public static void main(String [] args){
        Scanner scanner  =new Scanner(System.in);
        String strs = scanner.nextLine();
        if(Pattern.matches("[1-9 ]*",strs)){
            String[] str = strs.split(" ");
            int [] peaches =new  int[Integer.parseInt(str[0])];
            for(int i=1;i<=Integer.parseInt(str[0]);i++){
                peaches[i-1] = Integer.parseInt(str[i]);
            }
            Arrays.sort(peaches);
            int k=peaches[peaches.length-1];
            while (k>0) {
                int time=0;
                for (int i = 0; i < peaches.length; i++) {
                    if (peaches[i]%k==0){
                        time+=peaches[i]/k;
                    }else {
                        time+=peaches[i]/k+1;
                    }

                }
                if (time>Integer.parseInt(str[str.length-1])){
                    System.out.println(k+1);
                    break;
                }
                k--;
            }
        }else {
            System.out.println(-1);
        }

    }
}
