package nobody.eventos;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
public class MoneyRank {
	
	   public static File Killss;
       public static FileConfiguration Kills;
      
            
       public static void createFile1() {
   		Killss = new File("plugins/Sexo/Kills.yml");
   		Kills = YamlConfiguration.loadConfiguration(Killss);
   		saveKills();
   	
   	}
      
       public static void saveKills() {
               //Salvar
                try {
                       Kills.save(Killss);
               } catch (IOException e) {
                       e.printStackTrace();
               }
       }
      
       public static void createKillsAcc(Player p) {
               //Usa esse método de quando entrar
               //Criar conta do jogador
               if(!Kills.contains(p.getName())){
               Kills.set(p.getName() , 10);
               saveKills();
               }
       }
      
       public static int getKills(Player p){
               return (int)Kills.getInt(p.getName());
       }
      
       public static void addKills(int Qntd, Player p) {
               //Adicionar quantidade
           Kills.set(p.getName(), getKills(p) + Qntd);
               saveKills();
       }
      
       public static void removeKills(Player p, int Qntd) {
               //Remover quantidade
               Kills.set(p.getName(), getKills(p) - Qntd);
               saveKills();
       }
		

	public static void removeKills(String name, int d) {
		// TODO Auto-generated method stub
		
	}

 }
