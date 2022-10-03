package com.knubisoft.tasks.algorithm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelRoot {

    public List<Item> items;

    public static class Batter {
        public String id;
        public String type;
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
