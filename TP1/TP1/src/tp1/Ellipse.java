package tp1;

import java.util.ArrayList;
import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        for(Double i =-widthRadius/2; i <= widthRadius/2; i++){
            for(Double j = -heightRadius/2; j <= heightRadius/2; j++){
                //  formule x^2/a^2 + y^2/b^2 = 1;
                if( (Math.pow(i,2)/Math.pow(widthRadius/2,2)) + (Math.pow(j,2)/Math.pow(heightRadius/2,2))>=0 &&
                        (Math.pow(i,2)/Math.pow(widthRadius/2,2)) + (Math.pow(j,2)/Math.pow(heightRadius/2,2))<=1)
                {
                    this.add(new Point2d(i,j));}
            }
        }
    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        for(Double i = 0.0; i <= dimensions.X(); i++){
            for(Double j = 0.0; j <= dimensions.Y(); j++){
                // formule x^2/a^2 + y^2/b^2 = 1;
                if( (Math.pow(i-dimensions.X()/2,2)/Math.pow(dimensions.X()/2,2)) +
                        (Math.pow(j-dimensions.Y()/2,2)/Math.pow(dimensions.Y()/2,2))<=1.0){
                    this.add(new Point2d(i,j));}
            }
        }
    }

    // TODO initialiser le parent.
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {

        var listTemp= new ArrayList<Point2d>();
        for(var coords:this.getCoords())
        {
            listTemp.add(coords.translate(point));

        }
        return new Ellipse(listTemp);
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {

        var listTemp= new ArrayList<Point2d>();
        for(var coords:this.getCoords())
        {
            listTemp.add(coords.rotate(angle));

        }
        return new Ellipse(listTemp);
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() {
        return new Ellipse(this.getCoords());
    }
}
