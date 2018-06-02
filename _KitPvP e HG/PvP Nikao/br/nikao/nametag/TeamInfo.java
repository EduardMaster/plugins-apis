/*    */ package br.nikao.nametag;
/*    */ 
/*    */ 
/*    */ public class TeamInfo
/*    */ {
/*    */   private String name;
/*    */   private String prefix;
/*    */   private String suffix;
/*    */   
/*    */   TeamInfo(String name)
/*    */   {
/* 12 */     this.name = name;
/*    */   }
/*    */   
/*    */   void SetarPrefix(String prefix) {
/* 16 */     this.prefix = prefix;
/*    */   }
/*    */   
/*    */   void SetarSuffix(String suffix) {
/* 20 */     this.suffix = suffix;
/*    */   }
/*    */   
/*    */   String PegarPrefix() {
/* 24 */     return this.prefix;
/*    */   }
/*    */   
/*    */   String PegarSuffix() {
/* 28 */     return this.suffix;
/*    */   }
/*    */   
/*    */   String PegarNome() {
/* 32 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\TeamInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */