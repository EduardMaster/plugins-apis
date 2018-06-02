/*     */ package br.nikao.nametag;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Scanner;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class GroupLoader
/*     */ {
/*     */   private static final String PREFIX = "[NAMETAG CONFIG] ";
/*     */   static final boolean DEBUG = true;
/*     */   
/*     */   public static LinkedHashMap<String, LinkedHashMap<String, String>> Carregar(JavaPlugin Plugin)
/*     */   {
/*  19 */     String folder = "plugins/" + Plugin.getName();
/*  20 */     File folderFile = new File(folder);
/*  21 */     if (!folderFile.exists()) {
/*  22 */       folderFile.mkdir();
/*     */     }
/*  24 */     String path = "plugins/" + Plugin.getName() + "/groups.txt";
/*  25 */     File source = new File(path);
/*  26 */     if (source.exists()) {
/*  27 */       return CarregarConfig(source);
/*     */     }
/*     */     try {
/*  30 */       source.createNewFile();
/*     */     } catch (IOException e) {
/*  32 */       Print("Failed to create config file: ");
/*  33 */       e.printStackTrace();
/*     */     }
/*  35 */     return CriarConfig(source);
/*     */   }
/*     */   
/*     */   private static LinkedHashMap<String, LinkedHashMap<String, String>> CriarConfig(File target) {
/*  39 */     PrintWriter out = null;
/*     */     try {
/*  41 */       out = new PrintWriter(target);
/*     */     } catch (FileNotFoundException e) {
/*  43 */       e.printStackTrace();
/*     */     }
/*  45 */     out.println("// This file declares custom permissions and ties prefixes and suffixes to them.");
/*  46 */     out.println("// Players who possess these permissions will have the prefix and suffix assigned to the given permission.");
/*  47 */     out.println("nametag.group.admin prefix = \"[&cAdmin&f] \"");
/*  48 */     out.println("nametag.group.mod prefix = \"[&bMod&f] \"");
/*  49 */     out.println("nametag.group.member prefix = \"[&eMember&f] \"");
/*  50 */     out.println("nametag.group.swag prefix = \"&eThe &b\"");
/*  51 */     out.println("nametag.group.swag suffix = \" &cSwagmaster\"");
/*     */     
/*  53 */     LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap();
/*     */     
/*  55 */     LinkedHashMap<String, String> admin = new LinkedHashMap();
/*  56 */     admin.put("prefix", "[&cAdmin&f] ");
/*  57 */     map.put("nametag.group.admin", admin);
/*     */     
/*  59 */     LinkedHashMap<String, String> mod = new LinkedHashMap();
/*  60 */     mod.put("prefix", "[&bMod&f] ");
/*  61 */     map.put("nametag.group.mod", mod);
/*     */     
/*  63 */     LinkedHashMap<String, String> member = new LinkedHashMap();
/*  64 */     member.put("prefix", "[&eMember&f] ");
/*  65 */     map.put("nametag.group.member", member);
/*     */     
/*  67 */     LinkedHashMap<String, String> swag = new LinkedHashMap();
/*  68 */     swag.put("prefix", "&eThe &b");
/*  69 */     swag.put("suffix", " &cSwagmaster");
/*  70 */     map.put("nametag.group.swag", swag);
/*     */     
/*  72 */     out.close();
/*     */     
/*  74 */     return map;
/*     */   }
/*     */   
/*     */   public static LinkedHashMap<String, LinkedHashMap<String, String>> CarregarConfig(File source) {
/*  78 */     Scanner in = null;
/*     */     try {
/*  80 */       in = new Scanner(source);
/*     */     } catch (FileNotFoundException e) {
/*  82 */       e.printStackTrace();
/*     */     }
/*     */     
/*  85 */     LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap();
/*     */     
/*  87 */     boolean syntaxError = false;
/*     */     
/*  89 */     while (in.hasNext()) {
/*  90 */       String line = in.nextLine();
/*  91 */       if ((!line.trim().startsWith("//")) && (!line.isEmpty())) {
/*  92 */         syntaxError = CheckWords(line);
/*  93 */         if (syntaxError) {
/*  94 */           Print("Error in syntax, not enough elements on line!");
/*     */         }
/*     */         
/*  97 */         Scanner lineScanner = new Scanner(line);
/*     */         
/*  99 */         String node = lineScanner.next();
/* 100 */         String operation = lineScanner.next();
/* 101 */         String equals = lineScanner.next();
/* 102 */         if (!equals.trim().equals("=")) {
/* 103 */           Print("Error in syntax, \"=\" expected at third element, \"" + equals + "\" given.");
/*     */           
/* 105 */           syntaxError = true;
/* 106 */           break;
/*     */         }
/* 108 */         String rawValue = lineScanner.nextLine();
/* 109 */         syntaxError = CheckValue(rawValue);
/* 110 */         if (syntaxError) {
/* 111 */           Print("Error in syntax, value not encased in quotation marks!");
/* 112 */           break;
/*     */         }
/* 114 */         String value = PegarValue(rawValue);
/*     */         
/* 116 */         LinkedHashMap<String, String> entry = new LinkedHashMap();
/*     */         
/* 118 */         if (map.get(node) != null) {
/* 119 */           entry = (LinkedHashMap)map.get(node);
/*     */         }
/*     */         
/* 122 */         entry.put(operation.toLowerCase(), value);
/*     */         
/* 124 */         if (map.get(node) == null) {
/* 125 */           map.put(node, entry);
/*     */         }
/* 127 */         lineScanner.close();
/*     */       }
/*     */     }
/* 130 */     in.close();
/*     */     
/* 132 */     if (syntaxError) {
/* 133 */       return new LinkedHashMap();
/*     */     }
/* 135 */     return map;
/*     */   }
/*     */   
/*     */   private static void Print(String Jogador) {
/* 139 */     System.out.println("[NAMETAG CONFIG] " + Jogador);
/*     */   }
/*     */   
/*     */   private static void PrintDebug(String Jogador)
/*     */   {
/* 144 */     System.out.println("[NAMETAG CONFIG] " + Jogador);
/*     */   }
/*     */   
/*     */   private static boolean CheckWords(String line) {
/* 148 */     int count = 0;
/* 149 */     Scanner reader = new Scanner(line);
/* 150 */     while (reader.hasNext()) {
/* 151 */       count++;
/* 152 */       reader.next();
/*     */     }
/* 154 */     reader.close();
/* 155 */     if (count >= 4) {
/* 156 */       return false;
/*     */     }
/* 158 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean CheckValue(String rawValue) {
/* 162 */     rawValue = rawValue.trim();
/* 163 */     if (!rawValue.startsWith("\"")) {
/* 164 */       return true;
/*     */     }
/* 166 */     if (!rawValue.endsWith("\"")) {
/* 167 */       return true;
/*     */     }
/* 169 */     return false;
/*     */   }
/*     */   
/*     */   private static String PegarValue(String rawValue) {
/* 173 */     rawValue = rawValue.trim();
/* 174 */     String f1 = "";
/* 175 */     String f2 = "";
/* 176 */     for (int t = 1; t < rawValue.length() - 1; t++) {
/* 177 */       f1 = f1 + rawValue.charAt(t);
/*     */     }
/* 179 */     for (int t = 0; (t < f1.length()) && (t < 16); t++) {
/* 180 */       f2 = f2 + f1.charAt(t);
/*     */     }
/* 182 */     return f2;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\GroupLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */