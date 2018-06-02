package Zey.PvP.Kits;

import org.bukkit.plugin.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Main.*;

import org.bukkit.potion.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

public class Gladiator implements Listener
{
    public Plugin plugin;
    private List<Block> gladiatorbloco;
    private HashMap<Block, Player> gladblock;
    static HashMap<Player, Player> lutando;
    private HashMap<Player, Location> lugar;
    private int glad1;
    private int glad2;
    
    public Gladiator(final Main plugin) {
        this.gladiatorbloco = new ArrayList<Block>();
        this.gladblock = new HashMap<Block, Player>();
        Gladiator.lutando = new HashMap<Player, Player>();
        this.lugar = new HashMap<Player, Location>();
        this.plugin = (Plugin)plugin;
    }
    
    @EventHandler
    void KitGladiator(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            final Player r = (Player)e.getRightClicked();
            if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.Gladiator.contains(p.getName())) {
                final Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 80.0, p.getLocation().getZ());
                final Location loc2 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() + 8), (double)(p.getLocation().getBlockY() + 82), (double)(p.getLocation().getBlockZ() + 8));
                final Location loc3 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() - 8), (double)(p.getLocation().getBlockY() + 82), (double)(p.getLocation().getBlockZ() - 8));
                if (Gladiator.lutando.containsKey(p) || Gladiator.lutando.containsKey(r)) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê já está em uma arena Gladiator.");
                    return;
                }
                final List<Location> cuboid = new ArrayList<Location>();
                for (int bX = -10; bX <= 10; ++bX) {
                    for (int bZ = -10; bZ <= 10; ++bZ) {
                        for (int bY = -1; bY <= 10; ++bY) {
                            final Block b = loc.clone().add((double)bX, (double)bY, (double)bZ).getBlock();
                            if (!b.isEmpty()) {
                                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê não pode ultilizar esse kit aqui.");
                                return;
                            }
                            if (bY == 10) {
                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                            }
                            else if (bY == -1) {
                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                            }
                            else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                            }
                        }
                    }
                }
                for (final Location loc4 : cuboid) {
                    loc4.getBlock().setType(Material.GLASS);
                    this.gladiatorbloco.add(loc4.getBlock());
                    this.gladblock.put(loc4.getBlock(), p);
                    this.gladblock.put(loc4.getBlock(), r);
                }
                this.lugar.put(p, p.getLocation());
                this.lugar.put(r, r.getLocation());
                p.teleport(loc2);
                r.teleport(loc3);
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
                r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
                Gladiator.lutando.put(p, r);
                Gladiator.lutando.put(r, p);
                this.glad1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance1(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 4800L);
                this.glad2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance1(), (Runnable)new Runnable() {
                    @SuppressWarnings("unlikely-arg-type")
					@Override
                    public void run() {
                        if (Gladiator.lutando.containsKey(p) && Gladiator.lutando.containsKey(r)) {
                            Gladiator.lutando.remove(p);
                            Gladiator.lutando.remove(r);
                            p.teleport((Location)Gladiator.this.lugar.get(p));
                            r.teleport((Location)Gladiator.this.lugar.get(r));
                            for (final Block glad : Gladiator.this.gladiatorbloco) {
                                if ((Gladiator.this.gladblock.get(glad) == r || Gladiator.this.gladblock.get(glad) == p) && glad.getType() == Material.GLASS) {
                                    glad.setType(Material.AIR);
                                }
                            }
                            Gladiator.this.lugar.remove(p);
                            Gladiator.this.lugar.remove(r);
                            Gladiator.this.gladblock.remove(p);
                            Gladiator.this.gladblock.remove(r);
                        }
                    }
                }, 6000L);
            }
        }
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@EventHandler
    void KitGladiatorInteragir(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (this.gladiatorbloco.contains(p) && p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@EventHandler
    void KitGladiatorSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (Gladiator.lutando.containsKey(p)) {
            final String nome = Gladiator.lutando.get(p).getName();
            final Player q = Bukkit.getPlayer(nome);
            Gladiator.lutando.remove(p);
            Gladiator.lutando.remove(q);
            q.sendMessage(String.valueOf(Main.prefix) + " §7» §cO jogador(a): §e§l" + p.getDisplayName() + " §cdeslogou no gladiator.");
            q.teleport((Location)this.lugar.get(q));
            Bukkit.getScheduler().cancelTask(this.glad1);
            Bukkit.getScheduler().cancelTask(this.glad2);
            for (final Block glad : this.gladiatorbloco) {
                if ((this.gladblock.get(glad) == q || this.gladblock.get(glad) == p) && glad.getType() == Material.GLASS) {
                    glad.setType(Material.AIR);
                }
            }
            this.gladblock.remove(p);
            this.gladblock.remove(q);
        }
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@EventHandler
    void KitGladiatorMorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (Gladiator.lutando.containsKey(p)) {
            final String nome = Gladiator.lutando.get(p).getName();
            final Player m = Bukkit.getPlayer(nome);
            m.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §a§lGANHOU§7 a batalha no Gladiator.");
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §c§lPERDEU§7 a batalha no Gladiator.");
            Gladiator.lutando.remove(p);
            Gladiator.lutando.remove(m);
            m.teleport((Location)this.lugar.get(m));
            m.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
            Bukkit.getScheduler().cancelTask(this.glad1);
            Bukkit.getScheduler().cancelTask(this.glad2);
            for (final Block glad : this.gladiatorbloco) {
                if ((this.gladblock.get(glad) == m || this.gladblock.get(glad) == p) && glad.getType() == Material.GLASS) {
                    glad.setType(Material.AIR);
                }
            }
            this.gladblock.remove(p);
            this.gladblock.remove(m);
        }
    }
    
    @EventHandler
    void KitGladiatorComando(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (Gladiator.lutando.containsKey(p)) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê não pode executar comandos na Arena Gladiator.");
        }
    }
}
