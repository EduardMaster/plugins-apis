package Zey.PvP.Eventos;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;

public class Nerfs implements Listener
{
    @SuppressWarnings("deprecation")
	@EventHandler
    public void NerfsDanos(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            final Player player = (Player)event.getDamager();
            if (event.getDamage() > 1.0) {
                event.setDamage(event.getDamage() - 1.0);
            }
            if (event.getDamager() instanceof Player) {
                if (player.getFallDistance() > 0.0f && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                    final int NewDamage = (int)(event.getDamage() * 1.5) - (int)event.getDamage();
                    if (event.getDamage() > 1.0) {
                        event.setDamage(event.getDamage() - NewDamage);
                    }
                }
                if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                    event.setDamage(1.0);
                }
                if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                    event.setDamage(2.0);
                }
                if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                    event.setDamage(4.0);
                }
                if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                    event.setDamage(5.0);
                }
                if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                    event.setDamage(1.0);
                }
                if (player.getItemInHand().getType() == Material.STONE_AXE) {
                    event.setDamage(2.0);
                }
                if (player.getItemInHand().getType() == Material.IRON_AXE) {
                    event.setDamage(4.0);
                }
                if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                    event.setDamage(5.0);
                }
                if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
                    event.setDamage(event.getDamage() + 1.0);
                }
                if (player.getFallDistance() > 0.0f && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                    if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                    }
                    if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) && !player.isOnGround()) {
                        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                    }
                }
            }
        }
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void Quebrar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final ItemStack item1 = p.getItemInHand();
        final Material material1 = Material.getMaterial(item1.getTypeId());
        if (!material1.isBlock() && material1.getMaxDurability() >= 1 && item1.getDurability() != 0) {
            p.getItemInHand().setDurability((short)0);
            p.updateInventory();
        }
        final PlayerInventory item2 = p.getInventory();
        if (p.getInventory().getHelmet() != null) {
            final Material material2 = Material.getMaterial(item2.getHelmet().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getHelmet().getDurability() != 0) {
                p.getInventory().getHelmet().setDurability((short)1);
            }
        }
        if (p.getInventory().getChestplate() != null) {
            final Material material2 = Material.getMaterial(item2.getChestplate().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getChestplate().getDurability() != 0) {
                p.getInventory().getChestplate().setDurability((short)1);
            }
        }
        if (p.getInventory().getLeggings() != null) {
            final Material material2 = Material.getMaterial(item2.getLeggings().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getLeggings().getDurability() != 0) {
                p.getInventory().getLeggings().setDurability((short)1);
            }
        }
        if (p.getInventory().getBoots() != null) {
            final Material material2 = Material.getMaterial(item2.getBoots().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getBoots().getDurability() != 0) {
                p.getInventory().getBoots().setDurability((short)1);
            }
        }
    }
}
