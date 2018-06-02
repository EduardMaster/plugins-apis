package Zey.PvP.Main;

import Zey.PvP.APIs.TheTitle;
import Zey.PvP.Cassino.ApostasListener;
import Zey.PvP.Commands.AdminCommand;
import Zey.PvP.Commands.AplicarCommand;
import Zey.PvP.Commands.AutoSoupCommand;
import Zey.PvP.Commands.BroadcastCommand;
import Zey.PvP.Commands.BuildCommand;
import Zey.PvP.Commands.CageCommand;
import Zey.PvP.Commands.CcCommand;
import Zey.PvP.Commands.ChatCommand;
import Zey.PvP.Commands.DarCoinsCommand;
import Zey.PvP.Commands.FinalizarCommand;
import Zey.PvP.Commands.FlyCommand;
import Zey.PvP.Commands.GmCommand;
import Zey.PvP.Commands.HeadCommand;
import Zey.PvP.Commands.InfoCommand;
import Zey.PvP.Commands.IniciarCommand;
import Zey.PvP.Commands.InvCommand;
import Zey.PvP.Commands.KitCommand;
import Zey.PvP.Commands.LigaCommand;
import Zey.PvP.Commands.MacroTestCommand;
import Zey.PvP.Commands.PingCommand;
import Zey.PvP.Commands.PvPCommand;
import Zey.PvP.Commands.RecraftCommand;
import Zey.PvP.Commands.ReportCommand;
import Zey.PvP.Commands.LimparTelaCommand;
import Zey.PvP.Commands.LobbyCommand;
import Zey.PvP.Commands.ScoreCommand;
import Zey.PvP.Commands.SetArenaCommand;
import Zey.PvP.Commands.SetGroupCommand;
import Zey.PvP.Commands.SetVipCommand;
import Zey.PvP.Commands.SortearKit;
import Zey.PvP.Commands.SortearVip;
import Zey.PvP.Commands.TagCommand;
import Zey.PvP.Commands.TellCommand;
import Zey.PvP.Commands.TpAllCommand;
import Zey.PvP.Commands.TpCommand;
import Zey.PvP.Commands.TpHereCommand;
import Zey.PvP.Commands.Vis;
import Zey.PvP.Commands.sKit;
import Zey.PvP.Config.MyConfigManager;
import Zey.PvP.Config.Status;
import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Eventos.Admin;
import Zey.PvP.Eventos.AntFlood;
import Zey.PvP.Eventos.ChatForm;
import Zey.PvP.Eventos.Direito;
import Zey.PvP.Eventos.Entrar;
import Zey.PvP.Eventos.GanharXP;
import Zey.PvP.Eventos.Geral;
import Zey.PvP.Eventos.Nerfs;
import Zey.PvP.Eventos.ParkourJump;
import Zey.PvP.Eventos.PlacaDeRecraft;
import Zey.PvP.Eventos.PlacaDaLava;
import Zey.PvP.Eventos.PlacaDeSopa;
import Zey.PvP.Eventos.TabPersonalizado;
import Zey.PvP.JumpBlocks.DiamondJump;
import Zey.PvP.JumpBlocks.EmeraldJump;
import Zey.PvP.JumpBlocks.IronJump;
import Zey.PvP.Kits.Ajnin;
import Zey.PvP.Kits.Anchor;
import Zey.PvP.Kits.AntiTower;
import Zey.PvP.Kits.Armor;
import Zey.PvP.Kits.Avatar;
import Zey.PvP.Kits.C4;
import Zey.PvP.Kits.Camel;
import Zey.PvP.Kits.Confuser;
import Zey.PvP.Kits.DeshFire;
import Zey.PvP.Kits.Fisherman;
import Zey.PvP.Kits.Gladiator;
import Zey.PvP.Kits.Grappler;
import Zey.PvP.Kits.HotPotato;
import Zey.PvP.Kits.Hulk;
import Zey.PvP.Kits.JellyFish;
import Zey.PvP.Kits.Kangaroo;
import Zey.PvP.Kits.Madman;
import Zey.PvP.Kits.Magma;
import Zey.PvP.Kits.Monk;
import Zey.PvP.Kits.Ninja;
import Zey.PvP.Kits.Poseidon;
import Zey.PvP.Kits.QuickDropper;
import Zey.PvP.Kits.Rain;
import Zey.PvP.Kits.Resouper;
import Zey.PvP.Kits.Snail;
import Zey.PvP.Kits.Sonic;
import Zey.PvP.Kits.Specialist;
import Zey.PvP.Kits.Stomper;
import Zey.PvP.Kits.Switcher;
import Zey.PvP.Kits.Swords;
import Zey.PvP.Kits.TheForceField;
import Zey.PvP.Kits.Thor;
import Zey.PvP.Kits.Thresh;
import Zey.PvP.Kits.TimeLord;
import Zey.PvP.Kits.Turtle;
import Zey.PvP.Kits.Viking;
import Zey.PvP.Kits.Viper;
import Zey.PvP.Menus.MenuAdm;
import Zey.PvP.Menus.MenuCabeças;
import Zey.PvP.Menus.MenuEventos;
import Zey.PvP.Menus.MenuGeral;
import Zey.PvP.Menus.MenuKits;
import Zey.PvP.Menus.MenuKits2;
import Zey.PvP.Menus.MenuLojaExtras;
import Zey.PvP.Menus.MenuLojaKits;
import Zey.PvP.Menus.MenuLojaVips;
import Zey.PvP.Menus.MenuOutros;
import Zey.PvP.Menus.MenuPerfil;
import Zey.PvP.Menus.MenuWarps;
import Zey.PvP.Score.PlayerListener;
import Zey.PvP.Score.SManager;
import Zey.PvP.Score.ScoreB;
import Zey.PvP.Utils.Proteção;
import Zey.PvP.Warps.Fps;
import Zey.PvP.Warps.Lava;
import Zey.PvP.Warps.Evento;
import Zey.PvP.Warps.Parkour;
import Zey.PvP.Warps.SetFps;
import Zey.PvP.Warps.SetLava;
import Zey.PvP.Warps.SetEvento;
import Zey.PvP.Warps.SetParkour;
import Zey.PvP.Warps.SetSpawn;
import Zey.PvP.Warps.SetarRdm;
import Zey.PvP.Warps.Setthemain;
import Zey.PvP.Warps.Spawn;
import Zey.PvP.Warps.TheMain;
import Zey.PvP.Warps.WarpRdm;
import net.minecraft.util.com.google.common.collect.Lists;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.defaults.ScoreboardCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

@SuppressWarnings("unused")
public class Main extends JavaPlugin
{
  public static String prefix;
  public static String loja;
  public static String ts;
  public static String discord;
  public static String motd;
  public static String motd2;
  public static Plugin plugin;
  public static Main instance;
  public static MyConfigManager manager;
  
  public static List<String> admins = Lists.newArrayList();
  
  public static Main getInstace()
  {
    return instance;
  }

  public static Main getInstance1()
  {
    return instance;
  }

  public static Main getPlugin() {
      return (Main)JavaPlugin.getProvidingPlugin((Class<?>)Main.class);
  }

  @SuppressWarnings("deprecation")
public void onEnable() {
		for (Player todos : Bukkit.getOnlinePlayers()) {
			todos.kickPlayer("§6§lZey§f§lNetwork \n \n §cServidor Reiniciando \n Para sua segurança e a de outros jogadores(a), você foi kickado. \n\nAguarde o servidor reiniciar e entre para jogar novamente =)");
		}
   SManager.onEnable();
   this.getServer().getPluginManager().registerEvents((Listener)new PlayerListener(), (Plugin)this);
    try {
      saveDefaultConfig();
    }
    catch (Exception localException) {
    }
    prefix = ("§6§lZey§f§lPvP");
    motd = ("§6§lZey§f§lNetwork §7(1.7, 1.8) \n§e§lServidor, ZeyPvP - 1.");
    motd2 = ("§6§lZey§f§lNetwork §7(1.7, 1.8) \n§c§lServidor em manutenção.");
    
	Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
	Bukkit.getConsoleSender().sendMessage("          §6§lZey§f§lNetwork        ");
	Bukkit.getConsoleSender().sendMessage("                                       ");
	Bukkit.getConsoleSender().sendMessage("      §6§lZey§f§lPvP §a§lHABILITADO");
	Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");

    getConfig().options().copyDefaults(true);
    getConfig().options().copyHeader(true);
    saveConfig();
    manager = new MyConfigManager(this);
    ZeyCoins.loadMoneyManager();

    instance = this;
    plugin = this;
    Eventos();
    Comandos();
    Kits();
  }
  

  public void onDisable()
  {
	Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
	Bukkit.getConsoleSender().sendMessage("          §6§lZey§f§lNetwork        ");
	Bukkit.getConsoleSender().sendMessage("                                       ");
	Bukkit.getConsoleSender().sendMessage("      §6§lZey§f§lPvP §c§lDESABILITADO!");
	Bukkit.getConsoleSender().sendMessage("§b§l§m-------------------------------------");
  }

  public void Eventos()
  {
    PluginManager Eventos = Bukkit.getPluginManager();
    Eventos.registerEvents(new PlacaDaLava(), this);
    Eventos.registerEvents(new PlacaDeRecraft(), this);
    Eventos.registerEvents(new Proteção(), this);
    Eventos.registerEvents(new Admin(this), this);
	Eventos.registerEvents(new DiamondJump(this), this);
	Eventos.registerEvents(new EmeraldJump(this), this);
	Eventos.registerEvents(new IronJump(this), this);
    Eventos.registerEvents(new GmCommand(this), this);
    Eventos.registerEvents(new TheTitle(), this);
    Eventos.registerEvents(new AntFlood(this), this);
    Eventos.registerEvents(new Entrar(), this);
    Eventos.registerEvents(new PingCommand(), this);
    Eventos.registerEvents(new CcCommand(this), this);
    Eventos.registerEvents(new MenuGeral(), this);
    Eventos.registerEvents(new Direito(), this);
    Eventos.registerEvents(new BroadcastCommand(), this);
    Eventos.registerEvents(new SetArenaCommand(this), this);
    Eventos.registerEvents(new KitCommand(this), this);
    Eventos.registerEvents(new Geral(), this);
    Eventos.registerEvents(new MenuPerfil(), this);
    Eventos.registerEvents(new MenuOutros(), this);
    Eventos.registerEvents(new TabPersonalizado(this), this);
    Eventos.registerEvents(new InvCommand(), this);
    Eventos.registerEvents(new GanharXP(), this);
    Eventos.registerEvents(new MyConfigManager(this), this);
    Eventos.registerEvents(new ZeyCoins(), this);
    Eventos.registerEvents(new ChatForm(), this);
    Eventos.registerEvents(new Status(), this);
    Eventos.registerEvents(new PvPCommand(), this);
    Eventos.registerEvents(new BuildCommand(), this);
    Eventos.registerEvents(new MenuKits2(this), this);
    Eventos.registerEvents(new MenuKits(this), this);
    Eventos.registerEvents(new TagCommand(), this);
    Eventos.registerEvents(new HeadCommand(), this);
    Eventos.registerEvents(new Fps(this), this);
    Eventos.registerEvents(new Lava(this), this);
    Eventos.registerEvents(new Evento(this), this);
    Eventos.registerEvents(new Parkour(this), this);
    Eventos.registerEvents(new SetarRdm(this), this);
    Eventos.registerEvents(new SetFps(this), this);
    Eventos.registerEvents(new SetLava(this), this);
    Eventos.registerEvents(new SetEvento(this), this);
    Eventos.registerEvents(new SetParkour(this), this);
    Eventos.registerEvents(new PlacaDeSopa(this), this);
    Eventos.registerEvents(new SetSpawn(this), this);
    Eventos.registerEvents(new Setthemain(this), this);
    Eventos.registerEvents(new Spawn(this), this);
    Eventos.registerEvents(new TheMain(this), this);
    Eventos.registerEvents(new WarpRdm(this), this);
    Eventos.registerEvents(new MenuWarps(), this);
    Eventos.registerEvents(new MenuLojaKits(this), this);
    Eventos.registerEvents(new MenuLojaVips(), this);
    Eventos.registerEvents(new MenuEventos(), this);
    Eventos.registerEvents(new MenuLojaExtras(this), this);
    Eventos.registerEvents(new MacroTestCommand(), this);
    Eventos.registerEvents(new ParkourJump(this), this);
    Eventos.registerEvents(new Vis(), this);
    Eventos.registerEvents(new MenuCabeças(this), this);
    Eventos.registerEvents(new ApostasListener(), this);
    Eventos.registerEvents(new ChatCommand(this), this);
  }

  void Comandos() {
		getCommand("admin").setExecutor(new AdminCommand(this));
		getCommand("autosoup").setExecutor(new AutoSoupCommand(this));
		getCommand("bc").setExecutor(new BroadcastCommand());
		getCommand("build").setExecutor(new BuildCommand());
		getCommand("cage").setExecutor(new CageCommand());
		getCommand("cc").setExecutor(new CcCommand(this));
		getCommand("chat").setExecutor(new ChatCommand(this));
		getCommand("darcoins").setExecutor(new DarCoinsCommand());
		getCommand("finalizar").setExecutor(new FinalizarCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("gm").setExecutor(new GmCommand(this));
		getCommand("head").setExecutor(new HeadCommand());
		getCommand("iniciar").setExecutor(new IniciarCommand());
		getCommand("inv").setExecutor(new InvCommand());
		getCommand("kit").setExecutor(new KitCommand(this));
		getCommand("liga").setExecutor(new LigaCommand());
		getCommand("testmacro").setExecutor(new MacroTestCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("pvp").setExecutor(new PvPCommand());
		getCommand("score").setExecutor(new ScoreCommand());
		getCommand("setarena").setExecutor(new SetArenaCommand(this));
		getCommand("setgroup").setExecutor(new SetGroupCommand());
		getCommand("setvip").setExecutor(new SetVipCommand());
		getCommand("skit").setExecutor(new sKit(this));
		getCommand("sortearkit").setExecutor(new SortearKit());
	    getCommand("sortearvip").setExecutor(new SortearVip());
	    getCommand("tag").setExecutor(new TagCommand());
	    getCommand("tpall").setExecutor(new TpAllCommand());
	    getCommand("tp").setExecutor(new TpCommand());
	    getCommand("tphere").setExecutor(new TpHereCommand());
	    getCommand("vis").setExecutor(new Vis());
	    getCommand("limpartela").setExecutor(new LimparTelaCommand());
	    getCommand("recraft").setExecutor(new RecraftCommand());
	    getCommand("tell").setExecutor(new TellCommand());
	    getCommand("aplicar").setExecutor(new AplicarCommand());
	    getCommand("ajuda").setExecutor(new InfoCommand());
	    getCommand("report").setExecutor(new ReportCommand(this));
	
    getCommand("fps").setExecutor(new Fps(this));
    getCommand("challenge").setExecutor(new Lava(this));
    getCommand("evento").setExecutor(new Evento(this));
    getCommand("parkour").setExecutor(new Parkour(this));
    getCommand("rdmset").setExecutor(new SetarRdm(this));
    getCommand("fpsset").setExecutor(new SetFps(this));
    getCommand("challengeset").setExecutor(new SetLava(this));
    getCommand("eventoset").setExecutor(new SetEvento(this));
    getCommand("parkourset").setExecutor(new SetParkour(this));
    getCommand("mainset").setExecutor(new Setthemain(this));
    getCommand("spawnset").setExecutor(new SetSpawn(this));
    getCommand("main").setExecutor(new TheMain(this));
    getCommand("spawn").setExecutor(new Spawn(this));
    getCommand("lojakits").setExecutor(new MenuLojaKits(this));
    getCommand("rdm").setExecutor(new WarpRdm(this));
    getCommand("lojaextras").setExecutor(new MenuLojaExtras(this));
  }

  public void Kits()
  {
    PluginManager Eventos = Bukkit.getPluginManager();
    Eventos.registerEvents(new Ajnin(), this);
    Eventos.registerEvents(new Anchor(), this);
    Eventos.registerEvents(new Armor(), this);
    Eventos.registerEvents(new Avatar(), this);
    Eventos.registerEvents(new C4(), this);
    Eventos.registerEvents(new Nerfs(), this);
    Eventos.registerEvents(new DeshFire(this), this);
    Eventos.registerEvents(new Fisherman(this), this);
    Eventos.registerEvents(new Gladiator(this), this);
    Eventos.registerEvents(new Hulk(), this);
    Eventos.registerEvents(new JellyFish(), this);
    Eventos.registerEvents(new Kangaroo(), this);
    Eventos.registerEvents(new Magma(), this);
    Eventos.registerEvents(new Monk(), this);
    Eventos.registerEvents(new MenuAdm(), this);
    Eventos.registerEvents(new Ninja(this), this);
    Eventos.registerEvents(new Poseidon(), this);
    Eventos.registerEvents(new Resouper(), this);
    Eventos.registerEvents(new Snail(this), this);
    Eventos.registerEvents(new Sonic(this), this);
    Eventos.registerEvents(new Stomper(this), this);
    Eventos.registerEvents(new Switcher(), this);
    Eventos.registerEvents(new Swords(), this);
    Eventos.registerEvents(new Grappler(this), this);
    Eventos.registerEvents(new TheForceField(this), this);
    Eventos.registerEvents(new Thor(), this);
    Eventos.registerEvents(new Thresh(this), this);
    Eventos.registerEvents(new QuickDropper(), this);
    Eventos.registerEvents(new Turtle(), this);
    Eventos.registerEvents(new Camel(), this);
    Eventos.registerEvents(new Rain(), this);
    Eventos.registerEvents(new TimeLord(), this);
    Eventos.registerEvents(new Confuser(), this);
    Eventos.registerEvents(new Viking(), this);
    Eventos.registerEvents(new Viper(this), this);
    Eventos.registerEvents(new AntiTower(), this);
    Eventos.registerEvents(new Madman(), this);
    Eventos.registerEvents(new Specialist(), this);
    Eventos.registerEvents(new HotPotato(), this);
   }
  }
