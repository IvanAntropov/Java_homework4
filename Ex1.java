// Написать программу, определяющую правильность расстановки скобок в выражении.

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.*;


public class Ex1{

/*  //Решение при помощи массивов
    static boolean IsIn(char c, char[] arr){
        for (int i = 0; i < arr.length; i++){
            if(c == arr[i]){
                return true;
            }
        }
        return false;
    }

    static int IsIndex(char c, char[] arr){
        for (int i = 0; i < arr.length; i++){
            if(c == arr[i]){
                return i;
            }
        }
        return -1;
    }

    public static boolean BraceAudit(String string){
        Stack<Character> braces = new Stack<>();
        char[] openBrackets = new char[]{'{', '[', '(','<'};
        char[] closeBrackets = new char[]{'}', ']', ')','>'};
        char c;
        for(int i = 0; i < string.length(); i++){
            c = string.charAt(i);
            if(IsIn(c,openBrackets)){
                braces.push(c);
            }else if(IsIn(c,closeBrackets) && !braces.empty()){
                char help = braces.pop();
                if(IsIndex(help,openBrackets) != IsIndex(c,closeBrackets)) {
                    return false;
                    }
                }
            }
        return braces.empty();
        }
*/

    //Решение с HashMap
    public static boolean BraceAuditHashMap(String string){
        Stack<Character> braces = new Stack<>();
        Map<Character,Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('[',']');
        brackets.put('{','}');
        brackets.put('<','>');
        char c;
        for(int i = 0; i < string.length(); i++){
            c = string.charAt(i);
            if(brackets.containsKey(c)){
                braces.push(c);
            }else if(brackets.containsValue(c) && !braces.empty()){
                char help = braces.pop();
                if(brackets.get(help) != c) {
                    return false;
                }
            }
        }
        return braces.empty();
    }

    public static void main(String[] args) {

//        Пример 1: a+(d*3) - истина
//        Пример 2: [a+(1*3) - ложь
//        Пример 3: [6+(3*3)] - истина
//        Пример 4: {a}[+]{(d*3)} - истина
//        Пример 5: <{a}+{(d*3)}> - истина
//        Пример 6: {a+]}{(d*3)} - ложь


//        System.out.println("a+(d*3) : " + BraceAudit("a+(d*3)"));
//        System.out.println("[a+(1*3) : " + BraceAudit("[a+(1*3)"));
//        System.out.println("[[6+(3*3)] : " + BraceAudit("[6+(3*3)]"));
//        System.out.println("{a}[+]{(d*3)} : " + BraceAudit("{a}[+]{(d*3)}"));
//        System.out.println("<{a}+{(d*3)}> : " + BraceAudit("<{a}+{(d*3)}>"));
//        System.out.println("{a+]}{(d*3)} : " + BraceAudit("{a+]}{(d*3)}"));

        System.out.println("a+(d*3) : " + BraceAuditHashMap("a+(d*3)"));
        System.out.println("[a+(1*3) : " + BraceAuditHashMap("[a+(1*3)"));
        System.out.println("[[6+(3*3)] : " + BraceAuditHashMap("[6+(3*3)]"));
        System.out.println("{a}[+]{(d*3)} : " + BraceAuditHashMap("{a}[+]{(d*3)}"));
        System.out.println("<{a}+{(d*3)}> : " + BraceAuditHashMap("<{a}+{(d*3)}>"));
        System.out.println("{a+]}{(d*3)} : " + BraceAuditHashMap("{a+]}{(d*3)}"));

    }
}