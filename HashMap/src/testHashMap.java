import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class testHashMap {

	private void testHashMap() throws Exception {
		Map map = new HashMap();
		map.put("userName", "peter");
		map.put("useremail", "aaa@163.com");
		map.put("usersex", "ÄÐ");
 
		Iterator it = map.keySet().iterator();
		Iterator myvalues = map.values().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = myvalues.next();
			System.out.print("key=" + key.toString() + ",");
			System.out.println("next=" + value.toString());
		}
	}

}
