// Example 1:
// Input: nums = [37,100]
// Output: 1
// Explanation:
// Compute the digit sum for each integer: [3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
// Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to obtain the sorted order.
// Thus, the minimum number of swaps required to rearrange nums is 1.
  
// Example 2:
// Input: nums = [22,14,33,7]
// Output: 0
// Explanation:
// Compute the digit sum for each integer: [2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] → [4, 5, 6, 7]
// Sort the integers based on digit sum: [22, 14, 33, 7]. The array is already sorted.
// Thus, the minimum number of swaps required to rearrange nums is 0.

class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        //store (digitsum,value,original index)
        List<int[]> sortedList = new ArrayList<>();
        for(int i=0;i<n;i++){
            sortedList.add(new int[]{digitSum(nums[i]),nums[i],i});
        }
        //sort by digitsum,then by value
        sortedList.sort((a,b)->{
             if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
             return Integer.compare(a[1],b[1]);
        });
        //Map original index to sorted position
        int[] indexMap = new int[n];
        for(int i=0;i<n;i++){
            indexMap[sortedList.get(i)[2]]=i;
        }
        //find cycles
        boolean[] visited = new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++){
            if(visited[i] || indexMap[i]==i) continue;
            int cycleSize=0;
            int j=i;
            while(!visited[j]){
                visited[j]=true;
                j=indexMap[j];
                cycleSize++;
            }
            if(cycleSize>0){
                swaps+=(cycleSize-1);
            }
        }
        return swaps;

    }
    private int digitSum(int n){
        int sum=0;
        while(n!=0){
            int mod=n%10;
            sum+=mod;
            n/=10;
        }
        return sum;
    }
}
