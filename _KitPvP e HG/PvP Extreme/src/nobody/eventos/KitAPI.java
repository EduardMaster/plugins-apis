/*      */ package nobody.eventos;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;

/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.enchantments.Enchantment;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.meta.ItemMeta;
/*      */ 
/*      */ public class KitAPI
/*      */ {
/*      */   public static ItemStack sopa;
/*      */   public static ItemMeta sopameta;
/*      */   public static ItemStack cogu1;
/*      */   public static ItemMeta cogu1meta;
/*      */   public static ItemStack cogu2;
/*      */   public static ItemMeta cogu2meta;
/*      */   public static ItemStack pote;
/*      */   public static ItemMeta potemeta;
/*      */   public static ItemStack bu;
/*      */   public static ItemMeta bumeta;
/*   24 */   public static HashMap<String, String> Kit = new HashMap<String, String>();
/*   25 */   public static HashMap<String, Integer> KitDelay = new HashMap<String, Integer>();
/*   26 */   public static ArrayList<String> cooldown = new ArrayList<String>();
/*      */   
/*   28 */   public static void setKit(Player p, String kit) { Kit.put(p.getName(), kit); }
/*      */   
/*      */   public static String getkit(Player p)
/*      */   {
/*   32 */     if (Kit.containsKey(p.getName())) {
/*   33 */       return (String)Kit.get(p.getName());
/*      */     }
/*   35 */     return "Nenhum";
/*      */   }
/*      */   
/*      */   public static void RemoveKit(Player p)
/*      */   {
/*   40 */     Kit.remove(p.getName());
/*      */   }
/*      */   
/*      */   public static void DarSopa(Player p) {
/*   44 */     sopa = new ItemStack(Material.MUSHROOM_SOUP);
/*   45 */     sopameta = sopa.getItemMeta();
/*   46 */     sopameta.setDisplayName("§6Sopa");
/*   47 */     sopa.setItemMeta(sopameta);
/*      */     
/*   49 */     cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
/*   50 */     cogu1meta = cogu1.getItemMeta();
/*   51 */     cogu1meta.setDisplayName("§6Cogumelo");
/*   52 */     cogu1.setItemMeta(cogu1meta);
/*      */     
/*   54 */     cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
/*   55 */     cogu2meta = cogu2.getItemMeta();
/*   56 */     cogu2meta.setDisplayName("§eCogumelo");
/*   57 */     cogu2.setItemMeta(cogu2meta);
/*      */     
/*   59 */     pote = new ItemStack(Material.BOWL, 64);
/*   60 */     potemeta = pote.getItemMeta();
/*   61 */     potemeta.setDisplayName("§7Pote");
/*   62 */     pote.setItemMeta(potemeta);
/*      */     
/*   64 */     bu = new ItemStack(Material.COMPASS);
/*   65 */     bumeta = bu.getItemMeta();
/*   66 */     bumeta.setDisplayName("§aBussola");
/*   67 */     bu.setItemMeta(bumeta);
/*      */     
/*   69 */     for (int i = 1; i < 35; i++) {
/*   70 */       p.getInventory().addItem(new ItemStack[] { sopa });
/*   71 */       p.getInventory().setItem(15, cogu1);
/*   72 */       p.getInventory().setItem(14, cogu2);
/*   73 */       p.getInventory().setItem(13, pote);
/*   74 */       p.getInventory().setItem(8, bu);
/*      */     }
/*      */   }
/*      */   
/*      */   public static void PvP(Player p)
/*      */   {
/*   80 */     p.getInventory().clear();
/*   81 */     DarSopa(p);
/*   82 */     setKit(p, "PvP");
/*      */     
/*   84 */     ItemStack espada = new ItemStack(Material.STONE_SWORD);
/*   85 */     ItemMeta espadameta = espada.getItemMeta();
/*   86 */     espadameta.setDisplayName("§eEspada");//("§ePvP");
/*   87 */     espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*   89 */     p.getInventory().setItem(0, espada);
/*   90 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Kangaroo(Player p) {
/*   94 */     p.getInventory().clear();
/*   95 */     DarSopa(p);
/*   96 */     setKit(p, "Kangaroo");
/*      */     
/*   98 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*   99 */     ItemMeta espadameta = espada.getItemMeta();
/*  100 */     espadameta.setDisplayName("§eEspada");//("§eKangaroo");
/*  101 */     espada.setItemMeta(espadameta);
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  103 */     ItemStack kangaroo = new ItemStack(Material.FIREWORK);
/*  104 */     ItemMeta kangaroometa = kangaroo.getItemMeta();
/*  105 */     kangaroometa.setDisplayName("§eRocket Kangaroo");
/*  106 */     kangaroo.setItemMeta(kangaroometa);
/*      */     
/*  108 */     p.getInventory().setItem(0, espada);
/*  109 */     p.getInventory().setItem(1, kangaroo);
/*  110 */     p.updateInventory();
/*      */   }
/*      */   
/*  113 */   public static void Archer(Player p) { p.getInventory().clear();
/*  114 */     DarSopa(p);
/*  115 */     setKit(p, "Archer");
/*      */     
/*  117 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  118 */     ItemMeta espadameta = espada.getItemMeta();
/*  119 */     espadameta.setDisplayName("§eEspada");//("§eArcher");
/*  120 */     espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  122 */     ItemStack arco = new ItemStack(Material.BOW);
/*  123 */     ItemMeta arcometa = arco.getItemMeta();
/*  124 */     arcometa.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
/*  125 */     arcometa.addEnchant(Enchantment.KNOCKBACK, 3, true);
/*  126 */     arcometa.setDisplayName("§eArco");
/*  127 */     arco.setItemMeta(arcometa);
/*      */     
/*  129 */     ItemStack flecha = new ItemStack(Material.ARROW, 1);
/*  130 */     ItemMeta flechameta = flecha.getItemMeta();
/*  131 */     flechameta.setDisplayName("§f§lFlecha");
/*  132 */     flecha.setItemMeta(flechameta);
/*      */     
/*  134 */     p.getInventory().setItem(0, espada);
/*  135 */     p.getInventory().setItem(1, arco);
/*  136 */     p.getInventory().setItem(9, flecha);
/*      */   }
/*      */   
/*  139 */   public static void Viper(Player p) { p.getInventory().clear();
/*  140 */     DarSopa(p);
/*  141 */     setKit(p, "Viper");
/*      */     
/*  143 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  144 */     ItemMeta espadameta = espada.getItemMeta();
/*  145 */     espadameta.addEnchant(Enchantment.DURABILITY, 1, true);
/*  146 */     espadameta.setDisplayName("§eEspada");//("§eEspada!");
/*  147 */     espada.setItemMeta(espadameta);
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  149 */     p.getInventory().setItem(0, espada);
/*      */   }
/*      */   
/*      */   public static void Snail(Player p) {
/*  153 */     p.getInventory().clear();
/*  154 */     DarSopa(p);
/*  155 */     setKit(p, "Snail");
/*      */     
/*  157 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  158 */     ItemMeta espadameta = espada.getItemMeta();
/*  159 */     espadameta.setDisplayName("§eEspada");//("§eSnail");
/*  160 */     espada.setItemMeta(espadameta);
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  162 */     p.getInventory().setItem(0, espada);
/*      */   }
/*      */   
/*      */   public static void Fisherman(Player p) {
/*  166 */     p.getInventory().clear();
/*  167 */     DarSopa(p);
/*  168 */     setKit(p, "Fisherman");
/*      */     
/*  170 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  171 */     ItemMeta espadameta = espada.getItemMeta();
/*  172 */     espadameta.setDisplayName("§eEspada");//("§eFisherman");
/*  173 */     espada.setItemMeta(espadameta);
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  175 */     ItemStack vara = new ItemStack(Material.FISHING_ROD);
/*  176 */     ItemMeta varameta = vara.getItemMeta();
/*  177 */     varameta.setDisplayName("§eFisherman");
/*  178 */     vara.setItemMeta(varameta);
/*      */     
/*  180 */     p.getInventory().setItem(0, espada);
/*  181 */     p.getInventory().setItem(1, vara);
/*      */   }
/*      */   
/*      */   public static void Stomper(Player p) {
/*  185 */     p.getInventory().clear();
/*  186 */     DarSopa(p);
/*  187 */     setKit(p, "Stomper");
/*      */     
/*  189 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  190 */     ItemMeta espadameta = espada.getItemMeta();
/*  191 */     espadameta.setDisplayName("§eEspada");//("§eStomper");
/*  192 */     espada.setItemMeta(espadameta);
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  194 */     ItemStack jump = new ItemStack(Material.EMERALD_BLOCK);
/*  195 */     ItemMeta jumpmeta = jump.getItemMeta();
/*  196 */     jumpmeta.setDisplayName("§aJump");
/*  197 */     jump.setItemMeta(jumpmeta);
/*      */     
/*  199 */     p.getInventory().setItem(1, jump);
/*  200 */     p.getInventory().setItem(0, espada);
/*      */   }
/*      */   
/*      */   public static void Viking(Player p) {
/*  204 */     p.getInventory().clear();
/*  205 */     DarSopa(p);
/*  206 */     setKit(p, "Viking");
/*      */     
/*  208 */     ItemStack espada = new ItemStack(Material.STONE_AXE);
/*  209 */     ItemMeta espadameta = espada.getItemMeta();
/*  210 */     espadameta.setDisplayName("§eEspada");//("§eViking");
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  211 */     espada.setItemMeta(espadameta);
/*      */     
/*  213 */     p.getInventory().setItem(0, espada);
/*      */   }
/*      */   
/*      */   public static void Ninja(Player p) {
/*  217 */     p.getInventory().clear();
/*  218 */     DarSopa(p);
/*  219 */     setKit(p, "Ninja");
/*      */     
/*  221 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  222 */     ItemMeta espadameta = espada.getItemMeta();
/*  223 */     espadameta.setDisplayName("§eEspada");//("§eNinja");
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  224 */     espada.setItemMeta(espadameta);
/*      */     
/*  226 */     p.getInventory().setItem(0, espada);
/*  227 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Specialist(Player p)
/*      */   {
/*  232 */     p.getInventory().clear();
/*  233 */     DarSopa(p);
/*  234 */     setKit(p, "Specialist");
/*      */     
/*  236 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  237 */     ItemMeta espadameta = espada.getItemMeta();
/*  238 */     espadameta.setDisplayName("§eEspada");//("§eSpecialist");
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  239 */     espada.setItemMeta(espadameta);
/*      */     
/*  241 */     ItemStack enchant = new ItemStack(Material.BOOK);
/*  242 */     ItemMeta enchantmeta = enchant.getItemMeta();
/*  243 */     enchantmeta.setDisplayName("§eEncantar");
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  244 */     enchant.setItemMeta(enchantmeta);
/*      */     
/*  246 */     p.getInventory().setItem(0, espada);
/*  247 */     p.getInventory().setItem(1, enchant);
/*  248 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Turtle(Player p)
/*      */   {
/*  253 */     p.getInventory().clear();
/*  254 */     DarSopa(p);
/*  255 */     setKit(p, "Turtle");
/*      */     
/*  257 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  258 */     ItemMeta espadameta = espada.getItemMeta();
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  259 */     espadameta.setDisplayName("§eEspada");//("§eTurtle");
/*  260 */     espada.setItemMeta(espadameta);
/*      */     
/*  262 */     p.getInventory().setItem(0, espada);
/*  263 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Grandpa(Player p)
/*      */   {
/*  268 */     p.getInventory().clear();
/*  269 */     DarSopa(p);
/*  270 */     setKit(p, "Grandpa");
/*      */     
/*  272 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  273 */     ItemMeta espadameta = espada.getItemMeta();
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  274 */     espadameta.setDisplayName("§eEspada");//("§eGradpa");
/*  275 */     espada.setItemMeta(espadameta);
/*      */     
/*  277 */     ItemStack vara = new ItemStack(Material.STICK);
/*  278 */     ItemMeta varameta = vara.getItemMeta();
/*  279 */     varameta.addEnchant(Enchantment.KNOCKBACK, 5, true);
/*  280 */     varameta.setDisplayName("§eVoe para longe");
/*  281 */     vara.setItemMeta(varameta);
/*      */     
/*  283 */     p.getInventory().setItem(0, espada);
/*  284 */     p.getInventory().setItem(1, vara);
/*  285 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Berserker(Player p)
/*      */   {
/*  290 */     p.getInventory().clear();
/*  291 */     DarSopa(p);
/*  292 */     setKit(p, "Berserker");
/*      */     
/*  294 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  295 */     ItemMeta espadameta = espada.getItemMeta();
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  296 */     espadameta.setDisplayName("§eEspada");//("§eBerserker");
/*  297 */     espada.setItemMeta(espadameta);
/*      */     
/*  299 */     p.getInventory().setItem(0, espada);
/*  300 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Urgal(Player p)
/*      */   {
/*  305 */     p.getInventory().clear();
/*  306 */     DarSopa(p);
/*  307 */     setKit(p, "Urgal");
/*      */     
/*  309 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  310 */     ItemMeta espadameta = espada.getItemMeta();
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  311 */     espadameta.setDisplayName("§eEspada");//("§eUrgal");
/*  312 */     espada.setItemMeta(espadameta);
/*      */     
/*  314 */     ItemStack urgal = new ItemStack(Material.POTION, 2, (short)8201);
/*  315 */     ItemMeta urgalmeta = urgal.getItemMeta();
/*  316 */     urgalmeta.setDisplayName("§aPoÃ§Ã£o Magica");
/*  317 */     urgal.setItemMeta(urgalmeta);
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  319 */     p.getInventory().setItem(0, espada);
/*  320 */     p.getInventory().setItem(1, urgal);
/*  321 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Poseidon(Player p)
/*      */   {
/*  326 */     p.getInventory().clear();
/*  327 */     DarSopa(p);
/*  328 */     setKit(p, "Poseidon");
/*      */     
/*  330 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  331 */     ItemMeta espadameta = espada.getItemMeta();
/*  332 */     espadameta.setDisplayName("§eEspada");//("§ePoseidon");
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  333 */     espada.setItemMeta(espadameta);
/*      */     
/*  335 */     p.getInventory().setItem(0, espada);
/*  336 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Paladino(Player p)
/*      */   {
/*  341 */     p.getInventory().clear();
/*  342 */     DarSopa(p);
/*  343 */     setKit(p, "Paladino");
/*      */     
/*  345 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  346 */     ItemMeta espadameta = espada.getItemMeta();
/*  347 */     espadameta.setDisplayName("§eEspada");//("§ePaladino");
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  348 */     espada.setItemMeta(espadameta);
/*      */     
/*  350 */     ItemStack paladino = new ItemStack(Material.LEATHER_CHESTPLATE);
/*  351 */     ItemMeta paladinometa = paladino.getItemMeta();
/*  352 */     paladinometa.setDisplayName("§ePaladino");
/*  353 */     paladino.setItemMeta(paladinometa);
/*      */     
/*  355 */     p.getInventory().setChestplate(paladino);
/*  356 */     p.getInventory().setItem(0, espada);
/*  357 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Resouper(Player p)
/*      */   {
/*  362 */     p.getInventory().clear();
/*  363 */     DarSopa(p);
/*  364 */     setKit(p, "Resouper");
/*      */     
/*  366 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  367 */     ItemMeta espadameta = espada.getItemMeta();
/*  368 */     espadameta.setDisplayName("§eEspada");//("§eResouper");
/*  369 */     espada.setItemMeta(espadameta);
espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*      */     
/*  371 */     p.getInventory().setItem(0, espada);
/*  372 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Lavaman(Player p)
/*      */   {
/*  377 */     p.getInventory().clear();
/*  378 */     DarSopa(p);
/*  379 */     setKit(p, "Lavaman");
/*      */     
/*  381 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  382 */     ItemMeta espadameta = espada.getItemMeta();
/*  383 */     espadameta.setDisplayName("§eEspada");//("§eLavaman");
/*  384 */     espada.setItemMeta(espadameta);
/*      */     
/*  386 */     p.getInventory().setItem(0, espada);
/*  387 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Anchor(Player p)
/*      */   {
/*  392 */     p.getInventory().clear();
/*  393 */     DarSopa(p);
/*  394 */     setKit(p, "Anchor");
/*      */     
/*  396 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  397 */     ItemMeta espadameta = espada.getItemMeta();
/*  398 */     espadameta.setDisplayName("§eEspada");//("§eAnchor");
/*  399 */     espada.setItemMeta(espadameta);
/*      */     
/*  401 */     p.getInventory().setItem(0, espada);
/*  402 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Camel(Player p)
/*      */   {
/*  407 */     p.getInventory().clear();
/*  408 */     DarSopa(p);
/*  409 */     setKit(p, "Camel");
/*      */     
/*  411 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  412 */     ItemMeta espadameta = espada.getItemMeta();
/*  413 */     espadameta.setDisplayName("§eEspada");//("§eCamel");
/*  414 */     espada.setItemMeta(espadameta);
/*      */     
/*  416 */     p.getInventory().setItem(0, espada);
/*  417 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Frosty(Player p)
/*      */   {
/*  422 */     p.getInventory().clear();
/*  423 */     DarSopa(p);
/*  424 */     setKit(p, "Frosty");
/*      */     
/*  426 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  427 */     ItemMeta espadameta = espada.getItemMeta();
/*  428 */     espadameta.setDisplayName("§eEspada");//("§eFrosty");
/*  429 */     espada.setItemMeta(espadameta);
/*      */     
/*  431 */     p.getInventory().setItem(0, espada);
/*  432 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Grappler(Player p)
/*      */   {
/*  437 */     p.getInventory().clear();
/*  438 */     DarSopa(p);
/*  439 */     setKit(p, "Grappler");
/*      */     
/*  441 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  442 */     ItemMeta espadameta = espada.getItemMeta();
/*  443 */     espadameta.setDisplayName("§eEspada");//("§eGrappler");
/*  444 */     espada.setItemMeta(espadameta);
/*      */     
/*  446 */     ItemStack laço = new ItemStack(Material.LEASH);
/*  447 */     ItemMeta laçometa = laço.getItemMeta();
/*  448 */     laçometa.setDisplayName("§alaço");
/*  449 */     laço.setItemMeta(laçometa);
/*      */     
/*  451 */     p.getInventory().setItem(1, laço);
/*  452 */     p.getInventory().setItem(0, espada);
/*  453 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Hulk(Player p)
/*      */   {
/*  458 */     p.getInventory().clear();
/*  459 */     DarSopa(p);
/*  460 */     setKit(p, "Hulk");
/*      */     
/*  462 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  463 */     ItemMeta espadameta = espada.getItemMeta();
/*  464 */     espadameta.setDisplayName("§eEspada");//("§eHulk");
/*  465 */     espada.setItemMeta(espadameta);
/*      */     
/*  467 */     ItemStack laço = new ItemStack(Material.SADDLE);
/*  468 */     ItemMeta laçometa = laço.getItemMeta();
/*  469 */     laçometa.setDisplayName("§aPegar no Hulk");
/*  470 */     laço.setItemMeta(laçometa);
/*      */     
/*  472 */     p.getInventory().setItem(1, laço);
/*  473 */     p.getInventory().setItem(0, espada);
/*  474 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Switcher(Player p)
/*      */   {
/*  479 */     p.getInventory().clear();
/*  480 */     DarSopa(p);
/*  481 */     setKit(p, "Switcher");
/*      */     
/*  483 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  484 */     ItemMeta espadameta = espada.getItemMeta();
/*  485 */     espadameta.setDisplayName("§eEspada");//("§eSwitcher");
/*  486 */     espada.setItemMeta(espadameta);
/*      */     
/*  488 */     ItemStack laço = new ItemStack(Material.SNOW_BALL, 16);
/*  489 */     ItemMeta laçometa = laço.getItemMeta();
/*  490 */     laçometa.setDisplayName("§aSwitcher Ball");
/*  491 */     laço.setItemMeta(laçometa);
/*      */     
/*  493 */     p.getInventory().setItem(1, laço);
/*  494 */     p.getInventory().setItem(0, espada);
/*  495 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Launcher(Player p)
/*      */   {
/*  500 */     p.getInventory().clear();
/*  501 */     DarSopa(p);
/*  502 */     setKit(p, "Launcher");
/*      */     
/*  504 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  505 */     ItemMeta espadameta = espada.getItemMeta();
/*  506 */     espadameta.setDisplayName("§eEspada");//("§eLaucher");
/*  507 */     espada.setItemMeta(espadameta);
/*      */     
/*  509 */     ItemStack launcher = new ItemStack(Material.FISHING_ROD);
/*  510 */     ItemMeta launchermeta = launcher.getItemMeta();
/*  511 */     launchermeta.setDisplayName("§aLaucher");
/*  512 */     launcher.setItemMeta(launchermeta);
/*      */     
/*  514 */     p.getInventory().setItem(1, launcher);
/*  515 */     p.getInventory().setItem(0, espada);
/*  516 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Bomber(Player p)
/*      */   {
/*  521 */     p.getInventory().clear();
/*  522 */     DarSopa(p);
/*  523 */     setKit(p, "Bomber");
/*      */     
/*  525 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  526 */     ItemMeta espadameta = espada.getItemMeta();
/*  527 */     espadameta.setDisplayName("§eEspada");//("§eBomber");
/*  528 */     espada.setItemMeta(espadameta);
/*      */     
/*  530 */     ItemStack tnt = new ItemStack(Material.TNT);
/*  531 */     ItemMeta tntmeta = tnt.getItemMeta();
/*  532 */     tntmeta.setDisplayName("§aExplosion");
/*  533 */     tnt.setItemMeta(tntmeta);
/*      */     
/*  535 */     p.getInventory().setItem(1, tnt);
/*  536 */     p.getInventory().setItem(0, espada);
/*  537 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Endermage(Player p)
/*      */   {
/*  542 */     p.getInventory().clear();
/*  543 */     DarSopa(p);
/*  544 */     setKit(p, "Endermage");
/*      */     
/*  546 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  547 */     ItemMeta espadameta = espada.getItemMeta();
/*  548 */     espadameta.setDisplayName("§eEspada");//("§eEndermage");
/*  549 */     espada.setItemMeta(espadameta);
/*      */     
/*  551 */     ItemStack tnt = new ItemStack(Material.PORTAL);
/*  552 */     ItemMeta tntmeta = tnt.getItemMeta();
/*  553 */     tntmeta.setDisplayName("§aPuxar");
/*  554 */     tnt.setItemMeta(tntmeta);
/*      */     
/*  556 */     p.getInventory().setItem(1, tnt);
/*  557 */     p.getInventory().setItem(0, espada);
/*  558 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Fireman(Player p)
/*      */   {
/*  563 */     p.getInventory().clear();
/*  564 */     DarSopa(p);
/*  565 */     setKit(p, "Fireman");
/*      */     
/*  567 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  568 */     ItemMeta espadameta = espada.getItemMeta();
/*  569 */     espadameta.setDisplayName("§eEspada");//("§eFireman");
/*  570 */     espada.setItemMeta(espadameta);
/*      */     
/*  572 */     p.getInventory().setItem(0, espada);
/*  573 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Flash(Player p)
/*      */   {
/*  578 */     p.getInventory().clear();
/*  579 */     DarSopa(p);
/*  580 */     setKit(p, "Flash");
/*      */     
/*  582 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  583 */     ItemMeta espadameta = espada.getItemMeta();
/*  584 */     espadameta.setDisplayName("§eEspada");//("§eFlash");
/*  585 */     espada.setItemMeta(espadameta);
/*      */     
/*  587 */     ItemStack flash = new ItemStack(Material.REDSTONE_TORCH_ON);
/*  588 */     ItemMeta flashmeta = flash.getItemMeta();
/*  589 */     flashmeta.setDisplayName("§aVamos correr");
/*  590 */     flash.setItemMeta(flashmeta);
/*      */     
/*  592 */     p.getInventory().setItem(1, flash);
/*  593 */     p.getInventory().setItem(0, espada);
/*  594 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Milkman(Player p)
/*      */   {
/*  599 */     p.getInventory().clear();
/*  600 */     DarSopa(p);
/*  601 */     setKit(p, "Milkman");
/*      */     
/*  603 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  604 */     ItemMeta espadameta = espada.getItemMeta();
/*  605 */     espadameta.setDisplayName("§eEspada");//("§eMilkman");
/*  606 */     espada.setItemMeta(espadameta);
/*      */     
/*  608 */     ItemStack flash = new ItemStack(Material.MILK_BUCKET);
/*  609 */     ItemMeta flashmeta = flash.getItemMeta();
/*  610 */     flashmeta.setDisplayName("§aAquele Leitin");
/*  611 */     flash.setItemMeta(flashmeta);
/*      */     
/*  613 */     p.getInventory().setItem(1, flash);
/*  614 */     p.getInventory().setItem(0, espada);
/*  615 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Reaper(Player p)
/*      */   {
/*  620 */     p.getInventory().clear();
/*  621 */     DarSopa(p);
/*  622 */     setKit(p, "Reaper");
/*      */     
/*  624 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  625 */     ItemMeta espadameta = espada.getItemMeta();
/*  626 */     espadameta.setDisplayName("§eEspada");//("§eReaper");
/*  627 */     espada.setItemMeta(espadameta);
/*      */     
/*  629 */     ItemStack flash = new ItemStack(Material.WOOD_HOE);
/*  630 */     ItemMeta flashmeta = flash.getItemMeta();
/*  631 */     flashmeta.setDisplayName("§aFoiÃ§e");
/*  632 */     flash.setItemMeta(flashmeta);
/*      */     
/*  634 */     p.getInventory().setItem(1, flash);
/*  635 */     p.getInventory().setItem(0, espada);
/*  636 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Ryu(Player p)
/*      */   {
/*  641 */     p.getInventory().clear();
/*  642 */     DarSopa(p);
/*  643 */     setKit(p, "Ryu");
/*      */     
/*  645 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  646 */     ItemMeta espadameta = espada.getItemMeta();
/*  647 */     espadameta.setDisplayName("§eEspada");//("§eRyu");
/*  648 */     espada.setItemMeta(espadameta);
/*      */     
/*  650 */     ItemStack flash = new ItemStack(Material.BEACON);
/*  651 */     ItemMeta flashmeta = flash.getItemMeta();
/*  652 */     flashmeta.setDisplayName("§aHadouken");
/*  653 */     flash.setItemMeta(flashmeta);
/*      */     
/*  655 */     p.getInventory().setItem(1, flash);
/*  656 */     p.getInventory().setItem(0, espada);
/*  657 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void JellyFish(Player p)
/*      */   {
/*  662 */     p.getInventory().clear();
/*  663 */     DarSopa(p);
/*  664 */     setKit(p, "JellyFish");
/*      */     
/*  666 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  667 */     ItemMeta espadameta = espada.getItemMeta();
/*  668 */     espadameta.setDisplayName("§eEspada");//("§eJellyfish");
/*  669 */     espada.setItemMeta(espadameta);
/*      */     
/*  671 */     ItemStack flash = new ItemStack(Material.STATIONARY_WATER);
/*  672 */     ItemMeta flashmeta = flash.getItemMeta();
/*  673 */     flashmeta.setDisplayName("§aVeneno");
/*  674 */     flash.setItemMeta(flashmeta);
/*      */     
/*  676 */     p.getInventory().setItem(1, flash);
/*  677 */     p.getInventory().setItem(0, espada);
/*  678 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void C4(Player p)
/*      */   {
/*  683 */     p.getInventory().clear();
/*  684 */     DarSopa(p);
/*  685 */     setKit(p, "C4");
/*      */     
/*  687 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  688 */     ItemMeta espadameta = espada.getItemMeta();
/*  689 */     espadameta.setDisplayName("§eEspada");//("§eC4");
/*  690 */     espada.setItemMeta(espadameta);
/*      */     
/*  692 */     ItemStack flash = new ItemStack(Material.SLIME_BALL);
/*  693 */     ItemMeta flashmeta = flash.getItemMeta();
/*  694 */     flashmeta.setDisplayName("§aC4");
/*  695 */     flash.setItemMeta(flashmeta);
/*      */     
/*  697 */     p.getInventory().setItem(1, flash);
/*  698 */     p.getInventory().setItem(0, espada);
/*  699 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Magma(Player p) {
/*  703 */     p.getInventory().clear();
/*  704 */     DarSopa(p);
/*  705 */     setKit(p, "Magma");
/*      */     
/*  707 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  708 */     ItemMeta espadameta = espada.getItemMeta();
/*  709 */     espadameta.setDisplayName("§eEspada");//("§eMagma");
/*  710 */     espada.setItemMeta(espadameta);
/*      */     
/*  712 */     p.getInventory().setItem(0, espada);
/*  713 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Spiderman(Player p)
/*      */   {
/*  718 */     p.getInventory().clear();
/*  719 */     DarSopa(p);
/*  720 */     setKit(p, "Spiderman");
/*      */     
/*  722 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  723 */     ItemMeta espadameta = espada.getItemMeta();
/*  724 */     espadameta.setDisplayName("§eEspada");//("§eSpiderman");
/*  725 */     espada.setItemMeta(espadameta);
/*      */     
/*  727 */     ItemStack spider = new ItemStack(Material.STRING);
/*  728 */     ItemMeta spidermeta = spider.getItemMeta();
/*  729 */     spidermeta.setDisplayName("§aTeia");
/*  730 */     spider.setItemMeta(spidermeta);
/*      */     
/*  732 */     p.getInventory().setItem(1, spider);
/*  733 */     p.getInventory().setItem(0, espada);
/*  734 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Deshfire(Player p)
/*      */   {
/*  739 */     p.getInventory().clear();
/*  740 */     DarSopa(p);
/*  741 */     setKit(p, "Deshfire");
/*      */     
/*  743 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  744 */     ItemMeta espadameta = espada.getItemMeta();
/*  745 */     espadameta.setDisplayName("§eEspada");//("§eDeshfire");
/*  746 */     espada.setItemMeta(espadameta);
/*      */     
/*  748 */     ItemStack spider = new ItemStack(Material.REDSTONE_BLOCK);
/*  749 */     ItemMeta spidermeta = spider.getItemMeta();
/*  750 */     spidermeta.setDisplayName("§eDeshfire");
/*  751 */     spider.setItemMeta(spidermeta);
/*      */     
/*  753 */     p.getInventory().setItem(1, spider);
/*  754 */     p.getInventory().setItem(0, espada);
/*  755 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Sonic(Player p)
/*      */   {
/*  760 */     p.getInventory().clear();
/*  761 */     DarSopa(p);
/*  762 */     setKit(p, "Sonic");
/*      */     
/*  764 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  765 */     ItemMeta espadameta = espada.getItemMeta();
/*  766 */     espadameta.setDisplayName("§eEspada");//("§eSonic");
/*  767 */     espada.setItemMeta(espadameta);
/*      */     
/*  769 */     ItemStack spider = new ItemStack(Material.LAPIS_BLOCK);
/*  770 */     ItemMeta spidermeta = spider.getItemMeta();
/*  771 */     spidermeta.setDisplayName("§eSonic");
/*  772 */     spider.setItemMeta(spidermeta);
/*      */     
/*  774 */     p.getInventory().setItem(1, spider);
/*  775 */     p.getInventory().setItem(0, espada);
/*  776 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Critical(Player p)
/*      */   {
/*  781 */     p.getInventory().clear();
/*  782 */     DarSopa(p);
/*  783 */     setKit(p, "Critical");
/*      */     
/*  785 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  786 */     ItemMeta espadameta = espada.getItemMeta();
/*  787 */     espadameta.setDisplayName("§eEspada");//("§eCritical");
/*  788 */     espada.setItemMeta(espadameta);
/*      */     
/*  790 */     p.getInventory().setItem(0, espada);
/*  791 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Thor(Player p)
/*      */   {
/*  796 */     p.getInventory().clear();
/*  797 */     DarSopa(p);
/*  798 */     setKit(p, "Thor");
/*      */     
/*  800 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  801 */     ItemMeta espadameta = espada.getItemMeta();
/*  802 */     espadameta.setDisplayName("§eEspada");//("§eThor");
/*  803 */     espada.setItemMeta(espadameta);
/*      */     
/*  805 */     ItemStack infernor = new ItemStack(Material.STONE_AXE);
/*  806 */     ItemMeta infernormeta = infernor.getItemMeta();
/*  807 */     infernormeta.setDisplayName("§aCabumm...");
/*  808 */     infernor.setItemMeta(infernormeta);
/*      */     
/*  810 */     p.getInventory().setItem(1, infernor);
/*  811 */     p.getInventory().setItem(0, espada);
/*  812 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Boxer(Player p)
/*      */   {
/*  817 */     p.getInventory().clear();
/*  818 */     DarSopa(p);
/*  819 */     setKit(p, "Boxer");
/*      */     
/*  821 */     ItemStack espada = new ItemStack(Material.STONE_SWORD);
/*  822 */     ItemMeta espadameta = espada.getItemMeta();
/*  823 */     espadameta.setDisplayName("§eEspada");//("§eBoxer");
/*  824 */     espada.setItemMeta(espadameta);
/*      */     
/*  826 */     p.getInventory().setItem(0, espada);
/*  827 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Ebola(Player p)
/*      */   {
/*  832 */     p.getInventory().clear();
/*  833 */     DarSopa(p);
/*  834 */     setKit(p, "Ebola");
/*      */     
/*  836 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  837 */     ItemMeta espadameta = espada.getItemMeta();
/*  838 */     espadameta.setDisplayName("§eEspada");//("§eEbola");
/*  839 */     espada.setItemMeta(espadameta);
/*      */     
/*  841 */     p.getInventory().setItem(0, espada);
/*  842 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void ForceField(Player p)
/*      */   {
/*  847 */     p.getInventory().clear();
/*  848 */     DarSopa(p);
/*  849 */     setKit(p, "ForceField");
/*      */     
/*  851 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  852 */     ItemMeta espadameta = espada.getItemMeta();
/*  853 */     espadameta.setDisplayName("§eEspada");//("§eForceField");
/*  854 */     espada.setItemMeta(espadameta);
/*      */     
/*  856 */     ItemStack ff = new ItemStack(Material.NETHER_FENCE);
/*  857 */     ItemMeta ffmeta = ff.getItemMeta();
/*  858 */     ffmeta.setDisplayName("§aAtivar FF");
/*  859 */     ff.setItemMeta(ffmeta);
/*      */     
/*  861 */     p.getInventory().setItem(1, ff);
/*  862 */     p.getInventory().setItem(0, espada);
/*  863 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Timelord(Player p)
/*      */   {
/*  868 */     p.getInventory().clear();
/*  869 */     DarSopa(p);
/*  870 */     setKit(p, "Timelord");
/*      */     
/*  872 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  873 */     ItemMeta espadameta = espada.getItemMeta();
/*  874 */     espadameta.setDisplayName("§eEspada");//("§eTimelord");
/*  875 */     espada.setItemMeta(espadameta);
/*      */     
/*  877 */     ItemStack ff = new ItemStack(Material.WATCH);
/*  878 */     ItemMeta ffmeta = ff.getItemMeta();
/*  879 */     ffmeta.setDisplayName("§bFrozen");
/*  880 */     ff.setItemMeta(ffmeta);
/*      */     
/*  882 */     p.getInventory().setItem(1, ff);
/*  883 */     p.getInventory().setItem(0, espada);
/*  884 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Barbarian(Player p)
/*      */   {
/*  889 */     p.getInventory().clear();
/*  890 */     DarSopa(p);
/*  891 */     setKit(p, "Barbarian");
/*      */     
/*  893 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  894 */     ItemMeta espadameta = espada.getItemMeta();
/*  895 */     espadameta.setDisplayName("§eEspada");//("§eBarbarian");
/*  896 */     espada.setItemMeta(espadameta);
/*      */     
/*  898 */     p.getInventory().setItem(0, espada);
/*  899 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Backpacker(Player p)
/*      */   {
/*  904 */     p.getInventory().clear();
/*  905 */     DarSopa(p);
/*  906 */     setKit(p, "Backpacker");
/*      */     
/*  908 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  909 */     ItemMeta espadameta = espada.getItemMeta();
/*  910 */     espadameta.setDisplayName("§eEspada");//("§eBackerpacker");
/*  911 */     espada.setItemMeta(espadameta);
/*      */     
/*  913 */     ItemStack apple = new ItemStack(Material.CHEST);
/*  914 */     ItemMeta applemeta = apple.getItemMeta();
/*  915 */     applemeta.setDisplayName("§aSopas");
/*  916 */     apple.setItemMeta(applemeta);
/*      */     
/*  918 */     p.getInventory().setItem(1, apple);
/*  919 */     p.getInventory().setItem(0, espada);
/*  920 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Phantom(Player p)
/*      */   {
/*  925 */     p.getInventory().clear();
/*  926 */     DarSopa(p);
/*  927 */     setKit(p, "Phantom");
/*      */     
/*  929 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  930 */     ItemMeta espadameta = espada.getItemMeta();
/*  931 */     espadameta.setDisplayName("§eEspada");//("§ePhantom");
/*  932 */     espada.setItemMeta(espadameta);
/*      */     
/*  934 */     ItemStack apple = new ItemStack(Material.FEATHER);
/*  935 */     ItemMeta applemeta = apple.getItemMeta();
/*  936 */     applemeta.setDisplayName("§aVoa galinha");
/*  937 */     apple.setItemMeta(applemeta);
/*      */     
/*  939 */     p.getInventory().setItem(1, apple);
/*  940 */     p.getInventory().setItem(0, espada);
/*  941 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Avatar(Player p)
/*      */   {
/*  946 */     p.getInventory().clear();
/*  947 */     DarSopa(p);
/*  948 */     setKit(p, "Avatar");
/*      */     
/*  950 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  951 */     ItemMeta espadameta = espada.getItemMeta();
/*  952 */     espadameta.setDisplayName("§eEspada");//("§eAvatar");
/*  953 */     espada.setItemMeta(espadameta);
/*      */     
/*  955 */     ItemStack apple = new ItemStack(Material.WOOL);
/*  956 */     ItemMeta applemeta = apple.getItemMeta();
/*  957 */     applemeta.setDisplayName("§aAvatar");
/*  958 */     apple.setItemMeta(applemeta);
/*      */     
/*  960 */     p.getInventory().setItem(1, apple);
/*  961 */     p.getInventory().setItem(0, espada);
/*  962 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Rain(Player p) {
/*  966 */     p.getInventory().clear();
/*  967 */     DarSopa(p);
/*  968 */     setKit(p, "Rain");
/*      */     
/*  970 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  971 */     ItemMeta espadameta = espada.getItemMeta();
/*  972 */     espadameta.setDisplayName("§eEspada");//("§eRain");
/*  973 */     espada.setItemMeta(espadameta);
/*      */     
/*  975 */     ItemStack flecha = new ItemStack(Material.ARROW, 1);
/*  976 */     ItemMeta flechameta = flecha.getItemMeta();
/*  977 */     flechameta.setDisplayName("§f§lFlecha");
/*  978 */     flecha.setItemMeta(flechameta);
/*      */     
/*  980 */     p.getInventory().setItem(0, espada);
/*  981 */     p.getInventory().setItem(1, flecha);
/*  982 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void QuickDropper(Player p)
/*      */   {
/*  987 */     p.getInventory().clear();
/*  988 */     DarSopa(p);
/*  989 */     setKit(p, "QuickDropper");
/*      */     
/*  991 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/*  992 */     ItemMeta espadameta = espada.getItemMeta();
/*  993 */     espadameta.setDisplayName("§eEspada");//("§eQuickDropper");
/*  994 */     espada.setItemMeta(espadameta);
/*      */     
/*  996 */     p.getInventory().setItem(0, espada);
/*  997 */     p.updateInventory();
/*      */   }
/*      */   
/*      */   public static void Monk(Player p)
/*      */   {
/* 1002 */     p.getInventory().clear();
/* 1003 */     DarSopa(p);
/* 1004 */     setKit(p, "Monk");
/*      */     
/* 1006 */     ItemStack espada = new ItemStack(Material.WOOD_SWORD);
/* 1007 */     ItemMeta espadameta = espada.getItemMeta();
/* 1008 */     espadameta.setDisplayName("§eEspada");//("§eMonk");
/* 1009 */     espada.setItemMeta(espadameta);
/*      */     
/* 1011 */     ItemStack monk = new ItemStack(Material.BLAZE_ROD);
/* 1012 */     ItemMeta monkmeta = monk.getItemMeta();
/* 1013 */     monkmeta.setDisplayName("§eMonk");
/* 1014 */     monk.setItemMeta(monkmeta);
/*      */     
/* 1016 */     p.getInventory().setItem(1, monk);
/* 1017 */     p.getInventory().setItem(0, espada);
/* 1018 */     p.updateInventory();
/*      */   }
/*      */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\MasterKits.jar!\Utils\KitAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */