package ch16;
import java.util.*;
import java.util.stream.Collectors;

public class MyStreamEx {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Alice","Bob","Charlie","David");
		
		List<String> filteredNames = names.stream()
									.map(String::toUpperCase)
									.filter(name -> name.startsWith("A"))
									.collect(Collectors.toList());
		
		System.out.println(filteredNames);
		String name = "";
	}

}
