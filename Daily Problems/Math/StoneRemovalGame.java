class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean alice_turn = true;
        while(n>=remove && remove>0){
            n-=remove;
            remove--;
            alice_turn = !alice_turn;
        }
        return !alice_turn;
    }
}
