package Net.Hunger.Borda;

public class Border {
  public int radiusSq;
  public int definiteSq;
  public double centerX;
  public double centerZ;
  public double radius;

  public Border(double X, double Z, double Radius) {
    this.centerX = X;
    this.centerZ = Z;
    this.radius = Radius;
  }

  public String toString() {
    return "X: " + this.centerX + " Z: " + this.centerZ + " Radius: " + this.radius;
  }
}