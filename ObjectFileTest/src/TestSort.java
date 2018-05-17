import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestSort {

	public static void main(String[] args) {
		
//		String[] str = new String[]{"asd","dce","dc","asdew","s"};
//		sort(str);
//		Integer[] str1 = new Integer[]{1,2,35,7,32,9};
//		sortInt(str1);
		List<String> list = new ArrayList<String>();
		list.add("asd");
		list.add("dce");
		list.add("dc");
		list.add("s");
		System.out.println(list);
		sort(list);
		System.out.println(list);
		
	}
	
	public static <T extends Comparable<T>> void sort(List<T> list){
		Object[] array = list.toArray();
		sortObject(array);
		for(int i = 0; i < array.length; i++)
			list.set(i, (T)array[i]);
	}
	
	public static void sortObject(Object[] str){	
		boolean flag = true;
		for(int j = 0; j < str.length -1; j++){
			flag = true;
			System.out.println("第"+(j+1)+"趟");
			for(int i = 0; i < str.length-1-j; i++){
				System.out.print("第"+(i+1)+"次");
				if(((Comparable)str[i]).compareTo(str[i+1]) > 0){
					Object temp = str[i];
					str[i] = str[i+1];
					str[i+1] = temp;	
					flag = false;
					}
				System.out.println(Arrays.toString(str));
			}			
			if(flag){ break;}
		}
	}
	
	public static void sortInt(Integer[] str){
		int temp;
		boolean flag = true;
		for(int j = 0; j < str.length -1; j++){
			flag = true;
			System.out.println("第"+(j+1)+"趟");
			for(int i = 0; i < str.length-1-j; i++){
				System.out.print("第"+(i+1)+"次");
				if(str[i].compareTo(str[i+1]) > 0){
					temp = str[i];
					str[i] = str[i+1];
					str[i+1] = temp;	
					flag = false;
					}
				System.out.println(Arrays.toString(str));
			}			
			if(flag){ break;}
		}
	}
	
	public static void sort(String[] str){
		String temp = null;
		boolean flag = true;
		for(int j = 0; j < str.length -1; j++){
			flag = true;
			System.out.println("第"+(j+1)+"趟");
			for(int i = 0; i < str.length-1-j; i++){
				System.out.print("第"+(i+1)+"次");
				if(str[i].compareTo(str[i+1]) > 0){
					temp = str[i];
					str[i] = str[i+1];
					str[i+1] = temp;	
					flag = false;
					}
				System.out.println(Arrays.toString(str));
			}			
			if(flag){ break;}
		}
	}

}
