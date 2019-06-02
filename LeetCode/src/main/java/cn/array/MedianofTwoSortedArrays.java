package cn.array;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int left = -2, right = nums1.length + 1;
        int total = nums1.length + nums2.length;
        int pt1, pt2, pt3, pt4;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid + 1 > nums1.length - mid + nums2.length - 1) {
                right = mid;
            } else if (mid + 1 + nums2.length + 1 < nums1.length - mid - 1) {
                left = mid + 1;
            } else {
                int cpt = total / 2 - mid - 2;
                pt1 = (mid == -1) ? Integer.MIN_VALUE : nums1[mid];
                pt2 = (mid + 1 == nums1.length) ? Integer.MAX_VALUE : nums1[mid + 1];
                pt3 = (cpt == -1) ? Integer.MIN_VALUE : nums2[cpt];
                pt4 = (cpt + 1 == nums2.length) ? Integer.MAX_VALUE : nums2[cpt + 1];
                if (pt1 > pt4) {
                    right = mid;
                } else if (pt3 > pt2) {
                    left = mid + 1;
                } else {
                    int ptl = Math.max(pt1, pt3);
                    int ptr = Math.min(pt2, pt4);
                    if (total % 2 == 0) {
                        return ((double) (ptl + ptr) / 2);
                    } else {
                        return (double) (ptr);
                    }
                }
            }
        }
        return (double) (-1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 4, 5, 8};
        // 1, 2,2, 3, 4,4, 5,5,8
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(a, b));
    }
}
