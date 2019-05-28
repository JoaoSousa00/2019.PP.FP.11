package PPodpkg;

import Enumerations.Extension;

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
 * Classe que representa um ficheiro
 * </p>
 */

public class File {

    /**
     * Name of the file
     */
    private String name;
    
    /**
     * Extension of the file (ex: mp3, mp4 or txt)
     */
    private Extension extension;
    
    /**
     * Size of the file, in KB
     */
    private int size;
    
    /**
     * duration of the file, in seconds
     */
    private double duration;

    /**
     * Parameterized Constructor of file.
     * 
     * @param name Name of the file.
     * @param extension Extension of the file.
     * @param size Size of the file.
     * @param duration duration of the file.
     */
    public File(String name,Extension extension, int size, double duration) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.duration = duration;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the extension
     */
    public Extension getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    
    
}
