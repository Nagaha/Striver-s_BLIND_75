/*57. Insert Interval

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by start i.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int currIdx=0;
        //This is a simple approach
        List<int[]> list=new ArrayList<>();
        //Adding all the intervals less than newInterval
        while(currIdx<intervals.length && intervals[currIdx][1]<newInterval[0]){
            list.add(intervals[currIdx]);
            currIdx++;
        }

        //we are merging the Intervals
        while(currIdx<intervals.length && intervals[currIdx][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[currIdx][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[currIdx][1],newInterval[1]);
            currIdx++;
        }
        list.add(newInterval);//We add the merged interval

        //Adding the rest intervals
        while(currIdx<intervals.length){
            list.add(intervals[currIdx]);
            currIdx++;
        }

        //return the list as an array
        return list.toArray(new int[list.size()][]);

    }
}
