package tree.family.util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * Image util class
 * Every useful method which is needed more than once is defined in this class
 */
public class ImageUtil {
    /**
     * Method to save the pane to the corresponding image file
     *
     * @param pane: The pane which will be saved
     * @param file: The image file where the pane will be saved
     */
    public static void savePaneToImage(Pane pane, File file) {
        Scene scene = new Scene(pane);

        WritableImage writableImage = new WritableImage((int) pane.getPrefWidth(), (int) pane.getPrefHeight());
        pane.snapshot(null, writableImage);
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);

        if (file != null) {
            try {
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
