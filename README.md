# Doublevpartners Prueba - Ticket
Este proyecto es una API desarrollada en Spring Boot como parte de una prueba técnica. Permite realizar ciertas operaciones relacionadas con tickets y usuarios. El proyecto utiliza una base de datos MySQL para almacenar los datos.

# Requisitos
Para ejecutar este proyecto en un entorno local, necesitarás tener instalado lo siguiente:

Java 17 (JDK) o superior.
Docker (para ejecutar la base de datos MySQL como un contenedor).
# Configuración de la Base de Datos
Antes de ejecutar la aplicación, asegúrate de que Docker esté instalado y en funcionamiento en tu sistema. A continuación, puedes utilizar el siguiente comando para crear y ejecutar un contenedor Docker con una instancia de MySQL:

• docker run -d -p 3306:3306 --name mysql-server -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=ticket_system mysql:latest
Esto creará y ejecutará un contenedor Docker con una base de datos MySQL. La base de datos se llamará "ticket_system" y tendrás acceso con el usuario "root" y la contraseña "admin".
# Endpoints API
A continuación, se detallan algunos de los endpoints disponibles en la API:

GET /api/tickets: Obtiene una lista de todos los tickets.
•	Obtener todos: http://localhost:8080/api/tickets?page=0&size=10
![image](https://github.com/DanielSaenzt/doublevpartnersPruebaTicket/assets/60766477/3d63f47f-c8df-4200-8d0e-b8365a6af877)
•	Obtener todos filtrado: http://localhost:8080/api/tickets/filterById?page=0&size=10
![image](https://github.com/DanielSaenzt/doublevpartnersPruebaTicket/assets/60766477/f557e69a-def2-45b1-919a-de7d4b1d8a17)
•	Obtener filtrado: http://localhost:8080/api/tickets/filterById?id=12&page=0&size=10
![image](https://github.com/DanielSaenzt/doublevpartnersPruebaTicket/assets/60766477/a124ef57-4f9d-4f3b-9511-4ef3ce0d6c69)

GET /api/tickets/{id}: Obtiene un ticket por su ID.
•	Obtener por el id: http://localhost:8080/api/tickets/12
![image](https://github.com/DanielSaenzt/doublevpartnersPruebaTicket/assets/60766477/75f00154-6695-4893-91a3-8e8306425968)

POST /api/tickets/: Crea un nuevo ticket.
•	Crear un ticket: http://localhost:8080/api/tickets/
![image](https://github.com/DanielSaenzt/doublevpartnersPruebaTicket/assets/60766477/b6578d51-cce5-4102-a164-bed4f1098038)

PUT /api/tickets/{id}: Actualiza un ticket existente.
•	Editar Ticket: http://localhost:8080/api/tickets/4
![image](https://github.com/DanielSaenzt/doublevpartnersPruebaTicket/assets/60766477/309d7bb6-d2b0-495d-b236-3d9878e9bb27)

DELETE /api/tickets/{id}: Elimina un ticket por su ID.
•	Eliminar Ticket : http://localhost:8080/api/tickets/4
![image](https://github.com/DanielSaenzt/doublevpartnersPruebaTicket/assets/60766477/d588b8b4-7989-4d62-9c20-e765a0b5d926)
