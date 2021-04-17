public enum Planet {
    VELNOR(1),
    MIRAGE(1),
    PERIMETER(1),
    VEGAMINOR(1),
    VEGAMAJOR(1),
    HOPESEND(1),
    RIGELII(1),
    INDUSTREX(1);

    private final int production;
    Planet(int production){
        this.production = production;
    }

    int getResource(){
        return production;
    }
}
