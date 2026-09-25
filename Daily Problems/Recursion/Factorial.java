
//n=4        4*3*2*1=24

class Main {
    public static void main(String[] args) {
        int n=4;
        int ans = fact(n);     
        System.out.println(ans);
    }
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
}
