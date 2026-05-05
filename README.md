# Paso 1
Ejecutar el comando `mvn clean install` para poder obtener el jar de proyecto

# Paso 2
Ejecutar el comando `docker build -t agenda .` para poder empaquetar el proyecto

# Paso 3
Ejecutar el comando `docker-compose up -d` para inicializar los contenedores



# Servicios expuestos

Estos servicios una  vez ejecutados se consumen mediante alguna herramienta postman, bruno o mediante o git bash por medio `curl -X POST http://localhost:8080/contacto/buscar/id`


* Contacto

   Listar    http://localhost:8080/contacto - `GET`

   crear     http://localhost:8080/contacto - `POST`

   buscar por id http://localhost:8080/contacto/buscar/id - `POST`

   desactivar http://localhost:8080/contacto/id - `POST`


   activar    http://localhost:8080/contacto/activar/id - `POST`

   actualizar http://localhost:8080/contacto/id - `PUT`

   



* catalogo

   Listar http://localhost:8080/catalogo_contactos - `GET`

  crear http://localhost:8080/catalogo_contactos  - `POST`

  Actualizar http://localhost:8080/catalogo_contactos/id - `PUT`

