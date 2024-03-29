package xyz.yarinlevi.zombieisland.classes.messages;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.yarinlevi.zombieisland.ZombieIsland;

public class PlaceholderHandler extends PlaceholderExpansion {
    private final ZombieIsland instance;

    public PlaceholderHandler(ZombieIsland plugin) {
        this.instance = plugin;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "zombieisland";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Quapi";
    }

    @Override
    public @NotNull String getVersion() {
        return instance.getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if(player == null){
            return "";
        }
        if (identifier.equalsIgnoreCase("version")) {
            return ZombieIsland.getInstance().getDescription().getVersion();
        }

        return "";
    }
}
