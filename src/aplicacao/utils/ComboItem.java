package aplicacao.utils;

import java.util.Objects;

public class ComboItem {
    private Integer value;
    private String label;
    
    public ComboItem(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ComboItem)) {
            return false;
        }
        ComboItem a = (ComboItem) obj;
        return Objects.equals(a.getValue(), getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
