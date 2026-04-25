# Build stage
FROM maven:3.9.0-eclipse-temurin-17 AS builder

WORKDIR /build
COPY CadastroUsuarios/pom.xml .
RUN mvn dependency:go-offline

COPY CadastroUsuarios/ .
RUN mvn clean package -DskipTests

# Runtime stage
FROM jboss/wildfly:26.1.3.Final

# Copiar o WAR gerado para o diretório de deploy do WildFly
COPY --from=builder /build/target/CadastroUsuarios.war /opt/jboss/wildfly/standalone/deployments/

# Expor porta 8080
EXPOSE 8080

# WildFly já tem seu próprio script de inicialização
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]