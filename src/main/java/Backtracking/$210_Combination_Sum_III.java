package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*@author superball
*@time 2018年11月10日下午4:33:14
*/
public class $210_Combination_Sum_III {
	public static void main(String [] args){
		$210_Combination_Sum_III main = new $210_Combination_Sum_III();
		List<List<Integer>> res = main.combinationSum3(3, 7);
		for(List<Integer> list: res){
			for(int i: list){
				System.out.print(i+" ");
			}
		}
	}
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res,new ArrayList<Integer>(),k,n,0,1);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer>list,int k,int n,int currentSum,int i){
        if(currentSum==n&&k==list.size()){
            res.add(new ArrayList<Integer>(list));
        }
        if(currentSum>=n||list.size()>=k){
            return;
        }
        for(int j=i;j<10;j++){
            list.add(j);
            currentSum+=j;
            helper(res,list,k,n,currentSum,j+1);
            list.remove(list.size()-1);
            currentSum-=j;
        }
    }
}
