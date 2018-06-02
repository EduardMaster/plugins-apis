/*     */ package neero.demon.comandos;
/*     */ 
/*     */ import neero.demon.utils.ItemManager;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.material.MaterialData;
/*     */ 
/*     */ public class Kit implements org.bukkit.event.Listener, CommandExecutor
/*     */ {
/*  19 */   private static ItemManager im = new ItemManager();
/*     */   
/*     */ 
/*     */   public static void setupGUI(Player p)
/*     */   {
/*  24 */     Inventory inv = Bukkit.createInventory(p, 54, "            §6§lKits disponiveis");
/*     */     
/*     */ 
/*     */ 
/*  28 */     ItemStack vidro = im.createItem(Material.STAINED_GLASS_PANE, "vidro", "-", new String[0], 1, (short)0);
/*  29 */     ItemStack vermelho = im.createItem(Material.THIN_GLASS, "vidro", "-", new String[0], 1, (short)14);
/*  30 */     ItemStack verde = im.createItem(Material.THIN_GLASS, "vidro", "-", new String[0], 1, (short)5);
/*  31 */     ItemStack fogo = im.createItem(Material.getMaterial(351), "vidro", "§6Kits Primarios", new String[0], 1, (short)10);
/*  32 */     ItemStack kit2 = im.createItem(Material.getMaterial(351), "vidro", "§b§lKit2", new String[] { "§b§lAbra os Kits Secundários" }, 1, (short)8);
/*  32 */     ItemStack loja = im.createItem(Material.getMaterial(351), "vidro", "§b§lLoja", new String[] { "§b§lAbra a Loja" }, 1, (short)8);
/*     */ 
/*  36 */     ItemStack pvp = im.createItem(Material.getMaterial(272), "vidro", "§b§lPvP", new String[] { "§7Sem habilidade" }, 1, (short)0);
/*  37 */     ItemStack fisherman = im.createItem(Material.getMaterial(346), "vidro", "§b§lFisherman", new String[] { "§7Puxe seus inimigos para voce", "§7 usando a vara de pesca" }, 1, (short)0);
/*  38 */     ItemStack kangaroo = im.createItem(Material.getMaterial(401), "vidro", "§b§lKangaroo", new String[] { "§7Pule usando o Firework" }, 1, (short)0);
/*  39 */     ItemStack neo = im.createItem(Material.getMaterial(311), "vidro", "§b§lNeo", new String[] { "§7NÃƒ£o seja atingido por projeteis" }, 1, (short)0);
/*  40 */     ItemStack souper = im.createItem(Material.getMaterial(282), "vidro", "§b§lSouper", new String[] { "§7Mate um player e ganhe sopas" }, 1, (short)0);
/*  41 */     ItemStack reaper = im.createItem(Material.getMaterial(290), "vidro", "§b§lReaper", new String[] { "§7Bata com sua enchada e de efeitos em seus inimigos" }, 1, (short)0);
/*  45 */     ItemStack vulture = im.createItem(Material.getMaterial(281), "vidro", "§b§lVulture", new String[] { "§7Roube sopas do seus inimigos" }, 1, (short)0);
/*  46 */     ItemStack escapist = im.createItem(Material.getMaterial(401), "vidro", "§b§lEscapist", new String[] { "§7Escape para ganhar vantagens em seus inimigos" }, 1, (short)0);
/*  47 */     ItemStack archer = im.createItem(Material.getMaterial(261), "vidro", "§b§lArcher", new String[] { "§7Atire flexas em seus inimigos" }, 1, (short)0);
/*  48 */     ItemStack boxer = im.createItem(Material.getMaterial(267), "vidro", "§b§lBoxer", new String[] { "§7De mais dano batendo com a mao" }, 1, (short)0);
/*  49 */     ItemStack berserker = im.createItem(Material.getMaterial(351), "vidro", "§b§lBerserker", new String[] { "§7Mate alguem e fique furioso" }, 1, (short)1);
/*  50 */     ItemStack urgal = im.createItem(Material.getMaterial(373), "vidro", "§b§lUrgal", new String[] { "§7Ganhei poÃƒ§oes de forÃƒ§b§l" }, 1, (short)8265);
/*  51 */     ItemStack skyrunner = im.createItem(Material.getMaterial(264), "vidro", "§b§lSkyrunner", new String[] { "§7Segure o diamante e suba ate as alturas" }, 1, (short)0);
/*  52 */     ItemStack pesadelo = im.createItem(Material.getMaterial(173), "vidro", "§b§lPesadelo", new String[] { "§7Cause pesadelos em seu inimigo" }, 1, (short)0);
/*  53 */     ItemStack salvager = im.createItem(Material.getMaterial(345), "vidro", "§b§lSalvager", new String[] { "§7Salve itens aleatorios" }, 1, (short)0);
/*  54 */     ItemStack assassin = im.createItem(Material.getMaterial(331), "vidro", "§b§lAssassin", new String[] { "§7Fique forte ao clickar na redstone" }, 1, (short)0);
/*  55 */     ItemStack anchor = im.createItem(Material.getMaterial(145), "vidro", "§b§lAnchor", new String[] { "§7NÃƒ£o leve knockback" }, 1, (short)0);
/*  56 */     ItemStack snail = im.createItem(Material.getMaterial(30), "vidro", "§b§lSnail", new String[] { "§7Deixe seus inimigos com lentidao" }, 1, (short)0);
/*  57 */     ItemStack tocha = im.createItem(Material.getMaterial(377), "vidro", "§b§lTocha", new String[] { "§7Clique no item,", "§7e trapaceie seu adversario" }, 1, (short)0);
/*  58 */     ItemStack timelord = im.createItem(Material.getMaterial(347), "vidro", "§b§lTimelord", new String[] { "§7Click no relogio e pare o tempo para seus inimigos" }, 1, (short)0);
/*  59 */     ItemStack thor = im.createItem(Material.getMaterial(271), "vidro", "§b§lThor", new String[] { "§7Solte raios com seu machado" }, 1, (short)0);
/*  60 */     ItemStack achilles = im.createItem(Material.getMaterial(268), "vidro", "§b§lAchilles", new String[] { "§7Tome menos dano" }, 1, (short)0);
/*  61 */     ItemStack specialist = im.createItem(Material.getMaterial(384), "vidro", "§b§lSpecialist", new String[] { "§7Ganhe XP ao matar alguem" }, 1, (short)0);
/*  62 */     ItemStack turtle = im.createItem(Material.getMaterial(307), "vidro", "§b§lTurtle", new String[] { "§7Tome menos dano no shift" }, 1, (short)0);
/*  63 */     ItemStack vampire = im.createItem(Material.getMaterial(373), "vidro", "§b§lVampire", new String[] { "§730% de chanÃƒ§e ,", "§7de ficar forte no pvp" }, 1, (short)8229);
/*  64 */     ItemStack viking = im.createItem(Material.getMaterial(258), "vidro", "§b§lViking", new String[] { "§7De mais dano usando o chamado" }, 1, (short)0);
/*  65 */     ItemStack hulk = im.createItem(Material.getMaterial(329), "vidro", "§b§lHulk", new String[] { "§7Segure seus inimigos nas costas" }, 1, (short)0);
/*  66 */     ItemStack launcher = im.createItem(Material.getMaterial(19), "vidro", "§b§lLauncher", new String[] { "§7Lance seus inimigos com as suas esponjas" }, 1, (short)0);
/*  67 */     ItemStack gladiator = im.createItem(Material.getMaterial(101), "vidro", "§b§lGladiator", new String[] { "§7Chame seus inimigos para 1v1" }, 1, (short)0);
/*  68 */     ItemStack Phantom = im.createItem(Material.getMaterial(288), "vidro", "§b§lPhantom", new String[] { "§7Clique na pena e saia voando" }, 1, (short)0);
/*  69 */     ItemStack pikachu = im.createItem(Material.getMaterial(381), "vidro", "§b§lPikachu", new String[] { "§7Clique no olho e solte um raio destrutivo" }, 1, (short)0);
/*  70 */     ItemStack demoman = im.createItem(Material.getMaterial(13), "vidro", "§b§lDemoman", new String[] { "§7Exploda tudo em sua volta" }, 1, (short)0);
/*  71 */     ItemStack stomper = im.createItem(Material.getMaterial(309), "vidro", "§b§lStomper", new String[] { "§7Mate seus amigos pulando em cima deles." }, 1, (short)0);
/*  72 */     ItemStack tank = im.createItem(Material.getMaterial(46), "vidro", "§b§lTank", new String[] { "§7Exploda seus inimigos" }, 1, (short)0);
/*  73 */     ItemStack poseidon = im.createItem(Material.getMaterial(326), "vidro", "§b§lPoseidon", new String[] { "§7Fique forte na agua" }, 1, (short)0);
/*  74 */     ItemStack ebola = im.createItem(Material.getMaterial(376), "vidro", "§b§lEbola", new String[] { "§7Transmita a doença ebola" }, 1, (short)0);
/*  75 */     ItemStack grappler = im.createItem(Material.getMaterial(420), "vidro", "§b§lEscalador", new String[] { "§7Solte sua picareta magica" }, 1, (short)0);
/*  76 */     ItemStack gambler = im.createItem(Material.getMaterial(77), "vidro", "§b§lGambler", new String[] { "§7Ganha poções aleatorias ,", "§71% de chance de ficar full couro" }, 1, (short)0);
/*  77 */     ItemStack viper = im.createItem(Material.getMaterial(375), "vidro", "§b§lViper", new String[] { "§7De veneno para seus inimigos" }, 1, (short)0);
/*  78 */     ItemStack challenger = im.createItem(Material.getMaterial(20), "vidro", "§b§lChallenger", new String[] { "§7Desafie seu inimigo para uma arena magica" }, 1, (short)0);
/*  79 */     ItemStack barbarian = im.createItem(Material.getMaterial(268), "vidro", "§b§lBarbarian", new String[] { "§7Solte poderes aleatorios" }, 1, (short)57);
/*  80 */     ItemStack monk = im.createItem(Material.getMaterial(369), "vidro", "§b§lMonk", new String[] { "§7Confunda o inventario de seu inimigo" }, 1, (short)0);
/*  81 */     ItemStack burst = im.createItem(Material.GOLD_HOE, "vidro", "§b§lBurstMaster", new String[] { "§7Exploda os inimigos com sua enxada." }, 1, (short)1);
/*  82 */     ItemStack Sniper = im.createItem(Material.ARROW, "vidro", "§b§lSniper", new String[] { "§7Dê um tiro no inimigo" }, 1, (short)0);
/*  83 */     ItemStack sumo = im.createItem(Material.getMaterial(260), "vidro", "§b§lSumo", new String[] { "§7Pese muito e jogue seus inimigos pro alto" }, 1, (short)0);
/*     */     
/*  85 */     inv.setItem(0, vermelho);
/*  86 */     inv.setItem(1, vidro);
/*  87 */     inv.setItem(2, loja);
/*  88 */     inv.setItem(3, vidro);
/*  89 */     inv.setItem(4, fogo);
/*  90 */     inv.setItem(5, vidro);
/*  91 */     inv.setItem(6, kit2);
/*  92 */     inv.setItem(7, vidro);
/*  93 */     inv.setItem(8, verde);
/*  94 */     inv.setItem(9, pvp);
/*     */     
/*     */ 
/*     */ 
/*  98 */     if (p.hasPermission("kit.sumo")) {
/*  99 */       inv.addItem(new ItemStack[] { sumo });
/*     */     }
/*  98 */     if (p.hasPermission("kit.burstmaster")) {
/*  99 */       inv.addItem(new ItemStack[] { burst });
/*     */     }
/*     */     
/* 102 */     if (p.hasPermission("kit.Sniper")) {
/* 103 */       inv.addItem(new ItemStack[] { Sniper });
/*     */     }
/*     */     
/* 106 */     if (p.hasPermission("kit.vulture")) {
/* 107 */       inv.addItem(new ItemStack[] { vulture });
/*     */     }
/*     */     
/* 110 */     if (p.hasPermission("kit.escapist")) {
/* 111 */       inv.addItem(new ItemStack[] { escapist });
/*     */     }
/*     */     
/* 114 */     if (p.hasPermission("kit.archer")) {
/* 115 */       inv.addItem(new ItemStack[] { archer });
/*     */     }
/*     */     
/* 118 */     if (p.hasPermission("kit.boxer")) {
/* 119 */       inv.addItem(new ItemStack[] { boxer });
/*     */     }
/*     */     
/* 122 */     if (p.hasPermission("kit.berserker")) {
/* 123 */       inv.addItem(new ItemStack[] { berserker });
/*     */     }
/*     */     
/* 126 */     if (p.hasPermission("kit.urgal")) {
/* 127 */       inv.addItem(new ItemStack[] { urgal });
/*     */     }
/*     */     
/* 130 */     if (p.hasPermission("kit.skyrunner")) {
/* 131 */       inv.addItem(new ItemStack[] { skyrunner });
/*     */     }
/*     */     
/* 134 */     if (p.hasPermission("kit.pesadelo")) {
/* 135 */       inv.addItem(new ItemStack[] { pesadelo });
/*     */     }
/*     */     
/* 138 */     if (p.hasPermission("kit.salvager")) {
/* 139 */       inv.addItem(new ItemStack[] { salvager });
/*     */     }
/*     */     
/* 142 */     if (p.hasPermission("kit.assassin")) {
/* 143 */       inv.addItem(new ItemStack[] { assassin });
/*     */     }
/*     */     
/* 146 */     if (p.hasPermission("kit.anchor")) {
/* 147 */       inv.addItem(new ItemStack[] { anchor });
/*     */     }
/*     */     
/* 150 */     if (p.hasPermission("kit.snail")) {
/* 151 */       inv.addItem(new ItemStack[] { snail });
/*     */     }
/*     */     
/* 154 */     if (p.hasPermission("kit.tocha")) {
/* 155 */       inv.addItem(new ItemStack[] { tocha });
/*     */     }
/*     */     
/* 158 */     if (p.hasPermission("kit.timelord")) {
/* 159 */       inv.addItem(new ItemStack[] { timelord });
/*     */     }
/*     */     
/* 162 */     if (p.hasPermission("kit.thor")) {
/* 163 */       inv.addItem(new ItemStack[] { thor });
/*     */     }
/*     */     
/* 166 */     if (p.hasPermission("kit.achilles")) {
/* 167 */       inv.addItem(new ItemStack[] { achilles });
/*     */     }
/*     */     
/* 170 */     if (p.hasPermission("kit.specialist")) {
/* 171 */       inv.addItem(new ItemStack[] { specialist });
/*     */     }
/*     */     
/* 174 */     if (p.hasPermission("kit.turtle")) {
/* 175 */       inv.addItem(new ItemStack[] { turtle });
/*     */     }
/*     */     
/* 178 */     if (p.hasPermission("kit.vampire")) {
/* 179 */       inv.addItem(new ItemStack[] { vampire });
/*     */     }
/*     */     
/* 182 */     if (p.hasPermission("kit.viking")) {
/* 183 */       inv.addItem(new ItemStack[] { viking });
/*     */     }
/*     */     
/* 186 */     if (p.hasPermission("kit.hulk")) {
/* 187 */       inv.addItem(new ItemStack[] { hulk });
/*     */     }
/*     */     
/* 190 */     if (p.hasPermission("kit.launcher")) {
/* 191 */       inv.addItem(new ItemStack[] { launcher });
/*     */     }
/*     */     
/* 194 */     if (p.hasPermission("kit.gladiator")) {
/* 195 */       inv.addItem(new ItemStack[] { gladiator });
/*     */     }
/*     */     
/* 198 */     if (p.hasPermission("kit.phantom")) {
/* 199 */       inv.addItem(new ItemStack[] { Phantom });
/*     */     }
/*     */     
/* 202 */     if (p.hasPermission("kit.pikachu")) {
/* 203 */       inv.addItem(new ItemStack[] { pikachu });
/*     */     }
/*     */     
/* 206 */     if (p.hasPermission("kit.demoman")) {
/* 207 */       inv.addItem(new ItemStack[] { demoman });
/*     */     }
/*     */     
/* 210 */     if (p.hasPermission("kit.stomper")) {
/* 211 */       inv.addItem(new ItemStack[] { stomper });
/*     */     }
/*     */     
/* 214 */     if (p.hasPermission("kit.tank")) {
/* 215 */       inv.addItem(new ItemStack[] { tank });
/*     */     }
/*     */     
/* 218 */     if (p.hasPermission("kit.poseidon")) {
/* 219 */       inv.addItem(new ItemStack[] { poseidon });
/*     */     }
/*     */     
/* 222 */     if (p.hasPermission("kit.ebola")) {
/* 223 */       inv.addItem(new ItemStack[] { ebola });
/*     */     }
/*     */     
/* 226 */     if (p.hasPermission("kit.grappler")) {
/* 227 */       inv.addItem(new ItemStack[] { grappler });
/*     */     }
/*     */     
/* 230 */     if (p.hasPermission("kit.gambler")) {
/* 231 */       inv.addItem(new ItemStack[] { gambler });
/*     */     }
/*     */     
/* 234 */     if (p.hasPermission("kit.viper")) {
/* 235 */       inv.addItem(new ItemStack[] { viper });
/*     */     }
/*     */     
/* 238 */     if (p.hasPermission("kit.challenger")) {
/* 239 */       inv.addItem(new ItemStack[] { challenger });
/*     */     }
/*     */     
/* 242 */     if (p.hasPermission("kit.barbarian")) {
/* 243 */       inv.addItem(new ItemStack[] { barbarian });
/*     */     }
/*     */     
/* 246 */     if (p.hasPermission("kit.monk")) {
/* 247 */       inv.addItem(new ItemStack[] { monk });
/*     */     }
/*     */ 
/* 256 */     if (p.hasPermission("kit.fisherman")) {
/* 257 */       inv.addItem(new ItemStack[] { fisherman });
/*     */     }
/*     */     
/* 260 */     if (p.hasPermission("kit.kangaroo")) {
/* 261 */       inv.addItem(new ItemStack[] { kangaroo });
/*     */     }
/*     */     
/* 264 */     if (p.hasPermission("kit.neo")) {
/* 265 */       inv.addItem(new ItemStack[] { neo });
/*     */     }
/*     */     
/* 268 */     if (p.hasPermission("kit.souper")) {
/* 269 */       inv.addItem(new ItemStack[] { souper });
/*     */     }
/*     */     
/* 272 */     if (p.hasPermission("kit.reaper")) {
/* 273 */       inv.addItem(new ItemStack[] { reaper });
/*     */     }
/*     */     
/* 276 */     for (int i = 0; i < inv.getSize(); i++) {
/* 277 */       if (inv.getItem(i) == null) {
/* 278 */         inv.setItem(i, vidro);
/*     */       }
/*     */     }
/* 281 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */   public static void setupGUI2(Player p)
/*     */   {
/* 286 */     Inventory inv = Bukkit.createInventory(p, 54, "               §c§lOutros kits");
/*     */     
/* 288 */     ItemStack vidro = im.createItem(Material.getMaterial(102), "vidro", "-", new String[0], 1, (short)0);
/* 289 */     ItemStack vermelho = im.createItem(Material.getMaterial(171), "vidro", "§4§lSem informcoes", new String[0], 1, (short)14);
/* 290 */     ItemStack verde = im.createItem(Material.getMaterial(171), "vidro", "§4§lPagina", new String[0], 1, (short)5);
/* 291 */     ItemStack fogo = im.createItem(Material.getMaterial(51), "vidro", "§6§oJapaaPvP", new String[0], 1, (short)0);
/* 292 */     ItemStack baudofim = im.createItem(Material.getMaterial(130), "vidro", "§6§lDicas de Kits", new String[] { "§b§lKit Kangaroo!;-;" }, 1, (short)0);
/*     */     
/*     */ 
/*     */ 
/* 296 */     ItemStack pvp = im.createItem(Material.getMaterial(272), "vidro", "§b§lPvP", new String[] { "§7Sem habilidade" }, 1, (short)0);
/* 297 */     ItemStack fisherman = im.createItem(Material.getMaterial(346), "vidro", "§b§lFisherman", new String[] { "§7Puxe seus inimigos para voce", "§7 usando a vara de pesca" }, 1, (short)0);
/* 298 */     ItemStack kangaroo = im.createItem(Material.getMaterial(401), "vidro", "§b§lKangaroo", new String[] { "§7Pule usando o Firework" }, 1, (short)0);
/* 299 */     ItemStack neo = im.createItem(Material.getMaterial(311), "vidro", "§b§lNeo", new String[] { "§7Nao seja atingido por projeteis" }, 1, (short)0);
/* 300 */     ItemStack souper = im.createItem(Material.getMaterial(282), "vidro", "§b§lSouper", new String[] { "§7Mate um player e ganhe sopas" }, 1, (short)0);
/* 301 */     ItemStack reaper = im.createItem(Material.getMaterial(290), "vidro", "§b§lReaper", new String[] { "§7Bata com sua enchada e de efeitos em seus inimigos" }, 1, (short)0);
/*     */     
/*     */ 
/*     */ 
/* 305 */     ItemStack vulture = im.createItem(Material.getMaterial(281), "vidro", "§b§lVulture", new String[] { "§7Roube sopas do seus inimigos" }, 1, (short)0);
/* 306 */     ItemStack escapist = im.createItem(Material.getMaterial(401), "vidro", "§b§lEscapist", new String[] { "§7Escape para ganhar vantagens em seus inimigos" }, 1, (short)0);
/* 307 */     ItemStack archer = im.createItem(Material.getMaterial(261), "vidro", "§b§lArcher", new String[] { "§7Atire flexas em seus inimigos" }, 1, (short)0);
/* 308 */     ItemStack boxer = im.createItem(Material.getMaterial(267), "vidro", "§b§lBoxer", new String[] { "§7De mais dano batendo com a mao" }, 1, (short)0);
/* 309 */     ItemStack berserker = im.createItem(Material.getMaterial(351), "vidro", "§b§lBerserker", new String[] { "§7Mate alguem e fique furioso" }, 1, (short)1);
/* 310 */     ItemStack urgal = im.createItem(Material.getMaterial(373), "vidro", "§b§lUrgal", new String[] { "§7Ganhei pocoes de forca" }, 1, (short)8265);
/* 311 */     ItemStack skyrunner = im.createItem(Material.getMaterial(264), "vidro", "§b§lSkyrunner", new String[] { "§7Segure o diamante e suba ate as alturas" }, 1, (short)0);
/* 312 */     ItemStack pesadelo = im.createItem(Material.getMaterial(173), "vidro", "§b§lPesadelo", new String[] { "§7Cause pesadelos em seu inimigo" }, 1, (short)0);
/* 313 */     ItemStack salvager = im.createItem(Material.getMaterial(345), "vidro", "§b§lSalvager", new String[] { "§7Salve itens aleatorios" }, 1, (short)0);
/* 314 */     ItemStack assassin = im.createItem(Material.getMaterial(331), "vidro", "§b§lAssassin", new String[] { "§7Fique forte ao clickar na redstone" }, 1, (short)0);
/* 315 */     ItemStack anchor = im.createItem(Material.getMaterial(145), "vidro", "§b§lAnchor", new String[] { "§7Nao leve knockback" }, 1, (short)0);
/* 316 */     ItemStack snail = im.createItem(Material.getMaterial(30), "vidro", "§b§lSnail", new String[] { "§7Deixe seus inimigos com lentidao" }, 1, (short)0);
/* 317 */     ItemStack tocha = im.createItem(Material.getMaterial(377), "vidro", "§b§lTocha", new String[] { "§7Clique no item,", "§7e trapaceie seu adversario" }, 1, (short)0);
/* 318 */     ItemStack timelord = im.createItem(Material.getMaterial(347), "vidro", "§b§lTimelord", new String[] { "§7Click no relogio e pare o tempo para seus inimigos" }, 1, (short)0);
/* 319 */     ItemStack thor = im.createItem(Material.getMaterial(271), "vidro", "§b§lThor", new String[] { "§7Solte raios com seu machado" }, 1, (short)0);
/* 320 */     ItemStack achilles = im.createItem(Material.getMaterial(268), "vidro", "§b§lAchilles", new String[] { "§7Tome menos dano" }, 1, (short)0);
/* 321 */     ItemStack specialist = im.createItem(Material.getMaterial(384), "vidro", "§b§lSpecialist", new String[] { "§7Ganhe XP ao matar alguem" }, 1, (short)0);
/* 322 */     ItemStack turtle = im.createItem(Material.getMaterial(307), "vidro", "§b§lTurtle", new String[] { "§7Tome menos dano no shift" }, 1, (short)0);
/* 323 */     ItemStack vampire = im.createItem(Material.getMaterial(373), "vidro", "§b§lVampire", new String[] { "§730% de chance ,", "§7de ficar forte no pvp" }, 1, (short)8229);
/* 324 */     ItemStack viking = im.createItem(Material.getMaterial(258), "vidro", "§b§lViking", new String[] { "§7De mais dano usando o machado" }, 1, (short)0);
/* 325 */     ItemStack hulk = im.createItem(Material.getMaterial(329), "vidro", "§b§lHulk", new String[] { "§7Segure seus inimigos nas costas" }, 1, (short)0);
/* 326 */     ItemStack launcher = im.createItem(Material.getMaterial(19), "vidro", "§b§llauncher", new String[] { "§7Lance seus inimigos com as suas esponjas" }, 1, (short)0);
/* 327 */     ItemStack gladiator = im.createItem(Material.getMaterial(101), "vidro", "§b§lGladiator", new String[] { "§7Chame seus inimigos para 1v1" }, 1, (short)0);
/* 328 */     ItemStack Sniperantom = im.createItem(Material.getMaterial(288), "vidro", "§b§lSniperantom", new String[] { "§7Click na pena e saia voando" }, 1, (short)0);
/* 329 */     ItemStack pikachu = im.createItem(Material.getMaterial(381), "vidro", "§b§lPikachu", new String[] { "§7Clique no olho e solte um raio destrutivo" }, 1, (short)0);
/* 330 */     ItemStack demoman = im.createItem(Material.getMaterial(13), "vidro", "§b§lDemoman", new String[] { "§7Exploda tudo em sua volta" }, 1, (short)0);
/* 331 */     ItemStack stomper = im.createItem(Material.getMaterial(309), "vidro", "§b§lStomper", new String[] { "§7Mate seus amigos pulando em cima deles." }, 1, (short)0);
/* 332 */     ItemStack tank = im.createItem(Material.getMaterial(46), "vidro", "§b§lTank", new String[] { "§7Exploda seus inimigos" }, 1, (short)0);
/* 333 */     ItemStack poseidon = im.createItem(Material.getMaterial(326), "vidro", "§b§lPoseidon", new String[] { "§7Fique forte na agua" }, 1, (short)0);
/* 334 */     ItemStack ebola = im.createItem(Material.getMaterial(376), "vidro", "§b§lEbola", new String[] { "§7Transmita a doenÃƒ§b§l ebola" }, 1, (short)0);
/* 335 */     ItemStack grappler = im.createItem(Material.getMaterial(420), "vidro", "§b§lEscalador", new String[] { "§7Solte sua picareta magica" }, 1, (short)0);
/* 336 */     ItemStack gambler = im.createItem(Material.getMaterial(77), "vidro", "§b§lGambler", new String[] { "§7Ganha poÃƒ§oes aleatorias ,", "§71% de chance de ficar full couro" }, 1, (short)0);
/* 337 */     ItemStack viper = im.createItem(Material.getMaterial(375), "vidro", "§b§lViper", new String[] { "§7De veneno para seus inimigos" }, 1, (short)0);
/* 338 */     ItemStack challenger = im.createItem(Material.getMaterial(20), "vidro", "§b§lChallenger", new String[] { "§7Desafie seu inimigo para uma arena magica" }, 1, (short)0);
/* 339 */     ItemStack barbarian = im.createItem(Material.getMaterial(268), "vidro", "§b§lBarbarian", new String[] { "§7Solte poderes aleatorios" }, 1, (short)57);
/* 340 */     ItemStack monk = im.createItem(Material.getMaterial(369), "vidro", "§b§lMonk", new String[] { "§7Confunda o inventario de seu inimigo" }, 1, (short)0);
/* 341 */     ItemStack Batman = im.createItem(Material.BLAZE_ROD, "vidro", "§b§lBatman", new String[] { "§7Levite seu inimigo com morcegos" }, 1, (short)1);
/* 342 */     ItemStack Sniper = im.createItem(Material.getMaterial(154), "vidro", "§b§lSniper", new String[] { "§7Spawne tornados pelo mapa" }, 1, (short)0);
/* 343 */     ItemStack sumo = im.createItem(Material.getMaterial(260), "vidro", "§b§lSumo", new String[] { "§7Pese muito e jogue seus inimigos pro alto" }, 1, (short)0);
/*     */     
/* 345 */     inv.setItem(0, vermelho);
/* 346 */     inv.setItem(1, vidro);
/* 347 */     inv.setItem(2, baudofim);
/* 348 */     inv.setItem(3, vidro);
/* 349 */     inv.setItem(4, fogo);
/* 350 */     inv.setItem(5, vidro);
/* 351 */     inv.setItem(6, baudofim);
/* 352 */     inv.setItem(7, vidro);
/* 353 */     inv.setItem(8, verde);
/*     */     
/* 355 */     if (!p.hasPermission("kit.sumo")) {
/* 356 */       inv.addItem(new ItemStack[] { sumo });
/*     */     }
/*     */     
/* 359 */     if (!p.hasPermission("kit.Sniper")) {
/* 360 */       inv.addItem(new ItemStack[] { Sniper });
/*     */     }
/*     */     
/* 363 */     if (!p.hasPermission("kit.vulture")) {
/* 364 */       inv.addItem(new ItemStack[] { vulture });
/*     */     }
/*     */     
/* 367 */     if (!p.hasPermission("kit.escapist")) {
/* 368 */       inv.addItem(new ItemStack[] { escapist });
/*     */     }
/*     */     
/* 371 */     if (!p.hasPermission("kit.archer")) {
/* 372 */       inv.addItem(new ItemStack[] { archer });
/*     */     }
/*     */     
/* 375 */     if (!p.hasPermission("kit.boxer")) {
/* 376 */       inv.addItem(new ItemStack[] { boxer });
/*     */     }
/*     */     
/* 379 */     if (!p.hasPermission("kit.berserker")) {
/* 380 */       inv.addItem(new ItemStack[] { berserker });
/*     */     }
/*     */     
/* 383 */     if (!p.hasPermission("kit.urgal")) {
/* 384 */       inv.addItem(new ItemStack[] { urgal });
/*     */     }
/*     */     
/* 387 */     if (!p.hasPermission("kit.skyrunner")) {
/* 388 */       inv.addItem(new ItemStack[] { skyrunner });
/*     */     }
/*     */     
/* 391 */     if (!p.hasPermission("kit.pesadelo")) {
/* 392 */       inv.addItem(new ItemStack[] { pesadelo });
/*     */     }
/*     */     
/* 395 */     if (!p.hasPermission("kit.salvager")) {
/* 396 */       inv.addItem(new ItemStack[] { salvager });
/*     */     }
/*     */     
/* 399 */     if (!p.hasPermission("kit.assassin")) {
/* 400 */       inv.addItem(new ItemStack[] { assassin });
/*     */     }
/*     */     
/* 403 */     if (!p.hasPermission("kit.anchor")) {
/* 404 */       inv.addItem(new ItemStack[] { anchor });
/*     */     }
/*     */     
/* 407 */     if (!p.hasPermission("kit.snail")) {
/* 408 */       inv.addItem(new ItemStack[] { snail });
/*     */     }
/*     */     
/* 411 */     if (!p.hasPermission("kit.tocha")) {
/* 412 */       inv.addItem(new ItemStack[] { tocha });
/*     */     }
/* 414 */     if (!p.hasPermission("kit.timelord")) {
/* 415 */       inv.addItem(new ItemStack[] { timelord });
/*     */     }
/*     */     
/* 418 */     if (!p.hasPermission("kit.thor")) {
/* 419 */       inv.addItem(new ItemStack[] { thor });
/*     */     }
/*     */     
/* 422 */     if (!p.hasPermission("kit.achilles")) {
/* 423 */       inv.addItem(new ItemStack[] { achilles });
/*     */     }
/*     */     
/* 426 */     if (!p.hasPermission("kit.specialist")) {
/* 427 */       inv.addItem(new ItemStack[] { specialist });
/*     */     }
/*     */     
/* 430 */     if (!p.hasPermission("kit.turtle")) {
/* 431 */       inv.addItem(new ItemStack[] { turtle });
/*     */     }
/*     */     
/* 434 */     if (!p.hasPermission("kit.vampire")) {
/* 435 */       inv.addItem(new ItemStack[] { vampire });
/*     */     }
/*     */     
/* 438 */     if (!p.hasPermission("kit.viking")) {
/* 439 */       inv.addItem(new ItemStack[] { viking });
/*     */     }
/*     */     
/* 442 */     if (!p.hasPermission("kit.hulk")) {
/* 443 */       inv.addItem(new ItemStack[] { hulk });
/*     */     }
/*     */     
/* 446 */     if (!p.hasPermission("kit.launcher")) {
/* 447 */       inv.addItem(new ItemStack[] { launcher });
/*     */     }
/*     */     
/* 450 */     if (!p.hasPermission("kit.gladiator")) {
/* 451 */       inv.addItem(new ItemStack[] { gladiator });
/*     */     }
/*     */     

	
/* 458 */     if (!p.hasPermission("kit.pikachu")) {
/* 459 */       inv.addItem(new ItemStack[] { pikachu });
/*     */     }
/*     */     
/* 462 */     if (!p.hasPermission("kit.demoman")) {
/* 463 */       inv.addItem(new ItemStack[] { demoman });
/*     */     }
/*     */     
/* 466 */     if (!p.hasPermission("kit.stomper")) {
/* 467 */       inv.addItem(new ItemStack[] { stomper });
/*     */     }
/*     */     
/* 470 */     if (!p.hasPermission("kit.tank")) {
/* 471 */       inv.addItem(new ItemStack[] { tank });
/*     */     }
/*     */     
/* 474 */     if (!p.hasPermission("kit.poseidon")) {
/* 475 */       inv.addItem(new ItemStack[] { poseidon });
/*     */     }
/*     */     
/* 478 */     if (!p.hasPermission("kit.ebola")) {
/* 479 */       inv.addItem(new ItemStack[] { ebola });
/*     */     }
/*     */     
/* 482 */     if (!p.hasPermission("kit.grappler")) {
/* 483 */       inv.addItem(new ItemStack[] { grappler });
/*     */     }
/*     */     
/* 486 */     if (!p.hasPermission("kit.gambler")) {
/* 487 */       inv.addItem(new ItemStack[] { gambler });
/*     */     }
/*     */     
/* 490 */     if (!p.hasPermission("kit.viper")) {
/* 491 */       inv.addItem(new ItemStack[] { viper });
/*     */     }
/*     */     
/* 494 */     if (!p.hasPermission("kit.challenger")) {
/* 495 */       inv.addItem(new ItemStack[] { challenger });
/*     */     }
/*     */     
/* 498 */     if (!p.hasPermission("kit.barbarian")) {
/* 499 */       inv.addItem(new ItemStack[] { barbarian });
/*     */     }
/*     */     
/* 502 */     if (!p.hasPermission("kit.monk")) {
/* 503 */       inv.addItem(new ItemStack[] { monk });
/*     */     }
/*     */     
/* 506 */     if (!p.hasPermission("kit.Batman")) {
/* 507 */       inv.addItem(new ItemStack[] { Batman });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 512 */     if (!p.hasPermission("kit.fisherman")) {
/* 513 */       inv.addItem(new ItemStack[] { fisherman });
/*     */     }
/*     */     
/* 516 */     if (!p.hasPermission("kit.kangaroo")) {
/* 517 */       inv.addItem(new ItemStack[] { kangaroo });
/*     */     }
/*     */     
/* 520 */     if (!p.hasPermission("kit.neo")) {
/* 521 */       inv.addItem(new ItemStack[] { neo });
/*     */     }
/*     */     
/* 524 */     if (!p.hasPermission("kit.souper")) {
/* 525 */       inv.addItem(new ItemStack[] { souper });
/*     */     }
/*     */     
/* 528 */     if (!p.hasPermission("kit.reaper")) {
/* 529 */       inv.addItem(new ItemStack[] { reaper });
/*     */     }
/*     */     
/* 532 */     for (int i = 0; i < inv.getSize(); i++) {
/* 533 */       if (inv.getItem(i) == null) {
/* 534 */         inv.setItem(i, vidro);
/*     */       }
/*     */     }
/* 537 */     p.openInventory(inv);
/*     */   }
/*     */   
/*     */ 
/*     */   @org.bukkit.event.EventHandler
/*     */   public void click(InventoryClickEvent event)
/*     */   {
/* 544 */     Player p = (Player)event.getWhoClicked();
/* 545 */     if (p.getOpenInventory().getTitle().equalsIgnoreCase("            §6§lKits disponiveis")) {
/* 546 */       if (event.getCurrentItem() == null) {
/* 547 */         return;
/*     */       }
/* 549 */       if (event.getCurrentItem() == null) {
/* 550 */         event.setCancelled(true);
/*     */       }
/* 552 */       if ((event.getCurrentItem().getType().equals(Material.CARPET)) && 
/* 553 */         (event.getCurrentItem().getTypeId() == 171) && (event.getCurrentItem().getData().getData() == 5)) {
/* 554 */         setupGUI2(p);
/* 555 */         event.setCancelled(true);
/* 556 */         return;
/*     */       }
/*     */       

/* 559 */       if ((event.getCurrentItem().getTypeId() == 102) || (event.getCurrentItem().getTypeId() == 106) || (event.getCurrentItem().getTypeId() == 51)) {
/* 560 */         event.setCancelled(true);
/* 561 */         p.closeInventory();
/* 562 */         return;
/*     */       }
/* 564 */       p.chat("/" + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
/* 565 */       event.setCancelled(true);
/* 566 */       p.closeInventory();

/*     */     }
/* 568 */     if (event.getInventory().getName().equalsIgnoreCase("               §c§lOutros kits")) {
/* 569 */       if ((event.getCurrentItem().getTypeId() == 171) && (event.getCurrentItem().getData().getData() == 14)) {
/* 570 */         setupGUI(p);
/* 571 */         event.setCancelled(true);
/* 572 */         return;
/*     */       }
/* 574 */       if ((event.getCurrentItem().getTypeId() == 102) || (event.getCurrentItem().getTypeId() == 106) || (event.getCurrentItem().getTypeId() == 51)) {
/* 575 */         event.setCancelled(true);
/* 576 */         p.closeInventory();
/* 577 */         return;
/*     */       }
/* 579 */       p.chat("/" + ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
/* 580 */       event.setCancelled(true);
/* 581 */       p.closeInventory();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
/* 586 */     if ((commandLabel.equalsIgnoreCase("kit")) || (commandLabel.equalsIgnoreCase("kits"))) {
/* 587 */       Player p = (Player)sender;
/*     */       
/* 589 */       setupGUI(p);
/*     */     }
/*     */     
/*     */ 
/* 593 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Kit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */