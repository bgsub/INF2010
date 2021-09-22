package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;

    // TODO
    public static BaseShape create_e() {
       BaseShape mainBodyE = new Ellipse(maxWidth, maxHeight);
        BaseShape  middleToRemovE = new Ellipse(maxWidth - stripeThickness,
                maxHeight - stripeThickness);
        BaseShape  rectangleToAddE = new Rectangle(halfMaxWidth/2, maxWidth).rotate(Math.PI/2);
        BaseShape  rightToRemove = new Rectangle(halfMaxWidth, halfMaxHeight/2).translate(new Point2d(halfMaxWidth/2, halfMaxWidth/2));

                //patron fluent builder
       return mainBodyE.remove(middleToRemovE).remove(rightToRemove).add(rectangleToAddE);



    }

    // TODO
    public static BaseShape create_a() {
        BaseShape  mainBodyA= new Ellipse(maxWidth,maxHeight);
        BaseShape  middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight - stripeThickness);
        BaseShape  rectangleToAdd = new Rectangle(halfMaxWidth/4, maxHeight).translate(new Point2d(maxWidth/2, 0.0));
        //patron fluent builder
        return mainBodyA.remove(middleToRemove).add(rectangleToAdd);



    }

    // TODO
    public static BaseShape create_C() {
        BaseShape mainBody = new Ellipse(maxWidth, maxHeight);
        BaseShape middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight - stripeThickness);
       BaseShape rightToRemove = new Rectangle(halfMaxWidth, maxHeight/1.5).translate(new Point2d(halfMaxWidth/2, 0.0));
        //patron fluent builder
        return mainBody.remove(middleToRemove).remove(rightToRemove);

    }

    // TODO
    public static BaseShape create_l() {

        return  new Rectangle(halfMaxWidth/4, maxHeight);
    }

    // TODO
    public static BaseShape create_i() {
        BaseShape mainBodyI=new Rectangle(halfMaxWidth/4,maxHeight*3/4);
       BaseShape circleIToAdd = new Ellipse(halfMaxWidth/2,halfMaxWidth/2);
        //patron fluent builder
       return mainBodyI.translate(new Point2d(0.0,maxHeight*4/7)).add(circleIToAdd);
    }

    // TODO
    public static BaseShape create_A() {
         BaseShape mainBodyA1 = new Rectangle(halfMaxWidth/4, maxHeight);
        BaseShape mainBodyA2 = new Rectangle(halfMaxWidth/4, maxHeight).translate(new Point2d(halfMaxWidth, -halfMaxHeight/15));
        mainBodyA2.add(mainBodyA2.rotate(-270.0));

        BaseShape mainBodyA3 = new Rectangle(stripeThickness, halfMaxHeight/6);
        //patron fluent builder
        return  mainBodyA1.rotate(270.0).add(mainBodyA2.add(mainBodyA2.rotate(-270.0))).rotate(Math.PI)
                .add( mainBodyA3.translate(new Point2d(-halfMaxWidth/2,0.0)));

    }

    // TODO
    public static BaseShape create_V() {
        BaseShape mainBodyV1 = new Rectangle(halfMaxWidth/4, maxHeight);

        Rectangle mainBodyV2 = new Rectangle(halfMaxWidth/4, maxHeight).translate(new Point2d(halfMaxWidth, -halfMaxHeight/15));
        //patron fluent builder
        return mainBodyV1.rotate(270.0).add(mainBodyV2.add(mainBodyV2.rotate(-270.0)));
    }

    // TODO
    public static BaseShape create_n() {
        BaseShape mainBody0 = new Rectangle(halfMaxWidth/4, maxHeight);
        BaseShape mainBody1= new Ellipse(maxWidth,maxHeight*0.4);
        BaseShape middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight*0.4 - stripeThickness);
        BaseShape rectangleToRemove = new Rectangle(halfMaxHeight,maxWidth).translate(new Point2d(0.0,halfMaxHeight*0.4));
        BaseShape mainBody2 = new Rectangle(halfMaxWidth/4,maxHeight*0.75);
        //patron fluent builder
        return mainBody0.add(mainBody1.remove(middleToRemove)
                        .remove(rectangleToRemove).translate(new Point2d(maxWidth*0.42,-halfMaxWidth*1.2)))
                .add(mainBody2.translate(new Point2d(maxWidth*0.85,maxWidth*0.3)));
    }

    // TODO
    public static BaseShape create_r() {
        BaseShape mainBodyR0 = new Rectangle(halfMaxWidth/4, maxHeight);
        BaseShape mainBodyR1= new Ellipse(maxWidth,maxHeight*0.4);
        BaseShape middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight*0.4 - stripeThickness);
        BaseShape rectangleToRemove = new Rectangle(halfMaxHeight,maxWidth).translate(new Point2d(0.0,halfMaxHeight*0.4));
        //patron fluent builder
        return mainBodyR0.add(mainBodyR1.remove(middleToRemove)
                .remove(rectangleToRemove).translate(new Point2d(maxWidth*0.42,-halfMaxWidth*1.2)));
    }

    // TODO
    public static BaseShape create_B() {
        BaseShape mainBodyB0 = new Rectangle(halfMaxWidth/4, maxHeight);
        BaseShape mainBodyB1 = new Ellipse(maxWidth/0.7, halfMaxHeight);
        BaseShape mainBodyB2= new Ellipse(maxWidth/0.7, halfMaxHeight);

        BaseShape middleToRemove = new Ellipse(maxWidth/0.7 - stripeThickness,
                halfMaxHeight - stripeThickness);
        BaseShape leftToRemove = new Rectangle(maxWidth/0.7,halfMaxHeight).translate(new Point2d(-halfMaxWidth/0.7,0.0));

        //patron fluent builder
        return mainBodyB0.add(mainBodyB1.remove(middleToRemove).remove(leftToRemove)
                .translate(new Point2d(0.0,halfMaxHeight/2)))
                .add(mainBodyB2.remove(middleToRemove).remove(leftToRemove)
                        .translate(new Point2d(0.0,-halfMaxHeight/2)));
   }
}
