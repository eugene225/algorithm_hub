import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int x, y;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        x = Integer.parseInt(br.readLine());
        y = Integer.parseInt(br.readLine());
        
        if(x > 0 && y > 0)System.out.print(1);
        else if(x > 0 && y < 0) System.out.print(4);
        else if(x < 0 && y > 0) System.out.print(2);
        else if(x < 0 && y < 0) System.out.print(3);
            
    }

}