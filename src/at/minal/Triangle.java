package at.minal;

/*
Write a program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input,
and return whether the triangle is equilateral, isosceles or scalene.
We are looking for solutions that showcase problem solving skills and structural considerations that can be applied to
larger and potentially more complex problem domains. Pay special attention to tests, readability of code and error cases.
The resulting code will be used as the basis for broader discussions during the interview.
Therefore you should be prepared to discuss your choices.
 */
public class Triangle {
    double sideA;
    double sideB;
    double sideC;
    TriangleTypes type;

    public Triangle(double sideA, double sideB, double sideC) throws InvalidTriangleException {
        if(sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new InvalidTriangleException("The sides "+sideA+", "+sideB+" and "+sideC+" cannot be negative or zero.");
        }
        if(sideA+sideB <= sideC || sideA+sideC <= sideB || sideB+sideC <= sideA ){
            throw new InvalidTriangleException("The sides "+sideA+", "+sideB+" and "+sideC+" do not form a triangle.");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        setType();
    }

    public TriangleTypes getType(){
        return type;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    private void setType(){
        if(sideA == sideB && sideA == sideC){
            type = TriangleTypes.EQUILATERAL;
        }else if(sideA == sideB || sideA == sideC || sideB == sideC){
            type = TriangleTypes.ISOSCELES;
        } else {
            type = TriangleTypes.SCALENE;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
