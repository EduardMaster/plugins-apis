package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import Vinagre.*;
import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;





	public class Subzero implements Listener, CommandExecutor
	{
	    public static ArrayList<String> congelado;
	    
	    static {
	        Subzero.congelado = new ArrayList<String>();
	    }
	    
	    @EventHandler
	    public void ar(final PlayerInteractEvent e) {
	        final Player p = e.getPlayer();
	        if (Habilidade.getAbility(p).equalsIgnoreCase("Subzero") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.PACKED_ICE) {
	            e.setCancelled(true);
	            p.updateInventory();
	            if (Cooldown.add(p)) {
	                p.sendMessage("§cCooldown");
	                return;
	            }
	            Cooldown.add(p, 30);
	            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
	                @Override
	                public void run() {
	                	p.sendMessage("§aVocê ja pode usar o subzero novamente");
	                }
	            }, 600L);
	            final Location loc = p.getEyeLocation();
	            final BlockIterator blocos = new BlockIterator(loc, 0.0, 40);
	            while (blocos.hasNext()) {
	                final Location bloco = blocos.next().getLocation();
	                p.playSound(bloco, Sound.ITEM_PICKUP, 1.0f, 1.0f);
	                p.getWorld().playEffect(bloco, Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
	            }
	            final Snowball h = (Snowball)p.launchProjectile((Class)Snowball.class);
	            final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
	            h.setVelocity(velo1);
	            h.setMetadata("icew", (MetadataValue)new FixedMetadataValue((Plugin)Main.getInstance(), (Object)true));
	        }
	    }
	    
	    @EventHandler
	    public void aoDanoIceWizard(final EntityDamageByEntityEvent e) {
	        if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
	            final Snowball s = (Snowball)e.getDamager();
	            if (s.hasMetadata("icew")) {
	                final Player p = (Player)e.getEntity();
	                e.setDamage(e.getDamage() + 5.0);
	                Subzero.congelado.add(p.getName());
	                p.sendMessage("§7Voc\u00ea foi congelado por um Subzero");
	                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
	                    @Override
	                    public void run() {
	                        Subzero.congelado.remove(p.getName());
	                        p.sendMessage("§7Voc\u00ea foi descongelado");
	                    }
	                }, 140L);
	            }
	        }
	    }
	    
	    @EventHandler
	    public void aoAndar(final PlayerMoveEvent e) {
	        final Player p = e.getPlayer();
	        if (Subzero.congelado.contains(p.getName())) {
	            e.setTo(p.getLocation());
	            p.sendMessage("§7Voc\u00ea est\u00e1 congelado por um Subzero");
	        }
	    }
	
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
	    Player p = (Player)sender;
	    ItemStack dima = new ItemStack(Material.STONE_SWORD);
	    ItemMeta souperaa = dima.getItemMeta();
	    souperaa.setDisplayName("§cEspada");
	    dima.setItemMeta(souperaa);
	    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	    ItemMeta sopas = sopa.getItemMeta();
	    sopas.setDisplayName("§6Sopa");
	    sopa.setItemMeta(sopas);
		ItemStack ff = new ItemStack(Material.PACKED_ICE);
		ItemMeta ff2 = ff.getItemMeta();
		ff2.setDisplayName("§bSubZero");
		ff.setItemMeta(ff2);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	  
	  if (cmd.equalsIgnoreCase("subzero")) {
	    if (Array.used.contains(p.getName())) {
	    	p.sendMessage("§7» §cVoce ja esta usando um kit!");
	      return true;
	    }
	    if (!p.hasPermission("kitpvp.kit.subzero")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	      return true;
	    }
	    Array.used.add(p.getName());
	    p.sendMessage("§7» Voce escolheu o kit §cSubzero§7!");
	    p.setGameMode(GameMode.ADVENTURE);
	    p.getInventory().clear();
	    Array.kit.put(p, "Subzero");
	    Vinagre.Habilidade.setAbility(p, "Subzero");
	    p.getInventory().addItem(new ItemStack[] { dima });
	    p.getInventory().addItem(new ItemStack[] { ff });
	    Main.give(p);
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    Main.Dj.remove(p.getName());
	    Scoreboard.ScoreDoBasic.iscoriboard(p);
	    for (int i = 0; i <= 34; i++) {
	      p.getInventory().addItem(new ItemStack[] { sopa });
	    }
	  }
	  return false;
	}
}