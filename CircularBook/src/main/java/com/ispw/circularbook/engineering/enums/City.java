package com.ispw.circularbook.engineering.enums;

public enum City {
    ANY(""), ANCONA("Ancona"), AOSTA("Aosta"), BARI("Bari"), BOLOGNA("Bologna"), CAGLIARI("Cagliari"), CAMPOBASSO("Campobasso"), CATANZARO("Catanzaro"), FIRENZE("Firenze"), GENOVA("Genova"), AQUILA("L'aquila"), MILANO("Milano"), NAPOLI("Napoli"), PALERMO("Palermo"), PERUGIA("Perugia"), POTENZA("Potenza"), TORINO("Torino"), ROMA("Roma"), TRENTO("Trento"), TRIESTE("Trieste"), VENEZIA("Venezia");

    private final String nameCity;

    City(String nameCity){
        this.nameCity = nameCity;
    }

    public String getNameCity()
    {
        return this.nameCity;
    }

}
