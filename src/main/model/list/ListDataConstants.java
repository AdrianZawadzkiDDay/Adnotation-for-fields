package main.model.list;

public enum ListDataConstants {
    DEAL_TYPE(new String[] {"Primary deal", "Secondary deal", "All deal"});

    private final String[] list;

    ListDataConstants(String[] list) {
        this.list = list;
    }

    public String[] listTypes() {
        return list;
    }
}
