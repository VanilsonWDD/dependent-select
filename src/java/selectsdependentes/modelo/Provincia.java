/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selectsdependentes.modelo;

/**
 *
 * @author Vanilson
 */
public class Provincia {
    private int codigoProvincia;
    private String nomeProvincia;
    private Pais pais;

    public Provincia() {
    }

    public int getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(int codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
}
