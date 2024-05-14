package com.swontech.s05.service.common;
/* kjy
 * mapper to camelcase
 */

import com.google.common.base.CaseFormat;
import java.util.HashMap;

public class
CamelHashMap extends HashMap<String, Object> {
    public Object put(String key, Object value) {
        return super.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, key), value);
    }
}
