package tp1;

import java.util.HashSet;
import java.util.Set;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H() {
    	Double degrees90 = Math.toRadians(90);
    	BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
    	BaseShape smallStripe = new Rectangle(stripeThickness, maxWidth);
    	BaseShape hShape = mainStripe.translate(new Point2d(0.0, 0.0));
        BaseShape middleStripe = smallStripe.rotate(degrees90).translate(new Point2d(maxWidth + 10.0, halfMaxHeight));
        BaseShape rightStripe = mainStripe.translate(new Point2d(maxWidth, 0.0));
        hShape.add(middleStripe);
        hShape.add(rightStripe);
        return hShape;
        // DONE
    }

    // TODO
    public static BaseShape create_e() {
    	BaseShape lShape = new Rectangle(stripeThickness, maxHeight);
        return lShape;
        
        // À MODIFIER
    }

    // TODO
    public static BaseShape create_l() {
    	/*BaseShape lShape = new Rectangle(20.0, 200.0);
    	Double degrees90 = Math.toRadians(90);
    	BaseShape middleStripe = lShape.rotate(degrees90).translate(new Point2d(20.0, 100.0));
    	lShape.add(middleStripe);
        return lShape;*/
    	
    	
        
        Set<Point2d> coords =  new HashSet<Point2d>();
        for (Double i = -maxWidth; i < maxWidth; i++) {
         	for ( Double j = -maxHeight; j < maxHeight; j++) {
         		if (((i * i) / (maxWidth * maxWidth)) + ((j * j) / (maxHeight * maxHeight)) <= 1.0){
         			coords.add(new Point2d(i + 0.0, j + 0.0));
         		}
         	}
         }
        BaseShape oShape = new Ellipse(maxWidth, maxHeight);
        return oShape;
    	
    	
    }

    // TODO
    public static BaseShape create_o() {
    	/*BaseShape oShape = new Ellipse(maxWidth, maxHeight);
        return oShape;*/
    	
    	
    	
    	BaseShape lShape = new Rectangle(stripeThickness, maxHeight);
        return lShape;
    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W() {
        Double degrees15 = Math.toRadians(8);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.rotate(-degrees15).translate(new Point2d(-spacing, 0.0));
        BaseShape middleLeftStripe = mainStripe.rotate(degrees15).translate(new Point2d(-spacing / 3, 0.0));
        BaseShape middleRightStripe = mainStripe.rotate(-degrees15).translate(new Point2d(spacing / 3, 0.0));
        BaseShape rightStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing, 0.0));
        leftStripe.add(middleLeftStripe);
        leftStripe.add(middleRightStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_r() {
    	BaseShape lShape = new Rectangle(stripeThickness, maxHeight);
        return lShape;
        
        // À MODIFIER
    }

    // TODO
    public static BaseShape create_d() {
    	BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
    	BaseShape dShape = mainStripe.translate(new Point2d(maxWidth, 0.0));
    	/*BaseShape mainEllipse = new Circle(stripeThickness);
    	BaseShape dCircle = mainEllipse.translate(new Point2d(0.0, halfMaxHeight));
    	dShape.add(dCircle);*/
        return dShape;
    }
}
