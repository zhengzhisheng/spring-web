package leetCode.sort;

import java.util.PriorityQueue;

public class TopK {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        for(int j=k;j<nums.length;j++){
            if(nums[j]>queue.peek()){
                queue.poll();
                queue.add(nums[j]);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        TopK _this = new TopK();
        System.out.println(_this.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

}
