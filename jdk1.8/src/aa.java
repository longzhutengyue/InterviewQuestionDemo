import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class aa {

	public static void main(String[] args) {
		List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
		List<String> arr=new ArrayList<String>();
		
		arr.add("e");arr.add("e1");arr.add("e2");
		System.out.println(proNames);
		System.out.println(arr);
		System.out.println(proNames.get(0));
		List<String> lowercaseNames1 = proNames.stream().map(name -> {
			return name.toLowerCase();
			}).collect(Collectors.toList());
	}
}
