package com.hurricane;

import javafx.geometry.Orientation;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.transform.Scale;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScaledViewTest {
    @Test public void laysOutTheLoginColumnsBeforeScaling() {
        GridPane page = new GridPane();
        page.setPrefSize(1920, 1080);
        ColumnConstraints first = new ColumnConstraints();
        first.setPercentWidth(50);
        ColumnConstraints second = new ColumnConstraints();
        second.setPercentWidth(50);
        page.getColumnConstraints().addAll(first, second);
        Pane left = new Pane();
        Pane right = new Pane();
        page.add(left, 0, 0);
        page.add(right, 1, 0);
        ScaledView scaled = new ScaledView(page);

        scaled.resize(960, 540);
        scaled.layout();

        assertEquals(960, left.getWidth(), 0.0001);
        assertEquals(960, right.getWidth(), 0.0001);
        assertEquals(960, right.getLayoutX(), 0.0001);
    }

    @Test public void fitsLargeCanvasWithoutShrinkingItsLayoutCoordinates() {
        Pane page = new Pane();
        page.setPrefSize(1920, 1080);
        page.setMinSize(1440, 810);
        ScaledView scaled = new ScaledView(page);

        scaled.resize(960, 540);
        scaled.layout();

        Scale transform = (Scale) page.getTransforms().get(0);
        assertEquals(0.5, transform.getX(), 0.0001);
        assertEquals(transform.getX(), transform.getY(), 0.0001);
        assertEquals(1920, page.getWidth(), 0.0001);
        assertEquals(1080, page.getHeight(), 0.0001);
        assertEquals(540, scaled.prefHeight(960), 0.0001);
        assertEquals(0, scaled.minWidth(-1), 0.0001);
    }

    @Test public void tallFormsKeepTheirHeightForScrolling() {
        Pane form = new Pane();
        form.setPrefSize(1144, 1048);
        form.setMinSize(1144, 1048);
        form.setMaxSize(1144, 1048);
        ScaledView scaled = new ScaledView(form);

        assertEquals(Orientation.HORIZONTAL, scaled.getContentBias());
        assertEquals(1048, scaled.prefHeight(1144), 0.0001);
        assertEquals(524, scaled.prefHeight(572), 0.0001);
        assertEquals(1048, scaled.maxHeight(1144), 0.0001);
    }

    @Test public void resizingUpdatesBothAxesByTheSameFactor() {
        Pane page = new Pane();
        page.setPrefSize(900, 650);
        ScaledView scaled = new ScaledView(page);

        scaled.resize(450, 325);
        scaled.layout();
        scaled.resize(1350, 975);
        scaled.layout();

        Scale transform = (Scale) page.getTransforms().get(0);
        assertEquals(1.5, transform.getX(), 0.0001);
        assertEquals(1.5, transform.getY(), 0.0001);
        assertEquals(975, scaled.prefHeight(1350), 0.0001);
    }
}
