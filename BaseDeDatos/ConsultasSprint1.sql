use AmigosPeludos;
#Consultas Basicas
#1.Animales que estan disponibles
-- Objetivo: Nos permite conocer que animales estan disponibles para adopcion
-- Tablas implicadas: Animal
-- Condiciones: disAnimal = 'Disponible'
Select *
From Animal 
Where dispAnimal = 'Disponible'
order by nomAnimal;

#2.Lista de los clientes con su información 
-- Objetivo: Obtener información completa de los clientes
-- Tablas implicadas: Cliente, persona
-- Condiciones: Join entre cliente y persona por dni
SELECT p.dni, p.nombre, p.apellidos, p.telefono, p.correo, c.numMascotas
FROM Cliente c
JOIN Persona p ON c.dniCliente = p.dni;

#3.Comida que tenemos en stock
-- Objetivo: Lista de los alimentos que tenemos disponible en nuestro inventario
-- Tablas implicadas: Comida
-- Condiciones: stock >0, solo se muestran los alimentos que tenemos disponibles
SELECT nomComida, calorias, contenidos, proveedor
FROM Comida
WHERE stock >0
ORDER BY nomComida;

#4.Empleados que cuidan animales 
-- Objetivo: Identificar que empleados se encargan del cuidado de los animales
-- Tablas implicadas: Empleado, persona, cuida
-- Condiciones: Join de cuida con empleado  y persona 
SELECT p.dni, p.nombre, p.apellidos, e.puesto
FROM Empleado e
JOIN Persona p ON e.dniEmpleado = p.dni
JOIN Cuida c ON e.dniEmpleado = c.dniEmpleado;

#5.Historial médico de los animales
-- Objetivo: Consultar datos médicos de los animales 
-- Tablas implicadas: Animal, HistorialMedico
-- Condiciones: Join por codHM
SELECT a.idAnimal, a.nomAnimal, h.codHM, h.datosHM
FROM Animal a
JOIN HistorialMedico h ON a.codHM = h.codHM;

#6. Empleado que cuida a cada animal
-- Objetivo: Muestra qué empleado está asignado al cuidado de cada animal
-- Tablas implicadas: empleado, persona, cuida, animal
-- Condiciones: Join entre cuida, animal, empleado y persona 
SELECT a.idAnimal, a.nomAnimal, e.dniEmpleado, p.nombre, p.apellidos
FROM Cuida c
JOIN Animal a ON c.idAnimal = a.idAnimal
JOIN Empleado e ON c.dniEmpleado = e.dniEmpleado
JOIN Persona p ON e.dniEmpleado = p.dni;

#7.Datos de los voluntarios y sus actividades
-- Objetivo: Nos permite ver a los voluntarios y las actividades en las que participan.
-- Tablas implicadas: Voluntarios, cliente, persona, actividad
-- Condiciones: Join entre volunta, clinte, persona y actividad
SELECT p.dni, p.nombre, p.apellidos, a.nomActividad
FROM Volunta v
JOIN Cliente c ON v.dniCliente = c.dniCliente
JOIN Persona p ON c.dniCliente = p.dni
JOIN Actividad a ON v.nomActividad = a.nomActividad;

#8.Proveedores de comida
-- Objetivo: Permite conocer los proveedores y los alimentos que nos suministran.
-- Tablas implicadas: Proveedor, comida
-- Condiciones: Left Join para mostrar todos los proveedores
SELECT pr.nomProveedor, c.nomComida, c.calorias, c.contenidos, c.stock
FROM Proveedor pr
LEFT JOIN Comida c ON pr.nomProveedor = c.proveedor
ORDER BY pr.nomProveedor, c.nomComida;

#9.Horario de empleados
-- Objetivo: Muestra el horario y puesto de cada empleado.
-- Tablas implicadas: Empleado, persona
-- Condiciones: Join por dni
SELECT p.dni, p.nombre, p.apellidos, e.horario, e.puesto
FROM Empleado e
JOIN Persona p ON e.dniEmpleado = p.dni;

#10.Clientes que han realizado donaciones
-- Objetivo: Permite identificar los clientes que han realizado donaciones.
-- Tablas implicadas: Donacion, persona
-- Condiciones: Join entre donacion y persona 
SELECT DISTINCT p.dni, p.nombre, p.apellidos
FROM Donacion d
JOIN Persona p ON d.dniDonador = p.dni;

#11.Recuersos educativos disponibles
-- Objetivo: Nos muestra los recursos educativos disponibles y los clientes que han accedido.
-- Tablas implicadas: RecursoEducativo, Accede, Cliente, Persona
-- Conciciones: Left join para incluir recursos sin clientes
SELECT r.codRE, r.nomRE, r.contenidoRE, p.dni, p.nombre, p.apellidos
FROM RecursoEducativo r
LEFT JOIN Accede a ON r.codRE = a.codRE
LEFT JOIN Cliente c ON a.dniCliente = c.dniCliente
LEFT JOIN Persona p ON c.dniCliente = p.dni
ORDER BY r.nomRE, p.apellidos;

#12.Actividades disponibles para voluntarios
-- Objetivo: Permite conocer las actividades disponibles para voluntarios.
-- Tablas implicadas: Actividad
-- Conciciones: dispActividad = 'Disponible'
SELECT nomActividad, requisitos
FROM Actividad
WHERE dispActividad = 'Disponible';

#Consultas Avanzadas
#1.Empleados que supervisan actividades y también cuidan animales
-- Objetivo: Muestra los empleados que tienen dos trabajos: supervisan las actividades y cuidan los animales.
-- Tablas implicadas: Empleado, persona, cuida, supervisa 
-- Condiciones: Join entre todas las tablas
SELECT DISTINCT p.nombre, p.apellidos
FROM Empleado e 
JOIN Persona p ON e.dniEmpleado = p.dni 
JOIN Cuida c ON e.dniEmpleado = c.dniEmpleado 
JOIN Supervisa s ON e.dniEmpleado = s.dniEmpleado;

#2.Empleados que han revisado formularios rechazados y aceptados
-- Objetivo: Nos permite identificar los empleados que han revisado los formularios aceptados como los rechazados.
-- Tablas implicadas: Empleado, persona, revisa, formulario 
-- Condiciones: Group by y having para contar tipos distintos 
SELECT DISTINCT p.nombre, p.apellidos 
FROM Revisa r 
JOIN Empleado e ON r.dniEmpleado = e.dniEmpleado 
JOIN Persona p ON e.dniEmpleado = p.dni 
WHERE r.resultado IN ('Aceptado','Rechazado') 
GROUP BY p.nombre,p.apellidos 
HAVING COUNT(DISTINCT r.resultado)>1;

#3.Numero de clientes que tienen mas de una mascota 
-- Objetivo: Nos permite conocer cuántos clientes tienen más de una mascota.
-- Tablas implicadas: Cliente
-- Condiciones: numMascotas > 1
SELECT COUNT(*) AS NumClientes 
FROM Cliente 
WHERE numMascotas > 1;

#4.Numero de donaciones por tipo
-- Objetivo: Podemos conocer cuántas donaciones se realizaron por tipo (Dinero o especie).
-- Tablas implicadas: Donación
-- Condiciones: Agrupar por tipoDonacion
SELECT tipoDonacion, COUNT(*) AS NumDonaciones 
FROM Donacion 
GROUP BY tipoDonacion;

#5.Clientes que accedieron a más de un recurso educativo
-- Objetivo: Podemos identificar los clientes que han accedido a varios recursos educativos.
-- Tablas implicadas: Accede, cliente, persona
-- Condiciones: Group by y having >1
SELECT p.nombre, p.apellidos, COUNT(a.codRE) AS RecursosAccedidos 
FROM Accede a JOIN Cliente c ON a.dniCliente = c.dniCliente 
JOIN Persona p ON c.dniCliente = p.dni 
GROUP BY p.nombre,p.apellidos 
HAVING COUNT(a.codRE)>0;

#6.Animales disponibles sin cuidador asignado
-- Objetivo: Muestra los animales disponibles que aún no tienen cuidador asignado.
-- Tablas implicadas: Animal, cuida
-- Condiciones: dispAnimal='Disponible' y left join con null
SELECT a.nomAnimal 
FROM Animal a 
LEFT JOIN Cuida c ON a.idAnimal=c.idAnimal 
WHERE a.dispAnimal='Disponible' AND c.dniEmpleado IS NULL;

#7.Promedio de mascotas por cliente
-- Objetivo: Podemos conocer el promedio de mascotas por cliente.
-- Tablas implicadas: Cliente
-- Condiciones: ninguna 
SELECT AVG(numMascotas) AS PromedioMascotas 
FROM Cliente;

#8.Animal mas pesado y mas ligero
-- Objetivo: Identifica cuál es el animal más pesado y el más ligero del refugio.
-- Tablas implicadas: Animal
-- Condiciones: Subconsultas con Max y Min
SELECT nomAnimal, pesoAnimal 
FROM Animal 
WHERE pesoAnimal=(SELECT MAX(pesoAnimal) FROM Animal) OR pesoAnimal=(SELECT MIN(pesoAnimal) FROM Animal);

#9.Clientes que han rellenado formularios recientes
-- Objetivo: Podemos conocer los clientes que han rellenado el formulario en los últimos 30 días.
-- Tablas implicadas: Rellena, cliente, persona, formulario
-- Condiciones: fecha>=CURDATE()-INTERVAL 30 DAY
SELECT DISTINCT p.nombre,p.apellidos 
FROM Rellena r 
JOIN Cliente c ON r.dniCliente=c.dniCliente 
JOIN Persona p ON c.dniCliente=p.dni 
WHERE r.fecha>=CURDATE()-INTERVAL 30 DAY;

#10.Numero de animales por raza disponibles
-- Objetivo: Permite conocer cuántos animales de cada raza están disponibles.
-- Tablas implicadas: Animal
-- Condiciones: dispAnimal='Disponible' y GROUP BY razaAnimal
SELECT razaAnimal, COUNT(*) AS NumAnimales 
FROM Animal 
WHERE dispAnimal='Disponible' 
GROUP BY razaAnimal;

#11.Total de donaciones por cliente
-- Objetivo: Total de donaciones realizadas por cliente
-- Tablas implicadas: Donación, persona 
-- Condiciones: Persona p ON d.dniDonador=p.dni GROUP BY p.nombre,p.apellidos
SELECT p.nombre, p.apellidos, SUM(d.cantDonacion) AS TotalDonado 
FROM Donacion d 
JOIN Persona p ON d.dniDonador=p.dni 
GROUP BY p.nombre,p.apellidos;


#12.Clientes que no han accedido a ningun recurso educativo.
-- Objetivo: Permite conocer a los clientes que no han accedido a ningún recurso educativo.
-- Tablas implicadas: Cliente, accede, persona, recurso Educativo
-- Condiciones: LEFT JOIN y filtrado NULL
SELECT p.nombre, p.apellidos 
FROM Cliente c 
JOIN Persona p ON c.dniCliente=p.dni 
LEFT JOIN Accede a ON c.dniCliente=a.dniCliente 
WHERE a.codRE IS NULL;







