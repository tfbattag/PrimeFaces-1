/*
 * Copyright (c) 2013. All rights reserved.
 */

package edu.umt.utils;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/7/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileBlobConverter {

    public static void setFileBytes(byte[] data) throws Exception {
        //
    }

    /**
     * Use this method to create a file (staic or temporary) to the filesystem from a byte[].
     * @param data The byte array that will be written to the filesystem.
     * @param filenameSuffix  Use this arg to append unique text to the filename.
     * @throws Exception
     */
    public static void setFileBytes(byte[] data, String filename) throws Exception {
        File tempScan = new File(filename);
        FileOutputStream fos = new FileOutputStream(tempScan);
        fos.write(data);
        fos.close();
    }

    /**
     * Use this method to read a File and write it out as a byte[].  This byte[]
     * can be used for the property to be set on a MySQL BLOB.
     * @param file
     * @return
     * @throws Exception
     */
    public static byte[] getFileAsBytes(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        byte[] data = new byte[new Long(fc.size()).intValue()];
        ByteBuffer bb = ByteBuffer.wrap(data);
        fc.read(bb);
        System.out.println(data.length);
        return data;
    }

}
