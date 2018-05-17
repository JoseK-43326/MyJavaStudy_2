import java.io.*;



public class CodeCount {
	private static int codeCount = 0;
	private static int annotationCount = 0;
	private static int whiteCount = 0;
	
	public static void main(String[] args) {
		
		File f = new File("E:\\java\\GBC\\");
		File[] files = f.listFiles();
		for(File file : files){
			parse(file);
		}
		
	}

	private static void parse(File file) {
		boolean flag = false;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null){
				
				if(line.matches("^[\\s]*[\\s]$")){
					whiteCount ++;
				}else if(line.startsWith("/*") && !line.endsWith("*/")){
					annotationCount++;
					flag = true;
				} else if(true == flag){
					annotationCount++;
					if(line.endsWith("*/")){
						flag = false;
						}					
				}  
				else{
					codeCount++;
				}			
			}
			System.out.println("codeCount: " + codeCount);
			System.out.println("annotationCount: " + annotationCount);
			System.out.println("whiteCount: " + whiteCount);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
