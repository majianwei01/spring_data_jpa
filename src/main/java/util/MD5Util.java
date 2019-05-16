package util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
    public static final String SALT="majianwei";
    private static final String ALGORITHMNAME="MD5";
    private static final Integer HASHLTERATIONS=9;
    public static String creatMD5(String password){
        SimpleHash simpleHash = new SimpleHash(ALGORITHMNAME, password, SALT, HASHLTERATIONS);
        return simpleHash.toHex();
    }
}
