package me.rafael.vinagre.KomboPvP;

import Efeitos.DiamondBlock;
import Efeitos.EnderSignal;
import Efeitos.Flame;
import Efeitos.Potion;
import Efeitos.Rainbow;
import Efeitos.RedstoneBlock;
import Efeitos.RemoverEfeito;
import Efeitos.Selector;
import Efeitos.Smoke;
import Efeitos.Water;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import Scoreboard.Genocida;
import Scoreboard.ScoreDoBasic;
import Vinagre.API;
import Vytor.KitDiario.XpDiario;
import XP.DarXp;
import XP.GanharXP;

import XP.MyConfigManager;
import XP.RemoveXP;
import XP.VerXp;
import XP.XpM;
import me.rafael.vinagre.KomboPvP.Comandos.Admin;
import me.rafael.vinagre.KomboPvP.Comandos.Aplicar;
import me.rafael.vinagre.KomboPvP.Comandos.AutoMsg;
import me.rafael.vinagre.KomboPvP.Comandos.AutoSoup;
import me.rafael.vinagre.KomboPvP.Comandos.Broadcast;
import me.rafael.vinagre.KomboPvP.Comandos.Build;
import me.rafael.vinagre.KomboPvP.Comandos.Chat;
import me.rafael.vinagre.KomboPvP.Comandos.Crash;
import me.rafael.vinagre.KomboPvP.Comandos.DarKit;
import me.rafael.vinagre.KomboPvP.Comandos.Extra;
import me.rafael.vinagre.KomboPvP.Comandos.Fake;
import me.rafael.vinagre.KomboPvP.Comandos.Fly;
import me.rafael.vinagre.KomboPvP.Comandos.Gamemode;
import me.rafael.vinagre.KomboPvP.Comandos.Hats;
import me.rafael.vinagre.KomboPvP.Comandos.Head;
import me.rafael.vinagre.KomboPvP.Comandos.Help;
import me.rafael.vinagre.KomboPvP.Comandos.Invsee;

import me.rafael.vinagre.KomboPvP.Comandos.Kits;
import me.rafael.vinagre.KomboPvP.Comandos.Kits2;
import me.rafael.vinagre.KomboPvP.Comandos.Kits3;
import me.rafael.vinagre.KomboPvP.Comandos.LimparChat;
import me.rafael.vinagre.KomboPvP.Comandos.Loja;
import me.rafael.vinagre.KomboPvP.Comandos.LojaDeKits;
import me.rafael.vinagre.KomboPvP.Comandos.LojadeOutros;
import me.rafael.vinagre.KomboPvP.Comandos.LojadoServidor;
import me.rafael.vinagre.KomboPvP.Comandos.Managers;
import me.rafael.vinagre.KomboPvP.Comandos.Mensagens;
import me.rafael.vinagre.KomboPvP.Comandos.Owner;
import me.rafael.vinagre.KomboPvP.Comandos.Ping;
import me.rafael.vinagre.KomboPvP.Comandos.Ranks;
import me.rafael.vinagre.KomboPvP.Comandos.Regras;
import me.rafael.vinagre.KomboPvP.Comandos.Report;
import me.rafael.vinagre.KomboPvP.Comandos.SetArena;
import me.rafael.vinagre.KomboPvP.Comandos.SetSpawn;
import me.rafael.vinagre.KomboPvP.Comandos.SetWarp;
import me.rafael.vinagre.KomboPvP.Comandos.Skit;
import me.rafael.vinagre.KomboPvP.Comandos.Sobrevivente;
import me.rafael.vinagre.KomboPvP.Comandos.StaffChat;
import me.rafael.vinagre.KomboPvP.Comandos.StatusM;
import me.rafael.vinagre.KomboPvP.Comandos.Subzero;
import me.rafael.vinagre.KomboPvP.Comandos.Tag;
import me.rafael.vinagre.KomboPvP.Comandos.Teleport;
import me.rafael.vinagre.KomboPvP.Comandos.Tell;
import me.rafael.vinagre.KomboPvP.Comandos.TestClick;
import me.rafael.vinagre.KomboPvP.Comandos.TogglePvP;
import me.rafael.vinagre.KomboPvP.Comandos.Tp;
import me.rafael.vinagre.KomboPvP.Comandos.Tpall;
import me.rafael.vinagre.KomboPvP.Comandos.Ver;
import me.rafael.vinagre.KomboPvP.Comandos.Warps;
import me.rafael.vinagre.KomboPvP.Jumps.BlocoDeDima;
import me.rafael.vinagre.KomboPvP.Jumps.BlocoDeEsmeralda;
import me.rafael.vinagre.KomboPvP.Jumps.Esponja;
import me.rafael.vinagre.KomboPvP.Kits.Achilles;
import me.rafael.vinagre.KomboPvP.Kits.Alladin;
import me.rafael.vinagre.KomboPvP.Kits.Anchor;
import me.rafael.vinagre.KomboPvP.Kits.Archer;
import me.rafael.vinagre.KomboPvP.Kits.Backpacker;
import me.rafael.vinagre.KomboPvP.Kits.Barbarian;
import me.rafael.vinagre.KomboPvP.Kits.Bloodgun;
import me.rafael.vinagre.KomboPvP.Kits.Boxer;
import me.rafael.vinagre.KomboPvP.Kits.Bust;
import me.rafael.vinagre.KomboPvP.Kits.Camel;
import me.rafael.vinagre.KomboPvP.Kits.CicleFire;
import me.rafael.vinagre.KomboPvP.Kits.Confuser;
import me.rafael.vinagre.KomboPvP.Kits.Critical;
import me.rafael.vinagre.KomboPvP.Kits.Cyclope;
import me.rafael.vinagre.KomboPvP.Kits.DarkGod;
import me.rafael.vinagre.KomboPvP.Kits.Drain;
import me.rafael.vinagre.KomboPvP.Kits.DubleJump;
import me.rafael.vinagre.KomboPvP.Kits.Ebola;
import me.rafael.vinagre.KomboPvP.Kits.Endermage;
import me.rafael.vinagre.KomboPvP.Kits.Fireman;
import me.rafael.vinagre.KomboPvP.Kits.Fisherman;
import me.rafael.vinagre.KomboPvP.Kits.Forcefield;
import me.rafael.vinagre.KomboPvP.Kits.Frosty;
import me.rafael.vinagre.KomboPvP.Kits.Fujao;
import me.rafael.vinagre.KomboPvP.Kits.Gladiator;
import me.rafael.vinagre.KomboPvP.Kits.GladiatorHAB;
import me.rafael.vinagre.KomboPvP.Kits.Golen;
import me.rafael.vinagre.KomboPvP.Kits.Grandpa;
import me.rafael.vinagre.KomboPvP.Kits.Grappler;
import me.rafael.vinagre.KomboPvP.Kits.Gun;
import me.rafael.vinagre.KomboPvP.Kits.Hulk;
import me.rafael.vinagre.KomboPvP.Kits.Indio;
import me.rafael.vinagre.KomboPvP.Kits.Infernor;
import me.rafael.vinagre.KomboPvP.Kits.InfernorHAB;
import me.rafael.vinagre.KomboPvP.Kits.Jumper;
import me.rafael.vinagre.KomboPvP.Kits.Kangaroo;
import me.rafael.vinagre.KomboPvP.Kits.Launcher;
import me.rafael.vinagre.KomboPvP.Kits.Monk;
import me.rafael.vinagre.KomboPvP.Kits.Naruto;
import me.rafael.vinagre.KomboPvP.Kits.NetherMan;
import me.rafael.vinagre.KomboPvP.Kits.Ninja;
import me.rafael.vinagre.KomboPvP.Kits.Pesadelo;
import me.rafael.vinagre.KomboPvP.Kits.Poseidon;
import me.rafael.vinagre.KomboPvP.Kits.Quick;
import me.rafael.vinagre.KomboPvP.Kits.Rain;
import me.rafael.vinagre.KomboPvP.Kits.Reaper;
import me.rafael.vinagre.KomboPvP.Kits.RobinHood;
import me.rafael.vinagre.KomboPvP.Kits.Ryu;
import me.rafael.vinagre.KomboPvP.Kits.Snail;
import me.rafael.vinagre.KomboPvP.Kits.Stomper;
import me.rafael.vinagre.KomboPvP.Kits.Switcher;
import me.rafael.vinagre.KomboPvP.Kits.Teleporter;
import me.rafael.vinagre.KomboPvP.Kits.Thor;
import me.rafael.vinagre.KomboPvP.Kits.Thresh;
import me.rafael.vinagre.KomboPvP.Kits.Timelord;
import me.rafael.vinagre.KomboPvP.Kits.Tocha;
import me.rafael.vinagre.KomboPvP.Kits.Turtle;
import me.rafael.vinagre.KomboPvP.Kits.Velotrol;
import me.rafael.vinagre.KomboPvP.Kits.Viking;
import me.rafael.vinagre.KomboPvP.Kits.Viper;
import me.rafael.vinagre.KomboPvP.Kits.Vitality;
import me.rafael.vinagre.KomboPvP.Kits.Vulture;
import me.rafael.vinagre.KomboPvP.Kits.Waterbender;
import me.rafael.vinagre.KomboPvP.Kits.Wink;
import me.rafael.vinagre.KomboPvP.Kits.Wither;
import me.rafael.vinagre.KomboPvP.Kits.kPvP;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
import me.rafael.vinagre.KomboPvP.Listeners.ChatForm;
import me.rafael.vinagre.KomboPvP.Listeners.CombatLog;
import me.rafael.vinagre.KomboPvP.Listeners.Compass;
import me.rafael.vinagre.KomboPvP.Listeners.Cooldown;
import me.rafael.vinagre.KomboPvP.Listeners.Cores;
import me.rafael.vinagre.KomboPvP.Listeners.Eventos;
import me.rafael.vinagre.KomboPvP.Listeners.Events;
import me.rafael.vinagre.KomboPvP.Listeners.Feast;
import me.rafael.vinagre.KomboPvP.Listeners.Habilidades;
import me.rafael.vinagre.KomboPvP.Listeners.Motd;

import me.rafael.vinagre.KomboPvP.Listeners.PlacaDeSopa;
import me.rafael.vinagre.KomboPvP.Listeners.Players;
import me.rafael.vinagre.KomboPvP.Listeners.Recraft;
import me.rafael.vinagre.KomboPvP.Listeners.Reflection;
import me.rafael.vinagre.KomboPvP.Listeners.SemExplosao;
import me.rafael.vinagre.KomboPvP.Listeners.SomNosComandos;
import me.rafael.vinagre.KomboPvP.Listeners.Sopas;
import me.rafael.vinagre.KomboPvP.Listeners.SpamCheck;

import me.rafael.vinagre.KomboPvP.Listeners.Stop;


import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


import Caixas.Caixa;
import Caixas.CaixaKit;
import Caixas.CaixaXP;
import Caixas.Caixas;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Main
  extends JavaPlugin
{
  public static ReentrantLock lock = new ReentrantLock(true);
  public static String SQL_HOST = null;
  public static ArrayList<String> jp = new ArrayList();
  public static String SQL_PORT = null;
  public static Plugin plugin;
  public static Main instance;
  public static Integer score;
  
  
  public File registrofile;

  public YamlConfiguration registro;
  
  public File warpsfile;
  public YamlConfiguration warps;
  public File statusfile;
  public YamlConfiguration status;
  public File arenasfile;
  public YamlConfiguration arenas;
  
private File warps1;
private File arenas1;
private File status1;
private File registro1;

  public static Boolean COMPASS = Boolean.valueOf(true);
  public static Boolean AUTO_COMPASS = Boolean.valueOf(false);
  public static String SQL_USER = null;
  public static String SQL_PASS = null;
  
  public static ArrayList<String> Sonic = new ArrayList();
  public static ArrayList<String> qd = new ArrayList();
  public static List<String> OiDecompilerEz2 = new ArrayList();
  public static String SQL_DATA = null;
  public static List<Player> Tempo = new ArrayList();
  public static List<String> Ferro2 = new ArrayList();
  public static ArrayList<String> naruto = new ArrayList();
  public static File diretorioC = new File("C:\\KomboPvP- Configuraçoes");
  public static ArrayList<String> login = new ArrayList<>();
  public static List<String> Red2 = new ArrayList();
  public static List<String> Terra2 = new ArrayList();
  public static String cl = "§c§lVoce esta em cooldowm!!";
 
  public static FileConfiguration config;
  public static MyConfigManager manager;
  public static ArrayList<String> trocador = new ArrayList();
  public static Main main;
  public static ArrayList<String> Dj = new ArrayList();
  public static ArrayList<String> Deshfire = new ArrayList();
  public static ArrayList<String> rain = new ArrayList();
  public static List<Player> cooldownm = new ArrayList();
  public static ArrayList<String> Flames = new ArrayList();
  public static ArrayList<String> Ender = new ArrayList();
  public static ArrayList<String> Redstone = new ArrayList();
  public static ArrayList<String> Diamond = new ArrayList();
  public static ArrayList<String> Water = new ArrayList();
  public static ArrayList<String> Efeitos = new ArrayList();
  public static ArrayList<String> stomper = new ArrayList();
  public static ArrayList<String> Smoke = new ArrayList();
  public static ArrayList<String> EXTINGUISH = new ArrayList();
  public static ArrayList<String> AvatarH = new ArrayList();
  public static Main getInstace() {
		return instance;
	}
  public static ArrayList<String> Avatar = new ArrayList();
  public static ArrayList<String> antistomper = new ArrayList();
  public static ArrayList<String> Potion = new ArrayList();

  public static String ban = "§4§lBAN: ";
  public static String kick = "§4§lKICK: ";
  public static String mute = "§4§lMUTE: ";
  public static ArrayList<String> Rainbow = new ArrayList();
  public static ArrayList<String> jutso= new ArrayList();
  public static Main pl;
  
  public static Main getInstance() {
      return Main.instance;
  } {
    
  }
 

  
  
    
  
  
  public void onEnable()
  {
	  plugin = this;
	    instance = this;
	    saveConfig();
		instance = this;
		saveDefaultConfig();
		File warps = new File(getDataFolder(), "warps.yml");
		if (!warps.exists())
			saveResource("warps.yml", false);
		warps1 = new File(getDataFolder(), "warps.yml");
		this.warps = YamlConfiguration.loadConfiguration(warps1);
		
		File status = new File(getDataFolder(), "status.yml");
		if (!status.exists())
			saveResource("status.yml", false);
		status1 = new File(getDataFolder(), "status.yml");
		this.status = YamlConfiguration.loadConfiguration(status1);
		
		File registro = new File(getDataFolder(), "registro.yml");
		if (!registro.exists())
			saveResource("registro.yml", false);
		registro1 = new File(getDataFolder(), "registro.yml");
		this.registro = YamlConfiguration.loadConfiguration(registro1);
		
		File arenas = new File(getDataFolder(), "arenas.yml");
		if (!arenas.exists())
			saveResource("arenas.yml", false);
		arenas1 = new File(getDataFolder(), "arenas.yml");
		this.arenas = YamlConfiguration.loadConfiguration(arenas1);
		
		
		 Bukkit.getConsoleSender().sendMessage("PLUGIN ATIVADO");
		    Bukkit.getConsoleSender().sendMessage("DEPOIS QUE INICIAR O SERVER  ");
		    Bukkit.getConsoleSender().sendMessage("SETE AS ARENAS  ");
		    Bukkit.getConsoleSender().sendMessage("de /setarena 1 a 7  ");
		    Bukkit.getConsoleSender().sendMessage("antes de iniciar o server  ");
		    Bukkit.getConsoleSender().sendMessage("de /rg flag __global__ pvp allow ");
		    Bukkit.getConsoleSender().sendMessage("Plugin criado por zEnderX5_  ");
		    Bukkit.getConsoleSender().sendMessage("OBRIGADO POR USAR O PLUGIN  ");
		    Bukkit.getConsoleSender().sendMessage("zEnderX5_ DELICIA! ");
		    
		    
		    
		
    getServer().getPluginManager().registerEvents(new Chat(), this);
    
    
   
    
    getServer().getPluginManager().registerEvents(new Sobrevivente(), this);
    getServer().getPluginManager().registerEvents(new Gamemode(), this);
    getServer().getPluginManager().registerEvents(new Kits(), this);
    getServer().getPluginManager().registerEvents(new Compass(), this);
    getServer().getPluginManager().registerEvents(new Kits2(), this);
    getServer().getPluginManager().registerEvents(new Kits3(), this);
    getServer().getPluginManager().registerEvents(new Genocida(), this);
    getServer().getPluginManager().registerEvents(new LimparChat(), this);
    getServer().getPluginManager().registerEvents( new Cores(), this);
    getServer().getPluginManager().registerEvents( new Pesadelo(), this);
   
    getServer().getPluginManager().registerEvents(new SetSpawn(), this);
    
    getServer().getPluginManager().registerEvents(new Tag(), this);
    getServer().getPluginManager().registerEvents(new Skit(), this);
    getServer().getPluginManager().registerEvents(new LojaDeKits(null), this);
    getServer().getPluginManager().registerEvents(new StaffChat(), this);
    getServer().getPluginManager().registerEvents(new TestClick(), this);
    getServer().getPluginManager().registerEvents(new Tp(), this);
    getServer().getPluginManager().registerEvents(new Tpall(), this);
    getServer().getPluginManager().registerEvents(new Warps(), this);
    getServer().getPluginManager().registerEvents(new Cores(), this);
    getServer().getPluginManager().registerEvents(new SomNosComandos(), this);
    getServer().getPluginManager().registerEvents(new SemExplosao(), this);
    
    getServer().getPluginManager().registerEvents(new PlacaDeSopa(), this);
    getServer().getPluginManager().registerEvents(new Reflection(), this);
    
    
    getServer().getPluginManager().registerEvents(new Events(null), this);
    getServer().getPluginManager().registerEvents(new ChatForm(), this);
    getServer().getPluginManager().registerEvents(new Crash(), this);
    getServer().getPluginManager().registerEvents(new Broadcast(), this);
    getServer().getPluginManager().registerEvents(new Alladin(), this);
    getServer().getPluginManager().registerEvents(new Motd(), this);
    getServer().getPluginManager().registerEvents(new Rain(), this);
    getServer().getPluginManager().registerEvents(new Extra(), this);
    getServer().getPluginManager().registerEvents(new Recraft(), this);
    getServer().getPluginManager().registerEvents(new Managers(), this);
    getServer().getPluginManager().registerEvents(new Cores(), this);
    getServer().getPluginManager().registerEvents(new Caixas(), this);
    getServer().getPluginManager().registerEvents(new me.rafael.vinagre.KomboPvP.Kits.DJ(), this);
    getServer().getPluginManager().registerEvents(new Hats(null), this);
    getServer().getPluginManager().registerEvents(new Selector(null), this);
    getServer().getPluginManager().registerEvents(new Players(), this);
    
    String prefix = null;
    Bukkit.getServer().getConsoleSender().sendMessage(prefix + "ATIVADO");
    saveDefaultConfig();
    instance = this;
    plugin = this;
    getConfig().options().copyDefaults(true);
    getConfig().options().copyHeader(true);
    saveConfig();
    
    manager = new MyConfigManager(this);
    
    XpM.loadMoneyManager();
    
       
        
       
        
    
    

    getCommand("chat").setExecutor(new Chat());
    
    getCommand("fake").setExecutor(new Fake());
    getCommand("setarena").setExecutor(new SetArena());
    getCommand("sobrevivente").setExecutor(new Sobrevivente());
    getCommand("gm").setExecutor(new Gamemode());
    getCommand("kits").setExecutor(new Kits());
    getCommand("kits2").setExecutor(new Kits2());
    getCommand("kits3").setExecutor(new Kits3());
    getCommand("caixas").setExecutor(new Caixas());
    getCommand("cc").setExecutor(new LimparChat());
    getCommand("build").setExecutor(new Build());
    getCommand("help").setExecutor(new Help());
    getCommand("rank").setExecutor(new Ranks());
    getCommand("darxp").setExecutor(new DarXp());
    getCommand("removexp").setExecutor(new RemoveXP());
    getCommand("setspawn").setExecutor(new SetSpawn());
    getCommand("spawn").setExecutor(new SetSpawn());
    getCommand("setwarp").setExecutor(new SetWarp());
    getCommand("ver").setExecutor(new Ver());
    getCommand("pesadelo").setExecutor(new Pesadelo());
    getCommand("warp").setExecutor(new SetWarp());
    getCommand("trocador").setExecutor(new Rain());
    getCommand("dj").setExecutor(new me.rafael.vinagre.KomboPvP.Kits.DJ());
    getCommand("skit").setExecutor(new Skit());
    getCommand("tag").setExecutor(new Tag());
    getCommand("s").setExecutor(new StaffChat());
    getCommand("testclick").setExecutor(new TestClick());
    getCommand("info2").setExecutor(new Managers());
    getCommand("owner").setExecutor(new Owner());
    getCommand("tpc").setExecutor(new Tp());
    getCommand("tpall").setExecutor(new Tpall());
    getCommand("warps").setExecutor(new Warps());
    getCommand("eventos").setExecutor(new Warps());
    getCommand("fly").setExecutor(new Fly());
    getCommand("invsee").setExecutor(new Invsee());
    getCommand("tp").setExecutor(new Teleport());
    getCommand("togglepvp").setExecutor(new TogglePvP());
    getCommand("tell").setExecutor(new Tell());
    getCommand("darkit").setExecutor(new DarKit());
    getCommand("report").setExecutor(new Report(null));
    getCommand("aplicar").setExecutor(new Aplicar());
    getCommand("status").setExecutor(new me.rafael.vinagre.KomboPvP.Comandos.Status());
    getCommand("grandpa").setExecutor(new Grandpa());
    getCommand("darxp").setExecutor(new DarXp());
    getCommand("kills").setExecutor(new me.rafael.vinagre.KomboPvP.Comandos.Kills());
    getCommand("loja").setExecutor(new Loja(null));
    getCommand("lojadoservidor").setExecutor(new LojadoServidor(null));
    getCommand("lojadeoutros").setExecutor(new LojadeOutros(null));

    getCommand("admin").setExecutor(new Admin(null));
    getCommand("autosoup").setExecutor(new AutoSoup(null));
    getCommand("head").setExecutor(new Head(null));
    getCommand("crash").setExecutor(new Crash());
    getCommand("ping").setExecutor(new Ping());
    getCommand("bc").setExecutor(new Broadcast());
    
    getCommand("regras").setExecutor(new Regras());
    getCommand("gun").setExecutor(new Gun());
    getCommand("efeito1").setExecutor(new Flame());
    getCommand("efeito2").setExecutor(new EnderSignal());
    getCommand("efeito3").setExecutor(new Smoke());
    getCommand("efeito4").setExecutor(new RedstoneBlock());
    getCommand("efeito5").setExecutor(new DiamondBlock());
    getCommand("efeito6").setExecutor(new Water());
    
    getCommand("efeito7").setExecutor(new Potion());
    getCommand("lojadekits").setExecutor(new LojaDeKits(null));
    getCommand("efeito8").setExecutor(new Rainbow());
    getCommand("efeitos").setExecutor(new Selector(this));
    getCommand("youtuber").setExecutor(new me.rafael.vinagre.KomboPvP.Listeners.SerXingado());
    getCommand("extra").setExecutor(new Extra());
    getCommand("removerefeito").setExecutor(new RemoverEfeito());
    
    getServer().getPluginManager().registerEvents(new BlocoDeDima(), this);
    getServer().getPluginManager().registerEvents(new Gun(), this);
    getServer().getPluginManager().registerEvents(new BlocoDeEsmeralda(), this);
    getServer().getPluginManager().registerEvents(new Esponja(), this);
    getServer().getPluginManager().registerEvents(new Esponja(), this);
    getServer().getPluginManager().registerEvents(new Build(), this);
    getServer().getPluginManager().registerEvents(new Punheta.Ranks(), this);
    getServer().getPluginManager().registerEvents(new Anchor(this), this);
    getServer().getPluginManager().registerEvents(new Archer(), this);
    getServer().getPluginManager().registerEvents(new Backpacker(), this);
    getServer().getPluginManager().registerEvents(new Barbarian(), this);
    getServer().getPluginManager().registerEvents(new Endermage(), this);
    getServer().getPluginManager().registerEvents(new Frosty(), this);
    getServer().getPluginManager().registerEvents(new Bloodgun(), this);
    getServer().getPluginManager().registerEvents(new Boxer(), this);
    getServer().getPluginManager().registerEvents(new Camel(), this);
    getServer().getPluginManager().registerEvents(new GladiatorHAB(), this);
    getServer().getPluginManager().registerEvents(new CicleFire(this), this);
    getServer().getPluginManager().registerEvents(new Confuser(), this);
    getServer().getPluginManager().registerEvents(new Critical(), this);
    getServer().getPluginManager().registerEvents(new Cyclope(this), this);
    getServer().getPluginManager().registerEvents(new DarkGod(), this);
    
    getServer().getPluginManager().registerEvents(new Drain(this), this);
    getServer().getPluginManager().registerEvents(new Ebola(), this);
    getServer().getPluginManager().registerEvents(new Fireman(), this);
    getServer().getPluginManager().registerEvents(new Fisherman(), this);
    getServer().getPluginManager().registerEvents(new Forcefield(this), this);
    getServer().getPluginManager().registerEvents(new Fujao(), this);
    getServer().getPluginManager().registerEvents(new Gladiator(), this);
    getServer().getPluginManager().registerEvents(new Wink(), this);
    getServer().getPluginManager().registerEvents(new Waterbender(), this);
    getServer().getPluginManager().registerEvents(new GladiatorHAB(), this);
    getServer().getPluginManager().registerEvents(new Golen(this), this);
    getServer().getPluginManager().registerEvents(new Grappler(this), this);
    getServer().getPluginManager().registerEvents(new Hulk(), this);
    getServer().getPluginManager().registerEvents(new Indio(this), this);
    getServer().getPluginManager().registerEvents(new Infernor(), this);
    getServer().getPluginManager().registerEvents(new InfernorHAB(this), this);
    getServer().getPluginManager().registerEvents(new Kangaroo(), this);
    getServer().getPluginManager().registerEvents(new kPvP(), this);
    getServer().getPluginManager().registerEvents(new Pesadelo(), this);
    getServer().getPluginManager().registerEvents(new Vulture(), this);
    getServer().getPluginManager().registerEvents(new Achilles(null), this);
    getServer().getPluginManager().registerEvents(new Launcher(), this);
    getServer().getPluginManager().registerEvents(new Monk(this), this);
    getServer().getPluginManager().registerEvents(new NetherMan(), this);
    getServer().getPluginManager().registerEvents(new Ninja(), this);
    getServer().getPluginManager().registerEvents(new Poseidon(), this);
    getServer().getPluginManager().registerEvents(new Reaper(), this);
    getServer().getPluginManager().registerEvents(new RobinHood(), this);
    getServer().getPluginManager().registerEvents(new Ryu(this), this);
    getServer().getPluginManager().registerEvents(new Snail(), this);
    getServer().getPluginManager().registerEvents(new Stomper(), this);
    getServer().getPluginManager().registerEvents(new Switcher(), this);
    getServer().getPluginManager().registerEvents(new Thor(this), this);
    getServer().getPluginManager().registerEvents(new Thresh(this), this);
    getServer().getPluginManager().registerEvents(new Timelord(this), this);
    getServer().getPluginManager().registerEvents(new Turtle(), this);
    getServer().getPluginManager().registerEvents(new Velotrol(this), this);
    getServer().getPluginManager().registerEvents(new Viking(), this);
    getServer().getPluginManager().registerEvents(new me.rafael.vinagre.KomboPvP.Kits.Exploder(), this);
    getServer().getPluginManager().registerEvents(new me.rafael.vinagre.KomboPvP.Kits.Sonic(), this);
    getServer().getPluginManager().registerEvents(new Viper(), this);
    getServer().getPluginManager().registerEvents(new Subzero(), this);
    getServer().getPluginManager().registerEvents(new Vitality(), this);
    getServer().getPluginManager().registerEvents(new Wither(this), this);
    getServer().getPluginManager().registerEvents(new Tocha(), this);
    getServer().getPluginManager().registerEvents(new Teleporter(), this);
    getServer().getPluginManager().registerEvents(new Jumper(), this);
    getServer().getPluginManager().registerEvents(new Loja(this), this);
    getServer().getPluginManager().registerEvents(new Bust(), this);
    getServer().getPluginManager().registerEvents(new LojadeOutros(this), this);
    getServer().getPluginManager().registerEvents(new LojadoServidor(this), this);
    getServer().getPluginManager().registerEvents(new Admin(this), this);
    getServer().getPluginManager().registerEvents(new AutoSoup(this), this);
    getServer().getPluginManager().registerEvents(new XpDiario(), this);
    getServer().getPluginManager().registerEvents(new KitAPI(), this);
    
    getServer().getPluginManager().registerEvents(new Players(), this);
    getServer().getPluginManager().registerEvents(new StatusM(), this);
    
    getCommand("alladin").setExecutor(new Alladin());
    getCommand("anchor").setExecutor(new Anchor(this));
    getCommand("archer").setExecutor(new Archer());
    getCommand("backpacker").setExecutor(new Backpacker());
    getCommand("barbarian").setExecutor(new Barbarian());
    getCommand("boxer").setExecutor(new Boxer());
    getCommand("camel").setExecutor(new Camel());
    getCommand("pesadelo").setExecutor(new Pesadelo());
    getCommand("ciclefire").setExecutor(new CicleFire(this));
    getCommand("confuser").setExecutor(new Confuser());
    getCommand("critical").setExecutor(new Critical());
    getCommand("cyclope").setExecutor(new Cyclope(this));
    getCommand("sonic").setExecutor(new me.rafael.vinagre.KomboPvP.Kits.Sonic());
    getCommand("darkgod").setExecutor(new DarkGod());
    getCommand("doublejump").setExecutor(new DubleJump());
    getCommand("quickdropper").setExecutor(new Quick());
    getCommand("subzero").setExecutor(new Subzero());
    getCommand("drain").setExecutor(new Drain(this));
    getCommand("ebola").setExecutor(new Ebola());
    getCommand("burstmaster").setExecutor(new Bust());
    getCommand("fireman").setExecutor(new Fireman());
    getCommand("fisherman").setExecutor(new Fisherman());
    getCommand("teleporter").setExecutor(new Teleporter());
    getCommand("forcefield").setExecutor(new Forcefield(this));
    getCommand("fujao").setExecutor(new Fujao());
    getCommand("naruto").setExecutor(new Naruto());
    getCommand("gladiator").setExecutor(new Gladiator());
    getCommand("golen").setExecutor(new Golen(this));
    getCommand("avatar").setExecutor(new me.rafael.vinagre.KomboPvP.Kits.Avatar());
    getCommand("grappler").setExecutor(new Grappler(this));
    getCommand("hulk").setExecutor(new Hulk());
    getCommand("indio").setExecutor(new Indio(this));
    getCommand("infernor").setExecutor(new Infernor());
    getCommand("jumper").setExecutor(new Jumper());
    getCommand("kangaroo").setExecutor(new Kangaroo());
    getCommand("pvp").setExecutor(new kPvP());
    getCommand("launcher").setExecutor(new Launcher());
    getCommand("monk").setExecutor(new Monk(this));
    getCommand("netherman").setExecutor(new NetherMan());
    getCommand("ninja").setExecutor(new Ninja());
    getCommand("poseidon").setExecutor(new Poseidon());
    
    getCommand("reaper").setExecutor(new Reaper());
    getCommand("robinhood").setExecutor(new RobinHood());
    getCommand("ryu").setExecutor(new Ryu(this));
    getCommand("snail").setExecutor(new Snail());
    getCommand("stomper").setExecutor(new Stomper());
    getCommand("switcher").setExecutor(new Switcher());
   
    getCommand("thor").setExecutor(new Thor(this));
    getCommand("thresh").setExecutor(new Thresh(this));
    getCommand("timelord").setExecutor(new Timelord(this));
    getCommand("turtle").setExecutor(new Turtle());
    getCommand("velotrol").setExecutor(new Velotrol(this));
    getCommand("viking").setExecutor(new Viking());
    getCommand("deshfire").setExecutor(new me.rafael.vinagre.KomboPvP.Kits.Deshfire());
    getCommand("viper").setExecutor(new Viper());
    getCommand("vitality").setExecutor(new Vitality());
    getCommand("gaara").setExecutor( new Wink());
    getCommand("wither").setExecutor(new Wither(this));
    getCommand("jellyfish").setExecutor(new Waterbender());
    getCommand("achilles").setExecutor(new Achilles(null));
    getCommand("chestplate").setExecutor(new Vulture());
    getCommand("tocha").setExecutor(new Tocha());
    getCommand("frosty").setExecutor(new Frosty());
    getCommand("bloodgun").setExecutor(new Bloodgun());
    getCommand("flash").setExecutor(new Endermage());
    getCommand("naruto").setExecutor(new Naruto());
    getCommand("nofall").setExecutor(new me.rafael.vinagre.KomboPvP.Kits.Exploder());
    
    getServer().getPluginManager().registerEvents(new me.rafael.vinagre.KomboPvP.Kits.Deshfire(), this);
    getServer().getPluginManager().registerEvents(new CombatLog(), this);
    getServer().getPluginManager().registerEvents(new DubleJump(), this);
    getServer().getPluginManager().registerEvents(new Eventos(this), this);
    
    getServer().getPluginManager().registerEvents(new me.rafael.vinagre.KomboPvP.Kits.Avatar(), this);
   
    getServer().getPluginManager().registerEvents(new Sopas(null), this);
    getServer().getPluginManager().registerEvents(new SpamCheck(), this);
    getServer().getPluginManager().registerEvents(new Fake(), this);
    getServer().getPluginManager().registerEvents(new Stop(null), this);
    getServer().getPluginManager().registerEvents(new VerXp(), this);
    getServer().getPluginManager().registerEvents(new GanharXP(), this);
    getServer().getPluginManager().registerEvents(new Habilidades(this), this);
    getServer().getPluginManager().registerEvents(new ScoreDoBasic(), this);
    getServer().getPluginManager().registerEvents(new VerXp(), this);
    getServer().getPluginManager().registerEvents(new Naruto(), this);
    
    
    getServer().getPluginManager().registerEvents(new Feast(), this);
    getCommand("setfeast").setExecutor(new Feast());
    getCommand("setfeast2").setExecutor(new Feast());
    getCommand("setfeast3").setExecutor(new Feast());
    getCommand("setfeast4").setExecutor(new Feast());
    getCommand("setfeast5").setExecutor(new Feast());
    getCommand("spawn-feast").setExecutor(new Feast());
    
   
    Mensagens.start();
    
    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
      public void run()
      {
        for (World World : Bukkit.getServer().getWorlds()) {
          World.setTime(0L);
        }
      }
    }, 20L, 20L);
    
    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn-feast");
  }
  public static void teleport(Player p){
 {
	Random r = new Random();
	int o = r.nextInt(4);
	if(o == 0){
		World W = p.getWorld();
		double X = -1898.36557;
	    double Y = 12;
	    double Z = 853.04555;
	    Location spawner = new Location(W, X, Y, Z);
	    p.teleport(spawner);
	}
	else if (o == 1){
		World W = p.getWorld();
		double X = -1900.96117;
	    double Y = 11;
	    double Z = 966.45044;
	    Location spawner = new Location(W, X, Y, Z);
	    p.teleport(spawner);
	}
	else if (o == 2){
		World W = p.getWorld();
		double X = -1905.6;
	    double Y = 10;
	    double Z = 988.4;
	    Location spawner = new Location(W, X, Y, Z);
	    p.teleport(spawner);
	}
	else if (o == 3){
		World W = p.getWorld();
		double X = -1948.2;
	    double Y = 12;
	    double Z = 947.7;
	    Location spawner = new Location(W, X, Y, Z);
	    p.teleport(spawner);
	}
	else if (o == 4){
		World W = p.getWorld();
		double X = -1867.2;
	    double Y = 11;
	    double Z = 956.5;
	    Location spawner = new Location(W, X, Y, Z);
	    p.teleport(spawner);
	}
	
	}
 }
  

  public static void TirarEfeitos(Player p)
  {
    p.removePotionEffect(PotionEffectType.ABSORPTION);
    p.removePotionEffect(PotionEffectType.BLINDNESS);
    p.removePotionEffect(PotionEffectType.CONFUSION);
    p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.FAST_DIGGING);
    p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.HARM);
    p.removePotionEffect(PotionEffectType.HEAL);
    p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    p.removePotionEffect(PotionEffectType.HUNGER);
    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    p.removePotionEffect(PotionEffectType.INVISIBILITY);
    p.removePotionEffect(PotionEffectType.JUMP);
    p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    p.removePotionEffect(PotionEffectType.POISON);
    p.removePotionEffect(PotionEffectType.REGENERATION);
    p.removePotionEffect(PotionEffectType.SATURATION);
    p.removePotionEffect(PotionEffectType.SLOW);
    p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    p.removePotionEffect(PotionEffectType.SPEED);
    p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    p.removePotionEffect(PotionEffectType.WEAKNESS);
    p.removePotionEffect(PotionEffectType.WITHER);
    Array.admin.remove(p.getName());
    Array.used.remove(p.getName());
    CombatLog.Sair.remove(p.getName());
    TestClick.click.remove(p.getName());
    Array.warp.remove(p.getName());
    Sobrevivente.dentro.remove(p.getName());
    Sobrevivente.invencivel.remove(p.getName());
    Velotrol.Tempo.remove(p.getName());
    Wither.Tempo.remove(p.getName());
    Alladin.cooldown.remove(p.getName());
    Forcefield.noFF.remove(p);
    Forcefield.cooldown.remove(p);
    Main.stomper.remove(p.getName());
    Main.Avatar.remove(p.getName());
    Array.freeze.remove(p.getName());
    Array.freezing.remove(p.getName());
    Array.Velotrol2.remove(p.getName());
    Vinagre.Habilidade.removeAbility(p);
    Array.kit.put(p, "Sem Kit");
    Cooldown.remove(p);
  }
  
  public static void give(Player p)
  {
    ItemStack bussola = new ItemStack(Material.COMPASS);
    ItemMeta bussola2 = bussola.getItemMeta();
    bussola2.setDisplayName("§aBussola");
    bussola.setItemMeta(bussola2);
    
    ItemStack vermelho = new ItemStack(Material.RED_MUSHROOM, 64);
    ItemMeta vermelho2 = vermelho.getItemMeta();
    vermelho2.setDisplayName("§cCogumelo Vermelho");
    vermelho.setItemMeta(vermelho2);
    
    ItemStack marrom = new ItemStack(Material.BROWN_MUSHROOM, 64);
    ItemMeta marrom2 = marrom.getItemMeta();
    marrom2.setDisplayName("§8Cogumelo Marrom");
    marrom.setItemMeta(marrom2);
    
    ItemStack item = new ItemStack(Material.BOWL, 64);
    ItemMeta item2 = item.getItemMeta();
    item2.setDisplayName("§7Pote");
    @SuppressWarnings({ "unchecked", "rawtypes" })
	List<String> itemlore = new ArrayList();
    itemlore.add("§4use para fazer sopas!");
    item2.setLore(itemlore);
    item.setItemMeta(item2);
    p.getInventory().setItem(8, bussola);
    p.getInventory().setItem(14, vermelho);
    p.getInventory().setItem(15, marrom);
    p.getInventory().setItem(13, item);
  }
 
  public static WorldGuardPlugin getWorldGuard() {
	  
	    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");

	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null;
	    }
	 
	    return (WorldGuardPlugin) plugin;
	}

public static boolean areaPvP(Player p) {
	    ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
	    if (region.allows(DefaultFlag.PVP)) {
	     return true;
	     }
	     return false;
	  }
 
 
  
  
  
  public void saveConfig() {}



@EventHandler
public void onChat(AsyncPlayerChatEvent e)
{
  String message = e.getMessage();
  message = message.replaceAll("§", "&");
  e.setMessage(message);
  String msg = e.getMessage();
  msg = msg.replace("<3", "&c<3");
  msg = msg.replace("dec", "Dev");
  msg = msg.replace("plugin decompilado", "plugin delicia");
  msg = msg.replace("server bosta", "server daora");
  msg = msg.replace("hack", "hacker");
  msg = msg.replace("server lixo", "Foda");
  msg = msg.replace("GodPvP", "sou nub");
  msg = msg.replace("lixo", "GG");
  msg = msg.replace("gay", "&dGG§7");
 
  e.setMessage(msg);
}


public void save() {
	try {
		
		this.warps.save(this.warps1);
		this.arenas.save(this.arenas1);
		this.status.save(this.status1);

				
		
} catch (IOException e) {
	e.printStackTrace();
}
}


public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
    p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
}   

public static org.bukkit.plugin.Plugin getPlugin()
{
  return plugin;
}  

public static boolean SemPvP(Player p)
{
  ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
  if (region.allows(DefaultFlag.PVP)) {
    return true;
  }
  return false;
}   
}


