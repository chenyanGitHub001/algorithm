import java.util.Scanner;

public class excelNumChage {
    /*
题目描述：完成从一个正整数到 Excel 编号之间的转换。用过 excel 的都知道 excel 的列编号是这样的：
abc....z aaabac....az babbbc....yzzazbzc....zz aaa aab aac....
分别代表以下编号：
123....26272829....52535455....676677678679....702703704705....请写个函数，完成从一个正整数到这种字符串之间的转换。
原型：intTranslate(intN,string&ans)
功能:正整数到 Excel 编号字符串转换
输入:N
输出:ans
     */

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        StringBuilder str = new StringBuilder();
        StringBuilder stars= new StringBuilder();
        while (number>0){
            str.append(String.valueOf((char) (number % 26 + 'a' - 1)));
            number /=26;
        }
        for(int i=str.length()-1;i>=0;i--){
             stars.append(str.charAt(i));

        }
        System.out.println(stars);
    }
}
