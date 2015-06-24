
package modelo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
    Clip clip;
    public void tocar(String som)
    {
    try {
           
            AudioInputStream audioInputStream
                    = AudioSystem.getAudioInputStream(getClass().getResource("../audio/"+som));
            clip = AudioSystem.getClip();

            clip.open(audioInputStream);

            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void parar()
    {
        if(clip!=null)
        {
            clip.stop();
        }
    }

}
