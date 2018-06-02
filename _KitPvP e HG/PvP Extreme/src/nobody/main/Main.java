package nobody.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nobody.comandos.Admin;
import nobody.comandos.Autosoup;
import nobody.comandos.CC;
import nobody.comandos.Caixa;
import nobody.comandos.Caixas;
import nobody.comandos.ComprarCaixa;
import nobody.comandos.Danoglobal;
import nobody.comandos.Extra;
import nobody.comandos.Gamemode;
import nobody.comandos.Gratis;
import nobody.comandos.Kill;
import nobody.comandos.KillsCMD;
import nobody.comandos.Kit;
import nobody.comandos.KitDiario;
import nobody.comandos.KitPos;
import nobody.comandos.KitSelector;
import nobody.comandos.KitSelector2;
import nobody.comandos.LojaDeItens;
import nobody.comandos.LojaDeKits;
import nobody.comandos.LojaPerms;
import nobody.comandos.Menu;
import nobody.comandos.MenuDeLojas;
import nobody.comandos.Mutechat;
import nobody.comandos.Report;
import nobody.comandos.Skit;
import nobody.comandos.StaffChat;
import nobody.comandos.Tag;
import nobody.comandos.Tell;
import nobody.comandos.TopKills;
import nobody.comandos.Tpall;
import nobody.comandos.Tphere;
import nobody.comandos.WarpEventos;
import nobody.comandos.Warps;
import nobody.comandos.WarpsNormais;
import nobody.comandos.XPCmd;
import nobody.eventos.Broadcast;
import nobody.eventos.Cabeças;
import nobody.eventos.Chat;
import nobody.eventos.Drop;
import nobody.eventos.Fome;
import nobody.eventos.ItemManager;
import nobody.eventos.Join;
import nobody.eventos.Jumps;
import nobody.eventos.KitAPI;
import nobody.eventos.Money;
import nobody.eventos.MoneyRank;
import nobody.eventos.Motd;
import nobody.eventos.Placa;
import nobody.eventos.Quit;
import nobody.eventos.Stats;
import nobody.eventos.VillagerParkour;
import nobody.kit.Anchor;
import nobody.kit.Avatar;
import nobody.kit.Backpacker;
import nobody.kit.Barbarian;
import nobody.kit.Berserker;
import nobody.kit.Bomber;
import nobody.kit.Boxer;
import nobody.kit.C4;
import nobody.kit.Camel;
import nobody.kit.Critical;
import nobody.kit.Deshfire;
import nobody.kit.Ebola;
import nobody.kit.Endermage;
import nobody.kit.Fireman;
import nobody.kit.Fisherman;
import nobody.kit.Flash;
import nobody.kit.ForceField;
import nobody.kit.Frosty;
import nobody.kit.Grappler;
import nobody.kit.Hulk;
import nobody.kit.JellyFish;
import nobody.kit.Kangaroo;
import nobody.kit.Launcher;
import nobody.kit.Lavaman;
import nobody.kit.Magma;
import nobody.kit.Milkman;
import nobody.kit.Monk;
import nobody.kit.Ninja;
import nobody.kit.Phantom;
import nobody.kit.Poseidon;
import nobody.kit.Rain;
import nobody.kit.Reaper;
import nobody.kit.Resouper;
import nobody.kit.Ryu;
import nobody.kit.Snail;
import nobody.kit.Sonic;
import nobody.kit.Specialist;
import nobody.kit.Spiderman;
import nobody.kit.Stomper;
import nobody.kit.Switcher;
import nobody.kit.Thor;
import nobody.kit.Turtle;
import nobody.kit.Viking;
import nobody.kit.Viper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Main extends JavaPlugin {
	
	  public File caixa1;
	  public YamlConfiguration caixa;
	  
	  public File status1;
	  public YamlConfiguration status;
	  
	  public File loja1;
	  public YamlConfiguration loja;
	  
	  public File KitPos1;
	  public YamlConfiguration KitPos;
	  
	  
	public static Plugin plugin;
	public static Main instance;
	public static FileConfiguration config;
	public static ItemManager im = new ItemManager();
	public static Object score;
	
	public static final List<Player> warping = new ArrayList<Player>();
	ArrayList<String> a1 = new ArrayList<String>();
	ArrayList<String> a2 = new ArrayList<String>();
	public static ArrayList<String> mlg = new ArrayList<String>();
	public static Main getInstance()
	  {
	    return instance;
	  }  
	  public static Plugin getPlugin()
	  
	  {
	    return instance;
	  }
	
	  public static Plugin getMain()
	  
	  {
	    return plugin;
	  }
	
	public void onEnable() {
		getLogger().info(ChatColor.GREEN + "ExtremeKits 2016");
		getLogger().info(ChatColor.GREEN + "ExtremeKits 2016");
		getLogger().info(ChatColor.GREEN + "ExtremeKits 2016");
		MoneyRank.createFile1();
		
	    instance = this;
	    plugin = this;
	    saveDefaultConfig();
	    registrareventos();  
	    registrarcomandos();
	    Money.createFile1();
	    
	    File caixa = new File(getDataFolder(), "caixa.yml");
	    if (!caixa.exists()) {
	      saveResource("caixa.yml", false);
	    }
	    this.caixa1 = new File(getDataFolder(), "caixa.yml");
	    this.caixa = YamlConfiguration.loadConfiguration(caixa);
	    save();
	    
	    File loja = new File(getDataFolder(), "loja.yml");
	    if (!loja.exists()) {
	      saveResource("loja.yml", false);
	    }
	    
	    File KitPos = new File(getDataFolder(), "KitPos.yml");
	    if (!KitPos.exists()) {
	      saveResource("KitPos.yml", false);
	    }
	    this.KitPos1 = new File(getDataFolder(), "KitPos.yml");
	    this.KitPos = YamlConfiguration.loadConfiguration(KitPos);
	    save();
	    
	    this.loja1 = new File(getDataFolder(), "loja.yml");
	    this.loja = YamlConfiguration.loadConfiguration(loja);
	    save();
	}
	  
	  public void save()
	  {
	    try
	    {
	      this.caixa.save(this.caixa1);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
      public void save1()
      {
        try
        {
          this.status.save(this.status1);
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        }
	 
	    public void save2()
	    {
	      try
	      {
	        this.loja.save(this.loja1);
	      }
	      catch (IOException e)
	      {
	        e.printStackTrace();
	    }
	    }
	      public void save4()
	      {
	        try
	        {
	          this.KitPos.save(this.KitPos1);
	        }
	        catch (IOException e)
	        {
	          e.printStackTrace();
	        }
	      }
	 void registrareventos() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Join(this), this);
		pm.registerEvents(new Menu(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new Stats(), this);
		pm.registerEvents(new LojaDeKits(), this);
		pm.registerEvents(new Ninja(), this);
		pm.registerEvents(new Fome(), this);
		pm.registerEvents(new Skit(), this);
		pm.registerEvents(new Camel(), this);
		pm.registerEvents(new Tag(), this);
		pm.registerEvents(new LojaDeKits(), this);
		pm.registerEvents(new StaffChat(), this);
		pm.registerEvents(new Quit(), this);
		pm.registerEvents(new KitDiario(), this);
		pm.registerEvents(new Motd(), this);
		pm.registerEvents(new Snail(), this);
		pm.registerEvents(new Deshfire(), this);
		pm.registerEvents(new Mutechat(this), this);
		pm.registerEvents(new Danoglobal(), this);
		pm.registerEvents(new Gamemode(), this);
		pm.registerEvents(new VillagerParkour(), this);
		pm.registerEvents(new Admin(), this);
		pm.registerEvents(new Drop(), this);
		pm.registerEvents(new Thor(), this);
		pm.registerEvents(new WarpEventos(), this);
		pm.registerEvents(new Jumps(this), this);
		pm.registerEvents(new MenuDeLojas(), this);
		pm.registerEvents(new Sonic(), this);
		pm.registerEvents(new Warps(), this);
		pm.registerEvents(new Extra(), this);
		pm.registerEvents(new Placa(this), this);
		pm.registerEvents(new WarpsNormais(), this);
		pm.registerEvents(new LojaPerms(), this);
		pm.registerEvents(new Stomper(), this);
		pm.registerEvents(new Cabeças(this), this);
		pm.registerEvents(new Viking(), this);
		pm.registerEvents(new Anchor(), this);
		pm.registerEvents(new LojaDeItens(this), this);
		pm.registerEvents(new ComprarCaixa(), this);
		pm.registerEvents(new Caixas(), this);
		//
	    Bukkit.getServer().getPluginManager().registerEvents(new Monk(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new LojaDeKits(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Rain(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Avatar(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Phantom(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Backpacker(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new KitSelector2(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new KitSelector(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Barbarian(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new ForceField(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Ebola(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Boxer(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Thor(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Critical(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Deshfire(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Spiderman(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Magma(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Drop(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new C4(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new JellyFish(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Ryu(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Reaper(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Milkman(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Flash(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Fireman(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Endermage(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Bomber(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Launcher(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Switcher(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Hulk(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Grappler(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Anchor(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Frosty(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Camel(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Lavaman(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Resouper(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Poseidon(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Turtle(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Warps(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Berserker(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Specialist(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Ninja(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Viking(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Fisherman(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Viper(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Snail(), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new Kangaroo(), this);
		
		
	}
	 void registrarcomandos() {
	getCommand("heads").setExecutor(new Cabeças(this));
	getCommand("build").setExecutor(new Fome());
	getCommand("topkills").setExecutor(new TopKills());
    getCommand("comprarcaixa").setExecutor(new ComprarCaixa());
    getCommand("caixa").setExecutor(new Caixas());
    getCommand("doarcaixa").setExecutor(new Caixa());
    getCommand("villagerparkour").setExecutor(new VillagerParkour());
	getCommand("lojaitens").setExecutor(new LojaDeItens(this));
	getCommand("lojas").setExecutor(new MenuDeLojas());
	getCommand("lojaperms").setExecutor(new LojaPerms());
	getCommand("aplicar").setExecutor(new Gratis());
	getCommand("darkills").setExecutor(new KillsCMD());
	getCommand("autosoup").setExecutor(new Autosoup());
	getCommand("extra").setExecutor(new Extra());
	getCommand("warpss").setExecutor(new WarpsNormais());
	getCommand("eventos").setExecutor(new Warps());
	getCommand("kill").setExecutor(new Kill());
	getCommand("gm").setExecutor(new Gamemode());
	getCommand("gratis").setExecutor(new Gratis());
	getCommand("admin").setExecutor(new Admin());
	getCommand("menu").setExecutor(new Menu());
	getCommand("eventos").setExecutor(new WarpEventos());
    getCommand("kit").setExecutor(new Kit());
    getCommand("kits").setExecutor(new KitSelector());
    getCommand("kits2").setExecutor(new KitSelector2());
	getCommand("xp").setExecutor(new XPCmd());
	getCommand("warps").setExecutor(new Warps());
	getCommand("skit").setExecutor(new Skit());
    getCommand("kitpos5").setExecutor(new KitPos());
    getCommand("kitpos4").setExecutor(new KitPos());
    getCommand("kitpos3").setExecutor(new KitPos());
    getCommand("kitpos2").setExecutor(new KitPos());
    getCommand("kitpos1").setExecutor(new KitPos());
	getCommand("sc").setExecutor(new StaffChat());
	getCommand("loja").setExecutor(new LojaDeKits());
	getCommand("danoglobal").setExecutor(new Danoglobal());
	getCommand("mutechat").setExecutor(new Mutechat(this));
	getCommand("bc").setExecutor(new Broadcast());
	getCommand("broadcast").setExecutor(new Broadcast());
	getCommand("sc").setExecutor(new StaffChat());
	getCommand("tell").setExecutor(new Tell());
	getCommand("report").setExecutor(new Report(this));
	getCommand("cc").setExecutor(new CC(this));
	getCommand("tag").setExecutor(new Tag());
	getCommand("tpall").setExecutor(new Tpall(this));
	getCommand("tphere").setExecutor(new Tphere());
	}

	 public void tp(Player a, Location loc)
	  {
	    this.a1.add(a.getName());
	    Player p = a;
	    Location loc1 = loc;
	    this.a1.remove(p.getName());
	    p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
	    p.teleport(loc1);

	  }
	
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
  final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
  if ((sender instanceof Player))
  {
    final Player p = (Player)sender;
    if (!(sender instanceof Player))
    {
    }
    if (cmd.getName().equalsIgnoreCase("setSpawn"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("SpawnWorld", p.getLocation().getWorld().getName());
      getConfig().set("SpawnX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("SpawnY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("SpawnZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§2 Spawn Setado");
      return true;
    }
  
    if (cmd.getName().equalsIgnoreCase("setrdm"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("RdmWorld", p.getLocation().getWorld().getName());
      getConfig().set("RdmX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("RdmY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("RdmZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aReiDaMesa setado!");
      return true;
      
    }
    
    if (cmd.getName().equalsIgnoreCase("setfisherman"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("FishWorld", p.getLocation().getWorld().getName());
      getConfig().set("FishX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("FishY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("FishZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aFisherman setado!");
      return true;
      
    }
    
    if (cmd.getName().equalsIgnoreCase("setparkour"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("ParkWorld", p.getLocation().getWorld().getName());
      getConfig().set("ParkX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("ParkY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("ParkZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aParkour Setado!");
      return true;
    }
    
    
    if (cmd.getName().equalsIgnoreCase("setcsgo"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("CSGOWorld", p.getLocation().getWorld().getName());
      getConfig().set("CSGOX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("CSGOY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("CSGOZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aCSGO setado!");
      return true;
      
    }
    
    if (cmd.getName().equalsIgnoreCase("setinferno"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("InfernoWorld", p.getLocation().getWorld().getName());
      getConfig().set("InfernoX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("InfernoY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("InfernoZ", Double.valueOf(p.getLocation().getZ()));
      p.sendMessage("§aInferno setado!");
      return true;
      
    }
    
    if (cmd.getName().equalsIgnoreCase("setmlg"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("mlgWorld", p.getLocation().getWorld().getName());
      getConfig().set("mlgX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("mlgY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("mlgZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aMLG setado!");
      return true;
      
    }
    
    if (cmd.getName().equalsIgnoreCase("setspawn"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("SpawnWorld", p.getLocation().getWorld().getName());
      getConfig().set("SpawnX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("SpawnY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("SpawnZ", Double.valueOf(p.getLocation().getZ()));
      
      saveConfig();
      World world = p.getWorld();
      Location loc = p.getLocation();
      world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      p.sendMessage("§aSpawn setado!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("setfps"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("FpsWorld", p.getLocation().getWorld().getName());
      getConfig().set("FpsX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("FpsY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("FpsZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aFps setado!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("setchallenge"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("ChallengeWorld", p.getLocation().getWorld().getName());
      getConfig().set("ChallengeX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("ChallengeY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("ChallengeZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aChallenge setado!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("setmdr"))
    {
      if (!p.hasPermission("tk.setwarp"))
      {
        sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
        return true;
      }
      getConfig().set("MdrWorld", p.getLocation().getWorld().getName());
      getConfig().set("MdrX", Double.valueOf(p.getLocation().getX()));
      getConfig().set("MdrY", Double.valueOf(p.getLocation().getY()));
      getConfig().set("MdrZ", Double.valueOf(p.getLocation().getZ()));
      saveConfig();
      p.sendMessage("§aMdr setado!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("mdr"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      warping.add(p);
  	  p.setAllowFlight(false);
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
	  p.setFlying(false);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            ItemStack espada = new ItemStack(Material.STONE_SWORD);
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("MdrWorld"));
            double x = Main.this.getConfig().getDouble("MdrX");
            double y = Main.this.getConfig().getDouble("MdrY");
            double z = Main.this.getConfig().getDouble("MdrZ");
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { espada });
            for (int i = 0; i <= 34; i++) {
              p.getInventory().addItem(new ItemStack[] { sopa });
            }
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            KitAPI.setKit(p, "Mdr");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    
    if (cmd.getName().equalsIgnoreCase("parkour"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      warping.add(p);
  	  p.setAllowFlight(false);
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
	  p.setFlying(false);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            p.getInventory().clear();
            ItemStack Espada = new ItemStack(Material.SLIME_BALL);
            ItemMeta Espada1 = Espada.getItemMeta();
            Espada1.setDisplayName("§bAuto-Kill");
            Espada.setItemMeta(Espada1);
            p.getInventory().setItem(0, Espada);
            
            @SuppressWarnings("deprecation")
			ItemStack inv = new ItemStack(Material.getMaterial(351));
            ItemMeta inv1 = inv.getItemMeta();
            inv1.setDisplayName("§bAuto-Kill");
            inv.setItemMeta(inv1);
            p.getInventory().setItem(1, inv);
            
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("ParkWorld"));
            double x = Main.this.getConfig().getDouble("ParkX");
            double y = Main.this.getConfig().getDouble("ParkY");
            double z = Main.this.getConfig().getDouble("ParkZ");
            p.teleport(new Location(w, x, y, z));
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            KitAPI.setKit(p, "Parkour");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    
    if (cmd.getName().equalsIgnoreCase("rdm"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
      
      p.setAllowFlight(false);
	  p.setFlying(false);
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
      
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("RdmWorld"));
            double x = Main.this.getConfig().getDouble("RdmX");
            double y = Main.this.getConfig().getDouble("RdmY");
            double z = Main.this.getConfig().getDouble("RdmZ");
            PlayerInventory inv = p.getInventory();
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
            ItemStack espada = new ItemStack(Material.STONE_SWORD);
            p.getInventory().setArmorContents(null);
            inv.addItem(new ItemStack[] { espada });
            KitAPI.DarSopa(p);
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            KitAPI.setKit(p, "Rdm");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    
    if (cmd.getName().equalsIgnoreCase("CSGO"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
      warping.add(p);
  	  p.setAllowFlight(false);
	  p.setFlying(false);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("CSGOWorld"));
            double x = Main.this.getConfig().getDouble("CSGOX");
            double y = Main.this.getConfig().getDouble("CSGOY");
            double z = Main.this.getConfig().getDouble("CSGOZ");
            PlayerInventory inv = p.getInventory();
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
            ItemStack sopa = new ItemStack(Material.ARROW);
            
            ItemStack espada = new ItemStack(Material.BOW);
            espada.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            p.getInventory().setArmorContents(null);
            inv.addItem(new ItemStack[] { espada });
            inv.addItem(new ItemStack[] { sopa });
   
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            KitAPI.setKit(p, "CSGO");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    
    if (cmd.getName().equalsIgnoreCase("inferno"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
  	  p.setAllowFlight(false);
  	  p.setFlying(false);
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("InfernoWorld"));
            double x = Main.this.getConfig().getDouble("InfernoX");
            double y = Main.this.getConfig().getDouble("InfernoY");
            double z = Main.this.getConfig().getDouble("InfernoZ");
            PlayerInventory inv = p.getInventory();
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
            ItemStack espada = new ItemStack(Material.STONE_SWORD);
            p.getInventory().setArmorContents(null);
            inv.addItem(new ItemStack[] { espada });
            KitAPI.DarSopa(p);
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            KitAPI.setKit(p, "Inferno");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    if (cmd.getName().equalsIgnoreCase("fishermano"))
    {
    	
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
  	  p.setAllowFlight(false);
  	  p.setFlying(false);
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("FishWorld"));
            double x = Main.this.getConfig().getDouble("FishX");
            double y = Main.this.getConfig().getDouble("FishY");
            double z = Main.this.getConfig().getDouble("FishZ");
            PlayerInventory inv = p.getInventory();
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
            ItemStack espada = new ItemStack(Material.FISHING_ROD);
            p.getInventory().setArmorContents(null);
            inv.addItem(new ItemStack[] { espada });
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            KitAPI.setKit(p, "Fisherman");
            Main.warping.remove(p);
            
          }
        }
      }, 100L);
    }
    
    if (cmd.getName().equalsIgnoreCase("mlg"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("mlgWorld"));
            double x = Main.this.getConfig().getDouble("mlgX");
            double y = Main.this.getConfig().getDouble("mlgY");
            double z = Main.this.getConfig().getDouble("mlgZ");
            PlayerInventory inv = p.getInventory();
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
            ItemStack espada = new ItemStack(Material.WATER_BUCKET);
            p.getInventory().setArmorContents(null);
            inv.addItem(new ItemStack[] { espada });
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            mlg.add(p.getName());
            KitAPI.setKit(p, "Mlg");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    
    if (cmd.getName().equalsIgnoreCase("main"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("MainWorld"));
            double x = Main.this.getConfig().getDouble("MainX");
            double y = Main.this.getConfig().getDouble("MainY");
            double z = Main.this.getConfig().getDouble("MainZ");
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
        	  p.setAllowFlight(false);
      	  p.setFlying(false);
            p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
            p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            KitAPI.setKit(p, "Main");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    if (cmd.getName().equalsIgnoreCase("challenge"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
  	  p.setAllowFlight(false);
	  p.setFlying(false);
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("ChallengeWorld"));
            double x = Main.this.getConfig().getDouble("ChallengeX");
            double y = Main.this.getConfig().getDouble("ChallengeY");
            double z = Main.this.getConfig().getDouble("ChallengeZ");
            PlayerInventory inv = p.getInventory();
            p.teleport(new Location(w, x, y, z));
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            ItemStack espada = new ItemStack(Material.STONE_SWORD);
            inv.addItem(new ItemStack[] { espada });
            KitAPI.DarSopa(p);
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            Main.warping.remove(p);
          }
        }
      }, 100L);
    }
    if (cmd.getName().equalsIgnoreCase("fps"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            ItemStack espada = new ItemStack(Material.STONE_SWORD);
    	      espada.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        	  p.setAllowFlight(false);
      	  p.setFlying(false);
            World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("FpsWorld"));
            double x = Main.this.getConfig().getDouble("FpsX");
            double y = Main.this.getConfig().getDouble("FpsY");
            double z = Main.this.getConfig().getDouble("FpsZ");
            p.teleport(new Location(w, x, y, z));
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            p.setAllowFlight(false);
            p.setFlying(false);
            Main.warping.remove(p);
            KitAPI.setKit(p, "Fps");
            p.getInventory().setArmorContents(null);
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { espada });
            KitAPI.DarSopa(p);
            {
            }
          }
        }
      }, 100L);
    }
    if (cmd.getName().equalsIgnoreCase("spawn"))
    {
      p.sendMessage("§6{§a§lWARP§6} §7Teleportando em 5 Segundos!");
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 105, 100));
      warping.add(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
      {
        public void run()
        {
          if (Main.warping.contains(p))
          {
            p.teleport(p.getWorld().getSpawnLocation());
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            p.removePotionEffect(PotionEffectType.JUMP);
            p.removePotionEffect(PotionEffectType.SPEED);
            p.removePotionEffect(PotionEffectType.POISON);
            p.removePotionEffect(PotionEffectType.SLOW);
            
            p.getInventory().setArmorContents(null);
            for (PotionEffect effect : p.getActivePotionEffects()) {
              p.removePotionEffect(effect.getType());
            }
            p.getInventory().setArmorContents(null);
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            p.removePotionEffect(PotionEffectType.SPEED);
            p.removePotionEffect(PotionEffectType.JUMP);
            
            p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
            Main.warping.remove(p);
            
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            p.removePotionEffect(PotionEffectType.SPEED);
            p.removePotionEffect(PotionEffectType.JUMP);
            p.getInventory().clear();
            
            Join.entrar(p);
  	    
        }
      }
    }, 100L);
  }
}
return true;
		}
	}