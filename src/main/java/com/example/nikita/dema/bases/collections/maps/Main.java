package com.example.nikita.dema.bases.collections.maps;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<String>> name = new HashMap<>();


        name.put(456, List.of("Sneakers", "Boots", "Tapochki"));
        name.put(458, Collections.singletonList("Sneakers"));
        name.put(457, Arrays.asList("Sneakers", "dada"));
        name.put(444, List.of("Head", "Cap"));
        name.put(455, List.of("Mazda", "Opel", "Bugatti"));

        System.out.println(name.get(456));

    }
}
