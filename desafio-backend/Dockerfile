FROM jboss/wildfly

ENV JBOSS_HOME /opt/jboss/wildfly

RUN ${JBOSS_HOME}/bin/add-user.sh admin Admin#70365 --silent

ADD ./target/backend.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
