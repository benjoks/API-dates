# API Bitrth Date

Servicio valida la fecha de nacimiento de una persona con el rut ingresado en relacion a la base de datos. 
Esta puede ser replicada de una datalake.

### pre-requisitos

antes de comenzar es necesaria la instalacion de maven y java

```
sudo apt-get install maven
sudo apt-get install openjdk-11-jdk
```

### Instalacion

Para iniciar clone el proyecto

```
https://github.com/benjoks/API-dates
```

### Creacion del artefacto

comando creacion del artefacto

```
mvn clean , compile , install
```

## Paths

```
http://localhost:8080/personas/{rut}/nacimiento/{fecha}
```

## DockerFile

```
docker build -t mysql_demo .
docker run -p 33060:3306 -d mysql_demo
```

## Mas informacion





