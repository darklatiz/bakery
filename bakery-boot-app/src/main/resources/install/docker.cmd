1. We create a Volume for the docker contatiner
sudo docker create -v /var/lib/postgresql/data --name PostgresData alpine

2. We pull a postgresql container using the volume created in step 1
sudo docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=admin -d --volumes-from PostgresData postgres

3. Start the docker container
sudo docker start postgres

