package Enumerations;

/**
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Enumeração que
 * </p>
 */
public enum Extension {
        mp3, mp4, txt;
        
        public String ExtensionToString(Extension extension){
            switch(extension){
                case mp3: return ".mp3";
                case mp4: return ".mp4";
                case txt: return ".txt";
                default: return "Indefinido";
            }
        }
}
