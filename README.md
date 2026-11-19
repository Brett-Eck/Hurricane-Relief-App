# Hurricane Relief App

Our **Hurricane Relief App** is designed to help people affected by hurricanes find the resources and support they need.

Users can create relief requests, view available shelters, and receive assistance based on their situation. Volunteers can also view and accept relief requests based on qualifications. The goal of the app is to keep hurricane relief information organized and make it easier for people to get help.

## Development

### Build and run

Use JDK 17 or newer. The included Maven wrapper downloads Maven on its first run, so a separate Maven installation is not required. Run these commands from the repository root (the directory containing `pom.xml`):

```sh
./mvnw clean compile
./mvnw javafx:run
```

The JavaFX application opens the Primary screen. Its button opens the Secondary screen, whose button returns to Primary.

Run the existing model tests with `./mvnw test`. On Windows, use `mvnw.cmd` instead of `./mvnw`.

### Project layout

- `src/main/java/`: application, controllers, models, and location utilities.
- `src/main/resources/`: FXML screens and other application resources.
- `src/test/java/`: model tests.
- `src/test/resources/`: test fixtures.
- `json/`: runtime data; run from the repository root so reads and writes use this directory.
- `target/`: generated Maven output, ignored by Git.

### FXML and styling

The screens in `src/main/resources/com/hurricane/FXMLFiles/` use the shared JavaFX stylesheet
`src/main/resources/com/hurricane/styles.css`. Each FXML declares its stylesheet, so Scene Builder
can show the same styles as the running app.

Keep text, `fx:id`, event handlers, control structure, and layout coordinates in FXML. The shared
stylesheet defines one palette and reusable roles: ordinary buttons are primary actions;
`secondary-button`, `link-button`, and `nav-button` cover the other actions. Use `page-title`,
`heading`, `caption`, and `muted` for text, and `card` or `bg-*` for surfaces and artwork.
The larger Scene Builder layouts use `large-ui` to scale the same text styles. There are no
screen-specific style variants. Change the palette at the top of CSS to update every page.
`map.css` belongs to the WebView's HTML map and uses browser CSS.

Login and signup use responsive grid columns at their normal font size; their forms center in
the available space. Fixed Scene Builder canvases use `ScaledView` to fit the window width,
with vertical scrolling for tall pages. Initial window bounds include the title bar and stay
within the usable screen area. Navigation chooses the appropriate sizing for each view.

In VS Code, reload the Maven project after pulling this directory change. If old source folders still appear, run **Java: Clean Java Language Server Workspace** from the Command Palette. Select **Hurricane Relief App** to launch the GUI. This uses `Launcher` to start JavaFX with the IDE's dependency classpath. The terminal alternative is `./mvnw javafx:run`.

The optional, separate `LocationApp/` project is not part of the root Maven build.

## Requirements

[Requirements Document](docs/Hurricane_Relief_ChadGPT.pdf)

## Code Design

[UML Class Diagram](docs/uml_class_diagram.pdf)

[User Sequence Diagram](docs/uml_sequence-diagram1.pdf)

[Volunteer Sequence Diagram](docs/uml_sequence_diagram2.pdf)

## Project Board

[Project Board](https://github.com/users/Brett-Eck/projects/2/views/2) 

## Prototype

[Prototype](https://www.figma.com/site/9aZHn8PBG2RD942gWfUsoX/Hurricane-Relief?node-id=0-1&p=f&t=WGsmUa2f1KJLT7hM-0) //will do once we get one

## Our Team

| Team Members | Role |
| --- | --- |
| Brett Eckstrom | Team Member |
| Ethan Evans | Team Member |
| Dominic Gonzalez | Team Member |
| Jonny Shank | Team Member |
| Noah Yesh | Team Member |
