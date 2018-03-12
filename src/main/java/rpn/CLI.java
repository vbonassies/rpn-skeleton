package rpn;

import java.io.*;
import java.util.*;

public class CLI {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            String s = in.readLine();
            if (s==null) break;
            Stack<String> tks = new Stack<String>();
            tks.addAll(Arrays.asList(s.trim().split("[ \t]+")));
            if (tks.peek().equals("")) continue;
            try {
                double r = evaluate(tks);
                if (!tks.empty()) throw new Exception();
                System.out.println(r);
            }
            catch (Exception e) {System.out.println("error");}
        }
    }

    static double evaluate(String string) {
        try {
            Stack<String> stack = new Stack<>();
            String [] strings = string.split(" ");
            for (String s : strings) {
                stack.push(s);
            }
            return evaluate(stack);
        } catch (Exception e) {
            return 0;
        }
    }

    private static double evaluate(Stack<String> tks) throws Exception {
        String tk = tks.pop();
        double x,y;
        try {x = Double.parseDouble(tk);}
        catch (Exception e) {
            y = evaluate(tks);  x = evaluate(tks);
            if      (tk.equals("+"))  x += y;
            else if (tk.equals("-"))  x -= y;
            else if (tk.equals("*"))  x *= y;
            else if (tk.equals("/"))  x /= y;
            else throw new Exception();
        }
        return x;
    }
}