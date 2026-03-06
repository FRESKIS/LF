public class Label {

    Character value;
    boolean emptyTransition;

    public static Label createEmptyLabel(){
        return new Label();
    }

    public static Label createNonEmptyLabel(Character value) {
        return new Label(value);
    }

    private Label(Character value) {
        this.value = value;
        emptyTransition = false;
    }

    private Label() {
        emptyTransition = true;
    }

    public Character getValue() {
        return value;
    }

    public boolean isEmptyTransition() {
        return emptyTransition;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Label) {
            Label l = (Label) obj;
            if (l.isEmptyTransition())
                return this.isEmptyTransition();
            else
                return l.getValue().equals(this.getValue());
        } else
            return false;
    }

    @Override
    public String toString() {
        if (isEmptyTransition())
            return "$";
        else
            return getValue().toString();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
