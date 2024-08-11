package src;

import src.managers.HWIDManager;
import src.utilities.DisplayUtil;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Main {

    // you can make a method that check if the app version is not outdated else it crashes
    
    public static final String VERSION = "0.0.1";

    public static String getVersion() {
        return VERSION;
    }

    public Main() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        try {
            HWIDManager.hwidCheck();
            System.out.println("Access granted. Welcome to the application!");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            DisplayUtil.Display();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
