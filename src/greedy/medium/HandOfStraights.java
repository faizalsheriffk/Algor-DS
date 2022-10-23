package greedy.medium;

import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int card : hand) hm.put(card, hm.getOrDefault(card, 0) + 1);

        Arrays.sort(hand);
        for (int card : hand) {
            if (hm.get(card) <= 0) continue;
            for (int i = 1; i < groupSize; i++) {
                int count = hm.getOrDefault(card + i, 0);
                if (count > 0)
                    hm.put(card + i, count - 1);
                else
                    return false;
            }
            hm.put(card, hm.get(card) - 1);
        }

        return true;



    }

    //buggy algo I came up with
//     public boolean isNStraightHand(int[] hand, int groupSize) {

//         if(hand.length%groupSize != 0){
//             return false;
//         }

//         Arrays.sort(hand);

//         int currentSize = 1;
//         int groupSizeCount = 0;
//         int prevNum = hand[0];
//         int index = 1;
//         int startIndex = index;

//         while(index<hand.length){

//             if(hand[index] == -1){
//                 index++;
//                 continue;
//             }
//             //122334678

//             if(hand[index] == prevNum+1){
//                 prevNum = hand[index];
//                 hand[index] = -1;
//                 currentSize += 1;

//                 int size = currentSize/groupSize;
//                 if(size == 1){
//                     currentSize = 1;
//                     groupSizeCount++;

//                     index = startIndex;
//                     startIndex = startIndex+1;
//                 }
//             }

//             index+=1;

//         }

//         return hand.length/groupSize == groupSizeCount?true:false;
//     }
}
