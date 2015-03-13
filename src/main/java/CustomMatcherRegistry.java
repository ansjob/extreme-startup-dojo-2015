import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;


public class CustomMatcherRegistry {
	
	public List<CustomMatcher> matchers;
	
	public CustomMatcherRegistry() {
		matchers = Lists.newArrayList();
		register(".*what is the sum of (\\d+) and (\\d+)", new CustomMatcherHandler() {
			@Override
			public String getResponse(List<String> groups) {
	            return String.valueOf(Integer.parseInt(groups.get(1))
	                    + Integer.parseInt(groups.get(2)));				
			}
		});
		
		register(".*what is (\\d+) plus (\\d+)", new CustomMatcherHandler() {
			@Override
			public String getResponse(List<String> groups) {
	            return String.valueOf(Integer.parseInt(groups.get(1))
	                    + Integer.parseInt(groups.get(2)));
			}
		
		});
		
		register(".*Convert (\\d+) into Roman Numerals", new CustomMatcherHandler() {

			@Override
			public String getResponse(List<String> groups) {
	        	return RomanNumberConverter.convertToRoman(Integer.parseInt(groups.get(1)));
			}
			
		});
		
		register(".*which of the following is earliest: (.*)", new CustomMatcherHandler() {
			
			@Override
			public String getResponse(List<String> groups) {
				return EarlierTimeFinder.findEarliest(groups.get(1));
			}
		});
		
		register(".*What is ([A-Z]+) in decimal", new CustomMatcherHandler() {

			@Override
			public String getResponse(List<String> groups) {
	        	return RomanNumberConverter.convertToNumber(groups.get(1)).toString();
			}
			
		});
		
		register(".*what is (\\d+) multiplied by (\\d+)", new CustomMatcherHandler() {
			
			@Override
			public String getResponse(List<String> groups) {
				return String.valueOf(Integer.parseInt(groups.get(1))
	                    * Integer.parseInt(groups.get(2)));
			}
		});

		register("which of the following numbers is the largest:(.*)$", new CustomMatcherHandler() {

			@Override
			public String getResponse(List<String> groups) {
				String allthem = groups.get(1);
				String[] splitted = allthem.split(",| ");
				int max = Integer.MIN_VALUE;
				for (String next : splitted) {
					try {
						int nextNum = Integer.parseInt(next);
						max = Math.max(max, nextNum);
					} catch (NumberFormatException e) {
						// ignore junk
					}
				}
				return String.valueOf(max);
			}
			
		});

		register("which of the following numbers is the largest: ((\\d+),[^0-9]*)+$", new CustomMatcherHandler() {

			@Override
			public String getResponse(List<String> groups) {
				return String.valueOf(groups.get(1));
			}
			
		});

		
	}
	
	public void register(String regex, CustomMatcherHandler handler) {
		Pattern pattern = Pattern.compile(regex);
		matchers.add(new CustomMatcher(pattern, handler));
	}
	
	public String getMatch(String request) {
		for (CustomMatcher matcher : matchers) {
	        Matcher additionMatcher = matcher.pattern.matcher(request);
	        if (additionMatcher.matches()) {
	        	return matcher.handle(request);
	        }	
		}
		return "The FooBars";
	}
	
	public class CustomMatcher {
		public Pattern pattern;
		public CustomMatcherHandler handler;
		
		public CustomMatcher(Pattern pattern, CustomMatcherHandler handler) {
			this.pattern = pattern;
			this.handler = handler;
		}
		
		public String handle(String request) {
			Matcher m = pattern.matcher(request);
			List<String> groups = Lists.newArrayList();
			m.matches();
			for (int i = 0; i < m.groupCount()+1; i++) {
				groups.add(m.group(i));
			}
			return handler.getResponse(groups); 
		}
	}
	
	public interface CustomMatcherHandler {
		String getResponse(List<String> groups);
	}
	
}
