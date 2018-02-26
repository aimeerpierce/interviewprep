//given a string, check to see if it is a permeation of a palindrome
//e.g. tact coa --> taco cat, atco cta
//so the letters have to have 2 of eac, letter and one different one!

public class Palindrome {

	public static boolean isPermutation(String str){
		int[] table = charFrequencyTable(str);
		return checkFrequencyTable(table);
	}

	//this method checks the table to see if only one instance is a value of 1
	public static boolean checkFrequencyTable(int[] table){
		boolean count1 = false;
		for(int i = 0; i< table.length; i++){
			if(table[i]%2 == 1){
				if(count1){
					return false;
				}
				count1 = true;
			}
		}
		return true;
	}

	//this method creates a table that counts the frequency of each character
	public static int[] charFrequencyTable(String str){
		//make a table that has space for every letter of the alphabet
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a') +1];

		for(char c : str.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
			}
		}
		return table;

	}

	//this method maps a character to a numeric value between a-z
	public static int getCharNumber(char c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');

		int val = Character.getNumericValue(c);
		if(a <= val || val <=z){
			return val - a;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(isPermutation("tacocat"));
		System.out.println(isPermutation("aabbccc"));
		System.out.println(isPermutation("tacocatz"));
	}

}
