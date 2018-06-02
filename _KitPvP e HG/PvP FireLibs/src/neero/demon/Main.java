/*     */ package neero.demon;
/*     */ 
/*     */ import java.io.File;
import java.io.IOException;
/*     */ import java.util.ArrayList;
import java.util.HashMap;
/*     */ import java.util.List;

import neero.demon.comandos.Admin;
import neero.demon.comandos.Aplicar;
import neero.demon.comandos.Broadcast;
import neero.demon.comandos.Check;
import neero.demon.comandos.ClearChat;
import neero.demon.comandos.Crash;
import neero.demon.comandos.Fake;
import neero.demon.comandos.Fly;
import neero.demon.comandos.Gm;
import neero.demon.comandos.Inventario;
import neero.demon.comandos.Kit;
import neero.demon.comandos.Kit2;
import neero.demon.comandos.LojaKits;
import neero.demon.comandos.LojadeKits;
import neero.demon.comandos.Menu;
import neero.demon.comandos.Ping;
import neero.demon.comandos.Rank;
import neero.demon.comandos.Recraft;
import neero.demon.comandos.Report;
import neero.demon.comandos.Skit;
import neero.demon.comandos.StaffChat;
import neero.demon.comandos.Tag;
import neero.demon.comandos.TogglePvP;
import neero.demon.comandos.Tp;
import neero.demon.comandos.Warps;
import neero.demon.eventos.Dinheiro;
import neero.demon.eventos.Drops;
import neero.demon.eventos.JoinManager;
import neero.demon.eventos.Menus;
import neero.demon.eventos.Nerfs;
import neero.demon.eventos.Placa;
import neero.demon.kit2.Ajnin;
import neero.demon.kit2.Fireboost;
import neero.demon.kits.Achilles;
import neero.demon.kits.Anchor;
import neero.demon.kits.AntiStomper;
import neero.demon.kits.Archer;
import neero.demon.kits.Assassin;
import neero.demon.kits.Barbarian;
import neero.demon.kits.Berserker;
import neero.demon.kits.Boxer;
import neero.demon.kits.Challenger;
import neero.demon.kits.Demoman;
import neero.demon.kits.Ebola;
import neero.demon.kits.Escalador;
import neero.demon.kits.Escapist;
import neero.demon.kits.Fisherman;
import neero.demon.kits.Gambler;
import neero.demon.kits.Gladiator;
import neero.demon.kits.Hulk;
import neero.demon.kits.Kangaroo;
import neero.demon.kits.Launcher;
import neero.demon.kits.Neo;
import neero.demon.kits.Pesadelo;
import neero.demon.kits.Phantom;
import neero.demon.kits.Pikachu;
import neero.demon.kits.Poseidon;
import neero.demon.kits.PvP;
import neero.demon.kits.Reaper;
import neero.demon.kits.Salvager;
import neero.demon.kits.Skyrunner;
import neero.demon.kits.Snail;
import neero.demon.kits.Sniper;
import neero.demon.kits.Souper;
import neero.demon.kits.Specialist;
import neero.demon.kits.Stomper;
import neero.demon.kits.Sumo;
import neero.demon.kits.Tank;
import neero.demon.kits.Test;
import neero.demon.kits.Thor;
import neero.demon.kits.Timelord;
import neero.demon.kits.Tocha;
import neero.demon.kits.Turtle;
import neero.demon.kits.Urgal;
import neero.demon.kits.Vampire;
import neero.demon.kits.Viking;
import neero.demon.kits.Viper;
import neero.demon.kits.Vulture;
import neero.demon.utils.Clicktest;
import neero.demon.utils.ItemManager;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ public class Main extends JavaPlugin implements Listener
/*     */ {
/*     */   public static Plugin plugin;

/* 114 */   SettingsManager settings = SettingsManager.getInstance();
/* 115 */   ArrayList<String> a1 = new ArrayList<String>();
public File loja1;
public org.bukkit.configuration.file.YamlConfiguration loja;
public static Main instance;
public static String prefix = "prefix";
			public static FileConfiguration config;
/* 116 */   ArrayList<String> a2 = new ArrayList<String>();
/* 117 */   public static final List<Player> warping = new ArrayList<Player>();
/* 118 */   public static ItemManager im = new ItemManager();
/* 119 */   public HashMap<CommandSender, CommandSender> replies = new HashMap<CommandSender, CommandSender>();

/*     */   
/*     */   public static Plugin getPlugin()
/*     */   {
/* 123 */     return plugin;
/*     */   }
public static Main getInstance()
{
  return instance;
}

/*     */   
/*     */   public void onEnable()
/*     */   {
/* 128 */     Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 132 */         String[] msg = {
/* 133 */           "§4§lAVISO §7Compre Kits SecundÃ¡rios e VIP Na Loja > §n§oExtremelojapvp.buycraft.net", 
/* 134 */           "§4§lAVISO §7Encontrou algum hacker? Digite §4§o/report <Nick> <Hack Utilizado>", 
/* 135 */           "§4§lAVISO §7Nao e permitido times em nenhuma WARP", 
/* 135 */           "§4§lAVISO §7Veja seu RANK §m(ou de outro jogador)§7 Digitando /ranks", 
/* 136 */           "§4§lAVISO §7Nos temos tag Youtuber! Digite §b§o/youtuber §6§opara saber mais" };
/*     */         
/* 138 */         Bukkit.getServer().broadcastMessage(msg[new java.util.Random().nextInt(msg.length)]);
/*     */       }
/* 140 */     }, 40L, 1900L);
				instance = this;
/*     */     	    File loja = new File(getDataFolder(), "loja.yml");
if (!loja.exists())
    saveResource("loja.yml", false);
  this.loja1 = new File(getDataFolder(), "loja.yml");
  this.loja = YamlConfiguration.loadConfiguration(loja);
/* 142 */     FileConfiguration config = getConfig();
/* 143 */     config.options().copyDefaults(true);
/* 144 */     saveConfig();
/*     */     
/* 146 */     getServer().getPluginManager().registerEvents(this, this);
/*     */     
/* 148 */     this.settings.setup(this);
/* 149 */     plugin = this;
			  
			  Dinheiro.createFile1();
/* 151 */     comandos();
/* 152 */     comandosuteis();
/* 153 */     eventos();


/*     */   }
public void save2() {
    try {
      this.loja.save(this.loja1);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



/*     */   
/*     */   @EventHandler
/*     */   public void tell(PlayerQuitEvent e)
/*     */   {
/* 159 */     if (this.replies.containsKey(e.getPlayer())) {
/* 160 */       this.replies.remove(e.getPlayer());
/*     */     }
/*     */   }
/*     */   
/*     */   public void comandosuteis()
/*     */   {
/* 166 */     getCommand("fake").setExecutor(new Fake());
/* 168 */     getCommand("togglepvp").setExecutor(new TogglePvP());
/* 170 */     getCommand("pchat").setExecutor(new ClearChat());
/* 171 */     getCommand("cc").setExecutor(new ClearChat());
/* 172 */     getCommand("crash").setExecutor(new Crash(this));
/* 173 */     getCommand("fly").setExecutor(new Fly(this));
/* 174 */     getCommand("gm").setExecutor(new Gm(this));
/* 175 */     getCommand("head").setExecutor(new neero.demon.comandos.Head(this));
/* 176 */     getCommand("inv").setExecutor(new Inventario(this));
/* 179 */     getCommand("report").setExecutor(new Report(this));
/* 180 */     getCommand("skit").setExecutor(new Skit());
/* 182 */     getCommand("recraft").setExecutor(new Recraft());
/* 181 */     getCommand("s").setExecutor(new StaffChat());
/* 182 */     getCommand("tp").setExecutor(new Tp());
/* 183 */     getCommand("broadcast").setExecutor(new Broadcast());
/* 184 */     getCommand("bc").setExecutor(new Broadcast());
/* 185 */     getCommand("ping").setExecutor(new Ping());
/*     */   }
/*     */   
/*     */   public void comandos()
/*     */   {
/* 192 */     getCommand("challenger").setExecutor(new Challenger());
/* 193 */     getCommand("gladiator").setExecutor(new Gladiator(this));
/* 193 */     getCommand("anchor2").setExecutor(new Fireboost(this));
/* 194 */     getCommand("sumo").setExecutor(new Sumo(this));
/* 195 */     getCommand("check").setExecutor(new Check(this));
/* 196 */     getCommand("kit").setExecutor(new Kit());
/* 197 */     getCommand("kits").setExecutor(new Kit());
/* 198 */     getCommand("escalador").setExecutor(new Test());
/* 199 */     getCommand("escalador").setExecutor(new Escalador(this));
/* 200 */     getCommand("achilles").setExecutor(new Achilles(this));
/* 201 */     getCommand("anchor").setExecutor(new Anchor(this));
/* 201 */     getCommand("aplicar").setExecutor(new Aplicar());
/* 202 */     getCommand("archer").setExecutor(new Archer());
/* 203 */     getCommand("assassin").setExecutor(new Assassin(this));
/* 204 */     getCommand("barbarian").setExecutor(new Barbarian());
/* 205 */     getCommand("berserker").setExecutor(new Berserker());
/* 206 */     getCommand("boxer").setExecutor(new Boxer());
/* 207 */     getCommand("demoman").setExecutor(new Demoman());
/* 208 */     getCommand("escapist").setExecutor(new Escapist(this));
/* 209 */     getCommand("fisherman").setExecutor(new Fisherman());
/* 210 */     getCommand("neo").setExecutor(new Neo());
/* 211 */     getCommand("gambler").setExecutor(new Gambler(this));
/* 212 */     getCommand("hulk").setExecutor(new Hulk(this));
/* 213 */     getCommand("ebola").setExecutor(new Ebola());
/* 214 */     getCommand("kangaroo").setExecutor(new Kangaroo(this));
/* 215 */     getCommand("launcher").setExecutor(new Launcher(this));
/* 216 */     getCommand("pesadelo").setExecutor(new Pesadelo(this));
/* 217 */     getCommand("phantom").setExecutor(new Phantom(this));
/* 218 */     getCommand("pikachu").setExecutor(new Pikachu(this));
/* 219 */     getCommand("poseidon").setExecutor(new Poseidon());
/* 220 */     getCommand("reaper").setExecutor(new Reaper());
/* 221 */     getCommand("salvager").setExecutor(new Salvager());
/* 222 */     getCommand("skyrunner").setExecutor(new Skyrunner(this));
/* 223 */     getCommand("snail").setExecutor(new Snail());
/* 224 */     getCommand("souper").setExecutor(new Souper());
/* 225 */     getCommand("specialist").setExecutor(new Specialist());
/* 226 */     getCommand("stomper").setExecutor(new Stomper());
/* 227 */     getCommand("tank").setExecutor(new Tank());
/* 228 */     getCommand("thor").setExecutor(new Thor(this));
/* 229 */     getCommand("timelord").setExecutor(new Timelord(this));
/* 230 */     getCommand("tocha").setExecutor(new Tocha(this));
/* 231 */     getCommand("turtle").setExecutor(new Turtle());
/* 232 */     getCommand("urgal").setExecutor(new Urgal());
/* 233 */     getCommand("vampire").setExecutor(new Vampire());
/* 233 */     getCommand("admin").setExecutor(new Admin());
/* 234 */     getCommand("viking").setExecutor(new Viking());
/* 235 */     getCommand("viper").setExecutor(new Viper());
/* 236 */     getCommand("vulture").setExecutor(new Vulture());
/* 237 */     getCommand("pvp").setExecutor(new PvP());
/* 240 */     getCommand("warps").setExecutor(new Warps());
/* 241 */     getCommand("warp").setExecutor(new Warps());
/* 242 */     getCommand("serverinfo").setExecutor(new Warps());
/* 244 */     getCommand("ajnin2").setExecutor(new Ajnin());
/* 242 */     getCommand("loja").setExecutor(new LojadeKits());
/* 244 */     getCommand("sniper").setExecutor(new Sniper(this));
/* 244 */     getCommand("tag").setExecutor(new Tag());
/* 244 */     getCommand("antistomper2").setExecutor(new AntiStomper(this));
/* 244 */     getCommand("youtuber").setExecutor(new Warps());
/* 244 */     getCommand("kit2").setExecutor(new Kit2());
/* 244 */     getCommand("clicktest").setExecutor(new Clicktest());
/* 244 */     getCommand("ranks").setExecutor(new Rank());
/* 244 */     getCommand("lojaitens").setExecutor(new LojaKits(this));
/* 244 */     getCommand("stomper2").setExecutor(new neero.demon.kit2.Stomper());
/* 244 */     getCommand("extra").setExecutor(new neero.demon.comandos.Menu());
/*     */   }

/*     */   
/*     */   public void eventos()
/*     */   {
/* 249 */     PluginManager pm = Bukkit.getServer().getPluginManager();
/*     */     
/* 251 */     pm.registerEvents(new Ajnin(), this);
/* 251 */     pm.registerEvents(new Sniper(this), this);
/* 251 */     pm.registerEvents(new Menu(), this);
/* 251 */     pm.registerEvents(new Admin(), this);
/* 251 */     pm.registerEvents(new LojadeKits(), this);
/* 251 */     pm.registerEvents(new Drops(), this);
/* 251 */     pm.registerEvents(new LojaKits(this), this);
/* 251 */     pm.registerEvents(new Scoreboard(), this);
/* 251 */     pm.registerEvents(new neero.demon.kit2.Stomper(), this);
/* 252 */     pm.registerEvents(new TogglePvP(), this);
/* 253 */     pm.registerEvents(new ClearChat(), this);
/* 254 */     pm.registerEvents(new Challenger(), this);
/* 256 */     pm.registerEvents(new Placa(this), this);
/* 259 */     pm.registerEvents(new Nerfs(), this);
/* 260 */     pm.registerEvents(new Gladiator(this), this);
/* 261 */     pm.registerEvents(new Warps(), this);
/* 262 */     pm.registerEvents(new Challenger(), this);
/* 263 */     pm.registerEvents(new Menus(), this);
/* 263 */     pm.registerEvents(new Fake(), this);
/* 264 */     pm.registerEvents(new Sumo(this), this);
/* 265 */     pm.registerEvents(new PvP(), this);
/* 268 */     pm.registerEvents(new Vulture(), this);
/* 269 */     pm.registerEvents(new Viper(), this);
/* 270 */     pm.registerEvents(new Viking(), this);
/* 271 */     pm.registerEvents(new Vampire(), this);
/* 272 */     pm.registerEvents(new Turtle(), this);
/* 273 */     pm.registerEvents(new Clicktest(), this);
/* 273 */     pm.registerEvents(new Tocha(this), this);
/* 274 */     pm.registerEvents(new Timelord(this), this);
/* 275 */     pm.registerEvents(new Thor(this), this);
/* 276 */     pm.registerEvents(new Tank(), this);
/* 277 */     pm.registerEvents(new Stomper(), this);
/* 278 */     pm.registerEvents(new Souper(), this);
/* 279 */     pm.registerEvents(new Snail(), this);
/* 280 */     pm.registerEvents(new Skyrunner(this), this);
/* 281 */     pm.registerEvents(new Salvager(), this);
/* 282 */     pm.registerEvents(new neero.demon.comandos.Menu(), this);
/* 282 */     pm.registerEvents(new Reaper(), this);
/* 283 */     pm.registerEvents(new Poseidon(), this);
/* 284 */     pm.registerEvents(new Pikachu(this), this);
/* 285 */     pm.registerEvents(new Phantom(this), this);
/* 286 */     pm.registerEvents(new Pesadelo(this), this);
/* 287 */     pm.registerEvents(new Launcher(this), this);
/* 288 */     pm.registerEvents(new Kangaroo(this), this);
/* 289 */     pm.registerEvents(new Ebola(), this);
/* 290 */     pm.registerEvents(new Hulk(this), this);
/* 291 */     pm.registerEvents(new Gambler(this), this);
/* 292 */     pm.registerEvents(new Neo(), this);
/* 293 */     pm.registerEvents(new Fisherman(), this);
/* 294 */     pm.registerEvents(new Escapist(this), this);
/* 294 */     pm.registerEvents(new Fireboost(this), this);
/* 295 */     pm.registerEvents(new Boxer(), this);
/* 296 */     pm.registerEvents(new Assassin(this), this);
/* 297 */     pm.registerEvents(new Barbarian(), this);
/* 298 */     pm.registerEvents(new Berserker(), this);
/*     */     
/* 302 */     Bukkit.getServer().getPluginManager().registerEvents(new Skit(), this);
/* 305 */     Bukkit.getServer().getPluginManager().registerEvents(new Archer(), this);
/* 306 */     Bukkit.getServer().getPluginManager().registerEvents(new Anchor(this), this);
/* 307 */     Bukkit.getServer().getPluginManager().registerEvents(new Achilles(this), this);
/* 308 */     Bukkit.getServer().getPluginManager().registerEvents(new JoinManager(), this);
/* 309 */     Bukkit.getServer().getPluginManager().registerEvents(new Kit(), this);
/* 310 */     Bukkit.getServer().getPluginManager().registerEvents(new Test(), this);
/* 311 */     Bukkit.getServer().getPluginManager().registerEvents(new Escalador(this), this);
/* 312 */     Bukkit.getServer().getPluginManager().registerEvents(new Demoman(), this);
/*     */   }

/*     */   public void tp(Player a, Location loc)
/*     */   {
/* 317 */     this.a1.add(a.getName());
/* 318 */     Player p = a;
/* 319 */     Location loc1 = loc;
/* 320 */     this.a1.remove(p.getName());
/* 321 */     p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
/* 322 */     p.teleport(loc1);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*     */   {
/* 327 */     final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 328 */     ItemMeta sMeta = sopa.getItemMeta();
/* 329 */     sMeta.setDisplayName("§6Sopa");
/* 330 */     sopa.setItemMeta(sMeta);
/* 331 */     if ((sender instanceof Player))
/*     */     {
/* 333 */       final Player p = (Player)sender;
/* 334 */       if (!(sender instanceof Player))
/*     */       {
/* 336 */         sender.sendMessage(ChatColor.RED + "Voce nao pode usa admin!");
/* 337 */         return true;
/*     */       }
/* 339 */       if (cmd.getName().equalsIgnoreCase("setrdm"))
/*     */       {
/* 341 */         if (!p.hasPermission("fire.setwarp"))
/*     */         {
/* 343 */           sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
/* 344 */           return true;
/*     */         }
/* 346 */         getConfig().set("RdmWorld", p.getLocation().getWorld().getName());
/* 347 */         getConfig().set("RdmX", Double.valueOf(p.getLocation().getX()));
/* 348 */         getConfig().set("RdmY", Double.valueOf(p.getLocation().getY()));
/* 349 */         getConfig().set("RdmZ", Double.valueOf(p.getLocation().getZ()));
/* 350 */         saveConfig();
/* 351 */         p.sendMessage("§aReiDaMesa setado!");
/* 352 */         return true;
/*     */       }
/* 339 */       if (cmd.getName().equalsIgnoreCase("setparkour"))
/*     */       {
/* 341 */         if (!p.hasPermission("fire.setwarp"))
/*     */         {
/* 343 */           sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
/* 344 */           return true;
/*     */         }
/* 346 */         getConfig().set("ParkourWorld", p.getLocation().getWorld().getName());
/* 347 */         getConfig().set("ParkourX", Double.valueOf(p.getLocation().getX()));
/* 348 */         getConfig().set("ParkourY", Double.valueOf(p.getLocation().getY()));
/* 349 */         getConfig().set("ParkourZ", Double.valueOf(p.getLocation().getZ()));
/* 350 */         saveConfig();
/* 351 */         p.sendMessage("§aParkour setado!");
/* 352 */         return true;
/*     */       }
/* 354 */       if (cmd.getName().equalsIgnoreCase("setspawn"))
/*     */       {
/* 356 */         if (!p.hasPermission("fire.setwarp"))
/*     */         {
/* 358 */           sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
/* 359 */           return true;
/*     */         }
/* 361 */         getConfig().set("SpawnWorld", p.getLocation().getWorld().getName());
/* 362 */         getConfig().set("SpawnX", Double.valueOf(p.getLocation().getX()));
/* 363 */         getConfig().set("SpawnY", Double.valueOf(p.getLocation().getY()));
/* 364 */         getConfig().set("SpawnZ", Double.valueOf(p.getLocation().getZ()));
/* 365 */         saveConfig();
/* 366 */         World world = p.getWorld();
/* 367 */         Location loc = p.getLocation();
/* 368 */         world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
/* 369 */         p.sendMessage("§aSpawn setado!");
/* 370 */         return true;
/*     */       }
/* 372 */       if (cmd.getName().equalsIgnoreCase("setfps"))
/*     */       {
/* 374 */         if (!p.hasPermission("fire.setwarp"))
/*     */         {
/* 376 */           sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
/* 377 */           return true;
/*     */         }
/* 379 */         getConfig().set("FpsWorld", p.getLocation().getWorld().getName());
/* 380 */         getConfig().set("FpsX", Double.valueOf(p.getLocation().getX()));
/* 381 */         getConfig().set("FpsY", Double.valueOf(p.getLocation().getY()));
/* 382 */         getConfig().set("FpsZ", Double.valueOf(p.getLocation().getZ()));
/* 383 */         saveConfig();
/* 384 */         p.sendMessage("§aFps setado!");
/* 385 */         return true;
/*     */       }
/* 387 */       if (cmd.getName().equalsIgnoreCase("setchallenge"))
/*     */       {
/* 389 */         if (!p.hasPermission("fire.setwarp"))
/*     */         {
/* 391 */           sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
/* 392 */           return true;
/*     */         }
/* 394 */         getConfig().set("ChallengeWorld", p.getLocation().getWorld().getName());
/* 395 */         getConfig().set("ChallengeX", Double.valueOf(p.getLocation().getX()));
/* 396 */         getConfig().set("ChallengeY", Double.valueOf(p.getLocation().getY()));
/* 397 */         getConfig().set("ChallengeZ", Double.valueOf(p.getLocation().getZ()));
/* 398 */         saveConfig();
/* 399 */         p.sendMessage("§aChallenge setado!");
/* 400 */         return true;
/*     */       }
/* 402 */       if (cmd.getName().equalsIgnoreCase("setmdr"))
/*     */       {
/* 404 */         if (!p.hasPermission("fire.setwarp"))
/*     */         {
/* 406 */           sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
/* 407 */           return true;
/*     */         }
/* 409 */         getConfig().set("MdrWorld", p.getLocation().getWorld().getName());
/* 410 */         getConfig().set("MdrX", Double.valueOf(p.getLocation().getX()));
/* 411 */         getConfig().set("MdrY", Double.valueOf(p.getLocation().getY()));
/* 412 */         getConfig().set("MdrZ", Double.valueOf(p.getLocation().getZ()));
/* 413 */         saveConfig();
/* 414 */         p.sendMessage("§aMdr setado!");
/* 415 */         return true;
/*     */       }
/* 417 */       if (cmd.getName().equalsIgnoreCase("mdr"))
/*     */       {
/* 419 */         p.sendMessage("§c§oVoce sera teleportado em 5 segundos");
/* 420 */         warping.add(p);
/* 421 */         Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 425 */             if (Main.warping.contains(p))
/*     */             {
/* 427 */               for (PotionEffect effect : p.getActivePotionEffects()) {
/* 428 */                 p.removePotionEffect(effect.getType());
/*     */               }
/* 430 */               ItemStack espada = new ItemStack(Material.STONE_SWORD);
/* 431 */               World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("MdrWorld"));
/* 432 */               double x = Main.this.getConfig().getDouble("MdrX");
/* 433 */               double y = Main.this.getConfig().getDouble("MdrY");
/* 434 */               double z = Main.this.getConfig().getDouble("MdrZ");
/* 435 */               p.teleport(new Location(w, x, y, z));
/* 436 */               p.getInventory().clear();
/* 437 */               p.getInventory().addItem(new ItemStack[] { espada });
/* 438 */               for (int i = 0; i <= 34; i++) {
/* 439 */                 p.getInventory().addItem(new ItemStack[] { sopa });
/*     */               }
/* 441 */               p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
/* 444 */               Main.warping.remove(p);
/*     */             }
/*     */           }
/* 447 */         }, 100L);
/* 449 */       if (cmd.getName().equalsIgnoreCase("rdm"))
/*     */       {
/* 451 */         p.sendMessage("§c§oVoce sera teleportado em 5 segundos");
/* 452 */         warping.add(p);
/* 453 */         Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 457 */             if (Main.warping.contains(p))
/*     */             {
/* 459 */               for (PotionEffect effect : p.getActivePotionEffects()) {
/* 460 */                 p.removePotionEffect(effect.getType());
/*     */               }
/* 462 */               World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("RdmWorld"));
/* 463 */               double x = Main.this.getConfig().getDouble("RdmX");
/* 464 */               double y = Main.this.getConfig().getDouble("RdmY");
/* 465 */               double z = Main.this.getConfig().getDouble("RdmZ");
/* 466 */               PlayerInventory inv = p.getInventory();
/* 467 */               p.teleport(new Location(w, x, y, z));
/* 468 */               p.getInventory().clear();
/* 471 */               ItemStack espada = new ItemStack(Material.STONE_SWORD);
/* 472 */               p.getInventory().setArmorContents(null);
/* 473 */               inv.addItem(new ItemStack[] { espada });
/* 474 */               inv.addItem(new ItemStack[] { sopa });
/* 475 */               inv.addItem(new ItemStack[] { sopa });
/* 476 */               inv.addItem(new ItemStack[] { sopa });
/* 477 */               inv.addItem(new ItemStack[] { sopa });
/* 478 */               inv.addItem(new ItemStack[] { sopa });
/* 479 */               inv.addItem(new ItemStack[] { sopa });
/* 480 */               inv.addItem(new ItemStack[] { sopa });
/* 481 */               inv.addItem(new ItemStack[] { sopa });
/* 482 */               inv.addItem(new ItemStack[] { sopa });
/* 483 */               inv.addItem(new ItemStack[] { sopa });
/* 484 */               inv.addItem(new ItemStack[] { sopa });
/* 485 */               inv.addItem(new ItemStack[] { sopa });
/* 486 */               inv.addItem(new ItemStack[] { sopa });
/* 487 */               inv.addItem(new ItemStack[] { sopa });
/* 488 */               inv.addItem(new ItemStack[] { sopa });
/* 489 */               inv.addItem(new ItemStack[] { sopa });
/* 490 */               inv.addItem(new ItemStack[] { sopa });
/* 491 */               inv.addItem(new ItemStack[] { sopa });
/* 492 */               inv.addItem(new ItemStack[] { sopa });
/* 493 */               inv.addItem(new ItemStack[] { sopa });
/* 494 */               inv.addItem(new ItemStack[] { sopa });
/* 495 */               inv.addItem(new ItemStack[] { sopa });
/* 496 */               inv.addItem(new ItemStack[] { sopa });
/* 497 */               inv.addItem(new ItemStack[] { sopa });
/* 498 */               inv.addItem(new ItemStack[] { sopa });
/* 499 */               inv.addItem(new ItemStack[] { sopa });
/* 500 */               inv.addItem(new ItemStack[] { sopa });
/* 501 */               inv.addItem(new ItemStack[] { sopa });
/* 502 */               inv.addItem(new ItemStack[] { sopa });
/* 503 */               inv.addItem(new ItemStack[] { sopa });
/* 504 */               inv.addItem(new ItemStack[] { sopa });
/* 505 */               inv.addItem(new ItemStack[] { sopa });
/* 506 */               inv.addItem(new ItemStack[] { sopa });
/* 507 */               inv.addItem(new ItemStack[] { sopa });
/* 508 */               inv.addItem(new ItemStack[] { sopa });
/* 509 */               p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
/* 510 */               Main.warping.remove(p);
/*     */             }
/*     */           }
/* 513 */         }, 100L);
/*     */       }
/* 515 */       if (cmd.getName().equalsIgnoreCase("main"))
/*     */       {
/* 517 */         p.sendMessage("§c§oVoce sera teleportado em 5 segundos");
/* 518 */         warping.add(p);
/* 519 */         Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 523 */             if (Main.warping.contains(p))
/*     */             {
/* 525 */               for (PotionEffect effect : p.getActivePotionEffects()) {
/* 526 */                 p.removePotionEffect(effect.getType());
/*     */               }
/* 528 */               World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("MainWorld"));
/* 529 */               double x = Main.this.getConfig().getDouble("MainX");
/* 530 */               double y = Main.this.getConfig().getDouble("MainY");
/* 531 */               double z = Main.this.getConfig().getDouble("MainZ");
/* 532 */               p.teleport(new Location(w, x, y, z));
/* 533 */               p.getInventory().clear();
/* 534 */               p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
/* 535 */               p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
/* 536 */               p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
/* 537 */               p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
/* 538 */               p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
/* 541 */               Main.warping.remove(p);
/*     */             }
/*     */           }
/* 544 */         }, 100L);
/*     */       }
/* 546 */       if (cmd.getName().equalsIgnoreCase("challenge"))
/*     */       {
/* 548 */         p.sendMessage("§c§oVoce sera teleportado em 5 segundos");
/* 549 */         warping.add(p);
/* 550 */         Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 554 */             if (Main.warping.contains(p))
/*     */             {
/* 556 */               for (PotionEffect effect : p.getActivePotionEffects()) {
/* 557 */                 p.removePotionEffect(effect.getType());
/*     */               }
/* 559 */               World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("ChallengeWorld"));
/* 560 */               double x = Main.this.getConfig().getDouble("ChallengeX");
/* 561 */               double y = Main.this.getConfig().getDouble("ChallengeY");
/* 562 */               double z = Main.this.getConfig().getDouble("ChallengeZ");
/* 563 */               PlayerInventory inv = p.getInventory();
/* 564 */               p.teleport(new Location(w, x, y, z));
/* 565 */               p.getInventory().clear();
/* 566 */               p.getInventory().setArmorContents(null);
/* 569 */               ItemStack espada = new ItemStack(Material.STONE_SWORD);
/* 570 */               inv.addItem(new ItemStack[] { espada });
/* 571 */               inv.addItem(new ItemStack[] { sopa });
/* 572 */               inv.addItem(new ItemStack[] { sopa });
/* 573 */               inv.addItem(new ItemStack[] { sopa });
/* 574 */               inv.addItem(new ItemStack[] { sopa });
/* 575 */               inv.addItem(new ItemStack[] { sopa });
/* 576 */               inv.addItem(new ItemStack[] { sopa });
/* 577 */               inv.addItem(new ItemStack[] { sopa });
/* 578 */               inv.addItem(new ItemStack[] { sopa });
/* 579 */               inv.addItem(new ItemStack[] { sopa });
/* 580 */               inv.addItem(new ItemStack[] { sopa });
/* 581 */               inv.addItem(new ItemStack[] { sopa });
/* 582 */               inv.addItem(new ItemStack[] { sopa });
/* 583 */               inv.addItem(new ItemStack[] { sopa });
/* 584 */               inv.addItem(new ItemStack[] { sopa });
/* 585 */               inv.addItem(new ItemStack[] { sopa });
/* 586 */               inv.addItem(new ItemStack[] { sopa });
/* 587 */               inv.addItem(new ItemStack[] { sopa });
/* 588 */               inv.addItem(new ItemStack[] { sopa });
/* 589 */               inv.addItem(new ItemStack[] { sopa });
/* 590 */               inv.addItem(new ItemStack[] { sopa });
/* 591 */               inv.addItem(new ItemStack[] { sopa });
/* 592 */               inv.addItem(new ItemStack[] { sopa });
/* 593 */               inv.addItem(new ItemStack[] { sopa });
/* 594 */               inv.addItem(new ItemStack[] { sopa });
/* 595 */               inv.addItem(new ItemStack[] { sopa });
/* 596 */               inv.addItem(new ItemStack[] { sopa });
/* 597 */               inv.addItem(new ItemStack[] { sopa });
/* 598 */               inv.addItem(new ItemStack[] { sopa });
/* 599 */               inv.addItem(new ItemStack[] { sopa });
/* 600 */               inv.addItem(new ItemStack[] { sopa });
/* 601 */               inv.addItem(new ItemStack[] { sopa });
/* 602 */               inv.addItem(new ItemStack[] { sopa });
/* 603 */               p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
/* 604 */               Main.warping.remove(p);
/*     */             }
/*     */           }
/* 607 */         }, 100L);
/*     */       }
/* 609 */       if (cmd.getName().equalsIgnoreCase("fps"))
/*     */       {
/* 611 */         p.sendMessage("§c§oVoce sera teleportado em 5 segundos");
/* 612 */         warping.add(p);
/* 613 */         Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 617 */             if (Main.warping.contains(p))
/*     */             {
/* 619 */               for (PotionEffect effect : p.getActivePotionEffects()) {
/* 620 */                 p.removePotionEffect(effect.getType());
/*     */               }
/* 622 */               ItemStack espada = new ItemStack(Material.STONE_SWORD);
/* 623 */               World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("FpsWorld"));
/* 624 */               double x = Main.this.getConfig().getDouble("FpsX");
/* 625 */               double y = Main.this.getConfig().getDouble("FpsY");
/* 626 */               double z = Main.this.getConfig().getDouble("FpsZ");
/* 627 */               p.teleport(new Location(w, x, y, z));
/* 628 */               p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
/* 629 */               Main.warping.remove(p);
/* 632 */               p.getInventory().setArmorContents(null);
/* 633 */               p.getInventory().clear();
/* 634 */               p.getInventory().addItem(new ItemStack[] { espada });
/* 635 */               for (int i = 0; i <= 34; i++) {
/* 636 */                 p.getInventory().addItem(new ItemStack[] { sopa });
/*     */               }
/*     */             }
/*     */           }
/* 640 */         }, 100L);
/*     */       }
/* 642 */       if (cmd.getName().equalsIgnoreCase("spawn"))
/*     */       {
/* 644 */         p.sendMessage("§a§oVoce sera teleportado em 5 segundos");
/* 645 */         warping.add(p);
/* 646 */         Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
/*     */         {
/*     */ 
/*     */           @SuppressWarnings("deprecation")
public void run()
/*     */           {
/* 651 */             if (Main.warping.contains(p))
/*     */             {
/* 653 */               p.teleport(p.getWorld().getSpawnLocation());
/*     */               
/* 655 */               p.getInventory().setArmorContents(null);
/* 656 */               for (PotionEffect effect : p.getActivePotionEffects()) {
/* 657 */                 p.removePotionEffect(effect.getType());
/*     */               }
/* 659 */               p.getInventory().setArmorContents(null);
/* 660 */               p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
/* 661 */               p.removePotionEffect(PotionEffectType.SPEED);
/* 662 */               p.removePotionEffect(PotionEffectType.JUMP);
/*     */               
/* 664 */               p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
/* 665 */               Main.warping.remove(p);
/*     */               
/*     */ 
/* 669 */               p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
/* 670 */               p.removePotionEffect(PotionEffectType.SPEED);
/* 671 */               p.removePotionEffect(PotionEffectType.JUMP);
/* 672 */               p.getInventory().clear();
/*     */               
/* 674 */               ItemStack livro = Main.im.createItem(Material.getMaterial(340), "livro", "§aKits", new String[] { "§cEscolha seu kit" }, 1, (short)0);
/* 675 */               ItemStack barra = Main.im.createItem(Material.getMaterial(101), "barra", "-", new String[0], 1, (short)0);
/* 676 */               ItemStack papel = Main.im.createItem(Material.getMaterial(339), "barra", "§aWarps", new String[] { "§cVa para alguma warp" }, 1, (short)0);
/* 677 */               ItemStack yt = Main.im.createItem(Material.getMaterial(264), "barra", "§aYoutuber", new String[] { "§cveja os requisitos para ser §Youtuber" }, 1, (short)0);
/* 678 */               ItemStack air = new ItemStack(Material.AIR);
/*     */               
/* 680 */               p.getInventory().clear();
/* 681 */               p.getInventory().setItem(0, air);
/* 682 */               p.getInventory().setItem(1, air);
/* 683 */               p.getInventory().setItem(2, papel);
/* 684 */               p.getInventory().setItem(3, barra);
/* 685 */               p.getInventory().setItem(4, livro);
/* 686 */               p.getInventory().setItem(5, barra);
/* 687 */               p.getInventory().setItem(6, yt);
/* 688 */               p.getInventory().setItem(7, air);
/* 689 */               p.getInventory().setItem(8, air);
/*     */             }
/*     */           }
/* 692 */         }, 100L);
/*     */       }
}
}
return false;
}
}