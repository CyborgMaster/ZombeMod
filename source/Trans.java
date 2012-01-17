
import java.io.*;
import java.util.*;

public final class Trans {

    private static HashMap<String,String> map = new HashMap<String,String>();

    private static void readConfig() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("rename.txt"));
        String line;
        while((line = reader.readLine()) != null) {
            String got[] = line.replaceAll("\\A[\\t ]*","").replaceAll("[\\t ]*(|//.*)\\z","").split("[ \\t]+");
            if(got.length != 2) continue;
            got[0] = "(\\W|\\A)"+got[0]+"(\\W|\\z)";
            if(map.containsKey(got[0])) throw new Exception("Duplicate key : "+got[0]);
            //System.out.println("map: "+got[0]+" "+got[1]);
            map.put(got[0], "$1"+got[1]+"$2");
        }
    }
    
    private static String transform(String str) {
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
            str = str.replaceAll(entry.getKey() ,entry.getValue());
        }
        return str;
    }

    private static void handleFile(String fnIn) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fnIn));
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) builder.append(line).append("\n");
        String fnOutName = transform(fnIn);
        String fnOut = "tmp/"+fnOutName;
        FileWriter writer = new FileWriter(fnOut);
        writer.write(transform(builder.toString()));
        writer.close();
        
        exec("javac -O -cp class_out;class_in;class_in/lwjgl.jar;class_in/lwjgl_util.jar;class_in/jinput.jar;tmp -d class_out "+fnOut);
        exec("java Obfus class_out class_jar "+fnOutName.substring(0, fnOutName.length() - 5));
    }
    
    private static void exec(String cmd) throws Exception {
        System.out.println("Cmd: \""+cmd+"\"");
        Process process = Runtime.getRuntime().exec(cmd, null);
        StringWriter output = new StringWriter();
        InputStream stream = process.getErrorStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        // dirty hack
        do {
            int n;
            char[] buffer = new char[1024];
            while((n = reader.read(buffer)) != -1) output.write(buffer, 0, n);
            try {
                process.exitValue();
                break;
            } catch(IllegalThreadStateException whatever) { Thread.sleep(10); }
        } while(true);
        // dump it
        System.out.println(output.toString());
    }
    
    public static void main (String[] args) {
        try {
            if(args.length != 1) return;
            readConfig();
            handleFile(args[0]);
        } catch(Exception error) {
            error.printStackTrace(System.out);
        }
    }
}
