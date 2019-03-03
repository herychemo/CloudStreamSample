#!/usr/bin/env bash

option="${1}"
case ${option} in
    start)
        echo "Performing: start"
        docker pull rabbitmq:3.7-rc-management-alpine

        docker run -p 5672:5672     \
            -p 15672:15672	\
            --name RabbitMQ-Server   \
            --hostname OurRabbitMQ	\
            -d rabbitmq:3.7-rc-management-alpine

    ;;
    stop)
        echo "Performing: stop"
        docker stop RabbitMQ-Server
        docker rm RabbitMQ-Server
    ;;
    log)
        echo "Performing: log"
        docker logs -f RabbitMQ-Server
    ;;
    *)
        echo "Not Valid Option for: ${0}, use [start], [stop] or [log]"
    ;;
esac

