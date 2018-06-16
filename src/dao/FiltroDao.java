package dao;

import conexion.Conexion;
import interfaces.Metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Filtro;

public class FiltroDao implements Metodos<Filtro>{
    
    private static final String SQL_INSERT = "INSERT INTO filtros_aceite (codFiltro, marca, stock, existencia) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE filtros_aceite SET marca = ?, stock = ?, existencia = ? WHERE codFiltro = ?";
    private static final String SQL_DELETE = "DELETE FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READ = "SELECT * FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READALL = "SELECT * FROM filtros_aceite";
    private static final String SQL_NOMBREMARCA = "SELECT nombre FROM marcas WHERE id=?";

    public static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(Filtro g) {
        
        PreparedStatement ps;
        
        try{
            
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.getCodigo());
            ps.setInt(2, g.getMarca());
            ps.setInt(3, g.getStock());
            ps.setBoolean(4, true);
            
            if(ps.executeUpdate() > 0){
                return true;
            }            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerracConexion();
        }
        
        return false;
        
    }

    @Override
    public boolean delete(Object key) {
        
        PreparedStatement ps;
        
        try{
            
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate() > 0){
                return true;
            }            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerracConexion();
        }
        
        return false;
        
    }

    @Override
    public boolean update(Filtro c) {
        PreparedStatement ps;
        
        try{
            
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getMarca());
            ps.setInt(2, c.getStock());
            ps.setBoolean(3, c.getExistencia());
            ps.setString(4, c.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return true;
            }            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerracConexion();
        }
        
        return false;

    }
    
    
    @Override
    public Filtro read(Object key) {
        
        Filtro f = null;
        PreparedStatement ps, ps2;
        ResultSet rs, rs2;
        
        try{
            
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                ps2 = con.getCnx().prepareStatement(SQL_NOMBREMARCA);
                ps2.setInt(1, Integer.parseInt(rs.getString(3)));
                rs2 = ps2.executeQuery();
                rs2.next();
                f = new Filtro(rs.getInt(1), rs.getString(2), rs2.getString(1),Integer.parseInt(rs.getString(3)), rs.getInt(4), rs.getBoolean(5));
                rs2.close();
            }
            rs.close();

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerracConexion();
        }
        
        return f;
    }

    @Override
    public ArrayList<Filtro> readAll() {
    
        ArrayList<Filtro> all = new ArrayList<>();
        Statement s;
        PreparedStatement ps;
        ResultSet rs, rs2;
        
        try{
            
            s = con.getCnx().prepareStatement(SQL_READALL);
          
            rs = s.executeQuery(SQL_READALL);
            
            while(rs.next()){
                ps = con.getCnx().prepareStatement(SQL_NOMBREMARCA);
                ps.setInt(1, Integer.parseInt(rs.getString(3)));
                rs2 = ps.executeQuery();
                rs2.next();
                all.add(new Filtro(rs.getInt(1), rs.getString(2),  rs2.getString(1),Integer.parseInt(rs.getString(3)), rs.getInt(4), rs.getBoolean(5)));
            }
            rs.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(FiltroDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            con.cerracConexion();
        }
        
        return all;
        
    }
    
}
