// Combination Sum II
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result , List<Integer> temp, int[] candidates, 
        int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            } else if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            temp.add(candidates[i]);
            backtrack(result, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
