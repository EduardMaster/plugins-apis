package br.com.alpha.ENUMs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public enum KitsEnum {
	 ANCHOR("Anchor", null, Arrays.asList("Não leve knockback!")),
	 ACHILLES("Achilles", null, Arrays.asList("Leve mais dano somente com itens de madeira.")),
	 BACKPACKER("BackPacker", null, Arrays.asList("Tenha uma bolsa com sopas para refill!")),
	 BARBARIAN("Barbarian", null, Arrays.asList("Evolua de espadas até chegar no ultimo nível!")),
	 BOXER("Boxer", null, Arrays.asList("Tenha mais força com seus punhos!")),
	 CANNIBAL("Cannibal", null, Arrays.asList("Dê fome ao bater em seus adversários")),
	 COPYCAT("Copycat", null, Arrays.asList("Copie o kit do player que você matar!")),
	 CRAFTER("Crafter", null, Arrays.asList("Tenha uma furnace e uma crafting table portáteis!")),
	 CULTIVATOR("Cultivator", null, Arrays.asList("Seja um cultivador profissional!")),
	 DEMOMAN("Demoman", null, Arrays.asList("Exploda seus inimigos ao fazer sua plataforma!")),
	 ENDERMAGE("Endermage", null, Arrays.asList("Teleporte os seus inimigos ou amigos até você utilizando o portal!")),
	 FIREMAN("Fireman", null, Arrays.asList("Não leve dano de fogo.")),
	 FISHERMAN("Fisherman", null, Arrays.asList("Teleporte quem você fisgar até você!")),
	 GRANDPA("Grandpa", null, Arrays.asList("Tenha um bastão com knockback 2")),
	 JACKHAMMER("Jackhammer", null, Arrays.asList("Ao quebrar o chão com seu machado, quebre até a bedrock.")),
	 JUMPER("Jumper", null, Arrays.asList("Ganhe 10 enderpeals para te ajudar!")),
	 KANGAROO("Kangaroo", null, Arrays.asList("Seja um canguru.")),
	 LAUNCHER("Launcher", null, Arrays.asList("Ganhe 20 esponjas que ao subir em cima delas, você ganha um impulso.")),
	 LUMBERJACK("Lumberjack", null, Arrays.asList("Quebre todas as madeiras de uma árvore de baixo pra cima.")),
	 MADMAN("Madman", null, Arrays.asList("Dê fraqueza ao chegar perto de seus inimigos")),
	 MINER("Miner", null, Arrays.asList("Quebre todos os minérios ao quebrar somente 1 (Iron,Carvão)")),
	 MONK("Monk", null, Arrays.asList("Tire a espada da hotbar de seu inimigo ao utilizar este kit.")),
	 NINJA("Ninja", null, Arrays.asList("Teleporte-se até o player utilizando shift ao bater nele.")),
	 PHANTOM("Phantom", null, Arrays.asList("Tenha 5 segundos para voar.")),
	 POSEIDON("Poseidon", null, Arrays.asList("Ganhe força na água")),
	 PYRO("Pyro", null, Arrays.asList("Ganhe 1 isqueiro e 5 bolas de fogo para te ajudar.")),
	 REAPER("Reaper", null, Arrays.asList("Dê efeito de wither ao bater nos players usando sua HOE.")),
	 SCOUT("Scout", null, Arrays.asList("Seja um velocista, ganhe 3 poções de velocidade.")),
	 SNAIL("Snail", null, Arrays.asList("Dê lentidão nos players.")),
	 STOMPER("Stomper", null, Arrays.asList("Caia na cabeça dos players e mate-os.")),
	 SWITCHER("Switcher", null, Arrays.asList("Troque de lugar com os players que acertar usando sua bola de neve")),
	 TANK("Tank", null, Arrays.asList("Exploda o local em que matou o player")),
	 TOWER("Tower", null, Arrays.asList("Seja stomper e worm ao mesmo tempo.")),
	 THOR("Thor", null, Arrays.asList("Seja o THOR dos filmes da MARVEL.")),
	 TURTLE("Turtle", null, Arrays.asList("Não leve dano ao ficar no shift, mas também não poderá dar dano.")),
	 URGAL("Urgal", null, Arrays.asList("Ganhe 3 poções de força para usar durante o jogo.")),
	 VIKING("Viking", null, Arrays.asList("Dê diferentes danos com todos os tipos de machado.")),
	 VIPER("Viper", null, Arrays.asList("Dê veneno nos players.")),
	 SPECIALIST("Specialist", null, Arrays.asList("Ao matar ganhe xp, e seja um encantador profissional.")),
	 WORM("Worm", null, Arrays.asList("Seja uma minhoca.")),
	 FORGER("Worm", null, Arrays.asList("Faça minérios instantaneamente.")),
	 NONE("None", null, Arrays.asList("Nada."));
	
	String nome;
	Material item;
	List<String> hability;
	
	KitsEnum(String name, Material item, List<String> hability) {
		this.nome = name;
		this.item = item;
		this.hability = hability;
	}
	public String getName(){
		return this.nome;
	}
	public Material getItem(){
		return this.item;
	}
	public List<String> getHability(){
		return this.hability;
	}
	public static HashMap<Player, KitsEnum> kit = new HashMap<>();
	public static void setKit(Player jogador, KitsEnum kits){
		kit.put(jogador, kits);
	}
	public static void removeKit(Player jogador){
		kit.put(jogador, NONE);
	}
	public static boolean hasKit(Player jogador){
		return kit.containsKey(jogador) || (kit.get(jogador) == NONE);
	}
	public static KitsEnum getKit(Player jogador){
		return kit.get(jogador);
	}
	public static boolean hasItem(KitsEnum kits){
		return kits.getItem() != null;
	}
}