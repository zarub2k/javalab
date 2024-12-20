package com.javalab.model;

import java.util.List;

public record Organization(String name, List<User> users) {
}
