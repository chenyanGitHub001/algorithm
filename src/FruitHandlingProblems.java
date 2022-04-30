import java.net.PortUnreachableException;
import java.util.*;

public class FruitHandlingProblems {
    /**
     * 一组工人搬运一批水果，用一维数组存储工人编号和水果名称以及搬运重量，要求先按水果分组，然后按搬运重量排序输出。
     * 输入描述：
     * 第一行包括一个整数 N(1≤N≤100),代表工人的个数。接下来的 N 行每行包括两个整数 p 和 q,分别代表每个工人的编号和搬运重量，以及一个字符串 m,代表水果的名称。
     * 输出描述：
     * 先按水果分组，然后按工人的搬运重量从小到大进行排序，并将排序后的信息打印出来。如果工人搬运的重量相同，则按照编号的大小从小到大排序，并且要求水果的输
     * 出次序同输入次序。
     * 示例 1
     * 输入
     * 5
     * Apple 1 80
     * Apple 2 62
     * Apple 4 73
     * Orange 4 65
     * Orange 1 90
     * Apple 3 91
     * Orange 3 88
     * Orange 5 90
     * 输出
     * Apple 2 62
     * Apple 4 73
     * Apple 1 80
     * Apple 3 91
     * Orange 4 65
     * Orange 3 88
     * Orange 1 90
     * Orange 5 90
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[][] array = new String[num][3];
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < num; i++) {
            String[] value = scanner.nextLine().split(" ");
            for (int j = 0; j < value.length; j++) {
                array[i][j] = value[j];
                set.add(value[0]);

            }

        }
        for (String name : set) {
            Map<String, String> map = new TreeMap<>();
            for (int j = 0; j < array.length; j++) {
                if (array[j][0].equals(name)) {
                    map.put(array[j][1], array[j][2]);
                }
            }
            List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet()) {
            };
            Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.println(name + " " + list.get(i).getKey() + " " + list.get(i).getValue());
            }

        }

    }
}
