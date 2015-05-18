package com.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

	public static void main(String[] args) {
		String origin = "ab";
		String target = "aa";
		System.out.println(isomorphicStrings(origin, target));
	}
	
	public static boolean isomorphicStrings(String origin, String target){
		if(origin==null || target==null || origin.length() != target.length()) return false;
		int length = origin.length();
		Map<Character,Character> map = new HashMap<Character, Character>();
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<length;i++){
			char c1 = origin.charAt(i);
			char c2 = target.charAt(i);
			if(map.get(c1)==null){
				if(set.contains(c2)) return false;
				map.put(c1, c2);
				set.add(c2);
			}else{
				if(!map.get(c1).equals(c2)){
					return false;
				}
			}
		}
		return true;
	}
}
