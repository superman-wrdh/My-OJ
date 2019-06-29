package cn.array;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeArr = new int[m + n];
        int i = 0; // first array pointer
        int j = 0; // second array pointer
        int index = 0; // merge array pointer
        while (i < m && j < n) {

            // Pay attention to the details which i<m must be put on the first judge
            // condtion. It could occur the arrayOutOfIndex exception if we didn't do that.

            while (i < m && nums1[i] <= nums2[j]) {
                mergeArr[index++] = nums1[i++];
            }
            while (j < n && nums2[j] <= nums1[i]) {
                mergeArr[index++] = nums2[j++];
            }
        }

        // merge unsorted elements into merge array
        while (i < m) {
            mergeArr[index++] = nums1[i++];
        }
        while (j < n) {
            mergeArr[index++] = nums2[j++];
        }
        // This problem needs us to merge the final result into the first given array
        // such as num1 in this case.
        System.arraycopy(mergeArr, 0, nums1, 0, mergeArr.length);
        return mergeArr;
    }
}
