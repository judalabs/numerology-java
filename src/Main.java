import java.util.stream.Stream;

import numerology.Kaballah;

class Main {

    public static void main(String[] args) {

        Stream.of("Stefanny Yumi Nemoto",
                        "Rodrigo Judá Conceição"
                ).forEach(nome -> new Kaballah(nome, false).execute());
    }

}

