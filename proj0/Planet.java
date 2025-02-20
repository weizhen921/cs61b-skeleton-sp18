public class Planet {

    private static final double g=6.67E-11;

    /** creating a basic version of the Planet class with the following 6 instance variables:
     * they must be explicitly set to public via the public keyword. */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    /** add in two Planet constructors that can initialize an instance of the Planet class */
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    // adding a method called calcDistance that calculates the distance between two Planets
    // take in a single Planet and should return a double equal to the distance between the supplied Planet and the Planet that is doing the calculation
    public double calcDistance(Planet b){
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        return r;
    }

    public double calcForceExertedBy(Planet b){
        double r = calcDistance(b);
        double f = (g * this.mass * b.mass) / (r * r);
        return f;
    }

    public double calcForceExertedByX(Planet b){
        double r = calcDistance(b);
        double f = calcForceExertedBy(b);
        double fx = f * (b.xxPos - this.xxPos) / r;
        return fx;
    }

    public double calcForceExertedByY(Planet b){
        double r = calcDistance(b);
        double f = calcForceExertedBy(b);
        double fy = f * (b.yyPos - this.yyPos) / r;
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] b){
        double nfx = 0.0;

        for(int i = 0; i< b.length; i++){
            if(this.equals(b[i])){
                continue;
            }
            nfx = nfx + calcForceExertedByX(b[i]);
        }
        return nfx;
    }

    public double calcNetForceExertedByY(Planet[] b){
        double nfx = 0.0;

        for(int i = 0; i< b.length; i++){
            if(this.equals(b[i])){
                continue;
            }
            nfx = nfx + calcForceExertedByY(b[i]);
        }
        return nfx;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + (dt * aX);
        yyVel = yyVel + (dt * aY);
        xxPos = xxPos + (dt * xxVel);
        yyPos = yyPos + (dt * yyVel);
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);

    }

}
