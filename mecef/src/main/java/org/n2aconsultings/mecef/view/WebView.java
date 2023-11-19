package org.n2aconsultings.mecef.view;

public enum WebView {

    HOME{
        @Override
        String getTitle() {
            return "sign in";
        }

        @Override
        String getHtmlFile() {
            return "fxml/auth-signin.fxml";
        }

    };

    abstract String getTitle();
    abstract String getHtmlFile();
}
