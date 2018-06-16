package modelo;

public class Filtro {
    
    private int id;
    private String codigo;
    private int marca;
    private String nombreMarca;
    private int stock;
    private boolean existencia;

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Filtro(){

    
    }
    
    public Filtro(int id, String codigo, int marca, int stock, boolean existencia){
    
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
        
    }

    public Filtro(int id, String codigo, String nombreMarca, int marca, int stock, boolean existencia){

        this.id = id;
        this.codigo = codigo;
        this.nombreMarca = nombreMarca;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;

    }
    
    public Filtro(String codigo, int marca, int stock, boolean existencia){

        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
        
    }
    
    public Filtro(int marca, int stock, boolean existencia){
    
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean getExistencia() {
        return existencia;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
    
    
    
}
