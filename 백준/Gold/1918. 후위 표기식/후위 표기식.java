import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);

            if(now=='+'||now=='-'||now=='*'||now=='/'){
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(now)){
                    sb.append(stack.pop());
                }
                stack.add(now);
            }else if(now=='('){
                stack.add(now);
            }else if(now==')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                sb.append(now);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.print(sb.toString());
    }

    public static int priority(char oper){
        if(oper=='(' || oper==')') return 0;
        else if(oper=='+'||oper=='-') return 1;
        else if(oper=='*' || oper=='/') return 2;
        return -1;
    }

}