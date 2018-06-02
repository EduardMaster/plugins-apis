package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Comandos.Admin;
import Comandos.Build;
import Comandos.ClearChat;
import Comandos.Gm;
import Comandos.ItemQuebrar;
import Comandos.Kit;
import Comandos.Plugin;
import Comandos.Score;
import Comandos.StaffChat;
import Eventos.CustomTab;
import Eventos.Entrou;
import Eventos.Geral;
import Eventos.Matar;
import Eventos.Respawnou;
import Eventos.Saiu;
import Eventos.Sopa;
import GUI.InvMinigames;
import GUI.KitSelector;
import GUI.Sopinha;
import GUI.Warps;
import Hacks.AutoSoup;
import Kits.C4;
import Kits.C4L;
import Kits.Deshfire;
import Kits.Fisherman;
import Kits.ForceField;
import Kits.Kangaroo;
import Kits.Ninja;
import Kits.Snail;
import Kits.Sonic;
import Kits.Stomper;
import Kits.Surprise;
import Kits.Terrorista;
import Kits.Viking;
import Kits.Viper;
import Minigames.ClickTest;
import Minigames.Minigames;
import Utils.KitAPI;
import Warps.Challenge;
import Warps.FPS;
import Warps.SetChallenge;
import Warps.SetFPS;
import Warps.SetSpawn;

public class Main extends JavaPlugin{
	
	
	
	public static ArrayList<String> score = new ArrayList<>();
	
	public static Main plugin;
	public static Main getPlugin() {
		return plugin;
	}
	
	public static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
	public File stats1;
	public YamlConfiguration stats;


	
	public void onEnable() {
		instance =  this;
		plugin = this;
		saveDefaultConfig();
		RegisterEvents();
		Comandos();
		Bukkit.getConsoleSender().sendMessage("§6§lEZKits §4INICIADO");
		Segundo1();
		File stats = new File(getDataFolder(), "stats.yml");
		if (!stats.exists())
			saveResource("stats.yml", false);
		stats1 = new File(getDataFolder(), "stats.yml");
		this.stats = YamlConfiguration.loadConfiguration(stats1);
		save();
		
	}
	
	
	
	
	
	public void RegisterEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(new Viking(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new C4(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new C4L(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Plugin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CustomTab(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Ninja(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ItemQuebrar(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Admin(), this);		
		Bukkit.getServer().getPluginManager().registerEvents(new Fisherman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Entrou(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Saiu(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Deshfire(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Sonic(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Sopa(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ClickTest(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InvMinigames(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Minigames(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Geral(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Respawnou(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new KitSelector(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Kangaroo(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Terrorista(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Matar(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Viper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Snail(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Sopinha(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Build(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Warps(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GUI.Menu(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SetSpawn(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ForceField(this), this);
		
		


	}
	
	public void Comandos() {
		getCommand("surprise").setExecutor(new Surprise(this));
		getCommand("clearchat").setExecutor(new ClearChat());
		getCommand("menu").setExecutor(new GUI.Menu());;
		getCommand("gm").setExecutor(new Gm());
		getCommand("staffchat").setExecutor(new StaffChat());
		getCommand("build").setExecutor(new Build());
		getCommand("testmacro").setExecutor(new Hacks.TesteMacraum());
		getCommand("autosoup").setExecutor(new AutoSoup());
		getCommand("kit").setExecutor(new Kit());
		getCommand("admin").setExecutor(new Admin());
		getCommand("sopas").setExecutor(new Sopinha());
		getCommand("clicktest").setExecutor(new ClickTest());
		getCommand("score").setExecutor(new Score());
		getCommand("setfps").setExecutor(new SetFPS(this));
		getCommand("fps").setExecutor(new FPS(this));
		getCommand("challenge").setExecutor(new Challenge(this));
		getCommand("setchallenge").setExecutor(new SetChallenge(this));
		getCommand("setSpawn").setExecutor(new SetSpawn(this));
	    getCommand("spawn").setExecutor(new SetSpawn(this));
		
		
		
		
	}	
	public static void Segundo1() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				for (Player s : Bukkit.getOnlinePlayers()) {
					if (KitAPI.KitDelay.containsKey(s.getName())) {
						KitAPI.KitDelay.put(s.getName(), KitAPI.KitDelay.get(s.getName()) - 1);
					}
					if (Ninja.NinjaTime.containsKey(s.getName())) {
						Ninja.NinjaTime.put(s.getName(), Ninja.NinjaTime.get(s.getName()) - 1);
					}
				}
				
			}
		}, 0, 20);
	}
	
	public void save() {
		try {
			this.stats.save(this.stats1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
	

