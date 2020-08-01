package agenda01;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Agenda {

    private Contacto[] contactos;
    
    public Agenda() {
        this.contactos = new Contacto[10];
    }
    
    public Agenda (int tamanio){
        this.contactos = new Contacto[tamanio];
    }
    
    
    /**
     * Añade un contacto a la agenda
     * @param c 
     */
    
    public void aniadirContacto (Contacto c){
        
        boolean encontrado = false;
        boolean aniadido = false;
                
        if(existeContacto(c)){ //Indico si existe el contacto
            JOptionPane.showMessageDialog(null, "Existe un contacto con ese nombre");
            encontrado = true;
        } else if (agendaLlena()){ //Indico si la agenda está o no llena
            JOptionPane.showMessageDialog(null, "No hay espacio en la agenda");
            encontrado = true;
        }
               
        for (int i=0; i < contactos.length && !encontrado && !aniadido; i++){
            if (contactos[i]==null){ //Controlo los nulos
                contactos[i] = c; //si se trata del último elemento, agrega el nuevo contacto
                aniadido = true;
            }
        }
        
        if (aniadido){
            JOptionPane.showMessageDialog(null, "Se ha añadido");
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido añadir");
        }
    }
    /**
     * Indica si existe un contacto
     * @param c
     * @return 
     */
    public boolean existeContacto (Contacto c){
        
        for (int i=0; i<contactos.length;i++){
            //Controlo nulos e indico si el contacto es el mismo
            if (contactos[i] != null && c.equals(contactos[i])){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Lista los contactos de la agenda
     * 
     */
    public void listarContactos(){
        
        if (huecosLibre() == contactos.length){
            JOptionPane.showMessageDialog(null, "No hay contactos que mostrar");
        } else {
            for(int i=0; i<contactos.length; i++){
                if(contactos[i] != null){ //Controlo nulos
                System.out.println(contactos[i]);
                }
            }
        }
    }

    public Contacto[] getContactos() {
        return contactos;
    }
    
       
    public void buscarPorNombre(String nombre){

        boolean encontrado = false;

        for(int i=0; i<contactos.length && !encontrado; i++){
            if(contactos[i] != null && contactos[i].getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Su telefono es " + contactos[i].getTelefono());
            }
        }
        
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Contacto no encontrado");
        }
        
    }
    
    public boolean agendaLlena(){
       for(int i=0; i<contactos.length; i++){
           if (contactos[i] == null) {
               return false;// está llena
           }                     
       } 
       return true; // retorna verdadero, que la agenda está llena
    }
    
    /**
     * Elimina el contacto de la agenda
     * 
     * @param c 
     */
    
    
    public void eliminarContacto(Contacto c) {
        
        boolean encontrado = true;
        
        for(int i=0; i<contactos.length; i++){
            if(contactos[i] != null && contactos[i].equals(c))
                contactos[i] = null; //Controlo nulos
                encontrado = true; //Indico que lo he encontrado
        }
        
        if (!encontrado){
            JOptionPane.showMessageDialog(null, "No se ha encontrado el contacto");
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

    void exportarContactos() {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contactos.age"))) {
        
            for(int i=0; i<contactos.length; i++) {
                if (contactos[i] != null) { // Verifica que la posicion no sea nula para escribir
                    oos.writeObject(contactos[i]);
                }
            
            }
            
            JOptionPane.showMessageDialog(null, "Se ha escrito con exito");
            
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void importarContactos(String fichero) throws IOException, ClassNotFoundException {
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
        
            Contacto aux;
            while(true){
                aux =(Contacto)ois.readObject();
            
                aniadirContacto(aux);
            }
        } catch (EOFException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}


