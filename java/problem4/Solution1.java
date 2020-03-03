public class Solution1{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = new int[nums1.length+nums2.length];
        int i =0;
        int j = 0;
        int index = 0;

        while(i<nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                newArray[index] = nums1[i];
                i++;
            }else{
                newArray[index] = nums2[j];
                j++;
            }
            index++;
        }

        while(i<nums1.length){
            newArray[index]=nums1[i];
            index++;
            i++;
        }

        while(j<nums2.length){
            newArray[index] = nums2[j];
            index++;
            j++;
        }

        if(newArray.length%2==1){
            return (double)newArray[newArray.length/2];
        }else{
            return ((double)(newArray[newArray.length/2-1])+(double)(newArray[newArray.length/2]))/2;
        }
        
    }

    public static void main(String[] args){
        int[] array1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] array2 = new int[]{2,3,4,5,6,7,8,9,10,11};
        
        System.out.println(new Solution1().findMedianSortedArrays(array1, array2));
    }
}