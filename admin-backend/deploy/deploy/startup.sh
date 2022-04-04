source ./env
docker-compose -f application-service/docker-compose.yml -p ${DOCKER_STACK_NAME} up -d