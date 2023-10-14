# Define a imagem base que contém o Maven para construir a aplicação
FROM maven AS build

# Copie o código-fonte para o container
COPY . /usr/src/app

# Defina o diretório de trabalho
WORKDIR /usr/src/app

# Compile o código e crie o arquivo JAR
RUN mvn clean install

# Crie uma imagem menor que só contém o arquivo JAR da aplicação
FROM openjdk

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da imagem de construção para esta imagem menor
COPY --from=build /usr/src/app/target/api.jar /app

# Defina o comando de inicialização da aplicação
CMD ["java", "-jar", "api.jar"]
