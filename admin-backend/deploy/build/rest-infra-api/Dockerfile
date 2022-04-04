FROM azul/zulu-openjdk-debian:11.0.12-11.50.19-x86
ADD app.jar /runner/app.jar
WORKDIR /runner
#对于spring boot项目 强制设定端口为8080
ENTRYPOINT ["sh","-c","java -jar -Dserver.port=8080 /runner/app.jar "]