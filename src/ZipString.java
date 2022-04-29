import java.util.Scanner;
import java.util.regex.Matcher;

public class ZipString {
    /*
    通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序， 将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。
压缩规则：
1. 仅压缩连续重复出现的字符。比如字符串"abcbc"由于无连续重复字符，压缩后的字符串还是"abcbc".
2. 压缩字段的格式为"字符重复的次数+字符"。例如：字符串"xxxyyyyyyz"压缩后就成为"3x6yz"
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.nextLine().trim().toCharArray();
        StringBuffer stringBuffer  =new StringBuffer();
        int count=1;
        for(int i=0;i<str.length-1;i++){
            if(str[i]==str[i+1]){
                count++;
            }else {
                if(count==1){
                    stringBuffer.append(str[i]);
                }else {
                    stringBuffer.append(count).append(str[i]);
                    count=1;
                }
            }
            if(i==str.length-2){
                if(str[i]==str[i+1]){
                    count++;
                }else {
                    if(count==1){
                        stringBuffer.append(str[i+1]);
                    }else {
                        stringBuffer.append(count).append(str[i+1]);
                    }

                }
            }
        }

        System.out.println(stringBuffer);
    }
}
