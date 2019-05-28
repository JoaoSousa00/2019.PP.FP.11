package Tries;

import Enumerations.Extension;
import Enumerations.Reordena;
import PPodpkg.*;

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
 * 
 * </p>
 */

public class Demo {
    
    
    public static void main(String[] args) {
        
        File f1 = new File("Diogo", Extension.mp3, 12000, 3.23);
        File f2 = new File("António", Extension.mp3, 10340, 2.53);
        File f3 = new File("José", Extension.mp3, 17000, 4.03);
        File f4 = new File("txt 1", Extension.txt, 450, 3.23);
        File f5 = new File("txt 2", Extension.txt, 0, 0);
        
        PPod MP = new PPod(Reordena.name);
        
        MP.addFile(f1);
        MP.addFile(f2);
        MP.addFile(f3);
        MP.addFile(f4);
        MP.deleteFile(4);
        
        MP.playTrack(1);
        MP.nextTrack();
        MP.nextTrack();
        
        MP.shufflePlay();
        MP.playTrack(1);
        MP.nextTrack();
        MP.nextTrack();
        
        MP.listValidFiles();
        
        
        // Contagem de Exceções
        
        PPod MP1 = new PPod(Reordena.name);
        
        MP1.addFile(f1);
        MP1.addFile(f2);
        MP1.addFile(f3);
        MP1.addFile(f5);
        
        PPod[] MPA = new PPod[2];
        
        MPA[0] = MP;
        MPA[1] = MP1;
         
        CompanyPPods CPP = new CompanyPPods(MPA);
        System.out.println(CPP.getGlobalAddFileFailures());
        
        // Ficha 12
        
        MP.backup("");
        
        PPod MP2 = new PPod(Reordena.dura);
        MP2.recover("");
        MP2.listValidFiles();
    }
    
}
