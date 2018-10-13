package utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Salt {

    private static final String PRE = "SDtge4534%$#TrSA";
    private static final String POST = "&^%$&hgfHGFD3242W";

    public static Salt salt = new Salt();

    private Salt() {
    }

    public static String saltAndHash(String string) {

        return hasher(PRE + string + POST);
    }

    private static String hasher(String string) {

        return Hashing
                .sha256()
                .hashString(string, StandardCharsets.UTF_8)
                .toString();
    }
}
