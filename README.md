# JavaFX

## Todo

- JavaFX
- SpringBoot
- [Flyway](https://flywaydb.org/)
- [Asciidoc](https://asciidoc.org/)
- How to test JavaFX applications?
- Java module system?

### JavaFX tutorials

- [JavaFX 20 and Beyond](https://youtu.be/f8TOo8TL4-k), Kevin Rushforth, Oracle, Java Developer Day, March 2023
- [Learning JavaFX GUI Development](https://www.linkedin.com/learning/learning-javafx-gui-development?u=101685506)
- [JavaFX Grundkurs](https://www.linkedin.com/learning/javafx-grundkurs?u=101685506)
- [The JavaFX Scene – what it is and how to use it effectively](https://edencoding.com/javafx-scene/)
- [Jenkov: JavaFX Tutorial](https://jenkov.com/tutorials/javafx/index.html)

### Features

- multiple platform: Win, maxOS, Linux
- mobile: iOS, Android (Gluon)
- embedded (Gluon)
- CSS styling
- built-in charts
- 2S, 3D
- video, audio
- web view
- JavaFX/Swing interop
- full HW accelerated (Prism Graphics Layer), SW pipline as fallback
- `Assemble` repo
- [OpenJFX](https://openjfx.io)
- integrates JVM-based scripting languages like Groovy, ...

### Release Model

- first delivered in 2011
- 6-month cadence
- same release numbering as OpenJDK
- JavaFX n will run on JDK n-1 or in practice
  - JavaFX 11-19 -> JDK 11 LTS
  - javaFX 20 -21 -> JDK 17 LTS
- JavaFX 17, Sept. 2021
- JavaFX 18, March 2022
- JavaFX 19, Sept. 2022
- JavaFX 20, Mar. 2023
- JavaFX 21, Sept. 2023, runs on JDK 17 or later (JDK 21 recommended)
- [Roadmap](https://gluonhq.com/products/javafx/)

### Building and running

- jlink
  - produces a JDK that includes JavaFX modules
- jpackage
  - creates a distributable application (exe, dmg, rmp, deb, ...)
  - alternative: maven goal

### Architecture

### Containers

Pane

AnchorPane

- simplest container
- absolute controls positioning, x,y coordinates

BorderPane

- TOP, LEFT, CENTER, RIGHT, BOTTOM

FlowPane

- floating (resizing)

GridPane

- cells with coordinates

HBox, VBox

### Properties

- anonymous classes: `StringProperty`, `IntegerProperty`, ...
- implementations: `SimpleStringProperty`, `SimpleIntegerProperty`, ...
- adding event listener to property
- binding properties

### Styles

- [Styling JavaFX applications using CSS](https://www.callicoder.com/javafx-css-tutorial/), Jun 2017
- JavaFX CSS, prefixed with `-fx-`
- `stylesheets="@demo.css"` root container
