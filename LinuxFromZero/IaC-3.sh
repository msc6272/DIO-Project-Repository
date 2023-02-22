sudo docker volume create data
sudo docker volume create app
sudo cp LinuxFromZero/Microservice/app/index.php  /var/lib/docker/volumes/app/_data/

sudo docker create --name mysql-A -e MYSQL_ROOT_PASSWORD=Senha123 -e MYSQL_DATABASE=meubanco -p 3306:3306 --mount type=volume,src=data,dst=/var/lib/mysql/ mysql:5.7
sudo docker cp LinuxFromZero/Microservice/mysql/banco.sql mysql-A:/docker-entrypoint-initdb.d
sudo docker start mysql-adm

sudo docker run --name web-server -dt -p 80:80 --mount type=volume,src=app,dst=/app/ webdevops/php-apache:7.4-alpine
