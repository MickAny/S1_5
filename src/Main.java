import java.io.*;

public class Main {
    public static void main(String[] args) {
        File dir1 = new File("D:\\IntelliJ IDEA\\Gb\\S1_5\\src\\Jk");
        System.out.println(backUpFiles(dir1));
    }

    public static boolean backUpFiles(File directory){

        if(!directory.exists()) return false;

        File backUpDirectory = new File("./backup");
        backUpDirectory.mkdir();

        File[] files = directory.listFiles();

        for (File file: files) {

            File backUpFile = new File(backUpDirectory.getPath(), file.getName());
            try(FileInputStream input = new FileInputStream(file);
                FileOutputStream output = new FileOutputStream(backUpFile)){

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1){
                    output.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return true;
    }
}
