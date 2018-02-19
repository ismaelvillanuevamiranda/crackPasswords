/*
OUTPUT
james78_0MO 8dac38879e6bcf47db695568bccdc30c6da1eeb4 leached
linda78_0MO c02bba59dd9efb760f42e8b0a89e8babab5ab47f nitrify
sofia78_0MO 643264e2af4fa29cc739ce78a4eaf63b669584fb swollen
santiago78_0MO e5926316a72cce45095ea873fb5236f478c86ed7 presumably
isabella78_0MO e253945f69f2c1c30c582fe0289946e031db2c9e paisan
diego78_0MO 90d162ef92bde8dbcc22e68bdc47b3068acda69e reaccommodates
robert78_0MO 0173ce842d767e61d7c1ca613cfc4fed2db8fbbc reinterrogation
mary78_0MO db75cc4b0897e94bc72dbc6d33aa546b1a767241 alone
patricia78_0MO 7b19b5fe7fc3c624b9c47d2fb88e8b009b18339a firms
daniela78_0MO 1c0a8c1eed188d36bc4de78b98ade0fdbb83415a sickening
Time:4161 Miliseconds
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.util.*;
import java.io.File;
public class dictPwdFile {

    public static void main(String[] args) throws Exception {


        //==============================================
        //Read the dictionary file in a list
        //==============================================
    		Scanner scDictionary = new Scanner(new File("wordsEn.txt"));
    		List<String> linesDictionary = new ArrayList<String>();
    		while (scDictionary.hasNextLine()) {
    		  linesDictionary.add(scDictionary.nextLine());
    		}
    		String[] dictionary = linesDictionary.toArray(new String[0]);

        //==============================================
        //Read the password file in a list
        //==============================================
            Scanner scPassword = new Scanner(new File("dictPwdFile78.txt"));
            List<String> linesPassword = new ArrayList<String>();
            while (scPassword.hasNextLine()) {
              linesPassword.add(scPassword.nextLine());
            }
            String[] password = linesPassword.toArray(new String[0]);

        //==============================================
        //Measuring running time - START
        //==============================================
            long startTime = System.currentTimeMillis();
            

        //==============================================
        //Cracking the passwords
        //==============================================
            //Reading the salt word from the List
            for(int iPassword=0; iPassword<password.length; iPassword++){
                //Reading the word from the List
                for(int iDictionary=0; iDictionary<dictionary.length; iDictionary++){
                    //Concatenating the Salt word and the dictionary word
                    String concDictionarySalt = dictionary[iDictionary]+password[iPassword].split(",")[1].trim();
                    //Computing the SHA1 of the concatenation (salt + dictionary word)
                    String s = SHA1(concDictionarySalt);
                    //Comparing if both hashes are equals
                    if(s.equals(password[iPassword].split(",")[2].trim())){
                        // Printing username, hash, and password
                        System.out.println(password[iPassword].split(",")[0].trim()+" "+s+" "+dictionary[iDictionary]);
                    }
                }
            }

        //==============================================
        //Measuring running time - END
        //==============================================            
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time:"+elapsedTime);


    }
        //==============================================
        //Method SHA1: Computing the hashed password
        //This method is based on the program provided 
        //by Dr. Longpre
        //==============================================            
            public static String SHA1(String toHash){
            	try{
        	        MessageDigest hash = MessageDigest.getInstance("SHA1");
        	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	        hash.update(toHash.getBytes());
        	        byte[] digest = hash.digest();
        	    	return DatatypeConverter.printHexBinary(digest).toLowerCase();
            	}catch(Exception e){
            		return null;
            	}
            }
}





