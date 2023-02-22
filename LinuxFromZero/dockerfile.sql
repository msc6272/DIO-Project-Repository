FROM mysql:5.7
WORKDIR /var/lib/mysql/
ENV MYSQL_DATABASE=meubanco
ENV MYSQL_ROOT_PASSWORD=Senha123
EXPOSE 3306
VOLUME /var/lib/mysql/
ADD site.sql /docker-entrypoint-initdb.d