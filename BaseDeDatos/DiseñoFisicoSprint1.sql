drop database if exists AmigosPeludos;
create database AmigosPeludos collate utf8mb4_spanish_ci;
use AmigosPeludos;

create table Cuenta(
idCuenta smallint auto_increment primary key,
nomCuenta char(20) unique not null);

create table Persona(
dni char(9) unique primary key not null,
nombre char(50) not null,
apellidos char(50) not null,
telefono char(15) not null,
correo char(100) not null,
idCuenta smallint,
constraint FK_IdCuenta foreign key(idCuenta) references Cuenta(idCuenta));

create table Donacion(
fecha date not null,
codDonacion char(8) unique primary key not null,
tipoDonacion enum("Dinero", "Especie") not null,
cantDonacion integer not null,
mensajeDonacion char(200),
dniDonador char(9),
constraint FK_DniDonador foreign key(dniDonador) references Persona(dni));

create table RecursoEducativo(
codRE char(4) unique primary key not null,
nomRE char(30) not null,
contenidoRE text);

create table Cliente(
dniCliente char(9) primary key,
numMascotas tinyint,
constraint FK_DniCliente foreign key(dniCliente) references Persona(dni));

create table Accede(
dniCliente char(9),
codRE char(4),
constraint FK_DniCliente1 foreign key(dniCliente) references Cliente(dniCliente),
constraint FK_CodRE foreign key(codRE) references RecursoEducativo(codRE),
constraint PK_Accede primary key(dniCliente, codRE));

create table Formulario(
numFormulario tinyint primary key auto_increment,
respuestas text not null);

create table Rellena(
dniCliente char(9),
numFormulario tinyint,
fecha date not null,
constraint FK_DniCliente2 foreign key(dniCliente) references Cliente(dniCliente),
constraint FK_NumFormulario1 foreign key(numFormulario) references Formulario(numFormulario),
constraint PK_Rellena primary key(dniCliente, numFormulario));

create table Actividad(
nomActividad char(30) primary key unique not null,
dispActividad enum("Disponible", "No disponible") not null,
requisitos text);

create table Volunta(
dniCliente char(9),
nomActividad char(30),
constraint FK_DniCliente3 foreign key(dniCliente) references Cliente(dniCliente),
constraint FK_NomActividad1 foreign key(nomActividad) references Actividad(nomActividad),
constraint PK_Volunta primary key(dniCliente, nomActividad));

create table Empleado(
dniEmpleado char(9) primary key,
sueldo smallint not null constraint CH_Sueldo check(sueldo>=1184),
puesto enum("Cuidador/a", "Veterinario/a", "Auxiliar veterinario/a", "Etólogo/a", "Coordinador/a", "Responsable financiero", "Gestor/a de adopciones", "Responsable de comunicación", "Coordinador/a de voluntariado", "Educador/a ambiental", "Personal de limpieza") not null,
horario text not null,
constraint FK_DniEmpleado foreign key(dniEmpleado) references Persona(dni));

create table Supervisa(
dniEmpleado char(9),
nomActividad char(30),
constraint FK_DniEmpleado1 foreign key(dniEmpleado) references Empleado(dniEmpleado),
constraint FK_NomActividad2 foreign key(nomActividad) references Actividad(nomActividad),
constraint PK_Supervisa primary key(dniEmpleado, nomActividad));

create table Revisa(
dniEmpleado char(9),
numFormulario tinyint,
resultado enum("Aceptado", "Rechazado") not null,
constraint FK_DniEmpleado2 foreign key(dniEmpleado) references Empleado(dniEmpleado),
constraint FK_NumFormulario foreign key(numFormulario) references Formulario(numFormulario),
constraint PK_Revisa primary key(dniEmpleado, numFormulario));

create table HistorialMedico(
codHM char(5) primary key unique not null,
datosHM text);

create table Animal(
idAnimal char(5) primary key unique not null,
nomAnimal char(20) not null,
edadAnimal tinyint unsigned not null,
razaAnimal enum("Perro", "Gato", "Hurón") not null,
caractAnimal text,
necEspAnimal text,
dispAnimal enum("Disponible", "No disponible") not null,
pesoAnimal float unsigned not null,
codHM char(5),
constraint FK_CodHM foreign key(codHM) references HistorialMedico(codHM));

create table Cuida(
dniEmpleado char(9),
idAnimal char(5),
constraint FK_DniEmpleado3 foreign key(dniEmpleado) references Empleado(dniEmpleado),
constraint FK_IdAnimal1 foreign key(idAnimal) references Animal(idAnimal),
constraint PK_Cuida primary key(dniEmpleado, idAnimal));

create table Proveedor(
nomProveedor char(30) primary key unique not null);

create table Comida(
nomComida char(20) primary key unique not null,
calorias smallint unsigned not null,
contenidos text not null,
stock smallint unsigned not null,
proveedor char(30),
constraint FK_Proveedor foreign key(proveedor) references Proveedor(nomProveedor));

create table Come(
idAnimal char(5),
nomComida char(20),
constraint FK_IdAnimal2 foreign key(idAnimal) references Animal(idAnimal),
constraint FK_NomComida foreign key(nomComida) references Comida(nomComida),
constraint PK_Come primary key(idAnimal, nomComida));

USE AmigosPeludos;

-- Insertar registros en la tabla Cuenta
INSERT INTO Cuenta (nomCuenta) 
VALUES 
('Cuenta A'),  -- idCuenta = 1
('Cuenta B'),  -- idCuenta = 2
('Cuenta C'),  -- idCuenta = 3
('Cuenta D'),  -- idCuenta = 4
('Cuenta E'),  -- idCuenta = 5
('Cuenta F');  -- idCuenta = 6


-- Paso 2: Insertar personas en la tabla Persona con los nombres dados
INSERT INTO Persona (dni, nombre, apellidos, telefono, correo, idCuenta) 
VALUES 
('123456789', 'Jon', 'Sánchez', '612345678', 'jon.sanchez@email.com', 1),
('987654321', 'Maria', 'Ceron', '623456789', 'maria.jose@email.com', 2),
('456789123', 'June', 'Ras', '634567890', 'june.ras@email.com', 3),
('321654987', 'Lierni', 'González', '645678901', 'lierni.gonzalez@email.com', 4),
('654321789', 'Maitane', 'Martínez', '656789012', 'maitane.martinez@email.com', 5),
('567890123', 'Alberto', 'Sánchez', '667890123', 'alberto.sanchez@email.com', 4),
('654321987', 'Lucía', 'García', '678901234', 'lucia.garcia@email.com', 5),
('234567890', 'Carlos', 'Ramírez', '690123456', 'carlos.ramirez@email.com', 6),
('345678901', 'Raquel', 'Mendoza', '601234567', 'raquel.mendoza@email.com', 4);

-- Paso 3: Insertar más donaciones en la tabla Donacion
INSERT INTO Donacion (fecha, codDonacion, tipoDonacion, cantDonacion, mensajeDonacion, dniDonador) 
VALUES  
('2023-11-20', 'DON98765', 'Dinero', 800, 'Donación para el tratamiento de animales heridos', '123456789'),
('2023-11-22', 'DON87654', 'Especie', 15, 'Donación de juguetes para los animales', '987654321'),
('2023-12-01', 'DON76543', 'Dinero', 1200, 'Donación para los nuevos proyectos de adopción', '456789123'),
('2023-12-05', 'DON65432', 'Especie', 25, 'Donación de mantas para los perros del refugio', '321654987'),
('2023-12-10', 'DON54321', 'Dinero', 1500, 'Donación para la construcción de un nuevo parque para animales', '654321789'),
('2023-12-12', 'DON43210', 'Especie', 5, 'Donación de sillas y camas para animales pequeños', '567890123'),
('2023-12-20', 'DON32109', 'Dinero', 2000, 'Donación para las actividades de rehabilitación de animales', '654321987'),
('2023-12-25', 'DON21098', 'Especie', 40, 'Donación de cobijas y almohadas para el refugio', '123456789');

-- Insertar registros en la tabla Actividad
INSERT INTO Actividad (nomActividad, dispActividad, requisitos) 
VALUES 
('Cuidado de Roedores', 'Disponible', 'Experiencia en el manejo de roedores'),
('Voluntariado Ambiental', 'Disponible', 'Interés en la conservación del medio ambiente'),
('Paseo de Perros', 'Disponible', 'Capacidad para pasear perros grandes y pequeños'),
('Cuidado de Aves', 'Disponible', 'Interés en el cuidado de aves y su bienestar');


-- Insertar registros en la tabla Cliente
INSERT INTO Cliente (dniCliente, numMascotas) 
VALUES 
('123456789', 1),
('987654321', 2),
('567890123', 4),
('654321987', 5);

-- Insertar registros en la tabla Volunta
INSERT INTO Volunta (dniCliente, nomActividad) 
VALUES 
('123456789', 'Cuidado de Roedores'),
('987654321', 'Voluntariado Ambiental'),
('567890123', 'Paseo de Perros'),
('654321987', 'Cuidado de Aves');



-- Paso 6: Insertar más empleados en la tabla Empleado
INSERT INTO Empleado (dniEmpleado, sueldo, puesto, horario) 
VALUES 
('123456789', 1500, 'Cuidador/a', 'Lunes a Viernes, 9am - 5pm'),  -- Jon Sánchez
('987654321', 2500, 'Veterinario/a', 'Lunes a Viernes, 8am - 4pm'),  -- Maria Ceron
('456789123', 2000, 'Cuidador/a', 'Lunes a Viernes, 8am - 4pm'),  -- June Ras
('321654987', 3000, 'Veterinario/a', 'Lunes a Viernes, 10am - 6pm'),  -- Lierni González
('654321789', 2200, 'Cuidador/a', 'Lunes a Viernes, 7am - 3pm');  -- Maitane Martínez
-- Paso 7: Insertar más datos en la tabla HistorialMedico
INSERT INTO HistorialMedico (codHM, datosHM) 
VALUES 
('HM07', 'Vacunas al día, sin alergias o enfermedades graves'),
('HM08', 'Tratamiento para infecciones respiratorias'),
('HM09', 'Tratamiento para diabetes, controlado'),
('HM10', 'Check-up regular, sin enfermedades graves');

-- Paso 8: Insertar más animales en la tabla Animal
INSERT INTO Animal (idAnimal, nomAnimal, edadAnimal, razaAnimal, caractAnimal, necEspAnimal, dispAnimal, pesoAnimal, codHM) 
VALUES 
('A007', 'Simba', 3, 'Perro', 'Activo, juguetón', 'Ninguna', 'Disponible', 12.0, 'HM07'),
('A008', 'Nina', 2, 'Gato', 'Tímida, cariñosa', 'Ninguna', 'Disponible', 4.0, 'HM08'),
('A009', 'Benny', 1, 'Hurón', 'Juguetón, curioso', 'Ninguna', 'Disponible', 1.2, 'HM09'),
('A010', 'Milo', 5, 'Perro', 'Amigable, tranquilo', 'Ninguna', 'Disponible', 10.0, 'HM10');

-- Paso 9: Insertar más registros en la tabla Cuida
INSERT INTO Cuida (dniEmpleado, idAnimal) 
VALUES 
('456789123', 'A007'),
('654321789', 'A008'),
('123456789', 'A009');

-- Paso 10: Insertar más proveedores en la tabla Proveedor
INSERT INTO Proveedor (nomProveedor) 
VALUES 
('Proveedor G'),
('Proveedor H');

-- Paso 11: Insertar más alimentos para animales en la tabla Comida
INSERT INTO Comida (nomComida, calorias, contenidos, stock, proveedor) 
VALUES 
('Snacks para Perros', 150, 'Snacks para perros, sabor pollo', 50, 'Proveedor G'),
('Comida para Gatos', 220, 'Comida seca para gatos, sabor atún', 30, 'Proveedor H');

-- Paso 12: Insertar más registros en la tabla Come
INSERT INTO Come (idAnimal, nomComida) 
VALUES 
('A007', 'Snacks para Perros'),
('A008', 'Comida para Gatos');