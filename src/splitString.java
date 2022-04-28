import java.util.Scanner;

public class splitString {
    /**
     * 题目描述：连续输入字符串(输出次数为 N,字符串长度小于 100)，请按长度为 8 拆分每个字符串后输出到新的字符串数组，长度不是 8 整数倍的字符串请在后面补数字 0，
     * 空字符串不处理。首先输入一个整数，为要输入的字符串个数。
     * 例如：
     * 输入：2
     * abc
     * 12345789
     * 输出：abc00000
     * 12345678
     * 90000000
     */
    public static void main(String [] args){
        Scanner scanner  =new Scanner(System.in);
        int count = scanner.nextInt();
        String[] stringArray  = new String[count];
        for(int i=0;i<count;i++){
            stringArray[i]=scanner.nextLine();
        }
        for(int i=0;i<count;i++){
            String str = stringArray[i];
            int index=0;
            while (str.length()>=8){
               String txt = str.substring(index,index+8);
               str =str.toString().replace(txt, "");
               index = index+8;
               System.out.println(txt);
           }
           if (str.length()>0){
               int len = str.length();
               for(int j=0;j<8-len;j++){
                   str = str + "0";
               }
           }
           System.out.println(str);


        }

    }
}
