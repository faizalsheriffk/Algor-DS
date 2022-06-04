package binarySearch.medium;

public class KokoEatingBananas {


        public static int minEatingSpeed(int[] piles, int h) {

            int start = 0;
            int end = 0;

            /**
             * This logic would totally work unless there is a max integer given otherwise it would work
             *
             *             [312884470]
             *             312884469
             *
             *              for (int i = 0; i < piles.length - 1; i ++) {
             *                  if (piles[i] > max) {
             *                      max = piles[i];
             *                  }
             *              }
             *
             */




            for(int pile:piles){
                end = Math.max(pile, end);
            }

            /**
             * use start < end when you are not searching for a target but rather a minimum or the maximum in the input
             */
            while (start < end) {
                int mid = (start + end) / 2;
                int hours = count(piles, mid);

                if (hours > h) {
                    start = mid+1;


                }
                else {
                    end = mid;
                }
            }
            return end;
        }

        private static int count(int[] piles, int middle) {
            int hoursSpent = 0;
            for (int pile:piles) {
                /**
                 * (double) pile is important or else you will get result in integer
                 */
                hoursSpent += Math.ceil((double) pile / middle);
            }
            return hoursSpent;
        }

    }
