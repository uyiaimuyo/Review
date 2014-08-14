import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aysar on 4/9/2014.
 */
public class OrderTaskGraph {

    public static void printTaskOrder(int[] dfirst, int[] dsecond, int totalNumTasks) {
        List<Integer> g = new LinkedList<Integer>();
        List<Integer> t = new ArrayList<Integer>();
        for (int i=1;i<=totalNumTasks;i++) t.add(i);

        g.add(dfirst[0]);
        if (t.indexOf(dfirst[0]) > -1) t.remove(t.indexOf(dfirst[0]));
        int j=0;
        for (int i=1; i<dfirst.length; i++) {
            if (dfirst[i] != dfirst[j]) {
                g.add(dfirst[i]);
                if (t.indexOf(dfirst[i]) >-1)
                    t.remove(t.indexOf(dfirst[i]));
            }
        }
        j=0;
        g.add(dsecond[0]);
        if (t.indexOf(dsecond[0]) > -1) t.remove(t.indexOf(dsecond[0]));
        for (int i=1; i<dsecond.length; i++) {
            if (dsecond[i] != dsecond[j]) {
                g.add(dsecond[i]);
                if (t.indexOf(dsecond[i]) >-1)
                    t.remove(t.indexOf(dsecond[i]));
            }
        }

        for (int i=0; i<t.size(); i++) g.add(t.get(i));

        for (int i: g) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        printTaskOrder(new int[]{3,1,2},new int[]{2,2,4},6);
    }
}
