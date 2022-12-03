/**
 *  creates two bodies and prints out the pairwise force between them.
 */
public class TestBody {
    public static void main(String[] args){
        checkBody();
    }

    private static void checkBody() {
        System.out.println("Creating the bodies...");
        Body b1 = new Body(1.0,2.0,3.0,4.0,5.0,"jupiter.gif");
        Body b2 = new Body(2.0,3.0,3.0,4.0,5.0,"jupiter.gif");

        double f = b1.calcForceExertedBy(b2);
        System.out.println("the pairwise force between two bodies is: " + f);
    }

    private static void checkStringEquals(String expect, String actual, String label) {
        if(expect.equals(actual)){
            System.out.println("body argument: " + label + "PASS, expected: " + expect + "and you gave: " + actual);
        }
        else
            System.out.println("body argument: " + label + "FAIL, expected: " + expect + "and you gave: " + actual);
    }

    private static void checkEquals(double expect, double actual, String label) {
        if( Double.isNaN(actual) || Double.isInfinite(actual)){
            System.out.println("Body argument error, pls verify");
        }else if(expect == actual){
            System.out.println("body argument: " + label + "PASS, expected: " + expect + "and you gave: " + actual);
        }
        else
            System.out.println("body argument: " + label + "PASS, expected: " + expect + "and you gave: " + actual);
    }

}
