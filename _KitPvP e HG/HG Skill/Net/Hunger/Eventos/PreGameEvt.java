package Net.Hunger.Eventos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class PreGameEvt implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
	if(Main.PreGame) {
	e.setCancelled(true);
	}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
	if(Main.PreGame) {
	e.setCancelled(true);
	}
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
	if(Main.PreGame) {
	e.setCancelled(true);
	}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
	if(Main.PreGame) {
	e.setCancelled(true);
	}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
	if(Main.PreGame) {
	e.setCancelled(true);
	}
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
	if(Main.PreGame) {
	e.setCancelled(true);
	}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
	Player p = e.getPlayer();
	if(Main.PreGame) {
	Main.Jogadores.remove(p.getName());
	}
	}
	
	@EventHandler
	public void DamageMobs(EntityDamageEvent e) {
	if(!(e.getEntity() instanceof LivingEntity)) {
	return;
	}
	if(Main.PreGame) {
	e.setCancelled(true);
	return;
	}
	}

	@EventHandler
	public void DamagePlayers(EntityDamageByEntityEvent e) {
	if(!(e.getEntity() instanceof Player)) {
	return;
	}
	if(!(e.getDamager() instanceof Player)) {
	return;
	}
	if(Main.PreGame) {
	e.setCancelled(true);
	return;
	}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
    if(!(e.getEntity() instanceof Player)) {
    return;
    }
    if(Main.PreGame) {
    e.setCancelled(true);
    return;
    }
	}
	
	@EventHandler
	public void onWin(EntityDamageEvent e) {
	if(!(e.getEntity() instanceof Player)) {
	return;
	}
	if(Main.Finalizando) {
	e.setCancelled(true);
	return;
	}
	}

	@EventHandler
	public void onSlime(PlayerInteractEvent e) {
	Player p = e.getPlayer();
	if((Main.PreGame) && (p.getInventory().getItemInHand().getType() == Material.SLIME_BALL)) {
    p.sendMessage("§7[§a?§7] Você foi teleportado para um lugar §aAleatorio!");
    Random random = new Random();           
	Location teleportLocation = null;	            
	int x = random.nextInt(400) + 1;
	int y = 150;
	int z = random.nextInt(400) + 1;            
	boolean isOnLand = false;            
	while (isOnLand == false) {
	teleportLocation = new Location(p.getWorld(), x, y, z);	                    
	if (teleportLocation.getBlock().getType() != Material.AIR) {
	isOnLand = true;
	} else y--;    
	}
	p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));	
	}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
	final Player p = e.getPlayer();
	e.setJoinMessage(null);
	if(Main.PreGame) {
    p.getInventory().clear();
	Main.Jogadores.add(p.getName());

	Habilidade.removeAbility(p);
	Habilidade.setAbility(p, "Nenhum");

	ItemStack kits = new ItemStack(Material.CHEST);
	ItemMeta rkits = kits.getItemMeta();
	rkits.setDisplayName("§7[§a!§7] §aLista de kits! §7[§a!§7]");
	kits.setItemMeta(rkits);
	
	ItemStack buycraft = new ItemStack(Material.EMERALD);
	ItemMeta rbuycraft = buycraft.getItemMeta();
	rbuycraft.setDisplayName("§7[§a!§7] §aLoja Buycraft! §7[§a!§7]");
	buycraft.setItemMeta(rbuycraft);
	
	ItemStack kangaroo = new ItemStack(Material.FIREWORK);
	ItemMeta rkangaroo = kangaroo.getItemMeta();
	rkangaroo.setDisplayName("§7[§a!§7] §aKangaroo PreGame! §7[§a!§7]");
	kangaroo.setItemMeta(rkangaroo);
	
	ItemStack random  = new ItemStack(Material.SLIME_BALL);
	ItemMeta rrandom = random.getItemMeta();
	rrandom.setDisplayName("§7[§a!§7] §aTeleporte PreGame! §7[§a!§7]");
	random.setItemMeta(rrandom);
	
    ItemStack bookItem = new ItemStack(Material.WRITTEN_BOOK, 1);
    BookMeta metaData = (BookMeta)bookItem.getItemMeta();
    metaData.setTitle("§7[§a!§7] §aLivro de ajuda! §7[§a!§7]");
    metaData.setAuthor("§cGarotoGamer_");
    metaData.addPage(new String[] { "§1§l       SkillHG" });
    metaData.addPage(new String[] { "§1§oComo jogar :\n\n§0O HardCore Games e um\n§0modo de jogo onde o\n§0ultimo sobrevivente é o\n§0vencedor" });
    metaData.addPage(new String[] { "§1§oSopas :\n\n§0Sopas possuem um\nefeito especial dentro\ndo jogo\njogo\nAo clicar nelas voce\nbebe instantaneamente\ne regeneram 3,5\ncoracoes\najudando assim na\nduracao do pvp" });
    bookItem.setItemMeta(metaData);

    p.getInventory().setItem(0, kangaroo);
    p.getInventory().setItem(3, kits);
    p.getInventory().setItem(4, buycraft);
    p.getInventory().setItem(5, bookItem);
    p.getInventory().setItem(8, random);
    
    int x = new Random().nextInt(5) + 30;
	int y = new Random().nextInt(5) + 90;
	int z = new Random().nextInt(5) + 30;
	Location loc = new Location(p.getWorld(), x,y,z);
	p.teleport(loc);
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	public void run() {
	Bukkit.dispatchCommand(p, "kits");
	}
	},5L);
	}
  }
}