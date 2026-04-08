class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length -2;
        while (left < right) {
            int mid = left + (right - left +1)/2;
            if(arr[mid] <= arr[mid +1]) {
                left = mid;
            }else right = mid -1;
        }
        return left;
    }
}