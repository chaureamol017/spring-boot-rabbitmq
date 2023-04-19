docker-compose stop
docker rm demo-rabbit
docker rm api

#To remove spring boot application image
docker rmi spring-boot-rest-demo
rm -rf spring-boot-rest-demo/target

