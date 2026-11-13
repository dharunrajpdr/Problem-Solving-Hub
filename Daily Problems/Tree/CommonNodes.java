class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (true) {

            // Push all left nodes of first BST
            while (r1 != null) {
                s1.push(r1);
                r1 = r1.left;
            }

            // Push all left nodes of second BST
            while (r2 != null) {
                s2.push(r2);
                r2 = r2.left;
            }

            // If either stack is empty, traversal is complete
            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node a = s1.peek();
            Node b = s2.peek();

            if (a.data == b.data) {

                ans.add(a.data);

                s1.pop();
                s2.pop();

                r1 = a.right;
                r2 = b.right;
            }
            else if (a.data < b.data) {

                s1.pop();
                r1 = a.right;
            }
            else {

                s2.pop();
                r2 = b.right;
            }
        }

        return ans;
    }
}
