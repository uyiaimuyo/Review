/**
 * Created by Aysar on 2/11/2015.
 * Write a method to replace all spaces in a string with ‘%20’
 */
public class ReplaceAllSpacesInString {

    public static String replaceSpace(String str) {
        int len = str.length();
        if(str.isEmpty())
            return str;

        StringBuilder sb = new StringBuilder();

        boolean space = false;
        for(int i=0; i<len; i++) {
            if (str.charAt(i) != ' ') {
                if (space) {
                    space = false;
                    sb.append("%20");
                }
                sb.append(str.charAt(i));
            } else {
                if (!space) {
                    space = true;
                }
            }
        }
        if (space)
            sb.append("%20");
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(replaceSpace("  "));
        System.out.println(replaceSpace("  a  bbc   "));
        System.out.println(replaceSpace(""));
    }
}
