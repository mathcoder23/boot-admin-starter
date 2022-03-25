# 说明
> 后台模板前端开发框架

基于avue-cli后台模板进行改进优化，便捷并能更快速使用
# 项目初始化
```shell
chmod +x script/init.sh
./script/init.sh
```
这段脚本实际上就是通过yarn安装，不过添加了个国内镜像
## npm/yarn安装问题
### node或npm版本过低
根据提示，使用`node -v或`npm -v`查看版本是否满足要求
```shell
sudo npm cache clean -f
sudo npm install -g n
sudo n stable
```


# 项目运行
> 我觉得怎么运行可以在package.json里面查看，不过我可以在这里告诉你简单的。
`yarn run serve`

# 开发规范

## 项目版本
> 项目开发一定要有版本追溯。尽管项目在git仓库中管理，但是项目进展的版本说明是非常重要的。

### 版本说明
> 项目版本的记录在 version/web-version-record.md 文件中，每次新增版本，修改项目内容需要在这里记录

### 版本递增
```nodejs
version/new-version.js
```
每新增一个版本，执行一次，脚本分别会修改version/web-version-record.md文件和src/version.js文件，直接效果就是前端可以看到项目当前的版本

当然前端版本的显示是不够的，还需要记录后端接口的版本。
