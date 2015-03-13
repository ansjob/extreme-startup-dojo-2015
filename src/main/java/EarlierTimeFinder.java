
public class EarlierTimeFinder {
	public static String findEarliest(String input){
		String[] times = input.split(",");
		int earliest = 1000;
		String answer = "";
		
		for(int i=0; i<times.length; i++){
			times[i] = times[i].trim();
			int t = 0;
			
			if(times[i].charAt(times[i].length()-1) == 'm'){
				for(int j=0; j<times[i].length(); j++){
					if(times[i].charAt(j)>='0' && times[i].charAt(j)<='9'){
						t = 10*t+(times[i].charAt(j)-'0');
					}
					else break;
				}
				if(times[i].charAt(times[i].length()-2) == 'p') t+=12;
			}
			else{
				for(int j=0; j<times[i].length(); j++){
					if(times[i].charAt(j)>='0' && times[i].charAt(j)<='9'){
						if(j<2) t = 10*t+(times[i].charAt(j)-'0');
					}
					else if(times[i].charAt(j)=='.'){
						break;
					}
				}
			}
			
			if(t<earliest){
				answer = times[i];
				earliest = t;
			}
		}
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(findEarliest("0500, 8am, 10.00, 13.00, 6pm, 10am"));
	}
}
