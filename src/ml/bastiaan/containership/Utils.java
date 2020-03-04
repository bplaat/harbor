// Made by Bastiaan van der Plaat (0983259) from TINPRO02-3 or TINPRO03-1

package ml.bastiaan.containership;

public class Utils {
    public static int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
