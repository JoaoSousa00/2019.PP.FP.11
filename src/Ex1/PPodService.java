package Ex1;

/**
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Interface que representa os métodos a implementar pelo player
 * </p>
 */
public interface PPodService {

    /**
     * Adicionar um ficheiro ao player.
     * Deve lidar com as exceções que ocorram ao longo do programa 
     * (null references, memória cheia, ou máximo de ficheiros atingido).
     * 
     * @param file ficheiro a adicionar ao player
     * @return 
     */
    public boolean addFile(File file);
    
    /**
     * Apagar um ficheiro do player.
     * Este método deve contemplar a exceção de índices inválidos. 
     * Esta operação só está disponível se existirem álbuns armazenados.
     * 
     * @param index número do ficheiro para eliminar
     * @return 
     */
    public boolean deleteFile(int index);
    
    /**
     * Tenta reproduzir a faixa no índice indicado. 
     * A reprodução da faixa corresponde simplesmente a imprimir no ecrã os 
     * respectivos valores de “nome” e “duração”.
     * Este método deve contemplar a exceção de índices inválidos ou para 
     * ficheiros com extensões não suportadas.
     * 
     * @param index número do ficheiro para tocar
     * @return 
     */
    public void playTrack(int index);
    
    /**
     * Avança para a faixa seguinte, “reproduzindo-a” automaticamente. 
     * Caso não seja possível reproduzir o ficheiro corrente, deve saltar 
     * automaticamente para a faixa seguinte até encontrar um ficheiro passível
     * de ser reproduzido.
     * 
     * @return 
     */
    public void nextTrack();
    
    /**
     * Recua para a faixa anterior, “reproduzindo-a” automaticamente. 
     * Caso não seja possível reproduzir o ficheiro na faixa corrente, deve 
     * saltar automaticamente para a faixa anterior até encontrar um ficheiro 
     * passível de ser reproduzido.
     * 
     * @return 
     */
    public void previousTrack();
    
}
