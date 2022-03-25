package org.pettyfox.base.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class FilePathTool {
    public static String filePath2Uri(String filePath){
        if(StringUtils.isBlank(filePath)){
            return filePath;
        }
        return filePath.replace(System.getProperty("user.dir"),"").replace("\\","/");
    }
    public static String uri2filePath(String uri){
        if (StringUtils.isBlank(uri)) {
            return uri;
        }
        if (File.separator.equals("\\")) {
            //win
            uri = uri.replace("/", "\\");
        }
        return System.getProperty("user.dir") + File.separator + uri;
    }

}