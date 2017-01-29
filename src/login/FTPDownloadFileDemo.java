
package login;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class FTPDownloadFileDemo {

    public static void main(String[] args) {
        String server = "127.0.0.1";
        int port = 21;
        String password = "yassine123";
        String username = "yassine";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory("C:/Users/Yassine/Desktop/log");
            ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

// APPROACH #1: using retrieveFile(String, OutputStream)
            Date d = new Date();
            File f = new File("C:/Users/Yassine/Desktop/" + (d.getYear() + 1900) + "/" + (1 + d.getMonth()) + "/" + d.getDate());
            f.mkdirs();

            if (null == ftpClient.getSystemName()) {
                //use parserKey,pathName method signature
                System.out.println(ftpClient.listFiles("WINDOWS", null).length);
            } else {
                FTPFile[] files1 = ftpClient.listFiles();

                for (FTPFile fichier : files1) {
                    System.out.println(fichier.getName());
                    System.out.println(fichier.getName());
                    File[] listeFichiers = f.listFiles();

                    if (!fichier.getName().endsWith(".tmp")) {
                        boolean test = true;

                        for (File ff : listeFichiers) {
                            if (ff.getName().equals(fichier.getName())) {
                                test = false;
                            }
                        }

                        if (test) {
                            String remoteFile1 = "C:/Users/Yassine/Desktop/log/" + fichier.getName();
                            File downloadFile1 = new File(f.getAbsolutePath()+"/" + fichier.getName());
                            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
                            outputStream1.close();
                            if (success) {
                                System.out.println("Files were downloaded successfully.");
                            }
                        }

                    }

                }

            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
