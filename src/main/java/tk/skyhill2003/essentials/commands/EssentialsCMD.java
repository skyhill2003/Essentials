package tk.skyhill2003.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.skyhill2003.essentials.utils.Variable;

public class EssentialsCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player) {
            if(player.hasPermission("")) {
                if (args.length == 0) {
                    player.sendMessage(Variable.prefix + Variable.rightUse + args);
                }

                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("help")) {

                    }

                    if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {

                    }

                }
            } else {
                player.sendMessage(Variable.noPermissions);
            }
        }
        return false;
    }
}
