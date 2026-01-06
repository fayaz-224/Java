package DSA.TwoPointers;

//2 pointer approach - used 3 pointers left, right, index as below
public class Sort_012 {  //sort colors problem

    public static void sortArray(int[] nums) {  //Optimal Approach
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

    public void sortZeroOneTwo(int[] nums) {  //Approach - 2
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        //Count the number of 0s, 1s, and 2s
        for (int num : nums) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
            else cnt2++;
        }

        // Fill the first 'cnt0' elements with 0
        for (int i = 0; i < cnt0; i++) {
            nums[i] = 0;
        }

        // Fill the next 'cnt1' elements with 1
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            nums[i] = 1;
        }

        // Fill the remaining elements with 2
        for (int i = cnt0 + cnt1; i < nums.length; i++) {
            nums[i] = 2;
        }
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
