package src.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemUtil {

    private static final Logger LOGGER = Logger.getLogger(SystemUtil.class.getName());
    private static String OS = "";

    public static String getOS() {
        if (OS.isEmpty()) {
            OS = System.getProperty("os.name", "unknown");
        }
        return OS;
    }

    public static boolean isUnix() {
        String osName = getOS().toLowerCase();
        return osName.contains("nux") || osName.contains("nix") || osName.contains("mac");
    }

    public static String getSystemInfo() {
        String linuxPadding = "";

        if (isUnix()) {
            linuxPadding = "unix";
            try {
                Process process = Runtime.getRuntime().exec("/usr/bin/hostnamectl");
                try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    StringBuilder output = new StringBuilder();
                    String line;
                    while ((line = stdInput.readLine()) != null) {
                        output.append(line).append("\n");
                    }
                    String outputString = output.toString();
                    if (outputString.contains("Machine ID: ")) {
                        linuxPadding += outputString.split("Machine ID: ")[1].split("\n")[0].trim();
                    }
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to get system info", e);
            }
        } else {
            linuxPadding = getOS();
        }

        try {
            String hwid = SHA1(System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("COMPUTERNAME") + System.getProperty("user.name") + linuxPadding);
            return hwid;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOGGER.log(Level.SEVERE, "Failed to generate hardware ID", e);
            return null;
        }
    }

    private static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = md.digest(text.getBytes("UTF-8"));
        return convertToHex(sha1hash);
    }

    private static String convertToHex(byte[] data) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : data) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}