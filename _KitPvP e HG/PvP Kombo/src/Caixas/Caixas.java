package Caixas;



	import XP.XpM;
import me.rafael.vinagre.KomboPvP.Main;
import Scoreboard.ScoreDoBasic;
	import java.util.Random;
	import org.bukkit.Bukkit;
	import org.bukkit.Material;
	import org.bukkit.Sound;
	import org.bukkit.command.Command;
	import org.bukkit.command.CommandExecutor;
	import org.bukkit.command.CommandSender;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.inventory.InventoryClickEvent;
	import org.bukkit.inventory.Inventory;
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.meta.ItemMeta;

	public class Caixas
	  implements Listener, CommandExecutor
	{
	  public static ItemStack vidro;
	  public static ItemStack fly;
	  public static ItemMeta flymeta;
	  public static ItemMeta vidrometa;
	  public static ItemStack vidro2;
	  public static ItemMeta vidro2meta;
	  public static ItemStack tag;
	  public static ItemMeta tagmeta;
	  public static ItemStack resetkdr;
	  public static ItemMeta resetkdrmeta;
	  public static ItemStack todososkits;
	  public static ItemMeta todososkitsmeta;
	  public static ItemStack randomkit;
	  public static ItemMeta randomkitmeta;
	  public static ItemStack randomkit3;
	  public static ItemMeta randomkit3meta;
	  public static ItemStack randomkit2;
	  public static ItemMeta randomkit2meta;
	  
	  public Caixas() {}

	  @EventHandler
	  public void warps(InventoryClickEvent e)
	  {
	    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
	    {
	      Inventory inv = e.getInventory();
	      Player p = (Player)e.getWhoClicked();
	      if (inv.getTitle().equals("§8Caixas"))
	      {
	        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
	        e.setCancelled(true);
	        p.closeInventory();
	      }
	      if (e.getCurrentItem().isSimilar(todososkits)) {
	        if (XpM.getPlayerMoney(p) < 50000)
	        {
	          p.sendMessage( "Sem Grana Tente Novamente Mais Tarde");
	        }
	        else
	        {
	          XpM.getPlayerMoney(p);
	          
	          XpM.removeMoney(p, 50000);
	          p.sendMessage( "§7Voce Comprou §aTodos Os Kits§7 Aproveite");
	          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.*");
	          Scoreboard.ScoreDoBasic.iscoriboard(p);
	        }
	      }
	      if (e.getCurrentItem().isSimilar(fly)) {
	        if (XpM.getPlayerMoney(p) < 7000)
	        {
	          p.sendMessage( "Sem Grana Tente Novamente Mais Tarde");
	        }
	        else
	        {
	          XpM.getPlayerMoney(p);
	          
	          XpM.removeMoney(p, 7000);
	          p.sendMessage( "Comprou §aFly§7 Aproveite");
	          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.fly");
	          Scoreboard.ScoreDoBasic.iscoriboard(p);
	        }
	      }
	      if (e.getCurrentItem().isSimilar(tag)) {
	        if (XpM.getPlayerMoney(p) < 4000)
	        {
	          p.sendMessage( "Sem Grana Tente Novamente Mais Tarde");
	        }
	        else
	        {
	          XpM.getPlayerMoney(p);
	          
	          XpM.removeMoney(p, 4000);
	          p.sendMessage( "§7Voce Comprou §aTag MC§7 Aproveite");
	          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add tag.mc");
	          Scoreboard.ScoreDoBasic.iscoriboard(p);
	        }
	      }
	      if (e.getCurrentItem().isSimilar(randomkit2)) {
	        if (XpM.getPlayerMoney(p) < 5000)
	        {
	          p.sendMessage("§a§lCAIXA §f Sem Dinheiro Suficiente");
	        }
	        else
	        {
	          XpM.removeMoney(p, 5000);
	          Scoreboard.ScoreDoBasic.iscoriboard(p);
	          randomprata(p);
	        }
	      }
	      if (e.getCurrentItem().isSimilar(randomkit3)) {
	        if (XpM.getPlayerMoney(p) < 8000)
	        {
	          p.sendMessage("§a§lCAIXA §f Sem Dinheiro Suficiente");
	        }
	        else
	        {
	          XpM.removeMoney(p, 8000);
	          Scoreboard.ScoreDoBasic.iscoriboard(p);
	          randomouro(p);
	        }
	      }
	      if (e.getCurrentItem().isSimilar(randomkit)) {
	        if (XpM.getPlayerMoney(p) < 3000)
	        {
	          p.sendMessage("§a§lCAIXA §f Sem Dinheiro Suficiente");
	        }
	        else
	        {
	          XpM.removeMoney(p, 3000);
	          Scoreboard.ScoreDoBasic.iscoriboard(p);
	          randombronze(p);
	        }
	      }
	    }
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if (!(sender instanceof Player)) {
	      return true;
	    }
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("caixas"))
	    {
	      Inventory lojadeoutros = Bukkit.createInventory(p, 27, "§8Caixas");
	      
	      vidro = new ItemStack(Material.THIN_GLASS, 1, (short)14);
	      vidrometa = vidro.getItemMeta();
	      vidrometa.setDisplayName("§cCaixas");
	      vidro.setItemMeta(vidrometa);
	      
	      vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
	      vidro2meta = vidro2.getItemMeta();
	      vidro2meta.setDisplayName("§6Caixas");
	      vidro2.setItemMeta(vidro2meta);
	      
	      randomkit = new ItemStack(Material.getMaterial(336));
	      randomkitmeta = randomkit.getItemMeta();
	      randomkitmeta.setDisplayName("§6Caixa De Bronze §2Coins >> §a3000");
	      randomkit.setItemMeta(randomkitmeta);
	      
	      randomkit2 = new ItemStack(Material.IRON_INGOT);
	      randomkit2meta = randomkit2.getItemMeta();
	      randomkit2meta.setDisplayName("§7Caixa De Prata §2Coins >> §a5000");
	      randomkit2.setItemMeta(randomkit2meta);
	      
	      randomkit3 = new ItemStack(Material.GOLD_INGOT);
	      randomkit3meta = randomkit3.getItemMeta();
	      randomkit3meta.setDisplayName("§eCaixa De Ouro §2Coins >> §a8000");
	      randomkit3.setItemMeta(randomkit3meta);
	      for (int i = 0; i != 27; i++)
	      {
	        lojadeoutros.setItem(i, vidro);
	        lojadeoutros.setItem(11, randomkit);
	        lojadeoutros.setItem(13, randomkit2);
	        lojadeoutros.setItem(15, randomkit3);
	        lojadeoutros.setItem(10, vidro2);
	        lojadeoutros.setItem(12, vidro2);
	        lojadeoutros.setItem(9, vidro2);
	        lojadeoutros.setItem(14, vidro2);
	        lojadeoutros.setItem(16, vidro2);
	        lojadeoutros.setItem(17, vidro2);
	      }
	      p.openInventory(lojadeoutros);
	      return true;
	    }
	    return true;
	  }
	  
	  public void randombronze(Player p)
	  {
	    Random r = new Random();
	    int o = r.nextInt(14);
	    if (o == 0)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou De Premio o Kit Ninja");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ninja");
	    }
	    else if (o == 1)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a500§f Coins");
	      XpM.addMoney(p, 500);
	    }
	    else if (o == 2)
	    {
	      p.sendMessage("§a§lCAIXA  §fVoce Ganhou De Premio §a600§f Coins");
	      XpM.addMoney(p, 600);
	    }
	    else if (o == 3)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit  Golen");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.golen");
	    }
	    else if (o == 4)
	    {
	      p.sendMessage("§a§lCAIXA  §fVoce Ganhou De Premio Falar Colorido");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add chat.color");
	    }
	    else if (o == 5)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Thresh e §a500§f Coins");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thresh");
	      XpM.addMoney(p, 500);
	    }
	    else if (o == 6)
	    {
	      p.sendMessage("§a§lCAIXA  §fVoce Ganhou De Premio o Kit Sonic e §a100§f Coins §9(Veja o kit nas ultima pagina)");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.sonic");
	      XpM.addMoney(p, 100);
	    }
	    else if (o == 7)
	    {
	      p.sendMessage("§a§lCAIXA  §fVoce Ganhou De Premio o Kit Anchor");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.anchor");
	    }
	    else if (o == 8)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a1000§f Coins");
	      XpM.addMoney(p, 1000);
	    }
	    else if (o == 9)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a900§f Coins");
	      XpM.addMoney(p, 900);
	    }
	    else if (o == 10)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Fujao e §a800§f Coins");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fujao");
	      XpM.addMoney(p, 800);
	    }
	    else if (o == 11)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Naruto e Kit Jellyfish");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.jellyfish");
	    }
	    else if (o == 12)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Snail (veja o kit na 2 pagina)");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.snail");
	    }
	      else if (o == 13)
		    {
		      p.sendMessage("§a§lCAIXA §cVoce nao ganhou nada ;-;");
		      p.sendMessage("§c§lMais sorte na proxima vez");
		      
	      if ((o == 7) || 
	        (o == 8) || 
	        (o == 9) || 
	        (o == 10) || 
	        (o == 12)) {}
	    }
	  }
	  
	  public void randomprata(Player p)
	  {
	    Random r = new Random();
	    int o = r.nextInt(16);
	    if (o == 0)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Grappler");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.grappler");
	    }
	    else if (o == 1)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a5000§f Coins");
	      XpM.addMoney(p, 5000);
	    }
	    else if (o == 2)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a6000§f Coins");
	      XpM.addMoney(p, 6000);
	    }
	    else if (o == 3)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Gladiator");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
	    }
	    else if (o == 4)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio Falar Colorido");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add chat.color");
	    }
	    else if (o == 5)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Ebola e §a500§f Coins");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ebola");
	      XpM.addMoney(p, 500);
	    }
	    else if (o == 6)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou De Premio o Kit JellyFish e §a1000§f Coins");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.jellyfish");
	      XpM.addMoney(p, 1000);
	    }
	    else if (o == 7)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Gladiator");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
	    }
	    else if (o == 8)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio Kit DarkGod");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.darkgod");
	    }
	    else if (o == 9)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou De Premio §a900§f Coins");
	      XpM.addMoney(p, 900);
	    }
	    else if (o == 10)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Velotrol e §a800§f Coins");
	      p.sendMessage("§6§lVeja o kit na pagina 2");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.velotrol");
	      XpM.addMoney(p, 800);
	    }
	    else if (o == 11)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou Kit Sonic e Kit Deshfire");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.deshfire");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.sonic");
	    }
	    else if (o == 12)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Flash");
	      p.sendMessage("§6§lVeja o kit na pag 2");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.flash");
	      
	    }
	    else if (o == 13)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou Kit Barbarian");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.barbarian");
	    }
	    else if (o == 14)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou Kit DoubleJump + 1500 de XP");
	      p.sendMessage("§6§lVEJA O KIT NA ULTIMA PAGINA");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.doublejump");
	      XpM.addMoney(p, 1500);
	    }
	    else if (o == 15)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou Kit Gun + 500 de XP");
	      p.sendMessage("§6§lVEJA O KIT NA ULTIMA PAGINA");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gun");
	      XpM.addMoney(p, 500);
	    }
	    else if (o == 16)
	    {
	      p.sendMessage("§a§lCAIXA §f§lVoce Ganhou Kit Naruto + 800 de XP");
	     
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
	      XpM.addMoney(p, 800);
	    }
	    else if (o == 17)
	    {
	      p.sendMessage("§a§lCAIXA §f§l Voce Ganhou Kit Monk");
	    }
	    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.monk");
	    
	  
	    
	    if ((o != 7) && 
	      (o != 8) && 
	      (o != 9) && 
	      (o != 10) && 
	      (o != 11) && 
	      (o != 12) && 
	      (o != 13)) {}
	  }
	  
	  public void randomouro(Player p)
	  {
	    Random r = new Random();
	    int o = r.nextInt(17);
	    if (o == 0)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit FF");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.forcefield");
	    }
	    else if (o == 1)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a5000§f Coins");
	      XpM.addMoney(p, 5000);
	    }
	    else if (o == 2)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a6000§f Coins");
	      XpM.addMoney(p, 6000);
	    }
	    else if (o == 3)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Stomper");
	      p.sendMessage("§6§lVeja o kit na 2 pagina");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.stomper");
	    }
	    else if (o == 4)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio Falar Colorido");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add chat.color");
	    }
	    else if (o == 5)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit DJ e Infernor");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.dj");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.infernor");
	    }
	    else if (o == 6)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Avatar");
	      p.sendMessage("§6§lVeja o kit na ultima pagina");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.avatar");
	      XpM.addMoney(p, 1000);
	    }
	    else if (o == 7)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio o Kit Velotrol");
	      p.sendMessage("§6§lVeja o kit na ultima pagina");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.velotrol");
	    }
	    else if (o == 8)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio Kit Drain + 3000 de Coins");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.drain");
	      XpM.addMoney(p, 3000);
	    }
	    else if (o == 9)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou De Premio §a9000§f Coins");
	      XpM.addMoney(p, 9000);
	    }
	    else if (o == 10)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Barbarian");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.barbarian");
	    }
	    else if (o == 11)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Fireman e Reaper");
	      p.sendMessage("§6§lVeja o kit reaper na 2 pagina");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fireman");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.reaper");
	    }
	    else if (o == 12)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Timelord e Kit Bloodgun");
	      p.sendMessage("§6§lVeja os kits na 2 pagina");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.timelord");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.bloodgun");
	    }
	    else if (o == 13)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Thresh + 2000 coins");
	      p.sendMessage("§6§lVeja o kit Thresh na 2 pagina");
	      XpM.addMoney(p, 2000);
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thresh");
	    }
	    else if (o == 14)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Hulk Fireman Grappler e 1K de xp");
	      
	      XpM.addMoney(p, 1000);
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.grappler");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fireman");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.hulk");
	    }
	    else if (o == 15)
	    {
	      p.sendMessage("§a§lVoce ganhou de premio 12000 de XP");
	      
	      XpM.addMoney(p, 12000);
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.grappler");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fireman");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.hulk");
	    }
	    else if (o == 16)
	    {
	      p.sendMessage("§a§lVoce ganhou de premio o kit Gaara e Naruto + 1000 de XP");
	      
	      XpM.addMoney(p, 1000);
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gaara");
	      
	    }
	    else if (o == 17)
	    {
	      p.sendMessage("§a§lVce ganhou de premio a tag Winner!");
	      
	      
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add tag.winner");
	      
	      
	    }
	    else if (o == 18)
	    {
	      p.sendMessage("§a§lCAIXA §fVoce Ganhou Kit Thor + 1500 coins");
	      p.sendMessage("§6§lVeja o kit na 2 pagina");
	      XpM.addMoney(p, 1500);
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thor");
	      if ((o == 7) || 
	        (o == 8) || 
	        (o == 9) || 
	        (o == 10) || 
	        (o == 11) || 
	        (o == 12) || 
	        (o == 13) ||
	        (o == 14) ||
	        (o == 15) ||
	        (o == 16) ||
	        (o == 17) ||
	        (o == 18)) {}
	    }
	  }
	}

