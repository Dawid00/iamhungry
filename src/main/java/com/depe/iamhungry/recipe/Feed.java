package com.depe.iamhungry.recipe;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class Feed {
    private String type;
    private Content content;
    private Display display;
}
