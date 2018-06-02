/*    */ package br.nikao.nametag;
/*    */ 
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ public class NameTagChangeEvento extends Event implements Cancellable
/*    */ {
/*  9 */   private static final HandlerList handlers = new HandlerList();
/*    */   
/*    */   private String OldJogador;
/*    */   private String OldPrefix;
/*    */   private String OldSuffix;
/*    */   private String NewPrefix;
/*    */   private String NewSuffix;
/*    */   private NametagChangeType Tipo;
/*    */   private NametagChangeReason Reação;
/* 18 */   private boolean Cancelar = false;
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 21 */     return handlers;
/*    */   }
/*    */   
/*    */   public HandlerList getHandlers() {
/* 25 */     return handlers;
/*    */   }
/*    */   
/*    */   public NameTagChangeEvento(String Jogador, String OldPrefix, String OldSuffix, String NewPrefix, String NewSuffix, NametagChangeType Tipo, NametagChangeReason Reação) {
/* 29 */     this.OldJogador = Jogador;
/* 30 */     this.OldPrefix = OldPrefix;
/* 31 */     this.OldSuffix = OldSuffix;
/* 32 */     this.NewPrefix = NewPrefix;
/* 33 */     this.NewSuffix = NewSuffix;
/* 34 */     this.Tipo = Tipo;
/* 35 */     this.Reação = Reação;
/*    */   }
/*    */   
/*    */   public String PegarPlayerName() {
/* 39 */     return this.OldJogador;
/*    */   }
/*    */   
/*    */   public String PegarCurrentPrefix() {
/* 43 */     return this.OldPrefix;
/*    */   }
/*    */   
/*    */   public String PegarCurrentSuffix() {
/* 47 */     return this.OldSuffix;
/*    */   }
/*    */   
/*    */   public String PegarPrefix() {
/* 51 */     return this.NewPrefix;
/*    */   }
/*    */   
/*    */   public String PegarSuffix() {
/* 55 */     return this.NewSuffix;
/*    */   }
/*    */   
/*    */   public void SetarPrefix(String Prefix) {
/* 59 */     this.NewPrefix = Prefix;
/*    */   }
/*    */   
/*    */   public void SetarSufix(String Suffix) {
/* 63 */     this.NewSuffix = Suffix;
/*    */   }
/*    */   
/*    */   public NametagChangeType PegarTipo() {
/* 67 */     return this.Tipo;
/*    */   }
/*    */   
/*    */   public NametagChangeReason PegarReason() {
/* 71 */     return this.Reação;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean Cancelar) {
/* 75 */     this.Cancelar = Cancelar;
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 79 */     return this.Cancelar;
/*    */   }
/*    */   
/*    */   public static enum NametagChangeType {
/* 83 */     HARD,  SOFT;
/*    */   }
/*    */   
/*    */ 
/*    */   public static enum NametagChangeReason
/*    */   {
/* 89 */     SET_PREFIX,  SET_SUFFIX,  GROUP_NODE,  CUSTOM;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\NameTagChangeEvento.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */