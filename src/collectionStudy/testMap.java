package collectionStudy;

import java.util.HashMap;
import java.util.Map;

public class testMap {

	public static void main(String[] args) {
		String a[] = {"aaa","bbb","ccc","aaa","ccc","ddd","aaa"};
		Map<String,Integer> m1  = new HashMap<String,Integer>();
		for(int i=0;i<a.length;i++) {
			int s = m1.get(a[i])==null?1:m1.get(a[i])+1;
			m1.put(a[i], s);
		}
		System.out.println(m1.size()+"条记录");
		System.out.println(m1);
		System.out.println(m1.get("aaa"));
	}

}
