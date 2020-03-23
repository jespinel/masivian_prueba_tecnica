import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author jespinel
 */
public class Parser {

    private File file;

    public Parser(File _file) {
        file = _file;
    }

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        FileInputStream i = new FileInputStream(file);
        StringBuffer output = new StringBuffer();
        int data;
        while ((data = i.read()) > 0) {
            output.append((char) data);
        }
        return output.toString();
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        FileInputStream i = new FileInputStream(file);
        StringBuffer output = new StringBuffer();
        int data;
        while ((data = i.read()) > 0) {
            if (data < 0x80) {
                output.append((char) data);
            }
        }
        return output.toString();
    }

    public synchronized void saveContent(String content) throws FileNotFoundException {
        FileOutputStream o = new FileOutputStream(file);
        try {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
