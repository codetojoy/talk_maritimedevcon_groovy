
import static groovy.io.FileType.FILES

def ERROR_REGEX = /.*ERROR.*code.(\d+).*account id: (\d+)$/

def mapCodeToAccountId = [:].withDefault { key -> [] }

// -------- main

def root = new File(args[0])

root.eachFileRecurse (FILES) { file ->
    file.eachLine { line ->
        def matcher = (line =~ ERROR_REGEX)
 
        if (matcher.matches()) {
            def errorCode = matcher[0][1]
            def accountId = matcher[0][2]

            mapCodeToAccountId[errorCode] << accountId 
        }
    }
}

mapCodeToAccountId.each { key, value ->
    println "for code ${key} , account ids: " + value
}

