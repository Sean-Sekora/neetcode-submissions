class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int median1 = 0;
        int median2 = 0;

        for (int i = 0; i <= (length1 + length2) / 2; i++) {
            median2 = median1;
            if (p1 < length1 && p2 < length2) {
                if (nums1[p1] < nums2[p2]) {
                    median1 = nums1[p1];
                    p1++;
                } else {
                    median1 = nums2[p2];
                    p2++;
                }
            } else if (p1 < length1) {
                median1 = nums1[p1];
                p1++;
            } else {
                median1 = nums2[p2];
                p2++;
            }
        }

        return (length1 + length2) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
