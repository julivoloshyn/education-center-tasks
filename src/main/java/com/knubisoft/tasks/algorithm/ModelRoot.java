package com.knubisoft.tasks.algorithm;

import com.knubisoft.tasks.algorithm.reflection.annotation.AnnotationForTest;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelRoot {

    public List<Item> items;

    @Data
    @NoArgsConstructor
    public static class Batter {
        @AnnotationForTest
        public String id;
        public String type;

        public Batter(String id) {
            this.id = id;
        }

        public Batter(String id, String type) {
            this.id = id;
            this.type = type;
        }
    }

    @Getter
    public static class Item {
        public int id;
        public String type;
        public String name;
        public double ppu;
        public Batters batters;
        public List<Topping> topping;
    }

    public static class Batters {
        public List<Batter> batter;
    }

    public static class Topping {
        public String id;
        public String type;
    }

}
