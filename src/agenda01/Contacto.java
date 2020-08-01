package agenda01;

import java.io.Serializable;

public class Contacto implements Serializable{
    
    private static final long serialVersionUID = -1L;
    
    private String nombre;
    private int telefono;

    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public boolean equals(Contacto c){
        
        if (this.nombre.equalsIgnoreCase (c.getNombre())){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "nombre=" + nombre + ", telefono=" + telefono;
    }

}
