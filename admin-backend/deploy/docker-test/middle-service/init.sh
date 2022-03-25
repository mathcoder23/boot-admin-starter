
mkdir -p ${ENV_DIR}/mysql-data
mkdir -p ${ENV_DIR}/redis-data/config
mkdir -p ${ENV_DIR}/nacos-data/config

mkdir -p ${ENV_DIR}/nacos-data/data/standalone-logs

cp -R ./mysql-data/* ${ENV_DIR}/mysql-data/
cp ./redis-config/redis.conf ${ENV_DIR}/redis-data/config/redis.conf
cp -R ./nacos-config/* ${ENV_DIR}/nacos-data/config/