
DROP table IF EXISTS Empleado;

create table Empleado(
	id int auto_increment PRIMARY KEY,
	nombre varchar(250),
	trabajo enum ('Programador','Secretaria','Psicologo'),
	salario float DEFAULT 1500
);

insert into Empleado (nombre, trabajo,salario)values('Estefania','Programador','1500.0');
insert into Empleado (nombre, trabajo,salario)values('Lourdes','Secretaria','1600.0');
insert into Empleado (nombre, trabajo,salario)values('Marc','Programador','1800.0');
insert into Empleado (nombre, trabajo,salario)values('Mathias','Psicologo','1900.0');
