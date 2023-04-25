#To remove spring boot application image
removeSpringAppImage() {
  docker rmi $1
  rm -rf $1/target
}

docker-compose stop
docker rm demo-rabbit
docker rm api

#removeSpringAppImage 'demo-producer'
#removeSpringAppImage 'demo-consumer'

