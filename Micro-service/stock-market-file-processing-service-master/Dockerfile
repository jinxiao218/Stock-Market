FROM daocloud.io/java:latest
MAINTAINER jjxx<jjxx@163.com>
VOLUME /tmp
RUN echo "Asia/Shanghai">/etc/timezone && dpkg-reconfigure -f noninteractive tzdata
ADD stock-market-config-server 0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch/app.jar'
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]