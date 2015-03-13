import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RomanNumberConverter {
	
	
	
	public static String convertToRoman(int x){
		String result = "";
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(1, "I");
		myMap.put(4, "IV");
		myMap.put(5, "V");
		myMap.put(9, "IX");
		myMap.put(10, "X");
		myMap.put(40, "XL");
		myMap.put(50, "L");
		myMap.put(90, "XC");
		myMap.put(100, "C");
		myMap.put(400, "CD");
		myMap.put(500, "D");
		myMap.put(900, "CM");
		myMap.put(1000, "M");
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1000);
		list.add(900);
		list.add(500);
		list.add(400);
		list.add(100);
		list.add(90);
		list.add(50);
		list.add(40);
		list.add(10);
		list.add(9);
		list.add(5);
		list.add(4);
		list.add(1);
		
		
		while(x > 0){
			for(int i=0; i<list.size(); i++){
				if(x>=list.get(i)){
					result += myMap.get(list.get(i));
					x-=list.get(i);
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(convertToRoman(49));
	}
}
