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
