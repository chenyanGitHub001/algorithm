import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class promotionActivity {
    public static boolean regexNum(String[] stringArray) {
        for (int i = 0; i < 4; i++) {
            if (!Pattern.matches("[0-9]*", stringArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean regexChar(String[] stringArray) {
        for (int i = 4; i < 6; i++) {
            if (!Pattern.matches("[A-Z]*", stringArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            String[] stringArray = string.split(" ");
            StringBuffer stringBuffer = new StringBuffer();
            if (regexNum(stringArray) && regexChar(stringArray)) {
                Map<String, Integer> rateMap = new LinkedHashMap<>();
                rateMap.put("GBP", Integer.parseInt(stringArray[2]) * Integer.parseInt(stringArray[1]) * Integer.parseInt(stringArray[0]));
                rateMap.put("USD", Integer.parseInt(stringArray[1]) * Integer.parseInt(stringArray[0]));
                rateMap.put("CNY", Integer.parseInt(stringArray[0]));
                rateMap.put("HKD", 1);
                int currencyNum = Integer.parseInt(stringArray[3]);
                String currencyType = stringArray[4];
                String ExchangeType = stringArray[5];
                int count = currencyNum * rateMap.get(currencyType);
                if (ExchangeType.equals("MAX")) {
                    int index=0;
                    int remainder=0;
                    for(String key:rateMap.keySet()){
                        index = count/rateMap.get(key);
                        if(index>0) {
                            stringBuffer.append(index).append(" ").append(key).append(" ");
                        }
                        remainder = count%rateMap.get(key);
                        count=remainder;
                    }
                    System.out.println(stringBuffer);
                } else if(ExchangeType.equals("MIN")){
                    stringBuffer.append(count).append(" HKD ");
                    System.out.println(stringBuffer);
                }else {
                    System.out.println("ERROR");
                }

            } else {
                System.out.println("ERROR");
            }
        }
    }
}