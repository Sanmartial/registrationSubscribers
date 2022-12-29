public class Main {
    public static void main(String[] args) {
        ModelR model = new ModelR();
        ViewR view = new ViewR();

        ControllerR controllerR = new ControllerR(model, view);
        controllerR.creatingStructureForDataEntry(args);
    }
}
