package br.com.alpha;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.InventariosGUI;
import br.com.alpha.APIs.MySQL;
import br.com.alpha.APIs.MySQLBanManager;
import br.com.alpha.Borda.BorderMove;
import br.com.alpha.Comandos.ChangeMatchTime;
import br.com.alpha.Comandos.ChangeSkin;
import br.com.alpha.Comandos.ClearChat;
import br.com.alpha.Comandos.Desistir;
import br.com.alpha.Comandos.Fake;
import br.com.alpha.Comandos.Fly;
import br.com.alpha.Comandos.Help;
import br.com.alpha.Comandos.Kit;
import br.com.alpha.Comandos.Skit;
import br.com.alpha.Comandos.Staff;
import br.com.alpha.Comandos.TFake;
import br.com.alpha.Comandos.Tag;
import br.com.alpha.Habilidades.Achilles;
import br.com.alpha.Habilidades.Anchor;
import br.com.alpha.Habilidades.BackPacker;
import br.com.alpha.Habilidades.Barbarian;
import br.com.alpha.Habilidades.Cannibal;
import br.com.alpha.Habilidades.CopyCat;
import br.com.alpha.Habilidades.Cultivator;
import br.com.alpha.Habilidades.Demoman;
import br.com.alpha.Habilidades.Endermage;
import br.com.alpha.Habilidades.Fireman;
import br.com.alpha.Habilidades.Fisherman;
import br.com.alpha.Habilidades.Forger;
import br.com.alpha.Habilidades.JackHammer;
import br.com.alpha.Habilidades.Kangaroo;
import br.com.alpha.Habilidades.Launcher;
import br.com.alpha.Habilidades.Lumberjack;
import br.com.alpha.Habilidades.Madman;
import br.com.alpha.Habilidades.Miner;
import br.com.alpha.Habilidades.Monk;
import br.com.alpha.Habilidades.Phantom;
import br.com.alpha.Habilidades.Poseidon;
import br.com.alpha.Habilidades.Pyro;
import br.com.alpha.Habilidades.Reaper;
import br.com.alpha.Habilidades.Snail;
import br.com.alpha.Habilidades.Specialist;
import br.com.alpha.Habilidades.Stomper;
import br.com.alpha.Habilidades.Switcher;
import br.com.alpha.Habilidades.Tank;
import br.com.alpha.Habilidades.Thor;
import br.com.alpha.Habilidades.Tower;
import br.com.alpha.Habilidades.Viper;
import br.com.alpha.Habilidades.Worm;
import br.com.alpha.InGame.ManagerInGame;
import br.com.alpha.InGame.Listeners.ServerListPing;
import br.com.alpha.InGame.Listeners.SoupEating;
import br.com.alpha.InGame.Listeners.Feast.FeastProtect;
import br.com.alpha.InGame.Listeners.Kits.Managers.CooldownManagement;
import br.com.alpha.InGame.Schematic.Schematic;
import br.com.alpha.Invencibilidade.ManagerInvencibilidade;
import br.com.alpha.ScoreBoard.Scores;
import br.com.alpha.gamemanagement.GameTime;
import br.com.alpha.pregame.ManagerPreGame;
import br.com.alpha.pregame.listeners.EntityInteracting;
import br.com.alpha.pregame.listeners.FoodChange;
import br.com.alpha.pregame.listeners.PlayerInteracting;
import br.com.alpha.pregame.listeners.ProtectWorld;
import br.com.alpha.pregame.listeners.onInteractBlocks;
import br.com.alpha.pregame.listeners.Join.PlayerJoin;
import br.com.alpha.pregame.listeners.Quit.PlayerQuit;

@SuppressWarnings("deprecation")
public class MCAlpha extends JavaPlugin {

	public static GameTime Status = GameTime.PREGAME;
	public static Integer Time = 180;
	public static Integer needPlayers = 2;
	public static MySQL sql;
	public static MySQLBanManager sql2;

	public static MySQLBanManager getSQL2() {
		return MCAlpha.sql2;
	}

	public static void setSQL(final MySQLBanManager sql) {
		MCAlpha.sql2 = sql;
	}

	public static MySQL getSQL() {
		return MCAlpha.sql;
	}

	public static void setSQL(final MySQL sql) {
		MCAlpha.sql = sql;
	}

	public static List<Block> coliseumBlocks;

	public static String Logo = "§b§lALPHAHG §7» ";

	public static MCAlpha mcAlpha;

	public void onEnable() {

		mcAlpha = this;
		getConfig().options().copyDefaults(true);
		MySQLBanManager.sqlConnect();
		MySQL.sqlConnect();
		MySQL.createTableIf();
		onComandos();
		onEventos();
		loadBorda();
		loadConfiguration();
		onKits();
		Scores.run();
		spawnColiseu();
		startCooldownTask();

		super.onEnable();
	}

	public void onDisable() {
		kickarJogadores();
		Bukkit.shutdown();
		super.onDisable();
	}

	public void onLoad() {
		deletarMundo();
		super.onLoad();
	}

	void onComandos() {
		newCommand("tempo", new ChangeMatchTime());
		newCommand("help", new Help());
		newCommand("fake", new Fake());
		newCommand("tfake", new TFake());
		newCommand("changeskin", new ChangeSkin());
		newCommand("kit", new Kit());
		newCommand("fly", new Fly());
		newCommand("cc", new ClearChat());
		newCommand("desistir", new Desistir());
		newCommand("admin", new Desistir());
		newCommand("sc", new Staff());
		newCommand("skit", new Skit());
		newCommand("feast", new Fake());
		newCommand("tag", new Tag());
	}

	void onKits() {
		newListener(new Anchor());
		newListener(new BackPacker());
		newListener(new Endermage());
		newListener(new Cannibal());
		newListener(new Fisherman());
		newListener(new Fireman());
		newListener(new Snail());
		newListener(new Tank());
		newListener(new Thor());
		newListener(new Viper());
		newListener(new Barbarian());
		newListener(new CopyCat());
		newListener(new Cultivator());
		newListener(new Demoman());
		newListener(new Endermage());
		newListener(new Fireman());
		newListener(new Forger());
		newListener(new JackHammer());
		newListener(new Launcher());
		newListener(new Lumberjack());
		newListener(new Madman());
		newListener(new Miner());
		newListener(new Monk());
		newListener(new Poseidon());
		newListener(new Pyro());
		newListener(new Reaper());
		newListener(new Snail());
		newListener(new Specialist());
		newListener(new Stomper());
		newListener(new Switcher());
		newListener(new Tower());
		newListener(new Worm());
		newListener(new Phantom());
	}

	void onEventos() {
		newListener(new EntityInteracting());
		newListener(new FoodChange());
		newListener(new onInteractBlocks());
		newListener(new PlayerInteracting());
		newListener(new ProtectWorld());
		newListener(new PlayerJoin());
		newListener(new InventariosGUI());
		newListener(new Achilles());
		newListener(new ManagerInvencibilidade());
		newListener(new br.com.alpha.Invencibilidade.Listeners.EntityInteracting());
		newListener(new br.com.alpha.Invencibilidade.Listeners.FoodChange());
		newListener(new ManagerInGame());
		newListener(new SoupEating());
		newListener(new PlayerQuit());
		newListener(new ServerListPing());
		newListener(new FeastProtect());

		loadSoups();
	}

	void newCommand(String cmd, CommandExecutor executor) {
		getCommand(cmd).setExecutor(executor);
	}

	void newListener(Listener plugin) {
		Bukkit.getPluginManager().registerEvents(plugin, this);
		Bukkit.getPluginManager().registerEvents(new Kangaroo(), this);
	}

	void loadSoups() {
		ItemStack result = new ItemStack(Material.MUSHROOM_SOUP, 1);

		ShapelessRecipe CraftCacto = new ShapelessRecipe(result);
		CraftCacto.addIngredient(1, Material.CACTUS);
		CraftCacto.addIngredient(1, Material.BOWL);
		Bukkit.addRecipe(CraftCacto);

		ShapelessRecipe CraftAbobora = new ShapelessRecipe(result);
		CraftAbobora.addIngredient(2, Material.PUMPKIN_SEEDS);
		CraftAbobora.addIngredient(1, Material.BOWL);
		Bukkit.addRecipe(CraftAbobora);
 
		ShapelessRecipe CraftFlor = new ShapelessRecipe(result);
		CraftFlor.addIngredient(1, Material.RED_ROSE);
		CraftFlor.addIngredient(1, Material.YELLOW_FLOWER);
		CraftFlor.addIngredient(1, Material.BOWL);
		Bukkit.addRecipe(CraftFlor);

		ShapelessRecipe CraftCocoa = new ShapelessRecipe(result);
		CraftCocoa.addIngredient(1, Material.getMaterial(351), (byte) 3);
		CraftCocoa.addIngredient(1, Material.BOWL);
		Bukkit.addRecipe(CraftCocoa);
	}

	void loadBorda() {
		System.out.println("Gerando a borda do mundo...");
		Schematic.generateBorder(500, 256, Material.BEDROCK);
		Bukkit.getPluginManager().registerEvents(new BorderMove(), this);
	}

	void deletarMundo() {
		Bukkit.unloadWorld("world", false);
		System.gc();
		APIClass.deleteFile(new File("world"));
	}

	void loadConfiguration() {
		World world = Bukkit.getWorld("world");
		ManagerPreGame.startPreGame();
		world.setAutoSave(false);
		world.setTime(0L);
		world.setSpawnLocation(0, 140, 0);
		world.setDifficulty(Difficulty.NORMAL);
	}

	void kickarJogadores() {
		for (Player x : Bukkit.getOnlinePlayers()) {
			x.kickPlayer("§4§lAVISO: §cServidor reiniciando!");
		}
	}

	private static void loadColiseu(Location pasteLoc) {
		coliseumBlocks = Schematic.spawnBo2(pasteLoc, new File("plugins/schematics/coliseu.shematic"));
	}

	private static void spawnColiseu() {
		Schematic.start();

		System.out.println("Iniciando carregamento do coliseu...");
		long start = System.currentTimeMillis();
		loadColiseu(Bukkit.getWorld("world").getSpawnLocation());
		System.out.println(
				"Coliseu spawnado! (" + APIClass.formatDifferenceStr((System.currentTimeMillis() - start)) + ")");
	}

	private static void startCooldownTask() {
		CooldownManagement.runTaskTimer();
	}

}