package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSortEjerc {
    public static void radixSort(int[] arr) {
        //x es la variabilidad de los digitos
        int x = 10;

        String[] sArr = StringUtil.toStringArray(arr);
        int size = StringUtil.maxLength(sArr);
        StringUtil.lNormalize(sArr, '0');

        Map<Integer, ArrayList<String>> list = new HashMap<>();
        Integer value;
        int cont = 0;

        //Recorro 1 vez por cada caracter posible (0 a 9)
        for(int j=1; j<=size; j++) {

            //Genero las 10 listas
            for (int i = 0; i < sArr.length; i++) {
                value = Character.getNumericValue(sArr[i].charAt(size - j));
                if (list.get(value) == null)
                    list.put(value, new ArrayList<>());
                list.get(value).add(sArr[i]);
            }

            //Recorro el mapa para volver a generar el array
            for (int m = 0; m < x; m++) {
                if (list.get(m) != null) {
                    for (int i = 0; i < list.get(m).size(); i++) {
                        sArr[cont] = list.get(m).get(i);
                        cont++;
                    }

                }
            }

            list.clear();
            cont=0;
        }

        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.valueOf(sArr[i]);
        }


    }

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
    }
}
