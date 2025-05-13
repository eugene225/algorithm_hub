import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);
            if(ch == ')') {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count += 1;
                }
            }else {
                stack.push(str.charAt(i));
            }
        }

        System.out.println(count);
    }
}