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
        Ellipse mainBodyE = new Ellipse(maxWidth, maxHeight);
        Ellipse middleToRemovE = new Ellipse(maxWidth - stripeThickness,
                maxHeight - stripeThickness);
        Rectangle rectangleToAddE = new Rectangle(halfMaxWidth/2, maxWidth).rotate(Math.PI/2);
        BaseShape rightToRemove = new Rectangle(halfMaxWidth, halfMaxHeight/2).translate(new Point2d(halfMaxWidth/2, halfMaxWidth/2));

                //patron fluent builder
        mainBodyE.remove(middleToRemovE).remove(rightToRemove).add(rectangleToAddE);


        return mainBodyE;
    }

    // TODO
    public static BaseShape create_a() {
       Ellipse mainBodyA= new Ellipse(maxWidth,maxHeight);
        Ellipse middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight - stripeThickness);
        Rectangle rectangleToAdd = new Rectangle(halfMaxWidth/4, maxHeight).translate(new Point2d(maxWidth/2, 0.0));
        mainBodyA.remove(middleToRemove);
       mainBodyA.add(rectangleToAdd);

        return mainBodyA;
    }

    // TODO
    public static BaseShape create_C() {
        Ellipse mainBody = new Ellipse(maxWidth, maxHeight);
        Ellipse middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight - stripeThickness);
       BaseShape rightToRemove = new Rectangle(halfMaxWidth, maxHeight/1.5).translate(new Point2d(halfMaxWidth/2, 0.0));

        mainBody.remove(middleToRemove);
       mainBody.remove(rightToRemove);
        return mainBody;
    }

    // TODO
    public static BaseShape create_l() {
          return  new Rectangle(halfMaxWidth/4, maxHeight);
    }

    // TODO
    public static BaseShape create_i() {
        BaseShape mainBodyI=new Rectangle(halfMaxWidth/4,maxHeight*3/4);
       BaseShape circleIToAdd = new Ellipse(halfMaxWidth/2,halfMaxWidth/2);
        mainBodyI.translate(new Point2d(0.0,maxHeight*4/7));

        return mainBodyI.add(circleIToAdd);
    }

    // TODO
    public static BaseShape create_A() {
         Rectangle mainBodyA1 = new Rectangle(halfMaxWidth/4, maxHeight);
        mainBodyA1.rotate(270.0);
        Rectangle mainBodyA2 = new Rectangle(halfMaxWidth/4, maxHeight).translate(new Point2d(halfMaxWidth, -halfMaxHeight/15));
        mainBodyA2.add(mainBodyA2.rotate(-270.0));
        mainBodyA1.add(mainBodyA2);
        Rectangle mainBodyA3 = new Rectangle(stripeThickness, halfMaxHeight/6);
        mainBodyA3.translate(new Point2d(-halfMaxWidth/2,0.0));
         mainBodyA1.rotate(Math.PI);
         return mainBodyA1.add(mainBodyA3);
    }

    // TODO
    public static BaseShape create_V() {
         BaseShape mainBodyV1 = new Rectangle(halfMaxWidth/4, maxHeight);
      mainBodyV1.rotate(270.0);
      Rectangle mainBodyV2 = new Rectangle(halfMaxWidth/4, maxHeight).translate(new Point2d(halfMaxWidth, -halfMaxHeight/15));
      mainBodyV2.add(mainBodyV2.rotate(-270.0));
      mainBodyV1.add(mainBodyV2);
      return mainBodyV1;
    }

    // TODO
    public static BaseShape create_n() {
        Rectangle mainBody0 = new Rectangle(halfMaxWidth/4, maxHeight);
        Ellipse mainBody1= new Ellipse(maxWidth,maxHeight*0.4);
        Ellipse middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight*0.4 - stripeThickness);
        Rectangle rectangleToRemove = new Rectangle(halfMaxHeight,maxWidth).translate(new Point2d(0.0,halfMaxHeight*0.4));
        Rectangle mainBody2 = new Rectangle(halfMaxWidth/4,maxHeight*0.75);
        mainBody1.remove(middleToRemove);
        mainBody1.remove(rectangleToRemove);
        mainBody1.translate(new Point2d(maxWidth*0.42,-halfMaxWidth*1.2));
        mainBody2.translate(new Point2d(maxWidth*0.85,maxWidth*0.3));
        mainBody0.add(mainBody1);
        return mainBody0.add(mainBody2);
    }

    // TODO
    public static BaseShape create_r() {
        BaseShape mainBodyR0 = new Rectangle(halfMaxWidth/4, maxHeight);
        Ellipse mainBodyR1= new Ellipse(maxWidth,maxHeight*0.4);
        Ellipse middleToRemove = new Ellipse(maxWidth - stripeThickness,
                maxHeight*0.4 - stripeThickness);
        Rectangle rectangleToRemove = new Rectangle(halfMaxHeight,maxWidth).translate(new Point2d(0.0,halfMaxHeight*0.4));

        mainBodyR1.remove(middleToRemove);
        mainBodyR1.remove(rectangleToRemove);
        mainBodyR1.translate(new Point2d(maxWidth*0.42,-halfMaxWidth*1.2));
        return mainBodyR0.add(mainBodyR1);
    }

    // TODO
    public static BaseShape create_B() {
        Rectangle mainBodyB0 = new Rectangle(halfMaxWidth/4, maxHeight);
        Ellipse mainBodyB1 = new Ellipse(maxWidth/0.7, halfMaxHeight);
        BaseShape mainBodyB2= new Ellipse(maxWidth/0.7, halfMaxHeight);

        Ellipse middleToRemove = new Ellipse(maxWidth/0.7 - stripeThickness,
                halfMaxHeight - stripeThickness);
        BaseShape leftToRemove = new Rectangle(maxWidth/0.7,halfMaxHeight).translate(new Point2d(-halfMaxWidth/0.7,0.0));

       mainBodyB1.remove(middleToRemove);
       mainBodyB1.remove(leftToRemove);
       mainBodyB2.remove(middleToRemove);
       mainBodyB2.remove(leftToRemove);

        mainBodyB1.translate(new Point2d(0.0,halfMaxHeight/2));
        mainBodyB2.translate(new Point2d(0.0,-halfMaxHeight/2));
        mainBodyB0.add(mainBodyB1).add(mainBodyB2);

        return mainBodyB0;
   }
}
