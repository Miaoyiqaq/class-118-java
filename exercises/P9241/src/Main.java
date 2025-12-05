import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] Tt, D, L;
    static int[] idxOrder;
    static boolean found;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int TT = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TT; tc++) {
            N = fs.nextInt();
            Tt = new long[N];
            D = new long[N];
            L = new long[N];
            for (int i = 0; i < N; i++) {
                Tt[i] = fs.nextLong();
                D[i] = fs.nextLong();
                L[i] = fs.nextLong();
            }
            // 使用 Integer[] 对索引排序（按最晚开始时间升序）
            Integer[] order = new Integer[N];
            for (int i = 0; i < N; i++) order[i] = i;
            Arrays.sort(order, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    long va = Tt[a] + D[a];
                    long vb = Tt[b] + D[b];
                    return Long.compare(va, vb);
                }
            });
            // 转回 int[]
            idxOrder = new int[N];
            for (int i = 0; i < N; i++) idxOrder[i] = order[i];

            found = false;
            dfs(0, 0L);
            sb.append(found ? "YES" : "NO").append('\n');
        }
        System.out.print(sb.toString());
    }

    // mask: bitmask of scheduled planes, cur: current time
    static void dfs(int mask, long cur) {
        if (found) return; // already found a valid schedule
        if (mask == (1 << N) - 1) {
            found = true;
            return;
        }
        // try remaining planes in heuristic order
        for (int k = 0; k < N; k++) {
            int i = idxOrder[k];
            if ((mask & (1 << i)) != 0) continue;
            long earliestStart = Math.max(Tt[i], cur);
            long latestStart = Tt[i] + D[i];
            if (earliestStart <= latestStart) {
                dfs(mask | (1 << i), earliestStart + L[i]);
                if (found) return;
            }
        }
    }

    // Fast scanner
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
