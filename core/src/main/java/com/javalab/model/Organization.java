package com.javalab.model;

import java.util.List;

public record Organization(String name, String city, List<User> users) {
}
