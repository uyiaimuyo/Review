/**
 * Created by Aysar on 4/7/2014.
 */
public class Sorting {

    public static int[] bubbleSort(int[] a) {
        for (int i=a.length; i>=0; i--) {
            for (int j=0; j<i-1; j++) {
                if (a[j] > a[j+1]) {
                    int swap = a[j];
                    a[j] = a[j+1];
                    a[j+1] = swap;
                }
            }
        }
        return a;
    }

    public static int[] selectionSort(int[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for(int j=i+1; j<a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int swap = a[i];
            a[i] = a[min];
            a[min] = swap;
        }
        return a;
    }

    public static int[] insertionSort(int[] a) {
        for(int i=0; i<a.length; i++) {
            for(int j=i; j>0; j--) {
                if (a[j] < a[j-1]) {
                    int swap = a[j];
                    a[j] = a[j-1];
                    a[j-1] = swap;
                }
            }
        }
        return a;
    }

    public static int[] sort3(int[] a) {
        int i = a[0];
        int swap = 0;
        if (a[1] < i) {
            swap = a[1];
            a[1] = i;
            a[0] = swap;
        }
        if (a[2] < i) {
            swap = a[2];
            a[2] = i;
            a[0] = swap;
        }
        if (a[2] < a[1]) {
            swap = a[2];
            a[2] = a[1];
            a[1] = swap;
        }
        return a;
    }

    public static void mergeSort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (hi-lo)/2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid+1, hi);
        // merge
    }

    public static void qsort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        // get partition
        int p = a[lo];
        int i =lo, j=hi+1;
        while(true) {
            while (a[++i] < p) // ensure all #ers on left are less than p
                if (i == hi) break;
            while (p < a[--j]) // all #ers on right are less than p
                if (j == lo) break;
            if (i>=j) break; // we're done if pointers have crossed

            // swap any elements that don't agree with above while loops
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
        // put our partition inside so it gets sorted next time
        a[lo] = a[j];
        a[j] = p;

        //{8,10,2,6,1,5,3,4,9,7}
        qsort(a,lo,j-1); // sorts stuff on left side
        qsort(a,j+1,hi); // sorts stuff on right side
    }

    public static void main(String[] args) {
        int[] a = {8,10,2,6,1,5,3,4,9,7};
        int[] a2 = {8,10,2,6,1,5,3,4,9,7};
        int[] a3 = {8,10,2,6,1,5,3,4,9,7};
        int[] b = {8,10,2}; //{8,2,10} {2,8,10} {2,10,8} {10,2,8} {10,8,2}
        int[] c = {8,10,2,5};

        bubbleSort(a);
        System.out.println("\nBubble sort (n^2):");
        for (int i: a)
            System.out.print(i+", ");

        selectionSort(a);
        System.out.println("\nSelection sort (n^2/2):");
        for (int i: a)
            System.out.print(i+", ");

        System.out.println("\nInsertion sort (n^2/4):");
        insertionSort(a2);
        for (int i: a2)
            System.out.print(i+", ");

        System.out.println("\nSort 3 #ers with 3 if statements:");
        sort3(b);
        for (int i: b)
            System.out.print(i+", ");

        System.out.println("\nQuick sort (nlogn):");
        qsort(a3,0,a3.length-1);
        for (int i: a3)
            System.out.print(i+", ");
    }

}
