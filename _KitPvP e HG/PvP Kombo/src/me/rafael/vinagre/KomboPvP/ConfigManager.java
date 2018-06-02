package me.rafael.vinagre.KomboPvP;

/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class ConfigManager
/*    */ {
/* 15 */   static ConfigManager instance = new ConfigManager();
/*    */   Plugin p;
/*    */   FileConfiguration config;
/*    */   File cfile;
/*    */   FileConfiguration data;
/*    */   File dfile;
/*    */   
/*    */   public static ConfigManager getInstance()
/*    */   {
/* 24 */     return instance;
/*    */   }
/*    */   
/*    */   public void setup(Plugin p)
/*    */   {
/* 29 */     this.cfile = new File(p.getDataFolder(), "config.yml");
/* 30 */     this.config = p.getConfig();
/* 31 */     if (!p.getDataFolder().exists()) {
/* 32 */       p.getDataFolder().mkdir();
/*    */     }
/* 34 */     this.dfile = new File(p.getDataFolder(), "data.yml");
/* 35 */     if (!this.dfile.exists()) {
/*    */       try
/*    */       {
/* 38 */         this.dfile.createNewFile();
/*    */       }
/*    */       catch (IOException e)
/*    */       {
/* 42 */         Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
/*    */       }
/*    */     }
/* 45 */     this.data = YamlConfiguration.loadConfiguration(this.dfile);
/*    */   }
/*    */   
/*    */   public FileConfiguration getData()
/*    */   {
/* 50 */     return this.data;
/*    */   }
/*    */   
/*    */   public void saveData()
/*    */   {
/*    */     try
/*    */     {
/* 57 */       this.data.save(this.dfile);
/*    */     }
/*    */     catch (IOException e)
/*    */     {
/* 61 */       Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml!");
/*    */     }
/*    */   }
/*    */   
/*    */   public void reloadData()
/*    */   {
/* 67 */     this.data = YamlConfiguration.loadConfiguration(this.dfile);
/*    */   }
/*    */   
/*    */   public FileConfiguration getConfig()
/*    */   {
/* 72 */     return this.config;
/*    */   }
/*    */   
/*    */   public void saveConfig()
/*    */   {
/*    */     try
/*    */     {
/* 79 */       this.config.save(this.cfile);
/*    */     }
/*    */     catch (IOException e)
/*    */     {
/* 83 */       Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
/*    */     }
/*    */   }
/*    */   
/*    */   public void reloadConfig()
/*    */   {
/* 89 */     this.config = YamlConfiguration.loadConfiguration(this.cfile);
/*    */   }
/*    */   
/*    */   public org.bukkit.plugin.PluginDescriptionFile getDesc()
/*    */   {
/* 94 */     return this.p.getDescription();
/*    */   }
/*    */ }

