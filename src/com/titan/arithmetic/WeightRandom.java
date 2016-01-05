package com.titan.arithmetic;

import java.util.List;

public class WeightRandom 
{
	private Weight[] _weights;
	
	public WeightRandom(List list, String valueRef) 
	{
		try
		{
			_weights = WeightUtil.calculateWeights(list, valueRef);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Weight nextWeight()
	{
		if (_weights == null)
		{
			return null;
		}
		return WeightUtil.random(_weights);
	}
}
