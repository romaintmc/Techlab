package controller;

import model.resistorFunctions;
import view.initcomponents;

public class listeners {
    initcomponents init;
    resistorFunctions resistor;
    public listeners(initcomponents init, resistorFunctions resistor){
        this.init = init;
        this.resistor = resistor;

        System.out.println("Controler ON");

    }
    public void run(){
        //this.init.showWindows();
    }
}
