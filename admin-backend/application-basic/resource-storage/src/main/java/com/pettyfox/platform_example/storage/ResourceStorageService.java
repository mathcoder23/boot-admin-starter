package com.pettyfox.platform_example.storage;


/**
 * 资源存储服务,将资源以各种形式存储下来,比如文件存储,oss存储
 *
 * @author eface.m
 */
public interface ResourceStorageService {
    /**
     * 同步存储数据
     *
     * @param data         二进制数据
     * @param resourcePath 存储位置
     * @return
     */
    void syncStorageData(byte[] data, String resourcePath);

    /**
     * 异步存储数据
     *
     * @param data         二进制数据
     * @param resourcePath 存储位置
     * @return
     */
    void asyncStorageData(byte[] data, String resourcePath);

    /**
     * 同步删除资源
     *
     * @param resourcePath
     */
    void syncDeleteFile(String resourcePath);
}
