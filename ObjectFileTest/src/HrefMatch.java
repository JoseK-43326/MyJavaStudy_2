import java.io.*;
import java.util.regex.*;
import java.net.*;

public class HrefMatch {

	public static void main(String[] args) {
		
		String URLString;
		if(args.length > 0) URLString = args[0];
		else URLString = "http://www.baidu.com";
		try {
			InputStreamReader in = new InputStreamReader(new URL(URLString).openStream());
			StringBuilder input = new StringBuilder();
			int ch;
			if((ch = in.read()) != -1) input.append((char) ch);
			Pattern pattern = Pattern.compile("<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>])\\s*");
			Matcher matcher = pattern.matcher(input);
			while(matcher.find()){
				int start = matcher.start();
				int end = matcher.end();
				String match = input.substring(start,end);
				System.out.println(match);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
