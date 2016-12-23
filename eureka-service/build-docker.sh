echo "Consider running this script with sudo."
mkdir -p build
cp target/tasks-service.jar build/
cp src/main/docker/Dockerfile build/
docker build -t tasks-service build/
echo "Consider running container with option: \"--net=host\"."
