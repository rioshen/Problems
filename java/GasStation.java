/**
 * Created by Robbert on 1/26/15.
 * Gas Station
 * https://oj.leetcode.com/problems/gas-station/
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int position = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                position = i + 1;
                sum = 0;
            }
            total += gas[i] - cost[i];
        }

        return total >= 0 ? position : -1;
    }
}
