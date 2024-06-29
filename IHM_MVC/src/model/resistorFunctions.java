package model;

import java.awt.*;

public class resistorFunctions {
    int ring1, ring2, ring3, ring4, ring5;
    public resistorFunctions(){

    }

    public void panel4OK(Color color){
        if(!this.jToggleButton1.isSelected()){
            this.jPanel4.setBackground(Color.gray);
            this.ring4=0;
        }
        else{
            this.jPanel4.setBackground(color);
        }
    }

    public void setTextTolerance(int number){
        switch(number){
            case 1 -> this.jLabel4.setText("+/- 1%");
            case 2 -> this.jLabel4.setText("+/- 2%");
            case 5 -> this.jLabel4.setText("+/- 0.5%");
            case 6 -> this.jLabel4.setText("+/- 0.25%");
            case 7 -> this.jLabel4.setText("+/- 0.1%");
            case 8 -> this.jLabel4.setText("+/- 0.05%");
            case 10 -> this.jLabel4.setText("+/- 5%");
            case 11 -> this.jLabel4.setText("+/- 10%");
            default -> this.jLabel4.setText("Pas de tolérance correspondante");
        }
    }

    public int ButtonToInt(java.awt.event.ActionEvent e){
        Object source = e.getSource();

        int number = 0;

        //System.out.println("Button changing...");
        if(source.equals(this.jRadioButton1)){ number = 0;}
        else if(source.equals(this.jRadioButton2)){ number = 1;}
        else if(source.equals(this.jRadioButton3)){ number = 2;}
        else if(source.equals(this.jRadioButton4)){ number = 3;}
        else if(source.equals(this.jRadioButton5)){ number = 4;}
        else if(source.equals(this.jRadioButton6)){ number = 5;}
        else if(source.equals(this.jRadioButton7)){ number = 6;}
        else if(source.equals(this.jRadioButton8)){ number = 7;}
        else if(source.equals(this.jRadioButton9)){ number = 8;}
        else if(source.equals(this.jRadioButton10)){ number = 9;}
        else if(source.equals(this.jRadioButton11)){ number = 10;}
        else if(source.equals(this.jRadioButton12)){ number = 11;}
        //else{System.out.println("Button error...");}
        //System.out.println("Nombre :" +number);
        return number;
    }

    public Color IntToColor(int number){
        Color color = new Color(242,242,242);
        Color brown = new Color(88,41,0);
        Color gold = new Color(212,175,55);
        Color silver = new Color(170,169,173);
        //System.out.println("Color changing...");

        switch(number){
            case 0 -> color = Color.black;
            case 1 -> color = brown;
            case 2 -> color = Color.red;
            case 3 -> color = Color.orange;
            case 4 -> color = Color.yellow;
            case 5 -> color = Color.green;
            case 6 -> color = Color.blue;
            case 7 -> color = Color.magenta;
            case 8 -> color = Color.gray;
            case 9 -> color = Color.white;
            case 10 -> color = gold;
            case 11 -> color = silver;
            //default -> System.out.println("Color error");
        }
        //System.out.println("Couleur :" +color);
        return color;

    }

    public void changeRing(java.awt.event.ActionEvent evt){
        //System.out.println("Ring changing...");
        int result = ButtonToInt(evt);
        Color actualColor = IntToColor(result);
        //System.out.println("Bouton :" +result);
        switch (this.jLabel6.getText()){
            case "1" -> {this.jPanel2.setBackground(actualColor); this.ring1=result;}
            case "2" -> {this.jPanel3.setBackground(actualColor); this.ring2=result;}
            case "3" -> {this.jPanel5.setBackground(actualColor); this.ring3=result;}
            case "Multiplicateur" -> {panel4OK(IntToColor(result)); if(this.jToggleButton1.isSelected()){this.ring4=result;} else {this.ring4=0;}}
            case "Tolérance" -> {this.jPanel6.setBackground(actualColor); this.ring5=result; setTextTolerance(result);}
            //default -> System.out.println("Ring error");

        }
    }

    public void calculResistor(){
        int result = this.ring1*100 + this.ring2*10 + this.ring3;
        if(ring4==0 || !this.jToggleButton1.isSelected()){this.jLabel2.setText(""+result+"Ω");}
        else if(ring4>= 1 && ring4 <= 9 && this.jToggleButton1.isSelected()){this.jLabel2.setText(""+result+"*10^"+ring4+"Ω");}
        else if(ring4 == 10 && this.jToggleButton1.isSelected()){this.jLabel2.setText(""+result+"*10^-1 Ω");}
        else if(ring4 == 11 && this.jToggleButton1.isSelected()){this.jLabel2.setText(""+result+"*10^-2 Ω");}
    }
}
