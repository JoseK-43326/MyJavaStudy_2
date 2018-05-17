import java.util.*;
import java.util.regex.*;


public class RegExTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Pattern: ");
		String patternString = in.nextLine();
		
		Pattern pattern = null;
		pattern = Pattern.compile(patternString);		
		while(true){
			System.out.println("Enter String to match : ");
			String input = in.nextLine();
			if(input == null || input == "") return;
			Matcher matcher = pattern.matcher(input);
			int count = matcher.groupCount();
			if(matcher.matches()){
				System.out.println("Match!!");
				if(count > 0){
					for(int i = 0; i < input.length(); i++){
						for(int j = 1; j <= count; j++)
							if(i == matcher.start(j))
								System.out.print("(");
						System.out.print(input.charAt(i));
						for(int j = 1; j <= count; j++)
							if(i+1 == matcher.end(j))
								System.out.print(")");
						
					}
				System.out.println();				
				}			
			}else {
				System.out.println("Don't match!!");
			}
			
		}
	}

}
