package com.matthewedevelopment.ps.api.file.yaml;

import java.io.File;
import java.io.IOException;

/**
 * Created by matt1 on 3/22/2017.
 */
public interface YamlLoadable {
    YamlFile load(File file) throws YamlLoadException, IOException;
}
