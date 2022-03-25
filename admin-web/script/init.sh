echo "yarn初始化进入加速通道"
echo "yarn配置node-sass加速通道"
yarn config set sass_binary_site http://cdn.npm.taobao.org/dist/node-sass -g
yarn install --registry=https://registry.npm.taobao.org