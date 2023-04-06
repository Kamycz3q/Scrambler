# Scrambler
Scramble words or files into themselves or new file!

Arguments

-word [word] -> scramble word or words

-file [path to file/filename] -> scramble file content and save into same file if -newfile not provided !!! Must Exist !!!

-newfile [path to file/filename] -> scramble file content into new file (Don't need to exist)

Examples

java -jar Scrambler.jar -word this is a word
java -jar Scrambler.jar -file test.txt
java -jar Scrambler.jar -file test.txt -newfile test2.txt
