/*
OUTPUT
Len = 1 | isabella78-0MO | b51a60734da64be0e618bacbea2865a8a7dcd669 | b51a60734da64be0e618bacbea2865a8a7dcd669 | N
Time:14 ms

Len = 2 | diego78-0MO | e04d0aa5d93da7e7cf55f287a75e786b62277651 | e04d0aa5d93da7e7cf55f287a75e786b62277651 | d_
Time:34 ms

Len = 3 | robert78-0MO | af7c1f97b161972c97dd23a400663429a12e8cb9 | af7c1f97b161972c97dd23a400663429a12e8cb9 | vpp
Time:530 ms

Len = 4 | linda78-0MO | 246de260e9d29b2072057ae0b3b39623c5432c4c | 246de260e9d29b2072057ae0b3b39623c5432c4c | OXPr
Time:175272 ms

Len = 5 | mary78-0MO | 0c88b7d7942219c30c73edd1d8cda1f5bdb67c5a | 0c88b7d7942219c30c73edd1d8cda1f5bdb67c5a | 1-DQJ
Time:9768 ms
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.util.*;
import java.io.File;

public class randPwdFile {
    public static void main(String[] args) throws Exception {
        //==============================================
        //Read the password file into a list
        //==============================================
            Scanner scPassword = new Scanner(new File("randPwdFile78.txt"));
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
            int len = 6;
            int found=0;
     
            while(found==0){
                char[] pswd = generatePswdComplete(len);
                String s = SHA1(new String(pswd));
                    //Comparing if both hashes are equals
                for(int iPassword=0; iPassword<password.length; iPassword++){
                    if(s.equals(password[iPassword].split(",")[1].trim())){
                        // Printing username, hash, and password
                        System.out.println("Len = " + pswd.length + " | " + password[iPassword].split(",")[0].trim()+ " | " + password[iPassword].split(",")[1].trim()+ " | "+s+" | "+new String(pswd));
                        found++;
                    }else{
                    }              
                    System.out.println("Len = " + pswd.length + " | " + password[iPassword].split(",")[0].trim()+ " | " + password[iPassword].split(",")[1].trim()+ " | "+s+" | "+new String(pswd));
                }
            }
        //==============================================
        //Measuring running time - END
        //==============================================            
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Time:"+elapsedTime+" ms");
    }
    //==============================================
    //Method SHA1: Computing the hashed password
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
    //===========================================================
    //Method generatePswdComplete: Generate a new random password
    //===========================================================
        public static char[] generatePswdComplete(int len) {
            //String that contains all allowable characters to generate a password
            String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-";
            Random rnd = new Random();
            char[] pswd = new char[len];
            int index = 0;
            //
            for(int j=0; j<len; j++){
                index = getNextIndex(rnd, len, pswd);
                pswd[index] = CHARS.charAt(rnd.nextInt(CHARS.length()));
            }
            return pswd;
        }        
    //==================================================================================
    //Method getNextIndex: Determines if a specific position in the pswd string is empty
    //==================================================================================
        public static int getNextIndex(Random rnd, int len, char[] pswd) {
            int index = rnd.nextInt(len);
            while(pswd[index = rnd.nextInt(len)] != 0);
            return index;
        }
}

