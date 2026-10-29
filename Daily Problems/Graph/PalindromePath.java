
import java.util.*;

class Solution {
    private int[] head, to, next;
    private int[] first, last, depth;
    private int[][] up;
    private int timer, log;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        head = new int[n];
        Arrays.fill(head, -1);

        int m = edges.length;
        to = new int[2 * m];
        next = new int[2 * m];

        int idx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];

            to[idx] = v;
            next[idx] = head[u];
            head[u] = idx++;

            to[idx] = u;
            next[idx] = head[v];
            head[v] = idx++;
        }

        log = 32 - Integer.numberOfLeadingZeros(n);
        first = new int[n];
        last = new int[n];
        depth = new int[n];
        up = new int[log][n];

        timer = 0;
        dfs(0, 0);

        BIT bit = new BIT(n + 1);
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mask = 1 << (arr[i] - 'a');
            bit.update(first[i], mask);
            bit.update(last[i] + 1, mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            String[] p = query.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                if (arr[u] == c) continue;

                int mask = (1 << (arr[u] - 'a'))
                         ^ (1 << (c - 'a'));

                bit.update(first[u], mask);
                bit.update(last[u] + 1, mask);
                arr[u] = c;

            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int w = lca(u, v);

                int mask = bit.query(first[u])
                         ^ bit.query(first[v])
                         ^ (1 << (arr[w] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private void dfs(int u, int parent) {
        first[u] = timer++;
        up[0][u] = parent;

        for (int j = 1; j < log; j++) {
            up[j][u] = up[j - 1][up[j - 1][u]];
        }

        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];

            if (v == parent) continue;

            depth[v] = depth[u] + 1;
            dfs(v, u);
        }

        last[u] = timer - 1;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < log; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) return u;

        for (int j = log - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    static class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index + 1; i <= n; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int query(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}
