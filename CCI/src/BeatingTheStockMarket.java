/* 
Say  you  have  an  array  for  which  the  ith  element  is  the  price  of  a  given  stock  on  day  i.   
If  you  were  only  permitted  to  buy  one  share  of  the  stock  and  sell  one  share  of  the
  stock,  design  an  algorithm  to  find  the  best  times  to  buy  and  sell. 
*/


public class BeatingTheStockMarket {
	
	public void getBestTimesAt(int len; int[] a) {

		int lowestPriceIndex = 0;
		int highestPriceIndex = 0;
		int bestGain = 0;
		for(int i=1; i<len, i++) {
			if (a[i] < a[lowestPriceIndex]) {
				lowestPriceIndex = i;
			} else {
				if (a[i]-a[lowestPriceIndex] > bestGain) {
					bestGain = a[i] - a[lowestPriceIndex];
					highestPriceIndex = i;
				}
			}
		}
		System.out.println("The best gain upto day "+len+" is "+bestGain+" by buying on day "+lowestPriceIndex +
			" and selling on day "+highestPriceIndex);
	}

	public static void main(String[] args) {
		int[] tesla = [10,3,4,6,2,8,7,9,15,1,3];
		getBestTimesAt(tesla.length, tesla);
	}

}