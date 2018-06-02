package me.rafael.vinagre.KomboPvP.Listeners;


import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config
{
  public static Config Config = new Config();
  FileConfiguration kStats;
  File Stats;
  
  public static Config getConfig()
  {
    return Config;
  }
  
  public void setupConfig(Plugin plugin)
  {
    if (!plugin.getDataFolder().exists()) {
      plugin.getDataFolder().mkdir();
    }
    this.Stats = new File(plugin.getDataFolder(), "warps.yml");
    if (this.Stats.exists()) {
      try
      {
        this.Stats.createNewFile();
        Bukkit.getServer().getLogger().info("O Arquivo: warps.yml.yml foi gerado com sucesso!");
      }
      catch (IOException e)
      {
        Bukkit.getServer().getLogger().info("Ocorreu um erro ao gerar o Arquivo: warps.yml.yml!");
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
      Bukkit.getServer().getLogger().info("Ocorreu um erro ao salvar o Arquivo: warps.yml");
      e.printStackTrace();
    }
  }
}
