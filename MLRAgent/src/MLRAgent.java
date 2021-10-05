import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class MLRAgent extends Agent {
   NormalEcuationMLR MLR = new NormalEcuationMLR();

    protected void setup() {
        // Create and show the GUI
        InputDialogBox myInputDialogBox = new InputDialogBox(this);
        myInputDialogBox.showGui();
        System.out.println("Hello world! I'm a OneShot Multiple Linear Regression agent!");
        System.out.println("My local name is " + getAID().getLocalName());

    }

    public void getX(final String x1,final String x2) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                System.out.println("Regression model equation:\nY = "+MLR.getB0()+" + "+MLR.getB1()+"X1 + "+MLR.getB2()+"X2");
                System.out.print("Proyected Value of Y:");
                System.out.print(MLR.getB0()+MLR.getB1()*Double.parseDouble(x1)+ MLR.getB2()*Double.parseDouble(x2));
            }
        });

    }
}
