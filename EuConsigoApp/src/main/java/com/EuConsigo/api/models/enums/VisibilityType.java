package com.EuConsigo.api.models.enums;

// com lombok esta dando problema

public enum VisibilityType {
    PUBLIC("PUBLIC"),
    PRIVATE("PRIVATE"),
    FRIEND_ONLY("FRIEND_ONLY");

    private final String visibility;

    VisibilityType(String visibility) {
        this.visibility = visibility;
    }

    public String getVisibility() {
        return visibility;
    }
}
