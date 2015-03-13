
public class EarlierTimeFinder {
	public static String findEarliest(String input){
		String[] times = input.split(",");
		int earliest = 1000;
		String answer = "";
		
		for(int i=0; i<times.length; i++){
			times[i] = times[i].trim();
			int t = 0;
			for(int j=0; j<times[i].length(); j++){
				if(times[i].charAt(j)>='0' && times[i].charAt(j)<='9'){
					t = 10*t+(times[i].charAt(j)-'0');
				}
				else break;
			}
			if(times[i].charAt(times[i].length()-2) == 'p') t+=12;
			
			if(t<earliest){
				answer = times[i];
				earliest = t;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(findEarliest("9am, 10pm, 10am, 6am, 7am, 5am, 7pm, 2pm, 9pm"));
	}
}