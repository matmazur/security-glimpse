package utils;

public class Salt {

    private static final String PRE = "SDtge4534%$#TrSA";
    private static final String POST = "&^%$&hgfHGFD3242W";

    public static Salt salt = new Salt();

    private Salt() {
    }

    public static String salter(String string) {

        return PRE + string + POST;
    }
}
