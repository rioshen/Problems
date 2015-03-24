import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            if (!table.containsKey(value)) {
                table.put(target - value, i);
            } else {
                result[0] = Math.min(i + 1, table.get(value) + 1);
                result[1] = Math.max(i + 1, table.get(value) + 1);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = new TwoSum().twoSum(array, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
