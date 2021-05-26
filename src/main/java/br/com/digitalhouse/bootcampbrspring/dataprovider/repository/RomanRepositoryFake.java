package br.com.digitalhouse.bootcampbrspring.dataprovider.repository;

public class RomanRepositoryFake {
	private static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
	public static String getRomanNumberOf(Integer number) {
		return convertNumber(number);
	}
	
	private static String convertNumber(Integer number) {
	    StringBuilder roman = new StringBuilder();

	    for(int i=0;i<values.length;i++) {
	        while(number >= values[i]) {
	        	number -= values[i];
	            roman.append(romanLiterals[i]);
	        }
	    }
	    return roman.toString();
	}
			
}
