// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.harbor;

import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Utils {
    public static int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    public static ImageIcon loadImage(String filename, int width, int height) {
        try {
            BufferedImage image = ImageIO.read(Utils.class.getResource("/resources/" + filename));
            return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void threadWait() {
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
