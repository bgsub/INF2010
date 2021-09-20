package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape implements Cloneable {
    private Collection<Point2d> coords;

    // TODO Initialiser la liste de points.
    public BaseShape() {
        coords = new ArrayList<>();
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<>(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public BaseShape add(Point2d coord) {
        coords.add(coord);
        return this;
    }
    public BaseShape add(BaseShape shape) {
       coords.addAll(shape.coords);
       return this;
    }
    public BaseShape addAll(Collection<Point2d> coords) {
        BaseShape shapeTemp = new BaseShape(coords);
        this.coords.addAll(shapeTemp.coords);
        return this;
    }
    public BaseShape remove(Point2d coord) {
        coords.remove(coord);
        return this;
    }
    public BaseShape remove(BaseShape shape) {
        coords.removeAll(shape.coords);
        return this;
    }
    public BaseShape removeAll(Collection<Point2d> coords) {
        BaseShape shapeTemp = new BaseShape(coords);
        this.coords.removeAll(shapeTemp.coords);
        return this;

    }

    // TODO retourner les coordonnees de la liste.
    public Collection<Point2d> getCoords() {
        return new ArrayList<>(this.coords);
    }

    // TODO retourner une nouvelle liste ou tous les points sont des copy
    public Collection<Point2d> getCoordsDeepCopy() {
        Collection<Point2d> listClone = new ArrayList<>();
        Iterator<Point2d> iterator = this.coords.iterator();
        while(iterator.hasNext())
        {
            listClone.add((Point2d) iterator.next().clone());
        }
        return listClone;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        BaseShape shapeTemp = new BaseShape(this.coords);
        for(var coord:this.coords)
        {
            coord.translate(point);
        }
        return shapeTemp;

    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {

        BaseShape shapeTemp = new BaseShape(this.coords);
        for(var coord:this.coords)
        {
            coord.rotate(angle);
        }
        return shapeTemp;

    }

    // TODO donner la plus grande valeur en X
    public Double getMaxX() {
        Double maxX=0.0;
        for(var point : coords)
        {
            if(maxX< point.X())
                maxX=point.X();
        }

        return maxX;

    }

    // TODO donner la plus grande valeur en Y
    public Double getMaxY() {

        Double maxY=0.0;
        for(var point : coords)
        {
            if(maxY< point.Y())
                maxY=point.Y();
        }

        return maxY;
    }

    // TODO donner les plus grandes valeurs en X et Y
    public Point2d getMaxCoord() {

        return new Point2d(getMaxX(),getMaxY());
    }

    // TODO donner la plus petite valeur en X
    public Double getMinX() {
        Double minX=0.0;
        return Collections.min(coords).X() ;
    }
    // TODO donner la plus petite valeur en Y
    public Double getMinY() {
        Double minY=0.0;
        for(var point : coords)
        {
            if(minY> point.Y())
                minY=point.Y();
        }

        return minY;
    }

    // TODO donner les plus petites valeurs en X et Y
    public Point2d getMinCoord() {
        return new Point2d(getMinX(),getMinY());
    }

    // TODO retourner une nouvelle forme.
    //  super.clone() modifiait les tests donc nous l'avons pas utilisé
    public BaseShape clone() {
        return new BaseShape(this.coords);
    }
}

