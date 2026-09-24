//Brute force 
class Main {
    public static void main(String[] args) {
        int[] arr ={1,2,3};
        int k=3;
        System.out.println(subarraySum(arr,k));
    }
    public static int subarraySum(int[] arr,int x){
        int count=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==x){
                    count++;
                }
            }
        }
        return count;
    }
}

//optimal (using prefixsum)                                                  T.C: O(n*log n) S.C: O(n)

import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] arr ={1,2,3};
        int k=3;
        System.out.println(subarraySum(arr,k));
    }
    public static int subarraySum(int[] arr,int k){
        int n=arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);                               //key:prefixSum,value:count
        int presum=0;
        int count=0;
        for(int num:arr){
            presum+=num;
            if(map.containsKey(presum-k)){
                count+=map.get(presum-k);
            }
            map.put(presum,map.getOrDefault(presum,0)+1);
        }
        return count;
    }
}
