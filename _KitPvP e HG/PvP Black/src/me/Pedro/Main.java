package me.Pedro;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;
import me.Pedro.Eventos.Protecao;
import me.Pedro.INV.Caixa;
import me.Pedro.INV.CaixaKit;
import me.Pedro.INV.CaixaXP;
import me.Pedro.INV.Kits;
import me.Pedro.INV.Loja;
import me.Pedro.INV.MiniGamesInv;
import me.Pedro.INV.Warps;
import me.Pedro.Minigames.ClickTest;
import me.Pedro.Minigames.Minigames;
import me.Pedro.Score.ScoreBoards;
import me.Pedro.Score.Status;
import me.Pedro.XP.MyConfigManager;
import me.Pedro.XP.MyConfigManager;
import me.Pedro.CMD.Cwarps;
import me.Pedro.CMD.Kit;
import me.Pedro.Eventos.API;
import me.Pedro.Eventos.Evento;
import me.Pedro.Eventos.HAB;
import me.Pedro.XP.XpM;

public class Main
  extends JavaPlugin
{
public static Plugin plugin;
  public static Main instance;
	public static MyConfigManager manager;
	public static EffectManager em;
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
    Bukkit.getServer().getConsoleSender().sendMessage("§A§lATIVADO");
    saveDefaultConfig();
    instance = this;
    plugin = this;
    getConfig().options().copyDefaults(true);
    getConfig().options().copyHeader(true);
    saveConfig();
	em = new EffectManager(EffectLib.instance());
    Eventos();
    Comandos();
	manager = new MyConfigManager(this);
	XpM.loadMoneyManager();
	new BukkitRunnable() {
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			for(Player p:Bukkit.getOnlinePlayers()) {
				if(!score.contains(p.getName())) {
					ScoreBoards.setScoreBoard(p);
				}
				else {
					ScoreBoards.clearScoreboard(p);
				}
			}
		}
	}.runTaskTimer(this, 0, 20);
  }
  public void onDisable()
  {
    Bukkit.getServer().getConsoleSender().sendMessage("§4§lDESATIVADO");
  }
  
  public void Eventos()
  {
	    PluginManager Eventos = Bukkit.getPluginManager();
	    Eventos.registerEvents(new Status(this), this);
	    Eventos.registerEvents(new Protecao(this), this);
	    Eventos.registerEvents(new Evento(this), this);
	    Eventos.registerEvents(new Kits(this), this);
	    Eventos.registerEvents(new API(this), this);
	    Eventos.registerEvents(new HAB(this), this);
	    Eventos.registerEvents(new Warps(this), this);
	    Eventos.registerEvents(new Caixa(this), this);
	    Eventos.registerEvents(new CaixaKit(this), this);
	    Eventos.registerEvents(new CaixaXP(this), this);
	    Eventos.registerEvents(new Minigames(this), this);
	    Eventos.registerEvents(new MiniGamesInv(this), this);
	    Eventos.registerEvents(new Loja(this), this);
  }
  public void Comandos()
  {
	    getCommand("kit").setExecutor(new Kit(this));
	    getCommand("clicktest").setExecutor(new ClickTest(this));
	    getCommand("setspawn").setExecutor(new Cwarps(this));
	    getCommand("spawn").setExecutor(new Cwarps(this));
	    getCommand("setfps").setExecutor(new Cwarps(this));
	    getCommand("fps").setExecutor(new Cwarps(this));
	    getCommand("setlava").setExecutor(new Cwarps(this));
	    getCommand("lava").setExecutor(new Cwarps(this));
	    getCommand("setrdm").setExecutor(new Cwarps(this));
	    getCommand("rdm").setExecutor(new Cwarps(this));
	    getCommand("kreload").setExecutor(new Cwarps(this));
  }
}