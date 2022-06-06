package com.zenithbank.integration.entity.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Partners {
    WAKANOW("WAKANOW");

    private final String title;
    Partners(String title){
        this.title = title;
    }

    public String getValue(){
        return this.title;
    }

    public List<String> getValues(){
        List<String> values = new ArrayList<>();

        for(Partners p : Partners.values()){
            values.add(p.title);
        }
        return values;
    }

    public static Partners getEnumFromString(String text){
        for(Partners t : Partners.values()){
            if (t.title.equalsIgnoreCase(text)){
                return t;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
