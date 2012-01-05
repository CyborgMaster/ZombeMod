
import java.io.*;
import java.util.*;

public final class Obfus {

    private static void handleFile(String src, String dst, String fnSrc) throws Exception {
        String fnDst = fnSrc;
        if(fnSrc.equals("if.class")) fnDst = "i_.class";
        else if(fnSrc.equals("do.class")) fnDst = "d_.class";
        else if(fnSrc.equals("i_.class")) fnDst = "if.class";
        else if(fnSrc.equals("d_.class")) fnDst = "do.class";
        fnDst = dst + "/" + fnDst;
        fnSrc = src + "/" + fnSrc;
        System.out.println("Flipping: "+fnSrc+" -> "+fnDst);
        
        File fhSrc = new File(fnSrc);
        File fhDst = new File(fnDst);
        
        byte[] data = new byte[(int)fhSrc.length()];

        FileInputStream is = new FileInputStream(fhSrc);
        if(is.read(data) != data.length) throw new Exception("Read failed");
        is.close();
        
        int i = 0;
        while(i < data.length) {
            if(data.length - i > 4) {
                if((data[i] == 'L' && data[i+3] == ';') || (data[i] == 2 && data[i+3] == 1)) {
                    if(data[i+1] == 'i' && data[i+2] == 'f') data[i+2] = '_';
                    else if(data[i+1] == 'i' && data[i+2] == '_') data[i+2] = 'f';
                    else if(data[i+1] == 'd' && data[i+2] == 'o') data[i+2] = '_';
                    else if(data[i+1] == 'd' && data[i+2] == '_') data[i+2] = 'o';
                }
            }
            i++;
        }
        
        FileOutputStream os = new FileOutputStream(fhDst);
        os.write(data);
        os.close();
    }
    
    public static void main (String[] args) {
        try {
            if(args.length != 3) return;
            String[] files = args[2].split(";");
            for(int i=0;i<files.length;i++) if(files[i].length() > 0) handleFile(args[0], args[1], files[i] + ".class");
        } catch(Exception error) {
            error.printStackTrace(System.out);
        }
    }

}
