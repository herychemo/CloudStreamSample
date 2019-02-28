
docker pull rabbitmq:3.7-rc-management-alpine

docker run -p 5672:5672     \
	-p 15672:15672	\
    --name RabbitMQ-Server   \
	--hostname OurRabbitMQ	\
    -d rabbitmq:3.7-rc-management-alpine

docker logs -f RabbitMQ-Server
