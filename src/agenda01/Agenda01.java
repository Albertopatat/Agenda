/*package agenda01; Primer versión con menú DOS. Evoluciona a la versión 02


import java.util.InputMismatchException;
import java.util.Scanner;


public class Agenda01 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner (System.in);
        sn.useDelimiter("\n");
        
        boolean salir = false;
        int opcion; //Guarda la elección del usuario
        
        Agenda agendaTel = new Agenda(3);
        Contacto c;
        String nombre;
        int telefono;
        
        while (!salir){
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Contactos disponibles");
            System.out.println("7. Aganda llena");
            System.out.println("8. Salir");
            
            try {
                System.out.print("Ingrese una opción y presione enter: ");
                opcion = sn.nextInt();
                
                switch (opcion) {
                    case 1:
                        
                        System.out.println("Nombre:");
                        nombre = sn.next();
                        
                        System.out.println("Telefono:");
                        telefono = sn.nextInt();
                        
                        c = new Contacto(nombre, telefono);
                        
                        agendaTel.aniadirContacto(c);
                        
                        break;
                    
                    case 2:
                        
                        agendaTel.listarContactos();
                        
                        break;
                    
                    case 3:
                        
                        System.out.println("Nombre a buscar: ");
                        nombre = sn.next();
                        
                        agendaTel.buscarPorNombre(nombre);
                        break;
                    
                    case 4:
                        
                        System.out.println("Nombre a verificar: ");
                        nombre = sn.next();
                        
                        c = new Contacto(nombre, 0);// Pasa solo el nombre, verificar.
                        
                        if (agendaTel.existeContacto(c)) {
                            System.out.println("Existe contacto");
                        } else {
                            System.out.println("No existe contacto");
                        };
                        
                        break;
                    case 5:
                        
                        System.out.println("Nombre a eliminar: ");
                        nombre = sn.next();
                        
                        c = new Contacto(nombre, 0);
                        agendaTel.eliminarContacto(c);
                        
                        break;
                    
                    case 6:
                        System.out.println("Hay " + agendaTel.huecosLibre() + " contacto/s libre/s");
                        
                        break;
                    
                    case 7:
                        
                        if(agendaTel.agendaLlena()){
                            System.out.println("La agenda está llena");
                        } else {
                            System.out.println("La agenda aún tiene espacio");
                        }
                        
                        break;
                    
                    case 8:
                        
                        salir = true;
                        
                        break;
                    
                    default:
                        System.out.println("Ingrese un número entre 1 y 8");
                    
                }
                
            } catch (InputMismatchException e){
                System.out.println("Debes ingregar un número");
                sn.next();
            }
        }
    }
    
}
*/