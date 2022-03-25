cd `dirname $0`
source .env
docker-compose -f application-service/ai-kitchen-service/docker-compose-ai-kitchen.yml -p ${DOCKER_STACK_NAME} up -d
