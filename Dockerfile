FROM openjdk:8
COPY ./target/person-0.0.1-SNAPSHOT.jar /opt/springboot/person/person.jar
COPY ./application.template /opt/springboot/person/config/application.template
ADD ./consul-template /opt/springboot/person/
ADD ./start.sh /opt/springboot/person/
ADD ./refresh.sh /opt/springboot/person/
WORKDIR /opt/springboot/person
#RUN chmod 0644 /opt/springboot/poc/logrotate.conf
#RUN apt-get update
#RUN apt-get -y install logrotate
RUN chmod +x ./start.sh
RUN chmod +x ./refresh.sh
ENTRYPOINT ["./start.sh"]
