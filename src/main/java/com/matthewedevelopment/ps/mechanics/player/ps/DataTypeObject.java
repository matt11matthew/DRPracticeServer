package com.matthewedevelopment.ps.mechanics.player.ps;

import java.util.List;

/**
 * Created by matt1 on 3/13/2017.
 */
public class DataTypeObject {

    private Object object;

    public DataTypeObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public String getAsAString() {
        return (String) object;
    }

    public long getAsAInteger() {
       return getAsALong();
    }

    public Double getAsADouble() {
        if (object == null) {
            return 0.0D;
        }
        return (Double) object;
    }

    public long getAsALong() {
        if (object == null) {
            return 0L;
        }
        return Long.parseLong(object + "");
    }

    public Short getAsAShort() {
        if (object == null) {
            return 0;
        }
        return (Short) object;
    }

    public Boolean getAsABoolean() {
        if (object == null) {
            return false;
        }
        return (Boolean) object;
    }

    public List<String> getAsAStringList() {
        if (object == null) {
            return null;
        }
        return (List<String>) object;
    }
}
