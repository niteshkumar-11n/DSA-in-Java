import java.util.*;

class Solution {

    class Pair {
        int l;
        int r;
        int weight;
        int index;

        Pair(int l, int r, int weight, int index) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.index = index;
        }
    }

    class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Pair[] arr;
    Result[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by left endpoint
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);

            return Integer.compare(a.index, b.index);
        });

        dp = new Result[n + 1][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    Result solve(int i, int k) {

        if (i == arr.length || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Don't take current interval
        Result skip = solve(i + 1, k);

        // Take current interval
        int next = findNext(i);

        Result nextResult = solve(next, k - 1);

        List<Integer> takeIndices = new ArrayList<>();

        takeIndices.add(arr[i].index);
        takeIndices.addAll(nextResult.indices);

        // IMPORTANT:
        // Answer must be sorted by original indices
        Collections.sort(takeIndices);

        Result take = new Result(
            arr[i].weight + nextResult.score,
            takeIndices
        );

        dp[i][k] = better(skip, take);

        return dp[i][k];
    }

    // Binary search:
    // Find first interval whose left > current right
    int findNext(int i) {

        int low = i + 1;
        int high = arr.length - 1;

        int ans = arr.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].l > arr[i].r) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    Result better(Result a, Result b) {

        // Maximum score
        if (a.score > b.score) {
            return a;
        }

        if (b.score > a.score) {
            return b;
        }

        // Same score
        // Choose lexicographically smaller indices
        if (compare(a.indices, b.indices) <= 0) {
            return a;
        }

        return b;
    }

    int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        // If one is a prefix of the other,
        // shorter one is lexicographically smaller
        return Integer.compare(a.size(), b.size());
    }
}