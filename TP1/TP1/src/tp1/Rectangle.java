package tp1;

import java.util.ArrayList;
import java.util.Collection;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        for(double i = -width/2; i<=width/2; i++)
        {
            for (double j = -height/2 ; j<=height/2;j++)
            {
                this.add(new Point2d(i,j));
            }
        }

    }

    // TODO creer un rectangle avec les dimensions contenu dans un Point.
    public Rectangle(Point2d dimensions) {
        for(double i = -dimensions.X()/2; i<=dimensions.Y()/2; i++)
        {
            for (double j = -dimensions.X()/2 ; j<=dimensions.Y()/2;j++)
            {
                this.add(new Point2d(i,j));
            }
        }
    }

    // TODO initialiser le parent.
    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        var listTemp= new ArrayList<Point2d>();
        for(var coords:this.getCoords())
        {
            listTemp.add(coords.translate(point));

        }
        return new Rectangle(listTemp);
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {

        var listTemp= new ArrayList<Point2d>();
        for(var coords:this.getCoords())
        {
            listTemp.add(coords.rotate(angle));

        }
        return new Rectangle(listTemp);
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        return new Rectangle(this.getCoords());
    }
}
