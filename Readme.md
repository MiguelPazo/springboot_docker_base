# SpringBoot Docker Base

## Requirements

For building and running the application you need:

- [Open JDK 11](https://www.openlogic.com/openjdk-downloads)
- [Open JDK 11 (Windows)](https://docs.microsoft.com/es-es/java/openjdk/download)
- [Graddle 7.4](https://gradle.org/install)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method
in the `com.miguelpazo.auth.Main` class from your IDE.

```shell
gradle clean build
```

## Deploying the application to Docker

The easiest way to deploy the sample application to OpenShift is to use
the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
docker build -t springboot_docker_base .
docker run -dp 3031:3031 -t springboot_docker_base
```

After run docker commands you can access to endpoints:

```shell
curls -XGET http://localhost:3031
```

## Copyright

Released under the Apache License 2.0. See
the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.