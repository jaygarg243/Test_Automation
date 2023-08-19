import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.testng.Assert;

public class Test1 {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
				names.add("Abhijeet");
				names.add("Don");
				names.add("Alekhya");
				names.add("Adam");
				names.add("Ram");
		
		int count = 0;
		for(int i=0;i<names.size();i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		
	}*/
	//TestFilter
	public static void main(String[] args) {
		//CREATING A STREAM
		ArrayList<String> names = new ArrayList<String>();
				names.add("Abhijeet");
				names.add("Don");
				names.add("Alekhya");
				names.add("Azam");
				names.add("Rama");
				names.add("Adam");
				
				List<String> names1 = Arrays.asList("Jayash","Megha","Namita");
				
				//INTERMEDIATE OPERATION, terminal--->count()
				long c = names.stream().filter(s->s.startsWith("A")).count();
				//TERmiNAl OPERATION ON THE FINAL STREAM TO GET THE RESULT(only if intermediate is true/valid), life exists only if we have ternal operation
				System.out.println(c);
				long C = Stream.of("Abhijeet","Ram","Don").filter(s->s.startsWith("A")).count();
				System.out.println(C);
				//foreach
				names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
				//limit
				names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
				//map
				names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
				//sorted
				names.stream().filter(s->s.startsWith("A")).sorted().forEach(s->System.out.println(s));
				//concat
				System.out.println();
				Stream<String> newStream =  Stream.concat(names1.stream(),names.stream());
				newStream.sorted().forEach(s->System.out.println(s));
				//anymatch
				//boolean Flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
				//Assert.assertTrue(Flag);
				
				//collect
				List<String> ls = Stream.of("Abhijeet","Ram","Don").filter(s->s.endsWith("t")).collect(Collectors.toList());
				System.out.println(ls.get(0));
				
				List<Integer> value = Arrays.asList(3,2,2,7,5,1,9,7);
				//getting unique values
				value.stream().distinct().forEach(s->System.out.println(s));
				//sorting
				value.stream().sorted().forEach(s->System.out.println(s));
				//printing a particular index
				List<Integer> sorted = value.stream().sorted().collect(Collectors.toList());
				System.out.println(sorted.get(2));
				
	}

}
