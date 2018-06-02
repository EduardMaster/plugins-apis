package nobody.eventos;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
public class Money {
	
	   public static File Moneys;
       public static FileConfiguration Money;
      
            
       public static void createFile1() {
   		Moneys = new File("plugins/ThatExtreme/Money.yml");
   		Money = YamlConfiguration.loadConfiguration(Moneys);
   		saveMoney();
   	
   	}
      
       public static void saveMoney() {
               //Salvar
                try {
                       Money.save(Moneys);
               } catch (IOException e) {
                       e.printStackTrace();
               }
       }
      
       public static void createMoneyAcc(Player p) {
               //Usa esse método de quando entrar
               //Criar conta do jogador
               if(!Money.contains(p.getName())){
               Money.set(p.getName() , 10);
               saveMoney();
               }
       }
      
       public static int getMoney(Player p){
               return (int)Money.getInt(p.getName());
       }
      
       public static void addMoney(int Qntd, Player p) {
               //Adicionar quantidade
           Money.set(p.getName(), getMoney(p) + Qntd);
               saveMoney();
       }
      
       public static void removeMoney(Player p, int Qntd) {
               //Remover quantidade
               Money.set(p.getName(), getMoney(p) - Qntd);
               saveMoney();
       }

	public static void addMoney(int d, String name) {
		// TODO Auto-generated method stub
		
	}

	public static void removeMoney(String name, int d) {
		// TODO Auto-generated method stub
		
	}

 }
