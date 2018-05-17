import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;




public class TestMap {

	public static void main(String[] args) {
		String str = "can you can a can as a canner can can a can";
		String[] arrays = str.split(" ");
		Map<String,Letters> letters= new HashMap<String,Letters>();
		for(String temp:arrays){
			if(!letters.containsKey(temp))
				letters.put(temp, new Letters());
		}
		for(String temp:arrays){
			Letters con = letters.get(temp);
			con.setCount(con.getCount()+1);
		}
		Set<String> keys = letters.keySet();
		for(String key:keys){
			Letters con = letters.get(key);
			System.out.println("单词"+key+"出现了"+con.getCount());
		}
			
	}

}
