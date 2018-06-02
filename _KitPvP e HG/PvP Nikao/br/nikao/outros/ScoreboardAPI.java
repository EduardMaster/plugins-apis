/*    */ package br.nikao.outros;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.common.base.Splitter;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.AbstractMap.SimpleEntry;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import org.bukkit.scoreboard.Objective;
/*    */ import org.bukkit.scoreboard.Score;
/*    */ import org.bukkit.scoreboard.Scoreboard;
/*    */ import org.bukkit.scoreboard.ScoreboardManager;
/*    */ import org.bukkit.scoreboard.Team;
/*    */ 
/*    */ public class ScoreboardAPI
/*    */ {
/*    */   private Scoreboard Scoreboard;
/*    */   private String Titulo;
/*    */   private Map<String, Integer> Scores;
/*    */   private List<Team> Times;
/*    */   private Objective Objetivo;
/*    */   
/*    */   public ScoreboardAPI(String Titulo)
/*    */   {
/* 28 */     this.Scoreboard = org.bukkit.Bukkit.getScoreboardManager().getNewScoreboard();
/* 29 */     this.Titulo = Titulo;
/* 30 */     this.Scores = Maps.newLinkedHashMap();
/* 31 */     this.Times = com.google.common.collect.Lists.newArrayList();
/*    */   }
/*    */   
/*    */   public void adicionarLinha(String Mensagem, Integer Score) {
/* 35 */     Preconditions.checkArgument(Mensagem.length() < 500, "Não passe de 500 caracteres!");
/* 36 */     Mensagem = Substituir(Mensagem);
/* 37 */     this.Scores.put(Mensagem, Score);
/*    */   }
/*    */   
/*    */   private String Substituir(String Mensagem) {
/* 41 */     while (this.Scores.containsKey(Mensagem)) {
/* 42 */       Mensagem = Mensagem + "§r";
/*    */     }
/* 44 */     if (Mensagem.length() > 70)
/* 45 */       Mensagem = Mensagem.substring(0, 69);
/* 46 */     return Mensagem;
/*    */   }
/*    */   
/*    */   private Map.Entry<Team, String> criarTimes(String Mensagem)
/*    */   {
/* 51 */     String Resultado = "";
/* 52 */     if (Mensagem.length() <= 16) {
/* 53 */       return new AbstractMap.SimpleEntry(null, Mensagem);
/*    */     }
/* 55 */     Team Time = this.Scoreboard.registerNewTeam("text-" + this.Scoreboard.getTeams().size());
/* 56 */     Iterator MensagemSplit = Splitter.fixedLength(16).split(Mensagem).iterator();
/* 57 */     Time.setPrefix((String)MensagemSplit.next());
/* 58 */     Resultado = (String)MensagemSplit.next();
/*    */     
/* 60 */     if (Mensagem.length() > 32)
/* 61 */       Time.setSuffix((String)MensagemSplit.next());
/* 62 */     this.Times.add(Time);
/* 63 */     return new AbstractMap.SimpleEntry(Time, Resultado);
/*    */   }
/*    */   
/*    */   public void setarScoreboard()
/*    */   {
/* 68 */     this.Objetivo = this.Scoreboard.registerNewObjective("a", "dummy");
/* 69 */     this.Objetivo.setDisplayName(this.Titulo);
/* 70 */     this.Objetivo.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
/* 71 */     int index = this.Scores.size();
/* 72 */     for (Map.Entry Mensagem : this.Scores.entrySet()) {
/* 73 */       Map.Entry Time = criarTimes((String)Mensagem.getKey());
/* 74 */       Integer Score = Integer.valueOf(Mensagem.getValue() != null ? ((Integer)Mensagem.getValue()).intValue() : index);
/* 75 */       String Jogador = (String)Time.getValue();
/*    */       
/* 77 */       if (Time.getKey() != null) ((Team)Time.getKey()).addEntry(Jogador);
/* 78 */       this.Objetivo.getScore(Jogador).setScore(Score.intValue());
/* 79 */       index--;
/*    */     }
/*    */   }
/*    */   
/*    */   public void resetarScoreboard() {
/* 84 */     if (this.Objetivo != null) {
/* 85 */       this.Objetivo.unregister();
/*    */     }
/* 87 */     this.Scores.clear();
/* 88 */     for (Team Times : this.Times)
/* 89 */       Times.unregister();
/* 90 */     this.Times.clear();
/*    */   }
/*    */   
/*    */   public Scoreboard pegarScoreboard() {
/* 94 */     return this.Scoreboard;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\outros\ScoreboardAPI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */