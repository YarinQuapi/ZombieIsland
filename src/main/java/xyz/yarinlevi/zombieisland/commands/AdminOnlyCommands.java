package xyz.yarinlevi.zombieisland.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import xyz.yarinlevi.zombieisland.ZombieIsland;
import xyz.yarinlevi.zombieisland.classes.custom.customspawns.regions.SpawnerManager;

import java.util.logging.Level;

public class AdminOnlyCommands extends BaseCommand {
    //TODO: Replace messages to new system

    @CommandAlias("ziadmin")
    @CommandPermission("zombieisland.admin")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("register")) {
                if (args[1].equalsIgnoreCase("spawners")) {
                    try {
                        SpawnerManager.registerSpawners();
                        ZombieIsland.getInstance().getLogger().log(Level.INFO, "ZiSpawners were successfully registered.");
                    } catch (Exception e) {
                        e.printStackTrace();
                        ZombieIsland.getInstance().getLogger().log(Level.SEVERE, "Something went wrong while registering spawners!");
                    }
                }
            } else if (args[0].equalsIgnoreCase("force")) {
                if (args[1].equalsIgnoreCase("save")) {
                    ZombieIsland.getInstance().getLogger().info("Forcibly saving data to MySQL (check that the mysql server wouldn't crash !:D )");
                    ZombieIsland.getInstance().save();
                }
            }
        }

        return false;
    }
}
