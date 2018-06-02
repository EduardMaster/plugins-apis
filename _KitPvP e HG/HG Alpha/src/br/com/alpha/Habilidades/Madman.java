/*  1:   */ package br.com.alpha.Habilidades;
/*  2:   */ 
/*  3:   */ import java.text.DecimalFormat;
/*  5:   */ import java.util.HashMap;

/* 11:   */ import org.bukkit.Bukkit;
/* 12:   */ import org.bukkit.ChatColor;
/* 13:   */ import org.bukkit.entity.Entity;
/* 14:   */ import org.bukkit.entity.Player;
/* 15:   */ import org.bukkit.event.EventHandler;
/* 16:   */ import org.bukkit.event.Listener;
/* 17:   */ import org.bukkit.event.entity.EntityDamageEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.BarAPI;
import br.com.alpha.Comandos.Desistir;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

/* 19:   */ public class Madman
/* 20:   */   implements Listener
/* 21:   */ {
/* 22:21 */   @SuppressWarnings({ "unchecked", "rawtypes" })
private HashMap<Player, Double> madman = new HashMap();
/* 23:   */   
@SuppressWarnings("deprecation")
/* 24:   */   @EventHandler
/* 25:   */   public void onMadmanEffect(SecondEvent event)
/* 26:   */   {
/* 27:27 */     DecimalFormat dm = new DecimalFormat("##");
/* 28:28 */     if (MCAlpha.Status ==GameTime.INGAME) {
/* 29:29 */       for (Player p : Bukkit.getOnlinePlayers())
/* 30:   */       {
/* 31:31 */         if (KitsEnum.getKit(p) == KitsEnum.MADMAN) {
/* 32:32 */           for (Entity e : p.getNearbyEntities(20.0D, 20.0D, 20.0D)) {
/* 33:33 */             if (((e instanceof Player)) && (!Desistir.admin.contains(e)) && (!APIClass.espectadores.contains(e.getUniqueId())))
/* 34:   */             {
/* 35:35 */               if ((this.madman.containsKey((Player)e)) && (((Double)this.madman.get((Player)e)).doubleValue() < 3.0D))
/* 36:   */               {
/* 37:37 */                 this.madman.put((Player)e, Double.valueOf(((Double)this.madman.get((Player)e)).doubleValue() + 0.03D));
/* 38:   */               }
/* 39:   */               else
/* 40:   */               {
/* 41:41 */                 this.madman.put((Player)e, Double.valueOf(0.03D));
/* 42:42 */                 ((Player)e).sendMessage(ChatColor.GRAY + "Voce se sente tonto... Ugh!");
/* 43:   */               }
/* 44:44 */               BarAPI.setName((Player)e, "Madman Effect - +" + dm.format(((Double)this.madman.get((Player)e)).doubleValue() * 100.0D) + "% Damage taken. (+3% / seg", 400.0F);
/* 45:   */             }
/* 46:   */           }
/* 47:   */         }
/* 48:48 */         if (this.madman.containsKey(p))
/* 49:   */         {
/* 50:50 */           boolean hasMadMan = false;
/* 51:51 */           for (Entity e : p.getNearbyEntities(20.0D, 20.0D, 20.0D)) {
/* 52:52 */             if (((e instanceof Player)) && (!Desistir.admin.contains(e)) && (!APIClass.espectadores.contains(e.getUniqueId())))
/* 53:   */             {
/* 54:54 */               Player mad = (Player)e;
/* 55:55 */               if (KitsEnum.getKit(mad) == KitsEnum.MADMAN)
/* 56:   */               {
/* 57:57 */                 hasMadMan = true;
/* 58:58 */                 break;
/* 59:   */               }
/* 60:   */             }
/* 61:   */           }
/* 62:62 */           if (!hasMadMan) {
/* 63:63 */             if (((Double)this.madman.get(p)).doubleValue() - 0.1D <= 0.0D)
/* 64:   */             {
/* 65:65 */               this.madman.remove(p);
/* 66:66 */               p.sendMessage(ChatColor.GRAY + "Sua cabeça parece clara novamente");
/* 67:67 */               BarAPI.removeBar(p);
/* 68:   */             }
/* 69:   */             else
/* 70:   */             {
/* 71:71 */               this.madman.put(p, Double.valueOf(((Double)this.madman.get(p)).doubleValue() - 0.1D));
/* 72:72 */               BarAPI.setName(p, "Madman Effect -  +" + dm.format(((Double)this.madman.get(p)).doubleValue() * 100.0D) + "% Damage taken. (-1% / seg)", 400.0F);
/* 73:   */             }
/* 74:   */           }
/* 75:   */         }
/* 76:   */       }
/* 77:   */     }
/* 78:   */   }
/* 79:   */   
/* 80:   */   @EventHandler
/* 81:   */   public void onMadmanDamage(EntityDamageEvent event)
/* 82:   */   {
/* 83:83 */     if (!(event.getEntity() instanceof Player)) {
/* 84:84 */       return;
/* 85:   */     }
/* 86:86 */     Player p = (Player)event.getEntity();
/* 87:87 */     if ((this.madman.containsKey(p)) && (((Double)this.madman.get(p)).doubleValue() > 0.05D)) {
/* 88:88 */       event.setDamage(event.getDamage() + event.getDamage() * ((Double)this.madman.get(p)).doubleValue());
/* 89:   */     }
/* 90:   */   }
/* 91:   */ }