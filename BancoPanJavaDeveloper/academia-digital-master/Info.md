# Modelo de REST API de academia

## TODO

1. Usar como modelo para criar uma estrutura de minha autoria (algo diferente)

## Observações importantes

- Para executar o Docker (PostgreSQL)

```sh
docker run -it --rm -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=postgres -d postgres:15.2-alpine3.17
```

- Para para a instância do Docker

```sh
docker stop $(docker ps -a -q)
```
