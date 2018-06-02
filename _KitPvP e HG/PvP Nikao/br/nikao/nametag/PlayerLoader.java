/*     */ package br.nikao.nametag;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Scanner;
/*     */ import java.util.Set;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class PlayerLoader
/*     */ {
/*     */   private static final String PREFIX = "[NAMETAG CONFIG] ";
/*  16 */   private static String path = null;
/*     */   
/*     */   public static LinkedHashMap<String, LinkedHashMap<String, String>> load(JavaPlugin plugin) {
/*  19 */     String folder = "plugins/" + plugin.getName();
/*  20 */     File folderFile = new File(folder);
/*  21 */     if (!folderFile.exists()) {
/*  22 */       folderFile.mkdir();
/*     */     }
/*  24 */     path = "plugins/" + plugin.getName() + "/tags.txt";
/*  25 */     File source = new File(path);
/*  26 */     if (source.exists()) {
/*  27 */       return loadConfig();
/*     */     }
/*     */     try {
/*  30 */       source.createNewFile();
/*     */     } catch (IOException e) {
/*  32 */       print("Failed to create config file: ");
/*  33 */       e.printStackTrace();
/*     */     }
/*  35 */     return generateConfig(source, plugin);
/*     */   }
/*     */   
/*     */   static void addPlayer(String name, String operation, String value) {
/*  39 */     ArrayList<String> buffer = new ArrayList();
/*  40 */     File file = new File(path);
/*  41 */     Scanner in = null;
/*  42 */     PrintWriter out = null;
/*  43 */     value = value.replace("§", "&");
/*     */     try {
/*  45 */       in = new Scanner(new File(path));
/*     */     } catch (FileNotFoundException e) {
/*  47 */       e.printStackTrace();
/*     */     }
/*  49 */     while (in.hasNext()) {
/*  50 */       buffer.add(in.nextLine());
/*     */     }
/*  52 */     in.close();
/*     */     try {
/*  54 */       out = new PrintWriter(file);
/*     */     } catch (FileNotFoundException e) {
/*  56 */       e.printStackTrace(); }
/*     */     String[] arrayOfString;
/*  58 */     int j = (arrayOfString = (String[])buffer.toArray(new String[buffer.size()])).length; for (int i = 0; i < j; i++) { String line = arrayOfString[i];
/*  59 */       out.println(line);
/*     */     }
/*  61 */     out.println(name + " " + operation + " = \"" + value + "\"");
/*  62 */     out.close();
/*     */   }
/*     */   
/*     */   public static void update(String name, String prefix, String suffix) {
/*  66 */     LinkedHashMap<String, String> player = getPlayer(name);
/*     */     
/*  68 */     removePlayer(name, null);
/*  69 */     if ((prefix != null) && (!prefix.isEmpty())) {
/*  70 */       prefix = prefix.replace("§", "&");
/*  71 */       addPlayer(name, "prefix", prefix);
/*  72 */     } else if ((player != null) && (player.get("prefix") != null)) {
/*  73 */       addPlayer(name, "prefix", (String)player.get("prefix"));
/*     */     }
/*  75 */     if ((suffix != null) && (!suffix.isEmpty())) {
/*  76 */       suffix = suffix.replace("§", "&");
/*  77 */       addPlayer(name, "suffix", suffix);
/*  78 */     } else if ((player != null) && (player.get("suffix") != null)) {
/*  79 */       addPlayer(name, "suffix", (String)player.get("suffix"));
/*     */     }
/*     */   }
/*     */   
/*     */   static void overlap(String name, String prefix, String suffix) {
/*  84 */     prefix = prefix.replace("§", "&");
/*  85 */     suffix = suffix.replace("§", "&");
/*  86 */     removePlayer(name, null);
/*  87 */     if ((prefix != null) && (!prefix.isEmpty()))
/*  88 */       addPlayer(name, "prefix", prefix);
/*  89 */     if ((suffix != null) && (!suffix.isEmpty())) {
/*  90 */       addPlayer(name, "suffix", suffix);
/*     */     }
/*     */   }
/*     */   
/*     */   static void removePlayer(String name, String operation) {
/*  95 */     ArrayList<String> buffer = new ArrayList();
/*  96 */     File file = new File(path);
/*  97 */     Scanner in = null;
/*  98 */     PrintWriter out = null;
/*     */     try {
/* 100 */       in = new Scanner(new File(path));
/*     */     } catch (FileNotFoundException e) {
/* 102 */       e.printStackTrace();
/*     */     }
/* 104 */     while (in.hasNext()) {
/* 105 */       buffer.add(in.nextLine());
/*     */     }
/* 107 */     in.close();
/*     */     try {
/* 109 */       out = new PrintWriter(file);
/*     */     } catch (FileNotFoundException e) {
/* 111 */       e.printStackTrace(); }
/*     */     String[] arrayOfString;
/* 113 */     int j = (arrayOfString = (String[])buffer.toArray(new String[buffer.size()])).length; for (int i = 0; i < j; i++) { String line = arrayOfString[i];
/* 114 */       Scanner lineScanner = new Scanner(line);
/*     */       
/* 116 */       String lName = lineScanner.next();
/* 117 */       String lOperation = lineScanner.next();
/*     */       
/* 119 */       lineScanner.close();
/*     */       
/* 121 */       boolean skip = false;
/*     */       
/* 123 */       if (name.equals(lName)) {
/* 124 */         if ((operation != null) && (operation.equals(lOperation))) {
/* 125 */           skip = true;
/* 126 */         } else if (operation == null)
/* 127 */           skip = true;
/*     */       }
/* 129 */       if (!skip)
/* 130 */         out.println(line);
/*     */     }
/* 132 */     out.close();
/*     */   }
/*     */   
/*     */   static LinkedHashMap<String, String> getPlayer(String name) {
/* 136 */     LinkedHashMap<String, LinkedHashMap<String, String>> playerMap = loadConfig();
/* 137 */     String[] arrayOfString; int j = (arrayOfString = (String[])playerMap.keySet().toArray(new String[playerMap.keySet().size()])).length; for (int i = 0; i < j; i++) { String key = arrayOfString[i];
/* 138 */       if (key.equals(name)) {
/* 139 */         return (LinkedHashMap)playerMap.get(key);
/*     */       }
/*     */     }
/* 142 */     return null;
/*     */   }
/*     */   
/*     */   private static LinkedHashMap<String, LinkedHashMap<String, String>> generateConfig(File target, JavaPlugin plugin) {
/* 146 */     PrintWriter out = null;
/*     */     try {
/* 148 */       out = new PrintWriter(target);
/*     */     } catch (FileNotFoundException e) {
/* 150 */       e.printStackTrace();
/*     */     }
/*     */     
/* 153 */     out.close();
/*     */     
/* 155 */     return loadConfig();
/*     */   }
/*     */   
/*     */   private static LinkedHashMap<String, LinkedHashMap<String, String>> loadConfig() {
/* 159 */     File source = new File(path);
/* 160 */     Scanner in = null;
/*     */     try {
/* 162 */       in = new Scanner(source);
/*     */     } catch (FileNotFoundException e) {
/* 164 */       e.printStackTrace();
/*     */     }
/*     */     
/* 167 */     LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap();
/*     */     
/* 169 */     boolean syntaxError = false;
/*     */     
/* 171 */     while (in.hasNext()) {
/* 172 */       String line = in.nextLine();
/* 173 */       if ((!line.trim().startsWith("//")) && (!line.isEmpty())) {
/* 174 */         syntaxError = checkWords(line);
/*     */         
/*     */ 
/*     */ 
/* 178 */         Scanner lineScanner = new Scanner(line);
/*     */         
/* 180 */         String node = lineScanner.next();
/* 181 */         String operation = lineScanner.next();
/* 182 */         String equals = lineScanner.next();
/* 183 */         if (!equals.trim().equals("="))
/*     */         {
/* 185 */           syntaxError = true;
/* 186 */           break;
/*     */         }
/* 188 */         String rawValue = lineScanner.nextLine();
/* 189 */         syntaxError = checkValue(rawValue);
/* 190 */         if (syntaxError) {
/*     */           break;
/*     */         }
/* 193 */         String value = getValue(rawValue);
/*     */         
/* 195 */         LinkedHashMap<String, String> entry = new LinkedHashMap();
/*     */         
/* 197 */         if (map.get(node) != null) {
/* 198 */           entry = (LinkedHashMap)map.get(node);
/*     */         }
/*     */         
/* 201 */         entry.put(operation.toLowerCase(), value);
/*     */         
/* 203 */         if (map.get(node) == null) {
/* 204 */           map.put(node, entry);
/*     */         }
/* 206 */         lineScanner.close();
/*     */       }
/*     */     }
/* 209 */     in.close();
/*     */     
/* 211 */     if (syntaxError)
/* 212 */       return new LinkedHashMap();
/* 213 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void print(String p) {}
/*     */   
/*     */ 
/*     */   private static void printDebug(String p) {}
/*     */   
/*     */   private static boolean checkWords(String line)
/*     */   {
/* 224 */     int count = 0;
/* 225 */     Scanner reader = new Scanner(line);
/* 226 */     while (reader.hasNext()) {
/* 227 */       count++;
/* 228 */       reader.next();
/*     */     }
/* 230 */     reader.close();
/* 231 */     if (count >= 4) {
/* 232 */       return false;
/*     */     }
/* 234 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean checkValue(String rawValue) {
/* 238 */     rawValue = rawValue.trim();
/* 239 */     if (!rawValue.startsWith("\""))
/* 240 */       return true;
/* 241 */     if (!rawValue.endsWith("\""))
/* 242 */       return true;
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   private static String getValue(String rawValue) {
/* 247 */     rawValue = rawValue.trim();
/* 248 */     String f1 = "";
/* 249 */     String f2 = "";
/* 250 */     for (int t = 1; t < rawValue.length() - 1; t++) {
/* 251 */       f1 = f1 + rawValue.charAt(t);
/*     */     }
/* 253 */     for (int t = 0; (t < f1.length()) && (t < 16); t++) {
/* 254 */       f2 = f2 + f1.charAt(t);
/*     */     }
/* 256 */     return f2;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\PlayerLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */