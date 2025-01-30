package com.EuConsigo.api.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VisibilityType {
    PUBLIC("PUBLIC"),
    PRIVATE("PRIVATE"),
    FRIEND_ONLY("FRIEND_ONLY");

    private final String visibility;
}
