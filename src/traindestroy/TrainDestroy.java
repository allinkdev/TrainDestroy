package traindestroy;
 
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;
 
public class TrainDestroy extends JavaPlugin {
    public static Plugin plugin;
        public void onEnable() {
         try
        {
            final Metrics metrics = new Metrics(plugin);
            metrics.start();
        }
        catch (IOException ex)
        {
            getLogger().info(ChatColor.RED + "Failed to submit metrics data: " + ex.getMessage());
        }
            getConfig().options().copyDefaults(true);
            saveConfig();
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
                        public void run() {
                                Bukkit.broadcastMessage(ChatColor.GREEN + "§8§l[§7§lTrainDestroy§8§l] §cWARNING! §eAll trains will be destroyed in 1 minute!");
                                Bukkit.broadcastMessage(ChatColor.GREEN + "§8§l[§7§lTrainDestroy§8§l] §ePlease do not board a coming train.");
                                Bukkit.broadcastMessage(ChatColor.GREEN + "§8§l[§7§lTrainDestroy§8§l] §c§ePlease alight at the next station. Thank you!");
                        }
                 }, 3600, 72000);
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
                        public void run() {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();    
                            Bukkit.broadcastMessage(ChatColor.GREEN + "§8§l[§7§lTrainDestroy§8§l] §cNOTICE: All trains are now destroyed!" );
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World1"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World2"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World3"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World4"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World5"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World6"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World7"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World8"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World9"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World10"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World11"));
                                Bukkit.dispatchCommand(console, "ebutcher minecart " + getConfig().getString("World12"));
                                                                

                     }
    }, 3660, 73200);
    try {
        Metrics metrics = new Metrics(this);
        metrics.start();
    } catch (IOException e) {
        
    }
  }
 
}
