class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cost = 0;

        // Step 1: Pair as much as beneficial
        long pair = Math.min(need1, need2);

        if ((long) costBoth < (long) cost1 + cost2) {
            cost += pair * costBoth;

            need1 -= pair;
            need2 -= pair;
        }

        // Step 2: Remaining type-1
        cost += (long) need1 * Math.min(cost1, costBoth);

        // Step 3: Remaining type-2
        cost += (long) need2 * Math.min(cost2, costBoth);

        return cost;

    }
}
