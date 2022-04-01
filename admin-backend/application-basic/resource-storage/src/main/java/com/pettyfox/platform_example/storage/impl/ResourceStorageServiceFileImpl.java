package com.pettyfox.platform_example.storage.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.pettyfox.platform_example.storage.ResourceStorageService;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.*;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/9/16</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@Slf4j
public class ResourceStorageServiceFileImpl implements ResourceStorageService {

    private ExecutorService threadPool = new ThreadPoolExecutor(2, 10, 60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100), ThreadFactoryBuilder.create().setNamePrefix("res-store-").build()
            , new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    });

    private final String rootPath;

    public ResourceStorageServiceFileImpl(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public void syncStorageData(byte[] data, String resourcePath) {
        File file = Paths.get(rootPath, resourcePath.replace("/", File.separator)).toFile();
        FileUtil.writeBytes(data, file);
    }

    @Override
    public void asyncStorageData(byte[] data, String resourcePath) {
        threadPool.execute(() -> {
            syncStorageData(data, resourcePath);
        });
    }

    @Override
    public void syncDeleteFile(String resourcePath) {

    }

}
