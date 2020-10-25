# Bakery

## Once you have installed DOCKER

1. We create a Volume for the docker container
sudo docker create -v /var/lib/postgresql/data --name PostgresData alpine

2. We pull a postgresql container using the volume created in step 1
sudo docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=admin -d --volumes-from PostgresData postgres

3. Start the docker container
sudo docker start postgres


## Test Containers might not run
### Dirty bad workaround to make test containers run

```
sudo chmod 666 /var/run/docker.sock
```

[Workaround explanation](https://github.com/testcontainers/testcontainers-java/issues/613)

