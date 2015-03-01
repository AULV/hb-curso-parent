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

Con esto podemos ejecutar las pruebas unitarias de la sesión 1

#Configuración de la base de datos embebida

Para trabajar sin necesidad de instalar un manejador de base de datos se ha decidido
utilizar la base de datos embebida H2, para ocuparla debemos tener creada la carpeta
"**/opt/db/h2**" y ejecutar los siguientes pasos

##Paso 1.- Agregar versión y dependencias

Debemos agregar al pom.xml del parent la versión del H2 a utilizar

    <h2.version>1.4.185</h2.version>

Debemos agregar la dependencia al pom.xml del model

    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <version>${h2.version}</version>
    </dependency>

Debemos configurar el data source en el archivo model.application.context.xml para crear/usar la base de datos embebida

    <bean id="BitacoraDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
      <property name="driverClassName" value="org.h2.Driver" />
      <property name="url" value="jdbc:h2:/opt/db/h2/hb_bit;MODE=Oracle;TRACE_LEVEL_SYSTEM_OUT=2" />
      <property name="username" value="sa" />
      <property name="password" value="" />
    </bean>

Ver que estamos ocupando H2 en modo Oracle, con el objetivo de no tener problemas al momento de ocupar el manejador.
