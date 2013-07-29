package org.kiwi.domain;

public class KV {
    private final String key;
    private Integer value;

    public KV(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KV kv = (KV) o;

        if (key != null ? !key.equals(kv.key) : kv.key != null) return false;
        if (value != null ? !value.equals(kv.value) : kv.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
