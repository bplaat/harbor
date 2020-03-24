// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 this is my first try

package ml.bastiaan.harbor;

import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

// The utils class contains small utilities
public class Utils {
    // A inclusive random in range number generator
    public static int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    // A jar resource image loader and resizer
    public static ImageIcon loadImage(String filename, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(Utils.class.getResource("/resources/" + filename));
            return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Let a thread sleep / wait for a short time
    public static void threadWait() {
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
