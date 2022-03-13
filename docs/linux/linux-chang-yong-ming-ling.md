# Linux常用命令

压缩文件

```
# touch a.c       
# tar -czvf test.tar.gz a.c   //压缩 a.c文件为test.tar.gz
a.c
```

列出压缩文件内容

```
# tar -tzvf test.tar.gz 
-rw-r--r-- root/root     0 2010-05-24 16:51:59 a.c
```

解压文件

```
# tar -xzvf test.tar.gz 
a.c
```

### 查看磁盘空间

- **df -hl**：查看磁盘剩余空间
- **df -h**：查看每个根路径的分区大小
- **du -sh [目录名]**：返回该目录的大小
- **du -sm [文件夹]**：返回该文件夹总M数
- **du -h [目录名]**：查看指定文件夹下的所有文件大小（包含子文件夹）
