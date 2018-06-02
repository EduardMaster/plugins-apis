package br.com.alpha.APIs;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import br.com.alpha.MCAlpha;

@SuppressWarnings("unused")
public class RandomFakes {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> fakes = new ArrayList();

	public RandomFakes() {
		fakes.addAll(MCAlpha.mcAlpha.getConfig().getStringList("FakesAleatorios"));
	}

	public static String getFake() {
		if (fakes.size() > 0) {
			return (String) fakes.get(new Random().nextInt(fakes.size())).replace("&", "§");
		}
		return null;
	}

}
