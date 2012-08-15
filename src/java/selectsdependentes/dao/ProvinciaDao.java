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
import selectsdependentes.modelo.Provincia;

/**
 *
 * @author Vanilson
 */
public class ProvinciaDao {

    private Connection conexao;
    private ResultSet rs;
    private PreparedStatement ps;

    public ProvinciaDao() {
    }

    public List<Provincia> pesquisarProvinciaPorPais(int codigo) {
        List<Provincia> lp = new ArrayList<Provincia>();

        try {
            conexao = Conexao.getConnection();
            ps = conexao.prepareStatement("select pr.codigo_provincia, pr.nome_provincia from provincia pr, pais p "
                    + "where pr.codigo_pais = p.codigo_pais and pr.codigo_pais = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Não existem provincias cadastradas nesse pais");
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    Provincia p = new Provincia();
                    p.setCodigoProvincia(rs.getInt("codigo_provincia"));
                    p.setNomeProvincia(rs.getString("nome_provincia"));
                    lp.add(p);
                }
            }
        } catch (SQLException exception) {
            System.out.println("Impossivel visualizar provincias cadastradas nesse pais " + exception);
        }
        return lp;
    }
}
