package Pedrao;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import Pedrao.Comandos.Admin;
import Pedrao.Comandos.Arena;
import Pedrao.Comandos.AutoSoup;
import Pedrao.Comandos.Ban;
import Pedrao.Comandos.Gm;
import Pedrao.Comandos.Kick;
import Pedrao.Comandos.Kit;
import Pedrao.Comandos.Kits;
import Pedrao.Comandos.Report;
import Pedrao.Comandos.Sc;
import Pedrao.Comandos.StatusM;
import Pedrao.Comandos.Tag;
import Pedrao.Comandos.Tell;
import Pedrao.Comandos.Tp;
import Pedrao.Comandos.UnBan;
import Pedrao.Comandos.Youtuber;
import Pedrao.Comandos.cc;
import Pedrao.Eventos.AntSpam;
import Pedrao.Eventos.Chat;
import Pedrao.Eventos.Events;
import Pedrao.Eventos.Habilidade;
import Pedrao.Eventos.Jump;
import Pedrao.Eventos.Placa;
import Pedrao.Eventos.Players;
import Pedrao.Eventos.Sopa;
import Pedrao.Eventos.Sumir;
import Pedrao.Eventos.Sword;
import Pedrao.Feast.Ffeast;
import Pedrao.Feast.SFeast;
import Pedrao.Feast.SetFeast;
import Pedrao.Habilidades.Anchor;
import Pedrao.Habilidades.BloodGun;
import Pedrao.Habilidades.C4;
import Pedrao.Habilidades.ChestPlate;
import Pedrao.Habilidades.Curandeiro;
import Pedrao.Habilidades.DeathNote;
import Pedrao.Habilidades.DeshFire;
import Pedrao.Habilidades.FireBender;
import Pedrao.Habilidades.Fisherman;
import Pedrao.Habilidades.ForceField;
import Pedrao.Habilidades.Gladiator;
import Pedrao.Habilidades.Grappler;
import Pedrao.Habilidades.Gravity;
import Pedrao.Habilidades.Hulk;
import Pedrao.Habilidades.Jutso;
import Pedrao.Habilidades.Kangaroo;
import Pedrao.Habilidades.Kronos;
import Pedrao.Habilidades.Laucher;
import Pedrao.Habilidades.LifeStealer;
import Pedrao.Habilidades.Mago;
import Pedrao.Habilidades.Ninja;
import Pedrao.Habilidades.Pikachu;
import Pedrao.Habilidades.Rain;
import Pedrao.Habilidades.Sasuke;
import Pedrao.Habilidades.Snail;
import Pedrao.Habilidades.Sonic;
import Pedrao.Habilidades.Stomper;
import Pedrao.Habilidades.Terrorista;
import Pedrao.Habilidades.Thresh;
import Pedrao.Habilidades.Tornado;
import Pedrao.Habilidades.Urano;
import Pedrao.Habilidades.Velotrol;
import Pedrao.Habilidades.Viper;
import Pedrao.Habilidades.Vunerable;
import Pedrao.Habilidades.WaterBender;
import Pedrao.KitDiario.AbrirKitDiario;
import Pedrao.ScoreB.ScoreDoBasic;
import Pedrao.ScoreB.Scroller;
import Pedrao.ScoreB.Status;
import Pedrao.Warps.FPS;
import Pedrao.Warps.Mlg;
import Pedrao.Warps.SetFps;
import Pedrao.Warps.SetSpawn;
import Pedrao.Warps.Setmlg;
import Pedrao.Warps.Spawn;
import Pedrao.Warps.Warp;
import Pedrao.Warps.fMlg;
import Pedrao.XP.DarXp;
import Pedrao.XP.GanharXP;
import Pedrao.XP.MyConfigManager;
import Pedrao.XP.VerXp;
import Pedrao.XP.XpM;

public class Main
  extends JavaPlugin
{
  public static Plugin plugin;
  public static Main instance;
  public static MyConfigManager manager;
  public static String prefix = "§7{§e§lSoul§f§lPvP§7} §7";
  public static String cl = "§7{§e§lSoul§f§lPvP§7} §c§lVoce esta em cooldowm!!";
  public static String semperm = "§7{§e§lSoul§f§lPvP§7} §c§l§oVoce nao tem Permissao !";
  public static ArrayList<String> staff = new ArrayList<String>();
  public static ArrayList<String> score = new ArrayList<>();
  
  public static Main getInstance()
  {
    return instance;
  }
  
  public static Plugin getPlugin()
  {
    return plugin;
  }
  
  public void onEnable()
  {
    Bukkit.getServer().getConsoleSender().sendMessage(prefix + "§A§lATIVADO");
    saveDefaultConfig();
    instance = this;
    plugin = this;
    getConfig().options().copyDefaults(true);
    getConfig().options().copyHeader(true);
    saveConfig();
    
    Eventos();
    Comandos();
    
    manager = new MyConfigManager(this);
    SFeast.start();
    SFeast.start1();
    XpM.loadMoneyManager();
    
	//scoreboard
	new BukkitRunnable() {
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			for(Player p:Bukkit.getOnlinePlayers()) {
				if(!score.contains(p.getName())) {
					ScoreDoBasic.setScoreBoard(p);
				}
				else {
					ScoreDoBasic.removeScoreBoard(p);
				}
			}
		}
	}.runTaskTimer(this, 0, 20);
  }
  
  public void onDisable()
  {
    Bukkit.getServer().getConsoleSender().sendMessage(prefix + "§4§lDESATIVADO");
  }
  
  public void Eventos()
  {
    PluginManager Eventos = Bukkit.getPluginManager();
    Eventos.registerEvents(new Events(this), this);
    Eventos.registerEvents(new KitAPI(this), this);
    Eventos.registerEvents(new Kit(this), this);
    Eventos.registerEvents(new Admin(this), this);
    Eventos.registerEvents(new Ban(this), this);
    Eventos.registerEvents(new UnBan(this), this);
    Eventos.registerEvents(new Tag(this), this);
    Eventos.registerEvents(new AutoSoup(this), this);
    Eventos.registerEvents(new Report(this), this);
    Eventos.registerEvents(new Arena(this), this);
    Eventos.registerEvents(new Habilidade(this), this);
    Eventos.registerEvents(new Sopa(this), this);
    Eventos.registerEvents(new Sword(this), this);
    Eventos.registerEvents(new Players(this), this);
    Eventos.registerEvents(new AntSpam(this), this);
    Eventos.registerEvents(new Sumir(this), this);
    Eventos.registerEvents(new ForceField(this), this);
    Eventos.registerEvents(new Kits(this), this);
    Eventos.registerEvents(new Kangaroo(this), this);
    Eventos.registerEvents(new Fisherman(this), this);
    Eventos.registerEvents(new Anchor(this), this);
    Eventos.registerEvents(new Kronos(this), this);
    Eventos.registerEvents(new Stomper(this), this);
    Eventos.registerEvents(new Viper(this), this);
    Eventos.registerEvents(new Snail(this), this);
    Eventos.registerEvents(new Curandeiro(this), this);
    Eventos.registerEvents(new FireBender(this), this);
    Eventos.registerEvents(new DeathNote(this), this);
    Eventos.registerEvents(new BloodGun(this), this);
    Eventos.registerEvents(new WaterBender(this), this);
    Eventos.registerEvents(new Jump(this), this);
    Eventos.registerEvents(new Gm(this), this);
    Eventos.registerEvents(new Tp(this), this);
    Eventos.registerEvents(new Placa(this), this);
    Eventos.registerEvents(new Tell(this), this);
    Eventos.registerEvents(new cc(this), this);
    Eventos.registerEvents(new Kick(this), this);
    Eventos.registerEvents(new Chat(this), this);
    Eventos.registerEvents(new ScoreDoBasic(), this);
    Eventos.registerEvents(new Status(), this);
    Eventos.registerEvents(new GanharXP(), this);
    Eventos.registerEvents(new VerXp(), this);
    Eventos.registerEvents(new Warp(), this);
    Eventos.registerEvents(new SetFeast(this), this);
    Eventos.registerEvents(new FPS(this), this);
    Eventos.registerEvents(new StatusM(this), this);
    Eventos.registerEvents(new Ffeast(this), this);
    Eventos.registerEvents(new AbrirKitDiario(), this);
    Eventos.registerEvents(new SFeast(this), this);
    Eventos.registerEvents(new SetFps(this), this);
    Eventos.registerEvents(new Spawn(this), this);
    Eventos.registerEvents(new fMlg(this), this);
    Eventos.registerEvents(new Mlg(this), this);
    Eventos.registerEvents(new Setmlg(this), this);
    Eventos.registerEvents(new Terrorista(this), this);
    Eventos.registerEvents(new Tornado(this), this);
    Eventos.registerEvents(new Urano(this), this);
    Eventos.registerEvents(new Sonic(this), this);
    Eventos.registerEvents(new DeshFire(this), this);
    Eventos.registerEvents(new Gravity(this), this);
    Eventos.registerEvents(new Velotrol(this), this);
    Eventos.registerEvents(new Jutso(this), this);
    Eventos.registerEvents(new Rain(this), this);
    Eventos.registerEvents(new Sasuke(this), this);
    Eventos.registerEvents(new Vunerable(this), this);
    Eventos.registerEvents(new Grappler(this), this);
    Eventos.registerEvents(new Laucher(this), this);
    Eventos.registerEvents(new Pikachu(this), this);
    Eventos.registerEvents(new Ninja(this), this);
    Eventos.registerEvents(new Hulk(this), this);
    Eventos.registerEvents(new LifeStealer(this), this);
    Eventos.registerEvents(new ChestPlate(this), this);
    Eventos.registerEvents(new Sword(this), this);
    Eventos.registerEvents(new Mago(this), this);
    Eventos.registerEvents(new C4(this), this);
    Eventos.registerEvents(new Thresh(this), this);
    Eventos.registerEvents(new Sc(), this);
  }
  public void Comandos()
  {
	    getCommand("arenaset").setExecutor(new Arena(this));
	    getCommand("kit").setExecutor(new Kit(this));
	    getCommand("kits").setExecutor(new Kits(this));
	    getCommand("FPS").setExecutor(new FPS(this));
	    getCommand("admin").setExecutor(new Admin(this));
	    getCommand("report").setExecutor(new Report(this));
	    getCommand("autosoup").setExecutor(new AutoSoup(this));
	    getCommand("tag").setExecutor(new Tag(this));
	    getCommand("ban").setExecutor(new Ban(this));
	    getCommand("unban").setExecutor(new UnBan(this));
	    getCommand("Gm").setExecutor(new Gm(this));
	    getCommand("gamemode").setExecutor(new Gm(this));
	    getCommand("setfeast").setExecutor(new SetFeast(this));
	    getCommand("feast").setExecutor(new SetFeast(this));
	    getCommand("rfeast").setExecutor(new SetFeast(this));
	    getCommand("Tp").setExecutor(new Tp(this));
	    getCommand("Tell").setExecutor(new Tell(this));
	    getCommand("cc").setExecutor(new cc(this));
	    getCommand("Kick").setExecutor(new Kick(this));
	    getCommand("Chat").setExecutor(new Chat(this));
	    getCommand("setspawn").setExecutor(new SetSpawn(this));
	    getCommand("spawn").setExecutor(new Spawn(this));
	    getCommand("setmlg").setExecutor(new Setmlg(this));
	    getCommand("mlg").setExecutor(new Mlg(this));
	    getCommand("setfps").setExecutor(new SetFps(this));
	    getCommand("Youtuber").setExecutor(new Youtuber());
	    getCommand("darxp").setExecutor(new DarXp());
	    getCommand("xp").setExecutor(new VerXp());
	    getCommand("sc").setExecutor(new Sc());
	    getCommand("warps").setExecutor(new Warp());
  }
}