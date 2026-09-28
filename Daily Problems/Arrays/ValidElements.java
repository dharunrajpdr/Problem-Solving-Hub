class Solution {
    public List<Integer> findValidElements(int[] nums) {

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        if (nums.length == 1) {
            return list;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (isLeft(nums, 0, i - 1, i) ||isRight(nums, i + 1, nums.length - 1, i))
            {
                list.add(nums[i]);
            }
        }
        list.add(nums[nums.length - 1]);
        return list;
    }
    public static boolean isLeft(int[] arr, int start, int end, int element) {
        for (int i = start; i <= end; i++) {

            if (arr[i] >= arr[element]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isRight(int[] arr, int start, int end, int element) {
        for (int i = start; i <= end; i++) {

            if (arr[i] >= arr[element]) {
                return false;
            }
        }
        return true;
    }
}
