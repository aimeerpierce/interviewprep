public class uniqueString {
	//O(n^2) solution
	public static boolean unique(String str){
		char[] charr = str.toCharArray();
		int length = charr.length;
		boolean unique = true;

		for(int i = 0; i < length; i++){
			for(int j = i+1; j < length; j++){
				if(charr[i]==charr[j]){
					unique = false;
				}
			}
		}
		return unique;
	}

	//O(n) solution
	//Assuming ASCII string
	//ASCII stands for American Standard Code for Information Interchange.
	//Unicode has 136,000+ characters
	public static boolean unique2(String str){
		boolean[] char_set = new boolean[128]; //128 characters in ASCII Table
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i); //returns ASCII value for the character
			System.out.println("index: "+ i);
			System.out.println("val: "+val);
			if(char_set[val]){
				return false;
			}
			char_set[val]=true;
		}
		return true;
	}

	public static void main(String[] args) {
		if(unique2("abcd*^&%zqm0+")){
			System.out.println("string is unique");
		}else {
			System.out.println("string is not unique");
		}
	}
}
