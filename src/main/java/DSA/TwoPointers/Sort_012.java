package DSA.TwoPointers;

//2 pointer approach - used 3 pointers left, right, index as below
public class Sort_012 {  //sort colors problem
    public static void sortArray(int[] nums) {
        int left = 0, index = 0, right = nums.length - 1;

        while (index <= right) {
            if (nums[index] == 0) {  //we can use switch()
                swap(nums, left, index);
                left++;
                index++;
            }else if(nums[index] == 1){
                index++;
            } else {
                swap(nums, index, right);
                right--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 1, 2, 1, 0, 1, 2};
        sortArray(arr);
        System.out.println("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
