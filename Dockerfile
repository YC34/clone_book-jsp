
# base가 될 이미지 리눅스 운영체제 위에 설치해보려고한다.
# 현재 LTS(Long Term Support) version
FROM ubuntu:22.04

# setting ubuntu config
WORKDIR /home
RUN mkdir /soft
RUN mkdir /workspace
RUN apt-get update
RUN apt-get install -y net-tools wget vim lsof openssh-server

# OpenJDK 17 설치
RUN mkdir -p /usr/lib/jvm && \
    wget -qO- https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.11%2B9/OpenJDK17U-jdk_x64_linux_hotspot_17.0.11_9.tar.gz | tar xvz -C /usr/lib/jvm && \
    ln -s /usr/lib/jvm/jdk-17.0.11+9 /usr/lib/jvm/default-jdk

# JDK 설정
ENV JAVA_HOME /usr/lib/jvm/default-jdk
ENV PATH $PATH:$JAVA_HOME/bin

# Tomcat copy
COPY opt/apache-tomcat-11.0.0-M21 /soft/tomcat

# Tomcat 설정 (UTF-8 인코딩 설정 등) 
RUN sed -i 's/Connector port="8080"/Connector port="8080" URIEncoding="UTF-8"/g' /soft/tomcat/conf/server.xml 

# 포트 노출 
EXPOSE 8080 22


# SSH 서비스 실행 및 Tomcat 실행
CMD service ssh start && /soft/tomcat/bin/catalina.sh run


