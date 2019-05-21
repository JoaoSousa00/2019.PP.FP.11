package Ex1;

import Exceptions.*;

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
 * Classe que representa o player a ser desenvolvido
 * </p>
 */

public class PPod implements PPodService{

    /**
     * Número máximo de ficheiros no player
     */
    private static final int MAX_FILES = 20;
    
    /**
     * Free Space on the player, in KB
     */
    private float FreeSpace;
    
    /**
     * List of files/musics
     */
    private File[] files;
    
    /**
     * Current Index of the file playing at the moment
     */
    private int currentIndex;

    /**
     * Non parameterized Constructor of PPod.
     * Limits the number of files to 20.
     * The starting Free Space of the player is 100000 KB.
     */
    public PPod() {
        this.FreeSpace = 100000;
        this.files = new File[MAX_FILES];
    }

    /**
     * Counts the number of files on the player.
     * 
     * @return the number of existing files
     */
    protected int countFiles(){
        int i=0;
        while(i<this.files.length && this.files[i]!=null){
            i++;
        }
        return i;
    }
    
    /**
     * @return the FreeSpace in MB
     */
    public float getFreeSpace() {
        return (FreeSpace*1000);
    }

    /**
     * @return the files
     */
    public File[] getFiles() {
        return files;
    }

    @Override
    public boolean addFile(File file) {
        boolean done = false;
        try{
        if( file == null )
            throw new FileNullException("Erro | Ficheiro Nulo.");
        
        if( file.getSize() > this.FreeSpace )
            throw new SpaceLeakException("Erro | Falta de memória.");
        
        if( this.countFiles()+1>PPod.MAX_FILES )
            throw new FilesNumberException("Erro | Limite de ficheiros atingido.");
        
        this.files[ this.countFiles() ] = file;
        done = true;
        System.out.println("Ficheiro adicionado.");
        this.FreeSpace = this.FreeSpace - file.getSize();
                    
        } catch( FileNullException | SpaceLeakException | FilesNumberException e ){}
        
        return done;
    }

    @Override
    public boolean deleteFile(int index) {
        boolean done = false;
        int i=0;
        try{
            if( index>0 && index<this.countFiles() )
                throw new IndexOutOfBoundException("Erro | Index errado.");
            
            for(i=index; i<this.countFiles(); i++){
                this.files[i-1] = this.files[i];
            }
            this.files[i-1] = null;
            done = true;
            System.out.println("Ficheiro removido.");
            
        } catch( IndexOutOfBoundException e ) {}
        
        return done;
    }

    @Override
    public void playTrack(int index) {
        try{
            if(index>0 && index<this.countFiles() )
                throw new IndexOutOfBoundException("Erro | Index errado.");
            if(index>0 && index<this.countFiles() )
                throw new ExtensionException("Erro | Extensão errada.");
            
            this.currentIndex = index;
            System.out.println( "Ficheiro " + this.currentIndex + ": " + this.files[ this.currentIndex - 1 ].getName() );
            System.out.println( "Duração: " + this.files[ this.currentIndex-1 ].getDuration() + " segundos\n" );
            
        } catch( IndexOutOfBoundException | ExtensionException e ) {}
    }

    @Override
    public void nextTrack() {
        if(this.currentIndex==20)
            this.currentIndex = 1;
        else
            this.currentIndex++;
        this.playTrack(currentIndex);
    }

    @Override
    public void previousTrack() {
        if(this.currentIndex==1)
            this.currentIndex = 20;
        else
            this.currentIndex--;
        this.playTrack(currentIndex);
    }
}
