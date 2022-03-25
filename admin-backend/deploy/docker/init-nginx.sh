cd `dirname $0`
source .env
chmod +x ./application-service/init.sh
cd ./application-service
./init.sh