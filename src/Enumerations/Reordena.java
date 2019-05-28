package Enumerations;

/**
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Enumeração que
 * </p>
 */
public enum Reordena {
    name, size, dura;
        
        public String ReordenaToString(Reordena reordena){
            switch(reordena){
                case name: return "Nome do ficheiro de forma ascendente";
                case size: return "Tamanho do ficheiro de forma descendente";
                case dura: return "Duração do ficheiro de forma ascendente";
                default: return "Indefinido";
            }
        }
}
