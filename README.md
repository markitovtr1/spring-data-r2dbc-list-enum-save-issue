# List enum save issue

## Setting up repository

```sh
# Start postgres
docker-compose up -d postgres

# Run liquibase separately, to avoid failing because postgres did not start
docker-compose up liquibase

# Run tests
./gradlew test
```
