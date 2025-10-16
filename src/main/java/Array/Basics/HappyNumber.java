package Array.Basics;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/description/
//A happy number is a number defined by the following process:
// - Starting with any positive integer, replace the number by the sum of the squares of its digits.
// - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// - Those numbers for which this process ends in 1 are happy.
class HappyNumber {
    public  static boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while (!visit.contains(n)) {  //if n contains in set means we are going to see loop of same iterations. so return false
            visit.add(n);
            n = getNextNumber(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    static int getNextNumber(int n){
        int sum = 0;
        while(n != 0) {
            int k = n%10;
            sum = sum + (k*k);  //or use Math.power()
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 19;  //true
        int n1 = 2; //false
        System.out.println("is Happy Number: " + isHappy(n));
    }
}

/*
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */


/*

class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7) return true;
        else if(n<10) return false;
        else{
            int sum=0;
            while(n>0){
                int temp=n%10;
                sum+= temp*temp;
                n=n/10;
            }
            return isHappy(sum);
        }
    }
}
 */