# Implementation details

## Observações importantes

1) MySQLi não é mais usado, de acordo com o instrutor. No lugar dele usa-se o PDO_MySQL
2) Tudo está sendo colocado num único container (docker). O ideal, de acordo com o instrutor, seria ter um container para o Front-End (html, css, js), um para o Back-End (php) e outro para o banco de dados (MySQL).

## Passo a passo

1. Criar uma imagem Docker com o comando 'docker build'
2. Exportar a imagem criada para o DockerHub com o comando 'docker push'
3. Fazer o download das imagens necessárias do DockerHub para a VM hospedada em algum provedor (AWS, GC Platform, Oracle Cloud, etc)
4. Rodar as imagens necessárias com o comando 'docker run'

## Exemplos de comandos Docker

docker login -u $REGISTRY_USER -p $REGISTRY_PASS
docker build -t mscruz/app:1.0 app/
docker push mscruz/app:1.0
docker build -t mscruz/mysql:1.0 mysql/
docker push mscruz/mysql:1.0
sudo docker run -dti -p 3306:3306 --name mysql mscruz/mysql:1.0
sudo docker run -dti --name app-js -p 80:80 mscruz/app:1.0

docker volume create app
docker volume create data
docker run -e MYSQL_ROOT_PASSWORD=Senha123 -e MYSQL_DATABASE=meubanco --name mysql-A -d -p 3306:3306 --mount type=volume,src=data,dst=/var/lib/mysql/ mysql:5.7
docker run --name web-server -dt -p 80:80 --mount type=volume,src=app,dst=/app/ webdevops/php-apache:alpine-php7

## Links interessantes

[MySQL Docker](https://hub.docker.com/_/mysql)
[Docker Volumes](https://docs.docker.com/storage/volumes/#adding-a-data-volume)
[MySQL Preferred Auth Plugin](https://dev.mysql.com/doc/refman/8.0/en/upgrading-from-previous-series.html#upgrade-caching-sha2-password)
[Sample Project](https://github.com/denilsonbonatti/toshiro-shibakita)
[Understanding Docker Volumes](https://earthly.dev/blog/docker-volumes/)

## Outras informações importantes

Quando criamos um docker volume, eles são armazenados em /var/lib/docker/volumes. Por exemplo, após criar o volume 'data', podemos ver o conteúdo desse diretório com o comando 'ls -sla /var/lib/docker/volumes/data/_data'.
Na demonstração, ele criou um arquivo index.php direto em um dos volumes: /var/lib/docker/volumes/app/_data/index.php.
