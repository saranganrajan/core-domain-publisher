FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER apps.saranganrajan.com
COPY target/core-domain-publisher-0.0.1-SNAPSHOT.jar core-domain-publisher.jar
ENTRYPOINT ["java","-jar","/core-domain-publisher.jar"]
ADD ./newrelic/newrelic.jar /opt/newrelic/newrelic.jar
ENV JAVA_OPTS="$JAVA_OPTS -javaagent:/opt/newrelic/newrelic.jar"
ADD ./newrelic/newrelic.yml /opt/newrelic/newrelic.yml
ENV NEW_RELIC_APP_NAME="core-doman-publisher"
ENV JAVA_OPTS="$JAVA_OPTS -Dnewrelic.config.app_name='core-doman-publisher'"
ENV NEW_RELIC_LICENSE_KEY="e3e66fa88740b62d0c89593a0d27b4e1faa9NRAL"
ENV JAVA_OPTS="$JAVA_OPTS -Dnewrelic.config.license_key='e3e66fa88740b62d0c89593a0d27b4e1faa9NRAL'"