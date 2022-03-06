# docker build -t springboot_docker_base .
# docker run -dp 3031:3031 -t springboot_docker_base

FROM gradle:jdk11

WORKDIR /app
COPY . /app
CMD ["./bootstrap.sh"]