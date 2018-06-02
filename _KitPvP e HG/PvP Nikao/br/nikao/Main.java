/*     */ package br.nikao;
/*     */ 
/*     */ import br.nikao.comandos.Admin;
/*     */ import br.nikao.comandos.Aplicar;
/*     */ import br.nikao.comandos.Arena;
/*     */ import br.nikao.comandos.Build;
/*     */ import br.nikao.comandos.Chat;
/*     */ import br.nikao.comandos.Fly;
/*     */ import br.nikao.comandos.Kit;
/*     */ import br.nikao.comandos.KitPos;
/*     */ import br.nikao.comandos.Lag;
/*     */ import br.nikao.comandos.Rank;
/*     */ import br.nikao.comandos.Report;
/*     */ import br.nikao.comandos.Score;
/*     */ import br.nikao.comandos.StaffChat;
/*     */ import br.nikao.comandos.TPHere;
/*     */ import br.nikao.comandos.TPall;
/*     */ import br.nikao.comandos.Tag;
/*     */ import br.nikao.comandos.TogglePvP;
/*     */ import br.nikao.comandos.Tp;
/*     */ import br.nikao.comandos.Youtuber;
/*     */ import br.nikao.comandos.cc;
/*     */ import br.nikao.comandos.gm;
/*     */ import br.nikao.comandos.me;
/*     */ import br.nikao.eventos.Entrar;
/*     */ import br.nikao.eventos.Morrer;
/*     */ import br.nikao.eventos.Respawn;
/*     */ import br.nikao.eventos.Sair;
/*     */ import br.nikao.gui.Caixas;
/*     */ import br.nikao.gui.ComprarCaixa;
/*     */ import br.nikao.gui.Kits;
/*     */ import br.nikao.gui.LojaDeKits;
/*     */ import br.nikao.gui.Warps;
/*     */ import br.nikao.kits.Anchor;
/*     */ import br.nikao.kits.Barbarian;
/*     */ import br.nikao.kits.C4;
/*     */ import br.nikao.kits.Camel;
/*     */ import br.nikao.kits.Critical;
/*     */ import br.nikao.kits.Deshfire;
/*     */ import br.nikao.kits.Endermage;
/*     */ import br.nikao.kits.Fireman;
/*     */ import br.nikao.kits.ForceField;
/*     */ import br.nikao.kits.Frosty;
/*     */ import br.nikao.kits.Grappler;
/*     */ import br.nikao.kits.Hulk;
/*     */ import br.nikao.kits.Kangaroo;
/*     */ import br.nikao.kits.Launcher;
/*     */ import br.nikao.kits.Magma;
/*     */ import br.nikao.kits.Monk;
/*     */ import br.nikao.kits.Ninja;
/*     */ import br.nikao.kits.Phantom;
/*     */ import br.nikao.kits.Poseidon;
/*     */ import br.nikao.kits.Rain;
/*     */ import br.nikao.kits.Reaper;
/*     */ import br.nikao.kits.Resouper;
/*     */ import br.nikao.kits.Ryu;
/*     */ import br.nikao.kits.Specialist;
/*     */ import br.nikao.kits.Spiderman;
/*     */ import br.nikao.kits.Stomper;
/*     */ import br.nikao.kits.Switcher;
/*     */ import br.nikao.kits.Thor;
/*     */ import br.nikao.kits.Timelord;
/*     */ import br.nikao.kits.Turtle;
/*     */ import br.nikao.kits.Urgal;
/*     */ import br.nikao.kits.Viking;
/*     */ import br.nikao.kits.Viper;
/*     */ import br.nikao.minigames.VoidChallenge;
/*     */ import br.nikao.nametag.Array;
/*     */ import br.nikao.nametag.NametagEventHandler;
/*     */ import br.nikao.nametag.PlayerLoader;
/*     */ import br.nikao.outros.AntiMoveAPI;
/*     */ import br.nikao.outros.Bussula;
/*     */ import br.nikao.outros.ChatFlood;
/*     */ import br.nikao.outros.Config;
/*     */ import br.nikao.outros.Drop;
/*     */ import br.nikao.outros.ItemQuebrar;
/*     */ import br.nikao.outros.Jump;
/*     */ import br.nikao.outros.KillStreaks;
/*     */ import br.nikao.outros.KitAPI;
/*     */ import br.nikao.outros.Motd;
/*     */ import br.nikao.outros.MsgAutomatica;
/*     */ import br.nikao.outros.PlacadeRecraft;
/*     */ import br.nikao.outros.PlacadeSopa;
/*     */ import br.nikao.outros.RemoverEventos;
/*     */ import br.nikao.outros.Sopa;
/*     */ import br.nikao.outros.TagsAPI;
/*     */ import br.nikao.outros.WarpsAPI;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.ConsoleCommandSender;
/*     */ import org.bukkit.command.PluginCommand;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Main extends JavaPlugin
/*     */ {
/* 102 */   public static HashMap<String, Integer> Kills = new HashMap();
/* 103 */   public static HashMap<String, Integer> Deaths = new HashMap();
/* 104 */   public static HashMap<String, Integer> XP = new HashMap();
/* 105 */   public static HashMap<String, String> Rank = new HashMap();
/*     */   public static Main instance;
/*     */   public static Plugin plugin;
/*     */   
/*     */   public static Main getInstance() {
/* 110 */     return instance;
/*     */   }
/*     */   
/*     */   public void onEnable() {
/* 114 */     plugin = this;
/* 115 */     instance = this;
/* 116 */     saveDefaultConfig();
/* 117 */     Comandos();
/* 118 */     Eventos();
/* 119 */     Array.InciarTag();
/* 120 */     PlayerLoader.load(this);
/* 121 */     new MsgAutomatica(this);
/* 122 */     Bukkit.getServer().getConsoleSender().sendMessage(getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l>> §aFoi ativado com sucesso");
/*     */     
/* 124 */     Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         Player[] arrayOfPlayer;
/* 129 */         int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player s = arrayOfPlayer[i];
/* 130 */           Config.addKill(s, ((Integer)Main.Kills.get(s.getName())).intValue());
/* 131 */           Config.addDeaths(s, ((Integer)Main.Deaths.get(s.getName())).intValue());
/* 132 */           Config.addXP(s, ((Integer)Main.XP.get(s.getName())).intValue());
/*     */         }
/*     */       }
/* 135 */     }, 0L, 6000L);
/*     */   }
/*     */   
/*     */   public void onDisable()
/*     */   {
/* 140 */     Bukkit.getServer().getConsoleSender().sendMessage(getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + " §6§l>> §cFoi desativado com sucesso");
/*     */     
/*     */     Player[] arrayOfPlayer;
/* 143 */     int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
/* 144 */     for (int i = 0; i < j; i++) {
/* 145 */       Player todos = arrayOfPlayer[i];
/* 146 */       todos.kickPlayer(getInstance().getConfig().getString("NomeDoServidor").replace("&", "§") + "\n\n §cO Servidor está reiniciando\n");
/*     */     }
/*     */   }
/*     */   
/*     */   public void Comandos() {
/* 151 */     getCommand("warps").setExecutor(new Warps());
/* 152 */     getCommand("kit").setExecutor(new Kit());
/* 153 */     getCommand("kits").setExecutor(new Kits());
/* 154 */     getCommand("tag").setExecutor(new Tag());
/* 155 */     getCommand("tags").setExecutor(new br.nikao.comandos.Tags());
/* 156 */     getCommand("rank").setExecutor(new Rank());
/* 157 */     getCommand("fps").setExecutor(new WarpsAPI());
/* 158 */     getCommand("mdr").setExecutor(new WarpsAPI());
/* 159 */     getCommand("rdm").setExecutor(new WarpsAPI());
/* 160 */     getCommand("challenge").setExecutor(new WarpsAPI());
/* 161 */     getCommand("spawn").setExecutor(new WarpsAPI());
/* 162 */     getCommand("setspawn").setExecutor(new WarpsAPI());
/* 163 */     getCommand("setchallenge").setExecutor(new WarpsAPI());
/* 164 */     getCommand("setmdr").setExecutor(new WarpsAPI());
/* 165 */     getCommand("setfps").setExecutor(new WarpsAPI());
/* 166 */     getCommand("setrdm").setExecutor(new WarpsAPI());
/* 167 */     getCommand("admin").setExecutor(new Admin());
/* 168 */     getCommand("aplicar").setExecutor(new Aplicar());
/* 169 */     getCommand("arena").setExecutor(new Arena());
/* 170 */     getCommand("build").setExecutor(new Build());
/* 171 */     getCommand("cc").setExecutor(new cc());
/* 172 */     getCommand("report").setExecutor(new Report());
/* 173 */     getCommand("sc").setExecutor(new StaffChat());
/* 174 */     getCommand("togglepvp").setExecutor(new TogglePvP());
/* 175 */     getCommand("tp").setExecutor(new Tp());
/* 176 */     getCommand("tpall").setExecutor(new TPall());
/* 177 */     getCommand("youtuber").setExecutor(new Youtuber());
/* 178 */     getCommand("caixa").setExecutor(new Caixas());
/* 179 */     getCommand("comprarcaixa").setExecutor(new ComprarCaixa());
/* 180 */     getCommand("loja").setExecutor(new LojaDeKits());
/* 181 */     getCommand("kitpos").setExecutor(new KitPos());
/* 182 */     getCommand("lag").setExecutor(new Lag());
/* 183 */     getCommand("ping").setExecutor(new Lag());
/* 184 */     getCommand("status").setExecutor(new br.nikao.comandos.Status());
/* 185 */     getCommand("gm").setExecutor(new gm());
/* 186 */     getCommand("score").setExecutor(new Score());
/* 187 */     getCommand("tphere").setExecutor(new TPHere());
/* 188 */     getCommand("fly").setExecutor(new Fly());
/* 189 */     getCommand("chat").setExecutor(new Chat());
/*     */   }
/*     */   
/*     */   public void Eventos() {
/* 193 */     Bukkit.getServer().getPluginManager().registerEvents(new Entrar(), this);
/* 194 */     Bukkit.getServer().getPluginManager().registerEvents(new Sair(), this);
/* 195 */     Bukkit.getServer().getPluginManager().registerEvents(new Morrer(), this);
/* 196 */     Bukkit.getServer().getPluginManager().registerEvents(new Respawn(), this);
/* 197 */     Bukkit.getServer().getPluginManager().registerEvents(new RemoverEventos(), this);
/* 198 */     Bukkit.getServer().getPluginManager().registerEvents(new Motd(), this);
/* 199 */     Bukkit.getServer().getPluginManager().registerEvents(new Drop(), this);
/* 200 */     Bukkit.getServer().getPluginManager().registerEvents(new KitAPI(), this);
/* 201 */     Bukkit.getServer().getPluginManager().registerEvents(new br.nikao.gui.Status(), this);
/* 202 */     Bukkit.getServer().getPluginManager().registerEvents(new Warps(), this);
/* 203 */     Bukkit.getServer().getPluginManager().registerEvents(new Viper(), this);
/* 204 */     Bukkit.getServer().getPluginManager().registerEvents(new Kangaroo(), this);
/* 205 */     Bukkit.getServer().getPluginManager().registerEvents(new Kits(), this);
/* 206 */     Bukkit.getServer().getPluginManager().registerEvents(new Anchor(), this);
/* 207 */     Bukkit.getServer().getPluginManager().registerEvents(new Sopa(), this);
/* 208 */     Bukkit.getServer().getPluginManager().registerEvents(new Phantom(), this);
/* 209 */     Bukkit.getServer().getPluginManager().registerEvents(new Ninja(), this);
/* 210 */     Bukkit.getServer().getPluginManager().registerEvents(new Thor(), this);
/* 211 */     Bukkit.getServer().getPluginManager().registerEvents(new Timelord(), this);
/* 212 */     Bukkit.getServer().getPluginManager().registerEvents(new AntiMoveAPI(), this);
/* 213 */     Bukkit.getServer().getPluginManager().registerEvents(new br.nikao.kits.Fisherman(), this);
/* 214 */     Bukkit.getServer().getPluginManager().registerEvents(new Fireman(), this);
/* 215 */     Bukkit.getServer().getPluginManager().registerEvents(new Barbarian(), this);
/* 216 */     Bukkit.getServer().getPluginManager().registerEvents(new Hulk(), this);
/* 217 */     Bukkit.getServer().getPluginManager().registerEvents(new Jump(this), this);
/* 218 */     Bukkit.getServer().getPluginManager().registerEvents(new KillStreaks(), this);
/* 219 */     Bukkit.getServer().getPluginManager().registerEvents(new PlacadeRecraft(), this);
/* 220 */     Bukkit.getServer().getPluginManager().registerEvents(new PlacadeSopa(), this);
/* 221 */     Bukkit.getServer().getPluginManager().registerEvents(new Admin(), this);
/* 222 */     Bukkit.getServer().getPluginManager().registerEvents(new Arena(), this);
/* 223 */     Bukkit.getServer().getPluginManager().registerEvents(new Build(), this);
/* 224 */     Bukkit.getServer().getPluginManager().registerEvents(new TPall(), this);
/* 225 */     Bukkit.getServer().getPluginManager().registerEvents(new br.nikao.comandos.ComandoInexistente(), this);
/* 226 */     Bukkit.getServer().getPluginManager().registerEvents(new Viking(), this);
/* 227 */     Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
/* 228 */     Bukkit.getServer().getPluginManager().registerEvents(new Camel(), this);
/* 229 */     Bukkit.getServer().getPluginManager().registerEvents(new Critical(), this);
/* 230 */     Bukkit.getServer().getPluginManager().registerEvents(new Deshfire(), this);
/* 231 */     Bukkit.getServer().getPluginManager().registerEvents(new Endermage(this), this);
/* 232 */     Bukkit.getServer().getPluginManager().registerEvents(new ForceField(), this);
/* 233 */     Bukkit.getServer().getPluginManager().registerEvents(new Frosty(), this);
/* 234 */     Bukkit.getServer().getPluginManager().registerEvents(new Grappler(), this);
/* 235 */     Bukkit.getServer().getPluginManager().registerEvents(new Launcher(), this);
/* 236 */     Bukkit.getServer().getPluginManager().registerEvents(new Magma(), this);
/* 237 */     Bukkit.getServer().getPluginManager().registerEvents(new Monk(), this);
/* 238 */     Bukkit.getServer().getPluginManager().registerEvents(new Poseidon(), this);
/* 239 */     Bukkit.getServer().getPluginManager().registerEvents(new Rain(), this);
/* 240 */     Bukkit.getServer().getPluginManager().registerEvents(new Reaper(), this);
/* 241 */     Bukkit.getServer().getPluginManager().registerEvents(new Resouper(), this);
/* 242 */     Bukkit.getServer().getPluginManager().registerEvents(new Ryu(), this);
/* 243 */     Bukkit.getServer().getPluginManager().registerEvents(new Specialist(), this);
/* 244 */     Bukkit.getServer().getPluginManager().registerEvents(new Spiderman(), this);
/* 245 */     Bukkit.getServer().getPluginManager().registerEvents(new Switcher(), this);
/* 246 */     Bukkit.getServer().getPluginManager().registerEvents(new Turtle(), this);
/* 247 */     Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
/* 248 */     Bukkit.getServer().getPluginManager().registerEvents(new VoidChallenge(), this);
/* 249 */     Bukkit.getServer().getPluginManager().registerEvents(new Caixas(), this);
/* 250 */     Bukkit.getServer().getPluginManager().registerEvents(new ComprarCaixa(), this);
/* 251 */     Bukkit.getServer().getPluginManager().registerEvents(new LojaDeKits(), this);
/* 252 */     Bukkit.getServer().getPluginManager().registerEvents(new Bussula(), this);
/* 253 */     Bukkit.getServer().getPluginManager().registerEvents(new ItemQuebrar(), this);
/* 254 */     Bukkit.getServer().getPluginManager().registerEvents(new me(), this);
/* 255 */     Bukkit.getServer().getPluginManager().registerEvents(new TagsAPI(), this);
/* 256 */     Bukkit.getServer().getPluginManager().registerEvents(new Urgal(), this);
/* 257 */     Bukkit.getServer().getPluginManager().registerEvents(new C4(), this);
/* 258 */     Bukkit.getServer().getPluginManager().registerEvents(new NametagEventHandler(), this);
/* 259 */     Bukkit.getServer().getPluginManager().registerEvents(new ChatFlood(), this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\Main.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */