import java.util.ArrayList;

public class Urlify {
	public static String urlify(String str){
		char[] charr = str.toCharArray();
		ArrayList<Character> chars = new ArrayList<Character>();
		//int spaces = 0;
		for(int i = 0; i < charr.length; i++){
			if(charr[i] == ' '){
				//spaces++;
				chars.add('%');
				chars.add('2');
				chars.add('0');
				//i +=2;
			} else {
				chars.add(charr[i]);
			}
		}
		return String.valueOf(chars);
	}

	public static String urlify2(String stri){
		char[] str = stri.toCharArray();
		int spaces = 0;
		for(int i = 0; i < str.length; i++){
			if(str[i]==' '){
				spaces++;
			}
		}
		int newLength = str.length + spaces*2;
		System.out.println(newLength);
		str[newLength] = '\0';
		for(int j = str.length-1; j >=0; j--){
			if(str[j]==' '){
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				newLength -=3;
			} else {
				str[newLength-1] = str[j];
				newLength -=1;
			}
		}
		return String.valueOf(str);
	}

	public static void main(String[] args) {
		System.out.println("hi hello how are you");
		System.out.println(urlify2("hi hello how are you"));
	}
}
