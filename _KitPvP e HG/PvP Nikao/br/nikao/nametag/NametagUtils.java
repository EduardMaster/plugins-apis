/*     */ package br.nikao.nametag;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class NametagUtils
/*     */ {
/*     */   public static String formatColors(String str) {
/*   8 */     char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'n', 'r', 'l', 'k', 'o', 'm' };
/*   9 */     char[] array = str.toCharArray();
/*  10 */     for (int t = 0; t < array.length - 1; t++) {
/*  11 */       if (array[t] == '&') { char[] arrayOfChar1;
/*  12 */         int j = (arrayOfChar1 = chars).length; for (int i = 0; i < j; i++) { char c = arrayOfChar1[i];
/*  13 */           if (c == array[(t + 1)]) {
/*  14 */             array[t] = '§';
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  19 */     return new String(array);
/*     */   }
/*     */   
/*     */   public static void box(String[] paragraph, String title) {
/*  23 */     ArrayList<String> buffer = new ArrayList();
/*  24 */     String at = "";
/*     */     
/*  26 */     int side1 = (int)Math.round(25.0D - (title.length() + 4) / 2.0D);
/*  27 */     int side2 = (int)(26.0D - (title.length() + 4) / 2.0D);
/*  28 */     at = at + '+';
/*  29 */     for (int t = 0; t < side1; t++) {
/*  30 */       at = at + '-';
/*     */     }
/*  32 */     at = at + "{ ";
/*  33 */     at = at + title;
/*  34 */     at = at + " }";
/*  35 */     for (int t = 0; t < side2; t++) {
/*  36 */       at = at + '-';
/*     */     }
/*  38 */     at = at + '+';
/*  39 */     buffer.add(at);
/*  40 */     at = "";
/*  41 */     buffer.add("|                                                   |");
/*  42 */     String[] arrayOfString = paragraph;int j = paragraph.length; for (int i = 0; i < j; i++) { String s = arrayOfString[i];
/*  43 */       at = at + "| ";
/*  44 */       int left = 49;
/*  45 */       for (int t = 0; t < s.length(); t++) {
/*  46 */         at = at + s.charAt(t);
/*  47 */         left--;
/*  48 */         if (left == 0) {
/*  49 */           at = at + " |";
/*  50 */           buffer.add(at);
/*  51 */           at = "";
/*  52 */           at = at + "| ";
/*  53 */           left = 49;
/*     */         }
/*     */       }
/*  56 */       while (left-- > 0) {
/*  57 */         at = at + ' ';
/*     */       }
/*  59 */       at = at + " |";
/*  60 */       buffer.add(at);
/*  61 */       at = "";
/*     */     }
/*  63 */     buffer.add("|                                                   |");
/*  64 */     buffer.add("+---------------------------------------------------+");
/*     */     
/*  66 */     System.out.println(" ");
/*  67 */     j = (arrayOfString = (String[])buffer.toArray(new String[buffer.size()])).length; for (i = 0; i < j; i++) { String line = arrayOfString[i];
/*  68 */       System.out.println(line);
/*     */     }
/*  70 */     System.out.println(" ");
/*     */   }
/*     */   
/*     */   public static String trim(String input) {
/*  74 */     if (input.length() > 16) {
/*  75 */       String temp = input;
/*  76 */       input = "";
/*  77 */       for (int t = 0; t < 16; t++) {
/*  78 */         input = input + temp.charAt(t);
/*     */       }
/*     */     }
/*  81 */     return input;
/*     */   }
/*     */   
/*     */   public static String getValue(String rawValue)
/*     */   {
/*  86 */     if ((!rawValue.startsWith("\"")) || (!rawValue.endsWith("\""))) {
/*  87 */       return rawValue;
/*     */     }
/*  89 */     rawValue = rawValue.trim();
/*  90 */     String f1 = "";
/*  91 */     for (int t = 1; t < rawValue.length() - 1; t++) {
/*  92 */       f1 = f1 + rawValue.charAt(t);
/*     */     }
/*  94 */     return f1;
/*     */   }
/*     */   
/*     */   public static boolean compareVersion(String old, String newer) {
/*  98 */     ArrayList<Integer> oldValues = new ArrayList();
/*  99 */     ArrayList<Integer> newValues = new ArrayList();
/* 100 */     String at = "";
/* 101 */     char[] arrayOfChar; int j = (arrayOfChar = old.toCharArray()).length; for (int i = 0; i < j; i++) { char c = arrayOfChar[i];
/* 102 */       if (c != '.') {
/* 103 */         at = at + c;
/*     */       } else {
/*     */         try {
/* 106 */           oldValues.add(Integer.valueOf(Integer.parseInt(at)));
/*     */         } catch (Exception e) {
/* 108 */           return false;
/*     */         }
/* 110 */         at = "";
/*     */       }
/*     */     }
/*     */     try {
/* 114 */       oldValues.add(Integer.valueOf(Integer.parseInt(at)));
/*     */     } catch (Exception e) {
/* 116 */       return false;
/*     */     }
/* 118 */     at = "";
/* 119 */     j = (arrayOfChar = newer.toCharArray()).length; for (i = 0; i < j; i++) { char c = arrayOfChar[i];
/* 120 */       if (c != '.') {
/* 121 */         at = at + c;
/*     */       } else {
/*     */         try {
/* 124 */           newValues.add(Integer.valueOf(Integer.parseInt(at)));
/*     */         } catch (Exception e) {
/* 126 */           return false;
/*     */         }
/* 128 */         at = "";
/*     */       }
/*     */     }
/*     */     try {
/* 132 */       newValues.add(Integer.valueOf(Integer.parseInt(at)));
/*     */     } catch (Exception e) {
/* 134 */       return false;
/*     */     }
/* 136 */     int size = oldValues.size();
/* 137 */     boolean defaultToOld = true;
/* 138 */     if (newValues.size() < size) {
/* 139 */       size = newValues.size();
/* 140 */       defaultToOld = false;
/*     */     }
/* 142 */     for (int t = 0; t < size; t++) {
/* 143 */       if (((Integer)oldValues.get(t)).intValue() < ((Integer)newValues.get(t)).intValue())
/* 144 */         return true;
/* 145 */       if (((Integer)oldValues.get(t)).intValue() > ((Integer)newValues.get(t)).intValue()) {
/* 146 */         return false;
/*     */       }
/*     */     }
/* 149 */     if (oldValues.size() == newValues.size()) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (defaultToOld) {
/* 153 */       return true;
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\nametag\NametagUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */