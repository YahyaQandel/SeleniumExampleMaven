From amitaarya17/docker-maven-chrome
COPY . /app
WORKDIR /app
EXPOSE 9515
CMD mvn -B package --file pom.xml