// Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stationIndex = 0;
        int totalGas = 0;
        int currentGas = 0;

        for (int i = 0; i < gas.length; i++) {
            int difference = gas[i] - cost[i];
            currentGas += difference;
            totalGas += difference;

            if (currentGas < 0) {
                currentGas = 0;
                stationIndex = i + 1;
            }
        }

        return totalGas >= 0 ? stationIndex : -1;
    }
}
