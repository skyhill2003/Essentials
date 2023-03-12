package tk.skyhill2003.essentials;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tk.skyhill2003.essentials.utils.Variable;

import javax.swing.text.html.parser.DTD;
import java.io.File;
import java.io.IOException;

public final class Essentials extends JavaPlugin {
    public static Essentials instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§e" + getDescription().getName() + "§7 plugin is starting! §eCoded by " + getDescription().getAuthors());

        initConfig();
        process();

        File file = new File("plugins/Essentials", "config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Commands
        // getCommand("admintools").setExecutor(new AdminCMD());

        // Listener
        PluginManager pm = Bukkit.getPluginManager();
        // pm.registerEvents(new InventoryClickListener(), this);

        Bukkit.getConsoleSender().sendMessage("§e" + getDescription().getName() + "§7 plugin is started! §eCoded by " + getDescription().getAuthors());

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§e" + getDescription().getName() + "§7 plugin is stopped! §eCoded by " + getDescription().getAuthors());
    }

    public void initConfig() {
        reloadConfig();
        getConfig().options().header("Essentials Config - Plugin by skyhill2003");

        getConfig().addDefault("title", "§cEssentials");
        getConfig().addDefault("noPermissions", "§cNo Permissions");
        getConfig().addDefault("rightUse", "§cUse: ");

        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void process() {
        Variable.prefix = getConfig().getString("prefix").replace("&", "§");
        Variable.noPermissions = getConfig().getString("noPermissions").replace("&", "§");
        Variable.rightUse = getConfig().getString("rightUse").replace("&", "§");
    }

    public static tk.skyhill2003.essentials.Essentials getInstance() {
        return instance;
    }

}
