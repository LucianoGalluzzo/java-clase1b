package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSortEjerc
{
	public static void radixSort(int[] arr)
	{
		//La variabilidad de los digitos
		int x=10;
		String[] sArr = StringUtil.toStringArray(arr);
		int size = StringUtil.maxLength(sArr);
		StringUtil.lNormalize(sArr, '0');


		Map<Integer,ArrayList<String>> list = new HashMap<>();
		Integer value;
		int cont=0;

		//Genero las 10 listas
		for(int i=0; i<sArr.length; i++){
			value = Character.getNumericValue(sArr[i].charAt(size - 1));
			if(list.get(value) == null)
				list.put(value, new ArrayList<>());
			list.get(value).add(sArr[i]);
		}

		//Recorro el mapa para volver a generar el array
		for(int m=0; m<x; m++){
			if(list.get(m) != null) {
				for (int i = 0; i < list.get(m).size(); i++)
					sArr[cont] = list.get(m).get(i);
			}
		}




		for(int i=0; i<sArr.length;i++)
		{
			System.out.print(sArr[i]+(i<sArr.length-1?",":""));
		}

	}

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);
		
		/*for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}*/
	}
}
