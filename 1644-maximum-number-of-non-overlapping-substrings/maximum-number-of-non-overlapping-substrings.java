class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

   
        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';


            if (first[c] != i) {
                continue;
            }

            int end = last[c];
            boolean valid = true;

            for (int j = i; j <= end; j++) {

                int curr = s.charAt(j) - 'a';

                if (first[curr] < i) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[curr]);
            }

            if (valid) {
                intervals.add(new int[]{i, end});
            }
        }


        Collections.sort(intervals, (a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {

                ans.add(s.substring(start, end + 1));

                prevEnd = end;
            }
        }

        return ans;
    }
}