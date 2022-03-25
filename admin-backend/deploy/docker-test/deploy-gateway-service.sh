cd `dirname $0`
source .env
docker-compose -f application-service/gateway-service/docker-compose-gateway.yml -p ${DOCKER_STACK_NAME} up -d