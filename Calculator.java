public class Calculator {

  public static void main(String[] args) {
    System.out.println("8 2 + 99 9 - * 2 + 9 -");
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println("1 2 3 4 5 + * - -");
    System.out.println(eval("1 2 3 4 5 + * - -"));
  }

  public static double eval(String s) {
    @SuppressWarnings("unchecked")
    MyDeque<Double> stack = new MyDeque<Double>();
    String temp = "";
    for(int x = 0; x < s.length(); x ++) {
      //System.out.println("Stack: " + stack);
      //System.out.println(s.charAt(x));
      if (s.charAt(x) == ' ') {
        if (temp.length() > 0)stack.addLast(Double.parseDouble(temp));
        temp = "";
      }
      else if (checkSign(s.charAt(x))) {
        try {
          Double second = stack.removeLast();
          Double first = stack.removeLast();
          //System.out.println("First: " + first);
          //System.out.println("Second: " + second);
          stack.addLast(calculate(first, second, s.charAt(x)));
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
      else temp += s.charAt(x);
    }
    return stack.removeLast();
  }

  private static boolean checkSign(char input) {
    return (input == '+' || input == '-' || input == '*' || input == '/' || input == '%');
  }

  private static Double calculate(Double x, Double y, char sign) {
    Double output = 0.0;
    if (sign == '+') {
      output = x + y;
    }
    if (sign == '-') {
      output = x - y;
    }
    if (sign == '*') {
      output = x * y;
    }
    if (sign == '/') {
      output = x / y;
    }
    if (sign == '%') {
      output = x % y;
    }
    //System.out.println("Adding: " + output);
    return output;
  }
}
