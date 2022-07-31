/**
 * 
 * Refer GFG self-paced DSA course.
 * 
 * Logic is find profit/wt ratio for all given quantities.
 * 
 * check the comparision fn it is little different
 * 
 */

package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class ItemValue 
{ 
	Double cost; 
	double wt, val, ind; 
	public ItemValue(int wt, int val, int ind) 
	{ 
		this.wt = wt; 
		this.val = val; 
		this.ind = ind; 
		cost = this.val/this.wt;    // profit/wt ratio is stored in cost.
	} 
}

public class FractionalKnapsack {

    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        ItemValue iVa[] = new ItemValue[n];
        double totalValue = 0d; 
        for(int i=0;i<n;i++)
            iVa[i] = new ItemValue(arr[i].weight,arr[i].value,i) ;
        Arrays.sort(iVa, new Comparator<ItemValue>() 
		{ 
			@Override
			public int compare(ItemValue o1, ItemValue o2) 
			{ 
				return o2.cost.compareTo(o1.cost) ;		// comparision
			} 
		}); 
		for(ItemValue i: iVa) 
		{ 
			if (W - (int)i.wt >= 0) 
			{ 
				W = W - (int)i.wt; 
				totalValue += i.val; 
			} 
			else
			{
				totalValue += (W*i.cost); 
				break; 
			} 
		} 
		return totalValue; 
    }
    
}
