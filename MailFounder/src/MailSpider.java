import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailSpider {
	private static int Count = 0;
	public static void main(String[] args) {
		
		File f = new File("E:\\java\\Image\\email.html");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = null;
			while( (s = br.readLine()) != null){
				Pattern p = Pattern.compile("[\\w]+@[\\w]+\\.[\\w]{2,3}");
				Matcher m = p.matcher(s);
				while(m.find()){
					Count++;
					System.out.println(m.group());
				}
			}
			System.out.println("ƥ�䵽��E-Mail������" + Count);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
