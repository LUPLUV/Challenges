package dev.lupluv.challenges.commands;

import dev.lupluv.challenges.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChallengesCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player player)){
            sender.sendMessage(MessageUtil.getMessage("not_a_console_command"));
            return true;
        }

        if(!player.hasPermission("challenges.command.challenges")){
            player.sendMessage(MessageUtil.getMessage("no_perms"));
            return true;
        }

        if(args.length == 0){

        }

        return false;
    }
}
