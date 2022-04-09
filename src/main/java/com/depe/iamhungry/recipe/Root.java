package com.depe.iamhungry.recipe;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Root {
    private List<Feed> feed;
}
