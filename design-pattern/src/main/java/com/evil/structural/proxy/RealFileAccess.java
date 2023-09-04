package com.evil.structural.proxy;

/**
 * RealFileAccess
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体实现类：真实文件访问
class RealFileAccess implements FileAccess {
    private String fileName;

    public RealFileAccess(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void accessFile() {
        System.out.println("访问文件：" + fileName);
    }
}
