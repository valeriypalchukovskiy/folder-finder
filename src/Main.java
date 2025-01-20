import java.io.File;

public class Main {
    public static void main(String[] args)
    {
        String folderPath = "/C:/Users/123/Desktop/Акты для работы ГБУ";

        String folderPath2 = "/C:/Users/123/Desktop/nekoray";

        File file = new File(folderPath2);

        System.out.println(getFolderSize(file));
    }

    public static long  getFolderSize (File folder){
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file:files)
        {
            sum += getFolderSize(file);
        }
        return sum;
    }
}