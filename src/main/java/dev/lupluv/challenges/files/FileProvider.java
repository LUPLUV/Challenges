package dev.lupluv.challenges.files;

import dev.lupluv.challenges.Challenges;

import java.util.Map;

public class FileProvider {

    public static String workingDirectory;

    private File folder;
    private File configFile;
    private File languageFolder;
    private Map<String, File> languageFiles;

    public FileProvider(String arg0){

        workingDirectory = arg0;

        folder = new File(workingDirectory);
        configFile = loadFile("config.yml");

    }

    public File getFolder() {
        return folder;
    }

    public File getConfigFile() {
        return configFile;
    }

    public File getLanguageFolder() {
        return languageFolder;
    }

    public Map<String, File> getLanguageFiles() {
        return languageFiles;
    }

    public File getSelectedLanguageFile(){
        return languageFiles.get(Challenges.getInstance().SELECTED_LANGUAGE);
    }

    public static File loadFile(String subPath){
        return new File(workingDirectory + "//" + subPath);
    }

}
