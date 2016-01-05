package com.titan.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args)
	{
		ArrayList list = new ArrayList();
		list.add(new OpenItem("�Ա�", 48));
		list.add(new OpenItem("�ٶ������", 33));
		list.add(new OpenItem("�ṷ����", 12));
		list.add(new OpenItem("�Ѻ���Ƶ", 5));
		
		WeightRandom weightRandom = new WeightRandom(list, "hot");
		
		//����ͳ��
		HashMap hashmap = new HashMap();
		for (int j = 0; j < 1000000; j++) 
		{
			Weight matchWeight = weightRandom.nextWeight();
			OpenItem item = (OpenItem) matchWeight.data;
			Integer count = (Integer) hashmap.get(item.name);
			if (count == null)
			{
				hashmap.put(item.name, new Integer(0));
			}
			else
			{
				hashmap.put(item.name, new Integer(count.intValue() + 1));
			}
		}
		
		Object[] keys = hashmap.keySet().toArray();
		for (int i = 0; i < keys.length; i++) 
		{
			String key = (String) keys[i];
			System.out.println(key);
			System.out.println(hashmap.get(key));
		}
	}

}
