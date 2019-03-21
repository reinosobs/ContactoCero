## ContactoCero
Es una aplicación web orientada al control de rutinas de gimnasio, así como al asesoramiento de las distintas formas de entrenamiento  

### 1. Parte publica
Login, registro y algunos ejemplos de las distintas rutinas básicas con las que trabajamos para usuarios no registrados en la web y nuestras redes sociales.

### 2. Parte privada
Tras acceder cada usuario con sus credenciales propias puede ver sus diferentes rutinas, los progresos conseguidos hasta el momento y un planificador de entrenamientos.

### 3. Entidades principales
   - **Usuario**: Integrante registrado en nuestra aplicación.

   - **Rutina**: Conjunto de ejercicios que se recomienda a cada usuario dependiendo de sus objetivos.

   - **Ejercicio**: Tarea individual específica de cada grupo muscular que complementa a una o más rutinas.
   
   - **Dietas**: Distintos tipos de dietas acordes a lo que desea el usuario.

### 4. Funcionalidades
   - Envio de correo de bienvenida al correo del usuario nuevo registrado.
### 5. Integrantes
   * Sergio Reinoso Barrios / s.reinosob@alumnos.urjc.es / https://github.com/reinosobs

   * David Palacios Moreno / d.palaciosm@alumnos.urjc.es / https://github.com/d-palaciosm

   * Luis Santos Moreno / l.santosmor@alumnos.urjc.es / https://github.com/LuisitoSantos

### Apartados de la web


![login](https://user-images.githubusercontent.com/45769039/53116616-5ebf7080-3549-11e9-9fab-161a98a9f7c3.PNG)

Página para hacer login y entrar en la web del gimnasio.

![registro](https://user-images.githubusercontent.com/45769039/53116808-d392aa80-3549-11e9-8c80-a4397ace3230.png)

Página para registrarse en el caso de no poseer una cuenta.

![perfil2](https://user-images.githubusercontent.com/45769039/53530761-37404900-3af1-11e9-9e85-a6c8e74f9952.PNG)

En el apartado de perfin, podremos acceder a los datos básicos de nuestra cuenta, asi como a las rutinas guardadas y a las estadísticas de nuestro progreso. También podremos crear ejercicios, rutinas y dietas.

![ejercicios2](https://user-images.githubusercontent.com/45769039/53530781-47f0bf00-3af1-11e9-81da-a131728e287d.PNG)

En el apartado de ejercicios, podemos acceder a los diferentes tipos de ejercicios, agrupados en: tren superior, tren inferior y cardio, así como asignar ejercicios a rutinas existentes.

![rutinas2](https://user-images.githubusercontent.com/45769039/53530793-52ab5400-3af1-11e9-84ad-cdb83628238c.PNG)

En el apartados de rutinas, podemos acceder a los diferentes tipos de rutinas, agrupadas en: volumen, definición y pérdida de peso. Se nos da la posibilidad de guardar las rutinas que queramos en nuestro perfil.

![dietas2](https://user-images.githubusercontent.com/45769039/53530814-60f97000-3af1-11e9-8351-87a34dc52ea2.PNG)

En el apartado de dietas, podemos acceder a las diferentes dietas que nos ofrece la web, agrupadas en: hipercalórica, hipercalórica y mantenimiento. Se nos ofrece la posibilidad de descargarnos las dietas que deseemos.

![contacto2](https://user-images.githubusercontent.com/45769039/53530833-72427c80-3af1-11e9-8ad6-b6d48ff68fc7.PNG)

En el apartado de contacto, vemos referencias a las diferentes redes sociales relacionadas con el gimnasio. También se pueden ver las publicaciones que hacen los usuarios en las redes sociales con el hashtag de la web.


### Diagramas

![navegacion fase2](https://user-images.githubusercontent.com/45769039/53118456-6d0f8b80-354d-11e9-85ad-8b3dda7d6f0e.jpeg)

Diagrama de navegación

![e-r fase2](https://user-images.githubusercontent.com/45769039/53118308-199d3d80-354d-11e9-9b59-a6771a59d262.JPG)

Diagrama E/R

![uml](https://user-images.githubusercontent.com/46925882/54608499-1ebcb200-4a51-11e9-94f5-74f09e93ca60.JPG)

Diagrama UML

### Instrucciones para levantar la aplicación en VM

   - Descargar Vagrant
   
   - Ejecutar los comandos *vagrant up*, para preparar la máquina, y luego *vagrant ssh*, para iniciarla
   
   - Descargar la última versión de java mediante los comandos:
   
         sudo apt-get update
         sudo apt-get install -y openjdk-8-jre
      
   - Instalar mySQL y crear la base de datos usando:
   
         sudo apt-get install mysql-server
         mysql -h localhost -u root -p
         (deberemos introducir la contraseña de teníamos en el *apliccation-properties*)
      
         mysql> CREATE DATABASE usbbdd;
         mysql> USE mysql;
         mysql> SELECT User, Host, plugin FROM mysql.user;
         mysql> UPDATE user SET plugin='mysql_native_password' WHERE User='root';
         mysql> FLUSH PRIVILEGES;
         mysql> Exit
      
   - Generar el jar de la aplicación web y del servicio interno
   
   - Ejecutar: 
   
          java -jar contacto-cero-web-0.0.1-SNAPSHOT.jar & java -jar servicio-interno2-0.0.1-SNAPSHOPT.jar
   
   - Aplicación web iniciada
