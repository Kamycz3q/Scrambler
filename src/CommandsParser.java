public class CommandsParser {
    private static boolean stop = false;
    public static void RunArgs(String[] args) {
        for (int i = 0;i<args.length;i++) {
            switch (args[i].toLowerCase()) {
                //run word mode
                case "-word": {
                    String createWord = "";
                    for (int y = i+1;y<args.length;y++) {
                        createWord += args[y];
                        if (y < args.length-1) {
                            createWord += " ";
                        }
                    }
                    System.out.println(String.format("Scrambled '%s' word: ", createWord));
                    System.out.println(Scrambler.getScrambledWord(createWord));
                    stop = true;
                    break;
                }
                //run file mode
                case "-file": {
                    String selectedFileName = args[i+1];
                    String newFileName = null;
                    Boolean copyNewLines = false;
                    //look for newFile
                    for (int y = i+1;y<args.length;y++) {
                        if (args[y].toLowerCase().equals("-newfile")) {
                            newFileName = args[y+1];
                        }

                    }
                    Scrambler.scrambleFile(selectedFileName, newFileName);
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }


        }
    }
}
