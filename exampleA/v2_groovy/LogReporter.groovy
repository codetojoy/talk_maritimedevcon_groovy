
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LogReporter {
    private Pattern ERROR_REGEX = Pattern.compile(".*ERROR.*code.(\\d+).*account id: (\\d+)");
    private Map<String,List<String>> mapCodeToAccountId = new HashMap<>();

    private void processLine(String line) {
        Matcher matcher = ERROR_REGEX.matcher(line);
   
        if (matcher.matches()) {
            String errorCode = matcher.group(1);
            String accountId = matcher.group(2);

            if (mapCodeToAccountId.get(errorCode) == null) {
                mapCodeToAccountId.put(errorCode, new ArrayList<String>());
            } 

            mapCodeToAccountId.get(errorCode).add(accountId);
        }
    }

    private void processFile(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;  

            while ((line = br.readLine()) != null)  {  
                processLine(line);
            } 
        } catch (IOException ex) {
        }
    }

    public void processFiles(File... files) {
        for (File file : files) {
            if (file.isDirectory()) {
                processFiles(file.listFiles()); 
            } else {
                processFile(file);
            }
        }
    }

    public static void main(String... args) throws Exception {
        LogReporter logReporter = new LogReporter();
        File root = new File(args[0]);

        logReporter.processFiles(root);

        for (String errorCode : logReporter.mapCodeToAccountId.keySet()) {
            List<String> accountIds = logReporter.mapCodeToAccountId.get(errorCode);
            System.out.println("for code " + errorCode + " , account ids: " + accountIds);
        }
    }
}
