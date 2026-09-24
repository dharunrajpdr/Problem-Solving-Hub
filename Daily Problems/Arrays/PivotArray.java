import java.util.*;
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> list = new ArrayList<>();
        int count=0;
        for(int num:nums){
            if(num<pivot){
                list.add(num);
            }
            if(num==pivot){
                count++;
            }
        }
        for(int i=0;i<count;i++){
            list.add(pivot);
        }
        for(int num:nums){
            if(num>pivot){
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        int ind=0;
        for(int num:list){
            res[ind++]=num;
        }
        return res;
    }
}
