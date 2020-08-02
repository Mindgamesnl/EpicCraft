package com.craftmend.epiccraft.detection.enums;

import com.craftmend.epiccraft.detection.interfaces.RequirementTest;

import java.util.HashMap;
import java.util.Map;

class RequirementCache {

    public static final Map<Class<?>, RequirementTest> TEST_CACHE = new HashMap<>();

}
