cd `dirname $0`
source .env
docker-compose -f application-service/gateway-service/docker-compose-gateway.yml -p ${DOCKER_STACK_NAME} up -d
#docker-compose -f application-service/video-stream-service/docker-compose.yml -p ${DOCKER_STACK_NAME} up -d
#docker-compose -f application-service/ai-kitchen-service/docker-compose-ai-kitchen.yml -p ${DOCKER_STACK_NAME} up -d
#docker-compose -f application-service/xxl-job-service/docker-compose.yml -p ${DOCKER_STACK_NAME} up -d
