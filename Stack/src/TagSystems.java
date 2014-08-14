/** Tag systems. Write a program that reads in a binary string from the command line
 * and applies the following (00, 1101) tag-system: if the first bit is 0, delete the
 * first three bits and append 00; if the first bit is 1, delete the first three bits
 * and append 1101. Repeat as long as the string has at least 3 bits. Try to determine
 *  whether the following inputs will halt or go into an infinite loop:
 *  10010, 100100100100100100. Use a queue.
 */
public class TagSystems {
    public static void main(String[] args) {
        String bs = "100100100100100100";
        QueueImpl<Character> q = new QueueImpl<Character>();

        for (int i=0; i<bs.length(); i++) {
            q.enqueue(bs.charAt(i));
        }

        for (int i=0; i<bs.length()-2; i++) {
            if (bs.charAt(i) == '0') {
                q.dequeue();
                q.dequeue();
                q.dequeue();
                q.enqueue('0');
                q.enqueue('0');
            }
            if (bs.charAt(i) == '1') {
                q.dequeue();
                q.dequeue();
                q.dequeue();
                q.enqueue('1');
                q.enqueue('1');
                q.enqueue('0');
                q.enqueue('1');
            }
        }
        System.out.println(q);
    }
}
