package src.managers;

import src.utilities.DisplayUtil;
import src.utilities.NoStackTraceThrowable;
import src.utilities.SystemUtil;
import src.utilities.URLReader;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class HWIDManager {

    /**
     * pastebinURL example: https://pastebin.com/raw/pasteid
     */

    public static final String pastebinURL = "";

    public static List<String> hwids = new ArrayList<>();

    public static void hwidCheck() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        hwids = URLReader.readURL();
        boolean isHwidPresent = hwids.contains(SystemUtil.getSystemInfo());
        if (!isHwidPresent) {
            DisplayUtil.Display();
            throw new NoStackTraceThrowable("");
        }
    }
}
