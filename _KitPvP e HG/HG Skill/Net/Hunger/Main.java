package Net.Hunger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import Net.Hunger.Borda.BorderBlocks;
import Net.Hunger.Borda.BorderMove;
import Net.Hunger.Borda.BorderType;
import Net.Hunger.Borda.WorldBorder;
import Net.Hunger.Cheat.WrapperPlayClientUseEntity;
import Net.Hunger.Comandos.AuraCheck;
import Net.Hunger.Comandos.CMDAdmin;
import Net.Hunger.Comandos.CMDAplicar;
import Net.Hunger.Comandos.CMDArena;
import Net.Hunger.Comandos.CMDChat;
import Net.Hunger.Comandos.CMDCheck;
import Net.Hunger.Comandos.CMDFeast;
import Net.Hunger.Comandos.CMDFly;
import Net.Hunger.Comandos.CMDGamemode;
import Net.Hunger.Comandos.CMDHelp;
import Net.Hunger.Comandos.CMDInfo;
import Net.Hunger.Comandos.CMDInv;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Comandos.CMDKitDisable;
import Net.Hunger.Comandos.CMDKitDisableAll;
import Net.Hunger.Comandos.CMDKits;
import Net.Hunger.Comandos.CMDListener;
import Net.Hunger.Comandos.CMDMiniArena;
import Net.Hunger.Comandos.CMDPvP;
import Net.Hunger.Comandos.CMDSkit;
import Net.Hunger.Comandos.CMDSpawn;
import Net.Hunger.Comandos.CMDSpec;
import Net.Hunger.Comandos.CMDSpecTp;
import Net.Hunger.Comandos.CMDStaff;
import Net.Hunger.Comandos.CMDStart;
import Net.Hunger.Comandos.CMDTag;
import Net.Hunger.Comandos.CMDTeleportar;
import Net.Hunger.Comandos.CMDTell;
import Net.Hunger.Comandos.CMDTimer;
import Net.Hunger.Comandos.CMDVisInvis;
import Net.Hunger.Comandos.CMDWatch;
import Net.Hunger.Comandos.CMDWho;
import Net.Hunger.Eventos.ChecarVitoria;
import Net.Hunger.Eventos.Compass;
import Net.Hunger.Eventos.DeathPlayerMSG;
import Net.Hunger.Eventos.DropItem;
import Net.Hunger.Eventos.LoadKits;
import Net.Hunger.Eventos.LoadTag;
import Net.Hunger.Eventos.PreAndamento;
import Net.Hunger.Eventos.PreDeathEvt;
import Net.Hunger.Eventos.PreGameEvt;
import Net.Hunger.Eventos.PreInvencibilidadeEvt;
import Net.Hunger.Eventos.PreJoin;
import Net.Hunger.Habilidades.Anchor;
import Net.Hunger.Habilidades.BackPacker;
import Net.Hunger.Habilidades.Bigjump;
import Net.Hunger.Habilidades.Cacto;
import Net.Hunger.Habilidades.CopyCat;
import Net.Hunger.Habilidades.Crafter;
import Net.Hunger.Habilidades.Cultivator;
import Net.Hunger.Habilidades.Demoman;
import Net.Hunger.Habilidades.Durability;
import Net.Hunger.Habilidades.Dwarf;
import Net.Hunger.Habilidades.Endermage;
import Net.Hunger.Habilidades.Enderman;
import Net.Hunger.Habilidades.Fireman;
import Net.Hunger.Habilidades.Firer;
import Net.Hunger.Habilidades.Fisherman;
import Net.Hunger.Habilidades.Forger;
import Net.Hunger.Habilidades.Gladiator;
import Net.Hunger.Habilidades.Grappler;
import Net.Hunger.Habilidades.Hulk;
import Net.Hunger.Habilidades.JackHammer;
import Net.Hunger.Habilidades.Jellyfish;
import Net.Hunger.Habilidades.Kangaroo;
import Net.Hunger.Habilidades.KangarooPreGame;
import Net.Hunger.Habilidades.Launcher;
import Net.Hunger.Habilidades.Lumberjack;
import Net.Hunger.Habilidades.Madman;
import Net.Hunger.Habilidades.Miner;
import Net.Hunger.Habilidades.Monk;
import Net.Hunger.Habilidades.Ninja;
import Net.Hunger.Habilidades.Poseidon;
import Net.Hunger.Habilidades.Reaper;
import Net.Hunger.Habilidades.Snail;
import Net.Hunger.Habilidades.Specialist;
import Net.Hunger.Habilidades.Stomper;
import Net.Hunger.Habilidades.Surprise;
import Net.Hunger.Habilidades.Switcher;
import Net.Hunger.Habilidades.Swords;
import Net.Hunger.Habilidades.Tank;
import Net.Hunger.Habilidades.Thor;
import Net.Hunger.Habilidades.Timelord;
import Net.Hunger.Habilidades.Tower;
import Net.Hunger.Habilidades.Turtle;
import Net.Hunger.Habilidades.Viking;
import Net.Hunger.Habilidades.Viper;
import Net.Hunger.Habilidades.Well;
import Net.Hunger.Habilidades.Wolff;
import Net.Hunger.Habilidades.Worm;
import Net.Hunger.Inv.AllKits;
import Net.Hunger.Inv.InvKit;
import Net.Hunger.Inv.InvKit2;
import Net.Hunger.Manager.Arquivos;
import Net.Hunger.Manager.BarAPI;
import Net.Hunger.Manager.BarKit;
import Net.Hunger.Manager.EspectadoresManager;
import Net.Hunger.Manager.Habilidade;
import Net.Hunger.Manager.IniciandoEvt;
import Net.Hunger.Manager.SecondEvent;
import Net.Hunger.Manager.TabColor;
import Net.Hunger.Manager.Title;
import Net.Hunger.Timer.Iniciando;
import Net.Hunger.Timer.Invencibilidade;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class Main extends JavaPlugin implements Listener {
	
	public static Plugin instance;
	
	// Conjunto de booleans
	
	public static boolean PreGame;
	public static boolean PreInvencibilidade;
	public static boolean Partida;
	public static boolean Finalizando;
	
	// Interagers de partida 

	public static int Andamento = 0;
	public static Integer TimerIniciando = Integer.valueOf(180);
	public static Integer TimerInvencibilidade = Integer.valueOf(120);
	
	// Conjunto de ArrayLists
	
	public static FileConfiguration config;
	public static Boolean Feast = Boolean.valueOf(true);
	public static Integer TempoFeast = Integer.valueOf(300);
	public static Boolean BausFeast = Boolean.valueOf(true);
	public static List<String> saiu = new ArrayList<String>();
	public static Integer MinimoJogadores = Integer.valueOf(5);
	public static Boolean ProtecaoFeast = Boolean.valueOf(true);
	public static String site = "http://SkillNetwork.Buycraft.net";
	public static ArrayList<String> Watch = new ArrayList<String>();
	public static ArrayList<String> mortos = new ArrayList<String>();
	public static ArrayList<String> Relogar = new ArrayList<String>();
	public static ArrayList<String> Jogadores = new ArrayList<String>();
	public static HashMap<String, ItemStack[]> skit = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> armor = new HashMap<String, ItemStack[]>();
	
	// AntCheat /f
	
	public static final Random RANDOM = new Random();
	private HashMap<UUID, AuraCheck> running = new HashMap<UUID, AuraCheck>();
	
	public void onLoad() {
	Bukkit.getLogger().info("SkillNetwork - HG - Removendo mundo!");
	Bukkit.getServer().unloadWorld("world", false);
	deleteDir(new File("world"));
	}
	
	public static void deleteDir(File dir) {
	if (dir.isDirectory()) {
	String[] children = dir.list();
	for (int i = 0; i < children.length; i++) {
	deleteDir(new File(dir, children[i]));
	}
	}
	dir.delete();
	}
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
    instance = this;
 	PreGame = true;
    new Iniciando();
    new Surprise();
    Jogadores.clear();
    saveDefaultConfig();
    config = getConfig();
	KangarooPreGame.Kangaroo = true;
	Bukkit.getLogger().info("SkillNetwork - HG - Carregada!");
	Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Eventos();
    Comandos();
    Arquivos();
    Habilidades();
    ChecarVitoria.autobroadcastMessages();
    Bukkit.getServer().getWorld("world").getLoadedChunks();
    ((World)Bukkit.getServer().getWorlds().get(0)).setTime(0L);
    Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.PEACEFUL);
    
    ItemStack Resultado = new ItemStack(Material.MUSHROOM_SOUP, 1);
    ItemMeta Cactos = Resultado.getItemMeta();
    Resultado.setItemMeta(Cactos);
    ShapelessRecipe CraftCactos = new ShapelessRecipe(Resultado);
    CraftCactos.addIngredient(2, Material.CACTUS);
    CraftCactos.addIngredient(1, Material.BOWL);
    Bukkit.getServer().addRecipe(CraftCactos);
	
    ItemMeta Cocoa = Resultado.getItemMeta();
    Resultado.setItemMeta(Cocoa);
    ShapelessRecipe CraftCocoa = new ShapelessRecipe(Resultado);
    CraftCocoa.addIngredient(1, Material.INK_SACK, 3);
    CraftCocoa.addIngredient(1, Material.BOWL);
    Bukkit.getServer().addRecipe(CraftCocoa);
    
    ItemMeta Flores = Resultado.getItemMeta();
    Resultado.setItemMeta(Flores);
    ShapelessRecipe CraftFlores = new ShapelessRecipe(Resultado);
    CraftFlores.addIngredient(1, Material.YELLOW_FLOWER);
    CraftFlores.addIngredient(1, Material.RED_ROSE);
    CraftFlores.addIngredient(1, Material.BOWL);
    Bukkit.getServer().addRecipe(CraftFlores);
    BorderBlocks.GerarBorda();
	}
	
	public void Arquivos() {
	instance = this;
	new Arquivos();
	}
	
	public static Location getFeastLocation() { Random random = new Random();
	Location startFrom = ((World)Bukkit.getWorlds().get(0)).getSpawnLocation();
	Location loc;
    do {
    loc = startFrom.clone();
	loc.add((random.nextBoolean() ? 1 : -1) * random.nextInt(100), 60.0D, (random.nextBoolean() ? 1 : -1) * random.nextInt(100));
	int newY = ((World)Bukkit.getWorlds().get(0)).getHighestBlockYAt(loc);
	loc.setY(newY);
	} while (!WorldBorder.inBorder(loc, BorderType.WARN));
	return loc; 
	}
	
	public void onDisable() {
	Jogadores.clear();
	Bukkit.getServer().getScheduler().cancelAllTasks();
	}
	
	public void Comandos() {
	getCommand("iniciar").setExecutor(new CMDStart());
	getCommand("kits").setExecutor(new CMDKits());
	getCommand("kit").setExecutor(new CMDKit());
	getCommand("help").setExecutor(new CMDHelp());
	getCommand("admin").setExecutor(new CMDAdmin());
	getCommand("chat").setExecutor(new CMDChat());
	getCommand("checar").setExecutor(new CMDCheck());
	getCommand("gm").setExecutor(new CMDGamemode());
	getCommand("spec").setExecutor(new CMDSpec());
	getCommand("help").setExecutor(new CMDHelp());
	getCommand("info").setExecutor(new CMDInfo());
	getCommand("pvp").setExecutor(new CMDPvP());
	getCommand("skit").setExecutor(new CMDSkit());
	getCommand("spawn").setExecutor(new CMDSpawn());
	getCommand("sc").setExecutor(new CMDStaff());
	getCommand("miniarena").setExecutor(new CMDMiniArena());
	getCommand("tag").setExecutor(new CMDTag());
	getCommand("ir").setExecutor(new CMDSpecTp());
	getCommand("who").setExecutor(new CMDWho());
	getCommand("aplicar").setExecutor(new CMDAplicar());
	getCommand("fly").setExecutor(new CMDFly());
	getCommand("forcefeast").setExecutor(new CMDFeast());
	getCommand("feast").setExecutor(new CMDFeast());
	getCommand("tell").setExecutor(new CMDTell());
	getCommand("ip").setExecutor(new CMDHelp());
	getCommand("tp").setExecutor(new CMDTeleportar());
	getCommand("s").setExecutor(new CMDTeleportar());
	getCommand("sc").setExecutor(new CMDStaff());
	getCommand("arena").setExecutor(new CMDArena());
	getCommand("inv").setExecutor(new CMDInv());
	getCommand("tpall").setExecutor(new CMDTimer());
	getCommand("invencibilidade").setExecutor(new CMDTimer());
	getCommand("game").setExecutor(new CMDTimer());
	getCommand("pregame").setExecutor(new CMDTimer());
	getCommand("invis").setExecutor(new CMDCheck());
	getCommand("vis").setExecutor(new CMDVisInvis());
	getCommand("toggle").setExecutor(new CMDKitDisableAll());
	getCommand("togglekit").setExecutor(new CMDKitDisable());
	getCommand("watch").setExecutor(new CMDWatch());
	}

    public void Eventos() {
    Bukkit.getServer().getPluginManager().registerEvents(new PreGameEvt(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new IniciandoEvt(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PreInvencibilidadeEvt(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PreDeathEvt(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PreAndamento(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new CMDListener(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new CMDMiniArena(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new LoadTag(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new DeathPlayerMSG(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new InvKit(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new InvKit2(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new CMDKitDisable(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new DropItem(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new AllKits(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new BarKit(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new BorderMove(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new PreJoin(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new BarAPI(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new KangarooPreGame(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new TabColor(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new ChecarVitoria(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new EspectadoresManager(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Compass(), this);
    }
   
    public void Habilidades() {
    Bukkit.getServer().getPluginManager().registerEvents(new Firer(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Crafter(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Cultivator(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Wolff(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Demoman(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Dwarf(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Endermage(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Fisherman(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Tower(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new JackHammer(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Forger(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Cacto(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new CopyCat(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Gladiator(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Grappler(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Swords(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Viking(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Fireman(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Hulk(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Jellyfish(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Kangaroo(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Enderman(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Lumberjack(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new BackPacker(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Miner(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Anchor(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Monk(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Ninja(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Poseidon(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Reaper(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Durability(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Snail(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Specialist(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Switcher(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Well(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Bigjump(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new BackPacker(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Madman(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Tank(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Surprise(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Thor(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Timelord(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Launcher(this), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Turtle(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Viper(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new Worm(), this);
    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
    public void run() {
    Bukkit.getPluginManager().callEvent(new SecondEvent());
    }
    }, 20L, 60L);
    }   
    
    
    public void register() {
    ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, new PacketType[] { WrapperPlayClientUseEntity.TYPE }) {
    public void onPacketReceiving(PacketEvent event) {
    if (event.getPacketType() == WrapperPlayClientUseEntity.TYPE) {
    int entID = new WrapperPlayClientUseEntity(event.getPacket()).getTargetID();
    if (running.containsKey(event.getPlayer().getUniqueId())) {
    ((AuraCheck)running.get(event.getPlayer().getUniqueId())).markAsKilled(Integer.valueOf(entID));
    }
    }
    }
    });
    }
    
    public void unregister() {
    ProtocolLibrary.getProtocolManager().removePacketListeners(this);
    }
    
    public void remove(UUID id) {
    running.remove(id);
    if(running.size() == 0) {
    unregister();
    }
    }
    
    private boolean isRegistered;
    
    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(!(sender instanceof Player)) {
    sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
    return true;
    }
    if (args.length < 1) {
    return true;
    }
    Player player = Bukkit.getPlayer(args[0]);
    if (player == null) {
    sender.sendMessage("§7[§a?§7] Desculpe jogador Offline!");
    return true;
    }
    if (!isRegistered) {
    register();
    }
    if(sender.hasPermission("HungerGames.c.Admin")) {
    AuraCheck check = new AuraCheck(this, player);
    running.put(player.getUniqueId(), check);
    check.invoke(sender);
    return true;
    } else {
    sender.sendMessage("§7[§a?§7] Você não possue permissão!");
    }
	return true;
    }

    @EventHandler
    public void CommandPartida(final PlayerCommandPreprocessEvent event) {
    Player p = event.getPlayer();
    if ((Main.Partida) && (event.getMessage().toLowerCase().startsWith("/kit "))) {
    p.sendMessage("§7[§a!§7] Desculpe a partida ja esta em andamento!");
    event.setCancelled(true);
    return;
    }
    }
    
    ArrayList<String> NoKit = new ArrayList<String>();
    
    @EventHandler
    public void NoKit(final PlayerCommandPreprocessEvent event) {
    Player p = event.getPlayer();
    if ((NoKit.contains(p.getName())) && (event.getMessage().toLowerCase().startsWith("/kit "))) {
    p.sendMessage("§7[§a!§7] Desculpe a partida ja esta em andamento!");
    event.setCancelled(true);
    return;
    }
    }
    
    @EventHandler
    public void KitAndamento(final PlayerCommandPreprocessEvent e) {
    Player p = e.getPlayer();
    if((PreInvencibilidade)) {
    if(Habilidade.getAbility(p).equalsIgnoreCase("Nenhum") && (p.hasPermission("HungerGames.Kit5m"))) {
    if (e.getMessage().contains("/kit ")) {
    e.setCancelled(false);
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    public void run() {
    LoadKits.CheckKits(p);
    NoKit.add(p.getName());
    for (PotionEffect effect : p.getActivePotionEffects()) {
    p.removePotionEffect(effect.getType());
    }
    if(Habilidade.getAbility(p).equalsIgnoreCase("cacto")) {
    Cacto.RecraftCactus(p);
    }
    if(Habilidade.getAbility(p).equalsIgnoreCase("Surprise")) {
    Surprise.setSurprise(p);
    }
    }
    },25L);
    }
    } else {
    if (e.getMessage().contains("/kit ")) {
    e.setCancelled(true);
    }
    }
    }
    }
    
    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {
    if (running.containsKey(event.getPlayer().getUniqueId())) {
    ((AuraCheck)running.remove(event.getPlayer().getUniqueId())).end();
    }
    }
        
	public static void IniciarPartida() {
    Iniciando.cancel();
    new Invencibilidade();
	Main.PreGame = false;
    CMDKitDisable.KitsDisable = false;
	Main.PreInvencibilidade = true;
	IniciandoEvt.Teleportar = false;
    ((World)Bukkit.getServer().getWorlds().get(0)).setTime(0L);
    ((World)Bukkit.getServer().getWorlds().get(0)).setStorm(false);
    ((World)Bukkit.getServer().getWorlds().get(0)).setThundering(false);
	Bukkit.broadcastMessage(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ █ █ ▇ ▆ ▅ ▄ ▃ ▂"); 
	Bukkit.broadcastMessage(ChatColor.GRAY + "§c"); 
    Bukkit.broadcastMessage(ChatColor.GRAY + "A Partida iniciou §aBoa sorte!");
	Bukkit.broadcastMessage(ChatColor.GRAY + "Existem §a" + Main.Jogadores.size() + " §7jogadores participando!"); 
	Bukkit.broadcastMessage(ChatColor.GRAY + "A Invencibilidade acaba em" + ChatColor.WHITE + " 2 minutos!"); 
 	Bukkit.broadcastMessage(ChatColor.GRAY + "§b"); 
	Bukkit.broadcastMessage(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ █ █ ▇ ▆ ▅ ▄ ▃ ▂"); 
    for(Player Participando : Bukkit.getOnlinePlayers()) {
    if(Jogadores.contains(Participando.getName())) {
    Iniciando.RelogPreGame.remove(Participando);
    Participando.setAllowFlight(false);
    Title.sendTitle(Participando, "§6§lHardCore§c§lGames");
    Title.sendSubTitle(Participando, "§b§lBoa sorte!");
    Participando.playSound(Participando.getLocation(), Sound.AMBIENCE_THUNDER, 4.0F, 4.0F);
    Participando.setFlying(false);
    Participando.getInventory().clear();
    Participando.getInventory().addItem(new ItemStack(Material.COMPASS));
    LoadKits.CheckKits(Participando);
    Participando.setHealth(20);
    Participando.setFoodLevel(20);
    Participando.setFireTicks(0);
    Participando.setExhaustion(20.0F);
    if(Habilidade.getAbility(Participando).equalsIgnoreCase("Surprise")) {
    Surprise.setSurprise(Participando);
    }
    if(Habilidade.getAbility(Participando).equalsIgnoreCase("cacto")) {
    Cacto.RecraftCactus(Participando);
    }
    }
   } 
  }
}