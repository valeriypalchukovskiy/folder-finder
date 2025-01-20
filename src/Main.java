import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args)
    {


//
//        MyThread thread = new MyThread(1);
//        MyThread thread2 = new MyThread(2);
//        thread.start();
//        thread2.start();
        String folderPath = "/C:/Users/123/Desktop/Акты для работы ГБУ";
        String folderPath2 = "/C:/Users/123/Desktop";

        File file = new File(folderPath2);
        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size =  pool.invoke(calculator);
        System.out.println(size);

        long end = System.currentTimeMillis() - start;
        System.out.println(end);
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