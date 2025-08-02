import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }
}


public class Work {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{0,1,2,2,3,0,0,0,0};
        int[] arr2 = new int[]{2,2,3,4};
        solution.merge(arr1,5,arr2,4);
        System.out.println(Arrays.toString(arr1));
    }
}


class Solution88 {
    public int removeDuplicates(int[] nums) {
        int arr = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i -1]){
                nums[arr++] = nums[i];
            }

        }
        return arr;
    }
}

class Solution90 {
    public int removeElement(int[] nums, int val) {
        int arr = 0;
        for(int num:nums){
            if(num != val){
                nums[arr] = num;
                arr++;
            }
        }return arr;
    }
}

class Solution1 {

    public int removeElement(int[] nums, int val) {
        int usedSize = nums.length;
        int k = 0;
        for (int i = 0; i < usedSize; i++) {
            if(nums[i] == val){
                for (int j = i; j < usedSize -1; j++) {
                    nums[j] = nums[j +1];
                    System.out.println(Arrays.toString(nums));

                }
                i = 0;
                k++;
                usedSize--;
            }
        }
        return k;
    }
}
