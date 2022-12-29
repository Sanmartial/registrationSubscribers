import java.util.Scanner;

public class ControllerR implements SubscribeConstants {

    private final ModelR model;
    private final ViewR view;


    public ControllerR(ModelR model, ViewR view) {
        this.model = model;
        this.view = view;
    }

    Scanner scanner = new Scanner(System.in);

    public void creatingStructureForDataEntry(String[] args) {
        String[] responseVerificationResult = new String[COUNT_ARGS];
        if (args.length == COUNT_ARGS) {
            for (int i = 0; i < args.length; i++) {
                if (verificationResult(args[i], regRex[i])) {
                    responseVerificationResult[i] = args[i];
                } else
                    throw new IllegalArgumentException(ViewR.requireData[i] + " " + args[i] + " " + ViewR.INPUT_WRONG);
            }

        } else {
            view.printMessage(ViewR.INPUT_INFORMATION);
            for (int i = 0; i < ViewR.requireData.length; i++) {
                view.printMessage(ViewR.requireData[i]);
                responseVerificationResult[i] = scanner.nextLine();
                while (!verificationResult(responseVerificationResult[i], regRex[i])) {
                    view.printMessage(responseVerificationResult[i] + " " + ViewR.INPUT_WRONG);
                    responseVerificationResult[i] = scanner.nextLine();
                }
            }
        }

        Subscriber subscriber = new Subscriber(responseVerificationResult);
        model.implementsBusinessLogicForSubscribers(subscriber);
    }


    private boolean verificationResult(String arg, String regRex) {
        return arg.matches(regRex);
    }


}
