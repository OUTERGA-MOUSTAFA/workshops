package ma.youcode.workshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.youcode.workshop.models.Apprenant;
import ma.youcode.workshop.util.ConnectionFactory;

public class ApprenantDao {


    public List<Apprenant> findAll(){
        List<Apprenant> list= new ArrayList<>();
        String sql="select * from etudiant";
        try (Connection cn=ConnectionFactory.getConnection(); 
        Statement stmt=cn.createStatement();
        ResultSet rs=stmt.executeQuery(sql)) {
            while(rs.next()){
                list.add(new Apprenant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("filiere")));
            }
            
        } catch (SQLException e) {
            
        
        }
        return list;
    }

    public void save(Apprenant apprenant){
        String sql="insert into etudiant (nom, prenom, email, filiere) values (?, ?, ?, ?)";
        try (Connection cn=ConnectionFactory.getConnection();
        PreparedStatement ps=cn.prepareStatement(sql)) {
            ps.setString(1, apprenant.getNom());
            ps.setString(2, apprenant.getPrenom());
            ps.setString(3, apprenant.getEmail());
            ps.setString(4, apprenant.getFiliere());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'apprenant", e);
        }
    }

}
