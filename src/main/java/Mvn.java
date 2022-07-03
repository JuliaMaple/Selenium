import org.apache.commons.io.FileUtils;

public class Mvn {

    public static void main(String[] args) {
        String temp = FileUtils.getUserDirectoryPath();
        System.out.println(temp);
    }

}
