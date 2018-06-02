package GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;


public class KitSelector implements Listener, CommandExecutor {
	
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static java.util.List<String> Lore(String string)
      {
        String[] split = string.split(" ");
        string = "";
        ChatColor color = ChatColor.GOLD;
            ArrayList<String> newString = new ArrayList();
        for (int i = 0; i < split.length; i++)
        {
          if ((string.length() > 20) || (string.endsWith(".")))
          {
            newString.add(color + string);
            if ((string.endsWith("."))) {
              newString.add("");
            }
            string = "";
          }
          string = string + (string.length() == 0 ? "" : " ") + split[i];
        }
        newString.add(string);
        return newString;
      }
    
	public static ItemStack vidro;
	public static ItemMeta vidrometa;
	public static ItemStack vidro1;
	public static ItemMeta vidro1meta;
	public static ItemStack bolo;
	public static ItemMeta bolometa;
	public static ItemStack loja;
	public static ItemMeta lojameta;
	public static ItemStack corante;
	public static ItemMeta corantemeta;
	public static ItemStack pvp;
	public static ItemMeta pvpmeta;
	public static ItemStack kangaroo;
	public static ItemMeta kangaroometa;
	public static ItemStack viper;
	public static ItemMeta vipermeta;
	public static ItemStack snail;
	public static ItemMeta snailmeta;
	public static ItemStack reaper;
	public static ItemMeta reapermeta;
	public static ItemStack Fisherman;
	public static ItemMeta Fishermanmeta;
	public static ItemStack stomper;
	public static ItemMeta stompermeta;
	public static ItemStack viking;
	public static ItemMeta vikingmeta;
	public static ItemStack ninja;
	public static ItemMeta ninjameta;
	public static ItemStack boxer;
	public static ItemMeta boxermeta;
	public static ItemStack deshfire;
	public static ItemMeta deshfiremeta;
	public static ItemStack deshviper;
	public static ItemMeta deshvipermeta;
	public static ItemStack ff;
	public static ItemMeta ffmeta;
	public static ItemStack hulk;
	public static ItemMeta hulkmeta;
	public static ItemStack madman;
	public static ItemMeta madmanmeta;
	public static ItemStack ryu;
	public static ItemMeta ryumeta;
	public static ItemStack seya;
	public static ItemMeta seyameta;
	public static ItemStack sonic;
	public static ItemMeta sonicmeta;
	public static ItemStack specialist;
	public static ItemMeta specialistmeta;
	public static ItemStack titan;
	public static ItemMeta titanmeta;
	public static ItemStack turtle;
	public static ItemMeta turtlemeta;
	public static ItemStack urgal;
	public static ItemMeta urgalmeta;
	public static ItemStack thor;
	public static ItemMeta thormeta;
	public static ItemStack timelord;
	public static ItemMeta timelordmeta;
	public static ItemStack phantom;
	public static ItemMeta phantommeta;
	public static ItemStack poseidon;
	public static ItemMeta poseidonmeta;
	public static ItemStack quickdropper;
	public static ItemMeta quickdroppermeta;
	public static ItemStack Camel;
	public static ItemMeta Camelmeta;
	public static ItemStack burstmaster;
	public static ItemMeta burstmastermeta;
	public static ItemStack Gladiator;
	public static ItemMeta Gladiatormeta;
	
	
	   @EventHandler
	   public void Clicar(PlayerInteractEvent e)
	   {
	     Player p = e.getPlayer();
	     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
	       (p.getItemInHand().getType() == Material.CHEST) &&
	       (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKits"))) {
	       p.chat("/kits");
	     }
    }
	   @EventHandler
	   public void Clicar1(PlayerInteractEvent e)
	   {
	     Player p = e.getPlayer();
	     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
	       (p.getItemInHand().getType() == Material.EMERALD) &&
	       (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lLoja"))) {
	       p.chat("/lojakits");
	     }
    }
	   
	   @EventHandler
	   public void Clicar2(PlayerInteractEvent e)
	   {
	     Player p = e.getPlayer();
	     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
	       (p.getItemInHand().getType() == Material.NAME_TAG) &&
	       (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lParkour"))) {
	       p.chat("/parkour");
	     }
    }
	   @EventHandler
	   public void Clicar4(PlayerInteractEvent e)
	   {
	     Player p = e.getPlayer();
	     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
	       (p.getItemInHand().getType() == Material.WOOD_SWORD) &&
	       (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lClick-Teste"))) {
	       p.chat("/ct");
	     }
    }
	@EventHandler
	public void Execute(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§c§lFly§7§lTrue §b§lSeus kits")) {
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
	}
	@EventHandler
	public void Execute5(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§c§lFly§7§lTrue §b§lSeus kits")) {
				if (e.getCurrentItem().isSimilar(bolo)) {
					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
	}
	@EventHandler
	public void Execute1(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§c§lFly§7§lTrue §b§lSeus kits")) {
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();				
			}
			if (e.getCurrentItem().isSimilar(pvp)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pvp");
			}
			if (e.getCurrentItem().isSimilar(kangaroo)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
			}
			if (e.getCurrentItem().isSimilar(viper)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
			}
			if (e.getCurrentItem().isSimilar(snail)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
			}
			if (e.getCurrentItem().isSimilar(reaper)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit reaper");
			}
			if (e.getCurrentItem().isSimilar(Fisherman)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
			}
			if (e.getCurrentItem().isSimilar(stomper)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit stomper");
			}
			if (e.getCurrentItem().isSimilar(viking)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viking");
			}
			if (e.getCurrentItem().isSimilar(ninja)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
			}
			if (e.getCurrentItem().isSimilar(boxer)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit boxer");
			}
			if (e.getCurrentItem().isSimilar(deshfire)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshfire");
			}
			if (e.getCurrentItem().isSimilar(deshviper)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshviper");
			}
			if (e.getCurrentItem().isSimilar(ff)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit forcefield");
			}
			if (e.getCurrentItem().isSimilar(hulk)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
			}
			if (e.getCurrentItem().isSimilar(madman)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit madman");
			}
			if (e.getCurrentItem().isSimilar(ryu)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ryu");
			}
			if (e.getCurrentItem().isSimilar(seya)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit seya");
			}
			if (e.getCurrentItem().isSimilar(sonic)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit sonic");
			}
			if (e.getCurrentItem().isSimilar(specialist)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit specialist");
			}
			if (e.getCurrentItem().isSimilar(titan)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit titan");
			}
			if (e.getCurrentItem().isSimilar(quickdropper)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit quickdropper");
			}
			if (e.getCurrentItem().isSimilar(turtle)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit turtle");
			}
			
			if (e.getCurrentItem().isSimilar(urgal)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit urgal");
			}
			if (e.getCurrentItem().isSimilar(corante)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kits2");
			}
			if (e.getCurrentItem().isSimilar(thor)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
			}
			if (e.getCurrentItem().isSimilar(timelord)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit timelord");
			}
			if (e.getCurrentItem().isSimilar(phantom)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
			}
			if (e.getCurrentItem().isSimilar(poseidon)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
			}
			if (e.getCurrentItem().isSimilar(phantom)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
			}
			if (e.getCurrentItem().isSimilar(Camel)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit Camel");
			}
			if (e.getCurrentItem().isSimilar(burstmaster)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit burstmaster");
			}
			if (e.getCurrentItem().isSimilar(Gladiator)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit Gladiator");
			}
			if (e.getCurrentItem().isSimilar(loja)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/lojakits");
			}
				
		}
	  }
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce precisa ser um player");
			return true;
		}
		Player p = (Player)sender;
		Inventory kit = Bukkit.createInventory(p, 54, "§c§lFly§7§lTrue §b§lSeus kits");
		
	    vidro = new ItemStack(Material.STAINED_GLASS_PANE);
	    vidrometa = vidro.getItemMeta();
	    vidrometa.setDisplayName("§c§lFly§7§lTrue");
	    vidro.setItemMeta(vidrometa);
	    
	    vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
	    vidro1meta = vidro1.getItemMeta();
	    vidro1meta.setDisplayName("§c§lFly§7§lTrue");
	    vidro1.setItemMeta(vidro1meta);
	    
	    bolo = new ItemStack(Material.CAKE);
	    bolometa = bolo.getItemMeta();
	    bolometa.setDisplayName("§a§n" + p.getName());
	    bolo.setItemMeta(bolometa);
	    
	    loja = new ItemStack(Material.EMERALD);
	    lojameta = loja.getItemMeta();
	    lojameta.setDisplayName("§a§nLoja");
	    loja.setItemMeta(lojameta);
	    
	    pvp = new ItemStack(Material.STONE_SWORD);
	    pvpmeta = pvp.getItemMeta();
	    pvpmeta.setDisplayName("§b§lPvP");
	    pvp.setItemMeta(pvpmeta);
	    
	    corante = new ItemStack(Material.WOOL);
	    corantemeta = corante.getItemMeta();
	    corantemeta.setDisplayName("§a§lSegunda aba");
	    corante.setItemMeta(corantemeta);
	    
	    kangaroo = new ItemStack(Material.FIREWORK);
	    kangaroometa = kangaroo.getItemMeta();
	    kangaroometa.setDisplayName("§b§lKangaroo");
	    kangaroometa.setLore(Lore("§f§lUse §fpara §fdar §fsaltos §fmais §faltos"));
	    kangaroo.setItemMeta(kangaroometa);
	    
	    viper = new ItemStack(Material.SPIDER_EYE);
	    vipermeta = viper.getItemMeta();
	    vipermeta.setDisplayName("§b§lViper");
	    vipermeta.setLore(Lore("§f§lUse §fpara §fenvenenar §foponentes"));
	    viper.setItemMeta(vipermeta);
	    
	    snail = new ItemStack(Material.WEB);
	    snailmeta = snail.getItemMeta();
	    snailmeta.setDisplayName("§b§lSnail");
	    snailmeta.setLore(Lore("§f§lUse §fpara §fdeixar §fseus §foponentes §flentos"));
	    snail.setItemMeta(snailmeta);

	    reaper = new ItemStack(Material.WOOD_HOE);
	    reapermeta = reaper.getItemMeta();
	    reapermeta.setDisplayName("§b§lReaper");
	    reapermeta.setLore(Lore("§f§lUse §fpara §fdeixar §fseus §foponentes §fpodres"));
	    reaper.setItemMeta(reapermeta);
	    
	    Fisherman = new ItemStack(Material.FISHING_ROD);
	    Fishermanmeta = Fisherman.getItemMeta();
	    Fishermanmeta.setDisplayName("§b§lFisherman");
	    Fishermanmeta.setLore(Lore("§f§lUse §fsua §fvarinha §fpara puxar §foponentes"));
	    Fisherman.setItemMeta(Fishermanmeta);
	    
	    stomper = new ItemStack(Material.IRON_BOOTS);
	    stompermeta = stomper.getItemMeta();
	    stompermeta.setDisplayName("§b§lStomper");
	    stompermeta.setLore(Lore("§fPule §fde §flugares §faltos §fe §fmate §foponentes"));
	    stomper.setItemMeta(stompermeta);
	    
	    viking = new ItemStack(Material.STONE_AXE);
	    vikingmeta = viking.getItemMeta();
	    vikingmeta.setDisplayName("§b§lViking");
	    vikingmeta.setLore(Lore("§fSeja §fum §fviking §fe §fcause §fmuito §fdano"));
	    viking.setItemMeta(vikingmeta);
	    
	    boxer = new ItemStack(Material.QUARTZ);
	    boxermeta = boxer.getItemMeta();
	    boxermeta.setDisplayName("§b§lBoxer");
	    boxermeta.setLore(Lore("§fSeja §fum §fum §fboxer §fe §fde mais dano"));
	    boxer.setItemMeta(boxermeta);

	    deshfire = new ItemStack(Material.REDSTONE_BLOCK);
	    deshfiremeta = deshfire.getItemMeta();
	    deshfiremeta.setDisplayName("§b§lDeshfire");
	    deshfiremeta.setLore(Lore("§fDe §fum §fdesh §fcausando §ffogo"));
	    deshfire.setItemMeta(deshfiremeta);
	    
	    deshviper = new ItemStack(Material.EMERALD_BLOCK);
	    deshvipermeta = deshviper.getItemMeta();
	    deshvipermeta.setDisplayName("§b§lDeshviper");
	    deshvipermeta.setLore(Lore("§fDe §fum §fdesh §fcausando §fPoison"));
	    deshviper.setItemMeta(deshvipermeta);
	    
	    ff = new ItemStack(Material.IRON_FENCE);
	    ffmeta = ff.getItemMeta();
	    ffmeta.setDisplayName("§b§lForcefield");
	    ffmeta.setLore(Lore("§fCrie um campo de forca"));
	    ff.setItemMeta(ffmeta);
	    
	    hulk = new ItemStack(Material.SADDLE);
	    hulkmeta = hulk.getItemMeta();
	    hulkmeta.setDisplayName("§b§lHulk");
	    hulkmeta.setLore(Lore("§fPuxe alguem para suas costas"));
	    hulk.setItemMeta(hulkmeta);
	    
	    ryu = new ItemStack(Material.DIAMOND_BLOCK);
	    ryumeta = ryu.getItemMeta();
	    ryumeta.setDisplayName("§b§lRyu");
	    ryumeta.setLore(Lore("§fSeja o Ryu e mande Hadouken"));
	    ryu.setItemMeta(ryumeta);
	    
	    seya = new ItemStack(Material.DIAMOND);
	    seyameta = seya.getItemMeta();
	    seyameta.setDisplayName("§b§lSeya");
	    seyameta.setLore(Lore("§fTenha a armadura de §fpegasus"));
	    seya.setItemMeta(seyameta);
	    
	    sonic = new ItemStack(Material.LAPIS_BLOCK);
	    sonicmeta = sonic.getItemMeta();
	    sonicmeta.setDisplayName("§b§lSonic");
	    sonicmeta.setLore(Lore("§fDe §fum §fdesh §fcausando §fefeitos"));
	    sonic.setItemMeta(sonicmeta);
	    
	    specialist = new ItemStack(Material.ENCHANTED_BOOK);
	    specialistmeta = specialist.getItemMeta();
	    specialistmeta.setDisplayName("§b§lSpecialist");
	    specialistmeta.setLore(Lore("§fTenha um altar de enchant portatil"));
	    specialist.setItemMeta(specialistmeta);
	    
	    titan = new ItemStack(Material.BEDROCK);
	    titanmeta = titan.getItemMeta();
	    titanmeta.setDisplayName("§b§lTitan");
	    titanmeta.setLore(Lore("§fSeja um titan com uma grande regeneracao"));
	    titan.setItemMeta(titanmeta);
	    
	    turtle = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    turtlemeta = turtle.getItemMeta();
	    turtlemeta.setDisplayName("§b§lTurtle");
	    turtlemeta.setLore(Lore("§fTome menos dano no shift"));
	    turtle.setItemMeta(turtlemeta);

	    specialist = new ItemStack(Material.ENCHANTED_BOOK);
	    specialistmeta = specialist.getItemMeta();
	    specialistmeta.setDisplayName("§b§lSpecialist");
	    specialistmeta.setLore(Lore("§fTenha §fum §faltar §fde §fenchant §fportatil"));
	    specialist.setItemMeta(specialistmeta);

	    titan = new ItemStack(Material.BEDROCK);
	    titanmeta = titan.getItemMeta();
	    titanmeta.setDisplayName("§b§lTitan");
	    titanmeta.setLore(Lore("§fSeja §fum §ftitan §fcom §fuma §fgrande §fregeneracao"));
	    titan.setItemMeta(titanmeta);

	    turtle = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    turtlemeta = turtle.getItemMeta();
	    turtlemeta.setDisplayName("§b§lTurtle");
	    turtlemeta.setLore(Lore("§fTome §fmenos §fdano §fno §fshift"));
	    turtle.setItemMeta(turtlemeta);

	    urgal = new ItemStack(Material.REDSTONE);
	    urgalmeta = urgal.getItemMeta();
	    urgalmeta.setDisplayName("§b§lUrgal");
	    urgalmeta.setLore(Lore("§fUse §fe §ffique §fmais §fforte"));
	    urgal.setItemMeta(urgalmeta);
	    
	    ninja = new ItemStack(Material.COAL_BLOCK);
	    ninjameta = ninja.getItemMeta();
	    ninjameta.setDisplayName("§b§lNinja");
	    ninjameta.setLore(Lore("§fSeja §fum §fum §fninja §fe §fteleporte §faos §foponentes"));
	    ninja.setItemMeta(ninjameta);
	    
	    thor = new ItemStack(Material.GOLD_AXE);
	    thormeta = thor.getItemMeta();
	    thormeta.setDisplayName("§b§lThor");
	    thormeta.setLore(Lore("§fSeja §fo §fthor §fe §flance §fraios"));
	    thor.setItemMeta(thormeta);
	    
	    timelord = new ItemStack(Material.WATCH);
	    timelordmeta = timelord.getItemMeta();
	    timelordmeta.setDisplayName("§b§lTimeLord");
	    timelordmeta.setLore(Lore("§fSCongele os oponentes"));
	    timelord.setItemMeta(timelordmeta);

	    quickdropper = new ItemStack(Material.BOWL);
	    quickdroppermeta = quickdropper.getItemMeta();
	    quickdroppermeta.setDisplayName("§b§lQuickDropper");
	    quickdroppermeta.setLore(Lore("§fDrope §fsopas §fautomaticamente"));
	    quickdropper.setItemMeta(quickdroppermeta);
	    
	    poseidon = new ItemStack(Material.WATER_BUCKET);
	    poseidonmeta = poseidon.getItemMeta();
	    poseidonmeta.setDisplayName("§b§lPoseidon");
	    poseidonmeta.setLore(Lore("§fSeja §fo §fposeidon"));
	    poseidon.setItemMeta(poseidonmeta);
	    
	    phantom = new ItemStack(Material.FEATHER);
	    phantommeta = phantom.getItemMeta();
	    phantommeta.setDisplayName("§b§lPhantom");
	    phantommeta.setLore(Lore("§fVoe §fpor §f5 §fsegundos"));
	    phantom.setItemMeta(phantommeta);
	    
	    Camel = new ItemStack(Material.SAND);
	    Camelmeta = Camel.getItemMeta();
	    Camelmeta.setDisplayName("§b§lCamel");
	    Camelmeta.setLore(Lore("§fAnde §fpela §fareia §fe §fganhe §fefeitos"));
	    Camel.setItemMeta(Camelmeta);
	    
	    burstmaster = new ItemStack(Material.STONE_HOE);
	    burstmastermeta = burstmaster.getItemMeta();
	    burstmastermeta.setDisplayName("§b§lBurstMaster");
	    burstmastermeta.setLore(Lore("§fSeja §fum §fburstmaster"));
	    burstmaster.setItemMeta(burstmastermeta);
	    
	    madman = new ItemStack(Material.POTION, 1, (short)8232);
	    madmanmeta = madman.getItemMeta();
	    madmanmeta.setDisplayName("§b§lMadman");
	    madmanmeta.setLore(Lore("§fSeja §fum §fe §fde §ffraqueza §fnos §foponentes"));
	    madman.setItemMeta(madmanmeta);
	    
	    Gladiator = new ItemStack(Material.IRON_FENCE);
	    Gladiatormeta = Gladiator.getItemMeta();
	    Gladiatormeta.setDisplayName("§b§lGladiator");
	    Gladiatormeta.setLore(Lore("§fSeja §fum §fGladiator"));
	    Gladiator.setItemMeta(Gladiatormeta);
	    
	    for (int i =0; i != 54; i++) {
	    	  kit.setItem(0, vidro1);    
              kit.setItem(1, vidro1);      
              kit.setItem(2, loja);
              kit.setItem(3, vidro1);
              kit.setItem(4, bolo);
              kit.setItem(5, vidro1);
              kit.setItem(6, loja);
              kit.setItem(7, vidro1);
              kit.setItem(8, vidro1);
              kit.setItem(9, vidro1);
              kit.setItem(10, vidro1);
              kit.setItem(11, vidro1);
              kit.setItem(12, vidro1);
              kit.setItem(13, vidro1);
              kit.setItem(14, vidro1);
              kit.setItem(15, vidro1);
              kit.setItem(16, vidro1);
              kit.setItem(17, vidro1);
              kit.setItem(18, vidro);
              kit.setItem(19, vidro);
              kit.setItem(20, vidro);
              kit.setItem(21, vidro);
              kit.setItem(22, vidro);
              kit.setItem(23, vidro);
              kit.setItem(24, vidro);
              kit.setItem(25, vidro);
              kit.setItem(26, vidro);
              kit.setItem(27, vidro);
              kit.setItem(28, vidro);
              kit.setItem(29, vidro);
              kit.setItem(30, vidro);
              kit.setItem(31, vidro);
              kit.setItem(32, vidro);
              kit.setItem(33, vidro);
              kit.setItem(34, vidro);
              kit.setItem(35, vidro);
              kit.setItem(36, vidro);
              kit.setItem(37, vidro);
              kit.setItem(38, vidro);
              kit.setItem(39, vidro);
              kit.setItem(40, vidro);
              kit.setItem(41, vidro);
              kit.setItem(42, vidro);
              kit.setItem(43, vidro);
              kit.setItem(44, vidro);
              kit.setItem(45, vidro);
              kit.setItem(46, vidro);
              kit.setItem(47, vidro);
              kit.setItem(48, vidro);
              kit.setItem(49, vidro);
              kit.setItem(50, vidro);
              kit.setItem(51, vidro);
              kit.setItem(52, vidro);
              kit.setItem(53, vidro);
	    }
	    if (p.hasPermission("kit.pvp")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(pvp);
	    }
		if (p.hasPermission("kit.kangaroo")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(kangaroo);
	    }
		if (p.hasPermission("kit.viper")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(viper);
	    }
		if (p.hasPermission("kit.snail")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(snail);
	    }
		if (p.hasPermission("kit.reaper")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(reaper);
	    }
		if (p.hasPermission("kit.fisherman")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(Fisherman);
	    }
		if (p.hasPermission("kit.stomper")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(stomper);
	    }
		if (p.hasPermission("kit.viking")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(viking);
	    }
		if (Main.getInstace().loja.getString(p.getUniqueId() + ".Ninja").equals("true") || p.hasPermission("kit.ninja")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(ninja);
	    }
		if (p.hasPermission("kit.boxer")) {
	    	kit.removeItem(vidro);
	    	kit.addItem(boxer);
	    }
		if (p.hasPermission("kit.deshfire")) {
			kit.removeItem(vidro);
			kit.addItem(deshfire);
		}
		if (p.hasPermission("kit.deshviper")) {
			kit.removeItem(vidro);
			kit.addItem(deshviper);
		}
		if (p.hasPermission("kit.forcefield")) {
			kit.removeItem(vidro);
			kit.addItem(ff);
		}
		if (p.hasPermission("kit.hulk")) {
			kit.removeItem(vidro);
			kit.addItem(hulk);
		}
		if (p.hasPermission("kit.ryu")) {
			kit.removeItem(vidro);
			kit.addItem(ryu);
		}
		if (p.hasPermission("kit.sonic")) {
			kit.removeItem(vidro);
			kit.addItem(sonic);
		}
		if (p.hasPermission("kit.specialist")) {
			kit.removeItem(vidro);
			kit.addItem(specialist);
		}
		if (p.hasPermission("kit.titan")) {
			kit.removeItem(vidro);
			kit.addItem(titan);
		}
		if (p.hasPermission("kit.turtle")) {
			kit.removeItem(vidro);
			kit.addItem(turtle);
		}
		if (Main.getInstace().loja.getString(p.getUniqueId() + ".Urgal").equals("true") ||p.hasPermission("kit.Urgal")) {
			kit.removeItem(vidro);
			kit.addItem(urgal);
		}
		if (p.hasPermission("kit.madman")) {
			kit.removeItem(vidro);
			kit.addItem(madman);
		}
		if (p.hasPermission("kit.thor")) {
			kit.removeItem(vidro);
			kit.addItem(thor);
		}
		if (p.hasPermission("kit.timelord")) {
			kit.removeItem(vidro);
			kit.addItem(timelord);
		}
		if (p.hasPermission("kit.quickdropper")) {
			kit.removeItem(vidro);
			kit.addItem(quickdropper);
		}
		if (Main.getInstace().loja.getString(p.getUniqueId() + ".Poseidon").equals("true") ||p.hasPermission("kit.Poseidon")) {
			kit.removeItem(vidro);
			kit.addItem(poseidon);
		}
		if (Main.getInstace().loja.getString(p.getUniqueId() + ".Phantom").equals("true") ||p.hasPermission("kit.phantom")) {
			kit.removeItem(vidro);
			kit.addItem(phantom);
		}
		if (p.hasPermission("kit.Camel")) {
			kit.removeItem(vidro);
			kit.addItem(Camel);
		}
		if (p.hasPermission("kit.burstmaster")) {
			kit.removeItem(vidro);
			kit.addItem(burstmaster);
		}
		if (p.hasPermission("kit.seya")) {
			kit.removeItem(vidro);
			kit.addItem(seya);
		}
		if (p.hasPermission("kit.Gladiator")) {
			kit.removeItem(vidro);
			kit.addItem(Gladiator);
		}
		
		
	    p.openInventory(kit);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1,0F);
	    return false;
	}
}