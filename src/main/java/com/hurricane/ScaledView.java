package com.hurricane;

import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.scene.transform.Scale;

/** Fits a Scene Builder canvas to the available width without changing its proportions. */
final class ScaledView extends Region {
    private final Parent view;
    private final Scale scale = new Scale(1, 1, 0, 0);
    private final double designWidth;
    private final double designHeight;

    ScaledView(Parent view) {
        this.view = view;
        designWidth = Math.max(1, view.prefWidth(-1));
        designHeight = Math.max(1, view.prefHeight(designWidth));
        view.setManaged(false);
        view.getTransforms().add(scale);
        getChildren().add(new Group(view));
        setMinSize(0, 0);
    }

    @Override public Orientation getContentBias() {
        return Orientation.HORIZONTAL;
    }

    @Override protected double computePrefWidth(double height) {
        return designWidth;
    }

    @Override protected double computePrefHeight(double width) {
        return width < 0 ? designHeight : designHeight * width / designWidth;
    }

    @Override protected double computeMaxHeight(double width) {
        return computePrefHeight(width);
    }

    @Override protected void layoutChildren() {
        double factor = getWidth() / designWidth;
        view.resize(designWidth, designHeight);
        view.relocate(0, 0);
        scale.setX(factor);
        scale.setY(factor);
    }
}
