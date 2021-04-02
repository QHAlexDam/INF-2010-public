package tp1;

import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // TODO Initialiser les points.
    public BaseShape() {
    	coords = new HashSet<Point2d>();
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
    	   this.coords = new HashSet<Point2d>();
    	   this.coords.addAll(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        this.coords.add(coord);
    }
    public void add(BaseShape shape) {
    	this.coords.addAll(shape.coords);
    }
    public void addAll(Collection<Point2d> coords) {
    	this.coords.addAll(coords);
    }
    public void remove(Point2d coord) {
    	this.coords.remove(coord);
    }
    public void remove(BaseShape shape) {
    	this.coords.removeAll(shape.coords);
    }
    public void removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
    }

    // TODO retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
    	Set<Point2d> set = new HashSet<Point2d>();
 	    set.addAll(coords);
        return set;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
    	BaseShape shape = new BaseShape();
    	for (Point2d point2d : this.coords) 
    	{ 
    	    point2d = point2d.translate(point);
    	    shape.add(point2d);
    	}
    	return shape;
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
    	BaseShape shape = new BaseShape();
    	for (Point2d point2d : this.coords) 
    	{ 
    	    point2d = point2d.translate(point);
    	    shape.add(point2d);
    	}
    	return shape.coords;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
    	BaseShape shape = new BaseShape();
    	for (Point2d point2d : this.coords) 
    	{ 
    	    point2d = point2d.rotate(angle);
    	    shape.add(point2d);
    	}
    	return shape;
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {
    	BaseShape shape = new BaseShape();
    	for (Point2d point2d : this.coords) 
    	{ 
    	    point2d = point2d.rotate(angle);
    	    shape.add(point2d);
    	}
    	return shape.coords;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
    	BaseShape shape = new BaseShape(coords);
        return shape;
    }
}
