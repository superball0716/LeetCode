package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.

Example 1:
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:
Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation: 
The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.
 * @author superball
 * @time 2018年1月16日下午7:50:44
 */
public class DP_638 {
	public static void main(String[] args) {
		DP_638 main = new DP_638();
		List<Integer> price = new ArrayList<>();
		price.add(2);
		price.add(3);
		price.add(4);
		List<List<Integer>> special = new ArrayList<>();
		List<Integer> specialItem1 = new ArrayList<>();
		specialItem1.add(1);
		specialItem1.add(1);
		specialItem1.add(0);
		specialItem1.add(4);
		special.add(specialItem1);
		List<Integer> specialItem2 = new ArrayList<>();
		specialItem2.add(2);
		specialItem2.add(2);
		specialItem2.add(1);
		specialItem2.add(9);
		special.add(specialItem2);
		List<Integer> needs = new ArrayList<>();
		needs.add(1);
		needs.add(2);
		needs.add(1);
		System.out.println(main.shoppingOffers(price, special, needs));
	}

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		int j = 0, res = dot(needs, price);
		for (List<Integer> s : special) {
			ArrayList<Integer> clone = new ArrayList<>(needs);
			for (j = 0; j < needs.size(); j++) {
				int diff = clone.get(j) - s.get(j);
				if (diff < 0) {
					break;
				}
				clone.set(j, diff);
			}
			if (j == needs.size())
				res = Math.min(res, s.get(j) + shoppingOffers(price, special, clone));
		}
		return res;
	}

	public int dot(List<Integer> a, List<Integer> b) {
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i) * b.get(i);
		}
		return sum;
	}

}
