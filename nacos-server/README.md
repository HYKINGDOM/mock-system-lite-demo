# 工程简介


启动 Server，进入解压后文件夹或编译打包好的文件夹，找到如下相对文件夹 nacos/bin，并对照操作系统实际情况之下如下命令。

Linux/Unix/Mac 操作系统，执行命令 sh startup.sh -m standalone
Windows 操作系统，执行命令 cmd startup.cmd


将26行的set MODE="cluster"修改为set MODE="standalone"。这里就是将默认启动集群改为独立的启动。再次启动startup.cmd。

