public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            ArrayList<List<Integer>> MyAns = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0) {
                return MyAns;
            }
            Arrays.sort(nums);
            for (int outer = 0; outer <= nums.length - 1; outer++) {
                for (int i = outer + 1; i <= nums.length - 1; i++) {

                    int remaining = target - nums[i] - nums[outer];
                    int front = i + 1;
                    int back = nums.length - 1;

                    while (front < back) {
                        int twoSum = nums[front] + nums[back];
                        if (twoSum < remaining)
                            front++;
                        else if (twoSum > remaining)
                            back--;
                        else {
                            List<Integer> Quad = new ArrayList<>();
                            Quad.add(nums[outer]);
                            Quad.add(nums[i]);
                            Quad.add(nums[front]);
                            Quad.add(nums[back]);
                            MyAns.add(Quad);

                            while (front < back && nums[front] == Quad.get(2))
                                front++;
                            while (front < back && nums[back] == Quad.get(3))
                                back--;
                        }
                    }
                    while (i + 1 <= nums.length - 1 && nums[i] == nums[i + 1])
                        i++;
                }
                while (outer + 1 <= nums.length - 1 && nums[outer] == nums[outer + 1])
                    outer++;
            }

            return MyAns;
        }
    }
}
