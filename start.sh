#!/bin/bash
java -Xmx64m -jar person.jar &
/opt/springboot/person/consul-template \
    -consul-addr http://k8s-poc-consul-service \
    -vault-renew-token=false \
    -vault-addr http://k8s-poc-vault-service:8200 \
    -template "/opt/springboot/person/config/application.template:/opt/springboot/person/config/application.properties:./refresh.sh"

