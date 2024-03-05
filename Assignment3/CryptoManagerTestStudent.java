/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: This is a class meant to test various possibilities within the strings of caesar and bellaso encrypt/decrypt
 * Due: 03/04/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dylan Avallone
*/




package Application;

public class CryptoManagerTestStudent {

	public static void main(String[] args) {
		String strTest1 = "\"THIS TEST WILL FAIL AND SHOULD {{}{{}} FAIL SINCE IT IS WAY  OUTSIDE THE RANGE\"";
		String strTest2 = "\"THIS TEST SHOULD SUCCEED SINCE ITS IN RANGE\"";
		String strTest3 = "\"This test should fail because of lowercase letters\""; 
		String strTest4 = "HAHAHA";
		String strTest5 = "KDKDKD";
		String strTest6 = "?))5;6";
		String bellasoStrTest = "WHATSUP3444";
// tests to check string 1 and 2 
		boolean inBounds = CryptoManager.isStringInBounds(strTest1);
		boolean notinBounds = CryptoManager.isStringInBounds(strTest2);
		System.out.println(strTest1+" Is the string in bounds? "+inBounds);
		System.out.println(strTest2+" Is it in bounds? "+notinBounds);
//// test to check string 3 		
		notinBounds = CryptoManager.isStringInBounds(strTest3);		
		System.out.println(strTest3+" Is it in bounds? "+notinBounds);
//caesar & bellaso encrypt/decrypt tests		
		System.out.println("Caesar cipher of \""+strTest4+"\" should return \"KDKDKD\":   "+ CryptoManager.caesarEncryption(strTest4, 3));
		System.out.println("Caesar decryption of \""+strTest5+"\" should return \"HAHAHA\":    "+ CryptoManager.caesarDecryption(strTest5, 3));
		System.out.println("Bellaso cipher of \""+strTest4+"\" should return \"?))5;6\":    "+ CryptoManager.bellasoEncryption(strTest4, bellasoStrTest));
		System.out.println("Bellaso decryption of \""+strTest6+"\" should return \"HAHAHA\":    "+ CryptoManager.bellasoDecryption(strTest6, bellasoStrTest));
	}

	
	
	
	
}
