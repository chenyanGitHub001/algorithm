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
                    int gbpCount = count / rateMap.get("GBP");
                    if (gbpCount > 0) {
                        stringBuffer.append(gbpCount).append(" GBP ");
                    }
                    int gbpRemainder = currencyNum % rateMap.get("GBP");
                    //
                    int usdCount = gbpRemainder / rateMap.get("USD");
                    if (usdCount > 0) {
                        stringBuffer.append(usdCount).append(" USD ");

                    }
                    int usdRemainder = gbpRemainder % rateMap.get("USD");
                    int cnyCount = usdRemainder / rateMap.get("CNY");
                    if (cnyCount > 0) {
                        stringBuffer.append(cnyCount).append(" CNY ");

                    }
                    int cnyRemainder = usdRemainder % rateMap.get("CNY");
                    if (cnyRemainder > 0) {
                        stringBuffer.append(cnyRemainder).append(" HKD ");

                    }
                } else {
                    stringBuffer.append(count).append(" HKD ");
                }
                System.out.println(stringBuffer);
            } else {
                System.out.println("ERROR");
            }
        }
    }
}