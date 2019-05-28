package PPodpkg;

import Interfaces.PPodService;
import Enumerations.Extension;
import Enumerations.Reordena;
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
     * Reorders the player files according to an algorithm
     */
    private Reordena reordena;
    
    /**
     * Number of files exceptions in the add method
     */
    private int addFileFailures;

    /**
     * Non parameterized Constructor of PPod.
     * Limits the number of files to 20.
     * The starting Free Space of the player is 100000 KB.
     * @param reordena Algotithm to reorder the player files
     */
    public PPod(Reordena reordena) {
        this.FreeSpace = 100000;
        this.files = new File[MAX_FILES];
        this.reordena = reordena;
        this.addFileFailures = 0;
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
    
    /**
     * @return the addFileFailures
     */
    public int getAddFileFailures() {
        return addFileFailures;
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
        
        if( file.getSize() <= 0 )
            throw new FileSizeNullException("Erro | Tamanho do ficheiro inválido.");
        
        this.files[ this.countFiles() ] = file;
        done = true;
        System.out.println("Ficheiro adicionado.");
        this.FreeSpace = this.FreeSpace - file.getSize();
                    
        } catch( FileNullException | SpaceLeakException | FilesNumberException | FileSizeNullException e ){
            addFileFailures ++;
        }
        
        return done;
    }

    @Override
    public boolean deleteFile(int index) {
        boolean done = false;
        int i=0;
        try{
            if( index<1 && index>this.countFiles() )
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
            if( index < 0 && index > this.countFiles() )
                throw new IndexOutOfBoundException("Erro | Index errado.");
            
            if( this.files[ index - 1 ].getExtension() != Extension.mp3 )
                throw new FileExtensionException("Erro | Extensão errada.");
            
            if( this.files[ index - 1 ].getDuration() <= 0 )
                throw new FileDurationException("Erro | Duração errada.");
            
            this.currentIndex = index;
            System.out.println( "Ficheiro " + this.currentIndex + ": " + this.files[ this.currentIndex - 1 ].getName() );
            System.out.println( "Duração: " + this.files[ this.currentIndex - 1 ].getDuration() + " segundos\n" );
            
        } catch( IndexOutOfBoundException | FileExtensionException | FileDurationException e ) {}
    }
    
    /**
     * 
     * @return 
     */
    public boolean shufflePlay() {
        
        boolean done = false;
        
        switch (this.reordena) {
            case name:
                for (int j=0; j<countFiles()-1; j++){
                    for (int i=1; i<countFiles(); i++){
                        if( files[j].getName().compareToIgnoreCase(files[i].getName()) > 0 ){
                            File tmp = files[i];
                            files[i] = files[j];
                            files[j] = tmp;
                        }
                    }
                }
                done = true;
                System.out.println("Player reordenado por nome.\n");
                break;
                
            case size:
                for (int j=0; j<countFiles()-1; j++){
                    for (int i=1; i<countFiles(); i++){
                        if( files[j].getSize() < files[i].getSize() ){
                            File tmp = files[i];
                            files[i] = files[j];
                            files[j] = tmp;
                        }
                    }
                }
                done = true;
                System.out.println("Player reordenado por tamanho.\n");
                break;
                
            case dura:
                for (int j=0; j<countFiles()-1; j++){
                    for (int i=1; i<countFiles(); i++){
                        if( files[j].getDuration() > files[i].getDuration() ){
                            File tmp = files[i];
                            files[i] = files[j];
                            files[j] = tmp;
                        }
                    }
                }
                done = true;
                System.out.println("Player reordenado por duração.\n");
                break;
                
            default:
                break;
        }
        
        return done;
    }
    
    public void listValidFiles(){
        
        try{
            System.out.println("\n\t*** Lista de Ficheiros Válidos ***\t\n");
            
            for( int i=0; i<countFiles(); i++){
        
                if( this.files[i].getExtension() != Extension.mp3 )
                    throw new FileExtensionException("Erro | Extensão errada.");
        
                if( this.files[i].getDuration() <= 0 )
                    throw new FileDurationException("Erro | Duração errada.");
                
                System.out.println( "|Ficheiro " + (i+1) + ": " + this.files[i].getName() );
            }
        } catch( FileExtensionException | FileDurationException e){}
        
    }
    
    @Override
    public void nextTrack() {
        if(this.currentIndex == this.countFiles())
            this.currentIndex = 1;
        else
            this.currentIndex++;
        this.playTrack(this.currentIndex);
    }

    @Override
    public void previousTrack() {
        if(this.currentIndex==1)
            this.currentIndex = this.countFiles();
        else
            this.currentIndex--;
        this.playTrack(currentIndex);
    }
    
}
