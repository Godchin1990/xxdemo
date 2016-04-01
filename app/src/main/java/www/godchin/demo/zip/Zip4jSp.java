package www.godchin.demo.zip;

import android.text.TextUtils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

import java.io.File;

public class Zip4jSp {
    public interface ZipProcess {
        void start();

        void error();

        void completed();

        void handling(int percentDone);
    }

    public static void Unzip(final File zipFile, String dest, String passwd, String charset, final ZipProcess handler, final boolean isDeleteZipFile) throws Exception {
        ZipFile zFile = new ZipFile(zipFile);
        if (TextUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }
        zFile.setFileNameCharset(charset);
        if (!zFile.isValidZipFile()) {
            throw new ZipException("Compressed files are not illegal, may be damaged.");
        }
        File destDir = new File(dest); // Unzip directory
        if (destDir.isDirectory() && !destDir.exists()) {
            destDir.mkdir();
        }
        if (zFile.isEncrypted()) {
            zFile.setPassword(passwd.toCharArray());
        }

        final ProgressMonitor progressMonitor = zFile.getProgressMonitor();
        Thread progressThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    int percentDone = 0;
                    if (handler == null) {
                        return;
                    }
                    handler.start();
                    while (true) {
                        Thread.sleep(1000);
                        percentDone = progressMonitor.getPercentDone();
                        handler.handling(percentDone);
                        if (percentDone >= 100) {
                            break;
                        }
                    }
                    handler.completed();
                } catch (InterruptedException e) {
                    handler.error();
                    e.printStackTrace();
                } finally {
                    if (isDeleteZipFile) {
                        zipFile.deleteOnExit();
                        //zipFile.delete();
                    }
                }
            }
        });
        progressThread.start();
        zFile.setRunInThread(true);
        zFile.extractAll(dest);
    }
}

/**
 * ps:
 * (1)、字符集默认采用UTF-8
 * (2)、解压文件在线程中进行，所以需要setRunInThread(true).由于采用线程中解压文件，所以调用该函数时相当于异步执行，调用代码会直接往下走，需要注意并加以处理。
 * (3)、进度条另开了一个线程来处理，并将处理的结果以handler的形式发送
 * (4)、使用zipFile.deleteOnExit()而不是zipFile.delete();因为使用线程解压时，虽然从progressMonitor获得的percentDone已经达到了100，而事实上数据并没有完全解压完成。
 * 这时退出循环执行finally的delete函数，如果使用zipFile.delete()，将会删除文件，这样会使后续的解压失败。
 * 而使用zipFile.deleteOnExit()函数，该函数是当VM终止时才会删除文件，与zipFile.delete()删除文件不同。
 * APP在运行时，VM始终是在的，所以这样删除可以确保后续的解压能够正常进行。或者不去删除文件。
 * (5)、handler的代码见后文的MainActivity.java。
 */