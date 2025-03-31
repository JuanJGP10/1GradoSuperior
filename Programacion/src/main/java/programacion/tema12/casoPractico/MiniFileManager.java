
package programacion.tema12.casoPractico;

import java.io.File;

class MiniFileManager {

    public String getPwd(File f) {
        return f.getAbsolutePath();
    }

}