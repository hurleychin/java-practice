# Windows

## 彻底关闭 Hyper-V服务

以管理员身份运行命令提示符，执行命令 `bcdedit /set hypervisorlaunchtype off`

如果想要恢复hyper-v启动，`bcdedit / set hypervisorlaunchtype auto`