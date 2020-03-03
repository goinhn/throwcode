public class Solution1 {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1){
            return 0;
        }

        if(height.length == 2){
            return height[0] < height[1] ? height[0] : height[1];
        }

        int begin = 0;
        int end = height.length-1;
        int length = end;
        int maxSize = height[begin] < height[end] ? height[begin]*length : height[end]*length;

        while(length>0){
            if(height[begin] > height[end]){
                end--;
                length--;
                int nowSize = height[begin] < height[end] ? height[begin]*length : height[end]*length;
                if(maxSize < nowSize){
                    maxSize = nowSize;
                }
            }else{
                begin++;
                length--;
                int nowSize = height[begin] < height[end] ? height[begin]*length : height[end]*length;
                if(maxSize < nowSize){
                    maxSize = nowSize;
                }
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] pool = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(new Solution1().maxArea(pool));
    }
}