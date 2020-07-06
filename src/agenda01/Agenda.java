package agenda01;

public class Agenda {

    private Contacto[] contactos;
    
    public Agenda() {
        this.contactos = new Contacto[10];
    }
    
    public Agenda (int tamanio){
        this.contactos = new Contacto[tamanio];
    }
    
    public void aniadirContacto (Contacto c){
        
        if(existeContacto(c)){
            System.out.println("Existe un contacto con ese nombre");
        } else if (agendaLlena()){
            System.out.println("La agenda está llena");
        }
            
        
        boolean encontrado = false;
        for (int i=0; i < contactos.length && !encontrado; i++){
            if (contactos[i]==null){
                contactos[i] = c; //si se trata del último elemento, agrega el nuevo contacto
                encontrado = true;
            }
        }
        
        if (encontrado){
            System.out.println("Se ha añadido");
        }else{
            System.out.println("No se ha podido añadir");
        }
    }
    
    public boolean existeContacto (Contacto c){
        
        for (int i=0; i<contactos.length;i++){
            if (contactos[i] != null && c.equals(contactos[i])){
                return true;
            }
        }
        
        return false;
    }
    
    public void listarContactos(){
        for(int i=0; i<contactos.length; i++){
            if(contactos[i] != null){
                System.out.println(contactos[i]);
            }
        }
    }
    
    public void buscarPorNombre(String nombre){

        boolean encontrado = false;

        for(int i=0; i<contactos.length && !encontrado; i++){
            if(contactos[i] != null && contactos[i].getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Su telefono es " + contactos[i].getTelefono());
            }
        }
        
        if (!encontrado) {
            System.out.println("Contacto no encontrado");
        }
        
    }
    
    public boolean agendaLlena(){
       for(int i=0; i<contactos.length; i++){
           if (contactos[i] != null) {
               return false;
           }                      
       } 
       return true;
    }
    
    public void eliminarContacto(Contacto c) {
        
        boolean encontrado = true;
        
        for(int i=0; i<contactos.length; i++){
            if(contactos[i] != null && contactos[i].equals(c))
                contactos[i] = null;
                encontrado = true;
        }
        
        if (!encontrado){
            System.out.println ("No se ha encontrado el contacto");
        }
       
    }
    
    public int huecosLibre(){
        
        int contadorLibres = 0;
        for(int i=0; i<contactos.length; i++) {
            if(contactos[i]==null){
                contadorLibres++;
            }
        }
        return contadorLibres;
    }
    //for(int i=0; i<contactos.length; i++){

}


