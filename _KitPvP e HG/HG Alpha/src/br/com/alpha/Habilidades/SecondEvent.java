package br.com.alpha.Habilidades;

import org.bukkit.event.Event;
/*  4:   */ import org.bukkit.event.HandlerList;
/*  5:   */ 
/*  6:   */ public class SecondEvent
/*  7:   */   extends Event
/*  8:   */ {
/*  9: 9 */   private static final HandlerList handlers = new HandlerList();
/* 10:   */   
/* 11:   */   public static HandlerList getHandlerList()
/* 12:   */   {
/* 13:13 */     return handlers;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public HandlerList getHandlers()
/* 17:   */   {
/* 18:18 */     return handlers;
/* 19:   */   }
/* 20:   */ }
