package me.recenthg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.recenthg.CMDS.Admin;
import me.recenthg.CMDS.Arena;
import me.recenthg.CMDS.Bc;
import me.recenthg.CMDS.Chat;
import me.recenthg.CMDS.ClearChat;
import me.recenthg.CMDS.DarCoins;
import me.recenthg.CMDS.Desistir;
import me.recenthg.CMDS.Fake;
import me.recenthg.CMDS.Feast;
import me.recenthg.CMDS.Fly;
import me.recenthg.CMDS.ForceFeast;
import me.recenthg.CMDS.Gamemode;
import me.recenthg.CMDS.Iniciar;
import me.recenthg.CMDS.Inv;
import me.recenthg.CMDS.Jogo;
import me.recenthg.CMDS.Kit;
import me.recenthg.CMDS.MudarTimer;
import me.recenthg.CMDS.PvPGlobal;
import me.recenthg.CMDS.Report;
import me.recenthg.CMDS.SC;
import me.recenthg.CMDS.Score;
import me.recenthg.CMDS.Skit;
import me.recenthg.CMDS.SorteioKit;
import me.recenthg.CMDS.Spawn;
import me.recenthg.CMDS.Specs;
import me.recenthg.CMDS.Tag;
import me.recenthg.CMDS.Tell;
import me.recenthg.CMDS.Tp;
import me.recenthg.CMDS.VerCoins;
import me.recenthg.CMDS.VisInvee;
import me.recenthg.CMDS.Youtuber;
import me.recenthg.Dinheiro.DinheiroM;
import me.recenthg.Eventss.CoinsDiaria;
import me.recenthg.Eventss.CombatLog;
import me.recenthg.Eventss.Compass;
import me.recenthg.Eventss.KitDiario;
import me.recenthg.Eventss.PreInvEnvt;
import me.recenthg.Eventss.PreJoinEvt;
import me.recenthg.Kits.Aladdin;
import me.recenthg.Kits.Anchor;
import me.recenthg.Kits.BurstMaster;
import me.recenthg.Kits.Crafter;
import me.recenthg.Kits.Cultivator;
import me.recenthg.Kits.Endermage;
import me.recenthg.Kits.Fireman;
import me.recenthg.Kits.Fisherman;
import me.recenthg.Kits.Gaara;
import me.recenthg.Kits.Gladiator;
import me.recenthg.Kits.Grappler;
import me.recenthg.Kits.Hulk;
import me.recenthg.Kits.Kangaroo;
import me.recenthg.Kits.LumberJack;
import me.recenthg.Kits.Monk;
import me.recenthg.Kits.Ninja;
import me.recenthg.Kits.Phantom;
import me.recenthg.Kits.Poseidon;
import me.recenthg.Kits.Reaper;
import me.recenthg.Kits.Snail;
import me.recenthg.Kits.Specialist;
import me.recenthg.Kits.Stomper;
import me.recenthg.Kits.Surprise;
import me.recenthg.Kits.Thor;
import me.recenthg.Kits.Tower;
import me.recenthg.Kits.Turtle;
import me.recenthg.Kits.Velotrol;
import me.recenthg.Kits.Viper;
import me.recenthg.Kits.Vulcanos;
import me.recenthg.Kits.Well;
import me.recenthg.Kits.Wither;
import me.recenthg.Kits.Worm;
import me.recenthg.Manager.DarItemDoKit;
import me.recenthg.Manager.DropsItemKits;
import me.recenthg.Manager.Espectadores;
import me.recenthg.Manager.Listeners;
import me.recenthg.Manager.MensagenDeMorrer;
import me.recenthg.Manager.PreDeathEvt;
import me.recenthg.Manager.PreJoin;
import me.recenthg.Manager.Status;
import me.recenthg.Manager.Team;
import me.recenthg.Manager.TeamCMD;
import me.recenthg.Score.Scoreboasrdsadd;
import me.recenthg.Selector.Gui1;
import me.recenthg.Selector.Gui2;
import me.recenthg.Selector.SecGui1;
import me.recenthg.Selector.SecGui2;
import me.recenthg.Tempo.Iniciando;
import me.recenthg.Tempo.Invencibilidade;
import me.recenthg.Utils.Estado;
import me.recenthg.Utils.MyConfigManager;
import me.recenthg.Utils.TabColor;
import me.recenthg.jnbt.DataException;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class Main extends JavaPlugin {
	// Statics
	public static Main instance;
	public static Estado estados;
	public static int TimerIniciando = 301;
	public static int TimerAndamento = 1;
	public static int TimerInvencibilidade = 121;
	public static int MinimoDeJogadores = 5;
	public static Plugin plugin;
	public static MyConfigManager manager;
	public static ArrayList<String> mortos = new ArrayList<String>();
	public static ArrayList<String> saiu = new ArrayList<String>();

	// Strings
	public static String permissiao = "§4» §7Voce Nao Possue Permissão!";
	public static String Menssagems = "§2» §7";

	// ArrayLists
	public static ArrayList<String> Watch = new ArrayList<String>();
	public static ArrayList<String> Jogadores = new ArrayList<String>();
	public static ArrayList<String> NoKit = new ArrayList<String>();
	public static final HashMap<String, String> Time = new HashMap<>();
	public static ArrayList<String> score = new ArrayList<>();
	public static ArrayList<Block> BlocosColiseu = new ArrayList<>();
	public static ArrayList<Block> BlocosFeast = new ArrayList<>();
	public static HashMap<String, ItemStack[]> skit = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> armor = new HashMap<String, ItemStack[]>();

	public static ArrayList<Block> coliseu = new ArrayList<>();
	public ArrayList<Block> feast = new ArrayList<>();
	public ArrayList<Block> winner = new ArrayList<>();
	public ArrayList<Block> border = new ArrayList<>();

	public void onLoad() {
		Bukkit.getLogger().info("-=- EffectsHG Removendo mundo -=-");
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
	
	public File clan1;
	public YamlConfiguration clan;
	
	public File stats1;
	public YamlConfiguration stats;

	@SuppressWarnings("deprecation")
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage("§a§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		Bukkit.getServer().getConsoleSender().sendMessage("                 EffectsHG              ");
		Bukkit.getServer().getConsoleSender().sendMessage("           EffectsHG Ativado          ");
		Bukkit.getServer().getConsoleSender().sendMessage("§a§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		Configs();
		save();
		DinheiroM.manager = new MyConfigManager(this);
		DinheiroM.CarregarDinheiro();
		onRegister();
		onComandos();
		onKits();
		Jogadores.clear();
		plugin = this;
		instance = this;
		estados = Estado.INICIANDO;
		Iniciando.onIniciando();
		Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);

		manager = new MyConfigManager(this);
		ItemStack Resultado = new ItemStack(Material.MUSHROOM_SOUP, 1);
		ItemMeta Cactos = Resultado.getItemMeta();
		Resultado.setItemMeta(Cactos);
		ShapelessRecipe CraftCactos = new ShapelessRecipe(Resultado);
		CraftCactos.addIngredient(1, Material.CACTUS);
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

		ItemMeta Aboboras = Resultado.getItemMeta();
		Resultado.setItemMeta(Aboboras);
		ShapelessRecipe CraftAboboras = new ShapelessRecipe(Resultado);
		CraftAboboras.addIngredient(1, Material.PUMPKIN_SEEDS);
		CraftAboboras.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftAboboras);
		
		MSG();
		
		if (instance.getConfig().getBoolean("Coliseu")) {
			try {
				Bukkit.getConsoleSender().sendMessage("");
				Bukkit.getConsoleSender().sendMessage("EffectsHG - Iniciando Uma Nova Tarefa");
				Bukkit.getConsoleSender().sendMessage("Tarefa - Tentando Spawnar Coliseu");
				Bukkit.getConsoleSender().sendMessage("");
				Schematic s=Schematic.getInstance().carregarSchematics(new File(instance.getDataFolder(), "coliseu.schematic"));
				Schematic.getInstance().generateSchematic(instance.getServer().getWorlds().get(0), new Location(instance.getServer().getWorlds().get(0), -27.5D, 200.0D, -27.5D), s, coliseu);
				Bukkit.getConsoleSender().sendMessage("");
				Bukkit.getConsoleSender().sendMessage("EffectsHG - Tarefa Concluida");
				Bukkit.getConsoleSender().sendMessage("Tarefa - Spawnar Coliseu");
				Bukkit.getConsoleSender().sendMessage("");
			} catch (IOException | DataException e){
				Bukkit.getConsoleSender().sendMessage("");
				Bukkit.getConsoleSender().sendMessage("EffectsHG - Erro de schematic");
				Bukkit.getConsoleSender().sendMessage("Motivo - Coliseu.schematic");
				Bukkit.getConsoleSender().sendMessage("");
			}
		}
	}

	@EventHandler
	public void fullJoin(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if (p.hasPermission("Effects.Entrar")) {
				event.setResult(PlayerLoginEvent.Result.ALLOWED);

			} else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {

				event.setKickMessage((Object) ChatColor.GRAY + "§cEstamos Em Manutenção! Volte Mais Tarde");
			}
		}
	}

	@SuppressWarnings("unused")
	public static void sendActionBar(Player player, String message) {
		CraftPlayer p = (CraftPlayer) player;
		if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
			return;
		}
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat ppoc = new PacketPlayOutChat();
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
	}

	public void onDisable() {
		Jogadores.clear();
		Bukkit.getServer().getConsoleSender().sendMessage("§a§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		Bukkit.getServer().getConsoleSender().sendMessage("                 EffectsHG              ");
		Bukkit.getServer().getConsoleSender().sendMessage("           EffectsHG Desativado       ");
		Bukkit.getServer().getConsoleSender().sendMessage("§a§m-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

	}

	public void onRegister() {

		Bukkit.getServer().getPluginManager().registerEvents(new Iniciando(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DarItemDoKit(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreDeathEvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreJoin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Arena(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new MensagenDeMorrer(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Espectadores(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreJoinEvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreInvEnvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Gui1(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SecGui1(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Scoreboasrdsadd(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Admin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Status(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Gui2(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SecGui2(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DropsItemKits(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Compass(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CombatLog(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CoinsDiaria(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Team(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new KitDiario(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Invencibilidade(), this);
	}

	public void onKits() {
		Bukkit.getServer().getPluginManager().registerEvents(new Kangaroo(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Thor(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Phantom(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Wither(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Well(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Worm(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Monk(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Gladiator(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Reaper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Velotrol(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Grappler(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Turtle(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Gaara(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Hulk(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LumberJack(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Viper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Vulcanos(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Aladdin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Snail(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Specialist(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BurstMaster(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fireman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Ninja(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Poseidon(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Endermage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Cultivator(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Surprise(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fisherman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new TabColor(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Thor(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Tower(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Crafter(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Anchor(), this);
	}

	public void onComandos() {
		getCommand("iniciar").setExecutor(new Iniciar());
		getCommand("jogo").setExecutor(new Jogo());
		getCommand("darcoins").setExecutor(new DarCoins());
		getCommand("coins").setExecutor(new VerCoins());
		getCommand("sorteiokit").setExecutor(new SorteioKit());
		getCommand("clan").setExecutor(new TeamCMD());
		getCommand("youtuber").setExecutor(new Youtuber());
		getCommand("pro").setExecutor(new Youtuber());
		getCommand("tag").setExecutor(new Tag());
		getCommand("report").setExecutor(new Report());
		getCommand("pvp").setExecutor(new PvPGlobal());
		getCommand("feast").setExecutor(new Feast());
		getCommand("tell").setExecutor(new Tell());
		getCommand("tp").setExecutor(new Tp());
		getCommand("score").setExecutor(new Score());
		getCommand("inv").setExecutor(new Inv());
		getCommand("arena").setExecutor(new Arena());
		getCommand("spec").setExecutor(new Specs());
		getCommand("forcefeast").setExecutor(new ForceFeast());
		getCommand("sc").setExecutor(new SC());
		getCommand("kit").setExecutor(new Kit());
		getCommand("skit").setExecutor(new Skit());
		getCommand("fake").setExecutor(new Fake());
		getCommand("tfake").setExecutor(new Fake());
		getCommand("cc").setExecutor(new ClearChat());
		getCommand("vis").setExecutor(new VisInvee());
		getCommand("desistir").setExecutor(new Desistir());
		getCommand("chat").setExecutor(new Chat());
		getCommand("fly").setExecutor(new Fly());
		getCommand("bc").setExecutor(new Bc());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("admin").setExecutor(new Admin());
		getCommand("tempo").setExecutor(new MudarTimer());

	}
	
	public void Configs() {
		File clan = new File(getDataFolder(), "clan.yml");
		if (!clan.exists())
			saveResource("clan.yml", false);
		clan1 = new File(getDataFolder(), "clan.yml");
		this.clan = YamlConfiguration.loadConfiguration(clan1);
		
		File stats = new File(getDataFolder(), "stats.yml");
		if (!stats.exists())
			saveResource("stats.yml", false);
		stats1 = new File(getDataFolder(), "stats.yml");
		this.stats = YamlConfiguration.loadConfiguration(stats1);
	}
	
	public void save() {
		try {
			this.clan.save(clan1);
			this.stats.save(stats1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void MSG() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
			
			@Override
			public void run() {
				String msg[] = {"                                  \n  §7[§a§lANUNCIO§7]\n§7Gostou do servidor entao ajude ele\nComprando §aVIP§7/§6Kits§7 em nossa loja\n§ehttp://loja-EffectsNetwork.buycraft.net\n                                  ",
						"                                  \n  §7[§4§lALERTA§7]\n§7Achou algum §4§lHACK§7 ?\nEntao Utilize o\n§a /report\n                                  ",
						"                                  \n  §7[§a§lANUNCIO§7]\n§7Que fazer parte da equipe ?\nEffectsNetwork.Suporte\n§6§lGOOD LUCKY\n                                  ",
						"                                  \n  §7[§4§lALERTA§7]\n§7Achou um bug ?\nEntão report em nosso Skype\n§fEffectsNetwork.Suporte\n                                  "};
				
				Bukkit.broadcastMessage(msg[new Random().nextInt(msg.length)]);
			}
		}, 0l, 1250L);
	}
}