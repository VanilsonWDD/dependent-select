/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selectsdependentes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import selectsdependentes.conexao.Conexao;
import selectsdependentes.modelo.Pais;

/**
 *
 * @author Vanilson
 */
public class PaisDao {
    private Connection conexao;
    private ResultSet rs;
    private PreparedStatement ps;

    public PaisDao() {
    }
    
    public List<Pais> visualizar() {
        List<Pais> lp = new ArrayList<Pais>();

        try {
            conexao = Conexao.getConnection();
            ps = conexao.prepareStatement("select *from pais");
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Não existem paises cadastrados");
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    Pais p = new Pais();
                    p.setCodigoPais(rs.getInt("codigo_pais"));
                    p.setNomePais(rs.getString("nome_pais"));
                    lp.add(p);
                }
            }
        } catch (SQLException exception) {
            System.out.println("Impossivel visualizar pais " + exception);
        }
        return lp;
    }    
}
