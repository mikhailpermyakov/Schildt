interface StringFunc{
    String func(String str);
}

public class LambdaArgumentDemo {

    private static String changeStr(StringFunc sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda expressions expand Java";
        String outStr;

        System.out.println("Input string: " + inStr);

        StringFunc reverse = str -> {
            StringBuilder result = new StringBuilder();

            for (int i = str.length() - 1; i >= 0; i--)
                result.append(str.charAt(i));
                return result.toString();
        };

        outStr = changeStr(reverse, inStr);
//        outStr = reverse.func(inStr);
        System.out.println("Reversed string: " + outStr);

        outStr = changeStr(str -> str.replace(' ', '-'), inStr);
        System.out.println("String with replaced spaces: " + outStr);

        outStr = changeStr(str -> {
            StringBuilder result = new StringBuilder();
            char ch;

            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (Character.isUpperCase(ch))
                    result.append(Character.toLowerCase(ch));
                else
                    result.append(Character.toUpperCase(ch));
            }
            return result.toString();
        }, inStr);
        System.out.println("String with the inverse case: " + outStr);
    }
}
