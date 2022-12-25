package dev.lupluv.challenges;

import dev.lupluv.challenges.challenges.ChallengeManager;
import dev.lupluv.challenges.commands.ChallengesCmd;
import dev.lupluv.challenges.files.FileProvider;
import dev.lupluv.challenges.inventories.MainInventory;
import dev.lupluv.challenges.util.DisableReason;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Challenges extends JavaPlugin {

    // plugin instance
    private static Challenges instance;

    // important vars
    public String SELECTED_LANGUAGE;

    // Providers
    private FileProvider fileProvider;

    // Managers
    private ChallengeManager challengeManager;

    // Inventories and click handlers
    private MainInventory mainInventory;

    // Commands
    private ChallengesCmd challengesCmd;

    // Listeners

    @Override
    public void onLoad() {

        // First initialize the plugin instance
        instance = this;

        // Loading file data
        fileProvider = new FileProvider("plugins//Challenges");

        // setting SELECTED_LANGUAGE from config
        SELECTED_LANGUAGE = fileProvider.getConfigFile().asConfig().getString("selected_language");

    }

    @Override
    public void onEnable() {

        // Loading mysql connection

        // Initialize inventories
        mainInventory = new MainInventory();

        // Initialize commands
        challengesCmd = new ChallengesCmd();

        // Register event handlers
        registerEventHandlers(getServer().getPluginManager());

        // Register commands

        // Initialize Managers
        challengeManager = new ChallengeManager();


    }

    public void disableChallengesPlugin(DisableReason disableReason){
        getServer().getLogger().log(Level.WARNING, "§cDisabling §7Challenges Plugin");
        getServer().getLogger().log(Level.WARNING, "§cReason: " + disableReason.getMessage());
        getServer().getPluginManager().disablePlugin(instance);
    }

    private void registerCommand(String name, CommandExecutor commandExecutor){
        PluginCommand pluginCommand = getCommand(name);
        if(pluginCommand == null) {
            disableChallengesPlugin(DisableReason.COMMAND_NOT_FOUND("/" + name));
            return;
        }
        pluginCommand.setExecutor(commandExecutor);
    }

    private void registerCommands(){
        registerCommand("challenges", challengesCmd);
    }

    private void registerEventHandlers(PluginManager pm){
        pm.registerEvents(mainInventory, instance);
    }

    @Override
    public void onDisable() {

    }

    // getters

    public static Challenges getInstance() {
        return instance;
    }

    public String getSELECTED_LANGUAGE() {
        return SELECTED_LANGUAGE;
    }

    public FileProvider getFileProvider() {
        return fileProvider;
    }

    public MainInventory getMainInventory() {
        return mainInventory;
    }

    public ChallengeManager getChallengeManager() {
        return challengeManager;
    }
}
