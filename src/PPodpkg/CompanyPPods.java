package PPodpkg;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Classe que representa um conjunto de PPods de um empresa
 * </p>
 */

public class CompanyPPods {

    /**
     * Set of PPods
     */
    private PPod[] players;

    /**
     * Parameterized constructor of CompanyPPods.
     * 
     * @param players Set of PPods
     */
    public CompanyPPods(PPod[] players) {
        this.players = players;
    }
    
    public int getGlobalAddFileFailures(){
        int i=0, j=players.length, failures=0;
        while( i<j && players[i] != null ){
            failures += players[i].getAddFileFailures();
            i++;
        }
        return failures;
    }
    
}
