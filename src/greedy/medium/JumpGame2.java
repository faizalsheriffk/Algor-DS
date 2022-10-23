package greedy.medium;

public class JumpGame2 {

    public int jump(int[] nums) {
        //Simple BFS on a linear datastructure like array

        int r = 0;
        int l = 0;
        int minimumJumps = 0;

        while(r<nums.length-1){
            var jumpFarthest = 0;
            for(int i = l; i<=r; i++){ // level traversal
                jumpFarthest = Math.max(i+nums[i], jumpFarthest);
            }
            l = r+1;
            r = jumpFarthest;
            minimumJumps++;
        }


        return minimumJumps;
    }
}
