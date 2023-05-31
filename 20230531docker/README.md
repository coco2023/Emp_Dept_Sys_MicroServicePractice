# basic & import
    $ docker login -u "myusername" -p "mypassword" docker.io
    docker build -t koko2023/web-app .
    docker container run -d --name my-web-app -p 90:80 koko2023/web-app
    docker tag koko2023/web-app:latest hahaha12353/my-web-app 
    docker push hahaha12353/my-web-ap

# 1. py docker
docker build -t keyu/web-app .

docker container -d --name keyu -p 90:80 keyu/py-app

docker container run -d --name keyu -p 80:80 keyu/py-app

    FROM ubuntu
    RUN apt-get update && apt-get -y install python3-pip
    RUN pip install flask flask-mysql 
    COPY . /opt/source-code
    ENTRYPOINT FLASK_APP=/opt/source-code/app.py flask


# 2. html docker

docker ps -a

docker container stop $(docker container ls -aq)

docker container prune

docker image ls

docker image prune -a

docker build -t keyu/web-app .

docker container -d --name keyu -p 90:80 keyu/web-app

docker container run -d --name keyu -p 90:80 keyu/web-app

---
docker tag koko2023/web-app:latest hahaha12353/my-web-app

docker login

docker push hahaha12353/my-web-app

    <Dockerfile>
    FROM centos:7
    RUN yum -y update
    RUN yum -y install httpd
    COPY index.html /var/www/html/
    EXPOSE 80
    CMD [ "httpd", "-D", "FOREGROUND" ]


# 3. Spring Boot
create spring-boot project -> load -> mvn + docker -> test
mvn spring-boot:build-image

docker image ls

docker container run -d --name my-spring -p 9001:9001 sample-spring-app:0.0.1-SNAPSHOT