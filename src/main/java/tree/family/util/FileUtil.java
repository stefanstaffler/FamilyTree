package tree.family.util;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

/**
 * File util class
 * Every useful method which is needed more than once is defined in this class
 */
public class FileUtil {
    /**
     * Return the file where the pane will be saved
     *
     * @param window: Parent window of file chooser dialog
     * @return the file
     */
    public static File getTargetImageFile(Window window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        return fileChooser.showSaveDialog(window);
    }
}
