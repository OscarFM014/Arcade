
import java.applet.AudioClip;
public class WAudio {
	    public AudioClip getAudio(String direccion) {
	        return java.applet.Applet.newAudioClip(getClass().getResource(direccion));
	 }  
}

