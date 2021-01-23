/**
 * Planet
 *
 * @author Wangkun
 * @create 2021-01-23-15:28
 **/
public class Planet {
    private static final double G=6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double xp, yp, r2;
        xp = this.xxPos - p.xxPos;
        yp = this.yyPos - p.yyPos;
        r2 = xp * xp + yp * yp;
        return Math.sqrt(r2);
    }
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double F = (G * this.mass * p.mass)/(r * r);
        return  F;
    }
    public double calcForceExertedByX(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * (p.xxPos - this.xxPos) / r;
    }
    public double calcForceExertedByY(Planet p){
        double r = calcDistance(p);
        double F = calcForceExertedBy(p);
        return F * (p.yyPos - this.yyPos) / r;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double Fx = 0;
        for (Planet allPlanet : allPlanets) {
            if (this.equals(allPlanet)){
                continue;
            }
            Fx = Fx + calcForceExertedByX(allPlanet);
        }
        return  Fx;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double Fy = 0;
        for (Planet allPlanet : allPlanets) {
            if (this.equals(allPlanet)){
                continue;
            }
            Fy = Fy + calcForceExertedByY(allPlanet);
        }
        return Fy;
    }
    public void update(double dt, double fX, double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        double newxxVel = this.xxVel + dt * aX;
        double newyyVel = this.yyVel + dt * aY;
        this.xxVel = newxxVel;
        this.yyVel = newyyVel;
        this.xxPos = this.xxPos + dt * newxxVel;
        this.yyPos = this.yyPos + dt * newyyVel;
    }
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
