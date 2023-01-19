# Arch Linux禁用ipv6

如果您遇到一些问题，可以试着向内核参数加入 ipv6.disable=1 ，来完全关闭 IPv6 功能， 参考 内核参数 来了解更多信息.

此外，只加入ipv6.disable_ipv6=1内核参数可以保留IPv6功能，但不会向网卡分配IPv6地址。

也可以通过向/etc/sysctl.d/40-ipv6.conf加入如下配置来避免系统给网卡分配IPv6地址：

```shell
# Disable IPv6
net.ipv6.conf.all.disable_ipv6 = 1
net.ipv6.conf.nic0.disable_ipv6 = 1
...
net.ipv6.conf.nicN.disable_ipv6 = 1
```
重启 systemd-sysctl.service 单元来应用上述设置。

注意你必须在这里清楚地列出所有不需要分配IPv6地址的网卡，仅仅设置all.disable_ipv6并不会立刻对已经连接的网卡起作用。

注意： 如果通过 sysctl 禁用IPv6， 你应该在/etc/hosts中删除所有的IPv6主机，否则当你使用主机名连接它们的时候会解析到不通的IPv6地址
