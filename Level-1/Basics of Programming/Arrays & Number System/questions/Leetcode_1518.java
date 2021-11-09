public class Leetcode_1518 {
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int temp = numBottles;
            int temp2 = numBottles;

            while (temp2 / numExchange != 0) {
                int quo = temp2 / numExchange;
                temp += quo;

                int rem = temp2 % numExchange;
                temp2 = quo + rem;
            }
            return temp;
        }
    }
}
