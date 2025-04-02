package programacion.tema12.casoPractico;

import java.io.File;

class MiniFileManager {

    public String getPwd() {
        return MiniTerminal.getDirectorioActual().getPath();
    }

    public void cd(String dir) {
        File file = new File(getPwd() + "/" + dir);

        if (dir.equals("..")) {
            File back = new File(MiniTerminal.getDirectorioActual().getParent());
            MiniTerminal.getDirectorioActual().renameTo(back);
        }

        if (file.isDirectory()) {
            MiniTerminal.getDirectorioActual().renameTo(file);
        } else
            System.out.println("El nombre del directorio no es valido");
    }

}