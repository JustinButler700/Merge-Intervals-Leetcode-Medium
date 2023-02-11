class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){ return intervals;}
        //Sort the intervals.
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0]-arr2[0]);
        //Because we don't know the size of our result post merge, we use a list.
        List<int[]> res = new ArrayList<>();
        //Store the current interval.
        int[] current = intervals[0];
        res.add(current);
        for(int[] interval : intervals){
            //Keep track of the current & next interval
            int begin = current[0];
            int end = current[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            //If current interval intersects with next interval, merge them.
            if(end >= next_begin){
                //Merge is needed.
                current[1] = Math.max(end, next_end);

            }
            else{
                //Else, no intersect conflict, so we update the new current, and add it to the result.
                current = interval;
                res.add(current);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
