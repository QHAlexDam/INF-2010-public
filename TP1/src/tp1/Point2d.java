package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // TODO creer un point en 2d avec 2 donnees
    public Point2d(Double x, Double y) {
    	super(new Double[]  {x,y});
    }

	// TODO creer un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector) {
        super(new Double[] {vector[0],vector[1]});
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // TODO prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d translate(Double[] translateVector) {
    	Point2d point = this.clone();
    	point.vector[X] += translateVector[X];
    	point.vector[Y] += translateVector[Y];
        return point;
    }

    // TODO prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
    	Point2d point = this.clone();
    	point.vector[X] += translateVector.X();
    	point.vector[Y] += translateVector.Y();
        return point;
    }

    // TODO prendre un vecteur de donnees et appliquer la rotation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
    	Point2d point = this.clone();
    	point.vector[X] = rotationMatrix[X][X] * X() + rotationMatrix[X][Y] * Y();
    	point.vector[Y] = rotationMatrix[Y][X] * X() + rotationMatrix[Y][Y] * Y();
        return point;
    }

    // TODO prendre un angle de rotation, creer une matrice et appliquer la rotation.
    public Point2d rotate(Double angle) {
    	Point2d point = this.clone();
    	point.vector[X] = X() * Math.cos(angle) - Y() * Math.sin(angle);
    	point.vector[Y] = X() * Math.sin(angle) + Y() * Math.cos(angle);
    	return point;
    }

    // TODO prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
    	Point2d point = this.clone();
    	point.vector[X] /= divider;
    	point.vector[Y] /= divider;
        return point;
    }

    // TODO prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
    	Point2d point = this.clone();
    	point.vector[X] *= multiplier;
    	point.vector[Y] *= multiplier;
        return point;
    }

    // TODO prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
    	Point2d point = this.clone();
    	point.vector[X] += adder;
    	point.vector[Y] += adder;
        return point;
    }

    // TODO creer un nouveau point.
    @Override
    public Point2d clone() {
    	Point2d point = new Point2d(vector);
        return point;
    }
}
