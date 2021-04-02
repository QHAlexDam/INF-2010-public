package tp1;

import java.util.Set;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
    	 super();
    	 for(int i = 0; i < (Math.toDegrees(2*(Math.PI))); i++) {
    		 for (int j = 0; j < widthRadius; j++) {
    			 for (int k = 0; k < heightRadius; k++) {
    				 if(j <= (widthRadius*(Math.cos(Math.toRadians(i)))) && k <= (heightRadius*(Math.sin(Math.toRadians(i))))){
    					 super.add(new Point2d(j+0.0, k+0.0));
    					 super.add(new Point2d(-j+0.0,k+0.0));
    					 super.add(new Point2d(j+0.0,-k+0.0));
    					 super.add(new Point2d(-j+0.0,-k+0.0));	 
    				 } 				 
    			 }
    		 }   		 
    	 }        
    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        return new Ellipse(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return new Ellipse(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() { return new Ellipse(getCoords()); }
}
