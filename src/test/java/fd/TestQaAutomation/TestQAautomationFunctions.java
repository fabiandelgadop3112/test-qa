package fd.TestQaAutomation;

import java.util.Arrays;
import java.util.Collections;

public class TestQAautomationFunctions {
		

	public static  void printArray(String[][] arrayToPrint) {
		
		
		for(int i=0; i<=arrayToPrint.length-1; i++)
		{
			for(int j=0; j<=1; j++)
			{
				if(j==0) {System.out.print(arrayToPrint[i][j]);}
				else {System.out.print("|	"+arrayToPrint[i][j]);}
			}
			System.out.println();
		}
	}
	
	public static  String[][] Array(String[][] arrayToOrder, Integer row, Boolean order)
	{
		/*Esta funcion se encarga de ordenar un arreglo de columnas, teniendo como parametro
		 * el arreglo a ordenar arrayToOrder
		 * la columna a ordenar 0 o 1,
		 * El tipo de ordenamiento True Ascendente / False Descendente
		 * */
		
		
		
		String[] temporalArray 	= new String[arrayToOrder.length];
		String[][] finalArray	= new String[arrayToOrder.length][2];
		
		/*En este ciclo se asigna la columna a ordenar en un arreglo temporal*/
		for(int i=0; i<=arrayToOrder.length-1; i++)
		{temporalArray[i] = arrayToOrder[i][row];}
		
		/*Se valida si el ordenamiento es Ascendente o Descendente*/
		if(order) {	Arrays.sort(temporalArray); }
		else{Arrays.sort(temporalArray,Collections.reverseOrder());}
		
		
		/*Se pobla la informacion ordenada en el final Array*/
	    for(int i=0; i<= temporalArray.length-1; i++ ) {
	    	
	    	finalArray[i][row] = temporalArray[i];
	    	for(int j=0; j<=arrayToOrder.length-1;j++)
	    	{
	    		if(temporalArray[i] == arrayToOrder[j][row])
	    		{
	    			if(row==0) {finalArray[i][1] = arrayToOrder[j][1];}
	    			if(row==1) {finalArray[i][0] = arrayToOrder[j][0];}
	    			
	    		}
	    	}
	    	
	    }
			   
		return finalArray;
	}

}
