### Proyecto para ejecutar transacciones en Java, con JDBC.

#### Enunciado del problema que queremos resolver.

Queremos implantar una base de datos para transferir dinero entre cuentas; de una cuenta origen a una destino.
Hay que conseguir que la transacción se realice correctamente aunque haya fallos de conexión durante el proceso.
La transacción la podemos dividir en estas 4 operaciones:
* P1 Comprobar si existe nuestra cuenta y hay saldo en nuestra cuenta.
* P2 Comprobar los datos de la cuenta del receptor (que existe y puede recibir dinero, etc...).
* P3 Retirar el dinero de nuestra cuenta
* P4 Ingresar el dinero en la cuenta del receptor.

En este ejemplo el modelado va a ser simple; sólo usaremos una tabla Account, con 3 campos: id de la cuenta, id del cliente y dinero disponible.
He decidido envolver las 4 operaciones en una única transacción. 

Para entender mejor el uso de transacciones:

http://www.campusmvp.es/recursos/post/Fundamentos-de-SQL-Transacciones.aspx
http://luismido.wikidot.com/transacciones

#### Funcionalidades que ejecuta este código.
* Conectar-nos a una base de datos relacional con un driver, en este caso a un servidor local MySQL.
Se trata de un jar; en mi caso: mysql-connector-java-5.1.13-bin.jar
* Realizar las operaciones más comunes en una tabla de base de datos, operaciones CRU (Create,Read,Update); que todas son muy fáciles, y voy a usar la clase PreparedStatement, que tiene estas ventajas sobre la clase Statement: facilita el mapeo de datos y evita ataques de inyección SQL y errores con comillas simples y dobles en campos.
* Inserción masiva de datos en una tabla de forma segura y eficiente.
* Y por supuesto, el código necesario para implementar la transacción.
 
#### Requisitos y entorno usados:
* IDE Eclipse Kepler.
* Oracle JDK 7.
* Servidor MySQL 5.6 en localhost
* Un cliente SQL; en mi caso [Heidisql](http://www.heidisql.com/download.php)
* El jar con el driver; que comenté anteriormente. 
* Un [script de SQL, DDL](https://github.com/mamorosdev/ejemplos-java/blob/master/ProyectoTransaccionesJDBC/accounts_ddl.sql); para crear la base de datos.

Para aprender como gestionar bases de datos y transacciones en Java, con JDBC.

* http://www.chuidiang.com/java/mysql/PreparedStatement-java-mysql.php
* http://picarcodigo.blogspot.com.es/2013/05/jdbc-conexion-bases-de-datos-mysql.html
* http://blog.rolandopalermo.com/2012/10/transactions-jdbc.html

Si estás familiarizado en programación Java seguramente ya sabrás que hay formas más adequadas desarrollar para proyectos más grandes.
A grandes rasgos, se pueden clasificar de la siguiente forma:

<--- + Mantenible ---------------------------------- + Eficiente -->

Hibernate       MyBatis       Spring JDBC       JDBC        SQL

Sin embargo, en muchos casos, el rendimiento de Hibernate es más que aceptable, y al ser el framework más fácil de mantener (cuando se le coge el truco se ahorra muchisimo código innecesario para transformar los registros de tablas SQL en objetos de clases Java y viceversa.
