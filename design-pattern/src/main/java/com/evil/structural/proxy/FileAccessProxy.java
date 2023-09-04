package com.evil.structural.proxy;

/**
 * FileAccessProxy
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 代理类：文件访问代理
class FileAccessProxy implements FileAccess {
    private FileAccess realFileAccess;
    private String userName;

    public FileAccessProxy(String fileName, String userName) {
        this.realFileAccess = new RealFileAccess(fileName);
        this.userName = userName;
    }

    @Override
    public void accessFile() {
        if (userName.equals("admin")) {
            realFileAccess.accessFile();
        } else {
            System.out.println("无权限访问文件");
        }
    }
}
