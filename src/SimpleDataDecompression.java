import java.util.*;

public class SimpleDataDecompression {
    /*
题目描述：将一段压缩后的字符串解压缩，并且排序输出
解压规则：
每个字符串后面跟随一个数字，表示这个字符串的重复次数。例如，“a5”解压缩的结果为“aaaaa”；“abc3”解压缩后的结果为“abcabcabc”。
排序规则：
1、根据每个字符串的重复次数升序排序，然后输出结果。例如，“a3b2”，输出的结果为“bbaaa”。
2、如果字符重复次数一样，则根据 ASCII 编码顺序做升序排序，然后输出结果。例如，“b2a2”，输出的结果为“aabb”
输入描述：
输入的原始字符串仅包含字母和数字
输出描述：
输出的结果字符串仅包含字母
示例 1
输入：a11b2bac3bad3abcd2
输出：bbabcdabcdbacbacbacbadbadbadaaaaaaaaaaa
     */
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        char[] stringArray = scanner.nextLine().toCharArray();
        Set<String> set= new TreeSet<>();
        int slow=0;
        int fast=0;
        while (fast<stringArray.length){
            StringBuffer stringBuffer = new StringBuffer();
            if(Character.isDigit(stringArray[fast])){
                fast++;
            }
        }

        System.out.println(stringArray[1]);
    }
}
