class Monster {
    private int arms, legs, buttons, eyes;
    private String name;

    public Monster() {
        arms = 2;
        legs = 2;
        buttons = 3;
        eyes = 2;
        name = "default monster";
    }

    public Monster(int a, int l, int b, int e, String n) {
        arms = a;
        legs = l;
        buttons = b;
        eyes = e;
        name = n;
    }

    public int getArms() {return arms;}
    public int getLegs() {return legs;}
    public int getButtons() {return buttons;}
    public int getEyes() {return eyes;}
    public String getName() {return name;}

    public void setArms(int a) {arms = a;}
    public void setLegs(int l) {legs = l;}
    public void setButtons(int b) {buttons = b;}
    public void setEyes(int e) {eyes = e;}
    public void setName(String n) {name = n;}

    public String toString() {
        String out = "Monster " + name + ":\n";
        out += "\nArms: "+arms;
        out += "\nLegs: "+legs;
        out += "\nButtons: "+buttons;
        out += "\nEyes: "+eyes;
        out += "\nName: "+name;
        return out;
    }
}