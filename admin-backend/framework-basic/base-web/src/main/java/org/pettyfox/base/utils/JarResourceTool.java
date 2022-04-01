package org.pettyfox.base.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/19</p>
 * <p></p>
 * 将jar包内的resource文件转换到本地文件存储
 * 之所以需要如此是因为java的resource只能以stream的方式读取，但是某些场景我们只能使用file文件
 *
 * @author Petty Fox
 * @version 1.1
 * @date 2021-10-19
 */
public class JarResourceTool {
    /**
     * 保证，程序重新运行后都要覆盖之前的文件，解决文件更新的问题
     */
    private static List<String> hasCreate = new ArrayList<>();

    /**
     * java的resource只能以stream的方式读取，但是某些场景我们只能使用file文件
     * 此方法提供将resource转换为file
     *
     * @param resourcePath resource相对路径
     * @return file文件
     */
    public static File fileByResource(String resourcePath) {
        File file = new File(resourcePath);
        if (file.exists() && hasCreate.contains(resourcePath)) {
            return file;
        }
        InputStream in = JarResourceTool.class.getClassLoader().getResourceAsStream(resourcePath);
        try {
            FileUtils.copyInputStreamToFile(in, file);
            hasCreate.add(resourcePath);
        } catch (IOException e) {
            file.delete();
            e.printStackTrace();
        }
        return file;
    }
}
