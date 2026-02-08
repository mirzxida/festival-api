package com.example.festival.patterns;

import com.example.festival.model.*;

public class EntityFactory {
    private EntityFactory(){}
    public static BaseEntity createEntity(
            EntityType type,
            int id,
            String name,
            Object... args
    ) {

        return switch (type) {

            case BAND -> new Band(
                    id,
                    name,
                    (String) args[0],
                    (String) args[1]
            );

            case STAGE -> new Stage(
                    id,
                    name,
                    (int) args[0]
            );

            case CREW -> new Crew(
                    id,
                    name,
                    (String) args[0],
                    (Integer) args[1]
            );

            default -> throw new IllegalArgumentException(
                    "Unknown entity type: " + type
            );
        };
    }
}
