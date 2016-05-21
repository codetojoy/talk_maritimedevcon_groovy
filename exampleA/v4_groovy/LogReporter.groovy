
// optional typing
// collection literals
// regex support
// file support
// script for 'main'

class LogReporterImpl {
    private def ERROR_REGEX = ".*ERROR.*code.(\\d+).*account id: (\\d+)"
    private def mapCodeToAccountId = [:]

    private void processLine(String line) {
        def matcher = (line =~ ERROR_REGEX)
   
        if (matcher.matches()) {
            String errorCode = matcher.group(1)
            String accountId = matcher.group(2)

            if (mapCodeToAccountId.get(errorCode) == null) {
                mapCodeToAccountId.put(errorCode, [])
            } 

            mapCodeToAccountId.get(errorCode).add(accountId)
        }
    }

    private void processFile(File file) {
        file.eachLine { line ->
            processLine(line)
        }
    }

    void processFiles(File root) {
        root.eachFileRecurse { file ->
            if (file.isFile()) {
                processFile(file)
            }
        }
    }
}

// ---- main

LogReporterImpl logReporter = new LogReporterImpl()
File root = new File(args[0])

logReporter.processFiles(root)

for (String errorCode : logReporter.mapCodeToAccountId.keySet()) {
    List<String> accountIds = logReporter.mapCodeToAccountId.get(errorCode)
    System.out.println("for code " + errorCode + " , account ids: " + accountIds)
}
