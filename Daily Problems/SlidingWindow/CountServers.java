//2747 Count Zero Request Servers

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m=logs.length;
        int q=queries.length;
        //Sort logs by time
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        //Store query and its original index
        int[][] sortedQueries = new int[q][2];
        for(int i=0;i<q;i++){
            sortedQueries[i][0]=queries[i];
            sortedQueries[i][1]=i;
        }
        //Sort the query by time
        Arrays.sort(sortedQueries,(a,b)->Integer.compare(a[0],b[0]));

        int[] ans = new int[q];
        //Frequency of requests of each server
        int[] freq = new int[n+1];
        int left=0;
        int right=0;
        int activeServer=0;

        for(int i=0;i<q;i++){
            int time=sortedQueries[i][0];
            int index=sortedQueries[i][1];
            int start=time-x;

            //Include logs within the current window
            while(right<m && logs[right][1]<=time){
                int server = logs[right][0];
                if(freq[server]==0){
                    activeServer++;
                }
                freq[server]++;
                right++;
            }

            //Remove logs outside the current window
            while(left<right && logs[left][1]<start){
                int server = logs[left][0];
                freq[server]--;
                if(freq[server]==0){
                    activeServer--;
                }
                left++;
            }
            //Server with zero requests
            ans[index]=n-activeServer;
        }
        return ans;
    }
}
