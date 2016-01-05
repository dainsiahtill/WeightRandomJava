package com.titan.arithmetic;

import java.lang.reflect.Field;
import java.util.List;

public class WeightUtil
{
	public static Weight matchWeight(double value, Weight[] list) 
	{
		Weight result = null;
		
		for (int i = 0; i < list.length; i++) 
		{
			Weight weight = list[i];
			if (value >= weight.lower && value < weight.upper)
			{
				result = weight;
			}
		}
		
		return result;
	}
	
	public static Weight[] calculateWeights(List list, String valueRef) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException 
	{
		Weight weight;
		int sum = 0;
		int size = list.size();
		Weight[] resultList = new Weight[size];
		
		for (int i = 0; i < size; i++) 
		{
			Object item = list.get(i);
			Class cls = item.getClass();
			Field field = cls.getDeclaredField(valueRef);
			
			int value = field.getInt(item);
			sum += value;
			
			weight = new Weight();
			weight.data = item;
			weight.value = value;
			resultList[i] = weight;
		}
		
		double inc = 0;
		
		for (int j = 0; j < size; j++) 
		{
			weight = resultList[j];
			weight.proportion = weight.value / sum;
			weight.lower = inc;
			inc += weight.proportion;
			weight.upper = inc;
		}
		
		return resultList;
	}
	
	public static Weight random(Weight[] weightList)
	{
		return WeightUtil.matchWeight(Math.random(), weightList);
	}
}
