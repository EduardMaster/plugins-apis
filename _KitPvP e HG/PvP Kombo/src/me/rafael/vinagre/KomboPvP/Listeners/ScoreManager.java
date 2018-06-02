package me.rafael.vinagre.KomboPvP.Listeners;




import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
@SuppressWarnings("unused")
public class ScoreManager {

  public static ScoreManager ScoreManager = new ScoreManager();
  FileConfiguration kStats;
  File Stats;
  
  public static ScoreManager getConfig()
  {
    return ScoreManager;
  }
  
  public void setupConfig(Plugin plugin)
  {
    if (!plugin.getDataFolder().exists()) {
      plugin.getDataFolder().mkdir();
    }
    this.Stats = new File(plugin.getDataFolder(), "Stats.yml");
    if (this.Stats.exists()) {
      try
      {
        this.Stats.createNewFile();
        Bukkit.getServer().getLogger().info("O Arquivo: Stats.yml foi gerado com sucesso!");
      }
      catch (IOException e)
      {
        Bukkit.getServer().getLogger().info("Ocorreu um erro ao gerar o Arquivo: Stats.yml!");
        e.printStackTrace();
      }
    }
    this.kStats = YamlConfiguration.loadConfiguration(this.Stats);
  }
  
  public FileConfiguration getStats()
  {
    return this.kStats;
  }
  
  public void saveStats()
  {
    try
    {
      this.kStats.save(this.Stats);
    }
    catch (IOException e)
    {
      Bukkit.getServer().getLogger().info("Ocorreu um erro ao salvar o Arquivo: Stats.yml");
      e.printStackTrace();
    }
  }
}
