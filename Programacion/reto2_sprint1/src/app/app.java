package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Instanciamos Scanner
		
		// Variables
		boolean shutdown;					// Decide si el programa debe acabar o no
		boolean admin;						// Define si el usuario tiene permisos de aministrador o no
		int user;
		String input;						// Texto que introduce el usuario
		ArrayList<String> users = new ArrayList<>();
		ArrayList<String> usersHistory = new ArrayList<>();
		ArrayList<String> adminGroup = new ArrayList<>();
		ArrayList<String> adoptionForms = new ArrayList<>();
		ArrayList<String> voluntaryForms = new ArrayList<>();
		ArrayList<String> donations = new ArrayList<>();
		
		// Inicializando Variables
		shutdown = false;
		user = -1;			// -1 Significa que no ha iniciado session
		admin = false;
		
		// Programa
		
		// Creamos el usuario "admin"
				users.add("admin");
				users.add("admin");
				adminGroup.add("admin");
		do{
			// Comprobamos si el usuario esta registrado y si es administrador
			if(user > -1 && adminGroup.contains(users.get(user))) {
				admin = true;
				System.out.println("\nUsuario: "+users.get(user)+" [ADMINISTRADOR]");
			}else if(user > -1) {
				admin = false;
				System.out.println("\nUsuario: "+users.get(user));
			}else {
				admin = false;
			}
			
			// Menu principal
			System.out.print("\n1 : Iniciar sesion"
					+ "\n2 : Crear una cuenta nueva"
					+ "\n3 : Configuracion de cuenta"
					+ "\n4 : Catalogo de Animales"
					+ "\n5 : Adoptar a un Animal"
					+ "\n6 : Servicio de Voluntariado"
					+ "\n7 : Hacer una Donación"
					+ "\n8 : Recursos Educativos"
					+ "\n9 : Salir");
			
			// Si el usuario es administrador, se enseñara esta opcion en el menu
			if (admin == true) {
				System.out.print("\n10 : Menu CRUD");
			}
			
			System.out.print("\n>> ");
			input = sc.next();
			sc.nextLine();
			
			switch (input) {
			case "1": // Iniciar sesion
				user = login(users);
				break;
				
			case "2": // Crear una cuenta nueva
				user = signUp(users, usersHistory);
				break;
				
			case "3": // Configuracion de cuenta
				if(user != -1) {
					user = configureUser(user, users, usersHistory, adminGroup);
				}else {
					System.out.println("ERROR: Debes iniciar sesion para acceder a la configuracion de cuenta.");
				}				
				break;
				
			case "4": // Catalogo de animales
				// Datos de los animales
				ArrayList<String> dogCatalog = new ArrayList<>(Arrays.asList("Max", "3", "Labrador", "Vacunas al día, sin enfermedades", "Juguetón, amigable con niños", "Ninguna", "Rocky", "5", "Pastor Alemán", "Leve displasia de cadera tratada", "Protector, entrenado", "Ejercicio moderado", "Luna", "2", "Beagle", "Saludable", "Energética, le gusta correr", "Espacio para jugar", "Toby", "4", "Pug", "Problemas respiratorios leves", "Cariñoso, tranquilo", "Evitar ejercicio excesivo", "Daisy", "1", "Golden Retriever", "Vacunas al día", "Muy sociable", "Ninguna"));
				ArrayList<String> catCatalog = new ArrayList<>(Arrays.asList("Michi", "2", "Siames", "Saludable", "Independiente, cariñoso", "Ninguna", "Nube", "3", "Persa", "Problemas de piel tratados", "Tranquilo, dormilón", "Cepillado diario", "Coco", "1", "Europeo", "Saludable", "Curioso, le gusta trepar", "Rascadores", "Bella", "4", "Angora", "Esterilizada, sin complicaciones", "Dócil", "Ninguna", "Simba", "5", "Maine Coon", "Control veterinario anual", "Grande, sociable", "Alimentación específica"));
				ArrayList<String> ferretCatalog = new ArrayList<>(Arrays.asList("Pipo", "2", "Hurón estándar", "Desparasitado", "Muy activo", "Jaula grande", "Nala", "1.5", "Hurón albino", "Vacunas al día", "Curiosa y juguetona", "Supervisión constante", "Chispa", "3", "Hurón panda", "Ligera alergia alimentaria", "Le gusta escarbar", "Dieta especial", "Lilo", "2.5", "Hurón negro", "Saludable", "Sociable con humanos", "Ninguna", "Tito", "4", "Hurón sable", "Esterilizado", "Tranquilo", "Limpieza frecuente"));
				
				System.out.println("Bienvenido al cátalogo de adopción de mascotas"
						+ "\nColoca el número del animal que quieres ver "
						+ "\n1. Perro "
						+ "\n2. Gato "
						+ "\n3. Hurón");
				
				input = sc.next(); //Leer entrada del usuario
				sc.nextLine();
				
				switch(input) {
				case "1":
					System.out.println("Has seleccionado: perros."
							+ "\nAquí tienes 5 disponibles: ");
					printCatalog(dogCatalog);
					break;
				
				case "2":
					System.out.println("Has seleccionado: gatos."
							+ "\nAquí tienes 5 disponibles: ");
					printCatalog(catCatalog);
					break;
					
				case "3":
					System.out.println("Has seleccionado: hurónes."
							+ "\nAquí tienes 5 disponibles: ");
					printCatalog(ferretCatalog);
					break;
				
				default:
					System.out.println("ERROR: Esa opcion no existe, por favor intetnte de nuevo introduciendo un valor numerico entre 1 y 3.");
					break;
				}
				break;
				
			case "5": // Adoptar a un Animal
				newAdoptionForm(adoptionForms);
				break;
				
			case "6": // Servicio de Voluntariado
				newVoluntaryForm(voluntaryForms);
				break;
				
			case "7": // Hacer una Donación
				newDoncation(donations);
				break;
				
			case "8": // Recursos Educativos
				menuRE();
				break;
				
			case "9": // Salir
				System.out.println("¿Estas seguro de que quieres salir del programa?");
				input = sc.next().toLowerCase();
				sc.nextLine();
				
				// Si el usuario dice que si, se cierra el programa
				if (input.equals("si")) {
					System.out.println("Saliendo del programa...");
					shutdown = true;
				} else {
					System.out.println("Operacion cancelada.");
				}
				break;
				
			case "10": // Menu CRUD
				if (admin == true) {
					for (boolean salir=false; salir==false;) {
						System.out.print("[Menu CRUD]"
								+ "\n1 : Ver datos de todos los usuarios"
								+ "\n2 : Eliminar usuarios"
								+ "\n3 : Agregar administradores"
								+ "\n4 : Quitar administradores"
								+ "\n5 : Volver al menu principal"
								+ "\n>> ");
						
						input = sc.next();
						sc.nextLine();
						
						switch (input) {
						case "1": // Ver datos de todos los usuarios
							System.out.println("Usuarios: ");
							printArray(users);
							System.out.println("\nHistorial de usuarios: ");
							printArray(usersHistory);
							System.out.println("\ngrupoAdmin: ");
							printArray(adminGroup);
							break;
							
						case "2": // Eliminar usuarios
							System.out.print("Introduce el nombre del usuario que deseas eliminar: ");
							input = sc.next();
							sc.nextLine();
							
							if(users.contains(input)) {
								// Actualizar el historial de usuarios
								usersHistory.set(usersHistory.indexOf(input), input+" (Eliminado)");
								// Quitamos el usuario del grudo admin si esta en ello
								if(adminGroup.contains(input)) {
									adminGroup.remove(input);
								}
								// Comprueba si el usuario que se va a eliminar es el que esta en uso.
								if(input.equals(users.get(user))) {
									user = -1;
								}
								// Eliminar el nombre y contraseña de usuario
								users.remove(users.indexOf(input)+1);
								users.remove(users.indexOf(input));
								
								System.out.println("El usuario \""+input+"\" ha sido eliminado.");
								
							}else {
								System.out.println("ERROR: Usuario no encontrado.");
							}
							break;
							
						case "3": // Agregar administradores
							System.out.println("Introduce el usuario que deseas agreagar al grupo administrativo: ");
							input = sc.next();
							sc.nextLine();
							
							if(users.contains(input)) {
								adminGroup.add(input);
								System.out.println("El usuario \""+input+"\" se ha unido al grupo administrativo.");
							}else {
								System.out.println("ERROR: Usuario no encontrado.");
							}
							break;
							
						case "4": // Quitar administradores
							System.out.println("Introduce el usuario que deseas quitar del grupo administrativo: ");
							input = sc.next();
							sc.nextLine();
							
							if(users.contains(input)) {
								adminGroup.remove(input);
								System.out.println("El usuario \""+input+"\" se ha dejado el grupo administrativo.");
							}else {
								System.out.println("ERROR: Usuario no encontrado.");
							}
							break;
							
						case "5": // Volver al menu principal
							salir = true;
							break;
						}
					}
				} else {
					System.out.println("ERROR: Debes tener permisos de administrador para usar esta opcion.");
				}
				break;
				
			default: // Se ha introducido un valor que no existe.
				System.out.println("ERROR: Esa opcion no existe, por favor intetnte de nuevo introduciendo un valor numerico.");
				break;
			}
			
		} while (shutdown == false); // Se cierra el programa si shutdown es 'true'
		sc.close(); // Cerramos Scanner

	}

	// Metodos y funciones
	private static void printArray(ArrayList<String> array) {
		for (int i=0; i<array.size(); i++) {
			if (i<array.size()-1) {
				System.out.print(array.get(i)+", ");
			} else {
				System.out.print(array.get(i)+"\n");
			}
		}
		
	}
	
	private static void menuRE() {
		Scanner sc = new Scanner(System.in);
		
		for (boolean salir=false; salir==false;) {
			System.out.print("[Recursos Educativos]"
					+ "\n\n1 : Cuidado Responsable de Mascotas"
					+ "\n2 : La Esterilización"
					+ "\n3 : Prevención del Maltrato Animal"
					+ "\n4 : Volver al Menu Principal"
					+ "\nIntroduce el numero del recurso que quieres abrir:");
			String input = sc.next();
			
			switch (input) {
			case "1": // Cuidado Responsable de Mascotas
				System.out.println("\n[Cuidado Responsable de Mascotas]\n\nTener una mascota es una gran responsabilidad que requiere compromiso, dedicación y cariño. No basta con darle comida y un lugar para dormir; es fundamental cuidar su salud física y emocional para que tenga una vida plena y feliz.\n\nUna alimentación adecuada y equilibrada es básica para mantener a la mascota sana. Además, debe contar siempre con agua limpia y fresca, especialmente en días calurosos. La dieta debe ajustarse según la edad, tamaño y necesidades específicas de cada animal.\n\nEl seguimiento veterinario es indispensable. Vacunas, desparasitaciones y chequeos periódicos previenen enfermedades y detectan problemas a tiempo. También es importante considerar la esterilización para evitar camadas no deseadas y promover la salud del animal.\n\nEl ejercicio diario y la estimulación mental son esenciales para su bienestar. Paseos, juegos y actividades adecuadas a su especie evitan el estrés y comportamientos destructivos, fortaleciendo además el vínculo con su dueño.\n\nLa higiene regular, que incluye baños, corte de uñas y limpieza de sus espacios, ayuda a prevenir enfermedades y mantiene al animal cómodo. Cuidar su entorno también es parte del respeto y la responsabilidad.\n\nLas mascotas necesitan atención emocional y respeto. Debemos aprender a interpretar sus señales para evitar ansiedad o miedo, y nunca recurrir a castigos físicos, que solo dañan la confianza y el bienestar del animal.\n\nLa educación y la paciencia son claves para enseñar normas de convivencia, evitando problemas y facilitando una relación armoniosa. La identificación, como un collar o microchip, es vital para su seguridad en caso de pérdida.\n\nAntes de adoptar, es fundamental evaluar si se puede asumir el compromiso a largo plazo, ya que una mascota depende completamente de sus dueños durante toda su vida. Abandonar nunca es una opción responsable.\n\nEn definitiva, el cuidado responsable implica amor, respeto y dedicación para asegurar que las mascotas tengan una vida digna y feliz, y así construir juntos una sociedad más compasiva.");
				break;
			
			case "2": //La Esterilizacion
				System.out.println("\n[La Esterilizacion]\n\nLa esterilización de mascotas es un procedimiento veterinario que consiste en la intervención quirúrgica para evitar la reproducción de los animales. En el caso de las hembras se realiza mediante la ovariohisterectomía (extirpación de ovarios y útero), mientras que en los machos se practica la orquiectomía (extirpación de testículos).\n\nUno de los principales beneficios de la esterilización es la reducción de la sobrepoblación animal. Cada año, millones de perros y gatos terminan en refugios o en la calle debido a la falta de hogares responsables. Evitar camadas no deseadas contribuye a disminuir este problema social y de bienestar animal.\n\nAdemás de controlar la natalidad, la esterilización previene diversas enfermedades. En las hembras reduce significativamente el riesgo de tumores mamarios y elimina la posibilidad de infecciones uterinas graves como la piómetra. En los machos, disminuye la incidencia de cáncer testicular y problemas de próstata.\n\nEl procedimiento también tiene un impacto positivo en el comportamiento. En muchos casos, los animales esterilizados son menos propensos a la agresividad, a las fugas en busca de pareja y al marcaje con orina, lo que facilita la convivencia dentro del hogar.\n\nEs importante destacar que la cirugía no cambia la personalidad de la mascota, solo ayuda a estabilizar ciertos comportamientos asociados al instinto reproductivo. El cariño, la energía y el vínculo con sus dueños permanecen intactos.\n\nExisten mitos comunes que desmotivan a algunas personas a optar por la esterilización. Por ejemplo, no es cierto que los animales necesiten tener al menos una camada para estar sanos, ni que inevitablemente engorden después de la cirugía. Con una dieta equilibrada y ejercicio, pueden mantenerse en óptima condición física.\n\nEl momento ideal para esterilizar depende de la especie, raza y estado de salud del animal, pero los veterinarios suelen recomendarlo a una edad temprana, antes del primer celo en hembras y alrededor de los 6 a 8 meses en machos.\n\nEl procedimiento, aunque es una cirugía mayor, se considera seguro cuando lo realiza un profesional veterinario en un entorno adecuado. La recuperación suele ser rápida, con unos pocos días de reposo y cuidados básicos postoperatorios.\n\nEsterilizar a una mascota es un acto de responsabilidad y amor. No solo se protege la salud del animal, sino que también se contribuye a una sociedad más compasiva, con menos abandono y sufrimiento.\n\nEn conclusión, la esterilización es una herramienta fundamental para garantizar el bienestar de los animales de compañía y para fomentar una tenencia responsable. Informarse y tomar la decisión consciente de esterilizar es una de las mejores formas de cuidar a nuestras mascotas.");
				break;
			
			case "3": // Prevencion del Maltrato Animal
				System.out.println("\n[Prevencion del Maltrato Animal]\n\nLa prevención del maltrato animal es un tema esencial para garantizar el bienestar de todas las especies que conviven con los seres humanos. Se entiende como maltrato no solo la violencia física, sino también el abandono, la negligencia en cuidados básicos, la explotación y cualquier acción que cause sufrimiento innecesario a los animales.\n\nUno de los primeros pasos para prevenirlo es la educación y concienciación. Desde temprana edad, es importante enseñar a niños y jóvenes el valor del respeto hacia los animales, fomentando la empatía y la responsabilidad. Una sociedad consciente es menos propensa a tolerar el maltrato.\n\nLa tenencia responsable de mascotas es otra medida clave. Esto implica brindar alimento adecuado, atención veterinaria, espacio apropiado, compañía y, en general, satisfacer las necesidades físicas y emocionales del animal. Una mascota no es un objeto ni un entretenimiento pasajero, sino un ser vivo dependiente de nuestros cuidados.\n\nAsimismo, la esterilización contribuye indirectamente a prevenir el maltrato, ya que ayuda a controlar la sobrepoblación. Muchos animales terminan abandonados en las calles o en refugios porque nacen más crías de las que pueden ser adoptadas, y esta situación los expone al hambre, las enfermedades y la violencia.\n\nLas leyes y normativas de protección animal cumplen un papel fundamental. Contar con marcos legales claros que sancionen el maltrato y el abandono envía un mensaje contundente a la sociedad. Además, es necesario que estas leyes se acompañen de vigilancia, denuncias y aplicación efectiva de sanciones.\n\nLa colaboración con organizaciones de protección animal también es una forma de prevenir el maltrato. Estas entidades rescatan, rehabilitan y promueven la adopción responsable, además de realizar campañas educativas. Apoyarlas con voluntariado o donaciones fortalece su capacidad de acción.\n\nOtro aspecto importante es aprender a reconocer y denunciar casos de maltrato. Si un ciudadano observa signos de violencia, desnutrición, encadenamiento constante o abandono, debe reportarlo a las autoridades competentes. El silencio solo perpetúa el sufrimiento.\n\nOtro aspecto importante es aprender a reconocer y denunciar casos de maltrato. Si un ciudadano observa signos de violencia, desnutrición, encadenamiento constante o abandono, debe reportarlo a las autoridades competentes. El silencio solo perpetúa el sufrimiento.\n\nLa conciencia sobre el consumo también juega un papel en la prevención. Al elegir productos y espectáculos, es recomendable rechazar aquellos que impliquen explotación o crueldad hacia los animales, como circos con fauna silvestre, peleas o crías ilegales.\n\nPrevenir el maltrato animal no es solo una cuestión ética, sino también un reflejo de la calidad humana de una sociedad. Tratar con dignidad a los animales promueve valores de respeto, solidaridad y justicia que se extienden a todas las relaciones sociales.\n\nEn definitiva, la prevención del maltrato animal requiere educación, responsabilidad, leyes firmes y compromiso ciudadano. Cuidar de los animales no es un acto aislado, sino un deber compartido que contribuye a una convivencia más humana, justa y compasiva.");
				break;
			
			case "4": // Volver al Menu Principal
				System.out.println("Volviendo al menu principal...");
				salir = true;
				break;
		
			default:
				System.out.println("\nERROR: Esa opcion no existe, por favor intetnte de nuevo introduciendo un valor numerico.");
				break;
			}
		}
	}

	private static void newDoncation(ArrayList<String> donations) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[HAZ UNA DONACIÓN]\nNombre: ");
		donations.add(sc.next());
		sc.nextLine();
        
		for(boolean salir=false; salir==false;) {
        	System.out.print("Correo electrónico: ");
        	String input = sc.next();
            sc.nextLine();
            if(input.contains("@") && input.contains(".")) {
            	donations.add(input);
            	salir = true;
            }else {
            	System.out.println("ERROR: El correo electronico debe contener al menos un \'@\' y un dominio.");
            }
        }
		
        for (boolean salir=false; salir==false;) {
        	System.out.print("Cantidad de donacion: "); 
            int cantDonacion = sc.nextInt();
    		sc.nextLine();
            
            if (cantDonacion < 0) {
            	System.out.println("ERROR: El valor debe ser mayor que 0.");
            } else {
            	donations.add(Integer.toString(cantDonacion));
            	salir = true;
            }
        }
        
        for (boolean salir=false; salir==false;) {
        	System.out.print("Métodos de pago:\n1. Tarjeta\n2. PayPal\n3. Transferencia\nSelecciona una opcion: ");
			String input = sc.next();
			sc.nextLine();
			
			switch (input) {
			case "1":
				donations.add("Tarjeta");
				salir = true;
				break;
			case "2":
				donations.add("PayPal");
				salir = true;
				break;
			case "3":
				donations.add("Transferencia");
				salir = true;
				break;
			default:
				System.out.println("ERROR: Esa opcion no existe, por favor intetnte de nuevo introduciendo un valor numerico.\n");
				break;
			}
        }
        System.out.println("¡Muchas gracias por su donación!");
	}

	private static void newVoluntaryForm(ArrayList<String> voluntaryForms) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[FORMULARIO DE SERVICIO DE VOLUNTARIADO]\nNombre: ");
		voluntaryForms.add(sc.next());
        sc.nextLine();

        System.out.print("Ingrese su apellido:");
        voluntaryForms.add(sc.next());
        sc.nextLine();

        for(boolean salir=false; salir==false;) {
        	System.out.print("Correo electrónico: ");
        	String input = sc.next();
            sc.nextLine();
            if(input.contains("@") && input.contains(".")) {
            	voluntaryForms.add(input);
            	salir = true;
            }else {
            	System.out.println("ERROR: El correo electronico debe contener al menos un \'@\' y un dominio.");
            }
        }
        
        for(boolean salir=false; salir==false;) {
        	System.out.print("Numero de telefono: ");
        	String input = sc.next().replaceAll("\\s+", "");;
            sc.nextLine();
            if(input.length() == 9) {
            	voluntaryForms.add(input);
            	salir = true;
            }else {
            	System.out.println("ERROR: El numero de telefono debe ser 9 numeros de largo.");
            }
        }
        
        System.out.print("DNI: ");
        voluntaryForms.add(sc.next());
        sc.nextLine();
        
        for (boolean salir=false; salir==false;) {
        	System.out.print("¿En qué actividad te gustaría participar?"
        			+ "\n1. Paseadores"
        			+ "\n2. Cuidadores en Refugios"
        			+ "\n3. Entrenadores de perros"
        			+ "\n4. Voluntarios de Rescate"
        			+ "\n5. Voluntarios de difusión y adopción"
        			+ "\nSeleccione el número de la actividad que desea hacer: ");
			String input = sc.next();
			sc.nextLine();
			
			switch (input) {
			case "1":
				voluntaryForms.add("Paseadores");
				salir = true;
				break;
			case "2":
				voluntaryForms.add("Cuidadores en Refugios");
				salir = true;
				break;
			case "3":
				voluntaryForms.add("Entrenadores de perros");
				salir = true;
				break;
			case "4":
				voluntaryForms.add("Voluntarios de Rescate");
				salir = true;
				break;
			case "5":
				voluntaryForms.add("Voluntarios de difusión y adopción");
				salir = true;
				break;
			default:
				System.out.println("ERROR: Esa opcion no existe, por favor intetnte de nuevo introduciendo un valor numerico.\n");
				break;
			}
        }
        
        for (boolean salir=false; salir==false;) {
        	System.out.print("¿Cuando puedes participar?"
        			+ "\n1. Fines de semana"
        			+ "\n2. Entre semana"
        			+ "\nSeleccione su disponibilidad: ");
			String input = sc.next();
			sc.nextLine();
			
			switch (input) {
			case "1":
				voluntaryForms.add("Fines de semana");
				salir = true;
				break;
			case "2":
				voluntaryForms.add("Entre semana");
				salir = true;
				break;
			default:
				System.out.println("ERROR: Esa opcion no existe, por favor intetnte de nuevo introduciendo un valor numerico.\n");
				break;
			}
        }
        
        System.out.println("¿Por qué deseas ser Voluntario?");
        voluntaryForms.add(sc.next());
        sc.nextLine();
        System.out.println("Sus respuestas han sido guardadas.");
	}

	private static void newAdoptionForm(ArrayList<String> adoptionForms) {
		Scanner sc = new Scanner(System.in);
		// Recogemos las respuestas del usuario
		System.out.println("[SOLICITUD DE ADOPCIÓN]");
        System.out.print("Nombre completo: ");
        adoptionForms.add(sc.next());
        sc.nextLine();
        
        System.out.print("Dirección: ");
        adoptionForms.add(sc.next());
        sc.nextLine();
        
        for(boolean salir=false; salir==false;) {
        	System.out.print("Correo electrónico: ");
        	String input = sc.next();
            sc.nextLine();
            if(input.contains("@") && input.contains(".")) {
            	adoptionForms.add(input);
            	salir = true;
            }else {
            	System.out.println("ERROR: El correo electronico debe contener al menos un \'@\' y un dominio.");
            }
        }

        for(boolean salir=false; salir==false;) {
        	System.out.print("Numero de telefono: ");
        	String input = sc.next().replaceAll("\\s+", "");;
            sc.nextLine();
            if(input.length() == 9) {
            	adoptionForms.add(input);
            	salir = true;
            }else {
            	System.out.println("ERROR: El numero de telefono debe ser 9 numeros de largo.");
            }
        }

        System.out.print("Nombre del animal que deseas adoptar: ");
        adoptionForms.add(sc.next());
        sc.nextLine();

        System.out.print("¿Por qué deseas adoptar a este animal en especial?: ");
        adoptionForms.add(sc.next());
        sc.nextLine();
        System.out.println("Sus respuestas han sido guardadas.");
	}

	private static void printCatalog(ArrayList<String> datosAnimales) {
		for (int i=0; i<datosAnimales.size(); i=i+6) {
			System.out.println("Nombre: "+datosAnimales.get(i)
					+"\n - Edad: "+datosAnimales.get(i+1)
					+"\n - Raza: "+datosAnimales.get(i+2)
					+"\n - Historial Médico: "+datosAnimales.get(i+3)
					+"\n - Características: "+datosAnimales.get(i+4)
					+"\n - Necesidades Especiales: "+datosAnimales.get(i+5)
					+"\n");
		}		
	}

	private static int configureUser(int user, ArrayList<String> users, ArrayList<String> usersHistory, ArrayList<String> adminGroup) {
		Scanner sc = new Scanner(System.in);
		
		for (boolean salir=false; salir==false;) {
			System.out.println("[CONFIGURACION DE CUENTA]\n1 : Cerrar sesion\n2 : Eliminar cuenta\n3 : Volver al menu principal\n>> ");
			String input = sc.next();
			sc.nextLine();
			
			switch (input) {
			case "1": // Cerrar sesion
				System.out.println("Se ha cerrado la sesion del usuario \""+users.get(user)+"\".");
				user = -1;
				salir = true;
				break;
			case "2": // Eliminar cuenta
				System.out.print("Contraseña: ");
				input = sc.next();
				sc.nextLine();
				
				// Comprobamos si existe la contraseña es correcta
				if(input.equals(users.get(user+1))) {
					// Actualizamos el historial de usuarios
					usersHistory.set(usersHistory.indexOf(users.get(user)), users.get(user)+" (Eliminado)");
					// Quitamos el usuario del grudo admin si esta en ello
					if(adminGroup.contains(input)) {
						adminGroup.remove(input);
					}
					// Eliminamos el usuario del array de usuarios
					System.out.println("El usuario \""+users.get(user)+"\" ha sido eliminado.");
					users.remove(user);
					users.remove(user+1);
					user = -1;
					salir = true;
				}else {
					System.out.println("AVISO: La contraseña introducida es incorrecta.");
				}
				break;
				
			case "3": // Salir
				salir = true;
				break;
				
			default:
				System.out.println("ERROR: Esa opcion no existe, por favor intetnte de nuevo introduciendo un valor numerico.\n");
				break;
			}
		}
		return user;
	}

	private static int signUp(ArrayList<String> users, ArrayList<String> usersHistory) {
		Scanner sc = new Scanner(System.in);
		int indexOfUser = -1; // Guarda la posicion del nombre de usuario introducido en el array.
		
		System.out.print("Introduce un nombre de usuario: ");
		String input = sc.next();
		sc.nextLine();
		
		// Comprobamos si ya existe un usuario con el nombre introducido
		if(users.contains(input)) {
			System.out.println("ERROR: El nombre \""+input+"\" ya existe. Intente de nuevo con un nombre distinto.");
		}else {
			// Guardamos el nombre de usuario
			users.add(input);
			indexOfUser = users.size()-1;
			System.out.print("Introduce una contraseña: ");
			input = sc.next();
			sc.nextLine();
			
			// Guardamos la contraseña
			users.add(input);
			
			// Actualizamos el historial de usuarios
			usersHistory.add(users.get(indexOfUser));
			System.out.println("El usuario \""+users.get(indexOfUser)+"\" ha sido creado.");
		}
		
		return indexOfUser;
	}

	private static int login(ArrayList<String> users) {
		Scanner sc = new Scanner(System.in);
		int indexOfUser = -1; // Guarda la posicion del nombre de usuario introducido en el array.
		
		System.out.print("Nombre de usuario: ");
		String input = sc.next();
		sc.nextLine();
		
		// Comprobamos si existe el usuario epecificado
		if(users.contains(input)) {
			indexOfUser = users.indexOf(input);
			System.out.print("Contraseña: ");
			input = sc.next();
			sc.nextLine();
			
			// Comprobamos si existe la contraseña es correcta
			if(input.equals(users.get(indexOfUser+1))) {
				System.out.println("Has iniciado sesion en la cuenta \""+users.get(indexOfUser)+"\".");
			}else {
				System.out.println("AVISO: La contraseña introducida es incorrecta.");
				indexOfUser = -1;
			}
		}else {
			System.out.println("ERROR: El usuario \""+input+"\" no se ha encontrado.");
		}
		
		return indexOfUser;
	}

}