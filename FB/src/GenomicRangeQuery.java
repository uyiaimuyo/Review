// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        
        SegmentTree segTree = new SegmentTree(S.length());
        int [] t = new int[S.length()];
        for (int i=0;i<S.length();i++) {
            if (S.charAt(i) == 'A')
                t[i] = 1;
            else if (S.charAt(i) == 'C')
                t[i] = 2;
            else if (S.charAt(i) == 'G')
                t[i] = 3;
            else if (S.charAt(i) == 'T')
                t[i] = 4;
        }
        
        segTree.constructSegmentTree(t);
        
        int [] r = new int[P.length];
        for (int j=0; j<P.length;j++) {
             r[j] = segTree.getMin(P[j],Q[j]);    
        }
        
        return r;
    }
    public class SegmentTree
    {
    private int[] tree;
    private int maxsize;
    private int height;
 
    private  final int STARTINDEX = 0; 
    private  final int ENDINDEX;
    private  final int ROOT = 0;
 
    public SegmentTree(int size)
    {
        height = (int)(Math.ceil(Math.log(size) /  Math.log(2)));
        maxsize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxsize];
        ENDINDEX = size - 1; 
    }
 
    private int leftchild(int pos)
    {
        return 2 * pos + 1;
    }
 
    private int rightchild(int pos)
    {
        return 2 * pos + 2;
    }
 
    private int mid(int start, int end)
    {
        return (start + (end - start) / 2); 
    }
 
    private int getMinUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int current)
    {
        if (queryStart <= startIndex && queryEnd >= endIndex )
        {
            return tree[current];
        }
        if (endIndex < queryStart || startIndex > queryEnd)
        {
            return 4;
        }
        int mid = mid(startIndex, endIndex);
        return  Math.min(getMinUtil(startIndex, mid, queryStart, queryEnd, leftchild(current)),   getMinUtil( mid + 1, endIndex, queryStart, queryEnd, rightchild(current)));
    }
 
    public int getMin(int queryStart, int queryEnd)
    {
        if(queryStart < 0 || queryEnd > tree.length)
        {
            return -1;
        }
        return getMinUtil(STARTINDEX, ENDINDEX, queryStart, queryEnd, ROOT);
    }
 
    private int constructSegmentTreeUtil(int[] elements, int startIndex, int endIndex, int current)
    {
        if (startIndex == endIndex)
        {
            tree[current] = elements[startIndex];
            return tree[current];	
        }
        int mid = mid(startIndex, endIndex);
        tree[current] = Math.min(constructSegmentTreeUtil(elements, startIndex, mid, leftchild(current)), constructSegmentTreeUtil(elements, mid + 1, endIndex, rightchild(current)));
        System.out.println(tree[current]);
        return tree[current];
    }
 
    public void constructSegmentTree(int[] elements)
    {
        constructSegmentTreeUtil(elements, STARTINDEX, ENDINDEX, ROOT);	
    }
    }
}
