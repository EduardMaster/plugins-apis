package GUI;

import org.bukkit.Bukkit;
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

public class Warps implements Listener, CommandExecutor {
	
	public static ItemStack vidro;
	public static ItemMeta vidrometa;
	public static ItemStack vidro1;
	public static ItemMeta vidro1meta;
	public static ItemStack fps;
	public static ItemMeta fpsmeta;
	public static ItemStack main;
	public static ItemMeta mainmeta;
	public static ItemStack lava;
	public static ItemMeta lavameta;
	public static ItemStack sumo;
	public static ItemMeta sumometa;
	public static ItemStack fish;
	public static ItemMeta fishmeta;
	public static ItemStack z1v1;
	public static ItemMeta z1v1meta;
	
	   @EventHandler
	   public void Clicar(PlayerInteractEvent e)
	   {
	     Player p = e.getPlayer();
	     if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
	       (p.getItemInHand().getType() == Material.COMPASS) &&
	       (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a§LWARPS"))) {
	       p.chat("/warps");
	     }
}
	@EventHandler
	public void Execute(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§a§LWARPS")) {
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();			
			}
			if (e.getCurrentItem().isSimilar(vidro)) {
				e.setCancelled(true);
				p.closeInventory();
			}
			if (e.getCurrentItem().isSimilar(vidro1)) {
				e.setCancelled(true);
				p.closeInventory();
			}
			if (e.getCurrentItem().isSimilar(main)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/main");
			}
			if (e.getCurrentItem().isSimilar(sumo)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/sumo");
			}
			if (e.getCurrentItem().isSimilar(lava)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/challenge");
			}
			if (e.getCurrentItem().isSimilar(fps)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fps");
			}
			if (e.getCurrentItem().isSimilar(fish)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fisherman");
			}
			if (e.getCurrentItem().isSimilar(z1v1)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/1v1");
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
		Inventory warp = Bukkit.createInventory(p, 27, "§a§LWARPS");
		
	    vidro = new ItemStack(Material.STAINED_GLASS_PANE);
	    vidrometa = vidro.getItemMeta();
	    vidrometa.setDisplayName(" ");
	    vidro.setItemMeta(vidrometa);
	    
	    vidro1 = new ItemStack(Material.STAINED_GLASS_PANE,1, (short)4);
	    vidro1meta = vidro1.getItemMeta();
	    vidro1meta.setDisplayName(" ");
	    vidro1.setItemMeta(vidro1meta);
	    
	    lava = new ItemStack(Material.LAVA_BUCKET);
	    lavameta = lava.getItemMeta();
	    lavameta.setDisplayName("§c§lLavaChallenge");
	    lava.setItemMeta(lavameta);
	    
	    fps = new ItemStack(Material.STAINED_CLAY,1, (short)4);
	    fpsmeta = fps.getItemMeta();
	    fpsmeta.setDisplayName("§c§lFPS");
	    fps.setItemMeta(fpsmeta);
	    
	    main = new ItemStack(Material.POTION);
	    mainmeta = main.getItemMeta();
	    mainmeta.setDisplayName("§c§lMain");
	    main.setItemMeta(mainmeta);
	    
	    sumo = new ItemStack(Material.STICK);
	    sumometa = sumo.getItemMeta();
	    sumometa.setDisplayName("§c§lSumo");
	    sumo.setItemMeta(sumometa);
	    
	    fish = new ItemStack(Material.FISHING_ROD);
	    fishmeta = fish.getItemMeta();
	    fishmeta.setDisplayName("§c§lFisherman");
	    fish.setItemMeta(fishmeta);
	    
	    z1v1 = new ItemStack(Material.BLAZE_ROD);
	    z1v1meta = z1v1.getItemMeta();
	    z1v1meta.setDisplayName("§c§l1v1");
	    z1v1.setItemMeta(z1v1meta);

	    for (int i =0; i != 27; i++) {
	    	  warp.setItem(0, vidro);    
              warp.setItem(1, vidro1);      
              warp.setItem(2, vidro1);
              warp.setItem(3, vidro1);
              warp.setItem(4, vidro1);
              warp.setItem(5, vidro1);
              warp.setItem(6, vidro1);
              warp.setItem(7, vidro1);
              warp.setItem(8, vidro);
              warp.setItem(9, vidro);
              warp.setItem(10, vidro1);
              warp.setItem(11, fps);
              warp.setItem(12, main);
              warp.setItem(13, fish);
              warp.setItem(14, lava);
              warp.setItem(15, sumo);
              warp.setItem(16, vidro1);
              warp.setItem(17, vidro);
              warp.setItem(18, vidro);
              warp.setItem(19, vidro1);
              warp.setItem(20, vidro1);
              warp.setItem(21, vidro1);
              warp.setItem(22, vidro1);
              warp.setItem(23, vidro1);
              warp.setItem(24, vidro1);
              warp.setItem(25, vidro1);
              warp.setItem(26, vidro);
	    }
		
	    p.openInventory(warp);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1,0F);
	    return false;
	}
 }
