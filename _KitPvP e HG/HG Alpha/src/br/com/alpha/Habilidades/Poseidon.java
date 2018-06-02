/*  1:   */ package br.com.alpha.Habilidades;

/*  6:   */ import org.bukkit.Material;
/*  8:   */ import org.bukkit.entity.Player;
/*  9:   */ import org.bukkit.event.EventHandler;
/* 10:   */ import org.bukkit.event.Listener;
/* 11:   */ import org.bukkit.event.player.PlayerMoveEvent;
/* 12:   */ import org.bukkit.potion.PotionEffect;
/* 13:   */ import org.bukkit.potion.PotionEffectType;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

/* 15:   */ public class Poseidon implements Listener {
/* 18:   */   @EventHandler
/* 19:   */   public void onPlayerMove1(PlayerMoveEvent e) {
/* 21:19 */     Player p = e.getPlayer();
/* 22:20 */     if (MCAlpha.Status==GameTime.INGAME)
/* 23:   */     {
/* 24:22 */       Material m = e.getPlayer().getLocation().getBlock().getType();
/* 25:23 */       if ((KitsEnum.getKit(p)==KitsEnum.POSEIDON) && (
/* 26:24 */         (m == Material.STATIONARY_WATER) || (m == Material.WATER)))
/* 27:   */       {
/* 28:26 */         e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 1));
/* 29:27 */         e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 1));
/* 30:   */       }
/* 31:   */     }
/* 32:   */   }
/* 33:   */ }