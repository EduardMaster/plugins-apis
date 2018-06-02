package nobody.comandos;

import java.util.ArrayList;
import java.util.Random;

public class KitsAleatorios
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static String Kit()
  {
    ArrayList<String> lista;
    (lista = new ArrayList()).add("Viper");
    lista.add("Stomper");
    lista.add("Ninja");
    lista.add("Specialist");
    lista.add("Turtle");
    lista.add("Poseidon");
    lista.add("Berserker");
    lista.add("Paladino");
    lista.add("Resouper");
    lista.add("Lavaman");
    lista.add("Anchor");
    lista.add("Grappler");
    lista.add("Hulk");
    lista.add("Switcher");
    lista.add("Launcher");
    lista.add("Bomber");
    lista.add("Endermage");
    lista.add("Fireman");
    lista.add("Flash");
    lista.add("Milkman");
    lista.add("Reaper");
    lista.add("Ryu");
    lista.add("Jellyfish");
    lista.add("C4");
    lista.add("Magma");
    lista.add("Spiderman");
    lista.add("Deshfire");
    lista.add("Sonic");
    lista.add("Thor");
    lista.add("Boxer");
    lista.add("Ebola");
    lista.add("Forcefield");
    lista.add("Timelord");
    lista.add("Quickdropper");
    lista.add("Barbarian");
    lista.add("Backpacker");
    lista.add("Phantom");
    lista.add("Avatar");
    lista.add("Rain");
    lista.add("Monk");
    
    return (String)lista.get(new Random().nextInt(lista.size()));
  }
}
