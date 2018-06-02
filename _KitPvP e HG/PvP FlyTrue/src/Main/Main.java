package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import APIs.TitleAPI;
import Comandos.Admin;
import Comandos.Arena;
import Comandos.Bc;
import Comandos.Build;
import Comandos.Challenge;
import Comandos.ClearChat;
import Comandos.Coins;
import Comandos.Fps;
import Comandos.Gamemode;
import Comandos.Head;
import Comandos.Inv;
import Comandos.Kit;
import Comandos.Morrer;
import Comandos.Ping;
import Comandos.Report;
import Comandos.Score;
import Comandos.SetArena;
import Comandos.Spawn;
import Comandos.StaffChat;
import Comandos.Sumo;
import Comandos.Tag;
import Comandos.Tell;
import Comandos.TesteClick;
import Comandos.TogglePvP;
import Comandos.Tp;
import Comandos.Tpall;
import Comandos.ajuda;
import Comandos.Voar;
import Comandos.Youtuber;
import Comandos.aMain;
import EventosPrincipais.ChatForm;
import EventosPrincipais.Entrou;
import EventosPrincipais.Geral;
import EventosPrincipais.ItemQuebrar;
import EventosPrincipais.Matar;
import EventosPrincipais.Parkour;
import EventosPrincipais.Plugins;
import EventosPrincipais.Respawnou;
import EventosPrincipais.Saiu;
import EventosPrincipais.Sopa;
import EventosPrincipais.SwordNerf;
import GUI.KitSelector;
import GUI.LojaKits;
import GUI.Warps;
import Jumps.Diamante;
import Jumps.Esmeralda;
import Jumps.Ferro;
import Jumps.Redstone;
import Kits.Boxer;
import Kits.BurstMaster;
import Kits.Deshfire;
import Kits.Deshviper;
import Kits.Fisherman;
import Kits.Forcefield;
import Kits.Gladiator;
import Kits.Hulk;
import Kits.Kangaroo;
import Kits.Madman;
import Kits.Camel;
import Kits.Ninja;
import Kits.Phantom;
import Kits.Poseidon;
import Kits.Reaper;
import Kits.Ryu;
import Kits.Seya;
import Kits.Snail;
import Kits.Sonic;
import Kits.Specialist;
import Kits.Stomper;
import Kits.Thor;
import Kits.TimeLord;
import Kits.Titan;
import Kits.Turtle;
import Kits.Urgal;
import Kits.Viking;
import Kits.Viper;
import Outros.Motd;
import Outros.PlacaDeRecraft;
import Outros.PlacaDeSopa;
import Outros.ScoreBoard;
import Utils.KillStreak;
import Utils.KitAPI;
import Utils.TagsAPI;
import Utils.WarpsAPI;

public class Main extends JavaPlugin {
	
	public static Plugin plugin;
	public static Main instance;
	public static Main getInstace() {
		return instance;
	}
	
	public File stats1;
	public YamlConfiguration stats;
	public File warps1;
	public YamlConfiguration warps;
	public File loja1;
	public YamlConfiguration loja;
	public File arenas1;
	public YamlConfiguration arenas;
	
	public static ArrayList<String> score = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
	    plugin = this;
	    instance = this;
	    saveConfig();
		instance = this;
		saveDefaultConfig();
		File stats = new File(getDataFolder(), "stats.yml");
		if (!stats.exists())
			saveResource("stats.yml", false);
		stats1 = new File(getDataFolder(), "stats.yml");
		this.stats = YamlConfiguration.loadConfiguration(stats1);
		File warps = new File(getDataFolder(), "warps.yml");
		if (!warps.exists())
			saveResource("warps.yml", false);
		warps1 = new File(getDataFolder(), "warps.yml");
		this.warps = YamlConfiguration.loadConfiguration(warps1);
		File loja = new File(getDataFolder(), "loja.yml");
		if (!loja.exists())
			saveResource("loja.yml", false);
		loja1 = new File(getDataFolder(), "loja.yml");
		this.loja = YamlConfiguration.loadConfiguration(loja1);
		this.warps = YamlConfiguration.loadConfiguration(warps1);
		File arenas = new File(getDataFolder(), "arenas.yml");
		if (!arenas.exists())
			saveResource("arenas.yml", false);
		arenas1 = new File(getDataFolder(), "arenas.yml");
		this.arenas = YamlConfiguration.loadConfiguration(arenas1);
		save();
		new BukkitRunnable() {
			@Override
			public void run() {
				for(Player p:Bukkit.getOnlinePlayers()) {
					if(!score.contains(p.getName())) {
						int ping = ((CraftPlayer)p).getHandle().ping;
						int online = Bukkit.getOnlinePlayers().length;
						ScoreBoard.UpdateScore(p);
						TitleAPI.sendTabTitle(p, "§c§lFly§7§lTrue" + "\n" + "§aTenha um bom jogo", "§aKit : §f" + KitAPI.getKit(p) + " §aPing : §f" + ping + " §aOnline : §f" + online);
					}
					else {
						ScoreBoard.clearScoreboard(p);
					}
				}
			}
		}.runTaskTimer(this, 0, 15);
		RegisterEvents();
		Comandos();
		Segundos1();
		Bukkit.getConsoleSender().sendMessage("§bO Plugin §c§lFly§7§lTrue §bfoi iniciado creditos §cFlashDev");
		Bukkit.getConsoleSender().sendMessage("§bO Plugin §c§lFly§7§lTrue §bfoi iniciado creditos §cFlashDev");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§bO Plugin §c§lFly§7§lTrue §bfoi desativado creditos §cFlashDev");
		{
		}
		}
		
	public void RegisterEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(new Comandos.Fisherman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Gladiator(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new KillStreak(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new TagsAPI(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Plugins(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new WarpsAPI(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Urgal(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Thor(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new TimeLord(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Poseidon(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Phantom(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Camel(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BurstMaster(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new WarpsAPI(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Parkour(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Warps(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new TesteClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Ninja(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Tag(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LojaKits(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ItemQuebrar(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Motd(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Diamante(getInstace()), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Redstone(getInstace()), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Esmeralda(getInstace()), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Ferro(getInstace()), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Build(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Admin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlacaDeSopa(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlacaDeRecraft(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Entrou(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Geral(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Matar(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Saiu(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Sopa(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Specialist(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Titan(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Turtle(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Deshfire(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Sonic(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Deshviper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Seya(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Boxer(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Ryu(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Madman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Hulk(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Forcefield(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SwordNerf(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChatForm(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Respawnou(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new KitSelector(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Kangaroo(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fisherman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Viper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Snail(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Reaper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Viking(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Voar(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Youtuber(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SetArena(), this);
	}
	
	public void Comandos() {
     	getCommand("TogglePvP").setExecutor(new TogglePvP());
     	getCommand("ping").setExecutor(new Ping());
     	getCommand("lojakits").setExecutor(new LojaKits());
     	getCommand("head").setExecutor(new Head());
     	getCommand("inv").setExecutor(new Inv());
     	getCommand("parkour").setExecutor(new Comandos.Parkour());
     	getCommand("fps").setExecutor(new Fps());
     	getCommand("sumo").setExecutor(new Sumo());
     	getCommand("gm").setExecutor(new Gamemode());
     	getCommand("challenge").setExecutor(new Challenge());
     	getCommand("ajuda").setExecutor(new ajuda());
     	getCommand("main").setExecutor(new aMain());
     	getCommand("fisherman").setExecutor(new Comandos.Fisherman());
     	getCommand("tell").setExecutor(new Tell());
     	getCommand("tpall").setExecutor(new Tpall());
     	getCommand("warps").setExecutor(new Warps());
     	getCommand("spawn").setExecutor(new Spawn());
     	getCommand("testclick").setExecutor(new TesteClick());
     	getCommand("tags").setExecutor(new Tag());
     	getCommand("tag").setExecutor(new Tag());
     	getCommand("bc").setExecutor(new Bc());
     	getCommand("coins").setExecutor(new Coins());
     	getCommand("sc").setExecutor(new StaffChat());
     	getCommand("score").setExecutor(new Score());
     	getCommand("youtuber").setExecutor(new Youtuber());
     	getCommand("voar").setExecutor(new Voar());
     	getCommand("tp").setExecutor(new Tp());
     	getCommand("arena").setExecutor(new Arena());
     	getCommand("morrer").setExecutor(new Morrer());
		getCommand("setarena").setExecutor(new SetArena());
     	getCommand("build").setExecutor(new Build());
     	getCommand("admin").setExecutor(new Admin());
     	getCommand("kit").setExecutor(new Kit());
     	getCommand("kits").setExecutor(new KitSelector());
     	getCommand("clearchat").setExecutor(new ClearChat());
     	getCommand("report").setExecutor(new Report(getInstace()));
	}
	public void save() {
		try {
			this.stats.save(this.stats1);
			this.warps.save(this.warps1);
			this.loja.save(this.loja1);
			this.arenas.save(this.arenas1);
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
	public static void Segundos1() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstace(), new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for (Player s : Bukkit.getOnlinePlayers()) {
					if (KitAPI.KitDelay.containsKey(s.getName())) {
						KitAPI.KitDelay.put(s.getName(), KitAPI.KitDelay.get(s.getName()) - 1);
					}
				}
				
			}
		}, 0, 20);
	}
}
