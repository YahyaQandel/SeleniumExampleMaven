From markhobson/maven-chrome
COPY . /app
WORKDIR /app
CMD mvn -B package --file pom.xml