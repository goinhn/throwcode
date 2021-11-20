package com.goinhn.throwcode.test;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @date 2021-04-01T14:06:51
 */
public class ExtDir {

    private static File[] getExtDirs() {
        String s = System.getProperty("java.ext.dirs");
        File[] dirs;
        if(s != null){
            System.out.println(s);
            String[] str = s.split(File.pathSeparator);
            dirs = new File[str.length];
            for(int i = 0; i < str.length; i++){
                dirs[i] = new File(str[i]);
            }
        }else{
            dirs = new File[0];
        }

        return dirs;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        File[] files = getExtDirs();
        for (File file : files) {
            System.out.println(file);
        }


    }


}
