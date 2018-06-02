/*   1:    */ package br.com.alpha.Habilidades;
/*   2:    */ 
/*   3:    */ import java.util.HashMap;

/*   5:    */ import org.bukkit.Material;
/*   6:    */ import org.bukkit.block.Block;
/*   7:    */ import org.bukkit.block.BlockFace;
/*   8:    */ import org.bukkit.entity.Player;
/*   9:    */ import org.bukkit.event.EventHandler;
/*  10:    */ import org.bukkit.event.Listener;
/*  12:    */ import org.bukkit.event.block.BlockBreakEvent;
/*  13:    */ import org.bukkit.event.player.PlayerInteractEvent;
/*  14:    */ import org.bukkit.inventory.ItemStack;
/*  15:    */ import org.bukkit.potion.PotionEffect;
/*  16:    */ import org.bukkit.potion.PotionEffectType;

import br.com.alpha.ENUMs.KitsEnum;
/*  17:    */ 
/*  18:    */ public class Miner
/*  19:    */   implements Listener
/*  20:    */ {
/*  21: 20 */   @SuppressWarnings({ "unchecked", "rawtypes" })
private HashMap<Player, Long> cookieExpires = new HashMap();
/*  22: 21 */   public int delayForEatMinerApple = 1000;
/*  23:    */   
/*  24:    */   @EventHandler
/*  25:    */   public void onMiner2(BlockBreakEvent event)
/*  26:    */   {
/*  27: 26 */     Player minerplayer = event.getPlayer();
/*  28: 27 */     if ((KitsEnum.getKit(minerplayer) == KitsEnum.MINER) && 
/*  29: 28 */       (event.getBlock().getType() == Material.COAL_ORE))
/*  30:    */     {
/*  31: 30 */       Block u = event.getBlock().getRelative(BlockFace.UP);
/*  32: 31 */       while (u.getType() == Material.COAL_ORE)
/*  33:    */       {
/*  34: 33 */         u.breakNaturally();
/*  35: 34 */         u = u.getRelative(BlockFace.UP);
/*  36:    */       }
/*  37: 36 */       Block d = event.getBlock().getRelative(BlockFace.DOWN);
/*  38: 37 */       while (d.getType() == Material.COAL_ORE)
/*  39:    */       {
/*  40: 39 */         d.breakNaturally();
/*  41: 40 */         d = d.getRelative(BlockFace.DOWN);
/*  42:    */       }
/*  43: 42 */       Block e = event.getBlock().getRelative(BlockFace.EAST);
/*  44: 43 */       while (e.getType() == Material.COAL_ORE)
/*  45:    */       {
/*  46: 45 */         e.breakNaturally();
/*  47: 46 */         e = e.getRelative(BlockFace.EAST);
/*  48:    */       }
/*  49: 48 */       Block ene = event.getBlock().getRelative(BlockFace.EAST_NORTH_EAST);
/*  50: 49 */       while (ene.getType() == Material.COAL_ORE)
/*  51:    */       {
/*  52: 51 */         ene.breakNaturally();
/*  53: 52 */         ene = ene.getRelative(BlockFace.EAST_NORTH_EAST);
/*  54:    */       }
/*  55: 54 */       Block ese = event.getBlock().getRelative(BlockFace.EAST_SOUTH_EAST);
/*  56: 55 */       while (ese.getType() == Material.COAL_ORE)
/*  57:    */       {
/*  58: 57 */         ese.breakNaturally();
/*  59: 58 */         ese = ese.getRelative(BlockFace.EAST_SOUTH_EAST);
/*  60:    */       }
/*  61: 60 */       Block north = event.getBlock().getRelative(BlockFace.NORTH);
/*  62: 61 */       while (north.getType() == Material.COAL_ORE)
/*  63:    */       {
/*  64: 63 */         north.breakNaturally();
/*  65: 64 */         north = north.getRelative(BlockFace.NORTH);
/*  66:    */       }
/*  67: 66 */       Block ne = event.getBlock().getRelative(BlockFace.NORTH_EAST);
/*  68: 67 */       while (ne.getType() == Material.COAL_ORE)
/*  69:    */       {
/*  70: 69 */         ne.breakNaturally();
/*  71: 70 */         ne = ne.getRelative(BlockFace.NORTH_EAST);
/*  72:    */       }
/*  73: 72 */       Block nne = event.getBlock().getRelative(BlockFace.NORTH_NORTH_EAST);
/*  74: 73 */       while (nne.getType() == Material.COAL_ORE)
/*  75:    */       {
/*  76: 75 */         nne.breakNaturally();
/*  77: 76 */         nne = nne.getRelative(BlockFace.NORTH_NORTH_EAST);
/*  78:    */       }
/*  79: 78 */       Block nnw = event.getBlock().getRelative(BlockFace.NORTH_NORTH_WEST);
/*  80: 79 */       while (nnw.getType() == Material.COAL_ORE)
/*  81:    */       {
/*  82: 81 */         nnw.breakNaturally();
/*  83: 82 */         nnw = nnw.getRelative(BlockFace.NORTH_NORTH_WEST);
/*  84:    */       }
/*  85: 84 */       Block nw = event.getBlock().getRelative(BlockFace.NORTH_WEST);
/*  86: 85 */       while (nw.getType() == Material.COAL_ORE)
/*  87:    */       {
/*  88: 87 */         nw.breakNaturally();
/*  89: 88 */         nw = nw.getRelative(BlockFace.NORTH_WEST);
/*  90:    */       }
/*  91: 90 */       Block s = event.getBlock().getRelative(BlockFace.SELF);
/*  92: 91 */       while (s.getType() == Material.COAL_ORE)
/*  93:    */       {
/*  94: 93 */         s.breakNaturally();
/*  95: 94 */         s = s.getRelative(BlockFace.SELF);
/*  96:    */       }
/*  97: 96 */       Block south = event.getBlock().getRelative(BlockFace.SOUTH);
/*  98: 97 */       while (south.getType() == Material.COAL_ORE)
/*  99:    */       {
/* 100: 99 */         south.breakNaturally();
/* 101:100 */         south = south.getRelative(BlockFace.SOUTH);
/* 102:    */       }
/* 103:102 */       Block se = event.getBlock().getRelative(BlockFace.SOUTH_EAST);
/* 104:103 */       while (se.getType() == Material.COAL_ORE)
/* 105:    */       {
/* 106:105 */         se.breakNaturally();
/* 107:106 */         se = se.getRelative(BlockFace.SOUTH_EAST);
/* 108:    */       }
/* 109:108 */       Block sse = event.getBlock().getRelative(BlockFace.SOUTH_SOUTH_EAST);
/* 110:109 */       while (sse.getType() == Material.COAL_ORE)
/* 111:    */       {
/* 112:111 */         sse.breakNaturally();
/* 113:112 */         sse = sse.getRelative(BlockFace.SOUTH_SOUTH_EAST);
/* 114:    */       }
/* 115:114 */       Block ssw = event.getBlock().getRelative(BlockFace.SOUTH_SOUTH_WEST);
/* 116:115 */       while (ssw.getType() == Material.COAL_ORE)
/* 117:    */       {
/* 118:117 */         ssw.breakNaturally();
/* 119:118 */         ssw = ssw.getRelative(BlockFace.SOUTH_SOUTH_WEST);
/* 120:    */       }
/* 121:120 */       Block sw = event.getBlock().getRelative(BlockFace.SOUTH_WEST);
/* 122:121 */       while (sw.getType() == Material.COAL_ORE)
/* 123:    */       {
/* 124:123 */         sw.breakNaturally();
/* 125:124 */         sw = sw.getRelative(BlockFace.SOUTH_WEST);
/* 126:    */       }
/* 127:126 */       Block w = event.getBlock().getRelative(BlockFace.WEST);
/* 128:127 */       while (w.getType() == Material.COAL_ORE)
/* 129:    */       {
/* 130:129 */         w.breakNaturally();
/* 131:130 */         w = w.getRelative(BlockFace.WEST);
/* 132:    */       }
/* 133:132 */       Block wnw = event.getBlock().getRelative(BlockFace.WEST_NORTH_WEST);
/* 134:133 */       while (wnw.getType() == Material.COAL_ORE)
/* 135:    */       {
/* 136:135 */         wnw.breakNaturally();
/* 137:136 */         wnw = wnw.getRelative(BlockFace.WEST_NORTH_WEST);
/* 138:    */       }
/* 139:138 */       Block wsw = event.getBlock().getRelative(BlockFace.WEST_SOUTH_WEST);
/* 140:139 */       while (wsw.getType() == Material.COAL_ORE)
/* 141:    */       {
/* 142:141 */         wsw.breakNaturally();
/* 143:142 */         wsw = wsw.getRelative(BlockFace.WEST_SOUTH_WEST);
/* 144:    */       }
/* 145:    */     }
/* 146:    */   }
/* 147:    */   
/* 148:    */   @EventHandler
/* 149:    */   public void onMiner(BlockBreakEvent event)
/* 150:    */   {
/* 151:150 */     Player minerplayer = event.getPlayer();
/* 152:151 */     if ((KitsEnum.getKit(minerplayer)==KitsEnum.MINER) && 
/* 153:152 */       (event.getBlock().getType() == Material.IRON_ORE))
/* 154:    */     {
/* 155:154 */       Block u = event.getBlock().getRelative(BlockFace.UP);
/* 156:155 */       while (u.getType() == Material.IRON_ORE)
/* 157:    */       {
/* 158:157 */         u.breakNaturally();
/* 159:158 */         u = u.getRelative(BlockFace.UP);
/* 160:    */       }
/* 161:160 */       Block d = event.getBlock().getRelative(BlockFace.DOWN);
/* 162:161 */       while (d.getType() == Material.IRON_ORE)
/* 163:    */       {
/* 164:163 */         d.breakNaturally();
/* 165:164 */         d = d.getRelative(BlockFace.DOWN);
/* 166:    */       }
/* 167:166 */       Block e = event.getBlock().getRelative(BlockFace.EAST);
/* 168:167 */       while (e.getType() == Material.IRON_ORE)
/* 169:    */       {
/* 170:169 */         e.breakNaturally();
/* 171:170 */         e = e.getRelative(BlockFace.EAST);
/* 172:    */       }
/* 173:172 */       Block ene = event.getBlock().getRelative(BlockFace.EAST_NORTH_EAST);
/* 174:173 */       while (ene.getType() == Material.IRON_ORE)
/* 175:    */       {
/* 176:175 */         ene.breakNaturally();
/* 177:176 */         ene = ene.getRelative(BlockFace.EAST_NORTH_EAST);
/* 178:    */       }
/* 179:178 */       Block ese = event.getBlock().getRelative(BlockFace.EAST_SOUTH_EAST);
/* 180:179 */       while (ese.getType() == Material.IRON_ORE)
/* 181:    */       {
/* 182:181 */         ese.breakNaturally();
/* 183:182 */         ese = ese.getRelative(BlockFace.EAST_SOUTH_EAST);
/* 184:    */       }
/* 185:184 */       Block north = event.getBlock().getRelative(BlockFace.NORTH);
/* 186:185 */       while (north.getType() == Material.IRON_ORE)
/* 187:    */       {
/* 188:187 */         north.breakNaturally();
/* 189:188 */         north = north.getRelative(BlockFace.NORTH);
/* 190:    */       }
/* 191:190 */       Block ne = event.getBlock().getRelative(BlockFace.NORTH_EAST);
/* 192:191 */       while (ne.getType() == Material.IRON_ORE)
/* 193:    */       {
/* 194:193 */         ne.breakNaturally();
/* 195:194 */         ne = ne.getRelative(BlockFace.NORTH_EAST);
/* 196:    */       }
/* 197:196 */       Block nne = event.getBlock().getRelative(BlockFace.NORTH_NORTH_EAST);
/* 198:197 */       while (nne.getType() == Material.IRON_ORE)
/* 199:    */       {
/* 200:199 */         nne.breakNaturally();
/* 201:200 */         nne = nne.getRelative(BlockFace.NORTH_NORTH_EAST);
/* 202:    */       }
/* 203:202 */       Block nnw = event.getBlock().getRelative(BlockFace.NORTH_NORTH_WEST);
/* 204:203 */       while (nnw.getType() == Material.IRON_ORE)
/* 205:    */       {
/* 206:205 */         nnw.breakNaturally();
/* 207:206 */         nnw = nnw.getRelative(BlockFace.NORTH_NORTH_WEST);
/* 208:    */       }
/* 209:208 */       Block nw = event.getBlock().getRelative(BlockFace.NORTH_WEST);
/* 210:209 */       while (nw.getType() == Material.IRON_ORE)
/* 211:    */       {
/* 212:211 */         nw.breakNaturally();
/* 213:212 */         nw = nw.getRelative(BlockFace.NORTH_WEST);
/* 214:    */       }
/* 215:214 */       Block s = event.getBlock().getRelative(BlockFace.SELF);
/* 216:215 */       while (s.getType() == Material.IRON_ORE)
/* 217:    */       {
/* 218:217 */         s.breakNaturally();
/* 219:218 */         s = s.getRelative(BlockFace.SELF);
/* 220:    */       }
/* 221:220 */       Block south = event.getBlock().getRelative(BlockFace.SOUTH);
/* 222:221 */       while (south.getType() == Material.IRON_ORE)
/* 223:    */       {
/* 224:223 */         south.breakNaturally();
/* 225:224 */         south = south.getRelative(BlockFace.SOUTH);
/* 226:    */       }
/* 227:226 */       Block se = event.getBlock().getRelative(BlockFace.SOUTH_EAST);
/* 228:227 */       while (se.getType() == Material.IRON_ORE)
/* 229:    */       {
/* 230:229 */         se.breakNaturally();
/* 231:230 */         se = se.getRelative(BlockFace.SOUTH_EAST);
/* 232:    */       }
/* 233:232 */       Block sse = event.getBlock().getRelative(BlockFace.SOUTH_SOUTH_EAST);
/* 234:233 */       while (sse.getType() == Material.IRON_ORE)
/* 235:    */       {
/* 236:235 */         sse.breakNaturally();
/* 237:236 */         sse = sse.getRelative(BlockFace.SOUTH_SOUTH_EAST);
/* 238:    */       }
/* 239:238 */       Block ssw = event.getBlock().getRelative(BlockFace.SOUTH_SOUTH_WEST);
/* 240:239 */       while (ssw.getType() == Material.IRON_ORE)
/* 241:    */       {
/* 242:241 */         ssw.breakNaturally();
/* 243:242 */         ssw = ssw.getRelative(BlockFace.SOUTH_SOUTH_WEST);
/* 244:    */       }
/* 245:244 */       Block sw = event.getBlock().getRelative(BlockFace.SOUTH_WEST);
/* 246:245 */       while (sw.getType() == Material.IRON_ORE)
/* 247:    */       {
/* 248:247 */         sw.breakNaturally();
/* 249:248 */         sw = sw.getRelative(BlockFace.SOUTH_WEST);
/* 250:    */       }
/* 251:250 */       Block w = event.getBlock().getRelative(BlockFace.WEST);
/* 252:251 */       while (w.getType() == Material.IRON_ORE)
/* 253:    */       {
/* 254:253 */         w.breakNaturally();
/* 255:254 */         w = w.getRelative(BlockFace.WEST);
/* 256:    */       }
/* 257:256 */       Block wnw = event.getBlock().getRelative(BlockFace.WEST_NORTH_WEST);
/* 258:257 */       while (wnw.getType() == Material.IRON_ORE)
/* 259:    */       {
/* 260:259 */         wnw.breakNaturally();
/* 261:260 */         wnw = wnw.getRelative(BlockFace.WEST_NORTH_WEST);
/* 262:    */       }
/* 263:262 */       Block wsw = event.getBlock().getRelative(BlockFace.WEST_SOUTH_WEST);
/* 264:263 */       while (wsw.getType() == Material.IRON_ORE)
/* 265:    */       {
/* 266:265 */         wsw.breakNaturally();
/* 267:266 */         wsw = wsw.getRelative(BlockFace.WEST_SOUTH_WEST);
/* 268:    */       }
/* 269:    */     }
/* 270:    */   }
/* 271:    */   
/* 272:    */   @SuppressWarnings("deprecation")
@EventHandler
/* 273:    */   public void onChomp(PlayerInteractEvent event)
/* 274:    */   {
/* 275:275 */     if (event.getAction().name().contains("RIGHT"))
/* 276:    */     {
/* 277:277 */       Player p = event.getPlayer();
/* 278:278 */       if (((!this.cookieExpires.containsKey(p)) || (((Long)this.cookieExpires.get(p)).longValue() < System.currentTimeMillis())) && 
/* 279:279 */         (KitsEnum.getKit(p)==KitsEnum.MINER) && (event.getItem() != null) && (event.getItem().getType() == Material.APPLE)) {
/* 281:281 */         event.setCancelled(true);
/* 282:282 */         p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200, 1), true);
/* 283:283 */         event.getItem().setAmount(event.getItem().getAmount() - 1);
/* 284:284 */         if (event.getItem().getAmount() == 0) {
/* 285:285 */           p.setItemInHand(new ItemStack(0));
/* 286:    */         }
/* 287:287 */         p.updateInventory();
/* 288:288 */         this.cookieExpires.put(p, Long.valueOf(System.currentTimeMillis() + this.delayForEatMinerApple));
/* 289:    */       }
/* 290:    */     }
/* 291:    */   }
/* 292:    */ }