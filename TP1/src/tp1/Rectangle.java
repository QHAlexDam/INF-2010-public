package tp1;

import java.util.Collection;
import java.util.Set;

import org.w3c.dom.css.Rect;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        super();
        for (int i = 0; i < width; i++) {
        	for ( int j = 0; j < height; j++) {
        		super.add(new Point2d(i + 0.0, j + 0.0));
        	}
        }
        
    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
    	super();
    	for (int i = 0; i < dimensions.X(); i++) {
        	for ( int j = 0; j < dimensions.Y(); j++) {
        		super.add(new Point2d(i + 0.0, j + 0.0));
        	}
        }
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        return new Rectangle(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
    	return new Rectangle(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
    	return new Rectangle(Rectangle.super.getCoords());
    }
}
