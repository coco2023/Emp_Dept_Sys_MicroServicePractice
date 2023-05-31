# FROM ubuntu
# RUN apt-get update && apt-get -y install python3-pip
# RUN pip install flask flask-mysql 
# COPY . /opt/source-code
# ENTRYPOINT FLASK_APP=/opt/source-code/app.py flask


FROM centos:7
RUN yum -y update
RUN yum -y install httpd
COPY index.html /var/www/html/
EXPOSE 80
CMD [ "httpd", "-D", "FOREGROUND" ]