package eus.ehu.theme.theme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class HelloApplication extends Application {

    private Scene scene;

    private Properties prop;

    private String theme;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getRes("hello-view.fxml"));
        scene = new Scene(fxmlLoader.load());

        HelloController controller = fxmlLoader.getController();
        controller.setApplication(this);

        // Manage theme
        getTheme();
        setTheme(theme);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void setTheme(String theme) {
        scene.getStylesheets().clear();

        if (theme.equals("Dark Mode")) {
            String darkThemePath = getRes("darkTheme.css").toString();
            scene.getStylesheets().add(darkThemePath);
        }

        if (!theme.equals(this.theme)) {
            this.theme = theme;
            saveTheme();
        }
    }

    private void getTheme() {
        prop = new Properties();
        try (InputStream input = new
                FileInputStream(getRes("config.properties").getPath())) {
            prop.load(input);
            theme = prop.getProperty("user.theme");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveTheme() {
        try (OutputStream output = new FileOutputStream(getRes("config.properties").getPath())) {
            prop.setProperty("user.theme", theme);
            prop.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private URL getRes(String path) {
        return HelloApplication.class.getResource(path);
    }

    public static void main(String[] args) {
        launch();
    }
}