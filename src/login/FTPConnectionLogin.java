package login;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPConnectionLogin {

    private static void reponseServeur(FTPClient ftpClient) {
        String[] reponses = ftpClient.getReplyStrings();
        if (reponses != null && reponses.length > 0) {
            for (String reponse : reponses) {
                System.out.println("SERVEUR: " + reponse);
            }
        }
    }

    public static void main(String[] args) {
        boolean success = false;
        String server = "192.168.43.214";
        int port = 21;
        String password = "yassine123";
        String username = "yassine";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            reponseServeur(ftpClient);
            int reponse = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reponse)) {
                System.out.println("Operation échoué. Réponse Serveur: " + reponse);
                return;
            }
            boolean etat = ftpClient.login(username, password);
            reponseServeur(ftpClient);
            if (!etat) {
                System.out.println("Impossible d'accéder au serveur");
                return;
            } else {
                System.out.println("Identification réussie");
                ftpClient.enterLocalPassiveMode();
                ftpClient.changeWorkingDirectory("C:/Users/Yassine/Desktop/log");
                ftpClient.setFileType(FTP.ASCII_FILE_TYPE);


                Date d = new Date();
                File f = new File("C:/Users/Yassine/Desktop/" + (d.getYear() + 1900) + "/" + (1 + d.getMonth()) + "/" + d.getDate());
                f.mkdirs();

                if (null == ftpClient.getSystemName()) {
                    //use parserKey,pathName method signature
                    ftpClient.listFiles("WINDOWS", null);
                } else {
                    FTPFile[] files1 = ftpClient.listFiles();

                    for (FTPFile fichier : files1) {
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
                                File downloadFile1 = new File(f.getAbsolutePath() + "/" + fichier.getName());
                                OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                                boolean success1 = ftpClient.retrieveFile(remoteFile1, outputStream1);
                                outputStream1.close();

                                success = true;
                            }

                        }

                    }

                }
            }
        } catch (IOException ex) {
            System.out.println("Une erreur lors de la connexion a été détecté");
            ex.printStackTrace();
        }

        if (success) {
            System.out.println("Files were downloaded successfully.");
        } else {
            System.out.println("There is no new files");
        }
    }

    public static void getFile(URL u) throws IOException {
        String FileName = u.getFile();
        FileName = FileName.substring(FileName.lastIndexOf('/') + 1);
        //Open your local db as the input stream
        URLConnection uc = u.openConnection();
        String FileType = uc.getContentType();
        int FileLenght = uc.getContentLength();
//        if (FileLenght == -1) {
//            throw new IOException("Fichier non valide.");
//        }
        InputStream myInput = uc.getInputStream();
        // Path to the just created empty db
        Date d = new Date();
        String outFileName = "C:/Users/Yassine/Desktop/" + (d.getYear() + 1900) + "/" + (1 + d.getMonth()) + "/" + d.getDate() + "/" + FileName;
        //Open the empty db as the output stream
        File out = new File(outFileName);
        OutputStream myOutput = null;
        try {
            myOutput = new FileOutputStream(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        try {
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            //Close the streams 
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
