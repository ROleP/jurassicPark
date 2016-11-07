package com.rolep.sf.filediff;

/**
 * Created by rolep on 13/09/16.
 */
class LineEntry {

    private static String separator = ";";

    private String text;
    private Status status = Status.OLD;

    public LineEntry(String text) {
        this.text = text;
    }

    public LineEntry(String text, Status status) {
        this.text = text;
        this.status = status;
    }

    void addText(String newText) {
        text = text + separator + newText;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineEntry lineEntry = (LineEntry) o;

        return text != null ? text.equalsIgnoreCase(lineEntry.text) : lineEntry.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.toLowerCase().hashCode() : 0;
    }
}
