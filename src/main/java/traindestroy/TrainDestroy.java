package traindestroy;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public class TrainDestroy extends JavaPlugin {

    private void broadcastPluginMessage(String message) {
        Bukkit.broadcast(Component.text("§8§l[§7§lTrainDestroy§8§l] " + message).color(TextColor.color(Color.GREEN.getRGB())));
    }

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            broadcastPluginMessage("§cWARNING! §eAll trains will be destroyed in 1 minute!");
            broadcastPluginMessage("§ePlease do not board a coming train.");
            broadcastPluginMessage("§c§ePlease alight at the next station. Thank you!");
        }, 3600, 72000);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            broadcastPluginMessage("§cNOTICE: All trains are now being destroyed!");
            for (String world : getConfig().getStringList("worlds")) {
                try {
                    for (Entity entity : Bukkit.getWorld(world).getEntities()) {
                        if (entity.getType().equals(EntityType.MINECART)) {
                            entity.remove();
                        }
                    }
                } catch (Exception e) {
                    getLogger().warning(String.format("Issue while clearing trains of %s: %s", world, e.getMessage()));
                    e.printStackTrace();
                }
            }
        }, 3660, 73200);
    }

}
