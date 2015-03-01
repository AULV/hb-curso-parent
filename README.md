Este proyecto fue construido para impartir el curso de spring mvc y servicios rest para Hábil Mx

http://www.habil.mx


# Actividades realizadas

## Sesión 1

1.- Instalación de STS última versión

2.- Creación de cuenta

3.- Instalación de aplicación de escritorio GitHub

4.- Instalación de MySQL

5.- Creación de workspace

6.- Creación de proyectos

7.- Ajustes a proyectos creados

8.- Creación de repositorio local git

9.- Creación de repositorio remoto GitHub

10.- Primer commit en git

11.- Primer Sync en GitHub

12.- Creación del archivo .gitignore

13.- Exceptuar */target/*

14.- Descarga de los repositorios remotos habil y hb-curso-parent

15.- Puesta a punto de los proyectos en STS descargados de los repositorios maestros

16.- Creación de la base de datos y usuario en MySQL

17.- Ejecución de la prueba unitaria del proyecto hb-curso-parent para validar conectividad a la BBDD


# Configuración de la base de datos

  mysql>CREATE DATABASE hb_bit;

  mysql>CREATE USER ' bitacora'@'localhost' IDENTIFIED BY '12345678';

  mysql>GRANT ALL ON hb_bit.* TO 'bitacora'@'localhost';

  mysql>FLUSH PRIVILEGES;

Con esto podemos correr las pruebas unitarias
