# Example: Spring MessageSource from JSON


## Build and Run Docker Image

```bash
docker compose up -d
```

After a successful build, open the example in your web browser: http://localhost:8080

## Custom Changes

If you want to make changes for testing, you have to restart the Docker image.

```bash
docker compose restart
```

> [!NOTE]  
> When you restart, the JAR file is rebuilt and the Tomcat is started. This can take a few seconds.
