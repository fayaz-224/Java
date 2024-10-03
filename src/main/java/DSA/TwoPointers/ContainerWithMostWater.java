package DSA.TwoPointers;

//2 pointer approach - moving at diff speeds
// given an array of integers where each integer represents the height of a vertical line drawn on a 2D plane. The width between any two lines is the distance between their indices.
// The goal is to find the maximum area of water that can be trapped between two lines.
//So we need to find max water that can bve stored
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        int width = height.length-1; //it means no. of empty slots which could hold water
        while (left < right) {

            if (height[left] <= height[right]) {
                maxWater = Math.max(maxWater, width * height[left]);  //calculate area = width * length
                left++;
            } else {
                maxWater = Math.max(maxWater, width * height[right]);
                right--;
            }
            width--;
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};  //op: 49
        System.out.println("The maximum area of water that can be trapped is: " + maxArea(height));
    }
}

