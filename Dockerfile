FROM tomcat
COPY /target/dac-atividade.war ${CATALINA_HOME}/webapps