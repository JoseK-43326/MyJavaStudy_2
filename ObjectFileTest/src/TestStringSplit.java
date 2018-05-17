import java.util.Arrays;


public class TestStringSplit {

	public static void main(String[] args) {
		String str = "josek@qq.com;josek@163.com;josek@sohu.com";
		String[] array = str.split(";");
		System.out.println(Arrays.toString(array));
	}

}
