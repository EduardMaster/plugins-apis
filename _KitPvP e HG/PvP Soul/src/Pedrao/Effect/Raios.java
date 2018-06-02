package Pedrao.Effect;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import Pedrao.Main;

public class Raios {
	
	public static double cos(double i){ 
		return java.lang.Math.cos(i);
		}
    
	public static double sin(double i){
		return java.lang.Math.sin(i); 
		}
	
    public static void coneEffect(final Location loc){
        new BukkitRunnable(){
        	    
                double phi = 0;
                public void run(){
                        phi = phi + Math.PI/8;                                 
                        double x, y, z;                
                       
                        for (double t = 0; t <= 2*Math.PI; t = t + Math.PI/16){
                                for (double i = 0; i <= 1; i = i + 1){
                                        x = 0.4*(2*Math.PI-t)*0.5*cos(t + phi + i*Math.PI);
                                        y = 0.5*t;
                                        z = 0.4*(2*Math.PI-t)*0.5*sin(t + phi + i*Math.PI);
                                        loc.add(x, y, z);
                                        ParticleEffect.HEART.display(loc, 0, 0, 0, 0, 1);
                                        loc.subtract(x,y,z);                                    
                                }                       
                        }              
                       
                        if(phi > 10*Math.PI){                                          
                                this.cancel();
                        }
                }      
        }.runTaskTimer(Main.instance, 0, 3); 

    }
	public static void kitaguala(final Location loc) {
		new BukkitRunnable() {
			double phi = 0;
			public void run() {
				phi = phi + Math.PI/10;
				for (double t = 0; t <= 5*Math.PI; t += Math.PI/40) {
					double r = 1.2;
					double x = r*cos(t)*sin(phi);
					double y = r*cos(phi) + 1.2;
					double z = r*sin(t)*sin(phi);
					loc.add(x, y, z);
					ParticleEffect.DRIP_WATER.display(loc, 0, 0, 0, 0, 1);

					loc.subtract(x, y, z);
				}

				if (phi > Math.PI) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.instance, 0, 1);
	}
	
	public static void FireBender(final Location loc) {
		new BukkitRunnable() {
			double phi = 0;
			public void run() {
				phi = phi + Math.PI/10;
				for (double t = 0; t <= 5*Math.PI; t += Math.PI/40) {
					double r = 1.2;
					double x = r*cos(t)*sin(phi);
					double y = r*cos(phi) + 1.2;
					double z = r*sin(t)*sin(phi);
					loc.add(x, y, z);
					ParticleEffect.FLAME.display(loc, 0, 0, 0, 0, 1);

					loc.subtract(x, y, z);
				}

				if (phi > Math.PI) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.instance, 0, 1);
	}
}