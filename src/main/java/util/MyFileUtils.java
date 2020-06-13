/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author glamb
 */
public class MyFileUtils {

    public static byte[] convertInputStreamToByteArray(InputStream in) {

        byte[] returnArray = null;

        try {
            returnArray = new byte[in.available()];
            in.read(returnArray);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }
}
