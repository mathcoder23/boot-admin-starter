source .env
docker-compose -f application-service/nginx/docker-compose-nginx.yml -p ${DOCKER_STACK_NAME} up -d
