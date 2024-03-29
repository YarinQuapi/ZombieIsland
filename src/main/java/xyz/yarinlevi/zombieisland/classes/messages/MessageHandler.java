package xyz.yarinlevi.zombieisland.classes.messages;

import lombok.Getter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import xyz.yarinlevi.zombieisland.ZombieIsland;
import xyz.yarinlevi.zombieisland.classes.FileManager;

import java.io.File;
import java.util.HashMap;

public class MessageHandler {
    private final HashMap<String, String> messages = new HashMap<>();
    @Getter private final File file;
    @Getter private final FileConfiguration data;

    public MessageHandler() {
        file = new File(ZombieIsland.getInstance().getDataFolder(), "messages.yml");
        data = YamlConfiguration.loadConfiguration(file);

        FileManager.registerData(file, data);
        ConfigurationSection messageSection = data.getConfigurationSection("messages");

        if (messageSection != null) {
            ZombieIsland.getInstance().getLogger().warning("Loading messages..");
            messageSection.getKeys(false).forEach(key -> messages.put(key, ChatColor.translateAlternateColorCodes('&', messageSection.getString(key))));
            ZombieIsland.getInstance().getLogger().info("Successfully loaded " + messages.size() + " messages out of " + messageSection.getKeys(false).size() + " messages.");
        } else {
            ZombieIsland.getInstance().getLogger().severe("No messages were loaded! please check the file for errors.");
        }
    }

    public void testLoadedMessages() {
        StringBuilder stringBuilder = new StringBuilder("Loaded messages: \n");
        messages.forEach((key, value) -> stringBuilder.append(key).append(": ").append(value).append("\n"));
        ZombieIsland.getInstance().getLogger().warning(stringBuilder.toString());
    }

    public void sendMessage(Player p, String messageKey) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, messages.get(messageKey))));
    }
}
