package gui.events;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FilterFile extends FileFilter {
    private String description;
    private String extenstion;

    public FilterFile(String ext, String desc) {
        extenstion  = ext;
        description = desc;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }

        String filepath = file.getAbsolutePath();

        if (filepath.endsWith(extenstion)) {
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {

        // TODO Auto-generated method stub
        return description;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
