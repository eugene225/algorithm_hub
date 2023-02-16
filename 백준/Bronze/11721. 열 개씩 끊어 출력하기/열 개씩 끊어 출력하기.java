import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        for(int i=0;i<len/10*10;i+=10){
            System.out.println(s.substring(i, i+10));
        }

        if(len%10!=0){
            System.out.println(s.substring(len/10*10, len));
        }

    }

}