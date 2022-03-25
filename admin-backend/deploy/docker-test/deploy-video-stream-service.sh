source .env
docker-compose -f application-service/video-stream-service/docker-compose.yml -p ${DOCKER_STACK_NAME} up -d
