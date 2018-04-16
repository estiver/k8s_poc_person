sudo docker run --name database-service -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_USER=poc -e MYSQL_PASSWORD=poc123 -e MYSQL_DATABASE=poc -p 3306:3306 -d mysql:5.7

sudo docker build -t ehipolito/k8s-person .
sudo docker push ehipolito/k8s-person
