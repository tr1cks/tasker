package com.github.tr1cks.tasker.util;

import static java.util.UUID.randomUUID;

public class UuidGen {

    public static String newUuid() { return randomUUID().toString().replace("-", ""); }
}
