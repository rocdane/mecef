package org.n2aconsultings.mecef.view;

public enum FxmlView {
	MAIN{
		@Override
		String getTitle() {
			return "MeCEF | Accueil";
		}

		@Override
		String getFxmlFile() {
			return "fxml/edit-invoice.fxml";
		}

	},
	SUPPORT{
		@Override
		String getTitle() {
			return "MeCEF | A propos";
		}

		@Override
		String getFxmlFile() {
			return "fxml/support.fxml";
		}
	};
	abstract String getTitle();
	abstract String getFxmlFile();
}
