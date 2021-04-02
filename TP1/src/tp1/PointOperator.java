package tp1;

import java.util.*;

import com.sun.javafx.scene.paint.GradientUtils.Point;

public final class PointOperator {
    // TODO appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {
    	for (int i = 0; i < vector.length; i ++) {
    		vector[i] += translateVector[i];
    	}
        return vector;
    }

    // TODO appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {
    	Double[] vectorTemp = new Double[vector.length];
    	for (int i = 0;i < vector.length; i++) {
    		vectorTemp[i] = 0.0;
    	}
    	for (int i = 0; i < vector.length; i ++) {
    		for ( int j = 0; j < vector.length; j ++) {
        		vectorTemp[i] += rotationMatrix[i][j] * vector[j];
    		}
    	}
        return vectorTemp;
    }

    // TODO appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {
    	for (int i = 0; i < vector.length; i ++) {
    		vector[i] /= divider;
    	}
        return vector;
    }

    // TODO appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {
    	for (int i = 0; i < vector.length; i ++) {
    		vector[i] *= multiplier;
    	}
        return vector;
    }

    // TODO appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {
    	for (int i = 0; i < vector.length; i ++) {
    		vector[i] += adder;
    	}
        return vector;
    }

    // TODO retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {
    	Double xMax = -1000.0;
    	Double yMax = -1000.0;
    	for (Point2d point : coords) 
    	{ 
    	    if (xMax < point.X()) {
    	    	xMax = point.X();
    	    }
    	    if (yMax < point.Y()) {
    	    	yMax = point.Y();
    	    }
    	}
    	Point2d point = new Point2d(xMax, yMax);
        return point;
    }

    // TODO retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {
    	Double xMax = 1000.0;
    	Double yMax = 1000.0;
    	for (Point2d point : coords) 
    	{ 
    	    if (xMax > point.X()) {
    	    	xMax = point.X();
    	    }
    	    if (yMax > point.Y()) {
    	    	yMax = point.Y();
    	    }
    	}
    	Point2d point = new Point2d(xMax, yMax);
        return point;
    }
}
