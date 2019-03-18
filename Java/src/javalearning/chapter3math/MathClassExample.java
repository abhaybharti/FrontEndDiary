package javalearning.chapter3math;

/***
  	static double abs(double a) - This method returns the absolute value of a double value.
  	static float abs(float a) -  This method returns the absolute value of a float value.
  	static int abs(int a) -  This method returns the absolute value of an int value.
  	static long abs(long a) - This method returns the absolute value of a long value.
  	static double acos(double a) - This method returns the arc cosine of a value; the returned angle is in the range 0.0 through pi.
  	static double asin(double a) - This method returns the arc sine of a value; the returned angle is in the range -pi/2 through pi/2.
  	static double atan(double a) - This method returns the arc tangent of a value; the returned angle is in the range -pi/2 through pi/2.
  	static double atan2(double y, double x) - This method returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta).
  	static double cbrt(double a) - This method returns the cube root of a double value.
  	static double ceil(double a) - This method returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer.
 	static double copySign(double magnitude, double sign) - This method returns the first floating-point argument with the sign of the second floating-point argument.
  	static float copySign(float magnitude, float sign) - This method returns the first floating-point argument with the sign of the second floating-point argument.
 	static double cos(double a) -  This method returns the trigonometric cosine of an angle.
  	static double cosh(double x) - This method returns the hyperbolic cosine of a double value.
  	static double exp(double a) - This method returns Euler's number e raised to the power of a double value.
  	static double expm1(double x) - This method returns ex -1.
  	static double floor(double a) - This method returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer.
  	static int getExponent(double d) - This method returns the unbiased exponent used in the representation of a double.
  	static int getExponent(float f) - This method returns the unbiased exponent used in the representation of a float.
  	static double hypot(double x, double y) - This method returns sqrt(x2 +y2) without intermediate overflow or underflow.
  	static double IEEEremainder(double f1, double f2) - This method computes the remainder operation on two arguments as prescribed by the IEEE 754 standard.
  	static double log(double a) -  This method returns the natural logarithm (base e) of a double value.
  	static double log10(double a) - This method returns the base 10 logarithm of a double value.
  	static double log1p(double x) - This method returns the natural logarithm of the sum of the argument and 1.
  	static double max(double a, double b) - This method returns the greater of two double values.
  	static float max(float a, float b) - This method returns the greater of two float values.
  	static int max(int a, int b) - This method returns the greater of two int values.
  	static long max(long a, long b) - This method returns the greater of two long values.
  	static double min(double a, double b) - This method returns the smaller of two double values.
  	static float min(float a, float b) - This method returns the smaller of two float values.
  	static int min(int a, int b) - This method returns the smaller of two int values.
  	static long min(long a, long b) - This method returns the smaller of two long values.
  	static double nextAfter(double start, double direction) - This method returns the floating-point number adjacent to the first argument in the direction of the second argument.
  	static float nextAfter(float start, double direction) - This method returns the floating-point number adjacent to the first argument in the direction of the second argument.
  	static double nextUp(double d) - This method returns the floating-point value adjacent to d in the direction of positive infinity.
  	static float nextUp(float f) - This method returns the floating-point value adjacent to f in the direction of positive infinity.
  	static double pow(double a, double b) - This method returns the value of the first argument raised to the power of the second argument.
  	static double random() - This method returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
  	static double rint(double a) - This method returns the double value that is closest in value to the argument and is equal to a mathematical integer.
  	static long round(double a) - This method returns the closest long to the argument.
  	static int round(float a) - This method returns the closest int to the argument.
  	static double scalb(double d, int scaleFactor) - This method returns d × 2scaleFactor rounded as if performed by a single correctly rounded floating-point multiply to a member of the double value set.
  	static float scalb(float f, int scaleFactor) - This method return f × 2scaleFactor rounded as if performed by a single correctly rounded floating-point multiply to a member of the float value set.
  	static double signum(double d) - This method returns the signum function of the argument; zero if the argument is zero, 1.0 if the argument is greater than zero, -1.0 if the argument is less than zero.
  	static float signum(float f) - This method returns the signum function of the argument; zero if the argument is zero, 1.0f if the argument is greater than zero, -1.0f if the argument is less than zero.
  	static double sin(double a) - This method returns the hyperbolic sine of a double value.
  	static double sinh(double x) - This method Returns the hyperbolic sine of a double value.
  	static double sqrt(double a) - This method returns the correctly rounded positive square root of a double value.
  	static double tan(double a) - This method returns the trigonometric tangent of an angle.r
  	static double tanh(double x) - This method returns the hyperbolic tangent of a double value.
  	static double toDegrees(double angrad) - This method converts an angle measured in radians to an approximately equivalent angle measured in degrees.
  	static double toRadians(double angdeg) - This method converts an angle measured in degrees to an approximately equivalent angle measured in radians.
  	static double ulp(double d) - This method returns the size of an ulp of the argument.
  	static double ulp(float f) - This method returns the size of an ulp of the argument.
 */

public class MathClassExample {

    public static void main(String args[]){
      System.out.println(Math.max(5,7));
      System.out.println(Math.min(5,7));
    }
}
