/*     */ package br.nikao.nametag;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class NametagManager
/*     */ {
/*     */   private static final String TEAM_NAME_PREFIX = "NTE";
/*  16 */   private static List<Integer> list = new ArrayList();
/*     */   
/*  18 */   private static HashMap<TeamInfo, List<String>> teams = new HashMap();
/*     */   
/*     */   private static void AdicinarTeam(TeamInfo Team, String Jogador)
/*     */   {
/*  22 */     RemoverTeam(Jogador);
/*  23 */     List<String> List = (List)teams.get(Team);
/*  24 */     if (List != null) {
/*  25 */       List.add(Jogador);
/*  26 */       Player Jogadores = Bukkit.getPlayerExact(Jogador);
/*  27 */       if (Jogadores != null) {
/*  28 */         MandarPacketsAdicinarTeams(Team, Jogadores.getName());
/*     */       } else {
/*  30 */         OfflinePlayer JogadoresOff = Bukkit.getOfflinePlayer(Jogador);
/*  31 */         MandarPacketsAdicinarTeams(Team, JogadoresOff.getName());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void register(TeamInfo Team)
/*     */   {
/*  38 */     teams.put(Team, new ArrayList());
/*  39 */     MandarPacketsAdicionarTeams(Team);
/*     */   }
/*     */   
/*     */   private static boolean removeTeam(String Nome) {
/*     */     TeamInfo[] arrayOfTeamInfo;
/*  44 */     int j = (arrayOfTeamInfo = (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])).length; for (int i = 0; i < j; i++) { TeamInfo Team = arrayOfTeamInfo[i];
/*  45 */       if (Team.PegarNome().equals(Nome)) {
/*  46 */         removeTeam(Team);
/*  47 */         return true;
/*     */       }
/*     */     }
/*  50 */     return false;
/*     */   }
/*     */   
/*     */   private static void removeTeam(TeamInfo Team) {
/*  54 */     MandarPacketsRemoverTeams(Team);
/*  55 */     teams.remove(Team);
/*     */   }
/*     */   
/*     */   private static TeamInfo RemoverTeam(String Jogador) {
/*     */     TeamInfo[] arrayOfTeamInfo;
/*  60 */     int j = (arrayOfTeamInfo = (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])).length; for (int i = 0; i < j; i++) { TeamInfo Team = arrayOfTeamInfo[i];
/*  61 */       List<String> list = (List)teams.get(Team);
/*  62 */       String[] arrayOfString; int m = (arrayOfString = (String[])list.toArray(new String[list.size()])).length; for (int k = 0; k < m; k++) { String Tags = arrayOfString[k];
/*  63 */         if (Tags.equals(Jogador)) {
/*  64 */           Player Jogador1 = Bukkit.getPlayerExact(Jogador);
/*  65 */           if (Jogador1 != null) {
/*  66 */             MandarPacketsRemoverTeams(Team, Jogador1.getName());
/*     */           } else {
/*  68 */             OfflinePlayer Jogador2 = Bukkit.getOfflinePlayer(Tags);
/*  69 */             MandarPacketsRemoverTeams(Team, Jogador2.getName());
/*     */           }
/*  71 */           list.remove(Tags);
/*     */           
/*  73 */           return Team;
/*     */         }
/*     */       }
/*     */     }
/*  77 */     return null;
/*     */   }
/*     */   
/*     */   private static TeamInfo getTeam(String name) { TeamInfo[] arrayOfTeamInfo;
/*  81 */     int j = (arrayOfTeamInfo = (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])).length; for (int i = 0; i < j; i++) { TeamInfo team = arrayOfTeamInfo[i];
/*  82 */       if (team.PegarNome().equals(name)) {
/*  83 */         return team;
/*     */       }
/*     */     }
/*  86 */     return null;
/*     */   }
/*     */   
/*     */   private static TeamInfo[] PegarTeams() {
/*  90 */     TeamInfo[] list = new TeamInfo[teams.size()];
/*  91 */     int at = 0;
/*  92 */     TeamInfo[] arrayOfTeamInfo1; int j = (arrayOfTeamInfo1 = (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])).length; for (int i = 0; i < j; i++) { TeamInfo team = arrayOfTeamInfo1[i];
/*  93 */       list[at] = team;
/*  94 */       at++;
/*     */     }
/*  96 */     return list;
/*     */   }
/*     */   
/*     */   private static String[] PegarTeamJogadores(TeamInfo Team)
/*     */   {
/* 101 */     List<String> List = (List)teams.get(Team);
/* 102 */     if (List != null) {
/* 103 */       return (String[])List.toArray(new String[List.size()]);
/*     */     }
/* 105 */     return new String[0];
/*     */   }
/*     */   
/*     */   public static void Atualizar(String Jogador, String Prefix, String Suffix) {
/* 109 */     if ((Prefix == null) || (Prefix.isEmpty())) {
/* 110 */       Prefix = PegarPrefix(Jogador);
/*     */     }
/* 112 */     if ((Suffix == null) || (Suffix.isEmpty())) {
/* 113 */       Suffix = PegarSuffix(Jogador);
/*     */     }
/* 115 */     TeamInfo t = Pegar(Prefix, Suffix);
/* 116 */     AdicinarTeam(t, Jogador);
/*     */   }
/*     */   
/*     */   public static void Overlap(String Jogador, String Prefix, String Suffix) {
/* 120 */     if (Prefix == null) {
/* 121 */       Prefix = "";
/*     */     }
/* 123 */     if (Suffix == null) {
/* 124 */       Suffix = "";
/*     */     }
/* 126 */     TeamInfo t = Pegar(Prefix, Suffix);
/* 127 */     AdicinarTeam(t, Jogador);
/*     */   }
/*     */   
/*     */ 
/* 131 */   public static void Limpar(String player) { RemoverTeam(player); }
/*     */   
/*     */   public static String PegarPrefix(String Jogador) {
/*     */     TeamInfo[] arrayOfTeamInfo;
/* 135 */     int j = (arrayOfTeamInfo = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team = arrayOfTeamInfo[i];
/* 136 */       String[] arrayOfString; int m = (arrayOfString = PegarTeamJogadores(Team)).length; for (int k = 0; k < m; k++) { String Tags = arrayOfString[k];
/* 137 */         if (Tags.equals(Jogador)) {
/* 138 */           return Team.PegarPrefix();
/*     */         }
/*     */       }
/*     */     }
/* 142 */     return "";
/*     */   }
/*     */   
/*     */   public static String PegarSuffix(String Jogador) { TeamInfo[] arrayOfTeamInfo;
/* 146 */     int j = (arrayOfTeamInfo = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team = arrayOfTeamInfo[i];
/* 147 */       String[] arrayOfString; int m = (arrayOfString = PegarTeamJogadores(Team)).length; for (int k = 0; k < m; k++) { String Tags = arrayOfString[k];
/* 148 */         if (Tags.equals(Jogador)) {
/* 149 */           return Team.PegarSuffix();
/*     */         }
/*     */       }
/*     */     }
/* 153 */     return "";
/*     */   }
/*     */   
/*     */   public static String PegarFormattedName(String Jogador) {
/* 157 */     return PegarPrefix(Jogador) + Jogador + PegarSuffix(Jogador);
/*     */   }
/*     */   
/*     */   private static TeamInfo DeclareTeam(String Nome, String Prefix, String Suffix) {
/* 161 */     if (getTeam(Nome) != null) {
/* 162 */       TeamInfo Team = getTeam(Nome);
/* 163 */       removeTeam(Team);
/*     */     }
/*     */     
/* 166 */     TeamInfo Team = new TeamInfo(Nome);
/*     */     
/* 168 */     Team.SetarPrefix(Prefix);
/* 169 */     Team.SetarSuffix(Suffix);
/*     */     
/* 171 */     register(Team);
/*     */     
/* 173 */     return Team;
/*     */   }
/*     */   
/*     */   private static TeamInfo Pegar(String Prefix, String Suffix) {
/* 177 */     Atualizar();
/*     */     
/* 179 */     Integer[] arr$ = (Integer[])list.toArray(new Integer[list.size()]);int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int t = arr$[i$].intValue();
/*     */       
/* 181 */       if (getTeam("NTE" + t) != null) {
/* 182 */         TeamInfo team = getTeam("NTE" + t);
/*     */         
/* 184 */         if ((team.PegarSuffix().equals(Suffix)) && (team.PegarPrefix().equals(Prefix))) {
/* 185 */           return team;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 190 */     return DeclareTeam("NTE" + NextName(), Prefix, Suffix);
/*     */   }
/*     */   
/*     */   private static int NextName() {
/* 194 */     int at = 0;
/* 195 */     boolean cont = true;
/* 196 */     int len$; int i$; for (; cont; 
/*     */         
/* 198 */         i$ < len$)
/*     */     {
/* 197 */       cont = false;
/* 198 */       Integer[] arr$ = (Integer[])list.toArray(new Integer[list.size()]);len$ = arr$.length;i$ = 0; continue;int t = arr$[i$].intValue();
/* 199 */       if (t == at) {
/* 200 */         at++;
/* 201 */         cont = true;
/*     */       }
/* 198 */       i$++;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 206 */     list.add(Integer.valueOf(at));
/* 207 */     return at;
/*     */   }
/*     */   
/*     */   private static void Atualizar() { TeamInfo[] arrayOfTeamInfo;
/* 211 */     int j = (arrayOfTeamInfo = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team = arrayOfTeamInfo[i];
/* 212 */       int Entry = -1;
/*     */       try {
/* 214 */         Entry = Integer.parseInt(Team.PegarNome());
/*     */       }
/*     */       catch (Exception localException) {}
/* 217 */       if ((Entry != -1) && (PegarTeamJogadores(Team).length == 0)) {
/* 218 */         removeTeam(Team);
/* 219 */         list.remove(new Integer(Entry));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void MandarTeamsParaJogador(Player Jogador) {
/*     */     try {
/*     */       TeamInfo[] arrayOfTeamInfo;
/* 227 */       int j = (arrayOfTeamInfo = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team = arrayOfTeamInfo[i];
/* 228 */         PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 0);
/*     */         
/* 230 */         PacketPlayOut.sendToPlayer(Jogador);
/* 231 */         PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(PegarTeamJogadores(Team)), 3);
/*     */         
/* 233 */         PacketPlayOut.sendToPlayer(Jogador);
/*     */       }
/*     */     } catch (Exception e) {
/* 236 */       System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
/*     */       
/* 238 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void MandarPacketsAdicionarTeams(TeamInfo Team) {
/*     */     try {
/*     */       Player[] arrayOfPlayer;
/* 245 */       int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player Jogadores = arrayOfPlayer[i];
/* 246 */         PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 0);
/* 247 */         PacketPlayOut.sendToPlayer(Jogadores);
/*     */       }
/*     */     } catch (Exception e) {
/* 250 */       System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
/*     */       
/* 252 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void MandarPacketsRemoverTeams(TeamInfo Team)
/*     */   {
/* 258 */     boolean Cont = false;
/* 259 */     Object localObject; int j = (localObject = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team2 = localObject[i];
/* 260 */       if (Team2 == Team) {
/* 261 */         Cont = true;
/*     */       }
/*     */     }
/* 264 */     if (!Cont) {
/* 265 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 269 */       j = (localObject = Bukkit.getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player Jogadores = localObject[i];
/* 270 */         PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 1);
/* 271 */         PacketPlayOut.sendToPlayer(Jogadores);
/*     */       }
/*     */     } catch (Exception e) {
/* 274 */       System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
/* 275 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void MandarPacketsAdicinarTeams(TeamInfo Team, String Jogador)
/*     */   {
/* 281 */     boolean Cont = false;
/* 282 */     Object localObject; int j = (localObject = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team2 = localObject[i];
/* 283 */       if (Team2 == Team) {
/* 284 */         Cont = true;
/*     */       }
/*     */     }
/* 287 */     if (!Cont) {
/* 288 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 292 */       j = (localObject = Bukkit.getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player Jogadores = localObject[i];
/* 293 */         PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(new String[] { Jogador }), 3);
/*     */         
/* 295 */         PacketPlayOut.sendToPlayer(Jogadores);
/*     */       }
/*     */     } catch (Exception e) {
/* 298 */       System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
/*     */       
/* 300 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void MandarPacketsRemoverTeams(TeamInfo Team, String Jogador)
/*     */   {
/* 306 */     boolean Cont = false;
/* 307 */     Object localObject; int j = (localObject = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team2 = localObject[i];
/* 308 */       if (Team2 == Team) { String[] arrayOfString;
/* 309 */         int m = (arrayOfString = PegarTeamJogadores(Team2)).length; for (int k = 0; k < m; k++) { String NomeDoJogador = arrayOfString[k];
/* 310 */           if (NomeDoJogador.equals(Jogador)) {
/* 311 */             Cont = true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 316 */     if (!Cont) {
/* 317 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 321 */       j = (localObject = Bukkit.getOnlinePlayers()).length; for (i = 0; i < j; i++) { Player Jogadores = localObject[i];
/* 322 */         PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(new String[] { Jogador }), 4);
/* 323 */         PacketPlayOut.sendToPlayer(Jogadores);
/*     */       }
/*     */     } catch (Exception e) {
/* 326 */       System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
/*     */       
/* 328 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Resetar() { TeamInfo[] arrayOfTeamInfo;
/* 333 */     int j = (arrayOfTeamInfo = PegarTeams()).length; for (int i = 0; i < j; i++) { TeamInfo Team = arrayOfTeamInfo[i];
/* 334 */       removeTeam(Team);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\NametagManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */