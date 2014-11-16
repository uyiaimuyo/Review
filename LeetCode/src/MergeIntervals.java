import java.util.*;

/**
 * Created by Aysar on 11/15/2014.
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {

    static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    static class IntervalComparator implements Comparator<Interval>
    {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        System.out.println(mergeIntervals(intervals));
    }

    private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals, new IntervalComparator());
        ArrayList <Interval> newIntervals = new ArrayList<Interval>();
        Interval curr = intervals.get(0);
        for (int i=1; i<intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (curr.end >= next.start) {
                Interval newInt;
                if (curr.end > next.end) {
                    newInt = new Interval(curr.start, curr.end);
                } else {
                    newInt = new Interval(curr.start, next.end);
                }
                curr = newInt;
            }
            else {
                newIntervals.add(curr);
                curr = next;
            }
        }
        newIntervals.add(curr);
        return newIntervals;
    }


}
