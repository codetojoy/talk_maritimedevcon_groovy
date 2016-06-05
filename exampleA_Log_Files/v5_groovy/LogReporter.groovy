
def ERROR_REGEX = /.*ERROR.*code.(\d+).*account id: (\d+)$/

def mapCodeToAccountId = [:].withDefault { key -> [] }

def processLine = { line ->
    def matcher = (line =~ ERROR_REGEX)
 
    if (matcher.matches()) {
        def errorCode = matcher[0][1]
        def accountId = matcher[0][2]

        mapCodeToAccountId[errorCode] << accountId 
    }
}

def processFile = { file ->
    file.eachLine { line ->
        processLine(line)
    }
}

def processFiles = { root ->
    root.eachFileRecurse { file ->
        if (file.isFile()) {
            processFile(file)
        }
    }
}

// -------- main

def root = new File(args[0])

processFiles(root)

mapCodeToAccountId.each { errorCode, accounts ->
    println "for code ${errorCode} , account ids: " + accounts
}

