CREATE TABLE accounts (
  id_account varchar(20) NOT NULL,
  id_client varchar(20) NOT NULL,
  money double(10) NOT NULL,
  PRIMARY KEY (`id_account`)
);

insert into accounts (id_account,id_client,money) values 
	('A1','BANK',15680340.00),('A101','ONG',24520.50),
	('A201','Laura Soler',2367.20),('A257','Enrique Martinez',520.00),
	('A510','Ayuntamiento1',-14520.50);

-- Laura transfiere 300 euros a ONG.
-- Para que se pueda hacer la transacción de forma segura, A.C.I.D.; hay que 
-- encapuslar estas 4 operaciones. Aún no sé como hacerlo sin usar un 
-- procedimiento almacenado; así que lo he hecho en JDBC.

-- P1 Comprobar si existe nuestra cuenta y hay saldo en nuestra cuenta.
select money from accounts where id_account="A201" and money > 300.00;
-- P2 Comprobar los datos de la cuenta del receptor (que existe y puede recibir dinero, etc...).
select * from accounts where id_account="A101";
-- P3 Retirar el dinero de nuestra cuenta
update accounts set money=money-300.0 where id_account="A201";
-- P4 Ingresar el dinero en la cuenta del receptor.
update accounts set money=money+300.0 where id_account="A101";
