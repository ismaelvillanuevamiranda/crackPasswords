/*
ueISMAELs-MacBook-Pro:randPwdFile0 ismaelvillanueva$ time ./onlinePwdFile.sh 
jonathan78_-0MO - dh

real    23m36.113s
user    2m5.938s
sys 0m55.827s

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.util.*;
import java.io.File;

public class onlinePwdFile {

    public static void main(String[] args) throws Exception {
        //==============================================
        //Generating the passwords
        //==============================================
            int len = 2;
            char[] pswd = generatePswdComplete(len);
            System.out.print(new String(pswd));
    }
    //===========================================================
    //Method generatePswdComplete: Generate a new random password
    //===========================================================
        public static char[] generatePswdComplete(int len) {
            String CHARS = "abcdefghijklmnopqrstuvwxyz";
            Random rnd = new Random();
            char[] pswd = new char[len];
            int index = 0;
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