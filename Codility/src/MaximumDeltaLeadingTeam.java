/**
 * Created by Aysar on 8/25/2014.
 *
 * Given an array of positive integers that represents possible points a team
 * could score in an individual play. Now there are two teams play against each other.
 * Their final scores are S and S'. How would you compute the maximum number of times
 * the team that leads could have changed?
 For example, if S=10 and S'=6. The lead could have changed 4 times:
 Team 1 scores 2, then Team 2 scores 3 (lead change);
 Team 1 scores 2 (lead change), Team 2 score 0 (no lead change);
 Team 1 scores 0, Team 2 scores 3 (lead change);
 Team 1 scores 3, Team 2 scores 0 (lead change);
 Team 1 scores 3, Team 2 scores 0 (no lead change).
 */
public class MaximumDeltaLeadingTeam {

    public static void main(String args[]) {
        int [] p = {0,2,3};
        System.out.println(getMax(10,6,p,0));
    }

    public static int getMax(int s1, int s2, int[] plays, int c) {
        if (s1 == 0 && s2 == 0) return c;

        int max = -1;
        for (int i=0; i<plays.length; i++) {
            for (int j=0; j<plays.length; j++) {
                int s1_play = s1 - plays[i];
                int s2_play = s2 - plays[j];

                if ((s1_play < 0 || s2_play < 0) || (plays[i] == 0 && plays[j] == 0)) continue;
                if ((s1 > s2) && (s2_play >= s1_play)) {
                    c++;
                    System.out.println(s1+":"+s2+"->"+s1_play+":"+s2_play+"  "+c);
                } else if ((s2 > s1) && (s1_play >= s2_play)) {
                    c++;
                    System.out.println(s1+":"+s2+"->"+s1_play+":"+s2_play+"  "+c);
                }
                int x = getMax(s1_play, s2_play, plays, c);
                if (x > max) {
                    max = x;
                }
            }
        }
        return max;
    }
}
